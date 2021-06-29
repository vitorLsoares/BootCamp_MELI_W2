package Teoria;

public class Main {
    public static void main(String[] args) {
        Pessoa aluno = Factory.getInstance("aluno", "Vitor");
        Pessoa professor = Factory.getInstance(TipoPessoa.Professor, "Kenyo");

        System.out.println("professor.getNome() = " + professor.getNome());
        System.out.println("aluno = " + aluno.getNome());
    }
}
