/* * PRÁCTICA.............: Práctica 4. 
 * * NOMBRE y APELLIDOS...: Cristina Navarro Soto
 * * CURSO y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO de la PRÁCTICA: Diseño de clases. Herencia y polimorfismo. 
 * * FECHA de ENTREGA.....: 23 de NOVIEMBRE de 2017 
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP4 {


    abstract class Ficha {

        string strReferencia;
        string strTitulo;
        byte byNumeroEjemplares;
        static int usNumOrden = 0;

        public Ficha(string strReferencia, string strTitulo, byte byNumeroEjemplares) {
            this.strReferencia = strReferencia + " - " + usNumOrden;
            this.strTitulo = strTitulo;
            this.byNumeroEjemplares = byNumeroEjemplares;
            System.Threading.Interlocked.Increment(ref usNumOrden);
        }

        public string propiedadIntReferencia {
            get {
                return strReferencia;
            }
        }

        public string propiedadStrTitulo {
            get {
                return strTitulo;
            }
        }

        public byte propiedadByNumeroEjemplares {
            get {
                return byNumeroEjemplares;
            }
        }

        public int propiedadIntNumOrden {
            get {
                return usNumOrden;
            }
        }

        public abstract void imprimir();

    }
}
