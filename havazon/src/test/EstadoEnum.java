package test;

public enum EstadoEnum {
    AC("Acre", RegiaoEnum.NORTE),
    AL("Alagoas",RegiaoEnum.NORTE ),
    AP("Amapá", RegiaoEnum.NORTE),
    AM("Amazonas", RegiaoEnum.NORTE),
    BA("Bahia", RegiaoEnum.NORDESTE),
    CE("Ceará", RegiaoEnum.NORDESTE),
    DF("Distrito Federal", RegiaoEnum.CENTRO_OESTE),
    ES("Espírito Santo", RegiaoEnum.SUDESTE),
    GO("Goiás", RegiaoEnum.CENTRO_OESTE),
    MA("Maranhão", RegiaoEnum.NORDESTE),
    MT("Mato Grosso", RegiaoEnum.CENTRO_OESTE),
    MS("Mato Grosso do Sul", RegiaoEnum.CENTRO_OESTE),
    MG("Minas Gerais", RegiaoEnum.SUDESTE),
    PA("Pará", RegiaoEnum.NORTE),
    PB("Paraíba", RegiaoEnum.NORDESTE),
    PR("Paraná", RegiaoEnum.SUL),
    PE("Pernambuco", RegiaoEnum.NORDESTE),
    PI("Piauí", RegiaoEnum.NORDESTE),
    RJ("Rio de Janeiro", RegiaoEnum.SUDESTE),
    RN("Rio Grande do Norte", RegiaoEnum.NORDESTE),
    RS("Rio Grande do Sul", RegiaoEnum.SUL),
    RO("Rondônia", RegiaoEnum.NORTE),
    RR("Roraima", RegiaoEnum.NORTE),
    SC("Santa Catarina", RegiaoEnum.SUL),
    SP("São Paulo", RegiaoEnum.SUDESTE),
    SE("Sergipe", RegiaoEnum.NORDESTE),
    TO("Tocantins", RegiaoEnum.NORTE);

    private final String nome;
    private final RegiaoEnum regiao;

    EstadoEnum(String nome, RegiaoEnum regiao) {
        this.nome = nome;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public String getStrRegiao(){
        return regiao.name();
    }

    @Override
    public String toString() {
        return nome;
    }
}