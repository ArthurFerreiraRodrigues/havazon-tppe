package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import models.CartaoModel;

@RunWith(Parameterized.class)
public class CartaoModelTest {

    String numeroCartao;
    boolean isNumeroValido;

    public CartaoModelTest(String numeroCartao, boolean isNumeroValido) {
        this.numeroCartao = numeroCartao;
        this.isNumeroValido = isNumeroValido;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { "1234 1264 1234 1234", true },
                { "1234123412341234", false },
                { "1234567890123456789", false },
                { "4296 1311 1111 1111", true },
                { "4296 1311 1111 111", false },
        });
    }

    @Test
    public void test() {

        CartaoModel cartao = new CartaoModel(numeroCartao);

        assertEquals(isNumeroValido, cartao.isNumeroValido());
    }
}
