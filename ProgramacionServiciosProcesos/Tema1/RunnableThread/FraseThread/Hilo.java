public class Hilo extends Thread {
    Hilo(String nombre){
        setName(nombre);
    }

    public void run(){
        System.out.println("Hola, el mundo es de color de " +getName());
    }
}
