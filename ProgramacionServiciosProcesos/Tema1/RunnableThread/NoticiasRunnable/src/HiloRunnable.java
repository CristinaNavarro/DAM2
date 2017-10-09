public class HiloRunnable implements Runnable {
    Thread t;
    HiloRunnable(String noticia){
        t = new Thread(this);
        t.setName(noticia);
        t.start();
    }

    public void run(){
        System.out.println(t.getName());
    }
}
