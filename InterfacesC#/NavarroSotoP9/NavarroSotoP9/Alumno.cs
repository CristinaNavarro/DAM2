/* 
 * * PRÁCTICA.............: Práctica 9. 
 * * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
 * * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO DE LA PRÁCTICA: Aplicaciones de Formulario II. Más Controles. 
 * * FECHA DE ENTREGA.....: 25 de ENERO de 2018 
 */
using System;

namespace NavarroSotoP9 {
    [Serializable]
    public class Alumno {

        #region Atributos
        string strDNI;
        string strNombre;
        float[] arrayNotas;
        #endregion

        #region Constructor Alumnos básico
        public Alumno(string strNombre, float[] arrayNotas) {
            this.strNombre = strNombre;
            this.arrayNotas = arrayNotas;
        }

        public Alumno() {
           
        }
        #endregion

        #region Constructor Alumnos con matrícula
        public Alumno(string strNombre, float[] arrayNotas, string strDNI) {
            this.strDNI = strDNI;
            this.strNombre = strNombre;
            this.arrayNotas = arrayNotas;
        }
        #endregion

        #region Propiedades
        public string propiedadDNI {
            get {
                return this.strDNI;
            }
            set {
               this.strDNI = value;
            }
        }

        public string propiedadStrNombre {
            get {
                return this.strNombre;
            }
            set {
                this.strNombre = value;
            }
        }

        public float[] propiedadArrayNotas {
            get {
                return this.arrayNotas;
            }
            set {
                this.arrayNotas = value;
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
    }
}
