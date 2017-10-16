public class Jugador extends Thread {

    int puntos;
    long tiempo;
    Tuberia t;

    public Jugador(String nombre, Tuberia t) {
        this.puntos = 0;
        this.tiempo = 0;
        this.setName(nombre);
        this.t = t;
    }

    public void run() {
        int dado;
        tiempo = System.currentTimeMillis();
        for(int i = 1; i <= 20; i++){
            dado = tirarDado();
            if(dado == 6) this.puntos++;
            System.out.println("El jugador " + getName() + " ha sacado un " + dado + " en la tirada " + i + " con un total de " + this.puntos + " puntos");
        }
        this.tiempo = System.currentTimeMillis() - this.tiempo;
        t.recibirEnTuberia(this.getName(),this.puntos, this.tiempo);
    }

    public int tirarDado() {
        try {
            sleep((long) (Math.random()*3000)+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (int) ((Math.random()*6)+1);
    }

}
