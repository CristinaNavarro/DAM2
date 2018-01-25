/* * PRÁCTICA.............: Práctica 4. 
 * * NOMBRE y APELLIDOS...: Cristina Navarro Soto
 * * CURSO y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO de la PRÁCTICA: Diseño de clases. Herencia y polimorfismo. 
 * * FECHA de ENTREGA.....: 23 de NOVIEMBRE de 2017 
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP4 {
    class Auxiliar {
        #region Método de control de introducción del texto según su longitud
        public static string controlIntroduccion(string strPalabra, byte byLimite) {
            ConsoleKeyInfo key;

            do {
                int x = Console.CursorLeft;
                int y = Console.CursorTop;
                key = Console.ReadKey();
                if (key.Key == ConsoleKey.Backspace) {
                    Auxiliar.ejecucionBackSpace(strPalabra);
                    if (strPalabra.Length != 0) {
                        strPalabra = strPalabra.Substring(0, strPalabra.Length - 1);
                    }
                } else if (key.Key == ConsoleKey.Enter || key.Key == ConsoleKey.Tab) {
                    Console.SetCursorPosition(x, y);
                } else if (strPalabra.Length > byLimite) {
                    Console.Write("\b \b");
                }else if(strPalabra.Length < byLimite) {
                    strPalabra += key.KeyChar.ToString();
                }
            } while ((strPalabra.Length < byLimite && key.Key != ConsoleKey.Enter) || String.IsNullOrWhiteSpace(strPalabra));
            return strPalabra;
        }
        #endregion

        #region Método de control de introducción del texto según su longitud
        public static string controlIntroduccionNumero(string strPalabra, byte byLimite) {
            ConsoleKeyInfo key;

            do {
                int x = Console.CursorLeft;
                int y = Console.CursorTop;
                key = Console.ReadKey();
                if (key.Key == ConsoleKey.Enter || key.Key == ConsoleKey.Tab) {
                    Console.SetCursorPosition(x, y);
                } else if (Auxiliar.esKeyNumerico(key) && strPalabra.Length < byLimite) {
                    strPalabra += key.KeyChar.ToString();
                } else if (key.Key == ConsoleKey.Backspace) {
                    Auxiliar.ejecucionBackSpace(strPalabra);
                    if (strPalabra.Length != 0) {
                        strPalabra = strPalabra.Substring(0, strPalabra.Length - 1);
                    }
                } else if (!Auxiliar.esKeyNumerico(key) || strPalabra.Length > byLimite) {
                        Console.Write("\b \b");
                }
            } while ((strPalabra.Length < byLimite && key.Key != ConsoleKey.Enter) || String.IsNullOrWhiteSpace(strPalabra));
            return strPalabra;
        }
        #endregion

        #region Método de control de introducción de números según la longitud de la cadena
        public static string controlIntroduccionPalabra(string strPalabra, byte byLimite) {
            ConsoleKeyInfo key;

            do {
                int x = Console.CursorLeft;
                int y = Console.CursorTop;
                key = Console.ReadKey();
                if (!Auxiliar.esKeyNumerico(key) && key.Key != ConsoleKey.Backspace && key.Key != ConsoleKey.Enter && key.Key != ConsoleKey.Tab) {
                    strPalabra += key.KeyChar.ToString();
                } else if (key.Key == ConsoleKey.Backspace) {
                    Auxiliar.ejecucionBackSpace(strPalabra);
                    if (strPalabra.Length != 0) {
                        strPalabra = strPalabra.Substring(0, strPalabra.Length - 1);
                    }
                } else if (Auxiliar.esKeyNumerico(key)) {
                    Console.Write("\b \b");
                } else if (key.Key == ConsoleKey.Enter || key.Key == ConsoleKey.Tab) {
                    Console.SetCursorPosition(x, y);
                }
            } while ((strPalabra.Length < byLimite && key.Key != ConsoleKey.Enter) || String.IsNullOrWhiteSpace(strPalabra));
            return strPalabra;
        }
        #endregion

        #region Método que controla el paso de página
        public static void pulsarTeclaContinuar() {
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("Pulse cualquier tecla para continuar...");
            while (Console.ReadKey() == null) {
            }
            Console.ResetColor();
            Console.Clear();
        }
        #endregion

        #region Método que permite asignar color a una sola cadena
        public static void writeConColor(ConsoleColor consoleColor, string strTexto) {
            Console.ForegroundColor = consoleColor;
            Console.Write(strTexto);
            Console.ResetColor();
        }
        #endregion

        #region Visualización de alerta
        public static void imprimirAlerta(string strAlerta) {
            Console.Beep();
            Console.WriteLine();
            Console.BackgroundColor = ConsoleColor.Red;
            Console.SetCursorPosition((Console.WindowWidth - strAlerta.Length) / 2, Console.CursorTop);
            for (ushort i = 0; i < strAlerta.Length + 4; i++) {
                Console.Write("-");
            }
            for (byte i = 0; i < 2; i++) {
                Console.WriteLine();
                Console.SetCursorPosition((Console.WindowWidth - strAlerta.Length) / 2, Console.CursorTop);
                for (ushort j = 0; j < strAlerta.Length + 4; j++) {
                    Console.Write(" ");
                }
            }
            Console.SetCursorPosition((Console.WindowWidth - strAlerta.Length) / 2, Console.CursorTop);
            Console.WriteLine("| " + strAlerta + " |");
            Console.SetCursorPosition((Console.WindowWidth - strAlerta.Length) / 2, Console.CursorTop);
            for (ushort i = 0; i < strAlerta.Length + 4; i++) {
                Console.Write(" ");
            }
            Console.WriteLine();
            Console.SetCursorPosition((Console.WindowWidth - strAlerta.Length) / 2, Console.CursorTop);
            for (ushort i = 0; i < strAlerta.Length + 4; i++) {
                Console.Write("-");
            }
            Console.ResetColor();
            System.Threading.Thread.Sleep(2000);
            while (Console.KeyAvailable) {
                Console.ReadKey(false);
            }
            Console.Clear();
        }
        #endregion

        #region Comprobación de que la cadena contiene letra
        public static bool contieneLetra(string strComprobacion) {
            if (strComprobacion.Any(c => char.IsLetter(c))) {
                return true;
            }
            return false;
        }
        #endregion

        #region Comprobar digito numérico
        public static bool esKeyNumerico(ConsoleKeyInfo key) {
            bool boValido = false;
            if (key.Key == ConsoleKey.D0 || key.Key == ConsoleKey.D1 || key.Key == ConsoleKey.D2 || key.Key == ConsoleKey.D3 || key.Key == ConsoleKey.D4 || key.Key == ConsoleKey.D5
             || key.Key == ConsoleKey.D6 || key.Key == ConsoleKey.D7 || key.Key == ConsoleKey.D8 || key.Key == ConsoleKey.D9 || key.Key == ConsoleKey.NumPad0 || key.Key == ConsoleKey.NumPad1
             || key.Key == ConsoleKey.NumPad2 || key.Key == ConsoleKey.NumPad3 || key.Key == ConsoleKey.NumPad4 || key.Key == ConsoleKey.NumPad5 || key.Key == ConsoleKey.NumPad6
             || key.Key == ConsoleKey.NumPad7 || key.Key == ConsoleKey.NumPad8 || key.Key == ConsoleKey.NumPad9) {
                boValido = true;
            }
            return boValido;
        }
        #endregion

        #region Ejecución al pulsar BackSpace
        public static void ejecucionBackSpace(string strBorrado) {
            Console.SetCursorPosition(Console.CursorLeft + 1, Console.CursorTop);
            if (strBorrado.Length != 0) {
                Console.Write("\b \b");
            }
        }
        #endregion
    }
}

