public class Mostrador {


    private String[] listadoMostrador;
    private int cantidadClientes;
    private int cantidadEmbarcados;
    private int cantidadFacturados;


    Mostrador() {
        listadoMostrador = new String[50];
        cantidadClientes = 0;
        this.cantidadEmbarcados = 0;

    }

    synchronized void ponerEnCola(String pasajero) {
        System.out.println(pasajero + " se pone en cola para facturar en el puesto " + cantidadClientes + ".");
        listadoMostrador[cantidadClientes] = pasajero;
            while (!listadoMostrador[cantidadClientes].equals(pasajero)) {
                try {
                    System.out.println(pasajero + " ha intentado colarse en la cola de facturación. El siguiente es " + listadoMostrador[cantidadClientes]);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        cantidadClientes++;
        notifyAll();
    }

    synchronized void salirDeCola(String pasajero) {
        while (!listadoMostrador[cantidadFacturados].equals(pasajero)) {
            try {
                System.out.println(pasajero + " se ha intentado colar al facturar.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cantidadFacturados++;
        notifyAll();




    }
}
