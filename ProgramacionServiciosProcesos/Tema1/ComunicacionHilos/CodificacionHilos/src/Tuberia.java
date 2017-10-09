import java.util.ArrayList;

public class Tuberia {

    ArrayList<Integer> listaLetras = new ArrayList<>();
    String original;
    String codificado;

    Tuberia(){
        this.original = "";
        this.codificado = "nohaactuadoelotrohilo";
    }

    public void recibirDesdeHilo(String c){
        this.original = c;
        for(int i=0; i<c.length();i++){
            this.codificado += (char)(((int)c.charAt(i))+3);
        }
    }

    public String enviarHaciaHilo(){
        return this.codificado;
    }
}
