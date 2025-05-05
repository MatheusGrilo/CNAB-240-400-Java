package br.dev.grilo.service.cnab400.itau;

import br.dev.grilo.model.cnab400.itau.leitura.Detalhe;
import br.dev.grilo.model.cnab400.itau.leitura.Header;
import br.dev.grilo.model.cnab400.itau.leitura.Trailer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LeituraService {

    public void processarArquivoCnab400(Path arquivoPath) throws IOException {
        List<String> linhas = Files.readAllLines(arquivoPath);

        if (linhas.isEmpty()) {
            throw new IllegalArgumentException("Arquivo vazio");
        }

        validarEstruturaArquivo(linhas);

        for (String linha : linhas) {
            processarLinha(linha);
        }

    }

    public void validarEstruturaArquivo(List<String> linhas) {
        boolean tamanhoInvalido = linhas.stream()
                .anyMatch(linha -> linha.length() != 400);

        if (tamanhoInvalido) {
            throw new IllegalArgumentException("Arquivo contém linhas com tamanho diferente de 400 caracteres.");
        }


        String header = linhas.get(0);
        if (!"0".equals(Header.TIPO_DE_REGISTRO.extrair(header))) {
            throw new IllegalArgumentException("Primeira linha não é um header iniciado com 0");
        }


        String trailer = linhas.get(linhas.size() - 1);
        if (!"9".equals(Trailer.TIPO_DE_REGISTRO.extrair(trailer))) {
            throw new IllegalArgumentException("Última linha não é um trailer iniciado com 9");
        }
    }

    public void processarLinha(String linha) {
        String tipoRegistro = linha.substring(0, 1);

        switch (tipoRegistro) {
            case "0":
                processarHeader(linha);
                break;
            case "1":
                processarDetalhe(linha);
                break;
            case "9":
                processarTrailer(linha);
                break;
            default:
                throw new IllegalArgumentException("Tipo de registro desconhecido: " + tipoRegistro);
        }
    }

    public void processarHeader(String linha) {
        String codigoBanco = Header.CODIGO_DO_BANCO.extrair(linha);
        if (!"341".equals(codigoBanco)) {
            throw new IllegalArgumentException("Código do banco inválido no header. Esperado: 341, Encontrado: " + codigoBanco);
        }
    }

    private void processarDetalhe(String linha) {
        String codigoBanco = Detalhe.CODIGO_DO_BANCO.extrair(linha);
        if (!"341".equals(codigoBanco)) {
            throw new IllegalArgumentException("Código do banco inválido no detalhe");
        }

    }

    private void processarTrailer(String linha) {
        String sequencial = Trailer.NUMERO_SEQUENCIAL.extrair(linha);
        if(sequencial.length() != 6) {
            throw new IllegalArgumentException("Número sequencial inválido no trailer. Esperado: 6 dígitos, Encontrado: " + sequencial.length());
        }
    }


}
