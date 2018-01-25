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


namespace NavarroSotoP5 {
    class Grupo {

        #region Atributos
        string strNombreGrupo;
        byte byNumeroAsignaturas;
        string[] arrayCodigoAsignaturas; //3 caracteres
        List<Alumno> listaAlumnos;
        #endregion

        #region Constructor Grupo
        public Grupo(string strNombreGrupo, byte byNumeroAsignaturas, string[] arrayNumeroAsignaturas) {
            this.strNombreGrupo = strNombreGrupo;
            this.byNumeroAsignaturas = byNumeroAsignaturas;
            this.arrayCodigoAsignaturas = arrayNumeroAsignaturas;
            listaAlumnos = new List<Alumno>();
        }
        #endregion

        #region Propiedades
        public string propiedadStrNombreGrupo {
            get {
                return this.strNombreGrupo;
            }
        }

        public byte propiedadByNumeroAsignaturas {
            get {
                return this.byNumeroAsignaturas;
            }
        }

        public string[] propiedadListaAsignaturas {
            get {
                return this.arrayCodigoAsignaturas;
            }
        }

        //añadido para cargar datos desde archivo
        public List<Alumno> propiedadListaAlumnos {
            get {
                return this.listaAlumnos;
            }
        }
        #endregion

        #region Método añadirAlumno
        public void añadirAlumno(Alumno alumno) {
            listaAlumnos.Add(alumno);
            listaAlumnos.Sort();
        }
        #endregion

        #region Método buscaAlumno
        public short buscaAlumno(ushort usMatricula) {
            Console.Clear();
            for (short i = 0; i < listaAlumnos.Count; i++) {
                if (listaAlumnos.ElementAt(i).propiedadUsNumeroMatricula == usMatricula) {
                    Auxiliar.writeConColor(ConsoleColor.DarkYellow, "Los datos del alumno con matrícula " + usMatricula + " son:");
                    Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\t\tNombre: " + listaAlumnos.ElementAt(i).propiedadStrNombre + "\n\n\t\tNotas: ");
                    for (byte j = 0; j < arrayCodigoAsignaturas.Count(); j++) {
                        Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\t\t\tAsignatura " + arrayCodigoAsignaturas[j] + ": " + listaAlumnos.ElementAt(i).propiedadArrayNotas.ElementAt(j));
                    }
                    Auxiliar.writeConColor(ConsoleColor.White, "\n\n\n\tPulse cualquier tecla para continuar...");
                    if (Console.ReadKey() != null) {

                    }
                    return i;
                }
            }
            return -1;
        }
        #endregion

        #region Método borraAlumno
        public bool borraAlumno(ushort usMatricula) {
            for (short i = 0; i < listaAlumnos.Count; i++) {
                if (listaAlumnos.ElementAt(i).propiedadUsNumeroMatricula == usMatricula) {
                    listaAlumnos.RemoveAt(i);
                    return true;
                }
            }
            return false;
        }
        #endregion

        #region Método mediaAsignatura
        float mediaAsignatura(string strAsignatura) {
            byte byPosicion = 0;
            float floNota = 0;
            for (byte i = 0; i < arrayCodigoAsignaturas.Count(); i++) {
                if (arrayCodigoAsignaturas[i].Equals(strAsignatura, StringComparison.InvariantCultureIgnoreCase)) {
                    byPosicion = i;
                }
            }
            for (short i = 0; i < listaAlumnos.Count; i++) {
                floNota += listaAlumnos.ElementAt(i).propiedadArrayNotas.ElementAt(byPosicion);
            }
            floNota /= listaAlumnos.Count;
            return floNota;
        }
        #endregion

        #region Método actaGrupo
        public void actaGrupo() {
            Console.Clear();
            Auxiliar.writeConColor(ConsoleColor.Cyan, "ACTA DEL GRUPO " + propiedadStrNombreGrupo + "\n\n");
            byte bySinSuspensos = 0;
            byte byUnSuspenso = 0;
            byte byDosSuspensos = 0;
            byte byTresOMasSuspensos = 0;
            Console.ForegroundColor = ConsoleColor.Green;
            Console.Write(String.Format("\n{0,-10}{1,10}", "MATRÍCULA", "NOMBRE"));
            foreach (string asignatura in arrayCodigoAsignaturas) {
                Console.Write(String.Format("{0,6}", asignatura));
            }
            Console.Write(String.Format("{0,10}{1,10}", "MEDIA", "Nº SUS\n\n"));
            Console.ResetColor();
            foreach (Alumno alumno in listaAlumnos) {
                float media = 0;
                byte bySuspensos = 0;
                Console.Write(String.Format("{0,-8}{1,12}", alumno.propiedadUsNumeroMatricula, alumno.propiedadStrNombre));
                foreach (float nota in alumno.propiedadArrayNotas) {
                    Console.Write(String.Format("{0,6}", nota));
                    if (nota < 5) {
                        bySuspensos++;
                    }
                    media += nota;
                }
                media /= this.byNumeroAsignaturas;
                switch (bySuspensos) {
                    case 0:
                        bySinSuspensos++;
                        break;
                    case 1:
                        byUnSuspenso++;
                        break;
                    case 2:
                        byDosSuspensos++;
                        break;
                    case 3:
                        byTresOMasSuspensos++;
                        break;
                }
                Console.Write("{0,10}{1,6}\n\n", media.ToString("0.00"), bySuspensos);
            }
            Auxiliar.writeConColor(ConsoleColor.Green, "MEDIA");
            Console.Write("{0,15}", " ");
            foreach (string asignatura in arrayCodigoAsignaturas) {
                Console.Write(String.Format("{0,6}", mediaAsignatura(asignatura).ToString("0.00")));
            }
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\n\n\n\tNº de alumnos con 0 suspensos: " + bySinSuspensos + "\n");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\tNº de alumnos con 1 suspensos: " + byUnSuspenso + "\n");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\tNº de alumnos con 2 suspensos: " + byDosSuspensos + "\n");
            Auxiliar.writeConColor(ConsoleColor.Cyan, "\tNº de alumnos con 3 ó más sus: " + byTresOMasSuspensos + "\n");
            Auxiliar.writeConColor(ConsoleColor.White, "\n\n\n\tPulse cualquier tecla para continuar...");
            if (Console.ReadKey() != null) {

            }
        }
        #endregion
    }
}
