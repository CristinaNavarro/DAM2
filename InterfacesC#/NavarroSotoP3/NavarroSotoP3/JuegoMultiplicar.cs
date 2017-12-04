/* 
 * * PRÁCTICA.............: Práctica 3. 
 * * NOMBRE y APELLIDOS...: Cristina Navarro Soto
 * * CURSO y GRUPO........: 2º Desarrollo de Interfaces 
 * * TÍTULO de la PRÁCTICA: Sentencias de Control. Excepciones. 
 * * FECHA de ENTREGA.....: 16 de NOVIEMBRE de 2017 
 */

using System;


namespace NavarroSotoP3 {


    class JuegoMultiplicar {

        const byte byMINIMOFACTOR = 1;
        const byte byMAXIMOFACTOR = 10;


        byte byPrimerFactor;
        byte bySegundoFactor;
        byte byContadorAciertos;
        byte byTiempoMaximoRespuesta;

        public JuegoMultiplicar() {
            this.byPrimerFactor = 0;
            this.bySegundoFactor = 0;
            this.byContadorAciertos = 0;
            this.byTiempoMaximoRespuesta = 0;
        }

        public JuegoMultiplicar(byte byContadorAciertos, byte byTiempoMaximoRespuesta) {
            this.byContadorAciertos = byContadorAciertos;
            this.byTiempoMaximoRespuesta = byTiempoMaximoRespuesta;
        }

        public byte propiedadByPrimerFactor {
            get {
                return this.byPrimerFactor;
            }
        }

        public byte propiedadBySegundoFactor {
            get {
                return this.bySegundoFactor;
            }
        }

        public byte propiedadByContadorAciertos {
            get {
                return this.byContadorAciertos;
            }
            set {
                this.byContadorAciertos = value;
            }
        }

        public byte propiedadByTiempoMaximoRespuesta {
            get {
                return this.byTiempoMaximoRespuesta;
            }

            set {
                this.byTiempoMaximoRespuesta = value;
            }
        }

        public void generarOperandos() {
            Random random = new Random();
            this.byPrimerFactor = Convert.ToByte(random.Next(byMINIMOFACTOR, byMAXIMOFACTOR));
            this.bySegundoFactor = Convert.ToByte(random.Next(byMINIMOFACTOR, byMAXIMOFACTOR));
        }
    }
}
