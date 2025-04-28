package br.dev.grilo.model.cnab400.bradesco.leitura;

/**
 * Documentação do Trailer CNAB 400 do Bradesco em 28/04/2025:
 * Nº 4008.524.0121 - Versão 17
 * https://banco.bradesco/assets/pessoajuridica/pdf/4008-524-0121-layout-cobranca-versao-portugues.pdf
 * Todos serão armazenados como String, pois normalmente existem casas decimais à esquerda
 * O tamanho total do trailer é de 400 campos
 */
public class TrailerLeitura {
    /**
     * Identificação do Registro
     * 1 campo
     * Numérico
     * Padrão: 9
     */
    private String identificacaoDoRegistro;

    /**
     * Campo em branco
     * 393 campos
     * Alfabético
     */
    private String branco;

    /**
     * Número sequencial de Registro
     * 6 campos
     * Numérico
     * Número sequencial do Último Registro
     */
    private String numeroSequencialDeRegistro;

    public String getIdentificacaoDoRegistro() {
        return identificacaoDoRegistro;
    }

    public void setIdentificacaoDoRegistro(String identificacaoDoRegistro) {
        this.identificacaoDoRegistro = identificacaoDoRegistro;
    }

    public String getBranco() {
        return branco;
    }

    public void setBranco(String branco) {
        this.branco = branco;
    }

    public String getNumeroSequencialDeRegistro() {
        return numeroSequencialDeRegistro;
    }

    public void setNumeroSequencialDeRegistro(String numeroSequencialDeRegistro) {
        this.numeroSequencialDeRegistro = numeroSequencialDeRegistro;
    }
}
