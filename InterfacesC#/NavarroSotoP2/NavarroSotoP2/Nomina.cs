using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP2 {
    class Nomina {

        #region Atributos
        Empleado empleadoNomina;
        DateTime dateFechaNomina;
        byte byNumeroHorasExtra;
        #endregion

        #region Constructores
        public Nomina() {
            this.empleadoNomina = new Empleado();
            this.dateFechaNomina = DateTime.Today;
            this.byNumeroHorasExtra = 0;
        }

        public Nomina(Empleado empleadoNomina, DateTime dateFechaNomina, byte byNumeroHorasExtra) {
            this.empleadoNomina = empleadoNomina;
            this.dateFechaNomina = dateFechaNomina;
            this.byNumeroHorasExtra = byNumeroHorasExtra;
        }
        #endregion

        #region Propiedades
        public Empleado getEmpleadoNomina() {
            return this.empleadoNomina;
        }

        public DateTime getDateFechaNomina() {
            return this.dateFechaNomina;
        }

        public ushort getUsNumeroHorasExtra() {
            return byNumeroHorasExtra;
        }
        #endregion

        #region Métodos
        public double cotizacionSegDes() {
            return devengosPagaExtra() * 1.97 / 100;
        }

        public double cotizacionSegSoc() {
            return (devengosPagaExtra() + devengosPagaExtra() / 6) * 4.51 / 100;
        }

        public double devengosPagaExtra() {
            return salarioBase() + importeAntiguedad();
        }

        public void hojaSalarial() {
            double doLiquidoPercibir;
            if (this.getDateFechaNomina().Month.Equals(6) || this.getDateFechaNomina().Month.Equals(12)) {
                doLiquidoPercibir = totalDevengados() + devengosPagaExtra() - totalDescuentos();
            } else {
                doLiquidoPercibir = totalDevengados() - totalDescuentos();
            }

            Console.WriteLine("HOJA SALARIAL\n\n");
            Console.WriteLine("LIQUIDACIÓN DE HABERES AL " + dateFechaNomina.ToString("dd/MM/yyyy") + "\n\n");
            Console.WriteLine("Nombre..........: " + empleadoNomina.getStrNombre());
            Console.WriteLine("NIF.............: " + empleadoNomina.getStrNif());
            Console.WriteLine("Categoría.......: " + empleadoNomina.getByCategoria());
            Console.WriteLine("Nº de Trienios..: " + empleadoNomina.getByNumeroTrienios());
            Console.WriteLine("Nº de Hijos.....: " + empleadoNomina.getByNumeroHijos());

            Console.WriteLine("\nDEVENGOS\t\t\tDESCUENTOS");
            Console.WriteLine("________\t\t\t__________\n");
            Console.WriteLine(String.Format("{0,-15}{1,10}\t{2,-20}{3,10}", "Salario base", salarioBase().ToString("0.00"),
                "Cotización Seg. Soc.", cotizacionSegSoc().ToString("0.00")));
            Console.WriteLine("{0,-15}{1,10}\t{2,-20}{3,10}", "Antigüedad", importeAntiguedad().ToString("0.00"),
                "Cotización Seg.Des.", cotizacionSegDes().ToString("0.00"));
            Console.WriteLine("{0,-15}{1,10}\t{2,-20}{3,10}", "Importe Hor.Ext", importeHorasExtras().ToString("0.00"),
                "Retención IRPF", retencionIRPF().ToString("0.00"));
            if (this.getDateFechaNomina().Month.Equals(6) || this.getDateFechaNomina().Month.Equals(12)) {
                Console.WriteLine("{0,-15}{1,10}\t", "Paga Extra", devengosPagaExtra().ToString("0.00"));
            }
            Console.WriteLine("\n{0,-15}{1,10}\t{2,-20}{3,10}", "Total Devengos", totalDevengados().ToString("0.00"),
                "Total descuentos", totalDescuentos().ToString("0.00"));
            Console.WriteLine("\n\n----------------------------");
            Console.WriteLine("LÍQUIDO A PERCIBIR " + doLiquidoPercibir.ToString("0.00"));
            Console.WriteLine("----------------------------");
            Console.BackgroundColor = ConsoleColor.Blue;
            Console.WriteLine("Pulse cualquier tecla para salir.");
            Console.ResetColor();
            if (Console.ReadKey() != null) {

            }

        }

        public double importeAntiguedad() {
            return empleadoNomina.getByNumeroTrienios() * salarioBase() * 4 / 100;
        }

        public double importeHorasExtras() {
            return this.byNumeroHorasExtra * salarioBase() * 1 / 100;
        }

        public double retencionIRPF() {
            double doRetencionIRPF;
            switch (this.empleadoNomina.getByCategoria()) {
                case 1:
                    doRetencionIRPF = 18 - empleadoNomina.getByNumeroHijos();
                    break;
                case 2:
                    doRetencionIRPF = 15 - empleadoNomina.getByNumeroHijos();
                    break;
                default:
                    doRetencionIRPF = 12 - empleadoNomina.getByNumeroHijos();
                    break;
            }

            if (this.getDateFechaNomina().Month.Equals(6) || this.getDateFechaNomina().Month.Equals(12)) {
                return (totalDevengados() + devengosPagaExtra()) * doRetencionIRPF / 100;
            } else {
                return totalDevengados() * doRetencionIRPF / 100;
            }
        }

        public double salarioBase() {
            switch (this.empleadoNomina.getByCategoria()) {
                case 1:
                    return 2500;
                case 2:
                    return 2000;
                default:
                    return 1500;
            }

        }

        public double totalDescuentos() {
            return cotizacionSegSoc() + cotizacionSegDes() + retencionIRPF();
        }

        public double totalDevengados() {
            if (this.getDateFechaNomina().Month.Equals(6) || this.getDateFechaNomina().Month.Equals(12)) {
                return salarioBase() + importeAntiguedad() + importeHorasExtras() + devengosPagaExtra();
            } else {
                return salarioBase() + importeAntiguedad() + importeHorasExtras();
            }
        }
        #endregion
    }
}
