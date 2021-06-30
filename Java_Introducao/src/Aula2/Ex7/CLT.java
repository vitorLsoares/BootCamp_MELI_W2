package Aula2.Ex7;

public abstract class CLT<T> {

    private String nome;
    private Integer matricula;
    private String CPF;

    public CLT(String nome, Integer matricula, String CPF) {
        this.nome = nome;
        this.matricula = matricula;
        this.CPF = CPF;
    }

    public CLT(){

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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    abstract double pagarSalario(T t);

}
