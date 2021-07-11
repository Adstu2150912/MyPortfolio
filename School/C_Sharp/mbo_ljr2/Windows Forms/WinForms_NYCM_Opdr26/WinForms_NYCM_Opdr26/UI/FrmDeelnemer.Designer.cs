namespace WinForms_NYCM_Opdr26
{
    partial class FrmDeelnemer
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
            this.components = new System.ComponentModel.Container();
            this.lblWeergave = new System.Windows.Forms.Label();
            this.BtnInvoeren = new System.Windows.Forms.Button();
            this.tbChipnm = new System.Windows.Forms.TextBox();
            this.lblChipnm = new System.Windows.Forms.Label();
            this.tbRugnm = new System.Windows.Forms.TextBox();
            this.lblRugnm = new System.Windows.Forms.Label();
            this.tbDeelnm = new System.Windows.Forms.TextBox();
            this.lblDeelnm = new System.Windows.Forms.Label();
            this.lvDeelnemer = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.cmnLvDeelnemer = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.VerwijderDeelnemerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.AlleDeelnemersVerwijderenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cmnLvDeelnemer.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblWeergave
            // 
            this.lblWeergave.Location = new System.Drawing.Point(69, 197);
            this.lblWeergave.Name = "lblWeergave";
            this.lblWeergave.Size = new System.Drawing.Size(240, 84);
            this.lblWeergave.TabIndex = 11;
            this.lblWeergave.Text = "*weergave*";
            this.lblWeergave.Visible = false;
            // 
            // BtnInvoeren
            // 
            this.BtnInvoeren.Location = new System.Drawing.Point(209, 160);
            this.BtnInvoeren.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.BtnInvoeren.Name = "BtnInvoeren";
            this.BtnInvoeren.Size = new System.Drawing.Size(100, 23);
            this.BtnInvoeren.TabIndex = 10;
            this.BtnInvoeren.Text = "Invoeren";
            this.BtnInvoeren.UseVisualStyleBackColor = true;
            this.BtnInvoeren.Click += new System.EventHandler(this.BtnInvoeren_Click);
            // 
            // tbChipnm
            // 
            this.tbChipnm.Location = new System.Drawing.Point(209, 121);
            this.tbChipnm.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.tbChipnm.Name = "tbChipnm";
            this.tbChipnm.Size = new System.Drawing.Size(100, 22);
            this.tbChipnm.TabIndex = 7;
            // 
            // lblChipnm
            // 
            this.lblChipnm.AutoSize = true;
            this.lblChipnm.Location = new System.Drawing.Point(69, 121);
            this.lblChipnm.Name = "lblChipnm";
            this.lblChipnm.Size = new System.Drawing.Size(87, 17);
            this.lblChipnm.TabIndex = 4;
            this.lblChipnm.Text = "Chipnummer";
            // 
            // tbRugnm
            // 
            this.tbRugnm.Location = new System.Drawing.Point(209, 79);
            this.tbRugnm.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.tbRugnm.Name = "tbRugnm";
            this.tbRugnm.Size = new System.Drawing.Size(100, 22);
            this.tbRugnm.TabIndex = 8;
            // 
            // lblRugnm
            // 
            this.lblRugnm.AutoSize = true;
            this.lblRugnm.Location = new System.Drawing.Point(69, 79);
            this.lblRugnm.Name = "lblRugnm";
            this.lblRugnm.Size = new System.Drawing.Size(85, 17);
            this.lblRugnm.TabIndex = 5;
            this.lblRugnm.Text = "Rugnummer";
            // 
            // tbDeelnm
            // 
            this.tbDeelnm.Location = new System.Drawing.Point(209, 41);
            this.tbDeelnm.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.tbDeelnm.Name = "tbDeelnm";
            this.tbDeelnm.Size = new System.Drawing.Size(100, 22);
            this.tbDeelnm.TabIndex = 9;
            // 
            // lblDeelnm
            // 
            this.lblDeelnm.AutoSize = true;
            this.lblDeelnm.Location = new System.Drawing.Point(69, 41);
            this.lblDeelnm.Name = "lblDeelnm";
            this.lblDeelnm.Size = new System.Drawing.Size(77, 17);
            this.lblDeelnm.TabIndex = 6;
            this.lblDeelnm.Text = "Deelnemer";
            // 
            // lvDeelnemer
            // 
            this.lvDeelnemer.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3});
            this.lvDeelnemer.ContextMenuStrip = this.cmnLvDeelnemer;
            this.lvDeelnemer.FullRowSelect = true;
            this.lvDeelnemer.GridLines = true;
            this.lvDeelnemer.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
            this.lvDeelnemer.Location = new System.Drawing.Point(72, 305);
            this.lvDeelnemer.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.lvDeelnemer.Name = "lvDeelnemer";
            this.lvDeelnemer.Size = new System.Drawing.Size(237, 118);
            this.lvDeelnemer.TabIndex = 12;
            this.lvDeelnemer.UseCompatibleStateImageBehavior = false;
            this.lvDeelnemer.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "ColumnHeader";
            // 
            // cmnLvDeelnemer
            // 
            this.cmnLvDeelnemer.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.cmnLvDeelnemer.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.VerwijderDeelnemerToolStripMenuItem,
            this.AlleDeelnemersVerwijderenToolStripMenuItem});
            this.cmnLvDeelnemer.Name = "cmnLvBestelling";
            this.cmnLvDeelnemer.Size = new System.Drawing.Size(267, 80);
            // 
            // VerwijderDeelnemerToolStripMenuItem
            // 
            this.VerwijderDeelnemerToolStripMenuItem.Name = "VerwijderDeelnemerToolStripMenuItem";
            this.VerwijderDeelnemerToolStripMenuItem.Size = new System.Drawing.Size(266, 24);
            this.VerwijderDeelnemerToolStripMenuItem.Text = "Verwijder deelnemer";
            this.VerwijderDeelnemerToolStripMenuItem.Click += new System.EventHandler(this.VerwijderDeelnemerToolStripMenuItem_Click);
            // 
            // AlleDeelnemersVerwijderenToolStripMenuItem
            // 
            this.AlleDeelnemersVerwijderenToolStripMenuItem.Name = "AlleDeelnemersVerwijderenToolStripMenuItem";
            this.AlleDeelnemersVerwijderenToolStripMenuItem.Size = new System.Drawing.Size(266, 24);
            this.AlleDeelnemersVerwijderenToolStripMenuItem.Text = "Alle deelnemers verwijderen";
            this.AlleDeelnemersVerwijderenToolStripMenuItem.Click += new System.EventHandler(this.AlleDeelnemersVerwijderenToolStripMenuItem_Click);
            // 
            // FrmDeelnemer
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(379, 514);
            this.Controls.Add(this.lvDeelnemer);
            this.Controls.Add(this.lblWeergave);
            this.Controls.Add(this.BtnInvoeren);
            this.Controls.Add(this.tbChipnm);
            this.Controls.Add(this.lblChipnm);
            this.Controls.Add(this.tbRugnm);
            this.Controls.Add(this.lblRugnm);
            this.Controls.Add(this.tbDeelnm);
            this.Controls.Add(this.lblDeelnm);
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "FrmDeelnemer";
            this.Text = "Deelnemer";
            this.Load += new System.EventHandler(this.FrmDeelnemer_Load);
            this.cmnLvDeelnemer.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblWeergave;
        private System.Windows.Forms.Button BtnInvoeren;
        private System.Windows.Forms.TextBox tbChipnm;
        private System.Windows.Forms.Label lblChipnm;
        private System.Windows.Forms.TextBox tbRugnm;
        private System.Windows.Forms.Label lblRugnm;
        private System.Windows.Forms.TextBox tbDeelnm;
        private System.Windows.Forms.Label lblDeelnm;
        private System.Windows.Forms.ListView lvDeelnemer;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ContextMenuStrip cmnLvDeelnemer;
        private System.Windows.Forms.ToolStripMenuItem VerwijderDeelnemerToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem AlleDeelnemersVerwijderenToolStripMenuItem;
    }
}