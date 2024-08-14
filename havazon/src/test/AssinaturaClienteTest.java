package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.EstadoEnum;
import enums.TipoClienteEnum;
import models.CartaoModel;
import models.ClienteModel;
import models.EnderecoModel;

@RunWith(Parameterized.class)
public class AssinaturaClienteTest {

    boolean isPrime;
    double valorTotalComprasMensal;
    TipoClienteEnum tipoClienteEsperado;

    public AssinaturaClienteTest(boolean isPrime, double valorTotalComprasMensal, TipoClienteEnum tipoClienteEsperado) {
        this.isPrime = isPrime;
        this.valorTotalComprasMensal = valorTotalComprasMensal;
        this.tipoClienteEsperado = tipoClienteEsperado;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { false, 101, TipoClienteEnum.ESPECIAL },
                { false, 100, TipoClienteEnum.PADRAO },
                { true, 101, TipoClienteEnum.PRIME_ESPECIAL },
                { true, 100, TipoClienteEnum.PRIME },
        });
    }

    @Test
    public void test() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.GO), new CartaoModel("1234 1234 1234 1234") );

        if(isPrime){
            cliente.assinaturaPrime();
        }
        cliente.setValorTotalComprasMensal(valorTotalComprasMensal);

        assertEquals(cliente.getTipoCliente(), tipoClienteEsperado);
    }
}
