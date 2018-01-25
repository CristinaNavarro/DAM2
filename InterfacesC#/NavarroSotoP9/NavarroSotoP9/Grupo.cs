/* 
 * * PRÁCTICA.............: Práctica 9. 
 * * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
 * * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO DE LA PRÁCTICA: Aplicaciones de Formulario II. Más Controles. 
 * * FECHA DE ENTREGA.....: 25 de ENERO de 2018 
 */
using System;
using System.Collections.Generic;

namespace NavarroSotoP9 {
    [Serializable]
    public class Grupo {

        #region Atributos
        string strNombreGrupo;
        byte byNumeroAsignaturas;
        string[] arrayCodigoAsignaturas; 
        List<Alumno> listaAlumnos;
        #endregion

        #region Constructor Grupo
        public Grupo(string strNombreGrupo, byte byNumeroAsignaturas, string[] arrayNumeroAsignaturas) {
            this.strNombreGrupo = strNombreGrupo;
            this.byNumeroAsignaturas = byNumeroAsignaturas;
            this.arrayCodigoAsignaturas = arrayNumeroAsignaturas;
            listaAlumnos = new List<Alumno>();
        }

        public Grupo() {
           
        }
        #endregion

        #region Propiedades
        public string propiedadStrNombreGrupo {
            get {
                return this.strNombreGrupo;
            }
            set {
                this.strNombreGrupo = value;
            }
        }

        public byte propiedadByNumeroAsignaturas {
            get {
                return this.byNumeroAsignaturas;
            }
            set {
                this.byNumeroAsignaturas = value;
            }
        }

        public string[] propiedadListaAsignaturas {
            get {
                return this.arrayCodigoAsignaturas;
            }
            set {
                this.arrayCodigoAsignaturas = value;
            }
        }

        public List<Alumno> propiedadListaAlumnos {
            get {
                return this.listaAlumnos;
            }
            set {
                this.listaAlumnos = value;
            }
        }
        #endregion
    }
}
