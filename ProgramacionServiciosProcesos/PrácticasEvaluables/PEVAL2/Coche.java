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
public class Coche implements Runnable {

    //Atributos
    private Thread coche;
    private Parking parking;
    private int intEstado;

    //Constructor
    Coche(Parking parking, String strNombre) {
        this.coche = new Thread(this);
        this.parking = parking;
        this.coche.setName(strNombre);
        this.intEstado = -2;  //estado del coche respecto al párking: -2 fuera del parking  -1 dentro del parking  0-10 prioridad de lavado
        this.coche.start();
    }

    //Getter&Setter
    public int getIntEstado() {
        return this.intEstado;
    }

    public String getNombre() {
        return this.coche.getName();
    }

    public void setIntEstado(int intEstado) {
        this.intEstado = intEstado;
    }


    //Métodos
    //run del hilo coche, llamará a los métodos del párking
    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 10000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.parking.peticionEntradaParking(this);

        if (this.intEstado == -1) {
            int intAparcamientoDecidido;
            do {
                intAparcamientoDecidido = this.parking.decidirAparcamiento();
            } while (!parking.estaLibre(intAparcamientoDecidido, this));
            this.parking.aparcar(this, intAparcamientoDecidido);
            this.parking.lavarCocheOperario(this);
        }
    }


}
