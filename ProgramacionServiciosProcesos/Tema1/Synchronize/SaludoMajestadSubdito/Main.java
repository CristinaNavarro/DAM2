public class Main {
    public static void main(String[] args) {
        Saludo saludo = new Saludo();
        Persona majestad = new Persona(10,saludo);
        for(int i = 0; i < 5; i++){
            Persona subdito = new Persona(5,saludo);
            subdito.start();
        }
        majestad.start();
    }
}
