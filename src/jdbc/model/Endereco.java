
package jdbc.model;

public class Endereco extends Cliente{
    private int id_cliente;
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;

    public Endereco(String rua, String bairro, String numero, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
    }

    public Endereco() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = getId();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cep) {
        this.cidade = cep;
    }
    
}
