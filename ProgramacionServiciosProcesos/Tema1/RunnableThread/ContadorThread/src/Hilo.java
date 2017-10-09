public class Hilo extends Thread {
    Hilo(String nombre){
        setName(nombre);
        start();
    }
    public void run(){
        for(int i=0;i<500;i++) {
            System.out.println("El hilo" + getName() + " escribe " +i);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
