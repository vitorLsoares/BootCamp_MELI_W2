package Aula2.Ex6;

import org.jetbrains.annotations.Contract;

public class StringUtil {

    public static String rpad(String s, char c, int n){
        return String.format("%-" + n + "s", s).replace(' ',c);
    }
    public static String lpad(String s, char c, int n){
        return String.format("%" + n + "s", s).replace(' ',c);
    }
    public static String ltrim(String s){
        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return s.substring(i);
    }

    public static String rtrim(String s){

        int i = s.length()-1;
        while (i > 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        return s.substring(0,i+1);
    }

    @Contract(pure = true)
    public static String trim(String s){
        return s.replaceAll("^\\s+|\\s+$", "");
    }

    public static int indexOfN(String s, char c, int n){

        int count = 0 , counter = 0;

        for (char f : s.toCharArray()){

            if( f == c){
                count++;
            }
            if (count == n) {
                return counter;
            }
            if(f != ' ')  counter++ ;
        }

        return -1;
    }

}
