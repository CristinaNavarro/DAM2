public class HiloReceptor extends Thread {


    Tuberia t;

    HiloReceptor(Tuberia t){

        this.t = t;
    }

    public void run(){
        System.out.println(t.enviarHaciaHilo());
    }
}
