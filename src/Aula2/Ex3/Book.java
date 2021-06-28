package Aula2.Ex3;

import javax.swing.*;

public class Book {
    private String titulo;
    private Integer isbn;
    private String autor;

    public Book(String titulo, Integer isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public Book(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void emprestimo(){

    }

    public void devolver(){

    }

    @Override
    public String toString() {
        return titulo + ',' + isbn + ',' + autor + '\n' ;
    }
}
