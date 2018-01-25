/* 
* * PRÁCTICA.............: 
* * Práctica 8 * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
* * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
* * TÍTULO DE LA PRÁCTICA: Generación de Componentes. 
* * FECHA DE ENTREGA.....: 11 de enero de 2018
*/
using System.Windows.Forms;

namespace NavarroSotoP8 {
    public partial class TextBoxContraseña : TextBox {

        #region Constructor
        public TextBoxContraseña() {
            this.MaxLength = 8;
            this.UseSystemPasswordChar = true;
            this.KeyPress += new KeyPressEventHandler(keyPress);
        }
        #endregion

        #region Métodos
        void keyPress(object sender, KeyPressEventArgs e) { //revisar
            if((e.KeyChar < 64 || e.KeyChar > 71) && !char.IsDigit(e.KeyChar) && e.KeyChar !=8) {
                e.Handled = true;
            }
        }

        public void visualizar() {
            if (UseSystemPasswordChar) {
                this.UseSystemPasswordChar = false;
            } else {
                this.UseSystemPasswordChar = true;
            }
        }
        #endregion

    }
}
