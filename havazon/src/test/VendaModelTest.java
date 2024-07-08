package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
        ClienteModel cliente1 = new ClienteModel(new EnderecoModel(true, EstadoEnum.BA),
                new CartaoModel(" 4296 13XX XXXX XXXX "));
        // Cliente especial
        cliente1.setValorTotalComprasMensal(101);

        LocalDateTime dateTime1 = LocalDateTime.of(2024, 7, 2, 10, 0);

        List<ProdutoModel> produtos1 = Arrays.asList(
                new ProdutoModel(1, "Produto 1", 50.0, "peça"),
                new ProdutoModel(2, "Produto 2", 60.0, "peça"));

        VendaModel vendaModel1 = new VendaModel(cliente1, dateTime1, produtos1);

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
                "Desconto: 10.00%\n" +
                "Saldo de Cashback: 0.00\n" +
                "Frete: 10.50\n" +
                "Municipal: 4.38\n" +
                "ICMS: 13.14\n" +
                "Valor Total: 127.02\n" +
                "========================================\n";

        return Arrays.asList(new Object[][] {
                { vendaModel1, expectedOutput1 },

        });
    }

    @Test
    public void testEmitirNotaFiscal() {
        assertEquals(expectedOutput, vendaModel.emitirNotaFiscal());
    }
}
