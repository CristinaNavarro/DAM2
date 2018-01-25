/* 
* * PRÁCTICA.............: 
* * Práctica 8 * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
* * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
* * TÍTULO DE LA PRÁCTICA: Generación de Componentes. 
* * FECHA DE ENTREGA.....: 11 de enero de 2018
*/
using System;
using System.Windows.Forms;

namespace NavarroSotoP8 {
    public partial class TextBoxCorreo : TextBox {

        #region Constructor
        public TextBoxCorreo() {
            this.Leave += new EventHandler(perdidaFocus);
        }
        #endregion
        
        #region Métodos
        void perdidaFocus(object sender, EventArgs e) {
            if(!comprobarEmail(this.Text)) {
                this.Text = "";
                MessageBox.Show("El correo debe presentar el formato ___@___");
            }
        }

        bool comprobarEmail(string email) {
            try {
                var addr = new System.Net.Mail.MailAddress(email);
                return addr.Address == email;
            } catch {
                return false;
            }
        }
        #endregion

    }
}
