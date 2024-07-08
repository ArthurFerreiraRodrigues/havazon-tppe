package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.TipoClienteEnum;

@RunWith(Parameterized.class)
public class TipoClienteEnumTest {

    String tipoCliente;
    TipoClienteEnum tipoClienteEnum;

    public TipoClienteEnumTest(String tipoCliente, TipoClienteEnum tipoClienteEnum) {
        this.tipoCliente = tipoCliente;
        this.tipoClienteEnum = tipoClienteEnum;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { "Padrão", TipoClienteEnum.PADRAO },
                { "Especial", TipoClienteEnum.ESPECIAL },
                { "Prime", TipoClienteEnum.PRIME },
                { "Prime Especial", TipoClienteEnum.PRIME_ESPECIAL },
        });
    }

    @Test
    public void TipoClienteValueTest() {

        assertEquals(tipoCliente, tipoClienteEnum.getTipoCliente());
    }
}
