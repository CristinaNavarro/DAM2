public class HiloThread extends Thread {
    HiloThread(String nombre){
        setName(nombre);
    }
    public void run(){
        System.out.println(getName());
    }
}
