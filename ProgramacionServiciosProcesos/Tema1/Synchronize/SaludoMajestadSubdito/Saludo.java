public class Saludo {
    boolean permiso = false;

    public synchronized void saludar(int prioridad) {

        while (!permiso) {
            try {
                if (prioridad!=10) {
                    wait();
                }else{
                    System.out.println("Buenos días súbditos.");
                    permiso = true;
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Buenos días Majestad.");
    }

}
