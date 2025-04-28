package br.dev.grilo.enums;

/**
 * Enums de Bancos suportados no sistema.
 */
public enum BancoEnum {
    BRADESCO(237, "Bradesco");

    private final int codigo;
    private final String nome;

    BancoEnum(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
