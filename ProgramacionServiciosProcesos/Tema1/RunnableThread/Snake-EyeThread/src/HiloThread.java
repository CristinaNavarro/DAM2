public class HiloThread extends Thread {
    public void run(){
        int dado = (int) Math.floor(Math.random()*6)+1;
        System.out.println(dado);
    }
}
