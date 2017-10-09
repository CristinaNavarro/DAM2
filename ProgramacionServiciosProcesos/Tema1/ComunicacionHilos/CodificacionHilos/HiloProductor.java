public class HiloProductor extends Thread {

    String cadena;
    Tuberia t;

    HiloProductor(Tuberia t) {
        this.cadena = "pache quiere hacer memes";
        this.t = t;
    }

    public void run() {
        t.recibirDesdeHilo(cadena);
    }


}
