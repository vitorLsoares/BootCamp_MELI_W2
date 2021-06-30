package Teoria.Generics;

import Teoria.Anuncios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problema {

    public static void main(String[] args) {
//        List <String> lista = new ArrayList();
//
//        lista.add(new Double(3));
//        lista.add(new Integer(3));
//        lista.add(new String("problema"));
//        lista.add(new Object());
//
//        for (int i = 0; i<lista.size(); i++){
//            if (lista.get(i) instanceof Integer){
//
//            }
//            if (lista.get(i) instanceof Double){
//
//            }
//        }
        Anuncios[] anuncios ={new Anuncios("XBox",15),

        };

        List<Anuncios> lista = Arrays.asList(anuncios);

        lista.sort((o1,o2) -> Integer.compare(o1.getNumVendas(),o2.getNumVendas())); //Lambda

//        lista.sort(new Comparator<Anuncios>() {
//            @Override
//            public int compare(Anuncios o1, Anuncios o2) {
//                return Integer.compare(o1.getNumVendas(),o2.getNumVendas());
//            }
//        });

        System.out.println("Lista Sorter = " + Arrays.toString(lista.toArray()));


    }
}
