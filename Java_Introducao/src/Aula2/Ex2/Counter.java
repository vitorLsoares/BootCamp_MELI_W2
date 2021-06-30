package Aula2.Ex2;

public class Counter {

    private double count;

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public Counter(double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "count=" + count +
                '}';
    }

    public void incrementar(double incremantador){
        this.setCount(this.count + incremantador);
    }

    public void decrementar(double decrementador){
        this.setCount(this.count + decrementador);
    }
}
