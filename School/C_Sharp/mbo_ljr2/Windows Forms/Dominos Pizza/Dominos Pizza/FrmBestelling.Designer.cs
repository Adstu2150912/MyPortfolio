namespace Dominos_Pizza
{
    partial class FrmBestelling
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
            this.btnInvoeren = new System.Windows.Forms.Button();
            this.lblBestelCode = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lblPizzaGrootteType = new System.Windows.Forms.Label();
            this.lblPizzaBodemType = new System.Windows.Forms.Label();
            this.cbPizzaGrootteType = new System.Windows.Forms.ComboBox();
            this.cbPizzaBodemType = new System.Windows.Forms.ComboBox();
            this.lblAantal = new System.Windows.Forms.Label();
            this.tbAantal = new System.Windows.Forms.TextBox();
            this.cbPizzaNm = new System.Windows.Forms.ComboBox();
            this.txtBestelCode = new System.Windows.Forms.TextBox();
            this.cmnLvBestelling = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.verwijderBestellingToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.alleBestellingenVerwijderenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader5 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.lvBestelling = new System.Windows.Forms.ListView();
            this.cmnLvBestelling.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnInvoeren
            // 
            this.btnInvoeren.Location = new System.Drawing.Point(24, 89);
            this.btnInvoeren.Margin = new System.Windows.Forms.Padding(2);
            this.btnInvoeren.Name = "btnInvoeren";
            this.btnInvoeren.Size = new System.Drawing.Size(170, 24);
            this.btnInvoeren.TabIndex = 8;
            this.btnInvoeren.Text = "Bestelling Invoeren";
            this.btnInvoeren.UseVisualStyleBackColor = true;
            this.btnInvoeren.Click += new System.EventHandler(this.btnBevestigen_Click);
            // 
            // lblBestelCode
            // 
            this.lblBestelCode.AutoSize = true;
            this.lblBestelCode.Location = new System.Drawing.Point(22, 28);
            this.lblBestelCode.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblBestelCode.Name = "lblBestelCode";
            this.lblBestelCode.Size = new System.Drawing.Size(60, 13);
            this.lblBestelCode.TabIndex = 7;
            this.lblBestelCode.Text = "Bestelcode";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(122, 28);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(58, 13);
            this.label1.TabIndex = 7;
            this.label1.Text = "Pizzanaam";
            // 
            // lblPizzaGrootteType
            // 
            this.lblPizzaGrootteType.AutoSize = true;
            this.lblPizzaGrootteType.Location = new System.Drawing.Point(214, 28);
            this.lblPizzaGrootteType.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblPizzaGrootteType.Name = "lblPizzaGrootteType";
            this.lblPizzaGrootteType.Size = new System.Drawing.Size(91, 13);
            this.lblPizzaGrootteType.TabIndex = 7;
            this.lblPizzaGrootteType.Text = "Pizza grootte type";
            // 
            // lblPizzaBodemType
            // 
            this.lblPizzaBodemType.AutoSize = true;
            this.lblPizzaBodemType.Location = new System.Drawing.Point(321, 28);
            this.lblPizzaBodemType.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblPizzaBodemType.Name = "lblPizzaBodemType";
            this.lblPizzaBodemType.Size = new System.Drawing.Size(90, 13);
            this.lblPizzaBodemType.TabIndex = 7;
            this.lblPizzaBodemType.Text = "Pizza bodem type";
            // 
            // cbPizzaGrootteType
            // 
            this.cbPizzaGrootteType.FormattingEnabled = true;
            this.cbPizzaGrootteType.Location = new System.Drawing.Point(216, 52);
            this.cbPizzaGrootteType.Name = "cbPizzaGrootteType";
            this.cbPizzaGrootteType.Size = new System.Drawing.Size(90, 21);
            this.cbPizzaGrootteType.TabIndex = 9;
            // 
            // cbPizzaBodemType
            // 
            this.cbPizzaBodemType.FormattingEnabled = true;
            this.cbPizzaBodemType.Location = new System.Drawing.Point(323, 52);
            this.cbPizzaBodemType.Name = "cbPizzaBodemType";
            this.cbPizzaBodemType.Size = new System.Drawing.Size(106, 21);
            this.cbPizzaBodemType.TabIndex = 9;
            // 
            // lblAantal
            // 
            this.lblAantal.AutoSize = true;
            this.lblAantal.Location = new System.Drawing.Point(455, 28);
            this.lblAantal.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblAantal.Name = "lblAantal";
            this.lblAantal.Size = new System.Drawing.Size(37, 13);
            this.lblAantal.TabIndex = 7;
            this.lblAantal.Text = "Aantal";
            // 
            // tbAantal
            // 
            this.tbAantal.Location = new System.Drawing.Point(458, 54);
            this.tbAantal.Name = "tbAantal";
            this.tbAantal.Size = new System.Drawing.Size(100, 20);
            this.tbAantal.TabIndex = 10;
            // 
            // cbPizzaNm
            // 
            this.cbPizzaNm.FormattingEnabled = true;
            this.cbPizzaNm.Location = new System.Drawing.Point(124, 52);
            this.cbPizzaNm.Name = "cbPizzaNm";
            this.cbPizzaNm.Size = new System.Drawing.Size(72, 21);
            this.cbPizzaNm.TabIndex = 16;
            // 
            // txtBestelCode
            // 
            this.txtBestelCode.Location = new System.Drawing.Point(24, 52);
            this.txtBestelCode.Name = "txtBestelCode";
            this.txtBestelCode.Size = new System.Drawing.Size(82, 20);
            this.txtBestelCode.TabIndex = 10;
            // 
            // cmnLvBestelling
            // 
            this.cmnLvBestelling.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.verwijderBestellingToolStripMenuItem,
            this.alleBestellingenVerwijderenToolStripMenuItem});
            this.cmnLvBestelling.Name = "cmnLvBestelling";
            this.cmnLvBestelling.Size = new System.Drawing.Size(226, 48);
            // 
            // verwijderBestellingToolStripMenuItem
            // 
            this.verwijderBestellingToolStripMenuItem.Name = "verwijderBestellingToolStripMenuItem";
            this.verwijderBestellingToolStripMenuItem.Size = new System.Drawing.Size(225, 22);
            this.verwijderBestellingToolStripMenuItem.Text = "Verwijder bestelling";
            this.verwijderBestellingToolStripMenuItem.Click += new System.EventHandler(this.verwijderBestellingToolStripMenuItem_Click);
            // 
            // alleBestellingenVerwijderenToolStripMenuItem
            // 
            this.alleBestellingenVerwijderenToolStripMenuItem.Name = "alleBestellingenVerwijderenToolStripMenuItem";
            this.alleBestellingenVerwijderenToolStripMenuItem.Size = new System.Drawing.Size(225, 22);
            this.alleBestellingenVerwijderenToolStripMenuItem.Text = "Alle bestellingen verwijderen";
            this.alleBestellingenVerwijderenToolStripMenuItem.Click += new System.EventHandler(this.alleBestellingenVerwijderenToolStripMenuItem_Click);
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "";
            this.columnHeader1.Width = 0;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "";
            this.columnHeader2.Width = 100;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "";
            this.columnHeader3.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.columnHeader3.Width = 130;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "";
            this.columnHeader4.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.columnHeader4.Width = 100;
            // 
            // columnHeader5
            // 
            this.columnHeader5.Text = "";
            this.columnHeader5.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.columnHeader5.Width = 100;
            // 
            // lvBestelling
            // 
            this.lvBestelling.Activation = System.Windows.Forms.ItemActivation.OneClick;
            this.lvBestelling.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4,
            this.columnHeader5});
            this.lvBestelling.ContextMenuStrip = this.cmnLvBestelling;
            this.lvBestelling.FullRowSelect = true;
            this.lvBestelling.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
            this.lvBestelling.Location = new System.Drawing.Point(24, 136);
            this.lvBestelling.Margin = new System.Windows.Forms.Padding(2);
            this.lvBestelling.MultiSelect = false;
            this.lvBestelling.Name = "lvBestelling";
            this.lvBestelling.Size = new System.Drawing.Size(534, 106);
            this.lvBestelling.TabIndex = 17;
            this.lvBestelling.UseCompatibleStateImageBehavior = false;
            this.lvBestelling.View = System.Windows.Forms.View.Details;
            // 
            // FrmBestelling
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(584, 266);
            this.Controls.Add(this.lvBestelling);
            this.Controls.Add(this.cbPizzaNm);
            this.Controls.Add(this.txtBestelCode);
            this.Controls.Add(this.tbAantal);
            this.Controls.Add(this.cbPizzaBodemType);
            this.Controls.Add(this.cbPizzaGrootteType);
            this.Controls.Add(this.btnInvoeren);
            this.Controls.Add(this.lblAantal);
            this.Controls.Add(this.lblPizzaBodemType);
            this.Controls.Add(this.lblPizzaGrootteType);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblBestelCode);
            this.Name = "FrmBestelling";
            this.Text = "Bestelling";
            this.Load += new System.EventHandler(this.FrmBestelling_Load);
            this.cmnLvBestelling.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btnInvoeren;
        private System.Windows.Forms.Label lblBestelCode;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblPizzaGrootteType;
        private System.Windows.Forms.Label lblPizzaBodemType;
        private System.Windows.Forms.ComboBox cbPizzaGrootteType;
        private System.Windows.Forms.ComboBox cbPizzaBodemType;
        private System.Windows.Forms.Label lblAantal;
        private System.Windows.Forms.TextBox tbAantal;
        private System.Windows.Forms.ComboBox cbPizzaNm;
        private System.Windows.Forms.TextBox txtBestelCode;
        private System.Windows.Forms.ContextMenuStrip cmnLvBestelling;
        private System.Windows.Forms.ToolStripMenuItem verwijderBestellingToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem alleBestellingenVerwijderenToolStripMenuItem;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        private System.Windows.Forms.ListView lvBestelling;
    }
}