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
using System.Timers;

namespace NavarroSotoP3 {
    class Utilidades {

        #region Comprobación de que la cadena contiene número
        public static bool contieneNumero(string strComprobacion) {
            if (strComprobacion.Any(c => char.IsDigit(c))) {
                return true;
            }
            return false;
        }
        #endregion

        #region Comprobación de que la cadena contiene símbolos o letras
        public static bool contieneSímboloOLetra(string strComprobacion) {
            if (strComprobacion.Any(c => char.IsSymbol(c)) || strComprobacion.Any(c => char.IsPunctuation(c)) || strComprobacion.Any(c => char.IsLetter(c)) || strComprobacion.Equals(" ")) {
                return true;
            }
            return false;
        }
        #endregion

        #region Comprobar digito numérico
        public static bool esKeyNumerico(ConsoleKeyInfo key) {
            bool boValido = false;
            if (key.Key == ConsoleKey.D0 || key.Key == ConsoleKey.D1 || key.Key == ConsoleKey.D2 || key.Key == ConsoleKey.D3 || key.Key == ConsoleKey.D4 || key.Key == ConsoleKey.D5
             || key.Key == ConsoleKey.D6 || key.Key == ConsoleKey.D7 || key.Key == ConsoleKey.D8 || key.Key == ConsoleKey.D9) {
                boValido = true;
            }
            return boValido;
        }
        #endregion

        #region Validación de número según el tipo de variable
        public static bool esNumeroValido(string strNumeroComprobacion, string strTipo) {
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

        #region Ejecución al pulsar BackSpace
        public static void ejecucionBackSpace() {
            Console.SetCursorPosition(Console.CursorLeft + 1, Console.CursorTop);
            Console.Write("\b \b");
        }
        #endregion

        #region Visualización de alerta
        public static void imprimirAlerta(string strAlerta) {
            System.Media.SystemSounds.Asterisk.Play();
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

        #region Visualización de alerta de premio
        public static void imprimirAlertaPremio(string strAlerta) {
            System.Media.SystemSounds.Hand.Play();
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
            System.Threading.Thread.Sleep(4000);
            while (Console.KeyAvailable) {
                Console.ReadKey(false);
            }
            Console.Clear();
        }
        #endregion
    }
    #region Clase Temporizador (control tiempo de turno)
    class Temporizador {
        private static Timer aTimer;
        private static int nEventsFired = 0;
        private static DateTime previousTime;
        private static byte byTiempoMaximo;

        public Temporizador(byte byTiempo) {
            aTimer = new Timer(1000);
            nEventsFired = 0;
            byTiempoMaximo = byTiempo;
        }


        public void controlTiempo() {
            aTimer = new Timer(1000);
            aTimer.Elapsed += OnTimedEvent;
            aTimer.AutoReset = true;
            aTimer.Enabled = true; //se llamará al onTimedEvent
        }

        public bool comprobarTiempo(byte byTiempoMaximoRespuesta) {
            if (nEventsFired >= byTiempoMaximoRespuesta) {
                return false;
            }
            return true;
        }

        public void pararTemporizador() {
            aTimer.Enabled = false;
        }

        private static void OnTimedEvent(Object source, ElapsedEventArgs e) {
            nEventsFired++;
            previousTime = e.SignalTime;
            if (nEventsFired > byTiempoMaximo) {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.Write("\nFin de tiempo. Pulse cualquier tecla para continuar...\n");
                Console.ResetColor();
                aTimer.Enabled = false;
            }
        }

    }
    #endregion

}

