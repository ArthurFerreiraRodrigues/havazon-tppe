package models;

import enums.EstadoEnum;
import enums.RegiaoEnum;

public class EnderecoModel {
    private boolean isCapital;
    private EstadoEnum estado;

    public EnderecoModel(boolean isCapital, EstadoEnum estado) {
        this.isCapital = isCapital;
        this.estado = estado;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public RegiaoEnum getRegiao() {
        return estado.getRegiao();
    }
}
