/* 
* * PRÁCTICA.............: 
* * Práctica 8 * NOMBRE Y APELLIDOS...: Cristina Navarro Soto
* * CURSO Y GRUPO........: 2º Desarrollo de Interfaces 
* * TÍTULO DE LA PRÁCTICA: Generación de Componentes. 
* * FECHA DE ENTREGA.....: 11 de enero de 2018
*/
using System;
using System.Collections.Generic;

namespace NavarroSotoP8 {
    [Serializable]
    public class GrupoUsuarios {

        #region Atributos
        List<DatosUsuario> listUsuarios = new List<DatosUsuario>();
        #endregion

        #region Constructor
        public GrupoUsuarios() {
        }
        #endregion

        #region Propiedades
        public List<DatosUsuario> propiedadListUsuarios {
            get {
                return this.listUsuarios;
            }
            set {
                listUsuarios = value;
            }
        }
        #endregion

        #region Métodos
        public void addUsuario(DatosUsuario usuario) {
            listUsuarios.Add(usuario);
        }
        #endregion

    }
}
