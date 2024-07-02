package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.EstadoEnum;
import enums.RegiaoEnum;

@RunWith(Parameterized.class)
public class EstadoEnumTest {
    String estado;
    EstadoEnum estadoEnum;
    RegiaoEnum regiaoEnum;

    public EstadoEnumTest(String estado, EstadoEnum estadoEnum, RegiaoEnum regiaoEnum) {
        this.estado = estado;
        this.estadoEnum = estadoEnum;
        this.regiaoEnum = regiaoEnum;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { "Acre", EstadoEnum.AC, RegiaoEnum.NORTE },
                { "Distrito Federal", EstadoEnum.DF, RegiaoEnum.CENTRO_OESTE },
                { "Tocantins", EstadoEnum.TO, RegiaoEnum.NORTE },
        });
    }

    @Test
    public void test() {
        assertEquals(estado, estadoEnum.getNome());
        assertEquals(estadoEnum.getRegiao(), regiaoEnum);
    }
}
