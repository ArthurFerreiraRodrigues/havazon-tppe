package enums;

public enum TipoClienteEnum {

    PADRAO("Padrão"),
    ESPECIAL("Especial"),
    PRIME("Prime"),
    PRIME_ESPECIAL("Prime Especial");

    private String tipoCliente = "";

    TipoClienteEnum(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return this.tipoCliente;
    }
}
