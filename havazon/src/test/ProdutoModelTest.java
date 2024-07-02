package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.ProdutoModel;

public class ProdutoModelTest {

    @Test
    public void testProduto() {

        ProdutoModel p = new ProdutoModel(34215, "celular", 1400.99, "peça");

        assertEquals(34215, p.getCodigo());
        assertEquals("fone", p.getDescricao());
        assertEquals(49.50, p.getPreco(), 0.001);
        assertEquals("peça", p.getUnidade());
    }

}
