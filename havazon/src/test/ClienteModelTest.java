package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import enums.EstadoEnum;
import enums.TipoClienteEnum;
import models.CartaoModel;
import models.ClienteModel;
import models.EnderecoModel;

public class ClienteModelTest {

    @Test
    public void ClientePadrao() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));

        cliente.setValorTotalComprasMensal(0);
        assert cliente.getTipoCliente().equals(TipoClienteEnum.PADRAO);
    }

    @Test
    public void ClienteEspecial() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));
        cliente.setValorTotalComprasMensal(101);
        assert cliente.getTipoCliente().equals(TipoClienteEnum.ESPECIAL);
    }

    @Test
    public void ClienteQuaseEspecial() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));
        cliente.setValorTotalComprasMensal(100);
        assert cliente.getTipoCliente().equals(TipoClienteEnum.PADRAO);
    }

    @Test
    public void ClientePrime() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));
        cliente.assinaturaPrime();
        cliente.setValorTotalComprasMensal(0);
        assert cliente.getTipoCliente().equals(TipoClienteEnum.PRIME);
    }

    @Test
    public void ClientePrimeEspecial() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));
        cliente.assinaturaPrime();
        cliente.setValorTotalComprasMensal(101);
        assert cliente.getTipoCliente().equals(TipoClienteEnum.PRIME_ESPECIAL);
    }

    @Test
    public void ClientePrimeQuaseEspecial() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));
        cliente.assinaturaPrime();
        cliente.setValorTotalComprasMensal(100);
        assert cliente.getTipoCliente().equals(TipoClienteEnum.PRIME);
    }

    @Test
    public void ZeraSaldoCashback() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));
        cliente.addSaldoCashback(100);
        cliente.zeraSaldoCashback();
        assert cliente.getSaldoCashback() == 0;
    }

    @Test
    public void AddSaldoCashback() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));
        cliente.addSaldoCashback(100);
        cliente.addSaldoCashback(100);
        assert cliente.getSaldoCashback() == 200;
    }

    @Test
    public void EnderecoCliente() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));

        assertTrue(cliente.getEndereco() instanceof EnderecoModel);
    }

    @Test
    public void CartaoCliente() {
        ClienteModel cliente = new ClienteModel(new EnderecoModel(false, EstadoEnum.BA),
                new CartaoModel("1234 1234 1234 1234"));

        assertTrue(cliente.getCartao() instanceof CartaoModel);
    }

}
