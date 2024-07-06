package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enums.EstadoEnum;
import models.CartaoModel;
import models.ClienteModel;
import models.EnderecoModel;
import models.ProdutoModel;
import models.VendaModel;

/*
 * Para o teste abaixo, foi utilizado um exemplo onde o cliente possui cartao da empresa, e considerado um 
 * cliente especial, realiza a compra de dois produtos de 50 reais, gostaria que fosse entregue no DF na capital
 * o valor total da compra é de 100 reais, o desconto de 10% vem da compra no cartao da empresa, como ele realiza a
 * compra para o DF os impostos de ICMS fica com 18% aplicado sobre o valor da compra resultando em 18 reais 
 * e o frete fica com 3,5 reais , ja que temos um deconto de 30% do cartao para o frete de 5,00 reais.
 * resultando no final nos valores: valor total = 100 reais | valor total com desconto = 90 reais | 
 * frete com desconto = 3,5 | imposto icms = 18 reais |  imposto municipal = 0 reais  | Valor final = 111,50 reais.
 */

@RunWith(Parameterized.class)
public class VendaModelTest {
    private VendaModel vendaModel;
    private String expectedOutput;

    public VendaModelTest(VendaModel vendaModel, String expectedOutput) {
        this.vendaModel = vendaModel;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        ClienteModel cliente1 = new ClienteModel(new EnderecoModel(true, EstadoEnum.BA), new CartaoModel(" 4296 13XX XXXX XXXX "));
        // Cliente especial
        cliente1.setValorTotalComprasMensal(101);

        LocalDateTime dateTime1 = LocalDateTime.of(2024, 7, 2, 10, 0);

        List<ProdutoModel> produtos1 = Arrays.asList(
            new ProdutoModel(1, "Produto 1", 50.0, "peça"),
            new ProdutoModel(2, "Produto 2", 60.0, "peça")
        );

        VendaModel vendaModel1 = new VendaModel(cliente1, dateTime1, produtos1, 10.0, 0.0, 5.0, 111.5, 18.0);

        String expectedOutput1 = "========================================\n" +
                "NOTA FISCAL\n" +
                "========================================\n" +
                "Cliente ID: 1\n" +
                "Tipo Do Cliente: ESPECIAL\n" +
                "Data: 2024-07-02 10:00:00\n" +
                "----------------------------------------\n" +
                "PRODUTOS\n" +
                "- Produto 1\n" +
                "- Produto 2\n" +
                "----------------------------------------\n" +
                "Desconto: 10.00\n" +
                "Saldo de Cashback: 0.00\n" +
                "Frete: 5.00\n" +
                "Impostos: 18.00\n" +
                "Valor Total: 111.50\n" +
                "========================================\n";

        
        return Arrays.asList(new Object[][]{
                {vendaModel1, expectedOutput1},
                
        });
    }

    @Test
    public void testEmitirNotaFiscal() {
        assertEquals(expectedOutput, vendaModel.emitirNotaFiscal());
    }
}
