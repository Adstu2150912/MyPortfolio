namespace WinForms_NYCM_Opdr26
{
    partial class FrmRegistratie
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
            this.tdJaar = new System.Windows.Forms.TextBox();
            this.lblChipNm = new System.Windows.Forms.Label();
            this.lblJaar = new System.Windows.Forms.Label();
            this.lblRegPt = new System.Windows.Forms.Label();
            this.tdRegTd = new System.Windows.Forms.TextBox();
            this.lblRegTd = new System.Windows.Forms.Label();
            this.cbChipNm = new System.Windows.Forms.ComboBox();
            this.cbRegpt = new System.Windows.Forms.ComboBox();
            this.lvRegistratie = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.cmnLvRegistratie = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.VerwijderRegistratieToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.AlleRegistratiesVerwijderenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cmnLvRegistratie.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblWeergave
            // 
            this.lblWeergave.Location = new System.Drawing.Point(33, 182);
            this.lblWeergave.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblWeergave.Name = "lblWeergave";
            this.lblWeergave.Size = new System.Drawing.Size(216, 76);
            this.lblWeergave.TabIndex = 21;
            this.lblWeergave.Text = "*weergave*";
            this.lblWeergave.Visible = false;
            // 
            // BtnInvoeren
            // 
            this.BtnInvoeren.Location = new System.Drawing.Point(174, 149);
            this.BtnInvoeren.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.BtnInvoeren.Name = "BtnInvoeren";
            this.BtnInvoeren.Size = new System.Drawing.Size(75, 19);
            this.BtnInvoeren.TabIndex = 20;
            this.BtnInvoeren.Text = "Invoeren";
            this.BtnInvoeren.UseVisualStyleBackColor = true;
            this.BtnInvoeren.Click += new System.EventHandler(this.BtnInvoeren_Click);
            // 
            // tdJaar
            // 
            this.tdJaar.Location = new System.Drawing.Point(174, 116);
            this.tdJaar.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.tdJaar.Name = "tdJaar";
            this.tdJaar.Size = new System.Drawing.Size(76, 20);
            this.tdJaar.TabIndex = 17;
            // 
            // lblChipNm
            // 
            this.lblChipNm.AutoSize = true;
            this.lblChipNm.Location = new System.Drawing.Point(33, 23);
            this.lblChipNm.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblChipNm.Name = "lblChipNm";
            this.lblChipNm.Size = new System.Drawing.Size(65, 13);
            this.lblChipNm.TabIndex = 13;
            this.lblChipNm.Text = "Chipnummer";
            // 
            // lblJaar
            // 
            this.lblJaar.AutoSize = true;
            this.lblJaar.Location = new System.Drawing.Point(33, 116);
            this.lblJaar.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblJaar.Name = "lblJaar";
            this.lblJaar.Size = new System.Drawing.Size(27, 13);
            this.lblJaar.TabIndex = 14;
            this.lblJaar.Text = "Jaar";
            // 
            // lblRegPt
            // 
            this.lblRegPt.AutoSize = true;
            this.lblRegPt.Location = new System.Drawing.Point(33, 82);
            this.lblRegPt.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblRegPt.Name = "lblRegPt";
            this.lblRegPt.Size = new System.Drawing.Size(106, 13);
            this.lblRegPt.TabIndex = 15;
            this.lblRegPt.Text = "Registratiepunt in km";
            // 
            // tdRegTd
            // 
            this.tdRegTd.Location = new System.Drawing.Point(174, 51);
            this.tdRegTd.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.tdRegTd.Name = "tdRegTd";
            this.tdRegTd.Size = new System.Drawing.Size(76, 20);
            this.tdRegTd.TabIndex = 19;
            // 
            // lblRegTd
            // 
            this.lblRegTd.AutoSize = true;
            this.lblRegTd.Location = new System.Drawing.Point(33, 51);
            this.lblRegTd.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblRegTd.Name = "lblRegTd";
            this.lblRegTd.Size = new System.Drawing.Size(121, 13);
            this.lblRegTd.TabIndex = 16;
            this.lblRegTd.Text = "Registratietijd in minuten";
            // 
            // cbChipNm
            // 
            this.cbChipNm.FormattingEnabled = true;
            this.cbChipNm.Location = new System.Drawing.Point(174, 23);
            this.cbChipNm.Name = "cbChipNm";
            this.cbChipNm.Size = new System.Drawing.Size(75, 21);
            this.cbChipNm.TabIndex = 22;
            // 
            // cbRegpt
            // 
            this.cbRegpt.FormattingEnabled = true;
            this.cbRegpt.Location = new System.Drawing.Point(174, 82);
            this.cbRegpt.Name = "cbRegpt";
            this.cbRegpt.Size = new System.Drawing.Size(75, 21);
            this.cbRegpt.TabIndex = 23;
            // 
            // lvRegistratie
            // 
            this.lvRegistratie.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4});
            this.lvRegistratie.ContextMenuStrip = this.cmnLvRegistratie;
            this.lvRegistratie.FullRowSelect = true;
            this.lvRegistratie.GridLines = true;
            this.lvRegistratie.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
            this.lvRegistratie.HoverSelection = true;
            this.lvRegistratie.Location = new System.Drawing.Point(51, 292);
            this.lvRegistratie.Name = "lvRegistratie";
            this.lvRegistratie.Size = new System.Drawing.Size(185, 97);
            this.lvRegistratie.TabIndex = 24;
            this.lvRegistratie.UseCompatibleStateImageBehavior = false;
            this.lvRegistratie.View = System.Windows.Forms.View.Details;
            // 
            // cmnLvRegistratie
            // 
            this.cmnLvRegistratie.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.cmnLvRegistratie.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.VerwijderRegistratieToolStripMenuItem,
            this.AlleRegistratiesVerwijderenToolStripMenuItem});
            this.cmnLvRegistratie.Name = "cmnLvBestelling";
            this.cmnLvRegistratie.Size = new System.Drawing.Size(219, 48);
            // 
            // VerwijderRegistratieToolStripMenuItem
            // 
            this.VerwijderRegistratieToolStripMenuItem.Name = "VerwijderRegistratieToolStripMenuItem";
            this.VerwijderRegistratieToolStripMenuItem.Size = new System.Drawing.Size(218, 22);
            this.VerwijderRegistratieToolStripMenuItem.Text = "Verwijder registratie";
            this.VerwijderRegistratieToolStripMenuItem.Click += new System.EventHandler(this.VerwijderRegistratieToolStripMenuItem_Click);
            // 
            // AlleRegistratiesVerwijderenToolStripMenuItem
            // 
            this.AlleRegistratiesVerwijderenToolStripMenuItem.Name = "AlleRegistratiesVerwijderenToolStripMenuItem";
            this.AlleRegistratiesVerwijderenToolStripMenuItem.Size = new System.Drawing.Size(218, 22);
            this.AlleRegistratiesVerwijderenToolStripMenuItem.Text = "Alle registraties verwijderen";
            this.AlleRegistratiesVerwijderenToolStripMenuItem.Click += new System.EventHandler(this.AlleRegistratiesVerwijderenToolStripMenuItem_Click);
            // 
            // FrmRegistratie
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 472);
            this.Controls.Add(this.lvRegistratie);
            this.Controls.Add(this.cbRegpt);
            this.Controls.Add(this.cbChipNm);
            this.Controls.Add(this.lblWeergave);
            this.Controls.Add(this.BtnInvoeren);
            this.Controls.Add(this.tdJaar);
            this.Controls.Add(this.lblChipNm);
            this.Controls.Add(this.lblJaar);
            this.Controls.Add(this.lblRegPt);
            this.Controls.Add(this.tdRegTd);
            this.Controls.Add(this.lblRegTd);
            this.Name = "FrmRegistratie";
            this.Text = "Registratie";
            this.Load += new System.EventHandler(this.FrmRegistratie_Load);
            this.cmnLvRegistratie.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblWeergave;
        private System.Windows.Forms.Button BtnInvoeren;
        private System.Windows.Forms.TextBox tdJaar;
        private System.Windows.Forms.Label lblChipNm;
        private System.Windows.Forms.Label lblJaar;
        private System.Windows.Forms.Label lblRegPt;
        private System.Windows.Forms.TextBox tdRegTd;
        private System.Windows.Forms.Label lblRegTd;
        private System.Windows.Forms.ComboBox cbChipNm;
        private System.Windows.Forms.ComboBox cbRegpt;
        private System.Windows.Forms.ListView lvRegistratie;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ContextMenuStrip cmnLvRegistratie;
        private System.Windows.Forms.ToolStripMenuItem VerwijderRegistratieToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem AlleRegistratiesVerwijderenToolStripMenuItem;
    }
}