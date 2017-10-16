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

    class Principal {

        public static void Main(string[] args) {

						#region DeclaraciónDeVariables
            ushort usModoSeleccionado = 0;
						float floCoeficienteX = 0;
						float floCoeficienteY = 0;
						float floCoeficienteZ = 0;
						Ecuacion ecuacion;
						ushort usFactor = 0;
						ushort usNumeroElementos = 0;
						Tabla tabla;
            string strCadena;
            bool boolValido = false;
						#endregion

						do {
                do {
										Console.Write("Seleccione una opción: \n \n \t 1. Ecuación \n \t 2. Tabla \n \t 3. Salir \n \n \t ->");
                    strCadena = Console.ReadLine();
                    boolValido = EsNumeroValido(strCadena, "UInt16");
                    if(boolValido) {
                        usModoSeleccionado = Convert.ToUInt16(strCadena);
                    } else {
                        strCadena = "";
                    }
                } while(!boolValido || (usModoSeleccionado > 4 && usModoSeleccionado < 0));

								switch(usModoSeleccionado) {
										case 1:
												Console.Clear();
												Console.Write("Ecuación de segundo grado: \n \n");

                        do {
                            Console.Write("\t Introduzca el primer parámetro \n \t ->");
                            strCadena = Console.ReadLine();
                            boolValido = EsNumeroValido(strCadena,"Single","Ecuación de segundo grado: \n \n");
                            if(boolValido) {
                              floCoeficienteX = Convert.ToSingle(strCadena);
                            } else {
                                strCadena = "";
                            }
                            if(floCoeficienteX == 0) {
                                ImprimirAlerta("ALERTA: El primer parámetro de una ecuación de segundo grado no puede ser 0.");
                                Console.Write("Ecuación de segundo grado: \n \n");
                            }
                        } while(!boolValido || floCoeficienteX == 0);

                        do {
                        Console.Write("\t Introduzca el segundo parámetro \n \t ->");
												strCadena = Console.ReadLine();
                        boolValido = EsNumeroValido(strCadena,"Single","Ecuación de segundo grado: \n \n\t El primer parámetro es " +floCoeficienteX +"\n");
                            if(boolValido) {
                              floCoeficienteY = Convert.ToSingle(strCadena);
                            } else {
                                strCadena = "";
                            }
                        } while(!boolValido);

                        do {
                        Console.Write("\t Introduzca el tercer parámetro \n \t ->");
                        strCadena = Console.ReadLine();
                        boolValido = EsNumeroValido(strCadena,"Single","Ecuación de segundo grado: \n \n\t El primer parámetro es " +floCoeficienteX +" y el segundo es " +floCoeficienteY +"\n");
                            if(boolValido) { 
                              floCoeficienteZ = Convert.ToSingle(strCadena);
                            } else {
                                strCadena = "";
                            }
                        } while(!boolValido);

												ecuacion = new Ecuacion(floCoeficienteX, floCoeficienteY, floCoeficienteZ);
												ecuacion.HallarResultado();
												break;

										case 2:
												Console.Clear();
												Console.Write("Tabla de multiplicar: \n \n");

                        do {
												    Console.Write("\t Introduce el factor: \n \t ->");
                            strCadena = Console.ReadLine();
                            boolValido = EsNumeroValido(strCadena,"UInt16","Tabla de multiplicar: \n \n");
                            if(boolValido) {
                                usFactor = Convert.ToUInt16(strCadena);
                            } else {
                               strCadena = "";
                            }
                        } while(!boolValido);

                        do {
												    Console.Write("\t Introduce el número de elementos: \n \t ->");
                            strCadena = Console.ReadLine();
                            boolValido = EsNumeroValido(strCadena,"UInt16","Tabla de multiplicar: \n \n \t El factor es: " +usFactor +"\n");
                            if(boolValido) {
                                usNumeroElementos = Convert.ToUInt16(strCadena);
                            } else {
                               strCadena = "";
                            }
                        } while(!boolValido);

												tabla = new Tabla(usFactor, usNumeroElementos);
												tabla.ImprimirTabla();
											  break;

										case 3:
												break;

										default:
												ImprimirAlerta("ALERTA: Acaba de introducir un número que no es correcto. Recuerde introducir un número entre 1 y 3");
												break;
								}
				    } while(usModoSeleccionado!=3);

        }
		#region MétodosComprobación

				public static void ImprimirAlerta(string alerta) { 
						Console.Clear();
						Console.BackgroundColor = ConsoleColor.Red;
						Console.WriteLine(alerta +" \n");
						Console.ResetColor();
				}

        public static bool EsNumeroValido(string strNumero, string strTipo) {
            bool valido = true;
            try {
                if(strTipo.Equals("Single")) {
                  float floComprobar = Convert.ToSingle(strNumero);
                } else {
                  ushort floComprobar = Convert.ToUInt16(strNumero);
                }

            } catch(OverflowException) {
							  ImprimirAlerta("ALERTA: Acaba de introducir un número que no es correcto.");
					      valido = false;
            } catch(FormatException) {
							  ImprimirAlerta("ALERTA: Acaba de introducir unos caracteres no numéricos.");
					      valido = false;
            }
            return valido;
        }
        public static bool EsNumeroValido(string strNumero, string strTipo, string enunciadoAnterior) {
            bool valido = true;
            try {
                if(strTipo=="Single") {
                  float floComprobar = Convert.ToSingle(strNumero);
                } else {
                  ushort floComprobar = Convert.ToUInt16(strNumero);
                }
            } catch(OverflowException) {
							  ImprimirAlerta("ALERTA: Acaba de introducir un número que no es correcto.");
                Console.Write(enunciadoAnterior);
					      valido = false;
            } catch(FormatException) {
							  ImprimirAlerta("ALERTA: Acaba de introducir unos caracteres no numéricos.");
                Console.Write(enunciadoAnterior);
					      valido = false;
            }
            return valido;
        }
        #endregion
    }
}
