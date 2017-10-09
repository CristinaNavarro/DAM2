public class HiloRunnable implements Runnable {
    Thread t;
    HiloRunnable(){
        t = new Thread(this);
        t.setName("0");
        t.start();
    }
    public void run(){
        int dado = (int) Math.floor(Math.random()*7)+1;
        System.out.println(dado);
    }
}
