public class Pasajero extends Thread {

    private Mostrador mostrador;
    private Aeropuerto aeropuerto;

    Pasajero(int numeroPasajero, Mostrador mostrador, Aeropuerto aeropuerto) {
        setName("Pasajero " + numeroPasajero);
        this.mostrador = mostrador;
        this.aeropuerto = aeropuerto;
    }

    @Override
    public void run() {
        System.out.println(getName() + " llega al aeropuerto.");
        int peso;
        peso = aeropuerto.pesar(mostrador, this.getName());
        aeropuerto.facturar(mostrador, this.getName(), peso);
        aeropuerto.embarcar(this.getName());
    }
}
