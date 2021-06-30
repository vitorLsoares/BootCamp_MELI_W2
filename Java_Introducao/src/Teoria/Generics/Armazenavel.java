package Teoria.Generics;

import java.util.List;

public interface Armazenavel<T,U> {

        void salva(T t);
        List<T> getList();
        T get(U id);
}
