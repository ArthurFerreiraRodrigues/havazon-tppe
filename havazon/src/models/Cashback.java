package models;

import enums.TipoClienteEnum;

public class Cashback {
    
    private static final double CASHBACK_EMPRESARIAL = 0.05;
    private static final double CASHBACK_NORMAL = 0.03;
    private static final double CASHBACK_PADRAO = 0.0;

    public static double calcula(TipoClienteEnum tipoClienteEnum, double valorTotal, boolean isEmpresarial) {
        if (tipoClienteEnum == TipoClienteEnum.PADRAO || tipoClienteEnum == TipoClienteEnum.ESPECIAL) {
            return CASHBACK_PADRAO;
        }
        
        return isEmpresarial ? calculaCashbackEmpresarial(valorTotal) : calculaCashbackNormal(valorTotal);
    }

    private static double calculaCashbackEmpresarial(double valorTotal) {
        return valorTotal * CASHBACK_EMPRESARIAL;
    }

    private static double calculaCashbackNormal(double valorTotal) {
        return valorTotal * CASHBACK_NORMAL;
    }
}
