package Aula1;

public class Produto {

    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;

    //============== Construtor
    public Produto(String codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(){

    }

    //=========== Métodos

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto clone(Produto produto){
        Produto p = new Produto(produto.codigo,produto.nome,produto.preco,produto.quantidade);
        return p;
    }

    @Override
    public String toString() {
        return "Produto{" + '\n' +
                "Produto '" + this.codigo + '\n' +
                "nome = '" + this.nome + '\n' +
                "R$" + this.preco +'\n'+
                "Quantidade = " + this.quantidade +
                '}';
    }
}
