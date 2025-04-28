package br.dev.grilo;

import br.dev.grilo.service.cnab400.LeituraService;

public class Main {
    public static void main(String[] args) {
        LeituraService leituraService = new LeituraService();
        String caminhoArquivo = "src/main/resources/mock/2504242.TXT"; // Substitua pelo caminho do seu arquivo
        try {
            leituraService.lerArquivo(caminhoArquivo);
            System.out.println("Arquivo lido com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }


    }
}