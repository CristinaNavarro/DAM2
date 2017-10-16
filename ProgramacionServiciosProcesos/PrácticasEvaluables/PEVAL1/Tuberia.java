import java.util.ArrayList;

public class Tuberia {

    ArrayList<String> listaNombres = new ArrayList<>();
    ArrayList<Integer> listaPuntuacion = new ArrayList<>();
    ArrayList<Long> listaTiempo = new ArrayList<>();
    String ganador;

    public void recibirEnTuberia(String nombre, int puntos, long tiempo) {
        listaNombres.add(nombre);
        listaPuntuacion.add(puntos);
        listaTiempo.add(tiempo);
        if(this.listaPuntuacion.size() > 3){
            this.imprimirMarcador();
            this.decidirGanador();
            System.out.println("El ganador es " + this.ganador);
        }
    }

    public void imprimirMarcador() {
        for(int i = 0; i < listaPuntuacion.size(); i++){
            System.out.println(listaNombres.get(i) + " -- " + listaPuntuacion.get(i) + " en un tiempo de " +listaTiempo.get(i) +"ms");
        }
    }

    public void decidirGanador() {
        this.ganador = listaNombres.get(0);
        for(int i = 1; i < listaPuntuacion.size(); i++){
            if(listaPuntuacion.get(0) < listaPuntuacion.get(i)) {
                listaPuntuacion.set(0,listaPuntuacion.get(i));
                this.ganador = listaNombres.get(i);
            }else if(listaPuntuacion.get(0) < listaPuntuacion.get(i)){
                if(listaTiempo.get(0) < listaTiempo.get(i)){
                    listaTiempo.set(0,listaTiempo.get(i));
                }
            }
        }
    }


}
