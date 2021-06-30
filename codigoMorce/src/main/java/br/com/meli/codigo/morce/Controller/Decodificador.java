package br.com.meli.codigo.morce.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Decodificador {

    private final char[] ABC = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?' };

    private final String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.." };

    @RequestMapping("/decodificator/{string}")
    public String decodificador(@PathVariable("string") String word){

        word = word.toLowerCase();
        String[] words = word.split(" ");
        char[] chars = {};

        String retorno = "";

        for(int k = 0; k < words.length; k++)
        {
            chars = words[k].toCharArray();
            for (int index = 0; index < chars.length; index++)
            {
                for(int j =0 ; j<ABC.length;j++){
                    if (ABC[j] == chars[index])
                    {
                        retorno = retorno + MORSE[j] + '\20';
                    }
                }
            }
            retorno = retorno + '\20' + '\20';
        }

        System.out.printf(retorno);
        return retorno;
    }

    @RequestMapping("/codificador/{string}")
    public String codificador(@PathVariable("string") String word){

        String[] words = word.split("   ");
        char[] chars = {};

        String retorno = "";
        String letraMorse =  "";

        for(int k = 0; k < words.length; k++)
        {
            chars = words[k].toCharArray();
            for (int index = 0; index < chars.length; index++)
            {

                if (chars[index] != ' ') {
                    letraMorse = letraMorse + chars[index];
                    continue;
                }

                for(int j =0 ; j<MORSE.length;j++){
                    if (MORSE[j].equals(letraMorse) )
                    {
                        retorno = retorno + ABC[j] ;
                    }
                }
                letraMorse = "";

            }
            retorno = retorno + '\20';
        }

        return retorno;
    }

}
