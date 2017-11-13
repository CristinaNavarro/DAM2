/*
********Autor: Cristina Navarro
********Fecha: 13/11/2017
********Asignatura: Acceso a Datos
********Ejercicio:	Crea una Base de datos en MySQL de nombre UNIDAD2, con las tablas siguientes:
********PRODUCTOS:
********⦁	ID numérico, Clave Primaria
********⦁	DESCRIPCION varchar(50), no nulo
********⦁	STOCKACTUAL numérico
********⦁	STOCKMINIMO numérico
********⦁	PVP numérico
********CLIENTES:
********⦁	ID numérico, clave primaria
********⦁	NOMBRE varchar(50), no nulo
********⦁	DIRECCIÓN varchar(50)
********⦁	POBLACIÓN varchar(50)
********⦁	TELEF varchar(20)
********⦁	NIF varchar(10)
********VENTAS:
********⦁	IDVENTA numérico, clave primaria
********⦁	FECHA VENTA no nulo
********⦁	IDCLIENTE numérico, Cclave ajena a CLIENTES
********⦁	IDPRODUCTO numérico, clave ajena a PRODUCTOS
********⦁	CANTIDAD numérico
********⦁	Un cliente puede tener muchas ventas

********Una vez creadas, haz un programa Java que llene las tablas PRODUCTOS y CLIENTES (los datos a insertar se definen e el propio programa).
********Una vez rellenas, visualiza los datos insertados y el número de filas que se han insertado en cada tabla.
********Se pueden crear las tablas y métodos que se crean convenientes.
*/
public class Main {


    public static void main(String[] args)  {
        Conexion conexion = new Conexion();
        conexion.insertarClientes();
        conexion.insertarProductos();
        conexion.visualizarCliente();
        conexion.visualizarProducto();
        conexion.cerrarConexion();
    }
}