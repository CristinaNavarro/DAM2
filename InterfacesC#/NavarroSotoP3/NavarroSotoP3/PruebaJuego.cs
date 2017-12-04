/* 
 * * PRÁCTICA.............: Práctica 3. 
 * * NOMBRE y APELLIDOS...: Cristina Navarro Soto
 * * CURSO y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO de la PRÁCTICA: Sentencias de Control. Excepciones. 
 * * FECHA de ENTREGA.....: 16 de NOVIEMBRE de 2017 
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP3 {
    class PruebaJuego {
        public byte menu() {
            string strComprobacionNumero;
            bool boValido;
            byte byOpcion = 0;
            do {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Juego de multiplicar\n");
                Console.WriteLine("\t1. Establecer el tiempo de juego");
                Console.WriteLine("\t2. Establecer el número de preguntas");
                Console.WriteLine("\t3. JUGAR");
                Console.WriteLine("\t4. Salir\n\n");
                Console.Write("Opción: \n\t->");
                Console.ResetColor();
                strComprobacionNumero = Console.ReadLine();
                boValido = Utilidades.esNumeroValido(strComprobacionNumero, "byte");
                if (boValido) {
                    byOpcion = Convert.ToByte(strComprobacionNumero);
                    if (byOpcion == 0 || byOpcion > 4) {
                        boValido = false;
                        Utilidades.imprimirAlerta("No es válido, introduce un número entre 1 y 4");
                    } else {

                    }
                }
            } while (!boValido);
            return byOpcion;
        }

        public byte leerTiempoLimite() {
            string strComprobacionNumero;
            bool boValido;
            byte byOpcion = 0;
            do {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Tiempo máximo en segundos para responder(3-10):");
                Console.Write("\n\t->");
                Console.ResetColor();
                strComprobacionNumero = Console.ReadLine();
                boValido = Utilidades.esNumeroValido(strComprobacionNumero, "byte");
                if (boValido) {
                    byOpcion = Convert.ToByte(strComprobacionNumero);
                    if (byOpcion < 3 || byOpcion > 10) {
                        boValido = false;
                        Utilidades.imprimirAlerta("El valor debe ser mayor que 3 y menor que 10.");
                    }
                }
            } while (!boValido);
            return byOpcion;
        }

        public byte leerNumeroPreguntas() {
            string strComprobacionNumero;
            bool boValido;
            byte byOpcion = 0;
            do {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Número de preguntas que se realizarán(1-10): ");
                Console.Write("\n\t->");
                Console.ResetColor();
                strComprobacionNumero = Console.ReadLine();
                boValido = Utilidades.esNumeroValido(strComprobacionNumero, "byte");
                if (boValido) {
                    byOpcion = Convert.ToByte(strComprobacionNumero);
                    if (byOpcion < 1 || byOpcion > 10) {
                        boValido = false;
                        Utilidades.imprimirAlerta("El valor debe estar entre 1 y 10.");
                    }
                }
            } while (!boValido);
            return byOpcion;
        }

        public void jugar(byte byTiempoLimiteRespuesta, byte byNumeroPreguntas) {
            JuegoMultiplicar juegoMultiplicar = new JuegoMultiplicar();
            byte byRespuesta;
            byte byResultadoCorrecto;
            float floNota;
            byte byFallos;
            juegoMultiplicar.propiedadByTiempoMaximoRespuesta = byTiempoLimiteRespuesta;
            for (int i = 0; i < byNumeroPreguntas; i++) {
                juegoMultiplicar.generarOperandos();
                byRespuesta = responderIntervalo(byTiempoLimiteRespuesta, juegoMultiplicar);
                byResultadoCorrecto = Convert.ToByte(juegoMultiplicar.propiedadByPrimerFactor * juegoMultiplicar.propiedadBySegundoFactor);
                if (byResultadoCorrecto == byRespuesta) {
                    Utilidades.imprimirAlertaPremio("¡Bien, ha conseguido un punto!");
                    juegoMultiplicar.propiedadByContadorAciertos++;
                } else {
                    Utilidades.imprimirAlerta("No ha conseguido este punto, el resultado era: " + byResultadoCorrecto);
                }
                if (i < byNumeroPreguntas - 1) {
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    Console.Write("Pulse cualquier tecla para continuar...");
                    Console.ResetColor();
                }
            }
            Console.Clear();
            floNota = (Convert.ToSingle(juegoMultiplicar.propiedadByContadorAciertos) / Convert.ToSingle(byNumeroPreguntas)) * 10;
            byFallos = Convert.ToByte(byNumeroPreguntas - juegoMultiplicar.propiedadByContadorAciertos);
            Utilidades.imprimirAlertaPremio("Resultado final: " + juegoMultiplicar.propiedadByContadorAciertos + " -- Fallos: " + byFallos + " -- Nota: " + floNota.ToString("0.00"));
        }

        public byte responderIntervalo(byte byTiempoLimiteRespuesta, JuegoMultiplicar juegoMultiplicar) {
            Console.Clear();
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.Write("Tiempo disponible por turno: " + byTiempoLimiteRespuesta + " \nCalcule y pulse Intro para introducir la respuesta: \n\n\t");
            bool boBorradoDisponible = false;
            bool boTiempoDisponible;
            string strRespuesta = "";
            ConsoleKeyInfo key;
            Console.Write("\n\t-->" + juegoMultiplicar.propiedadByPrimerFactor + " * " + juegoMultiplicar.propiedadBySegundoFactor + " = ");
            Console.ResetColor();
            Temporizador temporizador = new Temporizador(byTiempoLimiteRespuesta);
            temporizador.controlTiempo();
            do {
                boTiempoDisponible = temporizador.comprobarTiempo(byTiempoLimiteRespuesta);
                key = Console.ReadKey();
                if (Utilidades.esKeyNumerico(key) && strRespuesta.Length < 2 && boTiempoDisponible) {
                    boBorradoDisponible = true;
                    strRespuesta += key.KeyChar.ToString();
                } else if (key.Key == ConsoleKey.Backspace && boBorradoDisponible && boTiempoDisponible) {
                    Utilidades.ejecucionBackSpace();
                    strRespuesta = strRespuesta.Substring(0, strRespuesta.Length - 1);
                    if (strRespuesta.Length == 0) {
                        boBorradoDisponible = false;
                    }
                } else if (key.Key == ConsoleKey.Backspace && !boBorradoDisponible && boTiempoDisponible) {
                    Console.SetCursorPosition(Console.CursorLeft + 1, Console.CursorTop);
                } else if (!Utilidades.esKeyNumerico(key) || strRespuesta.Length >= 2) {
                    Console.Write("\b \b");
                }
                boTiempoDisponible = temporizador.comprobarTiempo(byTiempoLimiteRespuesta);
            } while (key.Key != ConsoleKey.Enter && boTiempoDisponible);
            temporizador.pararTemporizador();
            boTiempoDisponible = temporizador.comprobarTiempo(byTiempoLimiteRespuesta);
            if (!boTiempoDisponible || strRespuesta.Equals("")) {
                strRespuesta = "0";
            }
            return Convert.ToByte(strRespuesta);
        }

        public static void Main(string[] ar) {
            PruebaJuego pruebaJuego = new PruebaJuego();
            byte byNumeroPreguntas = 0;
            byte byTiempoMaximoRespuesta = 0;
            byte byOpcion;
            while ((byOpcion = pruebaJuego.menu()) != 4) {
                switch (byOpcion) {
                    case 1:
                        Console.Clear();
                        byTiempoMaximoRespuesta = pruebaJuego.leerTiempoLimite();
                        break;
                    case 2:
                        Console.Clear();
                        byNumeroPreguntas = pruebaJuego.leerNumeroPreguntas();
                        break;
                    case 3:
                        if (byTiempoMaximoRespuesta >= 3 && byNumeroPreguntas > 0) {
                            pruebaJuego.jugar(byTiempoMaximoRespuesta, byNumeroPreguntas);
                        } else {
                            Utilidades.imprimirAlerta("Debe ejecutar antes las opciones 1 y 2 del menú");
                        }
                        break;
                }
                Console.Clear();
            }
        }
    }
}
