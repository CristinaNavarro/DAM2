/*
********Autor: Cristina Navarro
********Fecha: 12/11/2017
********Asignatura: Acceso a Datos
********Ejercicio:⦁	Crea un programa java que introduzca tres registros en la tabla empleados.
********Los datos a insertar son (emp_no, apellido, profesión, director, salario, comisión y dept_no).
********Antes de insertar se deben realizar las siguientes comprobaciones:
********    - Que el departamento exista en la tabla departamentos, si no existe no se inserta
********    - que el número de empleado no exista, si existe no se inserta
********    - que el salario sea mayor que 0, en caso contrario no se inserta
********    - que el director exista en la tabla empleados, si no existe no se inserta
********        (dir es el número de empleado de su director)
********    - El apellido y el oficio no pueden ser nulos.
********    - La fecha de alta del empleado es la fecha actual
********Cuando se inserte la fila visualizar mensaje y si no se inserta visualizar el motivo
********(departamento inexistente, numero de empleado duplicado, director inexistente, etc.

*/
public class Main {

    final static int NUMEROINSERT = 3;

    public static void main(String[] args)  {
        Conexion conexion = new Conexion();
        conexion.listarEmpleados();
        conexion.listarDepartamentos();
        for(int i = 0; i < NUMEROINSERT; i++) {
            System.out.println("Insertar empleado: " +i);
            conexion.insertar();
        }
        conexion.cerrarConexion();
    }
}