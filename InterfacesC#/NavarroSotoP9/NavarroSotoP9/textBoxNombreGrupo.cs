using System.Windows.Forms;

namespace NavarroSotoP9 {
    public partial class TextBoxNombreGrupo : TextBox {

        public TextBoxNombreGrupo() {
            this.KeyPress += new KeyPressEventHandler(keyPress);
        }

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
