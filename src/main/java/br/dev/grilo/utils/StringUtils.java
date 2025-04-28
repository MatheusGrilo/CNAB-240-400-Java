package br.dev.grilo.utils;

/**
 * Métodos utilitários para trabalhar com Strings.
 */
public class StringUtils {
    /**
     * Converte uma String numérica do CNAB em double.
     *
     * @param texto Texto numérico (sem vírgula)
     * @return Valor formatado em String (ex: "150.00")
     */
    public static String stringParaDouble(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "0.00";
        }
        try {
            double valor = Double.parseDouble(texto) / 100.0;
            return String.format("%.2f", valor);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Erro ao converter para double: " + texto, e);
        }
    }
}
