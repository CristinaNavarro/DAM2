/* 
 * * PRÁCTICA.............: Práctica 9. 
 * * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
 * * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO DE LA PRÁCTICA: Aplicaciones de Formulario II. Más Controles. 
 * * FECHA DE ENTREGA.....: 25 de ENERO de 2018 
 */
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Windows.Forms;

namespace NavarroSotoP9 {
    public partial class gestionGrupos : Form {

        private Grupo grupo;

        public gestionGrupos() {
            InitializeComponent();
            gridDatosAlumnos.CellEndEdit += new DataGridViewCellEventHandler(gridDatosAlumnos_CellLeave);
        }

        #region Botón crear grupo
        private void btnCrearGrupo_Click(object sender, EventArgs e) {
            new formNuevoGrupo().Show();
        }
        #endregion

        #region Boton abrir grupo o informe
        private void btnAbrirGrupo_Click(object sender, EventArgs e) {
            openFileDialog1.InitialDirectory = "./";
            openFileDialog1.Filter = "archivos de grupo (*.gru)|*.gru|archivos de informe (*.inf)|*.inf";
            openFileDialog1.DefaultExt = "archivos de grupo (*.gru)|*.gru";
            openFileDialog1.FilterIndex = 2;
            openFileDialog1.RestoreDirectory = true;
            openFileDialog1.FileName = "";
            openFileDialog1.ShowDialog();
        }
        #endregion

        #region Botón guardar grupo o informe
        private void btnGuardarGrupo_Click(object sender, EventArgs e) {
            List<Alumno> listaAlumnos = new List<Alumno>();
            float[] notas = null;
            for (int i = 0; i < gridDatosAlumnos.Rows.Count; i++) {
                if (gridDatosAlumnos.Rows[i].Visible == true && gridDatosAlumnos.Rows[i].Cells[0].Value != null && gridDatosAlumnos.Rows[i].Cells[1].Value != null) {
                    Alumno alumno = new Alumno();
                    if (gridDatosAlumnos.Rows[i].Cells[0].Value.ToString().Length != 0 && gridDatosAlumnos.Rows[i].Cells[1].Value.ToString().Length != 0) {
                        alumno.propiedadDNI = gridDatosAlumnos.Rows[i].Cells[0].Value.ToString();
                        alumno.propiedadStrNombre = gridDatosAlumnos.Rows[i].Cells[1].Value.ToString();
                        notas = new float[gridDatosAlumnos.Columns.Count - 2];
                        for (byte b = 2; b < gridDatosAlumnos.Columns.Count; b++) {
                            if (gridDatosAlumnos.Rows[i].Cells[b].Value != null) {
                                notas[b - 2] = Convert.ToSingle(gridDatosAlumnos.Rows[i].Cells[b].Value.ToString());
                            }
                        }
                        alumno.propiedadArrayNotas = notas;
                        listaAlumnos.Add(alumno);
                    }
                }
            }
            grupo.propiedadListaAlumnos = listaAlumnos;
            FileStream stream;
            if (checkAprobados.Checked) {
                stream = new FileStream(groupTablaGrupo.Text + ".inf", FileMode.Create);
                MessageBox.Show("Informe guardado correctamente.");
            } else {
                stream = new FileStream(groupTablaGrupo.Text + ".gru", FileMode.Create);
                MessageBox.Show("Grupo guardado correctamente.");
            }
            BinaryFormatter formater = new BinaryFormatter();
            formater.Serialize(stream, grupo);
            stream.Close();
        }
        #endregion

        #region Botón salir
        private void btnSalir_Click(object sender, EventArgs e) {
            if (MessageBox.Show("¿Desea Salir?", "Salir", MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button1) == System.Windows.Forms.DialogResult.Yes) {
                Application.Exit();
            }
        }
        #endregion

        #region Opción menú nuevo grupo
        private void nuevoGrupoToolStripMenuItem_Click(object sender, EventArgs e) {
            new formNuevoGrupo().Show();
        }
        #endregion

        #region Botón aceptar abrir archivo
        private void openFileDialog1_FileOk(object sender, CancelEventArgs e) {
            checkAprobados.Checked = false;
            gridDatosAlumnos.Columns.Clear();
            string nombreArchivo = openFileDialog1.FileName;
            FileStream stream = new FileStream(nombreArchivo, FileMode.Open);
            BinaryFormatter formater = new BinaryFormatter();
            grupo = (Grupo)(formater.Deserialize(stream));
            groupTablaGrupo.Text = grupo.propiedadStrNombreGrupo;
            stream.Close();

            gridDatosAlumnos.Columns.Add("Column", "DNI");
            gridDatosAlumnos.Columns.Add("Column", "Nombre");
            foreach (String asignatura in grupo.propiedadListaAsignaturas) {
                gridDatosAlumnos.Columns.Add("Column", asignatura);
            }
            for (int x = 0; x < grupo.propiedadListaAlumnos.Count; x++) {
                DataGridViewRow row = (DataGridViewRow)gridDatosAlumnos.Rows[0].Clone();
                gridDatosAlumnos.Rows.Add(row);
            }

            int i = 0;
            foreach (Alumno alumno in grupo.propiedadListaAlumnos) {
                gridDatosAlumnos.Rows[i].Cells[0].Value = alumno.propiedadDNI;
                gridDatosAlumnos.Rows[i].Cells[1].Value = alumno.propiedadStrNombre;
                byte j = 2;
                foreach (float nota in alumno.propiedadArrayNotas) {
                    gridDatosAlumnos.Rows[i].Cells[j].Value = String.Format("{0:0.00}", nota);
                    j++;
                }
                i++;
            }
            groupTablaGrupo.Show();
            if (nombreArchivo.Contains(".inf")) {
                gridDatosAlumnos.Enabled = false;
                checkAprobados.Hide();
                btnGuardarGrupo.Enabled = false;
            } else {
                gridDatosAlumnos.Enabled = true;
                checkAprobados.Show();
                btnGuardarGrupo.Enabled = true;
            }

        }
        #endregion

        #region Control introducción de datos
        private void gridDatosAlumnos_CellLeave(object sender, DataGridViewCellEventArgs e) {
            if (gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value != null) {
                switch (e.ColumnIndex) {
                    case 0:
                        int intRow = e.RowIndex;
                        if (!esDNIValido(gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value.ToString())) {
                            gridDatosAlumnos.Rows[intRow].Cells[e.ColumnIndex].Value = "";
                            MessageBox.Show("DNI incorrecto");
                        } else {
                            for (int i = 0; i < gridDatosAlumnos.Rows.Count; i++) {
                                if (gridDatosAlumnos.Rows[i].Cells[e.ColumnIndex].Value != null && gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value != null) {
                                    if (gridDatosAlumnos.Rows[i].Cells[e.ColumnIndex].Value.ToString().Equals(gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value.ToString())) {
                                        if (intRow != i) {
                                            gridDatosAlumnos.Rows[intRow].Cells[e.ColumnIndex].Value = "";
                                            MessageBox.Show("DNI repetido");
                                            i = gridDatosAlumnos.Rows.Count;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 1:
                        if (String.IsNullOrWhiteSpace(gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value.ToString()) || !contieneSoloLetras(gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value.ToString())) {
                            gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value = "";
                            MessageBox.Show("El nombre solo puede contener letras");
                        }
                        break;
                    default:
                        if (!numeroValido(gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value.ToString())) {
                            gridDatosAlumnos.Rows[e.RowIndex].Cells[e.ColumnIndex].Value = "0";
                        }
                        break;
                }
            }
        }
        #endregion

        #region Método DNI válido
        private bool esDNIValido(string strDNI) {
            uint intNumeroDNI;
            try {
                intNumeroDNI = Convert.ToUInt32(strDNI.Substring(0, strDNI.Length - 1));
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

        #region Método comprobación String válido
        private bool contieneSoloLetras(String strCadena) {
            foreach (char a in strCadena) {
                if (!char.IsLetter(a)) {
                    return false;
                }
            }
            return true;
        }
        #endregion

        #region Método comprobación número válido
        private bool numeroValido(String strNota) {
            try {
                float floComprobacion = Convert.ToSingle(strNota);
                if (floComprobacion <= 10 && floComprobacion >= 0) {
                    return true;
                } else {
                    MessageBox.Show("Las notas deben ser números mayores de 0 y menores de 10");
                }
            } catch (Exception e) {
                MessageBox.Show("Las notas deben ser números mayores de 0 y menores de 10");
            }
            return false;
        }
        #endregion

        #region Modificación Checked aprobados
        private void checkAprobados_CheckedChanged(object sender, EventArgs e) {
            gridDatosAlumnos.Rows.Clear();
            if (checkAprobados.Checked) {
                btnGuardarGrupo.Text = "Guardar informe";
                groupTablaGrupo.Text = grupo.propiedadStrNombreGrupo + "_aprobados";
                int i = 0;
                foreach (Alumno alumno in grupo.propiedadListaAlumnos) {
                    DataGridViewRow row = (DataGridViewRow)gridDatosAlumnos.Rows[0].Clone();
                    gridDatosAlumnos.Rows.Add(row);
                    if (todasAprobadas(alumno.propiedadArrayNotas)) {
                        gridDatosAlumnos.Rows[i].Cells[0].Value = alumno.propiedadDNI;
                        gridDatosAlumnos.Rows[i].Cells[1].Value = alumno.propiedadStrNombre;
                        byte j = 2;
                        foreach (float nota in alumno.propiedadArrayNotas) {
                            gridDatosAlumnos.Rows[i].Cells[j].Value = nota;
                            j++;
                        }
                        i++;
                    } else {
                        gridDatosAlumnos.Rows[i].Visible = false;
                        i++;
                    }
                }
            } else {
                btnGuardarGrupo.Text = "Guardar grupo";
                int i = 0;
                foreach (Alumno alumno in grupo.propiedadListaAlumnos) {
                    DataGridViewRow row = (DataGridViewRow)gridDatosAlumnos.Rows[0].Clone();
                    gridDatosAlumnos.Rows.Add(row);
                    gridDatosAlumnos.Rows[i].Cells[0].Value = alumno.propiedadDNI;
                    gridDatosAlumnos.Rows[i].Cells[1].Value = alumno.propiedadStrNombre;
                    byte j = 2;
                    foreach (float nota in alumno.propiedadArrayNotas) {
                        gridDatosAlumnos.Rows[i].Cells[j].Value = nota;
                        j++;
                    }
                    i++;
                }
                groupTablaGrupo.Text = grupo.propiedadStrNombreGrupo;
            }
        }
        #endregion

        #region Comprobación alumnos aprobados
        private bool todasAprobadas(float[] arrayNotas) {
            foreach (float nota in arrayNotas) {
                if (nota < 5) {
                    return false;
                }
            }
            return true;
        }
        #endregion

        #region Eliminar fila
        private void btnEliminarFila_Click(object sender, EventArgs e) {
            gridDatosAlumnos.CurrentRow.Visible = false;
        }
        #endregion

        #region Opción menú abrir grupo
        private void abrirGrupoToolStripMenuItem_Click(object sender, EventArgs e) {
            btnAbrirGrupo.PerformClick();
        }
        #endregion

        private void checkAprobados_MouseHover(object sender, EventArgs e) {
            tooltipPrincipal.Show("ffff", checkAprobados);
        }
    }
}


