public class Persona extends Thread {
    Fuente fuente;
    Persona(Fuente fuente, String nombre){
        this.setName(nombre);
        this.fuente = fuente;
    }

    public void run(){
        for(int i=0;i<10;i++){
            fuente.beber(this.getName());
        }
    }
}
