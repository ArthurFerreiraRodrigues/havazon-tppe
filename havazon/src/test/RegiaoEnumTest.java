package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.RegiaoEnum;

@RunWith(Parameterized.class)
public class RegiaoEnumTest {
    String regiao;
    RegiaoEnum regiaoEnum;

    public RegiaoEnumTest(String regiao, RegiaoEnum regiaoEnum) {
        this.regiao = regiao;
        this.regiaoEnum = regiaoEnum;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { "Centro-Oeste", RegiaoEnum.CENTRO_OESTE },
                { "Nordeste", RegiaoEnum.NORDESTE },
                { "Distrito-Federal", RegiaoEnum.DF},
        });
    }

    @Test
    public void test() {
        assertEquals(regiao, regiaoEnum.getNome());
    }
}
