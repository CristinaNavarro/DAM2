/* 
* * PRÁCTICA.............: 
* * Práctica 8 * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
* * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
* * TÍTULO DE LA PRÁCTICA: Generación de Componentes. 
* * FECHA DE ENTREGA.....: 11 de enero de 2018
*/
using System;
using System.Windows.Forms;
using System.Text.RegularExpressions;

namespace NavarroSotoP8 {
    public partial class TextBoxFecha : TextBox {

        #region Constructor
        public TextBoxFecha() {
        }
        #endregion

        #region Métodos
        public bool validarFecha(string fechaValidacion) {
            bool boValido = false;
            Regex regex = new Regex(@"\d{2}/\d{2}/\d{4}");
            DateTime target;
            try {
                target = DateTime.Parse(fechaValidacion);
                if (regex.IsMatch(fechaValidacion) && DateTime.Today >= target.AddYears(18)) {
                    boValido = true;
                }else{
                    MessageBox.Show("No eres mayor de edad.");
                }
            } catch (FormatException) {
                this.Text = "";
                //MessageBox.Show("La fecha introducida no es válida");
            }
            return boValido;
        }
        #endregion

    }
}
