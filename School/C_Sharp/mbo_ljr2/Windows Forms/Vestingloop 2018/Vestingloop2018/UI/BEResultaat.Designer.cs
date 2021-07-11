namespace Vestingloop2018
{
    partial class BEResultaat
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
            this.btnSelectieUitvoer = new System.Windows.Forms.Button();
            this.lbTijd = new System.Windows.Forms.Label();
            this.lbRoute = new System.Windows.Forms.Label();
            this.lbDeelnemer = new System.Windows.Forms.Label();
            this.tbTijd = new System.Windows.Forms.TextBox();
            this.tbDeelnemer = new System.Windows.Forms.TextBox();
            this.lbSelectieResultaat = new System.Windows.Forms.Label();
            this.lvBEResultaat = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader5 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Snelmenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.invoerenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.bewerkenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.verwijderenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tbRang = new System.Windows.Forms.TextBox();
            this.lbRang = new System.Windows.Forms.Label();
            this.RbSelectBEResultaat = new System.Windows.Forms.RadioButton();
            this.RbSelectFEResultaat = new System.Windows.Forms.RadioButton();
            this.lbResultaatID = new System.Windows.Forms.Label();
            this.lblNaamID = new System.Windows.Forms.Label();
            this.cbRoute = new System.Windows.Forms.ComboBox();
            this.Snelmenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnSelectieUitvoer
            // 
            this.btnSelectieUitvoer.Enabled = false;
            this.btnSelectieUitvoer.Location = new System.Drawing.Point(65, 394);
            this.btnSelectieUitvoer.Name = "btnSelectieUitvoer";
            this.btnSelectieUitvoer.Size = new System.Drawing.Size(122, 23);
            this.btnSelectieUitvoer.TabIndex = 17;
            this.btnSelectieUitvoer.Text = "Selectie uitvoeren";
            this.btnSelectieUitvoer.UseVisualStyleBackColor = true;
            this.btnSelectieUitvoer.Click += new System.EventHandler(this.BtnSelectieUitvoer_Click);
            // 
            // lbTijd
            // 
            this.lbTijd.AutoSize = true;
            this.lbTijd.Location = new System.Drawing.Point(459, 333);
            this.lbTijd.Name = "lbTijd";
            this.lbTijd.Size = new System.Drawing.Size(24, 13);
            this.lbTijd.TabIndex = 16;
            this.lbTijd.Text = "Tijd";
            // 
            // lbRoute
            // 
            this.lbRoute.AutoSize = true;
            this.lbRoute.Location = new System.Drawing.Point(317, 333);
            this.lbRoute.Name = "lbRoute";
            this.lbRoute.Size = new System.Drawing.Size(36, 13);
            this.lbRoute.TabIndex = 15;
            this.lbRoute.Text = "Route";
            // 
            // lbDeelnemer
            // 
            this.lbDeelnemer.AutoSize = true;
            this.lbDeelnemer.Location = new System.Drawing.Point(178, 333);
            this.lbDeelnemer.Name = "lbDeelnemer";
            this.lbDeelnemer.Size = new System.Drawing.Size(58, 13);
            this.lbDeelnemer.TabIndex = 14;
            this.lbDeelnemer.Text = "Deelnemer";
            // 
            // tbTijd
            // 
            this.tbTijd.Location = new System.Drawing.Point(459, 347);
            this.tbTijd.Name = "tbTijd";
            this.tbTijd.Size = new System.Drawing.Size(100, 20);
            this.tbTijd.TabIndex = 13;
            // 
            // tbDeelnemer
            // 
            this.tbDeelnemer.Location = new System.Drawing.Point(178, 347);
            this.tbDeelnemer.Name = "tbDeelnemer";
            this.tbDeelnemer.Size = new System.Drawing.Size(100, 20);
            this.tbDeelnemer.TabIndex = 11;
            // 
            // lbSelectieResultaat
            // 
            this.lbSelectieResultaat.AutoSize = true;
            this.lbSelectieResultaat.Location = new System.Drawing.Point(59, 316);
            this.lbSelectieResultaat.Name = "lbSelectieResultaat";
            this.lbSelectieResultaat.Size = new System.Drawing.Size(122, 13);
            this.lbSelectieResultaat.TabIndex = 10;
            this.lbSelectieResultaat.Text = "Geselecteerde resultaat:";
            // 
            // lvBEResultaat
            // 
            this.lvBEResultaat.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4,
            this.columnHeader5});
            this.lvBEResultaat.ContextMenuStrip = this.Snelmenu;
            this.lvBEResultaat.FullRowSelect = true;
            this.lvBEResultaat.GridLines = true;
            this.lvBEResultaat.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.Nonclickable;
            this.lvBEResultaat.Location = new System.Drawing.Point(59, 73);
            this.lvBEResultaat.Name = "lvBEResultaat";
            this.lvBEResultaat.Size = new System.Drawing.Size(682, 236);
            this.lvBEResultaat.TabIndex = 9;
            this.lvBEResultaat.UseCompatibleStateImageBehavior = false;
            this.lvBEResultaat.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "FE_Resultaat_ID";
            this.columnHeader1.Width = 0;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Deelnemer";
            this.columnHeader2.Width = 392;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "Route";
            this.columnHeader3.Width = 103;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "Tijd";
            this.columnHeader4.Width = 113;
            // 
            // columnHeader5
            // 
            this.columnHeader5.Text = "Rang";
            this.columnHeader5.Width = 70;
            // 
            // Snelmenu
            // 
            this.Snelmenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.invoerenToolStripMenuItem,
            this.bewerkenToolStripMenuItem,
            this.verwijderenToolStripMenuItem});
            this.Snelmenu.Name = "Snelmenu";
            this.Snelmenu.Size = new System.Drawing.Size(136, 70);
            this.Snelmenu.Text = "Snelmenu";
            // 
            // invoerenToolStripMenuItem
            // 
            this.invoerenToolStripMenuItem.Name = "invoerenToolStripMenuItem";
            this.invoerenToolStripMenuItem.Size = new System.Drawing.Size(135, 22);
            this.invoerenToolStripMenuItem.Text = "Invoeren";
            this.invoerenToolStripMenuItem.Click += new System.EventHandler(this.InvoerenToolStripMenuItem_Click);
            // 
            // bewerkenToolStripMenuItem
            // 
            this.bewerkenToolStripMenuItem.Name = "bewerkenToolStripMenuItem";
            this.bewerkenToolStripMenuItem.Size = new System.Drawing.Size(135, 22);
            this.bewerkenToolStripMenuItem.Text = "Bewerken";
            this.bewerkenToolStripMenuItem.Click += new System.EventHandler(this.BewerkenToolStripMenuItem_Click);
            // 
            // verwijderenToolStripMenuItem
            // 
            this.verwijderenToolStripMenuItem.Name = "verwijderenToolStripMenuItem";
            this.verwijderenToolStripMenuItem.Size = new System.Drawing.Size(135, 22);
            this.verwijderenToolStripMenuItem.Text = "Verwijderen";
            this.verwijderenToolStripMenuItem.Click += new System.EventHandler(this.VerwijderenToolStripMenuItem_Click);
            // 
            // tbRang
            // 
            this.tbRang.Location = new System.Drawing.Point(606, 347);
            this.tbRang.Name = "tbRang";
            this.tbRang.Size = new System.Drawing.Size(100, 20);
            this.tbRang.TabIndex = 13;
            // 
            // lbRang
            // 
            this.lbRang.AutoSize = true;
            this.lbRang.Location = new System.Drawing.Point(606, 333);
            this.lbRang.Name = "lbRang";
            this.lbRang.Size = new System.Drawing.Size(33, 13);
            this.lbRang.TabIndex = 16;
            this.lbRang.Text = "Rang";
            // 
            // RbSelectBEResultaat
            // 
            this.RbSelectBEResultaat.AutoSize = true;
            this.RbSelectBEResultaat.Location = new System.Drawing.Point(185, 28);
            this.RbSelectBEResultaat.Margin = new System.Windows.Forms.Padding(2);
            this.RbSelectBEResultaat.Name = "RbSelectBEResultaat";
            this.RbSelectBEResultaat.Size = new System.Drawing.Size(116, 17);
            this.RbSelectBEResultaat.TabIndex = 18;
            this.RbSelectBEResultaat.Text = "Selecteer Backend";
            this.RbSelectBEResultaat.UseVisualStyleBackColor = true;
            this.RbSelectBEResultaat.CheckedChanged += new System.EventHandler(this.RbSelectBEResultaat_CheckedChanged);
            // 
            // RbSelectFEResultaat
            // 
            this.RbSelectFEResultaat.AutoSize = true;
            this.RbSelectFEResultaat.Checked = true;
            this.RbSelectFEResultaat.Location = new System.Drawing.Point(55, 28);
            this.RbSelectFEResultaat.Margin = new System.Windows.Forms.Padding(2);
            this.RbSelectFEResultaat.Name = "RbSelectFEResultaat";
            this.RbSelectFEResultaat.Size = new System.Drawing.Size(115, 17);
            this.RbSelectFEResultaat.TabIndex = 19;
            this.RbSelectFEResultaat.TabStop = true;
            this.RbSelectFEResultaat.Text = "Selecteer Frontend";
            this.RbSelectFEResultaat.UseVisualStyleBackColor = true;
            this.RbSelectFEResultaat.CheckedChanged += new System.EventHandler(this.RbSelectFEResultaat_CheckedChanged);
            // 
            // lbResultaatID
            // 
            this.lbResultaatID.AutoSize = true;
            this.lbResultaatID.Location = new System.Drawing.Point(62, 349);
            this.lbResultaatID.Name = "lbResultaatID";
            this.lbResultaatID.Size = new System.Drawing.Size(71, 13);
            this.lbResultaatID.TabIndex = 20;
            this.lbResultaatID.Text = "*ResultaatID*";
            // 
            // lblNaamID
            // 
            this.lblNaamID.AutoSize = true;
            this.lblNaamID.Location = new System.Drawing.Point(62, 333);
            this.lblNaamID.Name = "lblNaamID";
            this.lblNaamID.Size = new System.Drawing.Size(66, 13);
            this.lblNaamID.TabIndex = 20;
            this.lblNaamID.Text = "Resultaat ID";
            // 
            // cbRoute
            // 
            this.cbRoute.FormattingEnabled = true;
            this.cbRoute.Location = new System.Drawing.Point(320, 347);
            this.cbRoute.Name = "cbRoute";
            this.cbRoute.Size = new System.Drawing.Size(103, 21);
            this.cbRoute.TabIndex = 21;
            // 
            // BEResultaat
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.cbRoute);
            this.Controls.Add(this.lblNaamID);
            this.Controls.Add(this.lbResultaatID);
            this.Controls.Add(this.RbSelectBEResultaat);
            this.Controls.Add(this.RbSelectFEResultaat);
            this.Controls.Add(this.btnSelectieUitvoer);
            this.Controls.Add(this.lbRang);
            this.Controls.Add(this.lbTijd);
            this.Controls.Add(this.lbRoute);
            this.Controls.Add(this.lbDeelnemer);
            this.Controls.Add(this.tbRang);
            this.Controls.Add(this.tbTijd);
            this.Controls.Add(this.tbDeelnemer);
            this.Controls.Add(this.lbSelectieResultaat);
            this.Controls.Add(this.lvBEResultaat);
            this.Name = "BEResultaat";
            this.Text = "Backend Resultaat";
            this.Load += new System.EventHandler(this.BEResultaat_Load);
            this.Snelmenu.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btnSelectieUitvoer;
        private System.Windows.Forms.Label lbTijd;
        private System.Windows.Forms.Label lbRoute;
        private System.Windows.Forms.Label lbDeelnemer;
        private System.Windows.Forms.TextBox tbTijd;
        private System.Windows.Forms.TextBox tbDeelnemer;
        private System.Windows.Forms.Label lbSelectieResultaat;
        private System.Windows.Forms.ListView lvBEResultaat;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        private System.Windows.Forms.TextBox tbRang;
        private System.Windows.Forms.Label lbRang;
        private System.Windows.Forms.ContextMenuStrip Snelmenu;
        private System.Windows.Forms.ToolStripMenuItem invoerenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem bewerkenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem verwijderenToolStripMenuItem;
        private System.Windows.Forms.RadioButton RbSelectBEResultaat;
        private System.Windows.Forms.RadioButton RbSelectFEResultaat;
        private System.Windows.Forms.Label lbResultaatID;
        private System.Windows.Forms.Label lblNaamID;
        private System.Windows.Forms.ComboBox cbRoute;
    }
}