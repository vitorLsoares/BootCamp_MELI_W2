package Aula2.Ex5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {

    private GregorianCalendar data;
    private Date manipulador;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public Data(Date data) {
        this.data = new GregorianCalendar();
        this.data.setTime(data);
        this.manipulador = data;
    }

    public Data(String data){
        try {
            this.data = new GregorianCalendar();
            this.data.setTime(formatter.parse(data));
        }catch (ParseException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Date getData() {
        return this.manipulador;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public Integer dataValidation(String data){
        try {
            return comparar(formatter.parse(data));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    private int comparar(Date date){
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        return data.compareTo(c);
    }


    public void incrementadorDia(int quantidade){
        adicionar(quantidade, Calendar.DAY_OF_MONTH);
    }

    private void adicionar( int quantidade, int tipoCampo){
        data.add(tipoCampo,quantidade);
        manipulador = data.getTime();
    }

    public void adicionar( int quantidade, TipoCampo tipoCampo){
        data.add(tipoCampo.ordinal(),quantidade);
        manipulador = data.getTime();
    }

    @Override
    public String toString() {
        return "Data: " + formatter.format(manipulador);
    }

}
