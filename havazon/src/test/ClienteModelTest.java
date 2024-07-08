package test;

import static org.junit.Assert.assertTrue;
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
public class ClienteModelTest {

    EstadoEnum estado;
    boolean isCapital;
    String numeroCartao;
    int valorTotalComprasMensal;
    boolean isPrime;
    TipoClienteEnum expectedTipoCliente;
    double cashback;
    int index;
    boolean zeraSaldoCashback;

    public ClienteModelTest(EstadoEnum estado, boolean isCapital, String numeroCartao, int valorTotalComprasMensal, boolean isPrime, TipoClienteEnum expectedTipoCliente, double cashback, int index, boolean zeraSaldoCashback) {
        this.estado = estado;
        this.isCapital = isCapital;
        this.numeroCartao = numeroCartao;
        this.valorTotalComprasMensal = valorTotalComprasMensal;
        this.isPrime = isPrime;
        this.expectedTipoCliente = expectedTipoCliente;
        this.cashback = cashback;
        this.index = index;
        this.zeraSaldoCashback = zeraSaldoCashback;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { EstadoEnum.BA, false, "1234 1234 1234 1234", 0, false, TipoClienteEnum.PADRAO, 100, 1, false},
                { EstadoEnum.BA, false, "1234 1234 1234 1234", 101, false, TipoClienteEnum.ESPECIAL, 100, 1, true},
                { EstadoEnum.BA, false, "1234 1234 1234 1234", 100, false, TipoClienteEnum.PADRAO, 100, 2, false},
                { EstadoEnum.BA, false, "1234 1234 1234 1234", 0, true, TipoClienteEnum.PRIME, 100, 2, true},
                { EstadoEnum.BA, false, "1234 1234 1234 1234", 101, true, TipoClienteEnum.PRIME_ESPECIAL, 100, 1, false},
                { EstadoEnum.BA, false, "1234 1234 1234 1234", 100, true, TipoClienteEnum.PRIME, 100, 1, false},
        });
    }

    @Test
    public void ClienteTest() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(isCapital, estado),
                new CartaoModel(numeroCartao));

        cliente.setValorTotalComprasMensal(valorTotalComprasMensal);
        if(isPrime) cliente.assinaturaPrime();
        assertEquals(expectedTipoCliente, cliente.getTipoCliente());
        assertTrue(cliente.getEndereco() instanceof EnderecoModel);
        assertTrue(cliente.getCartao() instanceof CartaoModel);
    }

    @Test
    public void CashbackTest() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(isCapital, estado),
                new CartaoModel(numeroCartao));

        for(int i = 0; i < index; i++) {
            cliente.addSaldoCashback(cashback);
        }
        if(zeraSaldoCashback) cliente.zeraSaldoCashback();

        double expectedCashback = zeraSaldoCashback ? 0 : cashback*index;

        assertEquals(expectedCashback, cliente.getSaldoCashback(), 0.01);
    }

    @Test
    public void AddSaldoCashback() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));
        cliente.addSaldoCashback(100);
        cliente.addSaldoCashback(100);
        assert cliente.getSaldoCashback() == 200;
    }

}
