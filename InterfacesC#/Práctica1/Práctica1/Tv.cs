/* 
 * * PRÁCTICA.............: Práctica 1. 
 * * NOMBRE y APELLIDOS...: Cristina Navarro Soto
 * * CURSO y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO de la PRÁCTICA: Diseño de clases. Herencia y polimorfismo. 
 * * FECHA de ENTREGA.....: 23 de octubre de 2017 
 */

using System;


namespace Práctica1 {
    class Tv {
        #region Atributos
        string strMarca;
        float floPulgadas;
        float floConsumo;
        float floPrecio;
        bool boEncendido;
        byte byCanal; //0-99
        byte byCanalAnterior;
        byte byVolumen; //1-100
        #endregion

        #region Constructor
        public Tv(string strMarca, float floPulgadas, float floConsumo, float floPrecio) {
            this.strMarca = strMarca;
            this.floPulgadas = floPulgadas;
            this.floConsumo = floConsumo;
            this.floPrecio = floPrecio;
            this.boEncendido = false;
            iniciarPorDefecto();
        }
        #endregion

        #region Getter&Setter
        public bool getBoEncendido() {
            return this.boEncendido;
        }
        #endregion

        #region Métodos
        private void iniciarPorDefecto() {
            this.byCanal = 0;
            this.byCanalAnterior = 0;
            this.byVolumen = 0;
        }

        public void pulsarEncendido() {
            if (boEncendido) {
                this.boEncendido = false;
                this.iniciarPorDefecto();
            } else {
                this.boEncendido = true;
                this.byCanal = 1;
                this.byCanalAnterior = byCanal;
                this.byVolumen = 25;
            }
        }

        public void subirVolumen() {
            if (this.boEncendido) {
                if (this.byVolumen != 100) {
                    this.byVolumen++;
                    Console.Write(this.byVolumen);
                } else {
                    Console.Beep();
                    alertaDatoIncorrecto("No se puede aumentar el volumen por encima de 100.");
                }
            } else {
                alertaTelevisorApagado();
            }
        }

        public void bajarVolumen() {
            if (this.boEncendido) {
                if (this.byVolumen > 0) {
                    this.byVolumen--;
                    Console.Write(this.byVolumen);
                } else {
                    Console.Beep();
                    alertaDatoIncorrecto("No se puede disminuir el volumen por debajo de 0.");
                }
            } else {
                alertaTelevisorApagado();
            }
        }

        public void ponerCanal(byte nuevoCanal) {
            if (this.boEncendido) {
                this.byCanalAnterior = this.byCanal;
                this.byCanal = nuevoCanal;
                Console.Write("\n\nEncendida -> Canal: " + this.byCanal + ", Volumen: " + this.byVolumen);
            } else {
                alertaTelevisorApagado();
            }

        }

        public void cambiarCanalAnterior() {
            byte aux = 0;
            if (this.boEncendido) {
                aux = this.byCanal;
                this.byCanal = this.byCanalAnterior;
                this.byCanalAnterior = aux;
            } else {
                alertaTelevisorApagado();
            }
        }

        private void estadoActual() {
            if (this.boEncendido) {
                Console.Write(this.byCanal);
                Console.Write(this.byVolumen);
            } else {
                Console.Write("Apagado.");
            }
        }

        public void informacionTecnica() {
            do {
                Console.Clear();
                Console.Write("Información técnica de mi tele: \n\n");
                Console.Write("\tMarca: " + this.strMarca);
                Console.Write(String.Format("\n\tTamaño en pulgadas: {0:G3}", this.floPulgadas));
                Console.Write(String.Format("\n\tConsumo: {0:G3} W", this.floConsumo));
                Console.Write(String.Format("\n\tPrecio: {0:G3} euros.", this.floPrecio));
                Console.Write("\n\tPulse ENTER para continuar...");
            } while (Console.ReadKey().Key != ConsoleKey.Enter);
        }

        private void alertaTelevisorApagado() {
            Console.Beep();
            Console.Beep();
            Console.Beep();
            Console.BackgroundColor = ConsoleColor.Red;
            Console.Write("\nPor favor, encienda el televisor para modificar el volumen o el canal.");
            Console.ResetColor();
            System.Threading.Thread.Sleep(2000);

        }

        public void alertaDatoIncorrecto(string strInformacion) {
            Console.BackgroundColor = ConsoleColor.Red;
            Console.Write("\n\n" + strInformacion);
            Console.ResetColor();
            System.Threading.Thread.Sleep(2000);
        }

        public void imprimirDatosEncendido() {
            Console.Write("\n\nEncendida -> Canal: " + this.byCanal + ", Volumen: " + this.byVolumen);
        }
        #endregion
    }
}
