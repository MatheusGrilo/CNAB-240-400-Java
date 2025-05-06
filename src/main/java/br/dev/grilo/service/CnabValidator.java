package br.dev.grilo.service;

import br.dev.grilo.model.cnab400.itau.leitura.Header;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CnabValidator {

    public List<String> validateItauCnab400(Path filePath) throws IOException {
        List<String> linhas = Files.readAllLines(filePath);
        List<String> erros = new ArrayList<String>(); // Lista de erros explicitamente tipada

        if (linhas.size() == 0) { // Substituindo isEmpty() por size() == 0
            erros.add("Arquivo vazio");
            return erros;
        }

        // Valida tamanho das linhas
        for (String linha : linhas) {
            if (linha.length() != 400) {
                erros.add("Linha com tamanho incorreto. Esperado: 400, Encontrado: " + linha.length());
            }
        }

        // Valida header usando SEU método validate()
        if (!Header.validate(linhas.get(0))) {
            erros.add("Header inválido para Itaú CNAB 400");
        }

        return erros;
    }
}