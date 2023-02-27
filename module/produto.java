package module;

public class produto {
    int idproduto;
    String Produto;
    int valor;
    int quantidadeEstoque;
    int quantidadeVendas;
    int lucro;

    public int getLucro() {
        return lucro;
    }

    public void setLucro(int lucro) {
        this.lucro = lucro;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(int quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }

    public produto() {
        this.Produto = Produto;
        this.valor = valor;
    }
    public produto(String nome, int id) {
        this.idproduto = idproduto;
    }

    public int getidproduto() {
        return idproduto;
    }

    public void setidproduto(int idproduto) {
        idproduto = idproduto;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String produto) {
        Produto = produto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}