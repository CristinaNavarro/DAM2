public class Main {
    public static void main(String[] args) {
        Fuente fuente = new Fuente();
        for(int i=1; i<3;i++){
            Persona persona = new Persona(fuente,"Persona "+i);
            persona.start();
        }
    }
}
