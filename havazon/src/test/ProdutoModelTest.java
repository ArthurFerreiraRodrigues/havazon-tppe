package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import models.ProdutoModel;

@RunWith(Parameterized.class)
public class ProdutoModelTest {

    int codigo;
    String descricao;
    double preco;
    String unidade;

    public ProdutoModelTest(int codigo, String descricao, double preco, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.unidade = unidade;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { 101 , "Caneta Esferográfica", 1.50, "unidade"},
                { 102 , "Notebook 15.6\" 8GB RAM", 3500.00, "peça"},
        });
    }

    @Test
    public void testProduto() {

        ProdutoModel p = new ProdutoModel(codigo, descricao, preco, unidade);

        assertEquals(codigo, p.getCodigo());
        assertEquals(descricao, p.getDescricao());
        assertEquals(preco, p.getPreco(), 0.001);
        assertEquals(unidade, p.getUnidade());
    }

}
