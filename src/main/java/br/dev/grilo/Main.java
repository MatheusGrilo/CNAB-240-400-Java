package br.dev.grilo;

import br.dev.grilo.model.cnab400.bradesco.leitura.HeaderLeitura;
import br.dev.grilo.model.cnab400.bradesco.leitura.TrailerLeitura;
import br.dev.grilo.model.cnab400.bradesco.leitura.TransacaoLeitura;
import br.dev.grilo.service.cnab400.LeituraService;
import br.dev.grilo.utils.StringUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LeituraService leituraService = new LeituraService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo CNAB 400:");
        String caminhoArquivo = scanner.nextLine();
        //  src/main/resources/mock/2504242.TXT
        //  src/main/resources/mock/2504282.TXT
        //  src/main/resources/mock/2504283.TXT

        try {
            LeituraService.ResultadoLido resultado = leituraService.lerArquivo(caminhoArquivo);
            System.out.println("Arquivo lido com sucesso!");

            HeaderLeitura header = resultado.getHeader();
            TrailerLeitura trailer = resultado.getTrailer();
            List<TransacaoLeitura> transacoes = resultado.getTransacoes();

            System.out.println("\n--- HEADER ---");
            System.out.println("Empresa: " + header.getNomeDaEmpresa());
            System.out.println("Banco: " + header.getNomeDoBancoPorExtenso());

            System.out.println("\n--- TRANSACOES ---");
            for (TransacaoLeitura transacao : transacoes) {
                System.out.println("Pagador: " + transacao.getNomeDoPagador().trim() +
                        " | Valor: " + StringUtils.stringParaDouble(transacao.getValorDoTitulo()));
            }

            System.out.println("\n--- TRAILER ---");
            System.out.println("Sequencial: " + trailer.getNumeroSequencialDeRegistro());

        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }


    }
}