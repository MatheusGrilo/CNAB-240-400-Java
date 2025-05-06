package br.dev.grilo.model.cnab400.itau.leitura;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HeaderTest {

    @Test
    void testExtrairCamposItauHeader() {
        String linhaHeader = "01REMESSA01COBRANCA       012300987654        EMPRESA EXEMPLO LTDA          341BANCO ITAU SA  300725                                                                                                                                                                                                                                                                                                      000001";

        assertTrue(Header.validate(linhaHeader));
    }

}
