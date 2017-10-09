public class Hilo implements Runnable{
    Thread t;
    Hilo(String nombre){
        t = new Thread(this);
        t.setName(nombre);
        t.start();
    }

    public void run(){
        for(int i=0;i<500;i++) {
            System.out.println("El hilo" + t.getName() + " escribe " +i);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
