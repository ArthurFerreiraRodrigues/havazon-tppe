package enums;

public enum RegiaoEnum {
    NORTE("Norte"),
    NORDESTE("Nordeste"),
    CENTRO_OESTE("Centro-Oeste"),
    SUDESTE("Sudeste"),
    SUL("Sul"),
    DF("Distrito-Federal");

    private final String nome;

    RegiaoEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
