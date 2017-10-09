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

    class Principal{

        public static void Main(string[] args) {

            UInt16 uiModoSeleccionado;	
						//Este do while se repetirá mientras el usuario no seleccione la tercera opción del menú
						do{
								try{
										//Se introduce por teclado el modo deseado
										Console.Write("Seleccione uno de los modos: 1. Ecuacion 2. Tabla 3. Salir");
										uiModoSeleccionado = Convert.ToUInt16(Console.ReadLine());
										//Mediante un switch se crea una instancia de Ecuacion, de Tabla o se finaliza el programa
										switch (uiModoSeleccionado) {
												case 1:
														//Se piden 3 números y se crea el objeto ecuación y se llama a su método
														Console.Write("Introduzca el primer numero");
														Single sinCoeficienteX = Convert.ToSingle(Console.ReadLine());
														Console.Write("Introduzca el segundo numero");
														Single sinCoeficienteY = Convert.ToSingle(Console.ReadLine());
														Console.Write("Introduzca el tercer numero");
														Single sinCoeficienteZ = Convert.ToSingle(Console.ReadLine());
														Ecuacion ecuacion = new Ecuacion(sinCoeficienteX, sinCoeficienteY, sinCoeficienteZ);
														ecuacion.HallarResultado();
														break;
												case 2:
														//Se introducen los datos por consola y se crea el objeto tabla, llamando después a su método
														Console.Write("Introduce el factor:");
														UInt16 uiFactor = Convert.ToUInt16(Console.ReadLine());
														Console.Write("Introduce el numero de elementos: ");
														UInt16 uiNumeroElementos = Convert.ToUInt16(Console.ReadLine());
														Tabla tabla = new Tabla(uiFactor, uiNumeroElementos);
														tabla.ImprimirTabla();
														break;
												default:
														if(uiModoSeleccionado!=3)
														Console.WriteLine("No ha introducido un numero correcto");
														break;
										}
								} catch(System.OverflowException) {
										uiModoSeleccionado = 0;
										Console.WriteLine("No se ha introducido un numero correcto");
								}catch(FormatException) {
										uiModoSeleccionado  = 0;
										Console.WriteLine("No se ha introducido un numero");
								}  
						}while(uiModoSeleccionado!=3);
        }
    }
}
