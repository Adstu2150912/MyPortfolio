namespace Numerieke_Algoritme
{
    partial class FrmANum
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.bestandToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.afsluitenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lblGetal = new System.Windows.Forms.Label();
            this.txtGetal = new System.Windows.Forms.TextBox();
            this.btnInvoeren = new System.Windows.Forms.Button();
            this.lvNumArrays = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.lblVoorkeur = new System.Windows.Forms.Label();
            this.rbVoorkeur1 = new System.Windows.Forms.RadioButton();
            this.rbVoorkeur2 = new System.Windows.Forms.RadioButton();
            this.ckbVoorkeur3 = new System.Windows.Forms.CheckBox();
            this.lblTotalRows = new System.Windows.Forms.Label();
            this.lblLoopTijd = new System.Windows.Forms.Label();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bestandToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(635, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // bestandToolStripMenuItem
            // 
            this.bestandToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.afsluitenToolStripMenuItem});
            this.bestandToolStripMenuItem.Name = "bestandToolStripMenuItem";
            this.bestandToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.bestandToolStripMenuItem.Text = "Bestand";
            // 
            // afsluitenToolStripMenuItem
            // 
            this.afsluitenToolStripMenuItem.Name = "afsluitenToolStripMenuItem";
            this.afsluitenToolStripMenuItem.Size = new System.Drawing.Size(121, 22);
            this.afsluitenToolStripMenuItem.Text = "Afsluiten";
            this.afsluitenToolStripMenuItem.Click += new System.EventHandler(this.afsluitenToolStripMenuItem_Click);
            // 
            // lblGetal
            // 
            this.lblGetal.AutoSize = true;
            this.lblGetal.Location = new System.Drawing.Point(123, 66);
            this.lblGetal.Name = "lblGetal";
            this.lblGetal.Size = new System.Drawing.Size(90, 13);
            this.lblGetal.TabIndex = 1;
            this.lblGetal.Text = "Voer een getal in:";
            // 
            // txtGetal
            // 
            this.txtGetal.Location = new System.Drawing.Point(264, 66);
            this.txtGetal.Name = "txtGetal";
            this.txtGetal.Size = new System.Drawing.Size(100, 20);
            this.txtGetal.TabIndex = 2;
            // 
            // btnInvoeren
            // 
            this.btnInvoeren.Location = new System.Drawing.Point(264, 180);
            this.btnInvoeren.Name = "btnInvoeren";
            this.btnInvoeren.Size = new System.Drawing.Size(75, 23);
            this.btnInvoeren.TabIndex = 3;
            this.btnInvoeren.Text = "Invoeren";
            this.btnInvoeren.UseVisualStyleBackColor = true;
            this.btnInvoeren.Click += new System.EventHandler(this.btnInvoeren_Click);
            // 
            // lvNumArrays
            // 
            this.lvNumArrays.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3});
            this.lvNumArrays.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.Nonclickable;
            this.lvNumArrays.Location = new System.Drawing.Point(126, 257);
            this.lvNumArrays.Name = "lvNumArrays";
            this.lvNumArrays.Size = new System.Drawing.Size(360, 154);
            this.lvNumArrays.TabIndex = 4;
            this.lvNumArrays.UseCompatibleStateImageBehavior = false;
            this.lvNumArrays.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "Naam";
            this.columnHeader1.Width = 66;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Getallen";
            this.columnHeader2.Width = 195;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "Aantal";
            this.columnHeader3.Width = 93;
            // 
            // lblVoorkeur
            // 
            this.lblVoorkeur.AutoSize = true;
            this.lblVoorkeur.Location = new System.Drawing.Point(123, 107);
            this.lblVoorkeur.Name = "lblVoorkeur";
            this.lblVoorkeur.Size = new System.Drawing.Size(109, 13);
            this.lblVoorkeur.TabIndex = 1;
            this.lblVoorkeur.Text = "Voorkeur berekening:";
            // 
            // rbVoorkeur1
            // 
            this.rbVoorkeur1.AutoSize = true;
            this.rbVoorkeur1.Location = new System.Drawing.Point(264, 107);
            this.rbVoorkeur1.Name = "rbVoorkeur1";
            this.rbVoorkeur1.Size = new System.Drawing.Size(44, 17);
            this.rbVoorkeur1.TabIndex = 5;
            this.rbVoorkeur1.TabStop = true;
            this.rbVoorkeur1.Text = "snel";
            this.rbVoorkeur1.UseVisualStyleBackColor = true;
            // 
            // rbVoorkeur2
            // 
            this.rbVoorkeur2.AutoSize = true;
            this.rbVoorkeur2.Location = new System.Drawing.Point(264, 130);
            this.rbVoorkeur2.Name = "rbVoorkeur2";
            this.rbVoorkeur2.Size = new System.Drawing.Size(64, 17);
            this.rbVoorkeur2.TabIndex = 5;
            this.rbVoorkeur2.TabStop = true;
            this.rbVoorkeur2.Text = "optimaal";
            this.rbVoorkeur2.UseVisualStyleBackColor = true;
            // 
            // ckbVoorkeur3
            // 
            this.ckbVoorkeur3.AutoSize = true;
            this.ckbVoorkeur3.Location = new System.Drawing.Point(264, 154);
            this.ckbVoorkeur3.Name = "ckbVoorkeur3";
            this.ckbVoorkeur3.Size = new System.Drawing.Size(142, 17);
            this.ckbVoorkeur3.TabIndex = 6;
            this.ckbVoorkeur3.Text = "willekeurige naamgeving";
            this.ckbVoorkeur3.UseVisualStyleBackColor = true;
            // 
            // lblTotalRows
            // 
            this.lblTotalRows.AutoSize = true;
            this.lblTotalRows.Location = new System.Drawing.Point(123, 214);
            this.lblTotalRows.Name = "lblTotalRows";
            this.lblTotalRows.Size = new System.Drawing.Size(99, 13);
            this.lblTotalRows.TabIndex = 7;
            this.lblTotalRows.Text = "*Totaal aantal rijen*";
            this.lblTotalRows.Visible = false;
            // 
            // lblLoopTijd
            // 
            this.lblLoopTijd.AutoSize = true;
            this.lblLoopTijd.Location = new System.Drawing.Point(123, 237);
            this.lblLoopTijd.Name = "lblLoopTijd";
            this.lblLoopTijd.Size = new System.Drawing.Size(52, 13);
            this.lblLoopTijd.TabIndex = 7;
            this.lblLoopTijd.Text = "*Looptijd*";
            this.lblLoopTijd.Visible = false;
            // 
            // FrmANum
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(635, 450);
            this.Controls.Add(this.lblLoopTijd);
            this.Controls.Add(this.lblTotalRows);
            this.Controls.Add(this.ckbVoorkeur3);
            this.Controls.Add(this.rbVoorkeur2);
            this.Controls.Add(this.rbVoorkeur1);
            this.Controls.Add(this.lvNumArrays);
            this.Controls.Add(this.btnInvoeren);
            this.Controls.Add(this.txtGetal);
            this.Controls.Add(this.lblVoorkeur);
            this.Controls.Add(this.lblGetal);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "FrmANum";
            this.Text = "Bereken numerieke rijen";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem bestandToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem afsluitenToolStripMenuItem;
        private System.Windows.Forms.Label lblGetal;
        private System.Windows.Forms.TextBox txtGetal;
        private System.Windows.Forms.Button btnInvoeren;
        private System.Windows.Forms.ListView lvNumArrays;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.Label lblVoorkeur;
        private System.Windows.Forms.RadioButton rbVoorkeur1;
        private System.Windows.Forms.RadioButton rbVoorkeur2;
        private System.Windows.Forms.CheckBox ckbVoorkeur3;
        private System.Windows.Forms.Label lblTotalRows;
        private System.Windows.Forms.Label lblLoopTijd;
    }
}

