package models;

import enums.TipoClienteEnum;

public class ClienteModel {
    private int id;
    private TipoClienteEnum tipoCliente;
    private EnderecoModel endereco;
    private double saldoCashback;
    private double valorTotalComprasMensal;
    private CartaoModel cartao;

    public ClienteModel(EnderecoModel endereco, CartaoModel cartao) {
        this.id = DatabaseModel.getClientes().size() + 1;
        this.tipoCliente = TipoClienteEnum.PADRAO;
        this.endereco = endereco;
        this.saldoCashback = 0;
        this.valorTotalComprasMensal = 0;
        this.cartao = cartao;
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
        return tipoCliente;
    }

    private void setTipoCliente(TipoClienteEnum tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void assinaturaPrime() {
        if (this.tipoCliente == TipoClienteEnum.PADRAO) {
            this.setTipoCliente(TipoClienteEnum.PRIME);
        } else if (this.tipoCliente == TipoClienteEnum.ESPECIAL) {
            this.setTipoCliente(TipoClienteEnum.PRIME_ESPECIAL);
        }
    }

    public double getSaldoCashback() {
        return saldoCashback;
    }

    public void addSaldoCashback(double saldoCashback) {
        this.saldoCashback += saldoCashback;
    }

    public void zeraSaldoCashback() {
        this.saldoCashback = 0;
    }

    public double getValorTotalComprasMensal() {
        return valorTotalComprasMensal;
    }

    public void setValorTotalComprasMensal(double valorTotalComprasMensal) {
        this.valorTotalComprasMensal = valorTotalComprasMensal;
        if (this.valorTotalComprasMensal > 100 && this.tipoCliente == TipoClienteEnum.PADRAO) {
            this.setTipoCliente(TipoClienteEnum.ESPECIAL);
        } else if (this.valorTotalComprasMensal > 100 && this.tipoCliente == TipoClienteEnum.PRIME) {
            this.setTipoCliente(TipoClienteEnum.PRIME_ESPECIAL);
        } else if (this.valorTotalComprasMensal <= 100 && this.tipoCliente == TipoClienteEnum.ESPECIAL) {
            this.setTipoCliente(TipoClienteEnum.PADRAO);
        } else if (this.valorTotalComprasMensal <= 100 && this.tipoCliente == TipoClienteEnum.PRIME_ESPECIAL) {
            this.setTipoCliente(TipoClienteEnum.PRIME);
        }
    }

}
