package Aula3.Ex1;

public class Celular implements Precedete<Celular>{

    private String numero ;
    private String holder;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Celular(String numero, String holder) {
        this.numero = numero;
        this.holder = holder;
    }

    @Override
    public int precedeA(Celular celular) {
        int retorna = -1;
        if (this.holder.compareToIgnoreCase(celular.getHolder()) > 0){
            retorna =  this.holder.compareToIgnoreCase(celular.getHolder());
        }

        return retorna;
    }
}
