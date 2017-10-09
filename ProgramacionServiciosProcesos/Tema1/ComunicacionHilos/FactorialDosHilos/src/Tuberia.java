public class Tuberia {

    int numero;

    Tuberia() {
        this.numero = 0;
    }

    public int enviarHaciaHilo(){
        return this.numero;
    }

    public void recibirDesdeHilo(int numero) {
        this.numero = numero;
    }
}
