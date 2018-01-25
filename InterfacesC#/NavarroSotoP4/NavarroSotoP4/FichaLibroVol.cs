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
    class FichaLibroVol : FichaLibro {
        ushort usNumeroVolumen;

        public FichaLibroVol(string strReferencia, string strTitulo, byte byNumeroEjemplares, string strAutor, string strEditorial, ushort usNumeroVolumen) : base(strReferencia, strTitulo, byNumeroEjemplares, strAutor, strEditorial) {
            this.usNumeroVolumen = usNumeroVolumen;
        }

        public ushort propiedadByNumeroVolumen {
            get {
                return usNumeroVolumen;
            }
        }

        public override void imprimir() {
            base.imprimir();
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Número de volumen: ", this.usNumeroVolumen));
        }
    }
}
