using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP2 {
    class Empleado {

        #region Atributos
        byte byCategoria;
        string strNif;
        string strNombre;
        byte byNumeroHijos;
        byte byNumeroTrienios;
        #endregion

        #region Constructores
        public Empleado() {
            this.byCategoria = 3;
            this.strNif = "12345678z";
            this.strNombre = "Fulanito";
            this.byNumeroHijos = 0;
            this.byNumeroTrienios = 0;
        }

        public Empleado(byte byCategoria, string strNif, string strNombre, byte byNumeroHijos, byte byNumeroTrienios) {
            this.byCategoria = byCategoria;
            this.strNif = strNif;
            this.strNombre = strNombre;
            this.byNumeroHijos = byNumeroHijos;
            this.byNumeroTrienios = byNumeroTrienios;
        }
        #endregion

        #region Propiedades
        public byte getByCategoria() {
            return this.byCategoria;
        }

        public string getStrNif() {
            return strNif;
        }

        public string getStrNombre() {
            return strNombre;
        }

        public byte getByNumeroHijos() {
            return this.byNumeroHijos;
        }

        public byte getByNumeroTrienios() {
            return this.byNumeroTrienios;
        }
        #endregion
    }
}
