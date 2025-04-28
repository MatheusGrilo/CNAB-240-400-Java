package br.dev.grilo.service.cnab400;

import br.dev.grilo.model.cnab400.bradesco.leitura.HeaderLeitura;
import br.dev.grilo.model.cnab400.bradesco.leitura.TrailerLeitura;
import br.dev.grilo.model.cnab400.bradesco.leitura.TransacaoLeitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável por ler arquivos CNAB 400 de remessa.
 */
public class LeituraService {


    /**
     * Lê um arquivo CNAB 400 e retorna os objetos Header, Transações e Trailer.
     *
     * @param caminhoArquivo Caminho do arquivo CNAB 400 (.REM)
     * @return Resultado contendo Header, lista de Transações e Trailer
     * @throws IOException Se ocorrer erro na leitura do arquivo
     */
    public ResultadoLido lerArquivo(String caminhoArquivo) throws IOException {
        HeaderLeitura header = null;
        List<TransacaoLeitura> transacoes = new ArrayList<>();
        TrailerLeitura trailer = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int contador = 0;
            while ((linha = reader.readLine()) != null) {
                contador++;

                if (contador == 1) {
                    header = parseHeader(linha);
                } else if (linha.startsWith("9")) {
                    trailer = parseTrailer(linha);
                } else {
                    transacoes.add(parseTransacao(linha));
                }
            }
        }

        return new ResultadoLido(header, transacoes, trailer);
    }

    private HeaderLeitura parseHeader(String linha) {
        HeaderLeitura header = new HeaderLeitura();
        header.setIdentificacaoDoRegistro(linha.substring(0, 1));
        header.setIdentificacaoDoArquivoDeRemessa(linha.substring(1, 2));
        header.setLiteralRemessa(linha.substring(2, 9));
        header.setCodigoDeServico(linha.substring(9, 11));
        header.setLiteralServico(linha.substring(11, 26));
        header.setCodigoDaEmpresa(linha.substring(26, 46));
        header.setNomeDaEmpresa(linha.substring(46, 76));
        header.setNumeroDoBancoNaCamaraDeCompensacao(linha.substring(76, 79));
        header.setNomeDoBancoPorExtenso(linha.substring(79, 94));
        header.setDataDaGravacaoDoArquivo(linha.substring(94, 100));
        header.setBrancos1(linha.substring(100, 108));
        header.setIdentificacaoDoSistema(linha.substring(108, 110));
        header.setNumeroSequencialDaRemessa(linha.substring(110, 117));
        header.setBrancos2(linha.substring(117, 394));
        header.setNumeroSequencialDoRegistroDeUmEmUm(linha.substring(394, 400));
        return header;
    }

    private TransacaoLeitura parseTransacao(String linha) {
        TransacaoLeitura transacao = new TransacaoLeitura();
        transacao.setIdentificacaoDoRegistro(linha.substring(0, 1));
        transacao.setAgenciaDeDebito(linha.substring(1, 6));
        transacao.setDigitoDaAgenciaDeDebito(linha.substring(6, 7));
        transacao.setRazaoDaContaCorrente(linha.substring(7, 12));
        transacao.setContaCorrente(linha.substring(12, 19));
        transacao.setDigitoDaContaCorrente(linha.substring(19, 20));
        transacao.setIdentificacaoDaEmpresaBeneficiariaNoBanco(linha.substring(20, 37));
        transacao.setNumControleDoParticipante(linha.substring(37, 62));
        transacao.setCodDoBancoASerDebitado(linha.substring(62, 65));
        transacao.setCampoDeMulta(linha.substring(65, 66));
        transacao.setPercentualDeMulta(linha.substring(66, 70));
        transacao.setIdentificacaoDoTituloNoBanco(linha.substring(70, 81));
        transacao.setDigitoDeAutoconferenciaDoNumBancario(linha.substring(81, 82));
        transacao.setDescontoBonificacaoPorDia(linha.substring(82, 92));
        transacao.setCondicaoParaEmissaoDaPapeletaDeCobranca(linha.substring(92, 93));
        transacao.setIdentSeEmiteBoletoParaDebitoAutomatico(linha.substring(93, 94));
        transacao.setIdentificacaoDaOperacaoDoBanco(linha.substring(94, 104));
        transacao.setIndicadorRateioCredito(linha.substring(104, 105));
        transacao.setEnderecamentoParaAvisoDebitoAutomatico(linha.substring(105, 106));
        transacao.setQuantidadeDePagamentos(linha.substring(106, 108));
        transacao.setIdentificacaoDaOcorrencia(linha.substring(108, 110));
        transacao.setNumDoDocumento(linha.substring(110, 120));
        transacao.setDataDoVencimentoDoTitulo(linha.substring(120, 126));
        transacao.setValorDoTitulo(linha.substring(126, 139));
        transacao.setBancoEncarregadoDaCobranca(linha.substring(139, 142));
        transacao.setAgenciaDepositaria(linha.substring(142, 147));
        transacao.setEspecieDeTitulo(linha.substring(147, 149));
        transacao.setIdentificacao(linha.substring(149, 150));
        transacao.setDataDaEmissaoDoTitulo(linha.substring(150, 156));
        transacao.setPrimeiraInstrucao(linha.substring(156, 158));
        transacao.setSegundaInstrucao(linha.substring(158, 160));
        transacao.setValorASerCobradoPorDiaDeAtraso(linha.substring(160, 173));
        transacao.setDataLimiteParaConcessaoDeDesconto(linha.substring(173, 179));
        transacao.setValorDoDesconto(linha.substring(179, 192));
        transacao.setValorDoIof(linha.substring(192, 205));
        transacao.setValorDoAbatimentoASerConcedidoOuCancelado(linha.substring(205, 218));
        transacao.setIdentificacaoDoTipoDeInscricaoDoPagador(linha.substring(218, 220));
        transacao.setNumInscricaoDoPagador(linha.substring(220, 234));
        transacao.setNomeDoPagador(linha.substring(234, 274));
        transacao.setEnderecoDoPagador(linha.substring(274, 314));
        transacao.setPrimeiraMensagem(linha.substring(314, 326));
        transacao.setCep(linha.substring(326, 331));
        transacao.setSufixoDoCep(linha.substring(331, 334));
        transacao.setBeneficiarioFinalOuSegundaMensagem(linha.substring(334, 394));
        transacao.setNumSequencialDoRegistro(linha.substring(394, 400));
        return transacao;
    }

    private TrailerLeitura parseTrailer(String linha) {
        TrailerLeitura trailer = new TrailerLeitura();
        trailer.setIdentificacaoDoRegistro(linha.substring(0, 1));
        trailer.setBranco(linha.substring(1, 394));
        trailer.setNumeroSequencialDeRegistro(linha.substring(394, 400));
        return trailer;
    }


    /**
     * Resultado da leitura de um arquivo CNAB 400.
     */
    public static class ResultadoLido {
        private final HeaderLeitura header;
        private final List<TransacaoLeitura> transacoes;
        private final TrailerLeitura trailer;

        public ResultadoLido(HeaderLeitura header, List<TransacaoLeitura> transacoes, TrailerLeitura trailer) {
            this.header = header;
            this.transacoes = transacoes;
            this.trailer = trailer;
        }

        public HeaderLeitura getHeader() {
            return header;
        }

        public List<TransacaoLeitura> getTransacoes() {
            return transacoes;
        }

        public TrailerLeitura getTrailer() {
            return trailer;
        }
    }
}
