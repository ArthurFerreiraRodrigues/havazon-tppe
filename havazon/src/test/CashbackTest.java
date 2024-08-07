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
import models.Cashback;
import models.ClienteModel;
import models.EnderecoModel;

@RunWith(Parameterized.class)
public class CashbackTest {
    ClienteModel cliente;
    double valorTotalCompra;
    double cashbackEsperado;

    public CashbackTest(ClienteModel clienteModel, double valorTotal, double cashbackEsperado) {
        this.cliente = clienteModel;
        this.valorTotalCompra = valorTotal;
        this.cashbackEsperado = cashbackEsperado;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        
        ClienteModel clientePadrao = new ClienteModel(new EnderecoModel(false, EstadoEnum.GO), new CartaoModel("1234 1234 1234 1234") );
        ClienteModel clienteEspecial = new ClienteModel(new EnderecoModel(true, EstadoEnum.RS), new CartaoModel("1234 1234 1234 1234"));
        clienteEspecial.setTipoCliente(TipoClienteEnum.ESPECIAL);
        ClienteModel clientePrimeSemCartaoEmpresarial = new ClienteModel(new EnderecoModel(true, EstadoEnum.RS), new CartaoModel("1234 1234 1234 1234"));
        clientePrimeSemCartaoEmpresarial.setTipoCliente(TipoClienteEnum.PRIME);
        ClienteModel clientePrimeComCartaoEmpresarial = new ClienteModel(new EnderecoModel(true, EstadoEnum.RS), new CartaoModel("4296 1334 1234 1234"));
        clientePrimeComCartaoEmpresarial.setTipoCliente(TipoClienteEnum.PRIME);
        ClienteModel clientePrimeEspecialSemCartaoEmpresarial = new ClienteModel(new EnderecoModel(true, EstadoEnum.RS), new CartaoModel("1234 1234 1234 1234"));
        clientePrimeEspecialSemCartaoEmpresarial.setTipoCliente(TipoClienteEnum.PRIME_ESPECIAL);
        ClienteModel clientePrimeEspecialComCartaoEmpresarial = new ClienteModel(new EnderecoModel(true, EstadoEnum.RS), new CartaoModel("4296 1334 1234 1234"));
        clientePrimeEspecialComCartaoEmpresarial.setTipoCliente(TipoClienteEnum.PRIME_ESPECIAL);

        return Arrays.asList(new Object[][] {
                { clientePadrao, 100, 0.0 },
                { clienteEspecial, 100, 0.0 },
                {clientePrimeSemCartaoEmpresarial, 100, 3.0},
                {clientePrimeComCartaoEmpresarial, 100, 5.0},
                {clientePrimeEspecialSemCartaoEmpresarial, 100, 3.0},
                {clientePrimeEspecialComCartaoEmpresarial, 100, 5.0},
        });
    }

    @Test
    public void TipoClienteValueTest() {
        double cashbackObtido = Cashback.calcula(cliente.getTipoCliente(), valorTotalCompra,  cliente.getCartao().isEmpresarial());
        assertEquals( cashbackObtido, cashbackEsperado, 0.001);
    }
}
