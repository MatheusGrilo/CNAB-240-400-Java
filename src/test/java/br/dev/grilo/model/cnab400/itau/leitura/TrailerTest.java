package br.dev.grilo.model.cnab400.itau.leitura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrailerTest {

    @Test
    void testExtrairCamposItauTrailer() {
        String linhaTrailer = "9                                                                                                                                                                                                                                                                                                                                                                                                         000003";

        assertEquals("9", Trailer.TIPO_DE_REGISTRO.extrair(linhaTrailer));
        assertEquals(" ".repeat(393), Trailer.BRANCOS.extrair(linhaTrailer));
        assertEquals("000003", Trailer.NUMERO_SEQUENCIAL.extrair(linhaTrailer));
    }

}
