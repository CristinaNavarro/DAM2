public class HiloThread extends Thread {
    HiloThread(String nombre){
        setName(nombre);
    }


    public void run() {
        System.out.println(getName() +": " +(int)Math.floor(Math.random()*10));
    }
}
