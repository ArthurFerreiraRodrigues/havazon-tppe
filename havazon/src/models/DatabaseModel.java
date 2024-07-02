package models;

import java.util.ArrayList;

public class DatabaseModel {
    private DatabaseModel() {
    }

    /*
     * private static ArrayList<Vendas> vendas = new ArrayList<Vendas>();
     * private static ArrayList<Produtos> produtos = new ArrayList<Produtos>();
     */
    private static ArrayList<ClienteModel> clientes = new ArrayList<ClienteModel>();

    public static ArrayList<ClienteModel> getClientes() {
        return clientes;
    }

}
