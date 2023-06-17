
package jdbc.model;

public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(int id,String nome, String cpf, String telefone, String funcao) {
        this.id=id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    
}
