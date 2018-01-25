using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP6 {
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
        public byte getByCategoria {
            get {
                return this.byCategoria;
            }

        }

        public string getStrNif {
            get {
                return strNif;
            }
        }

        public string getStrNombre {
            get {
                return strNombre;
            }
        }

        public byte getByNumeroHijos {
            get {
                return this.byNumeroHijos;
            }
        }

        public byte getByNumeroTrienios {
            get {
                return this.byNumeroTrienios;
            }
        }
        #endregion
    }
}
