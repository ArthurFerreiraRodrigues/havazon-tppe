package enums;

import enums.RegiaoEnum;

public class Imposto {
    static public double icms(double valorDoPedido){
        return valorDoPedido * 0.12;
    }
    static public double municipal(RegiaoEnum regiaoEnum, boolean isCapital){
        switch (regiaoEnum) {
            case RegiaoEnum.DF:
                if(isCapital) return 5.0;
                    return 0.0;
            case RegiaoEnum.CENTRO_OESTE:
                if(isCapital) return 10.0;
                    return 13.0;
            case RegiaoEnum.NORDESTE:
                if(isCapital) return 15.0;
                    return 18.0;
            case RegiaoEnum.NORTE:
                if(isCapital) return 20.0;
                    return 25.0;
            case RegiaoEnum.SUDESTE:
                if(isCapital) return 7.0;
                    return 10.0;
            case RegiaoEnum.SUL:
                if(isCapital) return 10.0;
                    return 13.0;
            default:
                return 0.0;
        }
    }
}
