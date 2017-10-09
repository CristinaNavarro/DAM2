public class HiloRunnable implements Runnable {
    Thread t;
    HiloRunnable(String nombre){
        t = new Thread(this);
        t.setName(nombre);
        t.start();
    }

    public void run(){
        System.out.println(t.getName() +(int)Math.floor(Math.random()*10));
    }
}
