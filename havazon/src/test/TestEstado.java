package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEstado {
    String estado;
    EstadoEnum estadoEnum;

    public TestEstado(String estado, EstadoEnum estadoEnum) {
        this.estado = estado;
        this.estadoEnum = estadoEnum;
    }

    @Parameters
    public static Iterable<Object[]> getParameters(){
        return Arrays.asList(new Object[][] { 
            {"Acre", EstadoEnum.AC},
            {"Distrito Federal", EstadoEnum.DF},
            {"Tocantins", EstadoEnum.TO},
        });
    }

    @Test
    public void test() {
        assertEquals(estado , estadoEnum.getNome());
    }
}
