namespace NavarroSotoP8 {
    partial class VentanaPrincipal {
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(VentanaPrincipal));
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.lblFecha = new System.Windows.Forms.Label();
            this.textBoxNombre = new NavarroSotoP8.TextBoxNombre();
            this.lblNombre = new System.Windows.Forms.Label();
            this.lblCorreo = new System.Windows.Forms.Label();
            this.textBoxCorreo = new NavarroSotoP8.TextBoxCorreo();
            this.lblContraseña = new System.Windows.Forms.Label();
            this.textBoxContraseña = new NavarroSotoP8.TextBoxContraseña();
            this.textBoxFecha = new NavarroSotoP8.TextBoxFecha();
            this.lblUsuario = new System.Windows.Forms.Label();
            this.textBoxUsuario = new NavarroSotoP8.TextBoxUsuario();
            this.btnRegistrar = new System.Windows.Forms.Button();
            this.btnVerContraseña = new System.Windows.Forms.Button();
            this.tip = new System.Windows.Forms.ToolTip(this.components);
            this.btnVerContraseñaLogin = new System.Windows.Forms.Button();
            this.textBoxUsuarioLogin = new NavarroSotoP8.TextBoxUsuario();
            this.textBoxContraseñaLogin = new NavarroSotoP8.TextBoxContraseña();
            this.btnLogin = new System.Windows.Forms.Button();
            this.calendarNacimiento = new NavarroSotoP8.CalendarNacimiento();
            this.tabControlUsuario = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.tableLayoutPanel2 = new System.Windows.Forms.TableLayoutPanel();
            this.lblContraseñaAsociada = new System.Windows.Forms.Label();
            this.lblUsuarioExistente = new System.Windows.Forms.Label();
            this.tableLayoutPanel1.SuspendLayout();
            this.tabControlUsuario.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.tableLayoutPanel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 2;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle());
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.Controls.Add(this.lblFecha, 0, 3);
            this.tableLayoutPanel1.Controls.Add(this.textBoxNombre, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.lblNombre, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.lblCorreo, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.textBoxCorreo, 1, 1);
            this.tableLayoutPanel1.Controls.Add(this.lblContraseña, 0, 2);
            this.tableLayoutPanel1.Controls.Add(this.textBoxContraseña, 1, 2);
            this.tableLayoutPanel1.Controls.Add(this.textBoxFecha, 1, 3);
            this.tableLayoutPanel1.Controls.Add(this.lblUsuario, 0, 4);
            this.tableLayoutPanel1.Controls.Add(this.textBoxUsuario, 1, 4);
            this.tableLayoutPanel1.Controls.Add(this.btnRegistrar, 1, 5);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(3, 6);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 7;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 47.69231F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 52.30769F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 30F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 31F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 37F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 53F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(248, 237);
            this.tableLayoutPanel1.TabIndex = 1;
            // 
            // lblFecha
            // 
            this.lblFecha.AutoSize = true;
            this.lblFecha.Location = new System.Drawing.Point(3, 95);
            this.lblFecha.Name = "lblFecha";
            this.lblFecha.Size = new System.Drawing.Size(106, 13);
            this.lblFecha.TabIndex = 7;
            this.lblFecha.Text = "Fecha de nacimiento";
            // 
            // textBoxNombre
            // 
            this.textBoxNombre.Location = new System.Drawing.Point(115, 3);
            this.textBoxNombre.MaxLength = 30;
            this.textBoxNombre.Name = "textBoxNombre";
            this.textBoxNombre.Size = new System.Drawing.Size(121, 20);
            this.textBoxNombre.TabIndex = 0;
            this.tip.SetToolTip(this.textBoxNombre, "Acepta únicamente letras.");
            this.textBoxNombre.TextChanged += new System.EventHandler(this.textBoxNombre_TextChanged);
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Location = new System.Drawing.Point(3, 0);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(44, 13);
            this.lblNombre.TabIndex = 1;
            this.lblNombre.Text = "Nombre";
            // 
            // lblCorreo
            // 
            this.lblCorreo.AutoSize = true;
            this.lblCorreo.Location = new System.Drawing.Point(3, 31);
            this.lblCorreo.Name = "lblCorreo";
            this.lblCorreo.Size = new System.Drawing.Size(93, 13);
            this.lblCorreo.TabIndex = 2;
            this.lblCorreo.Text = "Correo electrónico";
            // 
            // textBoxCorreo
            // 
            this.textBoxCorreo.Location = new System.Drawing.Point(115, 34);
            this.textBoxCorreo.MaxLength = 50;
            this.textBoxCorreo.Name = "textBoxCorreo";
            this.textBoxCorreo.Size = new System.Drawing.Size(121, 20);
            this.textBoxCorreo.TabIndex = 3;
            this.tip.SetToolTip(this.textBoxCorreo, "Debe contener @ y sin espacios.");
            // 
            // lblContraseña
            // 
            this.lblContraseña.AutoSize = true;
            this.lblContraseña.Location = new System.Drawing.Point(3, 65);
            this.lblContraseña.Name = "lblContraseña";
            this.lblContraseña.Size = new System.Drawing.Size(61, 13);
            this.lblContraseña.TabIndex = 4;
            this.lblContraseña.Text = "Contraseña";
            // 
            // textBoxContraseña
            // 
            this.textBoxContraseña.Location = new System.Drawing.Point(115, 68);
            this.textBoxContraseña.MaxLength = 8;
            this.textBoxContraseña.Name = "textBoxContraseña";
            this.textBoxContraseña.Size = new System.Drawing.Size(60, 20);
            this.textBoxContraseña.TabIndex = 5;
            this.tip.SetToolTip(this.textBoxContraseña, "Contraseña que solo admite caracteres hexadecimales (0 - 9 y A - F)");
            this.textBoxContraseña.UseSystemPasswordChar = true;
            // 
            // textBoxFecha
            // 
            this.textBoxFecha.Location = new System.Drawing.Point(115, 98);
            this.textBoxFecha.Name = "textBoxFecha";
            this.textBoxFecha.ReadOnly = true;
            this.textBoxFecha.Size = new System.Drawing.Size(121, 20);
            this.textBoxFecha.TabIndex = 8;
            this.tip.SetToolTip(this.textBoxFecha, "Debe ser mayor de edad. Haga clic aquí para desplegar el calendario.");
            // 
            // lblUsuario
            // 
            this.lblUsuario.AutoSize = true;
            this.lblUsuario.Location = new System.Drawing.Point(3, 126);
            this.lblUsuario.Name = "lblUsuario";
            this.lblUsuario.Size = new System.Drawing.Size(96, 13);
            this.lblUsuario.TabIndex = 9;
            this.lblUsuario.Text = "Nombre de usuario";
            // 
            // textBoxUsuario
            // 
            this.textBoxUsuario.Location = new System.Drawing.Point(115, 129);
            this.textBoxUsuario.MaxLength = 15;
            this.textBoxUsuario.Name = "textBoxUsuario";
            this.textBoxUsuario.Size = new System.Drawing.Size(121, 20);
            this.textBoxUsuario.TabIndex = 10;
            this.tip.SetToolTip(this.textBoxUsuario, "Debe empezar por mayúscula y ser único para cada usuario.");
            // 
            // btnRegistrar
            // 
            this.btnRegistrar.Location = new System.Drawing.Point(115, 166);
            this.btnRegistrar.Name = "btnRegistrar";
            this.btnRegistrar.Size = new System.Drawing.Size(121, 23);
            this.btnRegistrar.TabIndex = 11;
            this.btnRegistrar.Text = "Crear usuario";
            this.tip.SetToolTip(this.btnRegistrar, "Debe rellenar todos los campos.");
            this.btnRegistrar.UseVisualStyleBackColor = true;
            this.btnRegistrar.Click += new System.EventHandler(this.btnRegistrar_Click);
            // 
            // btnVerContraseña
            // 
            this.btnVerContraseña.Location = new System.Drawing.Point(184, 73);
            this.btnVerContraseña.Name = "btnVerContraseña";
            this.btnVerContraseña.Size = new System.Drawing.Size(56, 23);
            this.btnVerContraseña.TabIndex = 6;
            this.btnVerContraseña.Text = "Ver";
            this.tip.SetToolTip(this.btnVerContraseña, "Ver/Ocultar contraseña.");
            this.btnVerContraseña.UseVisualStyleBackColor = true;
            this.btnVerContraseña.Click += new System.EventHandler(this.btnVerContraseña_Click);
            // 
            // btnVerContraseñaLogin
            // 
            this.btnVerContraseñaLogin.Location = new System.Drawing.Point(171, 87);
            this.btnVerContraseñaLogin.Name = "btnVerContraseñaLogin";
            this.btnVerContraseñaLogin.Size = new System.Drawing.Size(53, 23);
            this.btnVerContraseñaLogin.TabIndex = 1;
            this.btnVerContraseñaLogin.Text = "Ver";
            this.tip.SetToolTip(this.btnVerContraseñaLogin, "Ver/Ocultar contraseña");
            this.btnVerContraseñaLogin.UseVisualStyleBackColor = true;
            // 
            // textBoxUsuarioLogin
            // 
            this.textBoxUsuarioLogin.Location = new System.Drawing.Point(71, 3);
            this.textBoxUsuarioLogin.MaxLength = 15;
            this.textBoxUsuarioLogin.Name = "textBoxUsuarioLogin";
            this.textBoxUsuarioLogin.Size = new System.Drawing.Size(147, 20);
            this.textBoxUsuarioLogin.TabIndex = 1;
            this.tip.SetToolTip(this.textBoxUsuarioLogin, "Usuario ya registrado que empiece por mayúscula (máx. 15 caracteres).");
            // 
            // textBoxContraseñaLogin
            // 
            this.textBoxContraseñaLogin.Location = new System.Drawing.Point(71, 60);
            this.textBoxContraseñaLogin.MaxLength = 8;
            this.textBoxContraseñaLogin.Name = "textBoxContraseñaLogin";
            this.textBoxContraseñaLogin.Size = new System.Drawing.Size(82, 20);
            this.textBoxContraseñaLogin.TabIndex = 2;
            this.tip.SetToolTip(this.textBoxContraseñaLogin, "Contraseña asociada al usuario en formato hexadecimal (0-9) y (A-F).");
            this.textBoxContraseñaLogin.UseSystemPasswordChar = true;
            // 
            // btnLogin
            // 
            this.btnLogin.Location = new System.Drawing.Point(71, 117);
            this.btnLogin.Name = "btnLogin";
            this.btnLogin.Size = new System.Drawing.Size(147, 23);
            this.btnLogin.TabIndex = 3;
            this.btnLogin.Text = "Login";
            this.tip.SetToolTip(this.btnLogin, "Debe completar ambos campos.");
            this.btnLogin.UseVisualStyleBackColor = true;
            this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
            // 
            // calendarNacimiento
            // 
            this.calendarNacimiento.Location = new System.Drawing.Point(285, 44);
            this.calendarNacimiento.Name = "calendarNacimiento";
            this.calendarNacimiento.TabIndex = 12;
            this.calendarNacimiento.Visible = false;
            this.calendarNacimiento.DateChanged += new System.Windows.Forms.DateRangeEventHandler(this.calendarNacimiento_DateChanged);
            // 
            // tabControlUsuario
            // 
            this.tabControlUsuario.Controls.Add(this.tabPage1);
            this.tabControlUsuario.Controls.Add(this.tabPage2);
            this.tabControlUsuario.Location = new System.Drawing.Point(5, 3);
            this.tabControlUsuario.Name = "tabControlUsuario";
            this.tabControlUsuario.SelectedIndex = 0;
            this.tabControlUsuario.Size = new System.Drawing.Size(272, 238);
            this.tabControlUsuario.TabIndex = 13;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.btnVerContraseña);
            this.tabPage1.Controls.Add(this.tableLayoutPanel1);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(264, 212);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Crear usuario";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.btnVerContraseñaLogin);
            this.tabPage2.Controls.Add(this.tableLayoutPanel2);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(264, 212);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Login";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // tableLayoutPanel2
            // 
            this.tableLayoutPanel2.ColumnCount = 2;
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 28.87029F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 71.12971F));
            this.tableLayoutPanel2.Controls.Add(this.lblContraseñaAsociada, 0, 1);
            this.tableLayoutPanel2.Controls.Add(this.textBoxUsuarioLogin, 1, 0);
            this.tableLayoutPanel2.Controls.Add(this.textBoxContraseñaLogin, 1, 1);
            this.tableLayoutPanel2.Controls.Add(this.btnLogin, 1, 2);
            this.tableLayoutPanel2.Controls.Add(this.lblUsuarioExistente, 0, 0);
            this.tableLayoutPanel2.Location = new System.Drawing.Point(6, 29);
            this.tableLayoutPanel2.Name = "tableLayoutPanel2";
            this.tableLayoutPanel2.RowCount = 3;
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 56F));
            this.tableLayoutPanel2.Size = new System.Drawing.Size(239, 170);
            this.tableLayoutPanel2.TabIndex = 0;
            // 
            // lblContraseñaAsociada
            // 
            this.lblContraseñaAsociada.AutoSize = true;
            this.lblContraseñaAsociada.Location = new System.Drawing.Point(3, 57);
            this.lblContraseñaAsociada.Name = "lblContraseñaAsociada";
            this.lblContraseñaAsociada.Size = new System.Drawing.Size(61, 13);
            this.lblContraseñaAsociada.TabIndex = 1;
            this.lblContraseñaAsociada.Text = "Contraseña";
            // 
            // lblUsuarioExistente
            // 
            this.lblUsuarioExistente.AutoSize = true;
            this.lblUsuarioExistente.Location = new System.Drawing.Point(3, 0);
            this.lblUsuarioExistente.Name = "lblUsuarioExistente";
            this.lblUsuarioExistente.Size = new System.Drawing.Size(62, 26);
            this.lblUsuarioExistente.TabIndex = 0;
            this.lblUsuarioExistente.Text = "Nombre de usuario";
            // 
            // VentanaPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.ClientSize = new System.Drawing.Size(480, 239);
            this.Controls.Add(this.tabControlUsuario);
            this.Controls.Add(this.calendarNacimiento);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "VentanaPrincipal";
            this.Text = "Opciones de usuario";
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.tabControlUsuario.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.tableLayoutPanel2.ResumeLayout(false);
            this.tableLayoutPanel2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private TextBoxNombre textBoxNombre;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Label lblNombre;
        private System.Windows.Forms.Label lblCorreo;
        private TextBoxCorreo textBoxCorreo;
        private System.Windows.Forms.Label lblContraseña;
        private TextBoxContraseña textBoxContraseña;
        private System.Windows.Forms.Button btnVerContraseña;
        private System.Windows.Forms.Label lblFecha;
        private TextBoxFecha textBoxFecha;
        private System.Windows.Forms.Label lblUsuario;
        private TextBoxUsuario textBoxUsuario;
        private System.Windows.Forms.ToolTip tip;
        private System.Windows.Forms.Button btnRegistrar;
        private CalendarNacimiento calendarNacimiento;
        private System.Windows.Forms.TabControl tabControlUsuario;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.Button btnVerContraseñaLogin;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel2;
        private System.Windows.Forms.Label lblContraseñaAsociada;
        private TextBoxUsuario textBoxUsuarioLogin;
        private System.Windows.Forms.Label lblUsuarioExistente;
        private TextBoxContraseña textBoxContraseñaLogin;
        private System.Windows.Forms.Button btnLogin;
    }
}

