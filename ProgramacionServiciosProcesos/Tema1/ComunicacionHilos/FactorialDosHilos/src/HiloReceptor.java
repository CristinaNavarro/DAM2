public class HiloReceptor extends Thread {
    Tuberia t;
    int numero;
    HiloReceptor(Tuberia t){
        this.t = t;
        this.numero = 0;
    }

    public void run(){
        this.numero = t.enviarHaciaHilo();
        hallarFactorial();
    }

    public void hallarFactorial(){
        long total=1;
        System.out.println("El factorial de " +this.numero +" es: ");
        while(this.numero>=2){
            total *= this.numero;
            this.numero--;
        }
        System.out.println(total);
    }
}
