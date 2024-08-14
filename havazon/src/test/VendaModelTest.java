package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
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

        ClienteModel cliente1 = new ClienteModel(new EnderecoModel(false, EstadoEnum.GO), new CartaoModel("1234 1234 1234 1234"));
        ClienteModel cliente2 = new ClienteModel(new EnderecoModel(true, EstadoEnum.RS), new CartaoModel("4296 1334 1234 1234"));
        ClienteModel cliente3 = new ClienteModel(new EnderecoModel(true, EstadoEnum.DF), new CartaoModel("4296 1234 1234 1234"));
        ClienteModel cliente4 = new ClienteModel(new EnderecoModel(false, EstadoEnum.PE), new CartaoModel("4296 1334 4321 4321"));

        cliente2.assinaturaPrime();
        cliente3.setValorTotalComprasMensal(120.00);
        cliente4.setValorTotalComprasMensal(120.00);
        cliente4.assinaturaPrime();

        ProdutoModel caneta = new ProdutoModel(101, "Caneta Esferográfica", 1.50, "unidade");
        ProdutoModel notebook = new ProdutoModel(102, "Notebook 15.6\" 8GB RAM", 3500.00, "peça");
        ProdutoModel cafe = new ProdutoModel(103, "Café em Grãos 1kg", 25.90, "kg");
        ProdutoModel tv = new ProdutoModel(104, "TV 42\" LED Full HD", 2300.00, "peça");
        ProdutoModel tecido = new ProdutoModel(105, "Tecido Algodão 1m", 12.00, "metro");

        VendaModel venda1 = new VendaModel(cliente1, LocalDateTime.parse("2024-07-06T17:57:42.978223"), Arrays.asList(caneta, notebook));
        VendaModel venda2 = new VendaModel(cliente2, LocalDateTime.parse("2024-04-05T17:57:42.978223"), Arrays.asList(tv, notebook));
        VendaModel venda3 = new VendaModel(cliente3, LocalDateTime.parse("2024-04-05T17:57:42.978223"), Arrays.asList(tecido));
        VendaModel venda4 = new VendaModel(cliente4, LocalDateTime.parse("2024-04-05T17:57:42.978223"), Arrays.asList(tecido, cafe, caneta, tv));
        VendaModel vendaCashbackMaiorValor = new VendaModel(cliente2, LocalDateTime.parse("2024-04-05T17:57:42.978223"), Arrays.asList(caneta));
        VendaModel vendaCashbackMenorValor = new VendaModel(cliente4, LocalDateTime.parse("2024-04-05T17:57:42.978223"), Arrays.asList(tecido, cafe, caneta, tv));

        String expectedOutput1 = "========================================\n" +
                "NOTA FISCAL\n" +
                "========================================\n" +
                "Cliente ID: 1\n" +
                "Tipo Do Cliente: PADRAO\n" +
                "Data: 2024-07-06 17:57:42\n" +
                "----------------------------------------\n" +
                "PRODUTOS\n" +
                "  R$ 1,50 - Caneta Esferográfica\n" +
                "  R$ 3500,00 - Notebook 15.6\" 8GB RAM\n" +
                "----------------------------------------\n" +
                "Desconto: 0,00%\n" +
                "Valor Abatido com Cashback: 0,00\n" +
                "Saldo de Cashback: 0,00\n" +
                "Frete: 13,00\n" +
                "Municipal: 140,58\n" +
                "ICMS: 421,74\n" +
                "Valor Total: 4076,82\n" +
                "========================================\n";

            String expectedOutput2 = "========================================\n" +
                "NOTA FISCAL\n" +
                "========================================\n" +
                "Cliente ID: 2\n" +
                "Tipo Do Cliente: PRIME\n" +
                "Data: 2024-04-05 17:57:42\n" +
                "----------------------------------------\n" +
                "PRODUTOS\n" +
                "  R$ 2300,00 - TV 42\" LED Full HD\n" +
                "  R$ 3500,00 - Notebook 15.6\" 8GB RAM\n" +
                "----------------------------------------\n" +
                "Desconto: 10,00%\n" +
                "Valor Abatido com Cashback: 0,00\n" +
                "Saldo de Cashback: 303,34\n" +
                "Frete: 10,00\n" +
                "Municipal: 209,20\n" +
                "ICMS: 627,60\n" +
                "Valor Total: 6066,80\n" +
                "========================================\n";

            String expectedOutput3 = "========================================\n" +
                "NOTA FISCAL\n" +
                "========================================\n" +
                "Cliente ID: 3\n" +
                "Tipo Do Cliente: ESPECIAL\n" +
                "Data: 2024-04-05 17:57:42\n" +
                "----------------------------------------\n" +
                "PRODUTOS\n" +
                "  R$ 12,00 - Tecido Algodão 1m\n" +
                "----------------------------------------\n" +
                "Desconto: 10,00%\n" +
                "Valor Abatido com Cashback: 0,00\n" +
                "Saldo de Cashback: 0,00\n" +
                "Frete: 3,50\n" +
                "Municipal: 0,00\n" +
                "ICMS: 2,57\n" +
                "Valor Total: 16,87\n" +
                "========================================\n";

            String expectedOutput4 = "========================================\n" +
                "NOTA FISCAL\n" +
                "========================================\n" +
                "Cliente ID: 4\n" +
                "Tipo Do Cliente: PRIME_ESPECIAL\n" +
                "Data: 2024-04-05 17:57:42\n" +
                "----------------------------------------\n" +
                "PRODUTOS\n" +
                "  R$ 12,00 - Tecido Algodão 1m\n" +
                "  R$ 25,90 - Café em Grãos 1kg\n" +
                "  R$ 1,50 - Caneta Esferográfica\n" +
                "  R$ 2300,00 - TV 42\" LED Full HD\n" +
                "----------------------------------------\n" +
                "Desconto: 20,00%\n" +
                "Valor Abatido com Cashback: 0,00\n" +
                "Saldo de Cashback: 109,59\n" +
                "Frete: 18,00\n" +
                "Municipal: 75,58\n" +
                "ICMS: 226,74\n" +
                "Valor Total: 2191,84\n" +
                "========================================\n";

            String expectedOutput5 = "========================================\n" +
                "NOTA FISCAL\n" +
                "========================================\n" +
                "Cliente ID: 2\n" +
                "Tipo Do Cliente: PRIME\n" +
                "Data: 2024-04-05 17:57:42\n" +
                "----------------------------------------\n" +
                "PRODUTOS\n" +
                "  R$ 1,50 - Caneta Esferográfica\n" +
                "----------------------------------------\n" +
                "Desconto: 10,00%\n" +
                "Valor Abatido com Cashback: 13,17\n" +
                "Saldo de Cashback: 0,00\n" +
                "Frete: 10,00\n" +
                "Municipal: 0,45\n" +
                "ICMS: 1,36\n" +
                "Valor Total: 0,00\n" +
                "========================================\n";

            String expectedOutput6 = "========================================\n" +
                "NOTA FISCAL\n" +
                "========================================\n" +
                "Cliente ID: 4\n" +
                "Tipo Do Cliente: PRIME_ESPECIAL\n" +
                "Data: 2024-04-05 17:57:42\n" +
                "----------------------------------------\n" +
                "PRODUTOS\n" +
                "  R$ 12,00 - Tecido Algodão 1m\n" +
                "  R$ 25,90 - Café em Grãos 1kg\n" +
                "  R$ 1,50 - Caneta Esferográfica\n" +
                "  R$ 2300,00 - TV 42\" LED Full HD\n" +
                "----------------------------------------\n" +
                "Desconto: 20,00%\n" +
                "Valor Abatido com Cashback: 109,59\n" +
                "Saldo de Cashback: 104,11\n" +
                "Frete: 18,00\n" +
                "Municipal: 75,58\n" +
                "ICMS: 226,74\n" +
                "Valor Total: 2082,25\n" +
                "========================================\n";

        return Arrays.asList(new Object[][] {
                { venda1, expectedOutput1 },
                { venda2, expectedOutput2 },
                { venda3, expectedOutput3 },
                { venda4, expectedOutput4 },
                { vendaCashbackMaiorValor, expectedOutput5 },
                { vendaCashbackMenorValor, expectedOutput6 },

        });
    }

    @Test
    public void testEmitirNotaFiscal() {
        assertEquals(expectedOutput, vendaModel.emitirNotaFiscal());
    }
}
