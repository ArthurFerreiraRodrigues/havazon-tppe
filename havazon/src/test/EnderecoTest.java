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

@RunWith(Parameterized.class)
public class EnderecoTest {

    String regiao;
    RegiaoEnum regiaoEnum;
    EstadoEnum estadoEnum;

    public EnderecoTest(String regiao, RegiaoEnum regiaoEnum, EstadoEnum estadoEnum) {
        this.regiao = regiao;
        this.regiaoEnum = regiaoEnum;
        this.estadoEnum = estadoEnum;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { "Centro-Oeste", RegiaoEnum.CENTRO_OESTE, EstadoEnum.GO },
                { "Nordeste", RegiaoEnum.NORDESTE, EstadoEnum.PB }
        });
    }

    @Test
    public void test() {
        EnderecoModel endereco = new EnderecoModel(false, estadoEnum);
        assertEquals(endereco.getRegiao(), regiaoEnum);
    }

}
