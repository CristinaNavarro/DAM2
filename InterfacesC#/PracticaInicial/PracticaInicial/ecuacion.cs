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
        float floCoeficienteX;
        float floCoeficienteY;
        float floCoeficienteZ;
				
				#endregion

        #region Constructor
        public Ecuacion(float floCoeficienteX, float floCoeficienteY, float floCoeficienteZ) {
            this.floCoeficienteX = floCoeficienteX;
            this.floCoeficienteY = floCoeficienteY;
            this.floCoeficienteZ = floCoeficienteZ;
        }
				#endregion

        #region Métodos
        public void HallarResultado() {
            float floDiscriminante;
				    float floResultadoSumando;
				    float floResultadoRestando;
				    float floControlImaginario;
				    string strFinalOperacion;

						floControlImaginario = (float) Math.Pow(this.floCoeficienteY, 2) - (4 * this.floCoeficienteX * this.floCoeficienteZ);
						if(floControlImaginario < 0) {
								floControlImaginario*=-1;
								floDiscriminante = Convert.ToSingle(Math.Sqrt(floControlImaginario));
                floDiscriminante /= 2 * this.floCoeficienteX;
								floResultadoSumando = - this.floCoeficienteY / (2 * this.floCoeficienteX);
								floResultadoRestando = - this.floCoeficienteY / (2 * this.floCoeficienteX);
								Console.Write(String.Format("\n \t Los resultados son: {0:G3}-{2:G3}*i y {1:G3}+{2:G3}*i \n", floResultadoRestando, floResultadoSumando, floDiscriminante));
								Console.Write("\nPulse la tecla Intro para volver al menú principal");
								strFinalOperacion = Console.ReadLine();
								Console.Clear();
						} else {
								floDiscriminante = Convert.ToSingle(Math.Sqrt(floControlImaginario));
								floResultadoSumando = (- this.floCoeficienteY + floDiscriminante) / (2 * this.floCoeficienteX);
								floResultadoRestando = (- this.floCoeficienteY - floDiscriminante) / (2 * this.floCoeficienteX);
								Console.Write(String.Format("\t Los resultados son {0:G3} y {1:G3} \n", floResultadoRestando, floResultadoSumando));
								Console.Write("\nPulse la tecla Intro para volver al menú principal");
								strFinalOperacion = Console.ReadLine();
								Console.Clear();
						}
				}
				#endregion
    }
}
