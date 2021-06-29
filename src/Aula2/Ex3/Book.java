package Aula2.Ex3;

import javax.swing.*;

public class Book {

    private String titulo;
    private Long isbn;
    private String autor;
    private boolean aluguel;


    public Book(String titulo, Long isbn, String autor, boolean aluguel) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.aluguel = aluguel;

    }

    public Book(){

    }

    public boolean isAluguel() { return aluguel; }

    public void setAluguel(boolean aluguel) { this.aluguel = aluguel; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void emprestimo(){
        this.aluguel = true;
    }

    public void devolver(){
        this.aluguel = false;
    }

    @Override
    public String toString() {
        return titulo + ',' + isbn + ',' + autor + ',' + (aluguel ? "Alugado" : "Livre")  + '\n' ;
    }
}
