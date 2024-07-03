package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.RegiaoEnum;
import models.ImpostoModel;


@RunWith(Parameterized.class)
public class ImpostoModelTest {
    ImpostoModel imposto;
    double valorDoPedido;
    double expectedIcmsResult;
    RegiaoEnum regiaoEnum;
    boolean isCapital;
    double expectedImpostoMunicipalResult;

    public ImpostoModelTest(double valorDoPedido, double expectedIcmsResult, double expectedImpostoMunicipalResult, RegiaoEnum regiaoEnum, boolean isCapital) {
        this.valorDoPedido = valorDoPedido;
        this.expectedIcmsResult = expectedIcmsResult;
        this.regiaoEnum = regiaoEnum;
        this.isCapital = isCapital;
        this.expectedImpostoMunicipalResult = expectedImpostoMunicipalResult;
        
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { 20.0 , 2.4, 5.0, RegiaoEnum.DF, true},
                { 20.0 , 2.4, 0.0, RegiaoEnum.DF, false},
                { 100.0 , 12.0, 10.0 ,RegiaoEnum.CENTRO_OESTE , true},
                { 100.0 , 12.0, 13.0 ,RegiaoEnum.CENTRO_OESTE , false},
        });
    }

    @Test
    public void test() {
        assertEquals(ImpostoModel.icms(valorDoPedido),expectedIcmsResult, 0.001);
        assertEquals(ImpostoModel.municipal(regiaoEnum, isCapital), expectedImpostoMunicipalResult, 0.001);
    }
}
