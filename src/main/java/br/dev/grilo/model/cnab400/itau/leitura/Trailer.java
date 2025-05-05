package br.dev.grilo.model.cnab400.itau.leitura;

/**
 * Cobrança CNAB 400 - Itaú
 * https://download.itau.com.br/bankline/layout_cobranca_400bytes_cnab_itau.pdf
 * Pag. 12
 */
public enum Trailer {

    TIPO_DE_REGISTRO("IDENTIFICAÇÃO DO REGISTRO TRAILER", 1, 1), // 9
    BRANCOS("COMPLEMENTO DO REGISTRO", 2, 394),
    NUMERO_SEQUENCIAL("NÚMERO SEQÜENCIAL DO REGISTRO NO ARQUIVO", 395, 400);


    private final String nome;
    private final int inicio;
    private final int fim;

    Trailer(String nome, int inicio, int fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String extrair(String linha) {
        return linha.substring(inicio - 1, fim);
    }

    public String getNome() {
        return nome;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }
}
