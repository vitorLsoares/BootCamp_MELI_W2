package Aula2.Ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        List<Book> biblioteca = new ArrayList<>();
        Book livro1 = new Book("Harry Potter",9780545582889L,"J. K. Rowling", false);
        Book livro2 = new Book("Game of Thrones",9780545652889L,"Geoger R. R. Martin", false);
        Book livro3 = new Book("2000 leguas subimarinas",6570545652889L,"Julio Verne", false);


        biblioteca.add(livro1);
        biblioteca.add(livro2);
        biblioteca.add(livro3);

        System.out.println("============ Livro Cadastrados");

        biblioteca.forEach(System.out::println);

        System.out.println("============ Aluguel");

        livro1.emprestimo();
        livro3.emprestimo();
        biblioteca.forEach(System.out::println);




    }
}
