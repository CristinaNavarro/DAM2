using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP2 {
    class Utilidades {

        #region Comprobación de que la cadena contiene número
        public static bool contieneNumero(string strComprobacion) {
            if (strComprobacion.Any(c => char.IsDigit(c))) {
                return true;
            }
            return false;
        }
        #endregion

        #region Comprobación de que la cadena contiene símbolos
        public static bool contieneSímbolo(string strComprobacion) {
            if (strComprobacion.Any(c => char.IsSymbol(c)) || strComprobacion.Any(c => char.IsPunctuation(c))) {
                return true;
            }
            return false;
        }
        #endregion

        #region Validación de DNI
        public static bool esDNIValido(string strDNI, string strAlerta) {
            uint intNumeroDNI;
            try {
                intNumeroDNI = Convert.ToUInt32(strDNI.Substring(0, 8));
            } catch (FormatException) {
                imprimirAlerta("No coincide con el formato del DNI.", strAlerta);
                return false;
            } catch (OverflowException) {
                imprimirAlerta("No es un número válido.", strAlerta);
                return false;
            } catch (ArgumentOutOfRangeException) {
                imprimirAlerta("No coincide con el formato del DNI.", strAlerta);
                return false;
            }
            char chLetraCorrespondiente;
            switch (intNumeroDNI % 23) {
                case 0:
                    chLetraCorrespondiente = 'T';
                    break;
                case 1:
                    chLetraCorrespondiente = 'R';
                    break;
                case 2:
                    chLetraCorrespondiente = 'W';
                    break;
                case 3:
                    chLetraCorrespondiente = 'A';
                    break;
                case 4:
                    chLetraCorrespondiente = 'G';
                    break;
                case 5:
                    chLetraCorrespondiente = 'M';
                    break;
                case 6:
                    chLetraCorrespondiente = 'Y';
                    break;
                case 7:
                    chLetraCorrespondiente = 'F';
                    break;
                case 8:
                    chLetraCorrespondiente = 'P';
                    break;
                case 9:
                    chLetraCorrespondiente = 'D';
                    break;
                case 10:
                    chLetraCorrespondiente = 'X';
                    break;
                case 11:
                    chLetraCorrespondiente = 'B';
                    break;
                case 12:
                    chLetraCorrespondiente = 'N';
                    break;
                case 13:
                    chLetraCorrespondiente = 'J';
                    break;
                case 14:
                    chLetraCorrespondiente = 'Z';
                    break;
                case 15:
                    chLetraCorrespondiente = 'S';
                    break;
                case 16:
                    chLetraCorrespondiente = 'Q';
                    break;
                case 17:
                    chLetraCorrespondiente = 'V';
                    break;
                case 18:
                    chLetraCorrespondiente = 'H';
                    break;
                case 19:
                    chLetraCorrespondiente = 'L';
                    break;
                case 20:
                    chLetraCorrespondiente = 'C';
                    break;
                case 21:
                    chLetraCorrespondiente = 'K';
                    break;
                case 22:
                    chLetraCorrespondiente = 'E';
                    break;
                default:
                    return false;
            }

            if (strDNI.Substring(strDNI.Length - 1, 1).Equals(Convert.ToString(chLetraCorrespondiente),
                StringComparison.InvariantCultureIgnoreCase)) {
                return true;
            } else {
                imprimirAlerta("DNI incorrecto, números y letra no coinciden", strAlerta);
            }
            return false;
        }
        #endregion

        #region Validación de número según el tipo de variable
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
                imprimirAlerta("Ha introducido algún carácter no numérico.", strAlerta);
                return false;
            } catch (OverflowException) {
                imprimirAlerta("Ha introducido un número no válido", strAlerta);
                return false;
            }
            return true;
        }
        #endregion

        #region Visualización de alerta
        public static void imprimirAlerta(string strAlerta, string strInformacionIntroducida) {
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
            Console.Clear();
            if (!strInformacionIntroducida.Equals("")) {
                Console.WriteLine(strInformacionIntroducida);
            }
        }
        #endregion
    }
}
