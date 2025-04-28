package br.dev.grilo.enums;

/**
 * Enums dos Status possíveis de um título.
 */
public enum StatusTituloEnum {
    PAGO("06"),
    ACEITO("02"),
    REJEITADO("03"),
    ESTORNADO("40"),
    CANCELADO("09");

    private final String codigo;

    StatusTituloEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
