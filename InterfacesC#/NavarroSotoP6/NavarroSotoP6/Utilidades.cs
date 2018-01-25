using System;
using System.Windows.Forms;
using System.Text.RegularExpressions;


namespace NavarroSotoP6 {
    class Utilidades {

        #region Validación de DNI
        public static bool esDNIValido(string strDNI) {
            uint intNumeroDNI;
            try {
                intNumeroDNI = Convert.ToUInt32(strDNI.Substring(0, 8));
            } catch (FormatException) {
                return false;
            } catch (OverflowException) {
                return false;
            } catch (ArgumentOutOfRangeException) {
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
            }
            return false;
        }
        #endregion

        #region SimulaciónTab
        public static void simulacionTab(KeyPressEventArgs e) {
            e.Handled = true;
            SendKeys.Send("{TAB}");
        }
        #endregion

        #region Validación de Fecha
        public static bool validarFecha(string fechaValidacion) {
            bool boValido = false;
            Regex re = new Regex(@"\d{2}/\d{4}");
            DateTime target;
            try {
                target = DateTime.Parse("01/" + fechaValidacion);
            }catch(FormatException) {
                MessageBox.Show("La fecha introducida no es válida, se ha completado con la fecha de hoy");
               target = DateTime.Today;
            }

            if (re.IsMatch(fechaValidacion) && DateTime.Today.Year == target.Year) {
                boValido = true;
            }
            return boValido;
        }
        #endregion
    }
}
