public class HiloProductor extends Thread {
    Tuberia t;
    HiloProductor(Tuberia t){
        this.t = t;
    }

    public void run() {
        t.recibirDesdeHilo((int) Math.floor(Math.random()*10)+1);
    }
}
