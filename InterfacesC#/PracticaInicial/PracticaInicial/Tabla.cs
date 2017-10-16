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
        ushort usFactor;
        ushort usNumeroElementos;
				#endregion

        #region Constructor
        public Tabla(ushort usFactor, ushort usNumeroElementos) {
            this.usFactor = usFactor;
            this.usNumeroElementos = usNumeroElementos;
        }
				#endregion

				#region Métodos

        public void ImprimirTabla() {
            string strFinalOperacion;
            ushort floUltimaPagina = (ushort) (usNumeroElementos % 10);
            float floPaginas = (usNumeroElementos / 10);
            ushort floUltimoElemento = 1;   

            for(ushort j = 1; j <= floPaginas; j++) {
                Console.Clear();

                if(floUltimaPagina == 0) {
                    Console.Write("Resultado de la tabla de " + usFactor + " -- página " + j + " de " + floPaginas + "\n \n");
                } else {
                    Console.Write("Resultado de la tabla de " + usFactor + " -- página " + j + " de " + (floPaginas + 1) + "\n \n");
                }

                floUltimoElemento = imprimirOperaciones(floUltimoElemento, (ushort) (j * 10));
                Console.Write("\nPulse la tecla Intro para pasar a la siguiente página.");
                strFinalOperacion = Console.ReadLine();
                Console.Clear();
            }

            if(floUltimaPagina != 0) {
                Console.Write("Resultado de la tabla de " + usFactor + " -- página " + (floPaginas + 1) + " de " + (floPaginas + 1) + "\n \n");
                floUltimoElemento = imprimirOperaciones(floUltimoElemento, (ushort) (floUltimoElemento + floUltimaPagina - 1));
            }

            Console.Write("\nFin de las páginas. Pulse la tecla Intro para volver al menú principal.");
            strFinalOperacion = Console.ReadLine();
            Console.Clear();
        }

        ushort imprimirOperaciones(ushort usValorMinimo, ushort usValorMaximo) {
				    ulong ulResultado;
            for(ushort i = usValorMinimo; i <= usValorMaximo; i++) {
                    ulResultado = (ulong) usFactor * i;
                    Console.WriteLine("\t " + usFactor + " x " +  i + " = " + ulResultado);
            }
            return ++usValorMaximo;
        }
				#endregion
    }
}
