public class Persona extends Thread {
    private Cuchara cuchara;
    Persona(String nombre,Cuchara cuchara){
        this.setName(nombre);
        this.cuchara = cuchara;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            cuchara.comer(this.getName());
        }
    }
}
