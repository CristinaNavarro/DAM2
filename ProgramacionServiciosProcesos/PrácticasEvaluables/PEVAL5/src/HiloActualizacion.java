public class HiloActualizacion extends Thread {

    private boolean conectado;

    HiloActualizacion() {
        new Thread(this);
        conectado = true;
    }

    @Override
    public void run() {
        while (conectado) {
            try {
                Thread.sleep(25000);
                if (conectado) {
                    InterfazClientePOP3.pulsarBoton();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /*
     * Cambia el valor de conectado para finalizar la ejecución del hilo
     */
    boolean cambiarModo() {
        conectado = !conectado;
        return conectado;
    }
}
