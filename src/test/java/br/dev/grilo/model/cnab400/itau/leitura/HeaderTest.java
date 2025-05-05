package br.dev.grilo.model.cnab400.itau.leitura;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HeaderTest {

    @Test
    void testExtrairCamposItauHeader() {
        String linhaHeader = "01REMESSA01COBRANCA       012300987654        EMPRESA EXEMPLO LTDA          341BANCO ITAU SA  300725                                                                                                                                                                                                                                                                                                      000001";

        assertEquals("0", Header.TIPO_DE_REGISTRO.extrair(linhaHeader));
        assertEquals("1", Header.OPERACAO.extrair(linhaHeader));
        assertEquals("REMESSA", Header.LITERAL_DE_REMESSA.extrair(linhaHeader));
        assertEquals("01", Header.CODIGO_DO_SERVICO.extrair(linhaHeader));
        assertEquals("COBRANCA       ", Header.LITERAL_DO_SERVICO.extrair(linhaHeader));
        assertEquals("0123", Header.AGENCIA.extrair(linhaHeader));
        assertEquals("00", Header.ZEROS.extrair(linhaHeader));
        assertEquals("98765", Header.CONTA.extrair(linhaHeader));
        assertEquals("4", Header.DAC.extrair(linhaHeader));
        assertEquals(" ".repeat(8), Header.BRANCOS_01.extrair(linhaHeader));
        assertEquals(30, Header.NOME_DA_EMPRESA.extrair(linhaHeader).length());
        assertEquals("341", Header.CODIGO_DO_BANCO.extrair(linhaHeader));
        assertEquals("BANCO ITAU SA  ", Header.NOME_DO_BANCO.extrair(linhaHeader));
        assertEquals("300725", Header.DATA_DE_GERACAO.extrair(linhaHeader));
        assertEquals(" ".repeat(294), Header.BRANCOS_02.extrair(linhaHeader));
        assertEquals("000001", Header.NUMERO_SEQUENCIAL.extrair(linhaHeader));
    }

}
