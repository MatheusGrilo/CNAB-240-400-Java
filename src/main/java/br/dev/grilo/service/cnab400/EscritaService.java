package br.dev.grilo.service.cnab400;

import br.dev.grilo.model.cnab400.bradesco.leitura.HeaderLeitura;
import br.dev.grilo.model.cnab400.bradesco.leitura.TrailerLeitura;
import br.dev.grilo.model.cnab400.bradesco.leitura.TransacaoLeitura;
import br.dev.grilo.utils.StringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EscritaService {
    public void gerarArquivoRetorno(String caminhoArquivoOrigem,
                                    HeaderLeitura header,
                                    List<TransacaoLeitura> transacoes,
                                    TrailerLeitura trailer) throws IOException {
        // Gera a data de hoje
        String dataGeracao = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyy"));

        // Calcula o aviso bancário
        int numeroSequencialRemessa = Integer.parseInt(header.getNumeroSequencialDaRemessa());
        String avisoBancario = String.format("%05d", numeroSequencialRemessa + 100);

        // Extrai nome do arquivo para montar o retorno
        String[] partesCaminho = caminhoArquivoOrigem.split("/");
        String nomeArquivoOriginal = partesCaminho[partesCaminho.length - 1];
        String nomeArquivoSemExtensao = nomeArquivoOriginal.substring(0, nomeArquivoOriginal.lastIndexOf('.'));
        String caminhoArquivoRetorno = caminhoArquivoOrigem.substring(0, caminhoArquivoOrigem.lastIndexOf('/') + 1)
                + "retorno_" + nomeArquivoSemExtensao + ".RET";
        System.out.println("Arquivo de retorno: " + caminhoArquivoRetorno);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoRetorno))) {
            // Variáveis para Trailer
            int quantidadeTotalTitulos = 0;
            long valorTotalTitulos = 0L;

            long valorTotalRegistros06 = 0L;

            int quantidadeRegistros02 = 0;
            int quantidadeRegistros06 = 0;
            int quantidadeRegistros09e10 = 0;
            int quantidadeRegistros12 = 0;
            int quantidadeRegistros13 = 0;
            int quantidadeRegistros14 = 0;
            int quantidadeRegistros19 = 0;


            // HEADER
            String headerRetorno = gerarLinhaHeader(header, avisoBancario, dataGeracao);
            validarEEscreverLinha(writer, headerRetorno, "Header");

            // TRANSACOES
            int numeroSequencial = 2;
            int sucesso = 0;
            int erro = 0;

            for (TransacaoLeitura transacao : transacoes) {
                String linhaTransacao = gerarLinhaTransacao(transacao, header, dataGeracao, numeroSequencial);

                if (linhaTransacao.length() == 400) {
                    writer.write(linhaTransacao + "\n");
                    sucesso++;
                } else {
                    System.out.println("Transação não contém 400 caracteres: " + linhaTransacao.length());
                    erro++;
                }

                // Atualizando valores para Trailer
                quantidadeTotalTitulos++;
                valorTotalTitulos += Long.parseLong(transacao.getValorDoTitulo());

                // Contagem de ocorrências - Exemplo simplificado
                if (transacao.getIdentificacaoDaOcorrencia().equals("06")) {
                    valorTotalRegistros06 += Long.parseLong(transacao.getValorDoTitulo());
                    quantidadeRegistros06++;
                }
                // Adicione outros códigos conforme seu fluxo

                numeroSequencial++;
            }


            // TRAILER
            String trailerRetorno = gerarLinhaTrailer(header, quantidadeTotalTitulos,
                    valorTotalTitulos, avisoBancario,
                    quantidadeRegistros02, quantidadeRegistros06,
                    quantidadeRegistros09e10, quantidadeRegistros12,
                    quantidadeRegistros13, quantidadeRegistros14,
                    quantidadeRegistros19);
            validarEEscreverLinha(writer, trailerRetorno, "Trailer");
        }

    }

    private String gerarLinhaHeader(HeaderLeitura header, String avisoBancario, String dataGeracao) {
        return "0" +
                "2" +
                "RETORNO" +
                "01" +
                StringUtils.padRight("COBRANCA", 15) +
                StringUtils.padRight(header.getCodigoDaEmpresa(), 20) +
                StringUtils.padRight(header.getNomeDaEmpresa(), 30) +
                StringUtils.padRight(header.getNumeroDoBancoNaCamaraDeCompensacao(), 3) +
                StringUtils.padRight(header.getNomeDoBancoPorExtenso(), 15) +
                StringUtils.padRight(header.getDataDaGravacaoDoArquivo(), 6) +
                "01600000" +    // Não sei de onde vem, apenas copiei dos exemplos que tive
                StringUtils.padLeft(avisoBancario, 5) +
                StringUtils.padRight("", 266) +
                StringUtils.padRight(dataGeracao, 6) +
                StringUtils.padRight("", 9) +
                "000001";   // Mesmo caso do comentário anterior
    }

    private String gerarLinhaTransacao(TransacaoLeitura transacao, HeaderLeitura header, String dataOcorrencia, int sequencial) {
        return "1" +
                transacao.getIdentificacaoDoTipoDeInscricaoDoPagador() +
                transacao.getNumInscricaoDoPagador() +
                "000" +
                transacao.getIdentificacaoDaEmpresaBeneficiariaNoBanco() +
                transacao.getNumControleDoParticipante() +
                "00000000" +
                transacao.getIdentificacaoDoTituloNoBanco() +
                " " +
                "0000000000" +
                "000000000000" +
                "0" +
                "00" +
                "9" +
                transacao.getIdentificacaoDaOcorrencia() +
                dataOcorrencia +
                transacao.getNumDoDocumento() +
                StringUtils.padLeft(transacao.getIdentificacaoDoTituloNoBanco(), 20) +
                transacao.getDataDoVencimentoDoTitulo() +
                StringUtils.padLeft(transacao.getValorDoTitulo(), 13) +
                header.getNumeroDoBancoNaCamaraDeCompensacao() +
                transacao.getAgenciaDepositaria() +
                StringUtils.padRight("", 2) +
                StringUtils.repetir("0", 13) +
                StringUtils.repetir("0", 13) +
                StringUtils.repetir("0", 13) +
                StringUtils.repetir("0", 13) +
                StringUtils.repetir("0", 13) +
                StringUtils.repetir("0", 13) +
                StringUtils.padLeft(transacao.getValorDoTitulo(), 13) +
                StringUtils.repetir("0", 13) +
                StringUtils.repetir("0", 13) +
                StringUtils.repetir(" ", 2) +
                " " +
                StringUtils.repetir(" ", 6) +
                StringUtils.repetir(" ", 3) +
                StringUtils.repetir(" ", 10) +
                StringUtils.repetir(" ", 4) +
                StringUtils.repetir("0", 10) +
                StringUtils.repetir(" ", 40) +
                StringUtils.repetir(" ", 2) +
                StringUtils.repetir(" ", 10) +
                StringUtils.repetir(" ", 14) +
                StringUtils.padLeft(String.valueOf(sequencial), 6);
    }

    private String gerarLinhaTrailer(HeaderLeitura header, int quantidadeTitulos, long valorTotal, String avisoBancario,
                                     int registros02, int registros06, int registros09e10, int registros12,
                                     int registros13, int registros14, int registros19) {

        System.out.println(avisoBancario);
        int avisoBancarioInt = Integer.parseInt(avisoBancario) - 100;
        String avisoBancarioOut = avisoBancarioInt + "";
        return "9" +
                "2" +
                "01" +
                header.getNumeroDoBancoNaCamaraDeCompensacao() +
                StringUtils.repetir(" ", 10) +
                StringUtils.padLeft(String.valueOf(quantidadeTitulos), 8) +
                StringUtils.padLeft(String.valueOf(valorTotal), 14) +
                StringUtils.padLeft(avisoBancario, 8) +
                StringUtils.repetir(" ", 10) +
                StringUtils.padLeft(String.valueOf(registros02), 5) +
                StringUtils.repetir("0", 12) +
                StringUtils.repetir("0", 12) +
                StringUtils.padLeft(String.valueOf(registros06), 5) +
                StringUtils.repetir("0", 12) +
                StringUtils.padLeft(String.valueOf(registros09e10), 5) +
                StringUtils.repetir("0", 12) +
                StringUtils.padLeft(String.valueOf(registros13), 5) +
                StringUtils.repetir("0", 12) +
                StringUtils.padLeft(String.valueOf(registros14), 5) +
                StringUtils.repetir("0", 12) +
                StringUtils.padLeft(String.valueOf(registros12), 5) +
                StringUtils.repetir("0", 12) +
                StringUtils.padLeft(String.valueOf(registros19), 5) +
                StringUtils.repetir("0", 12) +
                StringUtils.repetir(" ", 174) +
                StringUtils.repetir("0", 15) +
                StringUtils.repetir("0", 8) +
                StringUtils.repetir(" ", 9) +
                StringUtils.padLeft(avisoBancarioOut, 6);
    }

    private void validarEEscreverLinha(BufferedWriter writer, String linha, String descricao) throws IOException {
        if (linha.length() == 400) {
            writer.write(linha + "\n");
            System.out.println(descricao + " escrito");
        } else {
            System.out.println(descricao + " não contém 400 caracteres, contém " + linha.length());
        }
    }
}
