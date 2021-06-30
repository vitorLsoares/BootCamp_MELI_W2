package Aula3.Ex1;

import java.util.List;

public class Teste {


    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("Gabriel" , "465.394.495-07");
        Pessoa pessoa2 = new Pessoa("Bruno" , "598.394.452-02");
        Pessoa pessoa3 = new Pessoa("Joao" , "657.089.495-04");
        Pessoa pessoa4 = new Pessoa("Carlos" , "897.213.098-05");
        Pessoa pessoa5 = new Pessoa("Otto" , "768.426.656-00");

        Pessoa[] pessoas = {pessoa2,pessoa3,pessoa5,pessoa4,pessoa1};

        System.out.print("=========ANTES========\n");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getCpf() + ' ');
            //System.out.println(pessoas[i].getNome() + ' ' );
        }

        SortUtil.sort(pessoas);

        System.out.print("=========DEPOIS========\n");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getCpf() + ' ');
            //System.out.println(pessoas[i].getNome() + ' ' );
        }


        Celular celular1 = new Celular("99934000" , "TIM");
        Celular celular2 = new Celular("78546732" , "CLARO");
        Celular celular3 = new Celular("09876543" , "VIVO");
        Celular celular5 = new Celular("12345678" , "OI");
        Celular celular4 = new Celular("37465892" , "NEXTELL");

        //System.out.println(celular1.getHolder().compareToIgnoreCase(celular1.getHolder())+ ' ' );

        Celular[] celulars = {celular1,celular2,celular3,celular4,celular5};

        System.out.printf("=========ANTES========\n");
        for (Celular celular : celulars) {
            //System.out.println(celular.getNumero() + ' ');
            System.out.println(celular.getHolder() + ' ' );
        }

        SortUtil.sort(celulars);

        System.out.printf("=========DEPOIS========\n");
        for (Celular celular : celulars) {
            //System.out.println(celular.getNumero() + ' ');
            System.out.println(celular.getHolder() + ' ' );
        }

    }

}
