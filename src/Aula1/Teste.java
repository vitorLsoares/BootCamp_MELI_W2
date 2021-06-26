package Aula1;

public class Teste {
    public static void main(String[] args) {
        // Converting 'int' to 'Integer'
        int x = 123;
        Integer y = new Integer(x); // passing to constructor

        // Integer y = x;   //  or use simple assignment

        System.out.println("Before conversion: " + y.getClass().getName());

        System.out.println("After conversion: " + y.toString().getClass().getName()+" = "+ y.toString().length());
        System.out.println("After conversion (using Static method): " + Integer.toString(x).getClass().getName());
    }
}
