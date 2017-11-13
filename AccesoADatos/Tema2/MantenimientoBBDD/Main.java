/*
********Autor: Cristina Navarro
********Fecha: 01/11/2017
********Asignatura:AccesoADatos
********Ejercicio:	Manejo de base de datos con DB4O.
******** La aplicación mediante un menú debe ser capaz
******** de insertar registros, eliminar y actualizarlos.
******** El contenido de la base de datos son objetos que
******** tienen EMPLEADOS Y DEPARTAMENTOS.
*/

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Creación de la base de datos
        ObjectContainer bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
                "C:\\Users\\Cristi\\Desktop\\BaseDatos\\db4o\\ArchivosFormatoYap\\empledep.yap");
        Empleados e;

        int intEleccion;
        int intSeleccionBusqueda;
        do {
            System.out.println("Elige o introduce -1 para salir: \n\n\t 0.Insertar empleado \n\t 1.Modificar empleado " +
                    "\n\t 2.Eliminar empleado");
            intEleccion = sc.nextInt();
            switch (intEleccion) {
                case 0: //Insertar
                    System.out.print("Introduce el código del empleado: ");
                    int intCodigo = sc.nextInt();
                    System.out.print("\n\nIntroduce el apellido del empleado: ");
                    String intApellido = sc.next();
                    System.out.print("\n\nIntroduce el sueldo del empleado: ");
                    int intSueldo = sc.nextInt();
                    System.out.print("\n\nIntroduce el código del departamento del empleado: ");
                    int intDepartamento = sc.nextInt();
                    e = new Empleados(intCodigo, intApellido, intSueldo, intDepartamento);
                    insertarEmpleado(bbdd, e);
                    break;
                case 1: //Modificar
                    System.out.println("Introduzca el aspecto a tener en cuenta para la búsqueda del registro a modificar: \n1. Código \n2. Apellido \n3. Sueldo \n4. Departamento");
                    intSeleccionBusqueda = sc.nextInt();
                    System.out.println("Introduzca el campo a modificar: \n1. Código \n2. Apellido \n3. Sueldo \n4. Departamento");
                    int intSeleccionModificacion = sc.nextInt();
                    eleccionBusqueda(intSeleccionBusqueda, intSeleccionModificacion, bbdd);
                    break;
                case 2: //Eliminar
                    System.out.println("Introduzca el campo por el que buscar el registro a eliminar: \n1. Código \n2. Apellido \n3. Sueldo \n4. Departamento");
                    intSeleccionBusqueda = sc.nextInt();
                    eleccionBusquedaEliminacion(intSeleccionBusqueda,bbdd);
                    break;
                default:
                    break;
            }
        } while (intEleccion != -1);
        bbdd.close();
    }

    private static void insertarEmpleado(ObjectContainer bbdd, Empleados e) {
        bbdd.store(e);
        bbdd.commit();
    }

    private static void eleccionBusqueda(int intSeleccionBusqueda, int intSeleccionModificacion, ObjectContainer bbdd) {
        Scanner sc = new Scanner(System.in);
        ObjectSet<Empleados> osEmpleados;
        Empleados e;
        switch (intSeleccionBusqueda) {
            case 1:
                System.out.print("Introduzca qué código quiere buscar: ");
                e = new Empleados(sc.nextInt(), null, 0, 0);
                osEmpleados = bbdd.queryByExample(e);
                if (osEmpleados.size() == 0) {
                    System.out.println("No se han encontrado resultados con este código");
                } else {
                    while(osEmpleados.hasNext()) {
                        Empleados eActual = osEmpleados.next();
                        eleccionModificacion(intSeleccionModificacion, eActual, bbdd);
                    }
                }
                break;
            case 2:
                System.out.print("Introduzca qué apellido quiere buscar: ");
                e = new Empleados(0, sc.next(), 0, 0);
                osEmpleados = bbdd.queryByExample(e);
                if (osEmpleados.size() == 0) {
                    System.out.println("No se han encontrado resultados con este apellido");
                } else {
                    while(osEmpleados.hasNext()) {
                        Empleados eActual = osEmpleados.next();
                        eleccionModificacion(intSeleccionModificacion, eActual, bbdd);
                    }
                }
                break;
            case 3:
                System.out.print("Introduzca qué sueldo quiere buscar: ");
                e = new Empleados(0, null, sc.nextInt(), 0);
                osEmpleados = bbdd.queryByExample(e);
                if (osEmpleados.size() == 0) {
                    System.out.println("No se han encontrado resultados con este sueldo");
                } else {
                    while(osEmpleados.hasNext()) {
                        Empleados eActual = osEmpleados.next();
                        eleccionModificacion(intSeleccionModificacion, eActual, bbdd);
                    }
                }
                break;
            case 4:
                System.out.print("Introduzca qué departamento quiere buscar: ");
                e = new Empleados(0, null, 0, sc.nextInt());
                osEmpleados = bbdd.queryByExample(e);
                if (osEmpleados.size() == 0) {
                    System.out.println("No se han encontrado resultados con este apellido");
                } else {
                    while(osEmpleados.hasNext()) {
                        Empleados eActual = osEmpleados.next();
                        eleccionModificacion(intSeleccionModificacion, eActual, bbdd);
                    }
                }
                break;
            default:
                System.out.println("Ha introducido un valor incorrecto en el campo a buscar.");
        }
    }

    private static void eleccionModificacion(int intSeleccionModificacion, Empleados eActual, ObjectContainer bbdd) {
        Scanner sc = new Scanner(System.in);
        switch (intSeleccionModificacion) {
            case 1:
                System.out.print("Introduce el nuevo código: ");
                eActual.setCodigo(sc.nextInt());
                bbdd.store(eActual);
                bbdd.commit();
                break;
            case 2:
                System.out.print("Introduce el nuevo apellido: ");
                eActual.setApellido(sc.next());
                bbdd.store(eActual);
                bbdd.commit();
                break;
            case 3:
                System.out.print("Introduce el nuevo sueldo: ");
                eActual.setSueldo(sc.nextInt());
                bbdd.store(eActual);
                bbdd.commit();
                break;
            case 4:
                System.out.print("Introduce el nuevo departamento: ");
                eActual.setDepartamento(sc.nextInt());
                bbdd.store(eActual);
                bbdd.commit();
                break;
            default:
                System.out.print("Ha introducido un valor incorrecto en el campo a modificar");
        }
    }

    private static void eleccionBusquedaEliminacion(int intSeleccionBusqueda, ObjectContainer bbdd) {
        Scanner sc = new Scanner(System.in);
        ObjectSet<Empleados> osEmpleados;
        Empleados e;
        switch (intSeleccionBusqueda) {
            case 1:
                System.out.print("Introduzca qué código tendrán los registros a eliminar: ");
                e = new Empleados(sc.nextInt(), null, 0, 0);
                osEmpleados = bbdd.queryByExample(e);
                if (osEmpleados.size() == 0) {
                    System.out.println("No se han encontrado resultados con este código");
                } else {
                    while(osEmpleados.hasNext()) {
                        Empleados eActual = osEmpleados.next();
                        bbdd.delete(eActual);
                    }
                    bbdd.commit();
                }
                break;
            case 2:
                System.out.print("Introduzca qué apellido quiere buscar: ");
                e = new Empleados(0, sc.next(), 0, 0);
                osEmpleados = bbdd.queryByExample(e);
                if (osEmpleados.size() == 0) {
                    System.out.println("No se han encontrado resultados con este apellido");
                } else {
                    while(osEmpleados.hasNext()) {
                        Empleados eActual = osEmpleados.next();
                        bbdd.delete(eActual);
                    }
                    bbdd.commit();
                }
                break;
            case 3:
                System.out.print("Introduzca qué sueldo quiere buscar: ");
                e = new Empleados(0, null, sc.nextInt(), 0);
                osEmpleados = bbdd.queryByExample(e);
                if (osEmpleados.size() == 0) {
                    System.out.println("No se han encontrado resultados con este sueldo");
                } else {
                    while(osEmpleados.hasNext()) {
                        Empleados eActual = osEmpleados.next();
                        bbdd.delete(eActual);
                    }
                    bbdd.commit();
                }
                break;
            case 4:
                System.out.print("Introduzca qué departamento quiere buscar: ");
                e = new Empleados(0, null, 0, sc.nextInt());
                osEmpleados = bbdd.queryByExample(e);
                if (osEmpleados.size() == 0) {
                    System.out.println("No se han encontrado resultados con este apellido");
                } else {
                    while(osEmpleados.hasNext()) {
                        Empleados eActual = osEmpleados.next();
                        bbdd.delete(eActual);
                    }
                    bbdd.commit();
                }
                break;
            default:
                System.out.println("Ha introducido un valor incorrecto en el campo a buscar.");
        }
    }

}
