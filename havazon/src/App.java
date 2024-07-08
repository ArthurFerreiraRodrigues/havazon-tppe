import java.time.LocalDateTime;
import java.util.Arrays;

import enums.EstadoEnum;
import models.CartaoModel;
import models.ClienteModel;
import models.EnderecoModel;
import models.ProdutoModel;
import models.VendaModel;

public class App {
    public static void main(String[] args) throws Exception {

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
        VendaModel venda5 = new VendaModel(cliente2, LocalDateTime.parse("2024-04-05T17:57:42.978223"), Arrays.asList(caneta));
        VendaModel venda6 = new VendaModel(cliente4, LocalDateTime.parse("2024-04-05T17:57:42.978223"), Arrays.asList(tecido, cafe, caneta, tv));


        System.out.println(venda1.emitirNotaFiscal());
        System.out.println(venda2.emitirNotaFiscal());
        System.out.println(venda3.emitirNotaFiscal());
        System.out.println(venda4.emitirNotaFiscal());
        System.out.println(venda5.emitirNotaFiscal());
        System.out.println(venda6.emitirNotaFiscal());
    }
}
