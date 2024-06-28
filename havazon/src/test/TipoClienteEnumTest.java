package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import enums.TipoClienteEnum;

public class TipoClienteEnumTest {

    @Test
    public void TipoClienteValueTest() {
        assertEquals("Padrão", TipoClienteEnum.PADRAO.getTipoCliente());
        assertEquals("Especial", TipoClienteEnum.ESPECIAL.getTipoCliente());
        assertEquals("Prime", TipoClienteEnum.PRIME.getTipoCliente());
        assertEquals("Prime Especial", TipoClienteEnum.PRIME_ESPECIAL.getTipoCliente());
    }
}
