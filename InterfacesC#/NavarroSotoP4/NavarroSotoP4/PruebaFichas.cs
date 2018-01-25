/* * PRÁCTICA.............: Práctica 4. 
 * * NOMBRE y APELLIDOS...: Cristina Navarro Soto
 * * CURSO y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO de la PRÁCTICA: Diseño de clases. Herencia y polimorfismo. 
 * * FECHA de ENTREGA.....: 23 de NOVIEMBRE de 2017 
 */

using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP4 {
    class PruebaFichas {
        #region Menu
        static byte menu() {
            string strOpcion = "";
            imprimirMenu();
            strOpcion = Auxiliar.controlIntroduccionNumero(strOpcion, 1);
            return Convert.ToByte(strOpcion);
        }
        #endregion

        #region Main
        static void Main(string[] args) {
            bool boValido;

            ArrayList listFichaLibro = new ArrayList();
            ArrayList listFichaLibroVol = new ArrayList();
            ArrayList listFichaRevista = new ArrayList();
            ArrayList listFichaDVD = new ArrayList();
            byte byOpcion = 0;
            do {
                boValido = true;
                byOpcion = menu();
                Console.Clear();
                switch (byOpcion) {
                    case 1:
                        listFichaLibro.Add(creaFichaLibro());
                        break;
                    case 2:
                        listFichaLibroVol.Add(creaFichaLibroVol());
                        break;
                    case 3:
                        listFichaRevista.Add(creaFichaRevista());
                        break;
                    case 4:
                        listFichaDVD.Add(creaFichaDVD());
                        break;
                    case 5:
                        if ((listFichaLibro.Count + listFichaLibroVol.Count + listFichaRevista.Count + listFichaDVD.Count) != 0) {
                            byte byOpcionConsulta = imprimirMenuConsulta();
                            switch (byOpcionConsulta) {
                                case 1:
                                    imprimirListado(listFichaLibro);
                                    break;
                                case 2:
                                    imprimirListado(listFichaLibroVol);
                                    break;
                                case 3:
                                    imprimirListado(listFichaRevista);
                                    break;
                                case 4:
                                    imprimirListado(listFichaDVD);
                                    break;
                                default:
                                    Auxiliar.imprimirAlerta("Introduzca un número entre 1 y 4");
                                    break;
                            }
                        } else {
                            Auxiliar.imprimirAlerta("No existen fichas almacenadas");
                        }
                        break;
                    case 6:
                        break;
                    default:
                        boValido = false;
                        Auxiliar.imprimirAlerta("El número debe encontrarse entre 1 y 6");
                        break;
                }
                Console.Clear();
            } while (!boValido || byOpcion != 6);
        }
        #endregion

        #region Creación del objeto FichaLibro
        static FichaLibro creaFichaLibro() {
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\t1. Ficha del libro:\n");
            //Referencia
            string strReferencia = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tReferencia: ");
            strReferencia = Auxiliar.controlIntroduccionPalabra(strReferencia, 3);
            //Título
            string strTitulo = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tTítulo: ");
            strTitulo = Auxiliar.controlIntroduccion(strTitulo, 25);
            //Número de ejemplares
            string strNumeroEjemplares = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tNúmero de ejemplares: ");
            strNumeroEjemplares = Auxiliar.controlIntroduccionNumero(strNumeroEjemplares, 1); //Se considera que una biblioteca no tendrá más de 9 libros iguales
            //Autor
            string strAutor = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tAutor: ");
            strAutor = Auxiliar.controlIntroduccionPalabra(strAutor, 25);
            //Editorial
            string strEditorial = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tEditorial: ");
            strEditorial = Auxiliar.controlIntroduccionPalabra(strEditorial, 25);
            //Envío de objeto
            return new FichaLibro(strReferencia, strTitulo, Convert.ToByte(strNumeroEjemplares), strAutor, strEditorial);
        }
        #endregion

        #region Creación del objeto FichaLibroVol
        static FichaLibroVol creaFichaLibroVol() {
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\n\t2. Ficha del libro con volumen:");
            //Referencia
            string strReferencia = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tReferencia: ");
            strReferencia = Auxiliar.controlIntroduccionPalabra(strReferencia, 3);
            //Título
            string strTitulo = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tTítulo: ");
            strTitulo = Auxiliar.controlIntroduccion(strTitulo, 25);
            //Número de ejemplares
            string strNumeroEjemplares = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tNúmero de ejemplares: ");
            strNumeroEjemplares = Auxiliar.controlIntroduccionNumero(strNumeroEjemplares, 1); //Se considera que una biblioteca no tendrá más de 9 libros iguales
            //Autor
            string strAutor = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tAutor: ");
            strAutor = Auxiliar.controlIntroduccionPalabra(strAutor, 25);
            //Editorial
            string strEditorial = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tEditorial: ");
            strEditorial = Auxiliar.controlIntroduccionPalabra(strEditorial, 25);
            //Número de volumen
            string strNumeroVolumen = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tNúmero de volumen: ");
            strNumeroVolumen = Auxiliar.controlIntroduccionNumero(strNumeroVolumen, 3); //Se considera que no existirá un número de volumen mayor que 999
            return new FichaLibroVol(strReferencia, strTitulo, Convert.ToByte(strNumeroEjemplares), strAutor, strEditorial, Convert.ToByte(strNumeroVolumen));
        }
        #endregion

        #region Creación del objeto FichaRevista
        static FichaRevista creaFichaRevista() {
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\n\t3. Ficha de la revista:");
            //Referencia
            string strReferencia = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tReferencia: ");
            strReferencia = Auxiliar.controlIntroduccionPalabra(strReferencia, 3);
            //Título
            string strTitulo = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tTítulo: ");
            strTitulo = Auxiliar.controlIntroduccion(strTitulo, 25);
            //Número de ejemplares
            string strNumeroEjemplares = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tNúmero de ejemplares: ");
            strNumeroEjemplares = Auxiliar.controlIntroduccionNumero(strNumeroEjemplares, 1); //Se considera que una biblioteca no tendrá más de 9 libros iguales
            //Número
            string strNumero = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tNúmero: ");
            strNumero = Auxiliar.controlIntroduccionNumero(strNumero, 3);//Se considera que no existirá un número mayor que 999
            //Año
            string strAnio = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tAño: ");
            strAnio = Auxiliar.controlIntroduccionNumero(strAnio, 4);
            ushort usAnio = Convert.ToUInt16(strAnio);
            if (usAnio > System.DateTime.Now.Year || usAnio < 1900) { //Se considera que en la biblioteca no se almacenarán revistas de antes del año 1900
                Auxiliar.imprimirAlerta("Fecha no válida, se autocompletará con el año actual.");
                usAnio = Convert.ToUInt16(System.DateTime.Now.Year);
            }
            //Envío de objeto
            return new FichaRevista(strReferencia, strTitulo, Convert.ToByte(strNumeroEjemplares), Convert.ToUInt16(strNumero), usAnio);
        }
        #endregion

        #region Creación del objeto FichaDVD
        static FichaDVD creaFichaDVD() {
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\n\t4. Ficha del DVD:");
            //Referencia
            string strReferencia = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tReferencia: ");
            strReferencia = Auxiliar.controlIntroduccionPalabra(strReferencia, 3);
            //Título
            string strTitulo = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tTítulo: ");
            strTitulo = Auxiliar.controlIntroduccion(strTitulo, 25);
            //Número de ejemplares
            string strNumeroEjemplares = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tNúmero de ejemplares: ");
            strNumeroEjemplares = Auxiliar.controlIntroduccionNumero(strNumeroEjemplares, 1); //Se considera que una biblioteca no tendrá más de 9 DVD iguales
            //Director
            string strDirector = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tDirector: ");
            strDirector = Auxiliar.controlIntroduccionPalabra(strDirector, 25);
            //Año
            string strAnio = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tAño: ");
            strAnio = Auxiliar.controlIntroduccionNumero(strAnio, 4);
            ushort usAnio = Convert.ToUInt16(strAnio);
            if (usAnio > DateTime.Now.Year || usAnio < 1995) { //Se considera que en la biblioteca no se almacenarán DVD de antes del año 1995
                Auxiliar.imprimirAlerta("Fecha no válida, se autocompletará con el año actual.");
                usAnio = Convert.ToUInt16(DateTime.Now.Year);
            }
            Console.Clear();
            //Número de actores
            string strNumeroActores = "";
            byte byNumeroActores = 0;
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t¿Cuántos actores va a introducir?");
            strNumeroActores = Auxiliar.controlIntroduccionNumero(strNumeroActores, 1); //Se considera 9 como la mayor cantidad de actores posible
            byNumeroActores = Convert.ToByte(strNumeroActores);
            string[] arrayActores = new string[byNumeroActores];
            for (byte i = 0; i < byNumeroActores; i++) {
                Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t\t\tActor " + (i+1) + ": ");
                string strActor = "";
                strActor = Auxiliar.controlIntroduccionPalabra(strActor, 25);
                arrayActores[i] = strActor;
            }
            return new FichaDVD(strReferencia, strTitulo, Convert.ToByte(strNumeroEjemplares), strDirector, usAnio, arrayActores);
        }
        #endregion

        #region Método que imprime el menú
        static void imprimirMenu() {
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\tGESTIÓN BIBLIOTECA\n");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\tElija el tipo de ficha a crear");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\t1. Libro");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\t2. Libro Volumen");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\t3. Revista");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\t4. Película en DVD");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\t5. Consultar Biblioteca");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\t6. SALIR");
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\n\n\tTeclee opción ");
        }
        #endregion

        #region Método que imprime el menú de la consulta
        static byte imprimirMenuConsulta() {
            string strOpcionConsulta = "";
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\tConsulta de:");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t\t1. Libro");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t\t2. Libro Volumen");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t\t3. Revista");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t\t4. DVD");
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\n\tIntroduzca la opción");
            strOpcionConsulta = Auxiliar.controlIntroduccionNumero(strOpcionConsulta, 1);
            Console.Clear();
            return Convert.ToByte(strOpcionConsulta);
        }

        static void imprimirListado(ArrayList listFicha) {
            if (listFicha.Count != 0) {
                Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t --- Listado de fichas --- \n");
                for (ushort i = 0; i < listFicha.Count; i++) {
                    Auxiliar.writeConColor(ConsoleColor.White, "\nDatos de la ficha " + (i + 1) + " / " + (listFicha.Count) + "\n");
                    Ficha ficha = (Ficha)listFicha[i];
                    ficha.imprimir();
                    Console.Write("\n\n");
                    if (i != listFicha.Count - 1) {
                        Auxiliar.pulsarTeclaContinuar();
                        Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t --- Listado de fichas --- \n");
                    }
                }
                Console.ResetColor();
                Auxiliar.pulsarTeclaContinuar();
            } else {
                Auxiliar.imprimirAlerta("No existen fichas almacenadas.");
            }
        }
        #endregion
    }
}
