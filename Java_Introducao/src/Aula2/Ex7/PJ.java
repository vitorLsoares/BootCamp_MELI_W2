package Aula2.Ex7;

public abstract class PJ {

    private String nome;
    private Integer matricula;
    private String CNPJ;

    public PJ(String nome, Integer matricula, String CNPJ) {
        this.nome = nome;
        this.matricula = matricula;
        this.CNPJ = CNPJ;
    }
    public PJ(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
