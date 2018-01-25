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
    public partial class VentanaPrincipal : Form {
        GrupoUsuarios grupo;

        #region Constructor
        public VentanaPrincipal() {
            InitializeComponent();
            grupo = new GrupoUsuarios();

            System.Xml.Serialization.XmlSerializer reader =
                new System.Xml.Serialization.XmlSerializer(typeof(GrupoUsuarios));
            var path = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + "//DatosUsuario.xml";
            System.IO.StreamReader file = new System.IO.StreamReader(path);
            GrupoUsuarios grupoRecuperado = (GrupoUsuarios)reader.Deserialize(file);
            file.Close();

            grupo.propiedadListUsuarios = grupoRecuperado.propiedadListUsuarios;
            textBoxFecha.GotFocus += new EventHandler(consigueFocus);
            textBoxFecha.Leave += new EventHandler(pierdeFocus);
            calendarNacimiento.Leave += new EventHandler(pierdeFocus);
            btnVerContraseñaLogin.Click += new EventHandler(btnVerContraseñaLogin_Click);
            tabControlUsuario.Click += new EventHandler(modificacionTab);
        }
        #endregion

        #region Métodos
        private void btnVerContraseña_Click(object sender, EventArgs e) {
            textBoxContraseña.visualizar();
            if (btnVerContraseña.Text.Equals("Ver")) {
                btnVerContraseña.Text = "Ocultar";
            } else {
                btnVerContraseña.Text = "Ver";
            }
        }

        private void btnVerContraseñaLogin_Click(object sender, EventArgs e) {
            textBoxContraseñaLogin.visualizar();
            if (btnVerContraseñaLogin.Text.Equals("Ver")) {
                btnVerContraseñaLogin.Text = "Ocultar";
            } else {
                btnVerContraseñaLogin.Text = "Ver";
            }
        }

        private void btnRegistrar_Click(object sender, EventArgs e) {
            bool boValido = true;
            if (textBoxNombre.Text.Length == 0 || String.IsNullOrWhiteSpace(textBoxNombre.Text) || textBoxCorreo.Text.Length == 0 || textBoxContraseña.Text.Length == 0 || textBoxFecha.Text.Length == 0 || textBoxUsuario.Text.Length == 0) {
                MessageBox.Show("No se han introducido todos los datos");
            } else {
                foreach (DatosUsuario usuario in grupo.propiedadListUsuarios) {
                    if (usuario.propiedadStrUsuario.Equals(textBoxUsuario.Text)) {
                        boValido = false;
                    }
                }
                if (boValido) {
                    DatosUsuario datos = new DatosUsuario(textBoxNombre.Text, textBoxUsuario.Text, textBoxCorreo.Text, textBoxContraseña.Text);
                    grupo.addUsuario(datos);
                    System.Xml.Serialization.XmlSerializer writer =
                        new System.Xml.Serialization.XmlSerializer(typeof(GrupoUsuarios));
                    var path = "DatosUsuario.xml";
                    System.IO.FileStream file = System.IO.File.Create(path);
                    writer.Serialize(file, grupo);
                    file.Close();
                    MessageBox.Show("Usuario registrado con éxito.");
                } else {
                    MessageBox.Show("Ya existe un usuario con ese nombre");
                }
                limpiarInformacion();
            }
        }

        private void consigueFocus(Object sender, EventArgs e) {
            calendarNacimiento.Show();
            if (textBoxFecha.TextLength == 0) {
                textBoxFecha.Text = DateTime.Now.Date.ToShortDateString();
            }
        }

        private void pierdeFocus(Object sender, EventArgs e) {
            if (!(textBoxFecha.ContainsFocus || calendarNacimiento.ContainsFocus)) {
                calendarNacimiento.Hide();
                if (!textBoxFecha.validarFecha(textBoxFecha.Text)) {
                    textBoxFecha.Text = "";
                } 
            }
        }

        private void calendarNacimiento_DateChanged(object sender, DateRangeEventArgs e) {
            textBoxFecha.Text = calendarNacimiento.SelectionEnd.ToShortDateString();
        }

        private void btnLogin_Click(object sender, EventArgs e) {
            bool boValido = false;
            if (String.IsNullOrWhiteSpace(textBoxUsuarioLogin.Text)|| textBoxContraseñaLogin.Text.Length == 0) {
                MessageBox.Show("No se han introducido todos los datos.");
            } else {
                foreach (DatosUsuario usuario in grupo.propiedadListUsuarios) {
                    if (usuario.propiedadStrUsuario.Equals(textBoxUsuarioLogin.Text)) {
                        if (usuario.propiedadStrContraseña.Equals(textBoxContraseñaLogin.Text)) {
                            boValido = true;
                        }
                    }
                }
                if (boValido) {
                    MessageBox.Show("Login correcto.");
                } else {
                    MessageBox.Show("Login incorrecto, compruebe el usuario o la contraseña.");
                }
                limpiarInformacion();
            }
        }
        #endregion

        private void modificacionTab(object sender, EventArgs e) {
            calendarNacimiento.Hide();
            textBoxFecha.Text = "";
            limpiarInformacion();
        }

        private void limpiarInformacion() {
            textBoxNombre.Text = "";
            textBoxCorreo.Text = "";
            textBoxContraseña.Text = "";
            textBoxFecha.Text = "";
            textBoxUsuario.Text = "";
            textBoxUsuarioLogin.Text = "";
            textBoxContraseñaLogin.Text = "";
        }

        private void textBoxNombre_TextChanged(object sender, EventArgs e) {

        }
    }
}
