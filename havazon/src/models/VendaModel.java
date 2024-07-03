package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import enums.RegiaoEnum;
import enums.TipoClienteEnum;

public class VendaModel {
    private ClienteModel cliente;
    private LocalDateTime dateTime;
    // TODO: change this to Product class
    private List<String> produtos;
    private double desconto;
    private double saldoCashback;
    private double frete;
    private double valorTotal;
    private ImpostoModel imposto;

    public VendaModel(ClienteModel cliente, LocalDateTime dateTime, List<String> produtos, double valorTotal) {
        this.cliente = cliente;
        this.dateTime = dateTime;
        this.produtos = produtos;
        this.desconto = calculaDesconto(cliente);
        this.saldoCashback = cliente.getSaldoCashback();
        this.frete = cliente.getTipoCliente() == TipoClienteEnum.ESPECIAL ? calculaFrete(cliente.getEndereco().getRegiao(), cliente.getEndereco().isCapital()) * 0.7 : calculaFrete(cliente.getEndereco().getRegiao(), cliente.getEndereco().isCapital());
        this.valorTotal = valorTotal * (1.0 - this.desconto);
        this.imposto = new ImpostoModel(this.valorTotal + this.frete, this.cliente.getEndereco());
    }

    public double calculaDesconto(ClienteModel cliente) {
        double totalDesconto = 0.0;
        if (cliente.getTipoCliente() == TipoClienteEnum.ESPECIAL
                || cliente.getTipoCliente() == TipoClienteEnum.PRIME_ESPECIAL) {
            totalDesconto += 10.0;
        }
        if (cliente.getCartao().isEmpresarial()) {
            totalDesconto += 10.0;
        }

        return totalDesconto / 100.0;
    }

    public double calculaFrete(RegiaoEnum regiaoEnum, boolean isCapital) {
        switch (regiaoEnum) {
            case DF:
                if (isCapital)
                    return 5.0;
                return 0.0;
            case CENTRO_OESTE:
                if (isCapital)
                    return 10.0;
                return 13.0;
            case NORDESTE:
                if (isCapital)
                    return 15.0;
                return 18.0;
            case NORTE:
                if (isCapital)
                    return 20.0;
                return 25.0;
            case SUDESTE:
                if (isCapital)
                    return 7.0;
                return 10.0;
            case SUL:
                if (isCapital)
                    return 10.0;
                return 13.0;
            default:
                return 0.0;
        }
    }

    public String emitirNotaFiscal() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("NOTA FISCAL\n");
        sb.append("========================================\n");
        sb.append("Cliente ID: ").append(cliente.getId()).append("\n");
        sb.append("Tipo Do Cliente: ").append(cliente.getTipoCliente().name()).append("\n");
        sb.append("Data: ").append(dateTime.format(formatter)).append("\n");
        sb.append("----------------------------------------\n");
        sb.append("PRODUTOS\n");
        for (String produto : produtos) {
            sb.append("- ").append(produto).append("\n");
        }
        sb.append("----------------------------------------\n");
        sb.append(String.format("Desconto: %.2f%%\n", this.desconto*100));
        sb.append(String.format("Saldo de Cashback: %.2f\n", this.saldoCashback));
        sb.append(String.format("Frete: %.2f\n", this.frete));
        sb.append(String.format("Municipal: %.2f\n", this.imposto.getMunicipal()));
        sb.append(String.format("ICMS: %.2f\n", this.imposto.getIcms()));
        sb.append(String.format("Valor Total: %.2f\n", this.valorTotal + this.imposto.getIcms() + this.imposto.getMunicipal()));
        sb.append("========================================\n");

        return sb.toString();
    }

}
