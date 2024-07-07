package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import enums.TipoClienteEnum;

public class VendaModel {
    private ClienteModel cliente;
    private LocalDateTime dateTime;
    private List<ProdutoModel> produtos;
    private double desconto;
    private double saldoCashback;
    private double frete;
    private double valorTotal;
    private double impostos;

    public VendaModel(ClienteModel cliente, LocalDateTime dateTime, List<ProdutoModel> produtos) {
        this.cliente = cliente;
        this.dateTime = dateTime;
        this.produtos = produtos;
    }

    private void calculaDesconto(){
        if(this.cliente.getTipoCliente() == TipoClienteEnum.ESPECIAL){
            this.desconto = 10;
            if(this.cliente.getCartao().isEmpresarial()){
                this.desconto += 10;
            }
        }
    }

    private void calculaCashback(){
        if(this.cliente.getCartao().isEmpresarial()){
            this.saldoCashback = this.valorTotal * 0.05;
        }
        else{
            this.saldoCashback = this.valorTotal * 0.03;
        }
    }

    private double calculaValorProdutos(){
        double valor = 0;
        for (ProdutoModel produto : produtos) {
            valor += produto.getPreco();
        }
        return valor;
    }

    private void calculaImpostos(){
        this.impostos = ImpostoModel.icms(this.cliente.getEndereco().getEstado(), this.calculaValorProdutos());
    }

    private void calculaFrete(){
        this.frete = ImpostoModel.municipal(this.cliente.getEndereco().getRegiao(), this.cliente.getEndereco().isCapital());
    }

    private void calculaValorTotal(){
        this.calculaDesconto();
        this.calculaFrete();
        this.calculaImpostos();
        this.valorTotal = this.calculaValorProdutos() - this.desconto + this.frete + this.impostos;
    }
    
    public String emitirNotaFiscal() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        this.calculaValorTotal();
        this.calculaCashback();

        sb.append("========================================\n");
        sb.append("NOTA FISCAL\n");
        sb.append("========================================\n");
        sb.append("Cliente ID: ").append(cliente.getId()).append("\n");
        sb.append("Tipo Do Cliente: ").append(cliente.getTipoCliente().name()).append("\n");
        sb.append("Data: ").append(dateTime.format(formatter)).append("\n");
        sb.append("----------------------------------------\n");
        sb.append("PRODUTOS\n");
        for (ProdutoModel produto : produtos) {
            sb.append("- ").append(produto.getDescricao()).append("\n");
        }
        sb.append("----------------------------------------\n");
        sb.append(String.format("Desconto: %.2f\n", desconto));
        sb.append(String.format("Saldo de Cashback: %.2f\n", saldoCashback));
        sb.append(String.format("Frete: %.2f\n", frete));
        sb.append(String.format("Impostos: %.2f\n", impostos));
        sb.append(String.format("Valor Total: %.2f\n", valorTotal));
        sb.append("========================================\n");

        return sb.toString();
    }

}
