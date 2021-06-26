package Aula1;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex7 {

    public static void main(String[] args) {

        DecimalFormat df2 = new DecimalFormat("#.##");
        double crescimentoAnualX = 1.48;
        double crescimentoAnualY = 0.32;
        double valorInicialEmpresaX = 1130000.0;
        double valorInicialEmpresaY = 18400000.0;
        double UM_MILHAO = 1000000;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 01);
        //c.set(Calendar.YEAR, 2021);
        Integer i = 0, year = 2021;

        while(valorInicialEmpresaX <= valorInicialEmpresaY){


            valorInicialEmpresaX += valorInicialEmpresaX*(crescimentoAnualX/365);
            valorInicialEmpresaY += valorInicialEmpresaY*(crescimentoAnualY/365);

            c.set(Calendar.DAY_OF_YEAR, i);
            Date data = c.getTime();

            c.set(Calendar.YEAR, year);

//            System.out.println("Empresa X - "+sdf.format(data)+" - Valor da empresa:"+ String.format("%.2f",(valorInicialEmpresaX/UM_MILHAO)) +'m');
//            System.out.println("Empresa Y - "+sdf.format(data)+" - Valor da empresa:"+ String.format("%.2f",(valorInicialEmpresaY/UM_MILHAO)) +"m\n\n");

            System.out.println("Empresa X - "+sdf.format(data)+" - Valor da empresa:"+ df2.format((valorInicialEmpresaX/UM_MILHAO)) +'m');
            System.out.println("Empresa Y - "+sdf.format(data)+" - Valor da empresa:"+ df2.format((valorInicialEmpresaY/UM_MILHAO)) +"m\n\n");

            if(i%365 == 0){
                year++;
            }

            i++;
        }

    }
}
