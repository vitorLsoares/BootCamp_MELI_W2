package Aula3.Ex1;

import java.util.List;
import java.util.Comparator;

public class SortUtil {

    // O método nao me retora um valor Precedente apenas Precedente <T>
    //public static <T> void sort (List<Precedente <T>> arr[])
    public static void sort(Precedete array[]){

        int n = array.length;
        while (n > 0)
        {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++)
            {
                if (array[currentIndex - 1].precedeA( array[currentIndex] ) > 0)
                {
                    Precedete temp = array[currentIndex - 1];
                    array[currentIndex - 1] = array[currentIndex];
                    array[currentIndex] = temp;
                    lastModifiedIndex = currentIndex;
                }
            }
            n = lastModifiedIndex;
        }

    }

}
