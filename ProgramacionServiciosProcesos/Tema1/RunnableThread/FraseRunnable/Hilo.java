public class Hilo implements Runnable {
    Thread t;
    public Hilo(String color){
        t = new Thread(this);
        t.setName(color);
    }

    public void run(){
        System.out.println("Hola, el mundo es de color de " +t.getName());
    }
}
