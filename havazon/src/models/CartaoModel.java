package models;

public class CartaoModel {
    private String numero;
    private boolean isEmpresarial; // Cartão da loja ganha desconto

    public CartaoModel(String numero) {
        this.numero = numero;
        this.isEmpresarial = checkIsEmpresarial(numero);
    }

    private static boolean checkIsEmpresarial(String numero) {
        if (numero.startsWith("4296 13")) {
            return true;
        }
        return false;
    }

    public boolean isEmpresarial() {
        return isEmpresarial;
    }

    private String encryptNumero() {
        return numero.substring(0, 7) + "** **** ****";
    }

    /*
     * Método que verifica se o número do cartão é válido
     * e se está no formato correto
     * 
     * O número do cartão deve ter 19 caracteres e estar no formato:
     * "XXXX XXXX XXXX XXXX"
     * 
     * A validação deve ser realizada antes de contruir o objeto
     */
    public boolean isNumeroValido() {
        if (numero.length() == 19
                && numero.matches("[0-9]{4}" + " " + "[0-9]{4}" + " " + "[0-9]{4}" + " " + "[0-9]{4}")) {
            return true;
        }

        return false;
    }

    public String getNumero() {
        return encryptNumero();
    }

}
