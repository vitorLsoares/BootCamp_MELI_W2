package Aula2.Ex5;

import java.util.Arrays;
import java.util.Date;

public class Teste {

    public static void main(String[] args) {
        Date data = new Date(1998,8,9);
        Data aniversario = new Data(data);

        aniversario.adicionar(20,TipoCampo.DAY_OF_MONTH);




        System.out.println("aniversario = " + aniversario.getData());
    }
}
