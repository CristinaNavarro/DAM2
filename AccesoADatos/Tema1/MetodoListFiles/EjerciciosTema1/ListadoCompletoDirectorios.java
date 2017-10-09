package EjerciciosTema1;

/*
	Modificar el programa anterior para que liste
todo el árbol de directorios, en el caso que tenga
más directorios en su interior.

 */
import java.io.File;

public class ListadoCompletoDirectorios
{

    public static void main(String[] args)
    {
        File f;
        File[] paths;
        try
        {
            f = new File("C:\\Users\\Cristi\\Desktop\\A");
            paths = f.listFiles();
            listar(paths);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void listar(File[] paths)
    {
        for(File path:paths)
        {
            System.out.println(path.getName());
            if(path.isDirectory())
            {
                listar(path.listFiles());
            }
        }
    }
}

