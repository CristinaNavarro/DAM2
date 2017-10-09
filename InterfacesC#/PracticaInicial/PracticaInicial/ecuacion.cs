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

namespace PracticaInicial{
    class Ecuacion{

				#region Atributos
        //Atributos
        Single sinCoeficienteX;
        Single sinCoeficienteY;
        Single sinCoeficienteZ;
				#endregion

        #region Constructor
        public Ecuacion(Single sinCoeficienteX, Single sinCoeficienteY, Single sinCoeficienteZ) {
            this.sinCoeficienteX = sinCoeficienteX;
            this.sinCoeficienteY = sinCoeficienteY;
            this.sinCoeficienteZ = sinCoeficienteZ;
        }
				#endregion

        #region Métodos
        //HallarResultado halla el resultado de la ecuación cuadrática de los números introducidos por teclado
        public void HallarResultado() {
            
								Single sinControlImaginario = (Single) Math.Pow(this.sinCoeficienteY, 2) - 4 * this.sinCoeficienteX * this.sinCoeficienteZ;
								if(sinControlImaginario<0){
									sinControlImaginario*=-1;
									Single sinDiscriminante = Convert.ToSingle(Math.Sqrt(sinControlImaginario));
									Single sinResultadoSumando = (-this.sinCoeficienteY + sinDiscriminante)/(2*this.sinCoeficienteX);
									Single sinResultadoRestando = (-this.sinCoeficienteY - sinDiscriminante)/(2*this.sinCoeficienteX);
									Console.Write("Los resultados son " + sinResultadoRestando + "*i y " + sinResultadoSumando +"*i, siendo i el número imaginario");
								}else{
									Single sinDiscriminante = Convert.ToSingle(Math.Sqrt(sinControlImaginario));
									Single sinResultadoSumando = (-this.sinCoeficienteY + sinDiscriminante)/(2*this.sinCoeficienteX);
									Single sinResultadoRestando = (-this.sinCoeficienteY - sinDiscriminante)/(2*this.sinCoeficienteX);
									Console.Write("Los resultados son " + sinResultadoRestando + " y " + sinResultadoSumando);
								}
            
				}

				#endregion
    }
}
