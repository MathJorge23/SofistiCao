
package jdbc.model;

public class Pet {
    private int id;
    private int donoId;
    private String nome;
    private String raca;
    private String cor;
    private String porte;
    private double peso;

    public Pet() {
    }

    public Pet(int id, int donoId, String nome, String raca, String cor, String porte, double peso) {
        this.id = id;
        this.donoId = donoId;
        this.nome = nome;
        this.raca = raca;
        this.cor = cor;
        this.porte = porte;
        this.peso = peso;
    }

    public Pet(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getDonoId() {
        return donoId;
    }

    public void setDonoId(int donoId) {
        this.donoId = donoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
}
