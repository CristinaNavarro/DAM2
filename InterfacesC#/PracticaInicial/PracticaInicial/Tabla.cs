/*
* PRÁCTICA.............: Práctica Inicial.
* NOMBRE y APELLIDOS...: Cristina Navarro Soto
* CURSO y GRUPO........: 2º Desarrollo de Interfaces
* TÍTULO de la PRÁCTICA: Uso del IDE V.Studio
* FECHA de ENTREGA.....: 16 de Octubre de 2017
*/



using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PracticaInicial {
    class Tabla {

				#region Atributos
        UInt16 uiFactor;
        UInt16 uiNumeroElementos;
				#endregion

        #region Constructor
        public Tabla(UInt16 uiFactor, UInt16 uiNumeroElementos) {
            this.uiFactor = uiFactor;
            this.uiNumeroElementos = uiNumeroElementos;
        }
				#endregion

				#region Métodos
        //ImprimirTabla imprime la tabla de multiplicar del numero introducido hasta el numero de elementos indicado
        public void ImprimirTabla() {
            for(UInt16 i = 0; i <= this.uiNumeroElementos; i++) {
                Double uiResultado = uiFactor * i;
                Console.WriteLine(uiFactor + " x " + i + " = " + uiResultado);
            }
        }
				#endregion
    }
}
