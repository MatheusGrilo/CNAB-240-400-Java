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

    /**
     * Repete o caractere informado o número de vezes desejado.
     *
     * @param caractere Caractere ou texto a ser repetido
     * @param vezes     Quantidade de vezes que deve se repetir
     * @return String repetida
     */
    public static String repetir(String caractere, int vezes) {
        if (caractere == null || vezes <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder(vezes * caractere.length());
        for (int i = 0; i < vezes; i++) {
            sb.append(caractere);
        }
        return sb.toString();
    }

    /**
     * Preenche texto com espaços à direita até o tamanho desejado.
     */
    public static String padRight(String texto, int tamanho) {
        if (texto == null) texto = "";
        return String.format("%-" + tamanho + "s", texto);
    }

    /**
     * Preenche texto com zeros à esquerda até o tamanho desejado.
     */
    public static String padLeft(String texto, int tamanho) {
        if (texto == null) texto = "";
        return String.format("%" + tamanho + "s", texto).replace(' ', '0');
    }
}
