package module;

public class cliente {

    String nome;
    String senha;

    public cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public cliente() {

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}