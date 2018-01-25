
public class Main {
    public static void main(String[] args) {
        Mostrador mostrador = new Mostrador();
        Aeropuerto aeropuerto = new Aeropuerto();
        for(int i = 0; i < 50; i++) {
            Pasajero pasajero = new Pasajero(i,mostrador,aeropuerto);
            pasajero.start();
        }
    }


}
