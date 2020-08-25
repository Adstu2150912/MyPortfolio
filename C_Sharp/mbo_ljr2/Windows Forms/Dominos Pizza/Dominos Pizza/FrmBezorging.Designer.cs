namespace Dominos_Pizza
{
    partial class FrmBezorging
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
            this.tbactieCode = new System.Windows.Forms.TextBox();
            this.btnInvoeren = new System.Windows.Forms.Button();
            this.lblActieCode = new System.Windows.Forms.Label();
            this.lblBezorgTijd = new System.Windows.Forms.Label();
            this.lblBezorgDag = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lblPostCode = new System.Windows.Forms.Label();
            this.tbPostCode = new System.Windows.Forms.TextBox();
            this.tbHuisNummer = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtBezorgdag = new System.Windows.Forms.TextBox();
            this.txtBezorgtijd = new System.Windows.Forms.TextBox();
            this.cbBestelCode = new System.Windows.Forms.ComboBox();
            this.lvBezorging = new System.Windows.Forms.ListView();
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader5 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader6 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.cmnLvBezorging = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.verwijderBezorgingToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.alleBezorgingenVerwijderenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.cmnLvBezorging.SuspendLayout();
            this.SuspendLayout();
            // 
            // tbactieCode
            // 
            this.tbactieCode.Location = new System.Drawing.Point(584, 63);
            this.tbactieCode.Name = "tbactieCode";
            this.tbactieCode.Size = new System.Drawing.Size(84, 20);
            this.tbactieCode.TabIndex = 21;
            // 
            // btnInvoeren
            // 
            this.btnInvoeren.Location = new System.Drawing.Point(28, 101);
            this.btnInvoeren.Margin = new System.Windows.Forms.Padding(2);
            this.btnInvoeren.Name = "btnInvoeren";
            this.btnInvoeren.Size = new System.Drawing.Size(157, 24);
            this.btnInvoeren.TabIndex = 17;
            this.btnInvoeren.Text = "Bezorging Invoeren";
            this.btnInvoeren.UseVisualStyleBackColor = true;
            this.btnInvoeren.Click += new System.EventHandler(this.btnBevestigen_Click);
            // 
            // lblActieCode
            // 
            this.lblActieCode.AutoSize = true;
            this.lblActieCode.Location = new System.Drawing.Point(581, 35);
            this.lblActieCode.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblActieCode.Name = "lblActieCode";
            this.lblActieCode.Size = new System.Drawing.Size(55, 13);
            this.lblActieCode.TabIndex = 11;
            this.lblActieCode.Text = "Actiecode";
            // 
            // lblBezorgTijd
            // 
            this.lblBezorgTijd.AutoSize = true;
            this.lblBezorgTijd.Location = new System.Drawing.Point(332, 35);
            this.lblBezorgTijd.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblBezorgTijd.Name = "lblBezorgTijd";
            this.lblBezorgTijd.Size = new System.Drawing.Size(53, 13);
            this.lblBezorgTijd.TabIndex = 12;
            this.lblBezorgTijd.Text = "Bezorgtijd";
            // 
            // lblBezorgDag
            // 
            this.lblBezorgDag.AutoSize = true;
            this.lblBezorgDag.Location = new System.Drawing.Point(208, 35);
            this.lblBezorgDag.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblBezorgDag.Name = "lblBezorgDag";
            this.lblBezorgDag.Size = new System.Drawing.Size(58, 13);
            this.lblBezorgDag.TabIndex = 13;
            this.lblBezorgDag.Text = "Bezorgdag";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(122, 35);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(65, 13);
            this.label1.TabIndex = 15;
            this.label1.Text = "Huisnummer";
            // 
            // lblPostCode
            // 
            this.lblPostCode.AutoSize = true;
            this.lblPostCode.Location = new System.Drawing.Point(26, 35);
            this.lblPostCode.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblPostCode.Name = "lblPostCode";
            this.lblPostCode.Size = new System.Drawing.Size(52, 13);
            this.lblPostCode.TabIndex = 16;
            this.lblPostCode.Text = "Postcode";
            // 
            // tbPostCode
            // 
            this.tbPostCode.Location = new System.Drawing.Point(28, 63);
            this.tbPostCode.Name = "tbPostCode";
            this.tbPostCode.Size = new System.Drawing.Size(70, 20);
            this.tbPostCode.TabIndex = 21;
            // 
            // tbHuisNummer
            // 
            this.tbHuisNummer.Location = new System.Drawing.Point(124, 63);
            this.tbHuisNummer.Name = "tbHuisNummer";
            this.tbHuisNummer.Size = new System.Drawing.Size(62, 20);
            this.tbHuisNummer.TabIndex = 21;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(452, 35);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(60, 13);
            this.label2.TabIndex = 12;
            this.label2.Text = "Bestelcode";
            // 
            // txtBezorgdag
            // 
            this.txtBezorgdag.Location = new System.Drawing.Point(210, 63);
            this.txtBezorgdag.Name = "txtBezorgdag";
            this.txtBezorgdag.Size = new System.Drawing.Size(99, 20);
            this.txtBezorgdag.TabIndex = 21;
            // 
            // txtBezorgtijd
            // 
            this.txtBezorgtijd.Location = new System.Drawing.Point(334, 63);
            this.txtBezorgtijd.Name = "txtBezorgtijd";
            this.txtBezorgtijd.Size = new System.Drawing.Size(86, 20);
            this.txtBezorgtijd.TabIndex = 21;
            // 
            // cbBestelCode
            // 
            this.cbBestelCode.FormattingEnabled = true;
            this.cbBestelCode.Location = new System.Drawing.Point(454, 63);
            this.cbBestelCode.Margin = new System.Windows.Forms.Padding(2);
            this.cbBestelCode.Name = "cbBestelCode";
            this.cbBestelCode.Size = new System.Drawing.Size(108, 21);
            this.cbBestelCode.TabIndex = 22;
            // 
            // lvBezorging
            // 
            this.lvBezorging.Activation = System.Windows.Forms.ItemActivation.OneClick;
            this.lvBezorging.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4,
            this.columnHeader5,
            this.columnHeader6,
            this.columnHeader1});
            this.lvBezorging.ContextMenuStrip = this.cmnLvBezorging;
            this.lvBezorging.FullRowSelect = true;
            this.lvBezorging.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
            this.lvBezorging.Location = new System.Drawing.Point(28, 145);
            this.lvBezorging.Margin = new System.Windows.Forms.Padding(2);
            this.lvBezorging.MultiSelect = false;
            this.lvBezorging.Name = "lvBezorging";
            this.lvBezorging.Size = new System.Drawing.Size(639, 98);
            this.lvBezorging.TabIndex = 23;
            this.lvBezorging.UseCompatibleStateImageBehavior = false;
            this.lvBezorging.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "";
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "";
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "";
            // 
            // columnHeader5
            // 
            this.columnHeader5.Text = "";
            // 
            // columnHeader6
            // 
            this.columnHeader6.Text = "";
            // 
            // cmnLvBezorging
            // 
            this.cmnLvBezorging.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.verwijderBezorgingToolStripMenuItem,
            this.alleBezorgingenVerwijderenToolStripMenuItem});
            this.cmnLvBezorging.Name = "cmnLvBezorging";
            this.cmnLvBezorging.Size = new System.Drawing.Size(228, 48);
            // 
            // verwijderBezorgingToolStripMenuItem
            // 
            this.verwijderBezorgingToolStripMenuItem.Name = "verwijderBezorgingToolStripMenuItem";
            this.verwijderBezorgingToolStripMenuItem.Size = new System.Drawing.Size(227, 22);
            this.verwijderBezorgingToolStripMenuItem.Text = "Verwijder Bezorging";
            this.verwijderBezorgingToolStripMenuItem.Click += new System.EventHandler(this.verwijderBezorgingToolStripMenuItem_Click);
            // 
            // alleBezorgingenVerwijderenToolStripMenuItem
            // 
            this.alleBezorgingenVerwijderenToolStripMenuItem.Name = "alleBezorgingenVerwijderenToolStripMenuItem";
            this.alleBezorgingenVerwijderenToolStripMenuItem.Size = new System.Drawing.Size(227, 22);
            this.alleBezorgingenVerwijderenToolStripMenuItem.Text = "Alle bezorgingen verwijderen";
            this.alleBezorgingenVerwijderenToolStripMenuItem.Click += new System.EventHandler(this.alleBezorgingenVerwijderenToolStripMenuItem_Click);
            // 
            // FrmBezorging
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(691, 275);
            this.Controls.Add(this.lvBezorging);
            this.Controls.Add(this.cbBestelCode);
            this.Controls.Add(this.txtBezorgtijd);
            this.Controls.Add(this.txtBezorgdag);
            this.Controls.Add(this.tbHuisNummer);
            this.Controls.Add(this.tbPostCode);
            this.Controls.Add(this.tbactieCode);
            this.Controls.Add(this.btnInvoeren);
            this.Controls.Add(this.lblActieCode);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lblBezorgTijd);
            this.Controls.Add(this.lblBezorgDag);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblPostCode);
            this.Name = "FrmBezorging";
            this.Text = "Bezorging";
            this.Load += new System.EventHandler(this.FrmBezorging_Load);
            this.cmnLvBezorging.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tbactieCode;
        private System.Windows.Forms.Button btnInvoeren;
        private System.Windows.Forms.Label lblActieCode;
        private System.Windows.Forms.Label lblBezorgTijd;
        private System.Windows.Forms.Label lblBezorgDag;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblPostCode;
        private System.Windows.Forms.TextBox tbPostCode;
        private System.Windows.Forms.TextBox tbHuisNummer;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtBezorgdag;
        private System.Windows.Forms.TextBox txtBezorgtijd;
        private System.Windows.Forms.ComboBox cbBestelCode;
        private System.Windows.Forms.ListView lvBezorging;
        private System.Windows.Forms.ContextMenuStrip cmnLvBezorging;
        private System.Windows.Forms.ToolStripMenuItem verwijderBezorgingToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem alleBezorgingenVerwijderenToolStripMenuItem;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        private System.Windows.Forms.ColumnHeader columnHeader6;
        private System.Windows.Forms.ColumnHeader columnHeader1;
    }
}