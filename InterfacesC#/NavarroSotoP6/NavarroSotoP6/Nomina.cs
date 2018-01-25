using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NavarroSotoP6 {
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
        public Empleado getEmpleadoNomina {
            get {
                return this.empleadoNomina;
            }
        }

        public DateTime getDateFechaNomina {
            get {
                return this.dateFechaNomina;
            }
        }

        public ushort getUsNumeroHorasExtra {
            get {
                return byNumeroHorasExtra;
            }
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

        public double liquido() {
            double doLiquidoPercibir;
            if (this.getDateFechaNomina.Month.Equals(6) || this.getDateFechaNomina.Month.Equals(12)) {
                doLiquidoPercibir = totalDevengados() + devengosPagaExtra() - totalDescuentos();
            } else {
                doLiquidoPercibir = totalDevengados() - totalDescuentos();
            }
            return doLiquidoPercibir;
        }

        public double importeAntiguedad() {
            return empleadoNomina.getByNumeroTrienios * salarioBase() * 4 / 100;
        }

        public double importeHorasExtras() {
            return this.byNumeroHorasExtra * salarioBase() * 1 / 100;
        }

        public double retencionIRPF() {
            double doRetencionIRPF;
            switch (this.empleadoNomina.getByCategoria) {
                case 1:
                    doRetencionIRPF = 18 - empleadoNomina.getByNumeroHijos;
                    break;
                case 2:
                    doRetencionIRPF = 15 - empleadoNomina.getByNumeroHijos;
                    break;
                default:
                    doRetencionIRPF = 12 - empleadoNomina.getByNumeroHijos;
                    break;
            }

            if (this.getDateFechaNomina.Month.Equals(6) || this.getDateFechaNomina.Month.Equals(12)) {
                return (totalDevengados() + devengosPagaExtra()) * doRetencionIRPF / 100;
            } else {
                return totalDevengados() * doRetencionIRPF / 100;
            }
        }

        public double salarioBase() {
            switch (this.empleadoNomina.getByCategoria) {
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
            if (this.getDateFechaNomina.Month.Equals(6) || this.getDateFechaNomina.Month.Equals(12)) {
                return salarioBase() + importeAntiguedad() + importeHorasExtras() + devengosPagaExtra();
            } else {
                return salarioBase() + importeAntiguedad() + importeHorasExtras();
            }
        }
        #endregion
    }
}
