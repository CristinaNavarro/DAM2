public class Main {
    public static void main(String[] args) {
        Tuberia t = new Tuberia();
        Jugador jugador1 = new Jugador("Jugador 1", t);
        Jugador jugador2 = new Jugador("Jugador 2", t);
        Jugador jugador3 = new Jugador("Jugador 3", t);
        Jugador jugador4 = new Jugador("Jugador 4", t);

        jugador1.start();
        jugador2.start();
        jugador3.start();
        jugador4.start();

    }


}
