namespace NavarroSotoP9 {
    partial class formNuevoGrupo {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing) {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(formNuevoGrupo));
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.lblNombreGrupo = new System.Windows.Forms.Label();
            this.groupBoxAsignaturas = new System.Windows.Forms.GroupBox();
            this.checkedListAsignaturas = new System.Windows.Forms.CheckedListBox();
            this.btnCrear = new System.Windows.Forms.Button();
            this.errorNombre = new System.Windows.Forms.ErrorProvider(this.components);
            this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
            this.errorAsignaturas = new System.Windows.Forms.ErrorProvider(this.components);
            this.textBoxNombreGrupo = new NavarroSotoP9.TextBoxNombreGrupo();
            this.flowLayoutPanel1.SuspendLayout();
            this.tableLayoutPanel1.SuspendLayout();
            this.groupBoxAsignaturas.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorNombre)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.errorAsignaturas)).BeginInit();
            this.SuspendLayout();
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.Controls.Add(this.tableLayoutPanel1);
            this.flowLayoutPanel1.Controls.Add(this.groupBoxAsignaturas);
            this.flowLayoutPanel1.Controls.Add(this.btnCrear);
            this.flowLayoutPanel1.Location = new System.Drawing.Point(12, 12);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(327, 237);
            this.flowLayoutPanel1.TabIndex = 0;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 2;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 49.23077F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50.76923F));
            this.tableLayoutPanel1.Controls.Add(this.textBoxNombreGrupo, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.lblNombreGrupo, 0, 0);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 1;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 13.24786F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(307, 36);
            this.tableLayoutPanel1.TabIndex = 3;
            // 
            // lblNombreGrupo
            // 
            this.lblNombreGrupo.AutoSize = true;
            this.lblNombreGrupo.Location = new System.Drawing.Point(3, 0);
            this.lblNombreGrupo.Name = "lblNombreGrupo";
            this.lblNombreGrupo.Size = new System.Drawing.Size(121, 26);
            this.lblNombreGrupo.TabIndex = 0;
            this.lblNombreGrupo.Text = "Introduce el nombre del grupo";
            // 
            // groupBoxAsignaturas
            // 
            this.groupBoxAsignaturas.Controls.Add(this.checkedListAsignaturas);
            this.groupBoxAsignaturas.Location = new System.Drawing.Point(3, 45);
            this.groupBoxAsignaturas.Name = "groupBoxAsignaturas";
            this.groupBoxAsignaturas.Size = new System.Drawing.Size(307, 132);
            this.groupBoxAsignaturas.TabIndex = 6;
            this.groupBoxAsignaturas.TabStop = false;
            this.groupBoxAsignaturas.Text = "Asignaturas";
            // 
            // checkedListAsignaturas
            // 
            this.checkedListAsignaturas.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.checkedListAsignaturas.CheckOnClick = true;
            this.checkedListAsignaturas.FormattingEnabled = true;
            this.checkedListAsignaturas.Location = new System.Drawing.Point(19, 21);
            this.checkedListAsignaturas.Name = "checkedListAsignaturas";
            this.checkedListAsignaturas.Size = new System.Drawing.Size(238, 105);
            this.checkedListAsignaturas.TabIndex = 4;
            // 
            // btnCrear
            // 
            this.btnCrear.Location = new System.Drawing.Point(3, 183);
            this.btnCrear.Name = "btnCrear";
            this.btnCrear.Size = new System.Drawing.Size(307, 42);
            this.btnCrear.TabIndex = 3;
            this.btnCrear.Text = "Crear";
            this.btnCrear.UseVisualStyleBackColor = true;
            this.btnCrear.Click += new System.EventHandler(this.btnCrear_Click);
            // 
            // errorNombre
            // 
            this.errorNombre.ContainerControl = this;
            // 
            // errorAsignaturas
            // 
            this.errorAsignaturas.ContainerControl = this;
            // 
            // textBoxNombreGrupo
            // 
            this.textBoxNombreGrupo.Location = new System.Drawing.Point(154, 3);
            this.textBoxNombreGrupo.Name = "textBoxNombreGrupo";
            this.textBoxNombreGrupo.Size = new System.Drawing.Size(134, 20);
            this.textBoxNombreGrupo.TabIndex = 2;
            // 
            // formNuevoGrupo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(351, 261);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "formNuevoGrupo";
            this.Text = "formNuevoGrupo";
            this.flowLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.groupBoxAsignaturas.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.errorNombre)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.errorAsignaturas)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.Label lblNombreGrupo;
        private TextBoxNombreGrupo textBoxNombreGrupo;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.GroupBox groupBoxAsignaturas;
        private System.Windows.Forms.CheckedListBox checkedListAsignaturas;
        private System.Windows.Forms.Button btnCrear;
        private System.Windows.Forms.ErrorProvider errorNombre;
        private System.Windows.Forms.ToolTip toolTip1;
        private System.Windows.Forms.ErrorProvider errorAsignaturas;
    }
}