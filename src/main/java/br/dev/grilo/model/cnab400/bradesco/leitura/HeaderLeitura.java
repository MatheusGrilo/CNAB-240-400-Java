package br.dev.grilo.model.cnab400.bradesco.leitura;

/**
 * Documentação do Header CNAB 400 do Bradesco em 28/04/2025:
 * Nº 4008.524.0121 - Versão 17
 * https://banco.bradesco/assets/pessoajuridica/pdf/4008-524-0121-layout-cobranca-versao-portugues.pdf
 * Todos serão armazenados como String, pois normalmente existem casas decimais à esquerda
 * O tamanho total do cabeçalho é de 400 campos
 */
public class HeaderLeitura {

    /**
     * Identificação do Registro
     * 1 campo
     * Numérico
     * Padrão: 0
     */
    private String identificacaoDoRegistro;

    /**
     * Identificação do Arquivo de Remessa
     * 1 campo
     * Numérico
     * Padrão: 1
     */
    private String identificacaoDoArquivoDeRemessa;

    /**
     * Literal Remessa
     * 7 campos
     * Alfabético
     * Padrão: "REMESSA"
     */
    private String literalRemessa;

    /**
     * Código de Serviço
     * 2 campos
     * Numérico
     * Padrão: 01
     */
    private String codigoDeServico;

    /**
     * Literal Serviço
     * 15 campos
     * Alfabético
     * Padrão: "COBRANCA"
     */
    private String literalServico;

    /**
     * Código da Empresa
     * 20 campos
     * Numérico
     * Padrão: Código fornecido pelo banco (ex: 0000000000)
     */
    private String codigoDaEmpresa;

    /**
     * Nome da Empresa
     * 30 campos
     * Alfabético
     * Padrão: Nome da empresa
     */
    private String nomeDaEmpresa;

    /**
     * Número do Banco na Câmara de Compensação
     * 3 campos
     * Numérico
     * Padrão: 237 (Bradesco)
     */
    private String numeroDoBancoNaCamaraDeCompensacao;

    /**
     * Nome do Banco por Extenso
     * 15 campos
     * Alfabético
     * Padrão: "BRADESCO"
     */
    private String nomeDoBancoPorExtenso;

    /**
     * Data da Gravação do Arquivo
     * 6 campos
     * Numérico
     * Padrão: Data no formato DDMMAA
     */
    private String dataDaGravacaoDoArquivo;

    /**
     * Espaços em Branco 1
     * 8 campos
     * Alfabético
     * Padrão: Espaço em branco
     */
    private String brancos1;

    /**
     * Identificação do Sistema
     * 2 campos
     * Alfabético
     * Padrão: "MX" (Bradesco)
     */
    private String identificacaoDoSistema;

    /**
     * Número Sequencial da Remessa
     * 7 campos
     * Numérico
     * Padrão: Sequencial atribuído pela empresa
     */
    private String numeroSequencialDaRemessa;

    /**
     * Espaços em Branco 2
     * 277 campos
     * Alfabético
     * Padrão: Espaço em branco
     */
    private String brancos2;

    /**
     * Número Sequencial do Registro de Um em Um
     * 6 campos
     * Numérico
     * Padrão: 000001
     */
    private String numeroSequencialDoRegistroDeUmEmUm;

    // Getters e Setters

    public String getIdentificacaoDoRegistro() {
        return identificacaoDoRegistro;
    }

    public void setIdentificacaoDoRegistro(String identificacaoDoRegistro) {
        this.identificacaoDoRegistro = identificacaoDoRegistro;
    }

    public String getIdentificacaoDoArquivoDeRemessa() {
        return identificacaoDoArquivoDeRemessa;
    }

    public void setIdentificacaoDoArquivoDeRemessa(String identificacaoDoArquivoDeRemessa) {
        this.identificacaoDoArquivoDeRemessa = identificacaoDoArquivoDeRemessa;
    }

    public String getLiteralRemessa() {
        return literalRemessa;
    }

    public void setLiteralRemessa(String literalRemessa) {
        this.literalRemessa = literalRemessa;
    }

    public String getCodigoDeServico() {
        return codigoDeServico;
    }

    public void setCodigoDeServico(String codigoDeServico) {
        this.codigoDeServico = codigoDeServico;
    }

    public String getLiteralServico() {
        return literalServico;
    }

    public void setLiteralServico(String literalServico) {
        this.literalServico = literalServico;
    }

    public String getCodigoDaEmpresa() {
        return codigoDaEmpresa;
    }

    public void setCodigoDaEmpresa(String codigoDaEmpresa) {
        this.codigoDaEmpresa = codigoDaEmpresa;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getNumeroDoBancoNaCamaraDeCompensacao() {
        return numeroDoBancoNaCamaraDeCompensacao;
    }

    public void setNumeroDoBancoNaCamaraDeCompensacao(String numeroDoBancoNaCamaraDeCompensacao) {
        this.numeroDoBancoNaCamaraDeCompensacao = numeroDoBancoNaCamaraDeCompensacao;
    }

    public String getNomeDoBancoPorExtenso() {
        return nomeDoBancoPorExtenso;
    }

    public void setNomeDoBancoPorExtenso(String nomeDoBancoPorExtenso) {
        this.nomeDoBancoPorExtenso = nomeDoBancoPorExtenso;
    }

    public String getDataDaGravacaoDoArquivo() {
        return dataDaGravacaoDoArquivo;
    }

    public void setDataDaGravacaoDoArquivo(String dataDaGravacaoDoArquivo) {
        this.dataDaGravacaoDoArquivo = dataDaGravacaoDoArquivo;
    }

    public String getBrancos1() {
        return brancos1;
    }

    public void setBrancos1(String brancos1) {
        this.brancos1 = brancos1;
    }

    public String getIdentificacaoDoSistema() {
        return identificacaoDoSistema;
    }

    public void setIdentificacaoDoSistema(String identificacaoDoSistema) {
        this.identificacaoDoSistema = identificacaoDoSistema;
    }

    public String getNumeroSequencialDaRemessa() {
        return numeroSequencialDaRemessa;
    }

    public void setNumeroSequencialDaRemessa(String numeroSequencialDaRemessa) {
        this.numeroSequencialDaRemessa = numeroSequencialDaRemessa;
    }

    public String getBrancos2() {
        return brancos2;
    }

    public void setBrancos2(String brancos2) {
        this.brancos2 = brancos2;
    }

    public String getNumeroSequencialDoRegistroDeUmEmUm() {
        return numeroSequencialDoRegistroDeUmEmUm;
    }

    public void setNumeroSequencialDoRegistroDeUmEmUm(String numeroSequencialDoRegistroDeUmEmUm) {
        this.numeroSequencialDoRegistroDeUmEmUm = numeroSequencialDoRegistroDeUmEmUm;
    }
}
