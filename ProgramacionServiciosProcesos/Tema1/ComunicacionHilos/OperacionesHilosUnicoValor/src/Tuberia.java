public class Tuberia {
    double total;

    Tuberia(){
        this.total = 0;
    }

    public void operar(int numero, String nombre){
        switch (nombre){
            case "suma":
                System.out.println("El hilo suma " +numero +" = " +(total+=numero));
                break;
            case "resta":
                System.out.println("El hilo resta " +numero +" = " +(total-=numero));
                break;
            case "multiplicacion":
                System.out.println("El hilo multiplica " +numero +" = " +(total*=numero));
                break;
            default:
                System.out.println("El hilo divide " +numero +" = " +(total/=numero));
                break;
        }
    }
}
