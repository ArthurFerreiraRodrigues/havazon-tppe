package models;

import java.util.ArrayList;

public class DatabaseModel {
    private DatabaseModel() {
    }

    private static ArrayList<VendaModel> vendas = new ArrayList<VendaModel>();
    private static ArrayList<ProdutoModel> produtos = new ArrayList<ProdutoModel>();

    private static ArrayList<ClienteModel> clientes = new ArrayList<ClienteModel>();

    public static ArrayList<ClienteModel> getClientes() {
        return clientes;
    }

    public static ArrayList<VendaModel> getVendas() {
        return vendas;
    }

    public static ArrayList<ProdutoModel> getProdutos() {
        return produtos;
    }
}
