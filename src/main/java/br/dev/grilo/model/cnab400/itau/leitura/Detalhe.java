package br.dev.grilo.model.cnab400.itau.leitura;

/**
 * Cobrança CNAB 400 - Itaú
 * https://download.itau.com.br/bankline/layout_cobranca_400bytes_cnab_itau.pdf
 * Pag. 8
 */
public enum Detalhe {

    TIPO_DE_REGISTRO("IDENTIFICAÇÃO DO REGISTRO TRANSAÇÃO", 1, 1), // 1
    CODIGO_DE_INSCRICAO("TIPO DE INSCRIÇÃO DA EMPRESA", 2, 3), // Nota 1
    NUMERO_DE_INSCRICAO("Nº DE INSCRIÇÃO DA EMPRESA (CPF/CNPJ)", 4, 17), // Nota 1
    AGENCIA("AGÊNCIA MANTENEDORA DA CONTA", 18, 21),
    ZEROS("COMPLEMENTO DE REGISTRO", 22, 23), // "00"
    CONTA("NÚMERO DA CONTA CORRENTE DA EMPRESA", 24, 28),
    DAC("DÍGITO DE AUTO CONFERÊNCIA AG/CONTA EMPRESA", 29, 29),
    BRANCOS_1("COMPLEMENTO DE REGISTRO", 30, 33),
    INSTRUCAO_ALEGACAO("CÓD.INSTRUÇÃO/ALEGAÇÃO A SER CANCELADA", 34, 37), // NOTA 27
    USO_DA_EMPRESA("IDENTIFICAÇÃO DO TÍTULO NA EMPRESA", 38, 62), // NOTA 2
    NOSSO_NUMERO("IDENTIFICAÇÃO DO TÍTULO NO BANCO", 63, 70), // NOTA 3
    QTDE_DE_MOEDA("QUANTIDADE DE MOEDA VARIÁVEL", 71, 83), // NOTA 4
    NUM_DA_CARTEIRA("NÚMERO DA CARTEIRA NO BANCO", 84, 86), // NOTA 5
    USO_DO_BANCO("IDENTIFICAÇÃO DA OPERAÇÃO NO BANCO", 87, 107),
    CARTEIRA("CÓDIGO DA CARTEIRA", 108, 108), // NOTA 5
    COD_DE_OCORRENCIA("IDENTIFICAÇÃO DA OCORRÊNCIA", 109, 110), // NOTA 6
    NUM_DO_DOCUMENTO("Nº DO DOCUMENTO DE COBRANÇA (DUPL.,NP ETC.)", 111, 120), // NOTA 18
    VENCIMENTO("DATA DE VENCIMENTO DO TÍTULO", 121, 126), // NOTA 7
    VALOR_DO_TITULO("VALOR NOMINAL DO TÍTULO", 127, 139), // NOTA 8
    CODIGO_DO_BANCO("Nº DO BANCO NA CÂMARA DE COMPENSAÇÃO", 140, 142), // 341
    AGENCIA_COBRADORA("AGÊNCIA ONDE O TÍTULO SERÁ COBRADO", 143, 147), // NOTA 9
    ESPECIE("ESPÉCIE DO TÍTULO", 148, 149), // NOTA 10
    ACEITE("IDENTIFICAÇÃO DE TÍTULO ACEITO OU NÃO ACEITO", 150, 150), // A = ACEITE, N = NÃO ACEITE
    DATA_DE_EMISSAO("DATA DA EMISSÃO DO TÍTULO", 151, 156), // NOTA 31
    INSTRUCAO_1("1ª INSTRUÇÃO DE COBRANÇA", 157, 158), // NOTA 11
    INSTRUCAO_2("2ª INSTRUÇÃO DE COBRANÇA", 159, 160), // NOTA 11
    JUROS_DE_1_DIA("VALOR DE MORA POR DIA DE ATRASO", 161, 173), // NOTA 12
    DESCONTO_ATE("DATA LIMITE PARA CONCESSÃO DE DESCONTO", 174, 179), // DDMMAA
    VALOR_DO_DESCONTO("VALOR DO DESCONTO A SER CONCEDIDO", 180, 192), // NOTA 13
    VALOR_DO_IOF("VALOR DO I.O.F. RECOLHIDO P/ NOTAS SEGURO", 193, 205), // NOTA 14
    ABATIMENTO("VALOR DO ABATIMENTO A SER CONCEDIDO", 206, 218), // NOTA 13
    CODIGO_DE_INSCRICAO_2("IDENTIFICAÇÃO DO TIPO DE INSCRIÇÃO/PAGADOR", 219, 220), // 01 = CPF, 02 = CNPJ
    NUMERO_DE_INSCRICAO_2("Nº DE INSCRIÇÃO DO PAGADOR (CPF/CNPJ)", 221, 234),
    NOME_DO_PAGADOR("NOME DO PAGADOR", 235, 264), // NOTA 15
    BRANCOS_2("COMPLEMENTO DE REGISTRO", 265, 274), // NOTA 15
    LOGRADOURO("RUA, NÚMERO E COMPLEMENTO DO PAGADOR", 275, 314),
    BAIRRO("BAIRRO DO PAGADOR", 315, 326),
    CEP("CEP DO PAGADOR", 327, 334),
    CIDADE("CIDADE DO PAGADOR", 335, 349),
    ESTADO("UF DO PAGADOR", 350, 351),
    SACADOR_AVALISTA("NOME DO SACADOR OU AVALISTA", 352, 381), // NOTA 16
    BRANCOS_3("COMPLEMENTO DE REGISTRO", 382, 385),
    DATA_DE_MORA("DATA DE MORA", 386, 391), // DDMMAA
    PRAZO("QUANTIDADE DE DIAS", 392, 393), // NOTA 11 (A)
    BRANCOS_4("COMPLEMENTO DE REGISTRO", 394, 394),
    NUMERO_SEQUENCIAL("Nº SEQÜENCIAL DO REGISTRO NO ARQUIVO", 395, 400);


    private final String nome;
    private final int inicio;
    private final int fim;

    Detalhe(String nome, int inicio, int fim) {
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
