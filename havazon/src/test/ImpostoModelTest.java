package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.EstadoEnum;
import enums.RegiaoEnum;
import models.ImpostoModel;


@RunWith(Parameterized.class)
public class ImpostoModelTest {
    ImpostoModel imposto;
    double valorDoPedido;
    double expectedIcmsResult;
    RegiaoEnum regiaoEnum;
    EstadoEnum estadoEnum;
    boolean isCapital;
    double expectedImpostoMunicipalResult;

    public ImpostoModelTest(double valorDoPedido, double expectedIcmsResult, double expectedImpostoMunicipalResult, RegiaoEnum regiaoEnum, EstadoEnum estadoEnum, boolean isCapital) {
        this.valorDoPedido = valorDoPedido;
        this.expectedIcmsResult = expectedIcmsResult;
        this.regiaoEnum = regiaoEnum;
        this.estadoEnum = estadoEnum;
        this.isCapital = isCapital;
        this.expectedImpostoMunicipalResult = expectedImpostoMunicipalResult;
        
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { 20.0 , 3.59, 5.0, RegiaoEnum.DF, EstadoEnum.DF, true},
                { 20.0 , 3.59, 0.0, RegiaoEnum.DF, EstadoEnum.DF, false},
                { 100.0 , 16.0, 10.0 ,RegiaoEnum.CENTRO_OESTE, EstadoEnum.GO, true},
                { 100.0 , 16.0, 13.0 ,RegiaoEnum.CENTRO_OESTE, EstadoEnum.MT, false},
        });
    }

    @Test
    public void test() {
        assertEquals(ImpostoModel.icms(estadoEnum, valorDoPedido),expectedIcmsResult, 0.01);
        assertEquals(ImpostoModel.municipal(regiaoEnum, isCapital), expectedImpostoMunicipalResult, 0.01);
    }
}
