package models;

import enums.RegiaoEnum;

public class ImpostoModel {
    private double icms;
    private double municipal;

    public ImpostoModel(double valorDoPedido, EnderecoModel enderecoModel) {
        this.icms = valorDoPedido * icms(enderecoModel);
        this.municipal = valorDoPedido * municipal(enderecoModel);
    }

    private double icms(EnderecoModel enderecoModel) {
        if (enderecoModel.getRegiao() == RegiaoEnum.DF) {
            return 0.18;
        }

        return 0.12;

    }

    private double municipal(EnderecoModel enderecoModel) {
        if (enderecoModel.getRegiao() == RegiaoEnum.DF) {
            return 0.0;
        }

        return 0.04;
    }

    public double getIcms() {
        return icms;
    }

    public double getMunicipal() {
        return municipal;
    }

}
