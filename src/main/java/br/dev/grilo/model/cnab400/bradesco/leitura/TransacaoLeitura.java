package br.dev.grilo.model.cnab400.bradesco.leitura;


/**
 * Documentação das Transações CNAB 400 do Bradesco em 28/04/2025:
 * Nº 4008.524.0121 - Versão 17
 * https://banco.bradesco/assets/pessoajuridica/pdf/4008-524-0121-layout-cobranca-versao-portugues.pdf
 * Todos serão armazenados como String, pois normalmente existem casas decimais à esquerda
 * O tamanho total do das transações são de 400 campos cada
 */
public class TransacaoLeitura {

    /** Identificação do Registro
     * 1 campo
     * Numérico
     * Padrão: 1
     */
    private String identificacaoDoRegistro;

    /** Agência de Débito
     * 5 campos
     * Numérico
     * Opcional (Código da Agência do Pagador Exclusivo para débito em conta)
     */
    private String agenciaDeDebito;

    /** Dígito da Agência de Débito
     * 1 campo
     * Numérico
     * Opcional (Dígito da Agência do Pagador)
     */
    private String digitoDaAgenciaDeDebito;

    /** Razão da Conta-Corrente
     * 5 campos
     * Numérico
     * Opcional (Razão da Conta do Pagador)
     */
    private String razaoDaContaCorrente;

    /** Conta-Corrente
     * 7 campos
     * Numérico
     * Opcional (Número da Conta do Pagador)
     */
    private String contaCorrente;

    /** Dígito da Conta-Corrente
     * 1 campo
     * Numérico
     * Opcional (Dígito da Conta do Pagador)
     */
    private String digitoDaContaCorrente;

    /** Identificação da Empresa Beneficiária no Banco
     * 17 campos
     * Numérico
     * Zero, Carteira, Agência e Conta - Corrente
     */
    private String identificacaoDaEmpresaBeneficiariaNoBanco;

    /** Número de Controle do Participante
     * 25 campos
     * Alfanumérico
     * Uso da Empresa
     */
    private String numControleDoParticipante;

    /** Código do Banco a Ser Debitado
     * 3 campos
     * Numérico
     * Nº do Banco (Bradesco = 237)
     */
    private String codDoBancoASerDebitado;

    /** Campo de Multa
     * 1 campo
     * Numérico
     * Se = 2, considerar percentual de multa. Se = 0, sem multa.
     */
    private String campoDeMulta;

    /** Percentual de Multa
     * 4 campos
     * Numérico
     * Percentual de multa a ser considerado
     */
    private String percentualDeMulta;

    /** Identificação do Título no Banco
     * 11 campos
     * Alfanumérico
     * Número bancário para cobrança com e sem registro
     */
    private String identificacaoDoTituloNoBanco;

    /** Dígito de Autoconferência do Número Bancário
     * 1 campo
     * Numérico
     * Digito N/N
     */
    private String digitoDeAutoconferenciaDoNumBancario;

    /** Desconto/Bonificação por Dia
     * 10 campos
     * Numérico
     * Valor do desconto bonificação por dia.
     */
    private String descontoBonificacaoPorDia;

    /** Condição para Emissão da Papeleta de Cobrança
     * 1 campo
     * Numérico
     * 1 = Banco emite e processa o registro.
     * 2 = Cliente emite e o Banco somente processa o registro.
     */
    private String condicaoParaEmissaoDaPapeletaDeCobranca;

    /** Identificação se Emite Boleto para Débito Automático
     * 1 campo
     * Numérico
     * == N Não registra na cobrança.
     * != N Registra na cobrança e emite Boleto.
     */
    private String identSeEmiteBoletoParaDebitoAutomatico;

    /** Identificação da Operação do Banco
     * 10 campos
     * Alfanumérico
     * Brancos
     */
    private String identificacaoDaOperacaoDoBanco;

    /** Indicador de Rateio de Crédito
     * 1 campo
     * Numérico
     * Padrão: R
     */
    private String indicadorRateioCredito;

    /** Endereçamento para Aviso de Débito Automático
     * 1 campo
     * Numérico
     * Vide Obs. na página 19 do pdf
     */
    private String enderecamentoParaAvisoDebitoAutomatico;

    /** Quantidade de Pagamentos
     * 2 campos
     * Numérico
     * Vide Obs. na página 19 do pdf
     */
    private String quantidadeDePagamentos;

    /** Identificação da Ocorrência
     * 2 campos
     * Numérico
     * Códigos de Ocorrência
     */
    private String identificacaoDaOcorrencia;

    /** Número do Documento
     * 10 campos
     * Alfanumérico
     * Documento
     */
    private String numDoDocumento;

    /** Data do Vencimento do Título
     * 6 campos
     * Numérico
     * Formato: DDMMAA
     * Data de vencimento do título
     */
    private String dataDoVencimentoDoTitulo;

    /** Valor do Título
     * 13 campos
     * Numérico
     * Valor do Título (preencher sem ponto e sem vírgula)
     */
    private String valorDoTitulo;

    /** Banco Encarregado da Cobrança
     * 3 campos
     * Numérico
     * Preencher com zeros
     */
    private String bancoEncarregadoDaCobranca;

    /** Agência Depositária
     * 5 campos
     * Numérico
     * Preencher com zeros
     */
    private String agenciaDepositaria;

    /** Espécie de Título
     * 2 campos
     * Numérico
     * 01-Duplicata
     * 02-Nota Promissória
     * 03-Nota de Seguro
     * 05-Recibo
     * 10-Letras de Câmbio
     * 11-Nota de Débito
     * 12-Duplicata de Serv.
     * 31-Cartão de Crédito
     * 32-Boleto de Proposta
     * 33- Depósito e Aporte
     * 99-Outros
     */
    private String especieDeTitulo;

    /** Identificação
     * 1 campo
     * Alfabético
     * Sempre = N
     */
    private String identificacao;

    /** Data da Emissão do Título
     * 6 campos
     * Numérico
     * Formato: DDMMAA
     * Data de emissão do título
     */
    private String dataDaEmissaoDoTitulo;

    /** Primeira Instrução
     * 2 campos
     * Numérico
     * Vide Obs. na página 20 do pdf
     */
    private String primeiraInstrucao;

    /** Segunda Instrução
     * 2 campos
     * Numérico
     * Vide Obs. na página 20 do pdf
     */
    private String segundaInstrucao;

    /** Valor a Ser Cobrado por Dia de Atraso
     * 13 campos
     * Numérico
     * Mora por Dia de Atraso
     */
    private String valorASerCobradoPorDiaDeAtraso;

    /** Data Limite para Concessão de Desconto
     * 6 campos
     * Numérico
     * Formato: DDMMAA
     * Data limite para concessão de desconto
     */
    private String dataLimiteParaConcessaoDeDesconto;

    /** Valor do Desconto
     * 13 campos
     * Numérico
     * Valor Desconto
     */
    private String valorDoDesconto;

    /** Valor do IOF
     * 13 campos
     * Numérico
     * Valor do IOF
     */
    private String valorDoIof;

    /** Valor do Abatimento a Ser Concedido ou Cancelado
     * 13 campos
     * Numérico
     * Valor Abatimento
     */
    private String valorDoAbatimentoASerConcedidoOuCancelado;

    /** Identificação do Tipo de Inscrição do Pagador
     * 2 campos
     * Numérico
     * 01 = CPF, 02 = CNPJ
     */
    private String identificacaoDoTipoDeInscricaoDoPagador;

    /** Número de Inscrição do Pagador
     * 14 campos
     * Numérico
     * CNPJ/CPF
     */
    private String numInscricaoDoPagador;

    /** Nome do Pagador
     * 40 campos
     * Alfabético
     * Nome do Pagador
     */
    private String nomeDoPagador;

    /** Endereço do Pagador
     * 40 campos
     * Alfanumérico
     * Endereço do Pagador
     */
    private String enderecoDoPagador;

    /** Primeira Mensagem
     * 12 campos
     * Alfanumérico
     * Vide Obs. na página 21 do pdf
     */
    private String primeiraMensagem;

    /** CEP do Pagador
     * 5 campos
     * Numérico
     * CEP do Pagador sem Sufixo
     */
    private String cep;

    /** Sufixo do CEP
     * 3 campos
     * Numérico
     * Sufixo do CEP do Pagador
     */
    private String sufixoDoCep;

    /** Beneficiário Final ou Segunda Mensagem
     * 60 campos
     * Alfanumérico
     * Decomposição
     */
    private String beneficiarioFinalOuSegundaMensagem;

    /** Número Sequencial do Registro
     * 6 campos
     * Numérico
     * Número sequencial do registro no arquivo
     */
    private String numSequencialDoRegistro;

    // Getters and Setters

    public String getIdentificacaoDoRegistro() {
        return identificacaoDoRegistro;
    }

    public void setIdentificacaoDoRegistro(String identificacaoDoRegistro) {
        this.identificacaoDoRegistro = identificacaoDoRegistro;
    }

    public String getAgenciaDeDebito() {
        return agenciaDeDebito;
    }

    public void setAgenciaDeDebito(String agenciaDeDebito) {
        this.agenciaDeDebito = agenciaDeDebito;
    }

    public String getDigitoDaAgenciaDeDebito() {
        return digitoDaAgenciaDeDebito;
    }

    public void setDigitoDaAgenciaDeDebito(String digitoDaAgenciaDeDebito) {
        this.digitoDaAgenciaDeDebito = digitoDaAgenciaDeDebito;
    }

    public String getRazaoDaContaCorrente() {
        return razaoDaContaCorrente;
    }

    public void setRazaoDaContaCorrente(String razaoDaContaCorrente) {
        this.razaoDaContaCorrente = razaoDaContaCorrente;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getDigitoDaContaCorrente() {
        return digitoDaContaCorrente;
    }

    public void setDigitoDaContaCorrente(String digitoDaContaCorrente) {
        this.digitoDaContaCorrente = digitoDaContaCorrente;
    }

    public String getIdentificacaoDaEmpresaBeneficiariaNoBanco() {
        return identificacaoDaEmpresaBeneficiariaNoBanco;
    }

    public void setIdentificacaoDaEmpresaBeneficiariaNoBanco(String identificacaoDaEmpresaBeneficiariaNoBanco) {
        this.identificacaoDaEmpresaBeneficiariaNoBanco = identificacaoDaEmpresaBeneficiariaNoBanco;
    }

    public String getNumControleDoParticipante() {
        return numControleDoParticipante;
    }

    public void setNumControleDoParticipante(String numControleDoParticipante) {
        this.numControleDoParticipante = numControleDoParticipante;
    }

    public String getCodDoBancoASerDebitado() {
        return codDoBancoASerDebitado;
    }

    public void setCodDoBancoASerDebitado(String codDoBancoASerDebitado) {
        this.codDoBancoASerDebitado = codDoBancoASerDebitado;
    }

    public String getCampoDeMulta() {
        return campoDeMulta;
    }

    public void setCampoDeMulta(String campoDeMulta) {
        this.campoDeMulta = campoDeMulta;
    }

    public String getPercentualDeMulta() {
        return percentualDeMulta;
    }

    public void setPercentualDeMulta(String percentualDeMulta) {
        this.percentualDeMulta = percentualDeMulta;
    }

    public String getIdentificacaoDoTituloNoBanco() {
        return identificacaoDoTituloNoBanco;
    }

    public void setIdentificacaoDoTituloNoBanco(String identificacaoDoTituloNoBanco) {
        this.identificacaoDoTituloNoBanco = identificacaoDoTituloNoBanco;
    }

    public String getDigitoDeAutoconferenciaDoNumBancario() {
        return digitoDeAutoconferenciaDoNumBancario;
    }

    public void setDigitoDeAutoconferenciaDoNumBancario(String digitoDeAutoconferenciaDoNumBancario) {
        this.digitoDeAutoconferenciaDoNumBancario = digitoDeAutoconferenciaDoNumBancario;
    }

    public String getDescontoBonificacaoPorDia() {
        return descontoBonificacaoPorDia;
    }

    public void setDescontoBonificacaoPorDia(String descontoBonificacaoPorDia) {
        this.descontoBonificacaoPorDia = descontoBonificacaoPorDia;
    }

    public String getCondicaoParaEmissaoDaPapeletaDeCobranca() {
        return condicaoParaEmissaoDaPapeletaDeCobranca;
    }

    public void setCondicaoParaEmissaoDaPapeletaDeCobranca(String condicaoParaEmissaoDaPapeletaDeCobranca) {
        this.condicaoParaEmissaoDaPapeletaDeCobranca = condicaoParaEmissaoDaPapeletaDeCobranca;
    }

    public String getIdentSeEmiteBoletoParaDebitoAutomatico() {
        return identSeEmiteBoletoParaDebitoAutomatico;
    }

    public void setIdentSeEmiteBoletoParaDebitoAutomatico(String identSeEmiteBoletoParaDebitoAutomatico) {
        this.identSeEmiteBoletoParaDebitoAutomatico = identSeEmiteBoletoParaDebitoAutomatico;
    }

    public String getIdentificacaoDaOperacaoDoBanco() {
        return identificacaoDaOperacaoDoBanco;
    }

    public void setIdentificacaoDaOperacaoDoBanco(String identificacaoDaOperacaoDoBanco) {
        this.identificacaoDaOperacaoDoBanco = identificacaoDaOperacaoDoBanco;
    }

    public String getIndicadorRateioCredito() {
        return indicadorRateioCredito;
    }

    public void setIndicadorRateioCredito(String indicadorRateioCredito) {
        this.indicadorRateioCredito = indicadorRateioCredito;
    }

    public String getEnderecamentoParaAvisoDebitoAutomatico() {
        return enderecamentoParaAvisoDebitoAutomatico;
    }

    public void setEnderecamentoParaAvisoDebitoAutomatico(String enderecamentoParaAvisoDebitoAutomatico) {
        this.enderecamentoParaAvisoDebitoAutomatico = enderecamentoParaAvisoDebitoAutomatico;
    }

    public String getQuantidadeDePagamentos() {
        return quantidadeDePagamentos;
    }

    public void setQuantidadeDePagamentos(String quantidadeDePagamentos) {
        this.quantidadeDePagamentos = quantidadeDePagamentos;
    }

    public String getIdentificacaoDaOcorrencia() {
        return identificacaoDaOcorrencia;
    }

    public void setIdentificacaoDaOcorrencia(String identificacaoDaOcorrencia) {
        this.identificacaoDaOcorrencia = identificacaoDaOcorrencia;
    }

    public String getNumDoDocumento() {
        return numDoDocumento;
    }

    public void setNumDoDocumento(String numDoDocumento) {
        this.numDoDocumento = numDoDocumento;
    }

    public String getDataDoVencimentoDoTitulo() {
        return dataDoVencimentoDoTitulo;
    }

    public void setDataDoVencimentoDoTitulo(String dataDoVencimentoDoTitulo) {
        this.dataDoVencimentoDoTitulo = dataDoVencimentoDoTitulo;
    }

    public String getValorDoTitulo() {
        return valorDoTitulo;
    }

    public void setValorDoTitulo(String valorDoTitulo) {
        this.valorDoTitulo = valorDoTitulo;
    }

    public String getBancoEncarregadoDaCobranca() {
        return bancoEncarregadoDaCobranca;
    }

    public void setBancoEncarregadoDaCobranca(String bancoEncarregadoDaCobranca) {
        this.bancoEncarregadoDaCobranca = bancoEncarregadoDaCobranca;
    }

    public String getAgenciaDepositaria() {
        return agenciaDepositaria;
    }

    public void setAgenciaDepositaria(String agenciaDepositaria) {
        this.agenciaDepositaria = agenciaDepositaria;
    }

    public String getEspecieDeTitulo() {
        return especieDeTitulo;
    }

    public void setEspecieDeTitulo(String especieDeTitulo) {
        this.especieDeTitulo = especieDeTitulo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getDataDaEmissaoDoTitulo() {
        return dataDaEmissaoDoTitulo;
    }

    public void setDataDaEmissaoDoTitulo(String dataDaEmissaoDoTitulo) {
        this.dataDaEmissaoDoTitulo = dataDaEmissaoDoTitulo;
    }

    public String getPrimeiraInstrucao() {
        return primeiraInstrucao;
    }

    public void setPrimeiraInstrucao(String primeiraInstrucao) {
        this.primeiraInstrucao = primeiraInstrucao;
    }

    public String getSegundaInstrucao() {
        return segundaInstrucao;
    }

    public void setSegundaInstrucao(String segundaInstrucao) {
        this.segundaInstrucao = segundaInstrucao;
    }

    public String getValorASerCobradoPorDiaDeAtraso() {
        return valorASerCobradoPorDiaDeAtraso;
    }

    public void setValorASerCobradoPorDiaDeAtraso(String valorASerCobradoPorDiaDeAtraso) {
        this.valorASerCobradoPorDiaDeAtraso = valorASerCobradoPorDiaDeAtraso;
    }

    public String getDataLimiteParaConcessaoDeDesconto() {
        return dataLimiteParaConcessaoDeDesconto;
    }

    public void setDataLimiteParaConcessaoDeDesconto(String dataLimiteParaConcessaoDeDesconto) {
        this.dataLimiteParaConcessaoDeDesconto = dataLimiteParaConcessaoDeDesconto;
    }

    public String getValorDoDesconto() {
        return valorDoDesconto;
    }

    public void setValorDoDesconto(String valorDoDesconto) {
        this.valorDoDesconto = valorDoDesconto;
    }

    public String getValorDoIof() {
        return valorDoIof;
    }

    public void setValorDoIof(String valorDoIof) {
        this.valorDoIof = valorDoIof;
    }

    public String getValorDoAbatimentoASerConcedidoOuCancelado() {
        return valorDoAbatimentoASerConcedidoOuCancelado;
    }

    public void setValorDoAbatimentoASerConcedidoOuCancelado(String valorDoAbatimentoASerConcedidoOuCancelado) {
        this.valorDoAbatimentoASerConcedidoOuCancelado = valorDoAbatimentoASerConcedidoOuCancelado;
    }

    public String getIdentificacaoDoTipoDeInscricaoDoPagador() {
        return identificacaoDoTipoDeInscricaoDoPagador;
    }

    public void setIdentificacaoDoTipoDeInscricaoDoPagador(String identificacaoDoTipoDeInscricaoDoPagador) {
        this.identificacaoDoTipoDeInscricaoDoPagador = identificacaoDoTipoDeInscricaoDoPagador;
    }

    public String getNumInscricaoDoPagador() {
        return numInscricaoDoPagador;
    }

    public void setNumInscricaoDoPagador(String numInscricaoDoPagador) {
        this.numInscricaoDoPagador = numInscricaoDoPagador;
    }

    public String getNomeDoPagador() {
        return nomeDoPagador;
    }

    public void setNomeDoPagador(String nomeDoPagador) {
        this.nomeDoPagador = nomeDoPagador;
    }

    public String getEnderecoDoPagador() {
        return enderecoDoPagador;
    }

    public void setEnderecoDoPagador(String enderecoDoPagador) {
        this.enderecoDoPagador = enderecoDoPagador;
    }

    public String getPrimeiraMensagem() {
        return primeiraMensagem;
    }

    public void setPrimeiraMensagem(String primeiraMensagem) {
        this.primeiraMensagem = primeiraMensagem;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSufixoDoCep() {
        return sufixoDoCep;
    }

    public void setSufixoDoCep(String sufixoDoCep) {
        this.sufixoDoCep = sufixoDoCep;
    }

    public String getBeneficiarioFinalOuSegundaMensagem() {
        return beneficiarioFinalOuSegundaMensagem;
    }

    public void setBeneficiarioFinalOuSegundaMensagem(String beneficiarioFinalOuSegundaMensagem) {
        this.beneficiarioFinalOuSegundaMensagem = beneficiarioFinalOuSegundaMensagem;
    }

    public String getNumSequencialDoRegistro() {
        return numSequencialDoRegistro;
    }

    public void setNumSequencialDoRegistro(String numSequencialDoRegistro) {
        this.numSequencialDoRegistro = numSequencialDoRegistro;
    }
}
