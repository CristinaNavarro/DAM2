import java.util.ArrayList;

public class Cuchara {
    private ArrayList<String> ronda = new ArrayList<>();
    private boolean haComido = false;
    int contador = 0;
    String anterior = "";
    public synchronized void comer(String nombre){
        //System.out.println("Intenta comer "+ nombre);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         do{
            try {
                if (ronda.contains(nombre) || anterior.equals(nombre)) {
                    haComido = true;
                    wait();
                } else {
                    ronda.add(nombre);
                    contador++;
                    haComido = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (haComido);

            anterior = nombre;
            System.out.println(nombre + " ha comido");
        if (contador == 3){
            System.out.println(" --- ");
            ronda.removeAll(ronda);
            contador = 0;
        }
            notifyAll();

    }
}
