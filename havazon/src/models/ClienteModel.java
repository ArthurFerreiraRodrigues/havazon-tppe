package models;

import enums.TipoClienteEnum;

public class ClienteModel {
    private int id;
    private EnderecoModel endereco;
    private double valorTotalComprasMensal;
    private CartaoModel cartao;
    private AssinaturaCliente assinaturaCliente;
    private Cashback cashback;

    public ClienteModel(EnderecoModel endereco, CartaoModel cartao) {
        this.id = DatabaseModel.getClientes().size() + 1;
        this.endereco = endereco;
        this.valorTotalComprasMensal = 0;
        this.cartao = cartao;
        this.assinaturaCliente = new AssinaturaCliente(); // Nova classe para lógica de assinatura
        this.cashback = new Cashback(); // Classe para lógica de cashback

        DatabaseModel.getClientes().add(this);
    }

    public int getId() {
        return id;
    }

    public CartaoModel getCartao() {
        return cartao;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public TipoClienteEnum getTipoCliente() {
        return assinaturaCliente.getTipoCliente();
    }

    public void setTipoCliente(TipoClienteEnum tipoCliente) {
        this.assinaturaCliente.setTipoCliente(tipoCliente);
    }

    public void assinaturaPrime() {
        assinaturaCliente.assinaturaPrime();
    }

    public double getSaldoCashback() {
        return cashback.getSaldoCashback();
    }

    public double addSaldoCashback(double saldoCashback) {
        return cashback.addSaldoCashback(saldoCashback);
    }

    public void zeraSaldoCashback() {
        cashback.zeraSaldoCashback();
    }

    public double getValorTotalComprasMensal() {
        return valorTotalComprasMensal;
    }

    public void setValorTotalComprasMensal(double valorTotalComprasMensal) {
        this.valorTotalComprasMensal = valorTotalComprasMensal;
        assinaturaCliente.atualizaTipoClientePorValorTotal(valorTotalComprasMensal);
    }
}
