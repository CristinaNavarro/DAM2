/*
********Autor: Cristina Navarro
********Fecha: 28/10/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio: Programa sobre sincronización de hilos los
********cuales actuarán como coches que aparcan en un párking,
********en el que serán lavados y encerados, y tras esto,
********abandonarán el párking. El orden de lavado está
********impuesto por el orden en el que se ha aparcado.
********Si el párking está completo, no podrán entrar
********más coches.
*/
public class Parking {

    //Atributos
    private int intCochesDentro;
    private int intCochesAparcados;
    private final int intNUMEROPLAZAS = 10; //Número total de plazas del párking
    private Coche[] plazas;

    //Constructor
    Parking() {
        this.intCochesDentro = 0;
        this.intCochesAparcados = 0;
        this.plazas = new Coche[intNUMEROPLAZAS];
    }

    //Métodos
    //el coche llega al párking para preguntar si está completo
    synchronized void peticionEntradaParking(Coche coche) {
        if (intCochesDentro < intNUMEROPLAZAS) {
            System.out.println("\n---------->NUEVO CLIENTE: " + coche.getNombre() + "\n");
            coche.setIntEstado(-1);
            intCochesDentro++;
        } else {
            System.out.println("\n>>PÁRKING COMPLETO: El cliente " + coche.getNombre() + " se marcha por no tener plazas libres.");
        }

    }

    //el coche decide una plaza de las ofrecidas por el párking
    synchronized int decidirAparcamiento() {
        return (int) (Math.random() * intNUMEROPLAZAS);
    }

    //si la plaza está libre, se procederá a aparcar
    synchronized boolean estaLibre(int intPlaza, Coche coche) {
        if (this.plazas[intPlaza] == null) {
            coche.setIntEstado(this.intCochesAparcados);
            this.intCochesAparcados++;
            return true;
        }
        return false;
    }

    //busca una plaza libre para cada coche que ha podido entrar al párking
    void aparcar(Coche coche, int intPlazaDeseada) {
        plazas[intPlazaDeseada] = coche;
        System.out.println("\nEl coche " + coche.getNombre() + " ha aparcado en la plaza " + intPlazaDeseada/* + " con prioridad " + coche.getIntEstado()*/ + "\n");
    }

    //reestablece la prioridad de lavado de cada coche
    private synchronized void modificarPrioridades() {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null) { //asegurar que no sea null para no provocar nullpointerexception
                if (plazas[i].getIntEstado() != 0) {
                    plazas[i].setIntEstado(plazas[i].getIntEstado() - 1);
                } else {
                    this.intCochesDentro--;
                    this.intCochesAparcados--;
                    plazas[i] = null;
                }
            }
        }
    }

    //inversión de tiempo en lavado del coche
    synchronized void lavarCocheOperario(Coche coche) {
        if (coche != null) {
            while (coche.getIntEstado() != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long espera = (long) (Math.random() * 2000) + 1000;
            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            encerarCocheOperario(coche);
            notifyAll();
        }
    }

    //tiempo de encerado del coche y salida del párking
    private synchronized void encerarCocheOperario(Coche coche) {
        long espera = (long) (Math.random() * 2000) + 1000;
        try {
            Thread.sleep(espera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        modificarPrioridades();
        System.out.println("\n<---------" + coche.getNombre() + ", ya lavado, se fue.\n");
        notifyAll();

    }
}
