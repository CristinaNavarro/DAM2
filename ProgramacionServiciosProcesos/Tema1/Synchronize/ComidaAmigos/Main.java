public class Main {
    public static void main(String[] args) {
        String[] listaNombres = {"Wellington","Napoleon","Agustina"};
        Cuchara cuchara = new Cuchara();
        for(String nombre : listaNombres){
            Persona persona = new Persona(nombre,cuchara);
            persona.start();
        }
    }
}
