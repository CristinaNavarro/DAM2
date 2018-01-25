namespace NavarroSotoP9 {
    partial class gestionGrupos {
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(gestionGrupos));
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.btnNuevoGrupo = new System.Windows.Forms.Button();
            this.btnAbrirGrupo = new System.Windows.Forms.Button();
            this.btnGuardarGrupo = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.groupTablaGrupo = new System.Windows.Forms.GroupBox();
            this.btnEliminarFila = new System.Windows.Forms.Button();
            this.checkAprobados = new System.Windows.Forms.CheckBox();
            this.gridDatosAlumnos = new System.Windows.Forms.DataGridView();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.opcionesToolStrip = new System.Windows.Forms.ToolStripMenuItem();
            this.nuevoGrupoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.abrirGrupoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.tooltipPrincipal = new System.Windows.Forms.ToolTip(this.components);
            this.flowLayoutPanel1.SuspendLayout();
            this.groupTablaGrupo.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.gridDatosAlumnos)).BeginInit();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.Controls.Add(this.btnNuevoGrupo);
            this.flowLayoutPanel1.Controls.Add(this.btnAbrirGrupo);
            this.flowLayoutPanel1.Controls.Add(this.btnGuardarGrupo);
            this.flowLayoutPanel1.Controls.Add(this.btnSalir);
            this.flowLayoutPanel1.Location = new System.Drawing.Point(12, 27);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(212, 211);
            this.flowLayoutPanel1.TabIndex = 0;
            // 
            // btnNuevoGrupo
            // 
            this.btnNuevoGrupo.Location = new System.Drawing.Point(3, 3);
            this.btnNuevoGrupo.Name = "btnNuevoGrupo";
            this.btnNuevoGrupo.Size = new System.Drawing.Size(100, 100);
            this.btnNuevoGrupo.TabIndex = 0;
            this.btnNuevoGrupo.Text = "Nuevo grupo";
            this.btnNuevoGrupo.UseVisualStyleBackColor = true;
            this.btnNuevoGrupo.Click += new System.EventHandler(this.btnCrearGrupo_Click);
            // 
            // btnAbrirGrupo
            // 
            this.btnAbrirGrupo.Location = new System.Drawing.Point(109, 3);
            this.btnAbrirGrupo.Name = "btnAbrirGrupo";
            this.btnAbrirGrupo.Size = new System.Drawing.Size(100, 100);
            this.btnAbrirGrupo.TabIndex = 1;
            this.btnAbrirGrupo.Text = "Abrir grupo (.gru) o informe (.inf)";
            this.btnAbrirGrupo.UseVisualStyleBackColor = true;
            this.btnAbrirGrupo.Click += new System.EventHandler(this.btnAbrirGrupo_Click);
            // 
            // btnGuardarGrupo
            // 
            this.btnGuardarGrupo.Enabled = false;
            this.btnGuardarGrupo.Location = new System.Drawing.Point(3, 109);
            this.btnGuardarGrupo.Name = "btnGuardarGrupo";
            this.btnGuardarGrupo.Size = new System.Drawing.Size(100, 100);
            this.btnGuardarGrupo.TabIndex = 2;
            this.btnGuardarGrupo.Text = "Guardar grupo";
            this.btnGuardarGrupo.UseVisualStyleBackColor = true;
            this.btnGuardarGrupo.Click += new System.EventHandler(this.btnGuardarGrupo_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.Image = ((System.Drawing.Image)(resources.GetObject("btnSalir.Image")));
            this.btnSalir.Location = new System.Drawing.Point(109, 109);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(100, 100);
            this.btnSalir.TabIndex = 3;
            this.btnSalir.UseVisualStyleBackColor = true;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // groupTablaGrupo
            // 
            this.groupTablaGrupo.AutoSize = true;
            this.groupTablaGrupo.Controls.Add(this.btnEliminarFila);
            this.groupTablaGrupo.Controls.Add(this.checkAprobados);
            this.groupTablaGrupo.Controls.Add(this.gridDatosAlumnos);
            this.groupTablaGrupo.Location = new System.Drawing.Point(252, 13);
            this.groupTablaGrupo.Name = "groupTablaGrupo";
            this.groupTablaGrupo.Size = new System.Drawing.Size(629, 225);
            this.groupTablaGrupo.TabIndex = 1;
            this.groupTablaGrupo.TabStop = false;
            this.groupTablaGrupo.Text = "Grupo";
            this.groupTablaGrupo.Visible = false;
            // 
            // btnEliminarFila
            // 
            this.btnEliminarFila.Location = new System.Drawing.Point(473, 17);
            this.btnEliminarFila.Name = "btnEliminarFila";
            this.btnEliminarFila.Size = new System.Drawing.Size(148, 23);
            this.btnEliminarFila.TabIndex = 3;
            this.btnEliminarFila.Text = "Eliminar fila seleccionada";
            this.btnEliminarFila.UseVisualStyleBackColor = true;
            this.btnEliminarFila.Click += new System.EventHandler(this.btnEliminarFila_Click);
            // 
            // checkAprobados
            // 
            this.checkAprobados.AutoSize = true;
            this.checkAprobados.Location = new System.Drawing.Point(22, 28);
            this.checkAprobados.Name = "checkAprobados";
            this.checkAprobados.Size = new System.Drawing.Size(77, 17);
            this.checkAprobados.TabIndex = 1;
            this.checkAprobados.Text = "Aprobados";
            this.tooltipPrincipal.SetToolTip(this.checkAprobados, "Es necesario guardar los cambios realizados en el archivo para poder obtener un i" +
        "nforme.");
            this.checkAprobados.UseVisualStyleBackColor = true;
            this.checkAprobados.CheckedChanged += new System.EventHandler(this.checkAprobados_CheckedChanged);
            this.checkAprobados.MouseHover += new System.EventHandler(this.checkAprobados_MouseHover);
            // 
            // gridDatosAlumnos
            // 
            this.gridDatosAlumnos.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.ColumnHeader;
            this.gridDatosAlumnos.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.gridDatosAlumnos.Location = new System.Drawing.Point(22, 51);
            this.gridDatosAlumnos.Name = "gridDatosAlumnos";
            this.gridDatosAlumnos.Size = new System.Drawing.Size(599, 153);
            this.gridDatosAlumnos.TabIndex = 0;
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.opcionesToolStrip});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(241, 24);
            this.menuStrip1.TabIndex = 2;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // opcionesToolStrip
            // 
            this.opcionesToolStrip.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.nuevoGrupoToolStripMenuItem,
            this.abrirGrupoToolStripMenuItem});
            this.opcionesToolStrip.Name = "opcionesToolStrip";
            this.opcionesToolStrip.Size = new System.Drawing.Size(69, 20);
            this.opcionesToolStrip.Text = "Opciones";
            // 
            // nuevoGrupoToolStripMenuItem
            // 
            this.nuevoGrupoToolStripMenuItem.Name = "nuevoGrupoToolStripMenuItem";
            this.nuevoGrupoToolStripMenuItem.Size = new System.Drawing.Size(190, 22);
            this.nuevoGrupoToolStripMenuItem.Text = "Nuevo grupo";
            this.nuevoGrupoToolStripMenuItem.Click += new System.EventHandler(this.nuevoGrupoToolStripMenuItem_Click);
            // 
            // abrirGrupoToolStripMenuItem
            // 
            this.abrirGrupoToolStripMenuItem.Name = "abrirGrupoToolStripMenuItem";
            this.abrirGrupoToolStripMenuItem.Size = new System.Drawing.Size(190, 22);
            this.abrirGrupoToolStripMenuItem.Text = "Abrir grupo o informe";
            this.abrirGrupoToolStripMenuItem.Click += new System.EventHandler(this.abrirGrupoToolStripMenuItem_Click);
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            this.openFileDialog1.FileOk += new System.ComponentModel.CancelEventHandler(this.openFileDialog1_FileOk);
            // 
            // gestionGrupos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.ClientSize = new System.Drawing.Size(241, 248);
            this.Controls.Add(this.groupTablaGrupo);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Controls.Add(this.menuStrip1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "gestionGrupos";
            this.Text = "Gestión grupos de alumnos";
            this.flowLayoutPanel1.ResumeLayout(false);
            this.groupTablaGrupo.ResumeLayout(false);
            this.groupTablaGrupo.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.gridDatosAlumnos)).EndInit();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.Button btnNuevoGrupo;
        private System.Windows.Forms.Button btnAbrirGrupo;
        private System.Windows.Forms.Button btnGuardarGrupo;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.GroupBox groupTablaGrupo;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem opcionesToolStrip;
        private System.Windows.Forms.ToolStripMenuItem nuevoGrupoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem abrirGrupoToolStripMenuItem;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.DataGridView gridDatosAlumnos;
        private System.Windows.Forms.CheckBox checkAprobados;
        private System.Windows.Forms.Button btnEliminarFila;
        private System.Windows.Forms.ToolTip tooltipPrincipal;
    }
}

