/* 
* * PRÁCTICA.............: 
* * Práctica 8 * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
* * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
* * TÍTULO DE LA PRÁCTICA: Generación de Componentes. 
* * FECHA DE ENTREGA.....: 11 de enero de 2018
*/
using System;

namespace NavarroSotoP8 {
    [Serializable]
    public class DatosUsuario {
        
        #region Atributos
        private string strNombre;
        private string strUsuario;
        private string strCorreo;
        private string strContraseña;
        #endregion

        #region Constructores
        public DatosUsuario(string strNombre, string strUsuario, string strCorreo, string strContraseña) {
            this.strNombre = strNombre;
            this.strUsuario = strUsuario;
            this.strCorreo = strCorreo;
            this.strContraseña = strContraseña;
        }

        public DatosUsuario() {
          
        }
        #endregion

        #region Propiedades
        public string propiedadStrNombre {
            get {
                return this.strNombre;
            }
            set {
                this.strNombre = value;
            }
        }

        public string propiedadStrUsuario {
            get {
                return this.strUsuario;
            }
            set {
                this.strUsuario = value;
            }
        }

        public string propiedadStrCorreo {
            get {
                return this.strCorreo;
            }
            set {
                this.strCorreo = value;
            }
        }

        public string propiedadStrContraseña {
            get {
                return this.strContraseña;
            }
            set {
                this.strContraseña = value;
            }
        }
        #endregion

    }
}
