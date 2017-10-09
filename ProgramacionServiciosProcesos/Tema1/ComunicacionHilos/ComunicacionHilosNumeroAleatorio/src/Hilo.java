public class Hilo extends Thread {

    Tuberia t;

    Hilo(Tuberia t, String n){
        this.t =t;
        this.setName("Tuberia " +n);
    }

    public void run(){
        for(int i=0;i<100;i++) {
            int numero = (int) Math.floor(Math.random() * 10);
            t.lanzarATuberia(numero, getName());
            try{
                sleep(500);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
