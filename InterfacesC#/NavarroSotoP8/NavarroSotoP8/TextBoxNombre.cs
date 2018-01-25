/* 
* * PRÁCTICA.............: 
* * Práctica 8 * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
* * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
* * TÍTULO DE LA PRÁCTICA: Generación de Componentes. 
* * FECHA DE ENTREGA.....: 11 de enero de 2018
*/
using System.Windows.Forms;

namespace NavarroSotoP8 {
    public partial class TextBoxNombre : TextBox {

        #region Constructor
        public TextBoxNombre() {
            this.KeyPress += new KeyPressEventHandler(keyPress);
        }
        #endregion

        #region Métodos
        void keyPress(object sender, KeyPressEventArgs e) {
            if(!char.IsLetter(e.KeyChar) && e.KeyChar != 8 && e.KeyChar != 32) {
                e.Handled = true;
            }
        }
        #endregion

    }
}
