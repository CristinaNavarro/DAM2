package EjerciciosTema1;

/*
	Realiza un programa Java que reciba un nombre de directorio y
posteriormente borre el directorio junto a todo su contenido.

 */

import java.io.File;

public class EliminarDirectorio {

    public static void main(String[] args)
    {
        File f;
        File[] paths;
        try
        {
            f =  new File("C:\\Users\\Cristi\\Desktop\\A");
            paths = f.listFiles();
            while(f.listFiles().length!=0) {
                listar(paths);
            }
            f.delete();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void listar(File[] paths)
    {
        for(File path:paths)
        {
            if(path.isDirectory()) {
                if (path.listFiles().length>0) {
                    listar(path.listFiles());
                } else {
                    path.delete();
                }
            }else{
                path.delete();
            }
        }
    }
}
