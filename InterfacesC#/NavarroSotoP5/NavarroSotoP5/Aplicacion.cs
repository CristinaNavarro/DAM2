/*
 * * PRÁCTICA.............: Práctica 5. 
 * * NOMBRE Y APELLIDOS...: Cristina Navarro Soto 
 * * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO DE LA PRÁCTICA: Estructuras de Datos Internas y Manejo de Ficheros. 
 * * FECHA DE ENTREGA.....: 13 de DICIEMBRE de 2017
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;
using System.IO;
using System.Text;


namespace NavarroSotoP5 {
    class Aplicacion {

        #region Main
        public static void Main() {
            List<Grupo> listaGrupos = cargarDatosInicio();
            byte byOpcionMenu;
            do {
                Console.Clear();
                byOpcionMenu = menu();
                Grupo grupoDeseado = null;
                switch (byOpcionMenu) {
                    case 1:
                        Console.Clear();
                        listaGrupos.Add(grupoDeseado = creaGrupo(listaGrupos));
                        break;
                    case 2:
                        grupoDeseado = buscarGrupo(listaGrupos);
                        if (grupoDeseado != null) {
                            byte byOpcionSubmenu = 0;
                            do {
                                byOpcionSubmenu = submenu(grupoDeseado);
                                string strMatricula = "";
                                ushort usMatricula;
                                switch (byOpcionSubmenu) {
                                    case 1:
                                        grupoDeseado.añadirAlumno(creaAlumno(grupoDeseado.propiedadListaAsignaturas));
                                        break;
                                    case 2:
                                        Auxiliar.writeConColor(ConsoleColor.Gray, "\n\n\tIntroduce el número de matrícula del alumno a borrar: ");
                                        strMatricula = Auxiliar.controlIntroduccionNumero(strMatricula, 4); //se considera 9999 el número máximo de matrícula
                                        usMatricula = Convert.ToUInt16(strMatricula);
                                        if (grupoDeseado.buscaAlumno(usMatricula) == -1) {
                                            Auxiliar.imprimirAlerta("Ese alumno no existe o no pertenece a este grupo");
                                        } else {
                                            Auxiliar.imprimirAviso("Se ha borrado con éxito");
                                            grupoDeseado.borraAlumno(usMatricula);
                                        }
                                        break;
                                    case 3:
                                        Auxiliar.writeConColor(ConsoleColor.Gray, "\n\n\tIntroduce el número de matrícula del alumno a buscar: ");
                                        strMatricula = Auxiliar.controlIntroduccionNumero(strMatricula, 4); //se considera 9999 el número máximo de matrícula
                                        usMatricula = Convert.ToUInt16(strMatricula);
                                        if (grupoDeseado.buscaAlumno(usMatricula) == -1) {
                                            Auxiliar.imprimirAlerta("No existe un alumno con esa matrícula.");
                                        }
                                        break;
                                    case 4:
                                        if (grupoDeseado.propiedadListaAlumnos.Count != 0) {
                                            grupoDeseado.actaGrupo();
                                        } else {
                                            Auxiliar.imprimirAlerta("En ese grupo no se han guardado alumnos");
                                        }
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        Auxiliar.imprimirAlerta("Introduce un número entre 1 y 5");
                                        break;
                                }
                            } while (byOpcionSubmenu != 5);
                        } else {
                            Auxiliar.imprimirAlerta("No existe un grupo con ese nombre");
                        }
                        break;
                    case 3:
                        escribir(listaGrupos);
                        break;
                    default:
                        Auxiliar.imprimirAlerta("Introduce un número entre 1 y 3");
                        break;
                }
            } while (byOpcionMenu != 3);
        }
        #endregion

        #region Método menú
        static byte menu() {
            Console.Clear();
            string strOpcion = "";
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\tMENÚ PRINCIPAL");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\t1.Crear nuevo grupo \n\n\t\t2.Ver datos de un grupo \n\n\t\t3.Salir ");
            Auxiliar.writeConColor(ConsoleColor.Green, "\n\n\tIntroduzca la opción: ");
            strOpcion = Auxiliar.controlIntroduccionNumero(strOpcion, 1);
            return Convert.ToByte(strOpcion);
        }
        #endregion

        #region Método submenú
        static byte submenu(Grupo grupo) {
            Console.Clear();
            bool boValido;
            string strOpcion = "";
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\tSUBMENÚ GRUPO (datos del grupo " + grupo.propiedadStrNombreGrupo + ")");
            Auxiliar.writeConColor(ConsoleColor.Gray, "\n\n\t\t1.Añadir alumno \n\n\t\t2.Borrar alumno \n\n\t\t3.Consulta alumno \n\n\t\t4.Acta del grupo \n\n\t\t5.Volver al menú de inicio ");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\tIntroduzca la opción: ");
            strOpcion = Auxiliar.controlIntroduccionNumero(strOpcion, 1);
            boValido = Auxiliar.esNumeroValido(strOpcion, "Byte", "Solo se puede introducir un número entre 1 y 5");
            return Convert.ToByte(strOpcion);
        }
        #endregion

        #region Método creaGrupo
        static Grupo creaGrupo(List<Grupo> listaGrupos) {
            Console.Clear();
            //nombre grupo
            string strNombreGrupo = "";

            do {
                Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\tIntroduce el nombre del grupo: ");
                strNombreGrupo = Auxiliar.controlIntroduccionPalabra(strNombreGrupo, 10);
                if (nombreGrupoRepetido(listaGrupos, strNombreGrupo)) {
                    Auxiliar.imprimirAlerta("Nombre de grupo ya existente, introduce otro");
                }
            } while (nombreGrupoRepetido(listaGrupos, strNombreGrupo));
            //número asignaturas
            string strNumeroAsignaturas = "";
            byte byNumeroAsignaturas;
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\tIntroduce el número de asignaturas: ");
            strNumeroAsignaturas = Auxiliar.controlIntroduccionNumero(strNumeroAsignaturas, 1);
            byNumeroAsignaturas = Convert.ToByte(strNumeroAsignaturas);
            if (byNumeroAsignaturas < 4) {
                Auxiliar.writeConColor(ConsoleColor.Red, "\n\n\tEl número solo puede encontrarse entre 4 y 7.\n");
                Auxiliar.writeConColor(ConsoleColor.Red, "\tSe ha establecido automáticamente la cantidad de asignaturas como '4'\n");
                byNumeroAsignaturas = 4;
            } else if (byNumeroAsignaturas > 7) {
                Auxiliar.writeConColor(ConsoleColor.Red, "\n\n\tEl número solo puede encontrarse entre 4 y 7.\n");
                Auxiliar.writeConColor(ConsoleColor.Red, "\tSe ha establecido automáticamente la cantidad de asignaturas como '7'\n");
                byNumeroAsignaturas = 7;
            }
            //códigos asignaturas
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\tIntroduce los códigos de las asignaturas:");
            string[] arrayCodigoAsignaturas = new string[byNumeroAsignaturas];
            for (byte i = 0; i < byNumeroAsignaturas; i++) {
                Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t\tAsignatura " + i + ": ");
                string strCodigoAsignatura = "";
                arrayCodigoAsignaturas[i] = Auxiliar.controlIntroduccionPalabra(strCodigoAsignatura, 3).ToUpper();
            }
            //listaAlumnos
            List<Alumno> listaAlumnos = new List<Alumno>();
            return new Grupo(strNombreGrupo.ToUpper(), byNumeroAsignaturas, arrayCodigoAsignaturas);
        }
        #endregion

        #region Método creaAlumno
        static Alumno creaAlumno(string[] arrayAsignaturas) {
            Console.Clear();
            Auxiliar.writeConColor(ConsoleColor.Gray, "\n\tCREACIÓN DE ALUMNO");
            string strNombreAlumno = "";
            float[] arrayNotas = new float[arrayAsignaturas.Count()];
            //nombre
            Auxiliar.writeConColor(ConsoleColor.DarkYellow, "\n\n\t\tIntroduce el nombre del alumno: ");
            strNombreAlumno = Auxiliar.controlIntroduccionPalabra(strNombreAlumno, 10);
            //notas
            Auxiliar.writeConColor(ConsoleColor.DarkYellow, "\n\n\t\tIntroduce las notas del alumno: ");
            for (byte i = 0; i < arrayAsignaturas.Count(); i++) {
                Auxiliar.writeConColor(ConsoleColor.DarkYellow, "\n\n\t\t\tIntroduce la nota de " + arrayAsignaturas[i] + ": ");
                string strNumero = "";
                arrayNotas[i] = Convert.ToSingle(Auxiliar.controlIntroduccionNumero(strNumero, 2));
                if (arrayNotas[i] > 10) {
                    arrayNotas[i] = 10;
                    Auxiliar.writeConColor(ConsoleColor.Red, "\nSe ha establecido la nota como '10' al haber introducido un número incorrecto.");
                }
            }
            return new Alumno(strNombreAlumno.ToUpper(), arrayNotas);
        }
        #endregion

        #region Método buscarGrupo
        static Grupo buscarGrupo(List<Grupo> listaGrupo) {
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\tIntroduce el nombre del grupo:");
            Grupo grupoElegido = null;
            string strCodigoGrupo = "";
            strCodigoGrupo = Auxiliar.controlIntroduccionPalabra(strCodigoGrupo, 20);
            foreach (Grupo grupo in listaGrupo) {
                if (grupo.propiedadStrNombreGrupo.Equals(strCodigoGrupo, StringComparison.InvariantCultureIgnoreCase)) {
                    grupoElegido = grupo;
                }
            }
            return grupoElegido;
        }
        #endregion

        #region Método nombreGrupoRepetido control de no repetición de nombres de grupo
        static bool nombreGrupoRepetido(List<Grupo> listaGrupos, string strNombre) {
            foreach (Grupo grupo in listaGrupos) {
                if (grupo.propiedadStrNombreGrupo.Equals(strNombre, StringComparison.CurrentCultureIgnoreCase)) {
                    return true;
                }
            }
            return false;
        }
        #endregion

        #region Método escribir
        static void escribir(List<Grupo> listaGrupos) {
            if (!File.Exists("fichero.xml")) {
                XmlTextWriter writer = new XmlTextWriter("fichero.xml", Encoding.UTF8);
                writer.Close();
            }
            XmlDocument xmlDocument = new XmlDocument();
            XmlNode raizGrupos = xmlDocument.CreateElement("grupos");
            XmlNode raizAlumnos = xmlDocument.CreateElement("alumnos");
            XmlNode nodoGrupo;
            XmlNode nodoAlumnos;
            foreach (Grupo grupo in listaGrupos) {
                nodoGrupo = xmlDocument.CreateElement("grupo");
                XmlNode nombreGrupo = xmlDocument.CreateElement("nombregrupo");
                nombreGrupo.InnerText = grupo.propiedadStrNombreGrupo;
                XmlNode nodoNumeroAsignaturas = xmlDocument.CreateElement("numeroasignaturas");
                nodoNumeroAsignaturas.InnerText = grupo.propiedadByNumeroAsignaturas.ToString();
                XmlNode nodoListaAsignaturas = xmlDocument.CreateElement("listaasignaturas");
                foreach (string asignatura in grupo.propiedadListaAsignaturas) {
                    XmlNode nodoAsignatura = xmlDocument.CreateElement("asignatura");
                    nodoAsignatura.InnerText = asignatura;
                    nodoListaAsignaturas.AppendChild(nodoAsignatura);
                }
                nodoAlumnos = xmlDocument.CreateElement("alumnos");
                foreach (Alumno alumno in grupo.propiedadListaAlumnos) {
                    XmlNode nodoAlumno = xmlDocument.CreateElement("alumno");
                    XmlNode nodoNotas = xmlDocument.CreateElement("notas");
                    XmlNode nombreAlumno = xmlDocument.CreateElement("nombrealumno");
                    XmlNode matricula = xmlDocument.CreateElement("matricula");
                    nombreAlumno.InnerText = alumno.propiedadStrNombre;
                    matricula.InnerText = alumno.propiedadUsNumeroMatricula.ToString();
                    foreach (float nota in alumno.propiedadArrayNotas) {
                        XmlNode nodoNota = xmlDocument.CreateElement("nota");
                        nodoNota.InnerText = nota.ToString();
                        nodoNotas.AppendChild(nodoNota);
                    }
                    nodoAlumno.AppendChild(matricula);
                    nodoAlumno.AppendChild(nombreAlumno);
                    nodoAlumno.AppendChild(nodoNotas);
                    nodoAlumnos.AppendChild(nodoAlumno);
                }
                nodoGrupo.AppendChild(nombreGrupo);
                nodoGrupo.AppendChild(nodoNumeroAsignaturas);
                nodoGrupo.AppendChild(nodoListaAsignaturas);
                nodoGrupo.AppendChild(nodoAlumnos);
                raizGrupos.AppendChild(nodoGrupo);
            }
            xmlDocument.AppendChild(raizGrupos);
            xmlDocument.Save("fichero.xml");
        }
        #endregion

        #region Método cargarDatosInicio
        static List<Grupo> cargarDatosInicio() {
            List<Grupo> listaCargar = new List<Grupo>();
            Grupo grupoCargar;
            if (File.Exists("fichero.xml")) {
                XmlDocument xmlDocument = new XmlDocument();
                xmlDocument.Load("fichero.xml");
                XmlNodeList grupos = xmlDocument.GetElementsByTagName("grupos");
                XmlNodeList grupo = ((XmlElement)grupos[0]).GetElementsByTagName("grupo");
                foreach (XmlElement nodoGrupo in grupo) {
                    string nombreGrupo = nodoGrupo.ChildNodes[0].InnerText;
                    byte numeroAsignaturas = Convert.ToByte(nodoGrupo.ChildNodes[1].InnerText);
                    string[] arrayAsignaturas = new string[numeroAsignaturas];
                    for (byte i = 0; i < nodoGrupo.ChildNodes[2].ChildNodes.Count; i++) {
                        arrayAsignaturas[i] = nodoGrupo.ChildNodes[2].ChildNodes[i].InnerText;
                    }
                    grupoCargar = new Grupo(nombreGrupo, numeroAsignaturas, arrayAsignaturas);
                    if (nodoGrupo.ChildNodes.Count > 2) {
                        for (ushort i = 0; i < nodoGrupo.ChildNodes[3].ChildNodes.Count; i++) {
                            ushort matricula = Convert.ToUInt16(nodoGrupo.ChildNodes[3].ChildNodes[i].ChildNodes[0].InnerText);
                            string nombre = nodoGrupo.ChildNodes[3].ChildNodes[i].ChildNodes[1].InnerText;
                            float[] notas = new float[numeroAsignaturas];
                            for (byte j = 0; j < numeroAsignaturas; j++) {
                                notas[j] = Convert.ToUInt16(nodoGrupo.ChildNodes[3].ChildNodes[i].ChildNodes[2].ChildNodes[j].InnerText); //Cambiar tipo
                            }
                            grupoCargar.añadirAlumno(new Alumno(nombre, notas, matricula));
                        }
                    }
                    listaCargar.Add(grupoCargar);
                }
            }
            return listaCargar;
        }
        #endregion
    }
}

