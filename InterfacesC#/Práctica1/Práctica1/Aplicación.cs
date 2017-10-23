/* 
 * * PRÁCTICA.............: Práctica 1. 
 * * NOMBRE y APELLIDOS...: Cristina Navarro Soto
 * * CURSO y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO de la PRÁCTICA: Diseño de clases. Herencia y polimorfismo. 
 * * FECHA de ENTREGA.....: 23 de octubre de 2017 
 */

using System;

namespace Práctica1 {

    class Aplicación {

        static void Main(string[] args) {
            Tv televisor = comprarTelevisor();
            ConsoleKeyInfo tecla;
            bool boValido;
            byte byCambioCanal = 0;

            do {
                imprimirMenu(televisor);
                tecla = Console.ReadKey();

                switch (tecla.Key) {
                    case ConsoleKey.P:
                        televisor.pulsarEncendido();
                        imprimirMenu(televisor);
                        break;
                    case ConsoleKey.UpArrow:
                        televisor.subirVolumen();
                        imprimirMenu(televisor);
                        break;
                    case ConsoleKey.DownArrow:
                        televisor.bajarVolumen();
                        imprimirMenu(televisor);
                        break;
                    case ConsoleKey.RightArrow:
                        do {
                            imprimirMenu(televisor);
                            boValido = false;

                            if (televisor.getBoEncendido()) {
                                Console.Write("\n\nIntroduzca un canal entre 0 y 99 y confírmelo pulsando ENTER: ");
                                string strCadena = Console.ReadLine();
                                boValido = esNumeroValido(strCadena, "Byte");

                                if (boValido) {
                                    byCambioCanal = Convert.ToByte(strCadena);

                                    if (televisor.getBoEncendido() && byCambioCanal < 100) {
                                        televisor.ponerCanal(byCambioCanal);
                                    } else {
                                        esNumeroValido("-1", "Nopermitido");
                                        boValido = false;
                                    }
                                }
                            } else {
                                Console.Beep();
                                Console.Beep();
                                alertaExcepcion("Por favor, encienda el televisor para modificar el volumen o el canal.");
                                Console.Clear();
                                boValido = true;
                            }

                        } while (!boValido);
                        break;
                    case ConsoleKey.LeftArrow:
                        televisor.cambiarCanalAnterior();
                        imprimirMenu(televisor);
                        break;
                    case ConsoleKey.I:
                        televisor.informacionTecnica();
                        imprimirMenu(televisor);
                        break;
                    case ConsoleKey.Escape:
                        break;
                    default:
                        break;
                }
            } while (tecla.Key != ConsoleKey.Escape);
        }

        private static Tv comprarTelevisor() {
            string strMarca;
            float floPulgadas = 0;
            float floConsumo = 0;
            float floPrecio = 0;
            bool boValido = false;
            string strCadena;

            do {
                Console.Clear();
                Console.Write("Introduzca la marca de su nuevo televisor: \n\t->");
                strMarca = Console.ReadLine();
                if (String.IsNullOrWhiteSpace(strMarca)) {

                    alertaExcepcion("Es necesario introducir una marca de televisión.");

                    Console.Clear();
                }
            } while (String.IsNullOrWhiteSpace(strMarca));

            do {
                boValido = false;
                Console.Write("\nIntroduzca las pulgadas: \n\t->");
                strCadena = Console.ReadLine();
                boValido = esNumeroValido(strCadena, "Single");

                if (boValido) {
                    floPulgadas = Convert.ToSingle(strCadena);

                    if (floPulgadas > 400 && floPulgadas < 4) {
                        alertaExcepcion("Solo se venden televisores de entre 4 y 400 pulgadas.");
                        boValido = false;
                        Console.Clear();
                        Console.Write("La marca de su televisor es: " + strMarca + "\n");
                    } else if (floPulgadas <= 0) {
                        alertaExcepcion("No se puede introducir un número negativo o 0.");
                        boValido = false;
                        Console.Clear();
                        Console.Write("La marca de su televisor es: " + strMarca + "\n");
                    }

                } else {
                    Console.Clear();
                    Console.Write("La marca de su televisor es: " + strMarca + "\n");
                }

            } while (!boValido);

            do {
                boValido = false;
                Console.Write("\nIntroduzca el consumo energético: \n\t->");
                strCadena = Console.ReadLine();
                boValido = esNumeroValido(strCadena, "Single");

                if (boValido) {
                    floConsumo = Convert.ToSingle(strCadena);

                    if (floConsumo <= 0) {
                        boValido = false;
                        alertaExcepcion("No se puede introducir un consumo negativo o 0.");
                        Console.Clear();
                        Console.Write("La marca de su televisor es: " + strMarca + "\n");
                        Console.Write("\nSu televisor es de " + floPulgadas + " pulgadas\n");
                    }

                } else {
                    Console.Clear();
                    Console.Write("La marca de su televisor es: " + strMarca + "\n");
                    Console.Write("\nSu televisor es de " + floPulgadas + " pulgadas\n");
                }

            } while (!boValido);

            do {
                boValido = false;
                Console.Write("\nIntroduzca el precio: \n\t->");
                strCadena = Console.ReadLine();
                boValido = esNumeroValido(strCadena, "Single");

                if (boValido) {
                    floPrecio = Convert.ToSingle(strCadena);

                    if (floPrecio < 0) {
                        alertaExcepcion("No se puede introducir un precio negativo."); //Se permite un televisor regalado (floPrecio = 0)
                        boValido = false;
                        Console.Clear();
                        Console.Write("La marca de su televisor es: " + strMarca);
                        Console.Write("\n\nSu televisor es de " + floPulgadas + " pulgadas");
                        Console.Write("\n\nSu televisor consume " + floConsumo + "W\n");
                    }

                } else {
                    Console.Clear();
                    Console.Write("La marca de su televisor es: " + strMarca);
                    Console.Write("\n\nSu televisor es de " + floPulgadas + " pulgadas");
                    Console.Write("\n\nSu televisor consume " + floConsumo + "W\n");
                }

            } while (!boValido);

            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.Write("\n\nHa comprado un televisor de la marca " + strMarca + ".");
            Console.ResetColor();
            System.Threading.Thread.Sleep(2000);
            return new Tv(strMarca, floPulgadas, floConsumo, floPrecio);
        }

        private static void imprimirMenu(Tv televisor) {
            Console.Clear();
            Console.Write("Mando de control de la televisión");

            if (!televisor.getBoEncendido()) {
                Console.Write(" para modo APAGADO: \n");
                Console.Write("\n\t- Pulse P para encender la televisión.");
                Console.Write("\n\t- Pulse ESCAPE para salir.");
                Console.Write("\n\t- Pulse I para ver la información técnica de su televisor.");
            } else {
                Console.Write(" para modo ENCENDIDO: \n");
                Console.Write("\n\t- Pulse P para apagar la televisión.");
                Console.Write("\n\t- Pulse ESCAPE para salir.");
                Console.Write("\n\t- Pulse I para ver la información técnica de su televisor.");
                Console.Write("\n\t- Pulse ↑(flecha arriba) para subir el volumen.");
                Console.Write("\n\t- Pulse ↓(flecha abajo) para bajar el volumen.");
                Console.Write("\n\t- Pulse →(flecha derecha) para introducir un canal.");
                Console.Write("\n\t- Pulse ←(flecha izquierda) para volver al canal anterior.");
                televisor.imprimirDatosEncendido();
            }
        }

        static bool esNumeroValido(string strNumero, string strTipo) {
            bool boValido = true;

            if (strNumero.Contains(".") && strTipo.Equals("Single")) {
                alertaExcepcion("Utilice comas para indicar los decimales.");
                return false;
            }

            try {

                if (strTipo.Equals("Single")) {
                    float floComprobar = Convert.ToSingle(strNumero);
                } else {
                    byte floComprobar = Convert.ToByte(strNumero);
                }

            } catch (OverflowException) {
                alertaExcepcion("Ha introducido un número demasiado grande o negativo.");
                boValido = false;
            } catch (FormatException) {
                alertaExcepcion("No ha introducido un número.");
                boValido = false;
            }

            return boValido;
        }

        private static void alertaExcepcion(String strMensaje) {
            Console.BackgroundColor = ConsoleColor.Red;
            Console.Write("\n" + strMensaje);
            Console.ResetColor();
            Console.Beep();
            System.Threading.Thread.Sleep(2000);
        }
    }
}
