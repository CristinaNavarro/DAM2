using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP2 {
    class Principal {
        static void Main(string[] args) {

            #region Variables de control de introducción de datos
            string strNombre;
            string strNif;
            string strCategoria;
            string strTrienios;
            string strHijos;
            string strHorasExtra;
            string strFecha;
            byte byCategoria = 0;
            byte byNumeroTrienios = 0;
            byte byNumeroHijos = 0;
            byte byNumeroHorasExtra = 0;
            bool boValidez;
            string[] arrayFecha;
            string[] arraySeparador = new string[] { "/" };
            string strAlerta;
            DateTime dateFechaNomina = new DateTime(2008, 2, 2);
            #endregion

            #region Introducción datos empleado
            do {
                Console.WriteLine("Teclee los datos del empleado\n");
                Console.Write("\tNombre: ");
                strNombre = Console.ReadLine();
                boValidez = Utilidades.contieneNumero(strNombre);
                if (String.IsNullOrWhiteSpace(strNombre) || boValidez || Utilidades.contieneSímbolo(strNombre)) {
                    boValidez = true;
                    Utilidades.imprimirAlerta("El nombre no puede contener números, símbolos ni quedar en blanco.", "");
                } else if (strNombre.Length < 4) {
                    boValidez = true;
                    Utilidades.imprimirAlerta("El nombre debe tener como mínimo 4 caracteres.", "");
                }
            } while (boValidez);

            do {
                strAlerta = "Teclee los datos del empleado\n\n\tNombre: " + strNombre;
                Console.Write("\n\tNIF: ");
                strNif = Console.ReadLine();
                boValidez = Utilidades.esDNIValido(strNif, "Teclee los datos del empleado\n\n\tNombre: " + strNombre);
            } while (!boValidez);

            do {
                if (boValidez) {
                    strAlerta += "\n\n\tNIF: " + strNif;
                }
                Console.Write("\n\tCategoría: ");
                strCategoria = Console.ReadLine();
                boValidez = Utilidades.esNumeroValido(strCategoria, "byte", strAlerta);
                if (boValidez) {
                    byCategoria = Convert.ToByte(strCategoria);
                    if (byCategoria > 3 || byCategoria < 1) {
                        boValidez = false;
                        Utilidades.imprimirAlerta("Las categorías son 1, 2 y 3", strAlerta);
                    }
                }
            } while (!boValidez);

            do {
                if (boValidez) {
                    strAlerta += "\n\n\tCategoría: " + byCategoria;
                }
                Console.Write("\n\tNº Trienios: ");
                strTrienios = Console.ReadLine();
                boValidez = Utilidades.esNumeroValido(strTrienios, "byte", strAlerta);
                if (boValidez) {
                    byNumeroTrienios = Convert.ToByte(strTrienios);
                    if (byNumeroTrienios > 20) {
                        boValidez = false;
                        Utilidades.imprimirAlerta("No es posible que una persona tenga más de 20 trienios.", strAlerta);
                    }
                }
            } while (!boValidez);

            do {
                if (boValidez) {
                    strAlerta += "\n\n\tNº Trienios: " + byNumeroTrienios;
                }
                Console.Write("\n\tNº Hijos: ");
                strHijos = Console.ReadLine();
                boValidez = Utilidades.esNumeroValido(strHijos, "Int16", strAlerta);
                if (boValidez) {
                    if (Convert.ToInt16(strHijos) < 0) {
                        byNumeroHijos = 0;
                        Utilidades.imprimirAlerta("No es posible tener un número negativo de hijos", strAlerta + "\n\n\tNº Hijos: " + byNumeroHijos);
                    } else {
                        boValidez = Utilidades.esNumeroValido(strHijos, "byte", strAlerta);
                        if (boValidez) {
                            byNumeroHijos = Convert.ToByte(strHijos);
                            if (byNumeroHijos > 15) {
                                boValidez = false;
                                Utilidades.imprimirAlerta("No se considera posible tener más de 15 hijos", strAlerta);
                            }
                        }
                    }
                    
                }
            } while (!boValidez);
            #endregion

            #region Introducción datos de nómina
            do {
                if (boValidez) {
                    strAlerta += "\n\n\tNº Hijos: " + byNumeroHijos;
                }
                Console.WriteLine("\n\nTeclee los datos referentes a la nómina");
                Console.Write("\n\tFecha de liquidación (dd/mm/aaaa): ");
                strFecha = Console.ReadLine();
                arrayFecha = strFecha.Split(arraySeparador, StringSplitOptions.RemoveEmptyEntries);
                if (arrayFecha.Length == 3) {
                    boValidez = Utilidades.esNumeroValido(arrayFecha[0], "byte", strAlerta)
                    && Utilidades.esNumeroValido(arrayFecha[1], "byte", strAlerta)
                    && Utilidades.esNumeroValido(arrayFecha[2], "ushort", strAlerta);
                    if (boValidez) {
                        try {
                            dateFechaNomina = new DateTime(Convert.ToUInt16(arrayFecha[2]), Convert.ToByte(arrayFecha[1]),
                                Convert.ToByte(arrayFecha[0]));
                        } catch (ArgumentOutOfRangeException) {
                            boValidez = false;
                            Utilidades.imprimirAlerta("Recuerde introducir la fecha con el formato dd/mm/aaaa", strAlerta);
                        }
                        if (Convert.ToInt16(arrayFecha[2]) < 2017 || Convert.ToInt16(arrayFecha[2]) > 3000) {
                            boValidez = false;
                            Utilidades.imprimirAlerta("El rango de años permitido es desde 2017 hasta 3000", strAlerta);
                        }
                    }
                } else {
                    boValidez = false;
                    Utilidades.imprimirAlerta("Recuerde introducir la fecha con el formato dd/mm/aaaa", strAlerta);
                }
            } while (!boValidez);

            do {
                if (boValidez) {
                    strAlerta += "\n\n\nTeclee los datos referentes a la nómina\n\n\tFecha de liquidación (dd/mm/aaaa): "
                        + dateFechaNomina.ToString("dd/MM/yyyy");
                }
                Console.Write("\n\tNº de horas extras: ");
                strHorasExtra = Console.ReadLine();
                boValidez = Utilidades.esNumeroValido(strHorasExtra, "byte", strAlerta);
                if (boValidez) {
                    byNumeroHorasExtra = Convert.ToByte(strHorasExtra);
                    if (byNumeroHorasExtra > 100) {
                        boValidez = false;
                        Utilidades.imprimirAlerta("No se considera posible tener más de 100 horas extra al mes", strAlerta);
                    }
                }
            } while (!boValidez);
            Console.BackgroundColor = ConsoleColor.Blue;
            Console.Write("\nPulse una tecla para calcular y presentar la hoja salarial");
            Console.ResetColor();
            #endregion

            #region Creación Empleado y Nómina
            Empleado empleado = new Empleado(byCategoria, strNif, strNombre, byNumeroHijos, byNumeroTrienios);
            Nomina nomina = new Nomina(empleado, dateFechaNomina, byNumeroHorasExtra);
            if (Console.ReadKey() != null) {
                Console.Clear();
                nomina.hojaSalarial();
            }
            #endregion
        }
    }

}
