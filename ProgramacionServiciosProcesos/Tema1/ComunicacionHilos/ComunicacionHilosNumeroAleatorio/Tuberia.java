public class Tuberia {
    private int total;

    Tuberia(){
        this.total = 0;
    }

    void lanzarATuberia(int numero, String nombre){
        System.out.println("El hilo " +nombre +" suma " +numero +" = " +(total+=numero));
    }

}
