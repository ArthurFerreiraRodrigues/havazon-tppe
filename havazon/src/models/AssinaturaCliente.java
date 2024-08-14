package models;

import enums.TipoClienteEnum;

public class AssinaturaCliente {
    private TipoClienteEnum tipoCliente;

    public AssinaturaCliente() {
        this.tipoCliente = TipoClienteEnum.PADRAO;
    }

    public TipoClienteEnum getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoClienteEnum tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void assinaturaPrime() {
        if (this.tipoCliente == TipoClienteEnum.PADRAO) {
            this.setTipoCliente(TipoClienteEnum.PRIME);
        } else if (this.tipoCliente == TipoClienteEnum.ESPECIAL) {
            this.setTipoCliente(TipoClienteEnum.PRIME_ESPECIAL);
        }
    }

    public void atualizaTipoClientePorValorTotal(double valorTotalComprasMensal) {
        if (valorTotalComprasMensal > 100 && this.tipoCliente == TipoClienteEnum.PADRAO) {
            this.setTipoCliente(TipoClienteEnum.ESPECIAL);
        } else if (valorTotalComprasMensal > 100 && this.tipoCliente == TipoClienteEnum.PRIME) {
            this.setTipoCliente(TipoClienteEnum.PRIME_ESPECIAL);
        } else if (valorTotalComprasMensal <= 100 && this.tipoCliente == TipoClienteEnum.ESPECIAL) {
            this.setTipoCliente(TipoClienteEnum.PADRAO);
        } else if (valorTotalComprasMensal <= 100 && this.tipoCliente == TipoClienteEnum.PRIME_ESPECIAL) {
            this.setTipoCliente(TipoClienteEnum.PRIME);
        }
    }
}
