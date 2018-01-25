//HE TOMADO COMO CONDICIÓN EL ORDEN DE LA LISTA DE EMBARQUE EN LUGAR DEL NÚMERO DE PASAJEROS.


public class Aeropuerto {
    private int cantidadEmbarcados;
    private int cantidadFacturados;
    private String[] listaEmbarcado;
    private final int NUMEROPRIVILEGIADOS = 20;


    Aeropuerto() {
        this.cantidadFacturados = 0;
        this.cantidadEmbarcados = 0;
        listaEmbarcado = new String[50];
    }

    int pesar(Mostrador mostrador, String pasajero) {
        synchronized (mostrador) {
            System.out.println(pasajero + " va a pesar.");
            int peso = (int) (Math.random() * 20 + 5);
            System.out.println("La maleta de " + pasajero + " pesa " + peso + " kg.");
            mostrador.ponerEnCola(pasajero);
            return peso;
        }
    }

    void facturar(Mostrador mostrador, String pasajero, int pesoMaleta) {
        synchronized (mostrador) {
            mostrador.salirDeCola(pasajero);

                listaEmbarcado[cantidadFacturados] = pasajero;
                cantidadFacturados++;

            System.out.println(pasajero + " va a facturar.");
            int importe = pesoMaleta * 10;
            System.out.println("-------------" + pasajero + " tiene que pagar " + importe + " €");
        }
    }

    synchronized void embarcar(String pasajero) {
        System.out.println(pasajero +" ya ha pagado y se dispone a embarcar");
        if(cantidadEmbarcados < NUMEROPRIVILEGIADOS) {
            while (!listaEmbarcado[cantidadEmbarcados].equals(pasajero)) {
                try {
                    System.out.println(pasajero + " se ha intentado colar al embarcar.");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        cantidadEmbarcados++;

        System.out.println(pasajero + " embarca en el avión.");
        notifyAll();
    }
}
