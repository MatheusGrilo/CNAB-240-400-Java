package br.dev.grilo;

import br.dev.grilo.service.cnab400.itau.LeituraService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        LeituraService leituraService = new LeituraService();
        Path caminhoArquivo = Paths.get("src/main/resources/mock/ITAU/2505051.TXT");

        try {
            leituraService.processarArquivoCnab400(caminhoArquivo);
            System.out.println("Arquivo processado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Arquivo inválido: " + e.getMessage());
        }


    }
}