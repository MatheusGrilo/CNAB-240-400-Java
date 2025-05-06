package br.dev.grilo.model.cnab400.itau.leitura;

/**
 * Cobrança CNAB 400 - Itaú
 * https://download.itau.com.br/bankline/layout_cobranca_400bytes_cnab_itau.pdf
 * Pag. 7
 */
public enum Header {

    TIPO_DE_REGISTRO("IDENTIFICAÇÃO DO REGISTRO HEADER", 1, 1), // 0
    OPERACAO("TIPO DE OPERAÇÃO - REMESSA", 2, 2), // 1
    LITERAL_DE_REMESSA("IDENTIFICAÇÃO POR EXTENSO DO MOVIMENTO", 3, 9), // REMESSA
    CODIGO_DO_SERVICO("IDENTIFICAÇÃO DO TIPO DE SERVIÇO", 10, 11), // 01
    LITERAL_DO_SERVICO("IDENTIFICAÇÃO POR EXTENSO DO TIPO DE SERVIÇO", 12, 26), // COBRANCA
    AGENCIA("AGÊNCIA MANTENEDORA DA CONTA", 27, 30),
    ZEROS("COMPLEMENTO DE REGISTRO", 31, 32), // 00
    CONTA("NÚMERO DA CONTA CORRENTE DA EMPRESA", 33, 37),
    DAC("DÍGITO DE AUTO CONFERÊNCIA AG/CONTA EMPRESA", 38, 38),
    BRANCOS_01("COMPLEMENTO DO REGISTRO", 39, 46),
    NOME_DA_EMPRESA("NOME POR EXTENSO DA \"EMPRESA MÃE\"", 47, 76),
    CODIGO_DO_BANCO("Nº DO BANCO NA CÂMARA DE COMPENSAÇÃO", 77, 79), // 341
    NOME_DO_BANCO("NOME POR EXTENSO DO BANCO COBRADOR", 80, 94), // BANCO ITAU SA
    DATA_DE_GERACAO("DATA DE GERAÇÃO DO ARQUIVO", 95, 100), // DDMMAA
    BRANCOS_02("COMPLEMENTO DO REGISTRO", 101, 394),
    NUMERO_SEQUENCIAL("NÚMERO SEQÜENCIAL DO REGISTRO NO ARQUIVO", 395, 400); // 000001


    private final String nome;
    private final int inicio;
    private final int fim;

    Header(String nome, int inicio, int fim) {
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

    public static boolean validate(String linha) {
        if (linha.length() != 400) return false;
        if (!"0".equals(TIPO_DE_REGISTRO.extrair(linha))) return false;
        if(!"1".equals(OPERACAO.extrair(linha))) return false;
        if(!"REMESSA".equals(LITERAL_DE_REMESSA.extrair(linha))) return false;
        if(!"01".equals(CODIGO_DO_SERVICO.extrair(linha))) return false;
        if(!"COBRANCA       ".equals(LITERAL_DO_SERVICO.extrair(linha))) return false;
        if(!"00".equals(ZEROS.extrair(linha))) return false;
        if(!" ".repeat(8).equals(BRANCOS_01.extrair(linha))) return false;
        if(30 != NOME_DA_EMPRESA.extrair(linha).length()) return false;
        if (!"341".equals(CODIGO_DO_BANCO.extrair(linha))) return false;
        if(!"BANCO ITAU SA  ".equals(NOME_DO_BANCO.extrair(linha))) return false;
        if(!" ".repeat(294).equals(BRANCOS_02.extrair(linha))) return false;

        return true;
    }
}
