package Teoria;

public class Anuncios {
    private String codico;
    private String nome;
    private int numVendas;

    public Anuncios( String nome, int numVendas) {
        this.nome = nome;
        this.numVendas = numVendas;
    }

    public String getCodico() {
        return codico;
    }

    public void setCodico(String codico) {
        this.codico = codico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }
}
