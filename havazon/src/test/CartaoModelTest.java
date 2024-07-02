package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.CartaoModel;

public class CartaoModelTest {

    @Test
    public void test() {
        assertTrue(new CartaoModel("1234 1234 1234 1234").isNumeroValido());
        assertFalse(new CartaoModel("1234567890123456").isNumeroValido());
        assertFalse(new CartaoModel("1234567890123456789").isNumeroValido());
        assertTrue(new CartaoModel("4296 1311 1111 1111").isNumeroValido());
        assertTrue(new CartaoModel("4296 1311 1111 111").isEmpresarial());
        assertEquals("4296 13** **** ****", new CartaoModel("4296 1311 1111 111").getNumero());
    }
}
