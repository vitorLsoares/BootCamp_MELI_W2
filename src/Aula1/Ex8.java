package Aula1;

import java.io.IOException;
import java.util.Scanner;

public class Ex8 {

    public static void main(String[] args) throws IOException {

        Scanner console = new Scanner(System.in);
        int interator = 0;
        Produto[] mercado = new Produto[350];

        while (true){
            System.out.println("================================\n" +
                    "BEM VINDO AO MERCADO DO MELI\n          PARA ONDE DESEJA IR?\n\n" +
                    "1 - Inserir um Produto\n" +
                    "2 - Ver o total de produtos no mercado\n" +
                    "3 - Sair\n" +
                    "================================");


            int opicao = console.nextInt();

            switch (opicao){

                //Insercao de dados
                case 1:
                    //Runtime.getRuntime().exec("clear"); como faz pra apagar o console em JAVA
                    System.out.println("Digite o código:");
                    String código = console.next();
                    System.out.println("Digite o nome:");
                    String nome = console.next();
                    System.out.println("Digite o preco:");
                    double preco = console.nextDouble();
                    System.out.println("Digite o quantidade:");
                    int quantidade = console.nextInt();
                    mercado[interator] = new Produto(código,nome,preco,quantidade);
                    interator++;
                    break;


                // Vizualizaçao do estoque
                case 2:
                    double somaPreco = 0;
                    for (int i = 0; i < mercado.length;i++){
                        if(mercado[i] != null ){
//                            System.out.println("Produto "+mercado[i].getCodigo()+ "\n"+
//                                    mercado[i].getNome()+ "\n"+
//                                    "R$"+mercado[i].getPreco()+ "\n"+
//                                    "Quantidade: "+mercado[i].getQuantidade()+ "\n\n");
                            System.out.println(mercado[i]+"\n\n");
                            somaPreco += mercado[i].getQuantidade()*mercado[i].getPreco();
                        }
                    }
                    System.out.println("Valor Total: R$"+ somaPreco);

                    break;
                default:
                    break;
            }
            if (opicao == 3){
                break;
            }

        }
    }
}
