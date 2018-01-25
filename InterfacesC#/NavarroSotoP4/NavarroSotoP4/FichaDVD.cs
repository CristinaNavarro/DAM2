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
    class FichaDVD : Ficha {
        string strDirector;
        ushort usAnio;
        string[] arrayActores;

        public FichaDVD(string strReferencia, string strTitulo, byte byNumeroEjemplares, string strDirector, ushort usAnio, string[] arrayActores) : base(strReferencia, strTitulo, byNumeroEjemplares) {
            this.strDirector = strDirector;
            this.usAnio = usAnio;
            this.arrayActores = arrayActores;
        }

        public string propiedadStrDirector {
            get {
                return strDirector;
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
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Director: ", this.strDirector));
            Console.WriteLine(String.Format("{0,-25}{1,25}", "Año: ", this.usAnio));
            Console.WriteLine(String.Format("{0,-25}","Actores: "));
            for (byte i = 0; i < arrayActores.Length; i++) {
                Console.Write("\n\t" + arrayActores[i] + "\n");
            }
        }
    }
}
