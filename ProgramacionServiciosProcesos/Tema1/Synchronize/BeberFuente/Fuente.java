public class Fuente {
    public synchronized void beber(String persona) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("La persona que está bebiendo de la fuente es: " + persona);
    }
}
