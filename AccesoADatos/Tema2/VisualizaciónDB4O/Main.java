import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {
    public static void main(String[] args) {
        ObjectContainer bbdd = Db4oEmbedded.openFile("C:\\Users\\Cristi\\Desktop\\BaseDatos\\db4o\\ArchivosFormatoYap\\empledep.yap");
        System.out.println("Situación actual de la BBDD:");
        Empleados eQuery = new Empleados(0,null,0,0);
        ObjectSet<Empleados> listaEmpleados = bbdd.queryByExample(eQuery);
        System.out.println(listaEmpleados.size());
        if (listaEmpleados.size() == 0) {
            System.out.println("No haaaaaay");
        } else {
            while(listaEmpleados.hasNext()){
                Empleados e = listaEmpleados.next();
                System.out.println(e.getCodigo()+" " +e.getApellido() +" " +e.getSueldo() + " " +e.getDepartamento());
            }
        }
        bbdd.close();
    }
}
