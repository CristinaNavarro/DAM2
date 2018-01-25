using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NavarroSotoP6 {
    public partial class formNomina : Form {
        public formNomina() {
            InitializeComponent();
            this.ActiveControl = textBoxDNI;
            #region Eventos añadidos
            this.textBoxDNI.KeyPress += new KeyPressEventHandler(textBoxDNI_KeyPress);
            this.textBoxDNI.Leave += new EventHandler(textBoxDNI_Leave);
            this.textBoxNombre.KeyPress += new KeyPressEventHandler(textBoxNombre_KeyPress);
            this.textBoxNombre.Leave += new EventHandler(textBoxNombre_Leave);
            this.textBoxCategoria.KeyPress += new KeyPressEventHandler(textBoxCategoria_KeyPress);
            this.textBoxCategoria.Leave += new EventHandler(textBoxCategoria_Leave);
            this.textBoxHijos.KeyPress += new KeyPressEventHandler(textBoxHijos_KeyPress);
            this.textBoxHijos.Leave += new EventHandler(textBoxHijos_Leave);
            this.textBoxTrienios.KeyPress += new KeyPressEventHandler(textBoxTrienios_KeyPress);
            this.textBoxTrienios.Leave += new EventHandler(textBoxTrienios_Leave);
            this.textBoxHorasExtra.KeyPress += new KeyPressEventHandler(textBoxHorasExtra_KeyPress);
            this.textBoxHorasExtra.Leave += new EventHandler(textBoxHorasExtra_Leave);
            this.textBoxLiquidacion.KeyPress += new KeyPressEventHandler(textBoxLiquidacion_KeyPress);
            this.textBoxLiquidacion.Leave += new EventHandler(textBoxLiquidacion_Leave);
            this.btnModificarDatos.Leave += new EventHandler(btnModificarDatos_Leave);
            this.btnSalir.Leave += new EventHandler(btnSalir_Leave);
            this.textBoxDNI.MouseClick += new MouseEventHandler(textBoxDNI_Click);
            #endregion
            Nomina nomina = new Nomina();

        }

        #region Botón CalcularNómina
        private void btnCalcularNomina_Click(object sender, EventArgs e) {
            calcularNomina();
            tableResultadoNomina.Visible = true;
            btnModificarDatos.Focus();
            btnCalcularNomina.Enabled = false;
        }
        #endregion

        #region TextBoxDNI
        private void textBoxDNI_KeyPress(object sender, KeyPressEventArgs e) {
            if (e.KeyChar == (char)(Keys.Enter)) {
                Utilidades.simulacionTab(e);
            }
        }

        private void textBoxDNI_Leave(object sender, EventArgs e) {
            if (textBoxDNI.Text.Equals("")) {
                textBoxDNI.Focus();
                MessageBox.Show("Es obligatorio introducir el DNI");
            } else if (!Utilidades.esDNIValido(textBoxDNI.Text)) {
                textBoxDNI.Focus();
                textBoxDNI.Text = "";
                MessageBox.Show("El DNI introducido no es válido");
            } else {
                textBoxNombre.ReadOnly = false;
                textBoxDNI.ReadOnly = true;
            }
        }

        private void textBoxDNI_Click(object sender, EventArgs e) {
            
        }
        #endregion

        #region TextBoxNombre
        private void textBoxNombre_KeyPress(object sender, KeyPressEventArgs e) {
            if (!(e.KeyChar == 45 || (e.KeyChar > 64 && e.KeyChar < 91) || (e.KeyChar > 96 && e.KeyChar < 123) || e.KeyChar == (char)Keys.Space || e.KeyChar == 8 || e.KeyChar == (char)Keys.Enter)) {
                e.Handled = true;
            } else if (e.KeyChar == (char)(Keys.Enter)) {
                Utilidades.simulacionTab(e);

            }
        }

        private void textBoxNombre_Leave(object sender, EventArgs e) {
            if (String.IsNullOrWhiteSpace(textBoxNombre.Text)) {
                textBoxNombre.Focus();
                MessageBox.Show("Es obligatorio introducir el nombre");
            } else {
                textBoxCategoria.ReadOnly = false;
                textBoxNombre.ReadOnly = true;
            }
        }
        #endregion

        #region TextBoxCategoría
        private void textBoxCategoria_KeyPress(object sender, KeyPressEventArgs e) {
            if (!((e.KeyChar > 48 && e.KeyChar < 52) || e.KeyChar == 8 || e.KeyChar == (char)Keys.Enter)) {
                e.Handled = true;
            } else if (e.KeyChar == (char)(Keys.Enter)) {
                Utilidades.simulacionTab(e);
            }
        }

        private void textBoxCategoria_Leave(object sender, EventArgs e) {
            if (textBoxCategoria.Text.Equals("")) {
                textBoxCategoria.Focus();
                MessageBox.Show("Es obligatorio introducir la categoría");
            } else if (textBoxCategoria.Text.Length != 1) {
                textBoxCategoria.Text = "";
                textBoxCategoria.Focus();
                MessageBox.Show("La categoría debe encontrarse en el rango 1-3");
            } else {
                textBoxCategoria.ReadOnly = true;
                textBoxHijos.ReadOnly = false;
            }
        }
        #endregion

        #region TextBoxHijos
        private void textBoxHijos_KeyPress(object sender, KeyPressEventArgs e) {
            if (!((e.KeyChar > 47 && e.KeyChar < 58) || e.KeyChar == 8 || e.KeyChar == (char)Keys.Enter)) {
                e.Handled = true;
            } else if (e.KeyChar == (char)(Keys.Enter)) {
                Utilidades.simulacionTab(e);
            }
        }

        private void textBoxHijos_Leave(object sender, EventArgs e) {
            if (textBoxHijos.Text.Equals("")) {
                textBoxHijos.Text = "0";
                textBoxHijos.ReadOnly = true;
                textBoxTrienios.ReadOnly = false;
            } else if(textBoxHijos.Text.Length > 2) {
                MessageBox.Show("El número de hijos no es válido");
                textBoxHijos.Text = "";
                textBoxHijos.Focus();
            }else{
                byte byNumeroHijos = Convert.ToByte(textBoxHijos.Text);
                if(byNumeroHijos > 12) {
                    MessageBox.Show("El número de hijos no es válido, máximo 12");
                    textBoxHijos.Text = "";
                    textBoxHijos.Focus();
                }else{
                    textBoxHijos.ReadOnly = true;
                    textBoxTrienios.ReadOnly = false;
                }
            }
          

        }
        #endregion

        #region TextBoxTrienios
        private void textBoxTrienios_KeyPress(object sender, KeyPressEventArgs e) {
            if (!((e.KeyChar > 47 && e.KeyChar < 58) || e.KeyChar == 8 || e.KeyChar == (char)Keys.Enter)) {
                e.Handled = true;
            } else if (e.KeyChar == (char)(Keys.Enter)) {
                Utilidades.simulacionTab(e);
            }
        }

        private void textBoxTrienios_Leave(object sender, EventArgs e) {
            if (textBoxTrienios.Text.Equals("")) {
                textBoxTrienios.Text = "0";
                textBoxTrienios.ReadOnly = true;
                textBoxHorasExtra.ReadOnly = false;
            } else if (textBoxTrienios.Text.Length < 3) {
                if (Convert.ToByte(textBoxTrienios.Text) > 12) {
                    textBoxTrienios.Text = "";
                    textBoxTrienios.Focus();
                    MessageBox.Show("El máximo número de trienios permitidos es 12");
                } else {
                    textBoxTrienios.ReadOnly = true;
                    textBoxHorasExtra.ReadOnly = false;
                }
            } else {
                textBoxTrienios.Text = "";
                textBoxTrienios.Focus();
                MessageBox.Show("El máximo número de trienios permitidos es 12");
            }
        }
        #endregion

        #region TextBoxHorasExtra
        private void textBoxHorasExtra_KeyPress(object sender, KeyPressEventArgs e) {
            if (!((e.KeyChar > 47 && e.KeyChar < 58) || e.KeyChar == 8 || e.KeyChar == (char)Keys.Enter)) {
                e.Handled = true;
            } else if (e.KeyChar == (char)(Keys.Enter)) {
                Utilidades.simulacionTab(e);
            }
        }

        private void textBoxHorasExtra_Leave(object sender, EventArgs e) {
            if (textBoxHorasExtra.Text.Equals("")) {
                textBoxHorasExtra.Text = "0";
                textBoxHorasExtra.ReadOnly = true;
                textBoxLiquidacion.ReadOnly = false;
            } else if (textBoxHorasExtra.Text.Length < 3) {
                if (Convert.ToByte(textBoxHorasExtra.Text) > 15) {
                    textBoxHorasExtra.Text = "";
                    textBoxHorasExtra.Focus();
                    MessageBox.Show("El máximo número de horas extra permitidas es 15");
                } else {
                    textBoxHorasExtra.ReadOnly = true;
                    textBoxLiquidacion.ReadOnly = false;
                }
            } else {
                textBoxHorasExtra.Text = "";
                textBoxHorasExtra.Focus();
                MessageBox.Show("El máximo número de horas extra permitidas es 15");
            }
        }
        #endregion

        #region TextBoxLiquidación
        private void textBoxLiquidacion_KeyPress(object sender, KeyPressEventArgs e) {
            if (e.KeyChar == (char)(Keys.Enter)) {
                btnCalcularNomina.Enabled = true;
                Utilidades.simulacionTab(e);
            } else if (e.KeyChar == 9) {
                btnCalcularNomina.Enabled = true;
            }else if (e.KeyChar == (char)Keys.Space) {
                e.Handled = true;
            }
        }

        private void textBoxLiquidacion_Leave(object sender, EventArgs e) {
            if (textBoxLiquidacion.Text.Equals("")) {
                textBoxLiquidacion.Focus();
                textBoxLiquidacion.Text = "";
                MessageBox.Show("Es obligatorio introducir el período de liquidación");
            } else if (!Utilidades.validarFecha(textBoxLiquidacion.Text)) {
                textBoxLiquidacion.Focus();
                textBoxLiquidacion.Text = "";
                MessageBox.Show("No ha introducido una fecha válida");
            }else{
                textBoxLiquidacion.ReadOnly = true;
                btnCalcularNomina.Enabled = true;
                btnCalcularNomina.Focus();
            }
        }
        #endregion

        #region Botón salir
        private void btnSalir_Click(object sender, EventArgs e) {
            Application.Exit();
        }

        private void btnSalir_Leave(object sender, EventArgs e) {
            btnModificarDatos.Focus();
        }
        #endregion

        #region Calculo resultado nómina
        void calcularNomina() {
            Empleado empleado = new Empleado(Convert.ToByte(textBoxCategoria.Text), textBoxDNI.Text, textBoxNombre.Text, Convert.ToByte(textBoxHijos.Text), Convert.ToByte(textBoxTrienios.Text));
            Nomina nomina;
            try {
                nomina = new Nomina(empleado, DateTime.Parse("01/" + textBoxLiquidacion.Text), Convert.ToByte(textBoxHorasExtra.Text));
            } catch (FormatException) {
                nomina = new Nomina(empleado, DateTime.Today, Convert.ToByte(textBoxHorasExtra.Text));
                textBoxLiquidacion.Text = DateTime.Today.Date.ToString().Substring(3,7);
            }

            textBoxSalarioBase.Text = nomina.salarioBase().ToString("0.00");
            textBoxAntiguedad.Text = nomina.importeAntiguedad().ToString("0.00");
            textBoxHorasResultado.Text = nomina.importeHorasExtras().ToString("0.00");
            if(DateTime.Parse("01/" + textBoxLiquidacion.Text).Month == 6 || DateTime.Parse("01/" + textBoxLiquidacion.Text).Month == 12) {
                textBoxPagaExtra.Text = nomina.devengosPagaExtra().ToString("0.00");
            }else{
                textBoxPagaExtra.Text = "Solo meses 6 y 12.";
            }
            textBoxTotalDevengos.Text = nomina.totalDevengados().ToString("0.00");
            textBoxLiquido.Text = nomina.liquido().ToString("0.00");
            textBoxSS.Text = nomina.cotizacionSegSoc().ToString("0.00");
            textBoxDesempleo.Text = nomina.cotizacionSegDes().ToString("0.00");
            textBoxIRPF.Text = nomina.retencionIRPF().ToString("0.00");
            textBoxTotalDescuentos.Text = nomina.totalDescuentos().ToString("0.00");
        }
        #endregion

        #region Botón modificar datos
        private void btnModificarDatos_Click(object sender, EventArgs e) {
            tableResultadoNomina.Visible = false;
            textBoxDNI.ReadOnly = false;
            this.ActiveControl = textBoxDNI;
        }

        private void btnModificarDatos_Leave(object sender, EventArgs e) {
            btnSalir.Focus();
        }
        #endregion
    }
}
