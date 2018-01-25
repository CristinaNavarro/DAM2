/* 
 * * PRÁCTICA.............: Práctica 9. 
 * * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
 * * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO DE LA PRÁCTICA: Aplicaciones de Formulario II. Más Controles. 
 * * FECHA DE ENTREGA.....: 25 de ENERO de 2018 
 */
using System;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Windows.Forms;

namespace NavarroSotoP9 {
    public partial class formNuevoGrupo : Form {
        public formNuevoGrupo() {
            InitializeComponent();

            var items = checkedListAsignaturas.Items;
            checkedListAsignaturas.Items.Add("PRO");
            checkedListAsignaturas.Items.Add("FOL");
            checkedListAsignaturas.Items.Add("BAD");
            checkedListAsignaturas.Items.Add("END");
            checkedListAsignaturas.Items.Add("SAD");
            checkedListAsignaturas.Items.Add("SIS");
            checkedListAsignaturas.Items.Add("INT");
            checkedListAsignaturas.Items.Add("EMP");
            checkedListAsignaturas.Items.Add("AND");

        }

        private void btnCrear_Click(object sender, EventArgs e) {
            errorNombre.Clear();
            errorAsignaturas.Clear();
            if (!String.IsNullOrEmpty(textBoxNombreGrupo.Text) && asignaturasCorrectas()) {
                Grupo grupo = new Grupo();
                grupo.propiedadStrNombreGrupo = textBoxNombreGrupo.Text;
                grupo.propiedadByNumeroAsignaturas = Convert.ToByte(checkedListAsignaturas.CheckedItems.Count);
                grupo.propiedadListaAsignaturas = new string[grupo.propiedadByNumeroAsignaturas];
                grupo.propiedadListaAlumnos = new List<Alumno>();
                rellenarAsignaturas(grupo);
                if (!File.Exists(grupo.propiedadStrNombreGrupo + ".gru")) {
                    FileStream stream = new FileStream(grupo.propiedadStrNombreGrupo + ".gru", FileMode.Create);
                    BinaryFormatter formater = new BinaryFormatter();
                    formater.Serialize(stream, grupo);
                    stream.Close();
                    MessageBox.Show("Grupo creado correctamente");
                    Close();
                }else{
                    errorNombre.SetError(textBoxNombreGrupo, "Ya existe un grupo con ese nombre");
                }
            } else if (String.IsNullOrEmpty(textBoxNombreGrupo.Text)) {
                errorNombre.SetError(textBoxNombreGrupo, "El nombre debe empezar por mayúscula e incluir solo letras");
            }
        }

        private bool asignaturasCorrectas() {
            if (checkedListAsignaturas.CheckedItems.Count >= 4 && checkedListAsignaturas.CheckedItems.Count <= 8) {
                return true;
            }
            errorAsignaturas.SetError(checkedListAsignaturas, "Introduce entre 4 y 8 asignaturas");
            return false;
        }

        private void rellenarAsignaturas(Grupo grupo) {
            byte i = 0;
            foreach (String asignatura in checkedListAsignaturas.CheckedItems) {
                grupo.propiedadListaAsignaturas[i] = asignatura;
                i++;
            }
        }
    }
}
