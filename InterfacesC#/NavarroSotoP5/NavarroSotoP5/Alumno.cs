/*
 * * PRÁCTICA.............: Práctica 5. 
 * * NOMBRE Y APELLIDOS...: Cristina Navarro Soto 
 * * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO DE LA PRÁCTICA: Estructuras de Datos Internas y Manejo de Ficheros. 
 * * FECHA DE ENTREGA.....: 13 de DICIEMBRE de 2017
 */

using System;


namespace NavarroSotoP5 {
    class Alumno : IComparable<Alumno> {

        #region Atributos
        ushort usNumeroMatricula;
        string strNombre;
        float[] arrayNotas;
        static ushort usContador;
        static ushort usNuevosCreados;
        #endregion

        #region Constructor Alumnos básico
        public Alumno(string strNombre, float[] arrayNotas) {
            this.usNumeroMatricula = Convert.ToUInt16(usContador + usNuevosCreados);
            this.strNombre = strNombre;
            this.arrayNotas = arrayNotas;
            usNuevosCreados++;
        }
        #endregion

        #region Constructor Alumnos con matrícula
        public Alumno(string strNombre, float[] arrayNotas, ushort usNumeroMatricula) {
            this.usNumeroMatricula = usNumeroMatricula;
            this.strNombre = strNombre;
            this.arrayNotas = arrayNotas;
            if (usContador <= usNumeroMatricula) {
                usContador = ++usNumeroMatricula;
            }
        }
        #endregion

        #region Propiedades
        public ushort propiedadUsNumeroMatricula {
            get {
                return this.usNumeroMatricula;
            }
        }

        public string propiedadStrNombre {
            get {
                return this.strNombre;
            }
        }

        public float[] propiedadArrayNotas {
            get {
                return this.arrayNotas;
            }
        }
        #endregion

        #region Método mediaAlumno
        float mediaAlumno() {
            float floResultado = 0;
            for (byte i = 0; i < this.arrayNotas.Length; i++) {
                floResultado += this.arrayNotas[i];
            }
            floResultado /= this.arrayNotas.Length;
            return floResultado;
        }
        #endregion

        #region Método numSusAlumno
        byte numSusAlumno() {
            byte bySuspensos = 0;
            for (byte i = 0; i < this.arrayNotas.Length; i++) {
                if (this.arrayNotas[i] < 5) {
                    bySuspensos++;
                }
            }
            return bySuspensos;
        }
        #endregion

        #region Método CompareTo
        public int CompareTo(Alumno other) {
            return this.strNombre.CompareTo(other.propiedadStrNombre);
        }
        #endregion
    }
}
