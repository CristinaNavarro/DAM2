namespace NavarroSotoP6 {
    partial class formNomina {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing) {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent() {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(formNomina));
            this.btnCalcularNomina = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.panelDatos = new System.Windows.Forms.Panel();
            this.textBoxLiquidacion = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.textBoxHorasExtra = new System.Windows.Forms.TextBox();
            this.textBoxTrienios = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.textBoxHijos = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.textBoxCategoria = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.textBoxNombre = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.textBoxDNI = new System.Windows.Forms.TextBox();
            this.labelDNI = new System.Windows.Forms.Label();
            this.label16 = new System.Windows.Forms.Label();
            this.label15 = new System.Windows.Forms.Label();
            this.label14 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.fileSystemWatcher1 = new System.IO.FileSystemWatcher();
            this.textBoxSalarioBase = new System.Windows.Forms.TextBox();
            this.textBoxAntiguedad = new System.Windows.Forms.TextBox();
            this.textBoxHorasResultado = new System.Windows.Forms.TextBox();
            this.textBoxPagaExtra = new System.Windows.Forms.TextBox();
            this.textBoxTotalDevengos = new System.Windows.Forms.TextBox();
            this.tableResultadoNomina = new System.Windows.Forms.TableLayoutPanel();
            this.label11 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label17 = new System.Windows.Forms.Label();
            this.label18 = new System.Windows.Forms.Label();
            this.label19 = new System.Windows.Forms.Label();
            this.textBoxSS = new System.Windows.Forms.TextBox();
            this.textBoxDesempleo = new System.Windows.Forms.TextBox();
            this.textBoxIRPF = new System.Windows.Forms.TextBox();
            this.textBoxTotalDescuentos = new System.Windows.Forms.TextBox();
            this.btnModificarDatos = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.textBoxLiquido = new System.Windows.Forms.TextBox();
            this.panelDatos.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.fileSystemWatcher1)).BeginInit();
            this.tableResultadoNomina.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnCalcularNomina
            // 
            this.btnCalcularNomina.Enabled = false;
            this.btnCalcularNomina.ForeColor = System.Drawing.Color.DarkGreen;
            this.btnCalcularNomina.Location = new System.Drawing.Point(306, 137);
            this.btnCalcularNomina.Name = "btnCalcularNomina";
            this.btnCalcularNomina.Size = new System.Drawing.Size(147, 23);
            this.btnCalcularNomina.TabIndex = 0;
            this.btnCalcularNomina.Text = "Calcular hoja salarial";
            this.btnCalcularNomina.UseVisualStyleBackColor = true;
            this.btnCalcularNomina.Click += new System.EventHandler(this.btnCalcularNomina_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.ForeColor = System.Drawing.Color.DarkBlue;
            this.label1.Location = new System.Drawing.Point(12, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(480, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "CÁLCULO DE LA HOJA SALARIAL. INTRODUZCA LOS DATOS Y PULSE EL BOTÓN CALCULAR";
            // 
            // panelDatos
            // 
            this.panelDatos.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelDatos.Controls.Add(this.textBoxLiquidacion);
            this.panelDatos.Controls.Add(this.label8);
            this.panelDatos.Controls.Add(this.btnCalcularNomina);
            this.panelDatos.Controls.Add(this.label7);
            this.panelDatos.Controls.Add(this.textBoxHorasExtra);
            this.panelDatos.Controls.Add(this.textBoxTrienios);
            this.panelDatos.Controls.Add(this.label6);
            this.panelDatos.Controls.Add(this.textBoxHijos);
            this.panelDatos.Controls.Add(this.label5);
            this.panelDatos.Controls.Add(this.textBoxCategoria);
            this.panelDatos.Controls.Add(this.label4);
            this.panelDatos.Controls.Add(this.textBoxNombre);
            this.panelDatos.Controls.Add(this.label3);
            this.panelDatos.Controls.Add(this.textBoxDNI);
            this.panelDatos.Controls.Add(this.labelDNI);
            this.panelDatos.Location = new System.Drawing.Point(15, 39);
            this.panelDatos.Name = "panelDatos";
            this.panelDatos.Size = new System.Drawing.Size(541, 183);
            this.panelDatos.TabIndex = 2;
            // 
            // textBoxLiquidacion
            // 
            this.textBoxLiquidacion.Location = new System.Drawing.Point(173, 139);
            this.textBoxLiquidacion.Name = "textBoxLiquidacion";
            this.textBoxLiquidacion.ReadOnly = true;
            this.textBoxLiquidacion.Size = new System.Drawing.Size(100, 20);
            this.textBoxLiquidacion.TabIndex = 13;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(15, 142);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(152, 13);
            this.label8.TabIndex = 12;
            this.label8.Text = "Período liquidación (mm/aaaa)";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(403, 102);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(74, 13);
            this.label7.TabIndex = 11;
            this.label7.Text = "Nº horas extra";
            // 
            // textBoxHorasExtra
            // 
            this.textBoxHorasExtra.Location = new System.Drawing.Point(483, 99);
            this.textBoxHorasExtra.Name = "textBoxHorasExtra";
            this.textBoxHorasExtra.ReadOnly = true;
            this.textBoxHorasExtra.Size = new System.Drawing.Size(36, 20);
            this.textBoxHorasExtra.TabIndex = 10;
            // 
            // textBoxTrienios
            // 
            this.textBoxTrienios.Location = new System.Drawing.Point(325, 98);
            this.textBoxTrienios.Name = "textBoxTrienios";
            this.textBoxTrienios.ReadOnly = true;
            this.textBoxTrienios.Size = new System.Drawing.Size(36, 20);
            this.textBoxTrienios.TabIndex = 9;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(267, 102);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(55, 13);
            this.label6.TabIndex = 8;
            this.label6.Text = "Nº trienios";
            // 
            // textBoxHijos
            // 
            this.textBoxHijos.Location = new System.Drawing.Point(203, 100);
            this.textBoxHijos.Name = "textBoxHijos";
            this.textBoxHijos.ReadOnly = true;
            this.textBoxHijos.Size = new System.Drawing.Size(36, 20);
            this.textBoxHijos.TabIndex = 7;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(154, 103);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(43, 13);
            this.label5.TabIndex = 6;
            this.label5.Text = "Nº hijos";
            // 
            // textBoxCategoria
            // 
            this.textBoxCategoria.Location = new System.Drawing.Point(73, 99);
            this.textBoxCategoria.Name = "textBoxCategoria";
            this.textBoxCategoria.ReadOnly = true;
            this.textBoxCategoria.Size = new System.Drawing.Size(36, 20);
            this.textBoxCategoria.TabIndex = 5;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 103);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(54, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Categoría";
            // 
            // textBoxNombre
            // 
            this.textBoxNombre.Location = new System.Drawing.Point(68, 49);
            this.textBoxNombre.Name = "textBoxNombre";
            this.textBoxNombre.ReadOnly = true;
            this.textBoxNombre.Size = new System.Drawing.Size(229, 20);
            this.textBoxNombre.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 52);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(44, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Nombre";
            // 
            // textBoxDNI
            // 
            this.textBoxDNI.Location = new System.Drawing.Point(68, 10);
            this.textBoxDNI.Name = "textBoxDNI";
            this.textBoxDNI.Size = new System.Drawing.Size(99, 20);
            this.textBoxDNI.TabIndex = 1;
            // 
            // labelDNI
            // 
            this.labelDNI.AutoSize = true;
            this.labelDNI.Location = new System.Drawing.Point(12, 13);
            this.labelDNI.Name = "labelDNI";
            this.labelDNI.Size = new System.Drawing.Size(26, 13);
            this.labelDNI.TabIndex = 0;
            this.labelDNI.Text = "DNI";
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.ForeColor = System.Drawing.Color.Green;
            this.label16.Location = new System.Drawing.Point(3, 215);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(51, 13);
            this.label16.TabIndex = 7;
            this.label16.Text = "LÍQUIDO";
            this.label16.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.ForeColor = System.Drawing.Color.DarkBlue;
            this.label15.Location = new System.Drawing.Point(3, 174);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(83, 13);
            this.label15.TabIndex = 6;
            this.label15.Text = "Total Devengos";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.ForeColor = System.Drawing.Color.DarkBlue;
            this.label14.Location = new System.Drawing.Point(3, 126);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(59, 13);
            this.label14.TabIndex = 5;
            this.label14.Text = "Paga Extra";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.ForeColor = System.Drawing.Color.DarkBlue;
            this.label13.Location = new System.Drawing.Point(3, 96);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(62, 13);
            this.label13.TabIndex = 4;
            this.label13.Text = "Horas Extra";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.ForeColor = System.Drawing.Color.DarkBlue;
            this.label12.Location = new System.Drawing.Point(3, 65);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(61, 13);
            this.label12.TabIndex = 3;
            this.label12.Text = "Antigüedad";
            // 
            // fileSystemWatcher1
            // 
            this.fileSystemWatcher1.EnableRaisingEvents = true;
            this.fileSystemWatcher1.SynchronizingObject = this;
            // 
            // textBoxSalarioBase
            // 
            this.textBoxSalarioBase.Location = new System.Drawing.Point(142, 32);
            this.textBoxSalarioBase.Name = "textBoxSalarioBase";
            this.textBoxSalarioBase.ReadOnly = true;
            this.textBoxSalarioBase.Size = new System.Drawing.Size(100, 20);
            this.textBoxSalarioBase.TabIndex = 3;
            // 
            // textBoxAntiguedad
            // 
            this.textBoxAntiguedad.Location = new System.Drawing.Point(142, 68);
            this.textBoxAntiguedad.Name = "textBoxAntiguedad";
            this.textBoxAntiguedad.ReadOnly = true;
            this.textBoxAntiguedad.Size = new System.Drawing.Size(100, 20);
            this.textBoxAntiguedad.TabIndex = 4;
            // 
            // textBoxHorasResultado
            // 
            this.textBoxHorasResultado.Location = new System.Drawing.Point(142, 99);
            this.textBoxHorasResultado.Name = "textBoxHorasResultado";
            this.textBoxHorasResultado.ReadOnly = true;
            this.textBoxHorasResultado.Size = new System.Drawing.Size(100, 20);
            this.textBoxHorasResultado.TabIndex = 5;
            // 
            // textBoxPagaExtra
            // 
            this.textBoxPagaExtra.Location = new System.Drawing.Point(142, 129);
            this.textBoxPagaExtra.Name = "textBoxPagaExtra";
            this.textBoxPagaExtra.ReadOnly = true;
            this.textBoxPagaExtra.Size = new System.Drawing.Size(100, 20);
            this.textBoxPagaExtra.TabIndex = 6;
            // 
            // textBoxTotalDevengos
            // 
            this.textBoxTotalDevengos.Location = new System.Drawing.Point(142, 177);
            this.textBoxTotalDevengos.Name = "textBoxTotalDevengos";
            this.textBoxTotalDevengos.ReadOnly = true;
            this.textBoxTotalDevengos.Size = new System.Drawing.Size(100, 20);
            this.textBoxTotalDevengos.TabIndex = 7;
            // 
            // tableResultadoNomina
            // 
            this.tableResultadoNomina.ColumnCount = 4;
            this.tableResultadoNomina.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableResultadoNomina.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableResultadoNomina.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 151F));
            this.tableResultadoNomina.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 112F));
            this.tableResultadoNomina.Controls.Add(this.textBoxTotalDevengos, 1, 5);
            this.tableResultadoNomina.Controls.Add(this.label15, 0, 5);
            this.tableResultadoNomina.Controls.Add(this.textBoxPagaExtra, 1, 4);
            this.tableResultadoNomina.Controls.Add(this.label14, 0, 4);
            this.tableResultadoNomina.Controls.Add(this.textBoxHorasResultado, 1, 3);
            this.tableResultadoNomina.Controls.Add(this.label13, 0, 3);
            this.tableResultadoNomina.Controls.Add(this.textBoxAntiguedad, 1, 2);
            this.tableResultadoNomina.Controls.Add(this.textBoxSalarioBase, 1, 1);
            this.tableResultadoNomina.Controls.Add(this.label11, 0, 1);
            this.tableResultadoNomina.Controls.Add(this.label12, 0, 2);
            this.tableResultadoNomina.Controls.Add(this.label9, 0, 0);
            this.tableResultadoNomina.Controls.Add(this.label10, 2, 0);
            this.tableResultadoNomina.Controls.Add(this.label2, 2, 1);
            this.tableResultadoNomina.Controls.Add(this.label17, 2, 2);
            this.tableResultadoNomina.Controls.Add(this.label18, 2, 3);
            this.tableResultadoNomina.Controls.Add(this.label19, 2, 5);
            this.tableResultadoNomina.Controls.Add(this.textBoxSS, 3, 1);
            this.tableResultadoNomina.Controls.Add(this.textBoxDesempleo, 3, 2);
            this.tableResultadoNomina.Controls.Add(this.textBoxIRPF, 3, 3);
            this.tableResultadoNomina.Controls.Add(this.textBoxTotalDescuentos, 3, 5);
            this.tableResultadoNomina.Controls.Add(this.btnModificarDatos, 2, 6);
            this.tableResultadoNomina.Controls.Add(this.btnSalir, 3, 6);
            this.tableResultadoNomina.Controls.Add(this.textBoxLiquido, 1, 6);
            this.tableResultadoNomina.Controls.Add(this.label16, 0, 6);
            this.tableResultadoNomina.Location = new System.Drawing.Point(15, 241);
            this.tableResultadoNomina.Name = "tableResultadoNomina";
            this.tableResultadoNomina.RowCount = 7;
            this.tableResultadoNomina.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 44.64286F));
            this.tableResultadoNomina.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 55.35714F));
            this.tableResultadoNomina.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 31F));
            this.tableResultadoNomina.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 30F));
            this.tableResultadoNomina.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 48F));
            this.tableResultadoNomina.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 41F));
            this.tableResultadoNomina.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 86F));
            this.tableResultadoNomina.Size = new System.Drawing.Size(541, 302);
            this.tableResultadoNomina.TabIndex = 8;
            this.tableResultadoNomina.Visible = false;
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.ForeColor = System.Drawing.Color.DarkBlue;
            this.label11.Location = new System.Drawing.Point(3, 29);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(65, 13);
            this.label11.TabIndex = 2;
            this.label11.Text = "Salario base";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.ForeColor = System.Drawing.Color.DarkBlue;
            this.label9.Location = new System.Drawing.Point(3, 0);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(67, 13);
            this.label9.TabIndex = 0;
            this.label9.Text = "DEVENGOS";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.ForeColor = System.Drawing.Color.DarkBlue;
            this.label10.Location = new System.Drawing.Point(281, 0);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(81, 13);
            this.label10.TabIndex = 1;
            this.label10.Text = "DESCUENTOS";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.ForeColor = System.Drawing.Color.Tomato;
            this.label2.Location = new System.Drawing.Point(281, 29);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(116, 13);
            this.label2.TabIndex = 8;
            this.label2.Text = "Cotiz. Seguridad Social";
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.ForeColor = System.Drawing.Color.Tomato;
            this.label17.Location = new System.Drawing.Point(281, 65);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(126, 13);
            this.label17.TabIndex = 9;
            this.label17.Text = "Cotiz. Seguro Desempleo";
            // 
            // label18
            // 
            this.label18.AutoSize = true;
            this.label18.ForeColor = System.Drawing.Color.Tomato;
            this.label18.Location = new System.Drawing.Point(281, 96);
            this.label18.Name = "label18";
            this.label18.Size = new System.Drawing.Size(83, 13);
            this.label18.TabIndex = 10;
            this.label18.Text = "Retención IRPF";
            // 
            // label19
            // 
            this.label19.AutoSize = true;
            this.label19.ForeColor = System.Drawing.Color.Tomato;
            this.label19.Location = new System.Drawing.Point(281, 174);
            this.label19.Name = "label19";
            this.label19.Size = new System.Drawing.Size(91, 13);
            this.label19.TabIndex = 11;
            this.label19.Text = "Total Descuentos";
            // 
            // textBoxSS
            // 
            this.textBoxSS.Location = new System.Drawing.Point(432, 32);
            this.textBoxSS.Name = "textBoxSS";
            this.textBoxSS.ReadOnly = true;
            this.textBoxSS.Size = new System.Drawing.Size(100, 20);
            this.textBoxSS.TabIndex = 12;
            // 
            // textBoxDesempleo
            // 
            this.textBoxDesempleo.Location = new System.Drawing.Point(432, 68);
            this.textBoxDesempleo.Name = "textBoxDesempleo";
            this.textBoxDesempleo.ReadOnly = true;
            this.textBoxDesempleo.Size = new System.Drawing.Size(100, 20);
            this.textBoxDesempleo.TabIndex = 13;
            // 
            // textBoxIRPF
            // 
            this.textBoxIRPF.Location = new System.Drawing.Point(432, 99);
            this.textBoxIRPF.Name = "textBoxIRPF";
            this.textBoxIRPF.ReadOnly = true;
            this.textBoxIRPF.Size = new System.Drawing.Size(100, 20);
            this.textBoxIRPF.TabIndex = 14;
            // 
            // textBoxTotalDescuentos
            // 
            this.textBoxTotalDescuentos.Location = new System.Drawing.Point(432, 177);
            this.textBoxTotalDescuentos.Name = "textBoxTotalDescuentos";
            this.textBoxTotalDescuentos.ReadOnly = true;
            this.textBoxTotalDescuentos.Size = new System.Drawing.Size(100, 20);
            this.textBoxTotalDescuentos.TabIndex = 15;
            // 
            // btnModificarDatos
            // 
            this.btnModificarDatos.ForeColor = System.Drawing.Color.Green;
            this.btnModificarDatos.Location = new System.Drawing.Point(281, 218);
            this.btnModificarDatos.Name = "btnModificarDatos";
            this.btnModificarDatos.Size = new System.Drawing.Size(145, 42);
            this.btnModificarDatos.TabIndex = 16;
            this.btnModificarDatos.Text = "Modificar Datos";
            this.btnModificarDatos.UseVisualStyleBackColor = true;
            this.btnModificarDatos.Click += new System.EventHandler(this.btnModificarDatos_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.ForeColor = System.Drawing.Color.Green;
            this.btnSalir.Location = new System.Drawing.Point(432, 218);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(106, 42);
            this.btnSalir.TabIndex = 17;
            this.btnSalir.Text = "SALIR";
            this.btnSalir.UseVisualStyleBackColor = true;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // textBoxLiquido
            // 
            this.textBoxLiquido.Location = new System.Drawing.Point(142, 218);
            this.textBoxLiquido.Name = "textBoxLiquido";
            this.textBoxLiquido.ReadOnly = true;
            this.textBoxLiquido.Size = new System.Drawing.Size(100, 20);
            this.textBoxLiquido.TabIndex = 18;
            // 
            // formNomina
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(568, 555);
            this.Controls.Add(this.tableResultadoNomina);
            this.Controls.Add(this.panelDatos);
            this.Controls.Add(this.label1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "formNomina";
            this.Text = "Nómina";
            this.panelDatos.ResumeLayout(false);
            this.panelDatos.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.fileSystemWatcher1)).EndInit();
            this.tableResultadoNomina.ResumeLayout(false);
            this.tableResultadoNomina.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnCalcularNomina;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panelDatos;
        private System.Windows.Forms.TextBox textBoxDNI;
        private System.Windows.Forms.Label labelDNI;
        private System.Windows.Forms.TextBox textBoxNombre;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox textBoxHorasExtra;
        private System.Windows.Forms.TextBox textBoxTrienios;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox textBoxHijos;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBoxCategoria;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBoxLiquidacion;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label12;
        private System.IO.FileSystemWatcher fileSystemWatcher1;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.TableLayoutPanel tableResultadoNomina;
        private System.Windows.Forms.TextBox textBoxTotalDevengos;
        private System.Windows.Forms.TextBox textBoxPagaExtra;
        private System.Windows.Forms.TextBox textBoxHorasResultado;
        private System.Windows.Forms.TextBox textBoxAntiguedad;
        private System.Windows.Forms.TextBox textBoxSalarioBase;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label17;
        private System.Windows.Forms.Label label18;
        private System.Windows.Forms.Label label19;
        private System.Windows.Forms.TextBox textBoxSS;
        private System.Windows.Forms.TextBox textBoxDesempleo;
        private System.Windows.Forms.TextBox textBoxIRPF;
        private System.Windows.Forms.TextBox textBoxTotalDescuentos;
        private System.Windows.Forms.Button btnModificarDatos;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.TextBox textBoxLiquido;
    }
}

