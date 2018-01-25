/* 
* * PRÁCTICA.............: 
* * Práctica 8 * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
* * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
* * TÍTULO DE LA PRÁCTICA: Generación de Componentes. 
* * FECHA DE ENTREGA.....: 11 de enero de 2018
*/
using System.Windows.Forms;

namespace NavarroSotoP8 {
    public partial class TextBoxUsuario : TextBox {

        #region Constructor
        public TextBoxUsuario() {
            this.KeyPress += new KeyPressEventHandler(keyPress);
        }
        #endregion

        #region Métodos
        void keyPress(object sender, KeyPressEventArgs e) {
            if (this.Text.Length == 0) {
                if ((e.KeyChar < 64 || e.KeyChar > 91) && e.KeyChar != 8) {
                    e.Handled = true;
                }
            } else {
                if ((e.KeyChar < 96 || e.KeyChar > 123) && e.KeyChar != 8) {

                    e.Handled = true;
                }
            }
        }
        #endregion

    }
}
