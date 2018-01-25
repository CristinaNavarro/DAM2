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
    class FichaRevista : Ficha {
        ushort usNumero;
        ushort usAnio;

        public FichaRevista(string strReferencia, string strTitulo, byte byNumeroEjemplares, ushort usNumero, ushort usAnio) : base(strReferencia, strTitulo, byNumeroEjemplares) {
            this.usNumero = usNumero;
            this.usAnio = usAnio;
        }

        public ushort propiedadByNumero {
            get {
                return usNumero;
            }
        }

        public ushort propiedadUsAnio {
            get {
                return usAnio;
            }
        }

        public override void imprimir() {
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Referencia: ", propiedadIntReferencia));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Título: ", propiedadStrTitulo));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Número de ejemplares: ", propiedadByNumeroEjemplares));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Número: ", this.usNumero));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Año: ", this.usAnio));
        }
    }
}
