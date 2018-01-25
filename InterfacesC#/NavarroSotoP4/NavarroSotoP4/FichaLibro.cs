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
    class FichaLibro : Ficha {

        string strAutor;
        string strEditorial;

        public FichaLibro(string strReferencia, string strTitulo, byte byNumeroEjemplares, string strAutor, string strEditorial) : base(strReferencia, strTitulo, byNumeroEjemplares) {
            this.strAutor = strAutor;
            this.strEditorial = strEditorial;
        }

        public string propiedadStrAutor {
            get {
                return strAutor;
            }
        }

        public string propiedadStrEditorial {
            get {
                return strEditorial;
            }
        }

        public override void imprimir() {
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Referencia: ", propiedadIntReferencia));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Título: ", propiedadStrTitulo));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Número de ejemplares: ", propiedadByNumeroEjemplares));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Autor: ", this.strAutor));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Editorial: ", this.strEditorial));
        }
    }
}
