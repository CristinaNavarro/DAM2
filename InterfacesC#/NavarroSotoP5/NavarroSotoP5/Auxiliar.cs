﻿/*
 * * PRÁCTICA.............: Práctica 5. 
 * * NOMBRE Y APELLIDOS...: Cristina Navarro Soto 
 * * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO DE LA PRÁCTICA: Estructuras de Datos Internas y Manejo de Ficheros. 
 * * FECHA DE ENTREGA.....: 13 de DICIEMBRE de 2017
 */

using System;
using System.Text.RegularExpressions;


namespace NavarroSotoP5 {
    class Auxiliar {

        #region Método de control de introducción de letras según la longitud de la cadena
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
            } while ((strPalabra.Length < byLimite && key.Key != ConsoleKey.Enter) || String.IsNullOrWhiteSpace(strPalabra));//cuidado si strPalabra es null
            return strPalabra;
        }
        #endregion

        #region Método esNúmeroValido
        public static bool esNumeroValido(string strNumeroComprobacion, string strTipo, string strAlerta) {
            try {
                if (strTipo.Equals("ushort")) {
                    ushort usNumero = Convert.ToUInt16(strNumeroComprobacion);
                } else if (strTipo.Equals("byte")) {
                    byte byNumero = Convert.ToByte(strNumeroComprobacion);
                } else {
                    short shNumero = Convert.ToInt16(strNumeroComprobacion);
                }
            } catch (FormatException) {
                imprimirAlerta("Ha introducido algún carácter no numérico.");
                return false;
            } catch (OverflowException) {
                imprimirAlerta("Ha introducido un número no válido");
                return false;
            }
            return true;
        }
        #endregion

        #region Método imprimirAlerta
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

        #region Método imprimirAviso
        public static void imprimirAviso(string strAlerta) {
            System.Media.SystemSounds.Asterisk.Play();
            Console.WriteLine();
            Console.BackgroundColor = ConsoleColor.DarkGreen;
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

        #region Método de control de introducción del número según su longitud
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

        #region Comprobar digito numérico
        public static bool esKeyNumerico(ConsoleKeyInfo key) { 
            Regex regex = new Regex(@"\d+");
            Match match = regex.Match(key.KeyChar.ToString());
            if (match.Success) {
                return true;
            }
            return false;
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

        #region Método que permite asignar color a una sola cadena
        public static void writeConColor(ConsoleColor consoleColor, string strTexto) {
            Console.ForegroundColor = consoleColor;
            Console.Write(strTexto);
            Console.ResetColor();
        }
        #endregion
    }
}
