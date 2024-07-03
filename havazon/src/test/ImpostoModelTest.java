package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.EstadoEnum;
import enums.RegiaoEnum;
import models.EnderecoModel;
import models.ImpostoModel;


@RunWith(Parameterized.class)
public class ImpostoModelTest {
    ImpostoModel imposto;
    double valorDoPedido;
    double expectedIcmsResult;
    EstadoEnum estadoEnum;
    boolean isCapital;
    double expectedImpostoMunicipalResult;

    public ImpostoModelTest(double valorDoPedido, double expectedIcmsResult, double expectedImpostoMunicipalResult, EstadoEnum estadoEnum, boolean isCapital) {
        this.valorDoPedido = valorDoPedido;
        this.expectedIcmsResult = expectedIcmsResult;
        this.estadoEnum = estadoEnum;
        this.isCapital = isCapital;
        this.expectedImpostoMunicipalResult = expectedImpostoMunicipalResult;
        
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { 100.0 , 18.0, 0.0, EstadoEnum.DF, true},
                { 100.0 , 18.0, 0.0, EstadoEnum.DF, false},
                { 100.0 , 12.0, 4.0 ,EstadoEnum.GO , true},
                { 100.0 , 12.0, 4.0 ,EstadoEnum.GO , false},
        });
    }

    @Test
    public void test() {
        ImpostoModel imposto = new ImpostoModel(valorDoPedido, new EnderecoModel(isCapital, estadoEnum));
        assertEquals(imposto.getIcms(),expectedIcmsResult, 0.001);
        assertEquals(imposto.getMunicipal(), expectedImpostoMunicipalResult, 0.001);
    }
}
