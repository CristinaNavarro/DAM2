public class Hilo extends Thread {
    Tuberia t;
    Hilo(Tuberia t, String n){
        this.t = t;
        setName(n);
    }

    public void run(){
        for(int i=0;i<100;i++) {
            int numero = (int) Math.floor((Math.random() * 10)+1);
            t.operar(numero, getName());
        }
    }
}
