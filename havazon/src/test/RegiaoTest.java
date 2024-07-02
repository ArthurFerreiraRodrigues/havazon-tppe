package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.RegiaoEnum;

@RunWith(Parameterized.class)
public class RegiaoTest {
    String regiao;
    RegiaoEnum regiaoEnum;

    public RegiaoTest(String regiao, RegiaoEnum regiaoEnum) {
        this.regiao = regiao;
        this.regiaoEnum = regiaoEnum;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { "Centro-Oeste", RegiaoEnum.CENTRO_OESTE },
                { "Nordeste", RegiaoEnum.NORDESTE },
        });
    }

    @Test
    public void test() {
        assertEquals(regiao, regiaoEnum.getNome());
    }
}
