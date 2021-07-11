namespace Vestingloop2018
{
    partial class BEDeelname
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
            this.lvBEDeelname = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Snelmenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.InvoerenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.BewerkenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.verwijderenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lbSelectieDeelname = new System.Windows.Forms.Label();
            this.tbDeelnemer = new System.Windows.Forms.TextBox();
            this.tbAfkomst = new System.Windows.Forms.TextBox();
            this.tbLeeftijd = new System.Windows.Forms.TextBox();
            this.lbDeelnemer = new System.Windows.Forms.Label();
            this.lbAfkomst = new System.Windows.Forms.Label();
            this.lbLeeftijd = new System.Windows.Forms.Label();
            this.btnSelectieUitvoer = new System.Windows.Forms.Button();
            this.RbSelectFEDeelname = new System.Windows.Forms.RadioButton();
            this.RbSelectBEDeelname = new System.Windows.Forms.RadioButton();
            this.lbDeelnameID = new System.Windows.Forms.Label();
            this.lblNaam = new System.Windows.Forms.Label();
            this.Snelmenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // lvBEDeelname
            // 
            this.lvBEDeelname.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4});
            this.lvBEDeelname.ContextMenuStrip = this.Snelmenu;
            this.lvBEDeelname.FullRowSelect = true;
            this.lvBEDeelname.GridLines = true;
            this.lvBEDeelname.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.Nonclickable;
            this.lvBEDeelname.Location = new System.Drawing.Point(52, 68);
            this.lvBEDeelname.Name = "lvBEDeelname";
            this.lvBEDeelname.Size = new System.Drawing.Size(682, 231);
            this.lvBEDeelname.TabIndex = 0;
            this.lvBEDeelname.UseCompatibleStateImageBehavior = false;
            this.lvBEDeelname.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "BE_Deelname_ID";
            this.columnHeader1.Width = 0;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Deelnemer";
            this.columnHeader2.Width = 270;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "Afkomst";
            this.columnHeader3.Width = 333;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "Leeftijd";
            this.columnHeader4.Width = 75;
            // 
            // Snelmenu
            // 
            this.Snelmenu.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.Snelmenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.InvoerenToolStripMenuItem,
            this.BewerkenToolStripMenuItem,
            this.verwijderenToolStripMenuItem});
            this.Snelmenu.Name = "Snelmenu";
            this.Snelmenu.Size = new System.Drawing.Size(136, 70);
            this.Snelmenu.Text = "Snelmenu";
            // 
            // InvoerenToolStripMenuItem
            // 
            this.InvoerenToolStripMenuItem.Name = "InvoerenToolStripMenuItem";
            this.InvoerenToolStripMenuItem.Size = new System.Drawing.Size(135, 22);
            this.InvoerenToolStripMenuItem.Text = "Invoeren";
            this.InvoerenToolStripMenuItem.Click += new System.EventHandler(this.InvoerenToolStripMenuItem_Click);
            // 
            // BewerkenToolStripMenuItem
            // 
            this.BewerkenToolStripMenuItem.Name = "BewerkenToolStripMenuItem";
            this.BewerkenToolStripMenuItem.Size = new System.Drawing.Size(135, 22);
            this.BewerkenToolStripMenuItem.Text = "Bewerken";
            this.BewerkenToolStripMenuItem.Click += new System.EventHandler(this.BewerkenToolStripMenuItem_Click);
            // 
            // verwijderenToolStripMenuItem
            // 
            this.verwijderenToolStripMenuItem.Name = "verwijderenToolStripMenuItem";
            this.verwijderenToolStripMenuItem.Size = new System.Drawing.Size(135, 22);
            this.verwijderenToolStripMenuItem.Text = "Verwijderen";
            this.verwijderenToolStripMenuItem.Click += new System.EventHandler(this.VerwijderenToolStripMenuItem_Click);
            // 
            // lbSelectieDeelname
            // 
            this.lbSelectieDeelname.AutoSize = true;
            this.lbSelectieDeelname.Location = new System.Drawing.Point(52, 306);
            this.lbSelectieDeelname.Name = "lbSelectieDeelname";
            this.lbSelectieDeelname.Size = new System.Drawing.Size(128, 13);
            this.lbSelectieDeelname.TabIndex = 1;
            this.lbSelectieDeelname.Text = "Geselecteerde deelname:";
            // 
            // tbDeelnemer
            // 
            this.tbDeelnemer.Location = new System.Drawing.Point(195, 341);
            this.tbDeelnemer.Name = "tbDeelnemer";
            this.tbDeelnemer.Size = new System.Drawing.Size(100, 20);
            this.tbDeelnemer.TabIndex = 2;
            // 
            // tbAfkomst
            // 
            this.tbAfkomst.Location = new System.Drawing.Point(334, 340);
            this.tbAfkomst.Name = "tbAfkomst";
            this.tbAfkomst.Size = new System.Drawing.Size(100, 20);
            this.tbAfkomst.TabIndex = 3;
            // 
            // tbLeeftijd
            // 
            this.tbLeeftijd.Location = new System.Drawing.Point(476, 341);
            this.tbLeeftijd.Name = "tbLeeftijd";
            this.tbLeeftijd.Size = new System.Drawing.Size(100, 20);
            this.tbLeeftijd.TabIndex = 4;
            // 
            // lbDeelnemer
            // 
            this.lbDeelnemer.AutoSize = true;
            this.lbDeelnemer.Location = new System.Drawing.Point(195, 327);
            this.lbDeelnemer.Name = "lbDeelnemer";
            this.lbDeelnemer.Size = new System.Drawing.Size(58, 13);
            this.lbDeelnemer.TabIndex = 5;
            this.lbDeelnemer.Text = "Deelnemer";
            // 
            // lbAfkomst
            // 
            this.lbAfkomst.AutoSize = true;
            this.lbAfkomst.Location = new System.Drawing.Point(334, 327);
            this.lbAfkomst.Name = "lbAfkomst";
            this.lbAfkomst.Size = new System.Drawing.Size(45, 13);
            this.lbAfkomst.TabIndex = 6;
            this.lbAfkomst.Text = "Afkomst";
            // 
            // lbLeeftijd
            // 
            this.lbLeeftijd.AutoSize = true;
            this.lbLeeftijd.Location = new System.Drawing.Point(476, 327);
            this.lbLeeftijd.Name = "lbLeeftijd";
            this.lbLeeftijd.Size = new System.Drawing.Size(41, 13);
            this.lbLeeftijd.TabIndex = 7;
            this.lbLeeftijd.Text = "Leeftijd";
            // 
            // btnSelectieUitvoer
            // 
            this.btnSelectieUitvoer.Enabled = false;
            this.btnSelectieUitvoer.Location = new System.Drawing.Point(58, 384);
            this.btnSelectieUitvoer.Name = "btnSelectieUitvoer";
            this.btnSelectieUitvoer.Size = new System.Drawing.Size(122, 23);
            this.btnSelectieUitvoer.TabIndex = 8;
            this.btnSelectieUitvoer.Text = "Selectie uitvoeren";
            this.btnSelectieUitvoer.UseVisualStyleBackColor = true;
            this.btnSelectieUitvoer.Click += new System.EventHandler(this.BtnSelectieUitvoer_Click);
            // 
            // RbSelectFEDeelname
            // 
            this.RbSelectFEDeelname.AutoSize = true;
            this.RbSelectFEDeelname.Checked = true;
            this.RbSelectFEDeelname.Location = new System.Drawing.Point(52, 20);
            this.RbSelectFEDeelname.Margin = new System.Windows.Forms.Padding(2);
            this.RbSelectFEDeelname.Name = "RbSelectFEDeelname";
            this.RbSelectFEDeelname.Size = new System.Drawing.Size(112, 17);
            this.RbSelectFEDeelname.TabIndex = 9;
            this.RbSelectFEDeelname.TabStop = true;
            this.RbSelectFEDeelname.Text = "Selecteer frontend";
            this.RbSelectFEDeelname.UseVisualStyleBackColor = true;
            this.RbSelectFEDeelname.CheckedChanged += new System.EventHandler(this.RbSelectFEDeelname_CheckedChanged);
            // 
            // RbSelectBEDeelname
            // 
            this.RbSelectBEDeelname.AutoSize = true;
            this.RbSelectBEDeelname.Location = new System.Drawing.Point(182, 20);
            this.RbSelectBEDeelname.Margin = new System.Windows.Forms.Padding(2);
            this.RbSelectBEDeelname.Name = "RbSelectBEDeelname";
            this.RbSelectBEDeelname.Size = new System.Drawing.Size(116, 17);
            this.RbSelectBEDeelname.TabIndex = 9;
            this.RbSelectBEDeelname.Text = "Selecteer Backend";
            this.RbSelectBEDeelname.UseVisualStyleBackColor = true;
            this.RbSelectBEDeelname.CheckedChanged += new System.EventHandler(this.RbSelectBEDeelname_CheckedChanged);
            // 
            // lbDeelnameID
            // 
            this.lbDeelnameID.AutoSize = true;
            this.lbDeelnameID.Location = new System.Drawing.Point(57, 348);
            this.lbDeelnameID.Name = "lbDeelnameID";
            this.lbDeelnameID.Size = new System.Drawing.Size(74, 13);
            this.lbDeelnameID.TabIndex = 10;
            this.lbDeelnameID.Text = "*DeelnameID*";
            // 
            // lblNaam
            // 
            this.lblNaam.AutoSize = true;
            this.lblNaam.Location = new System.Drawing.Point(57, 327);
            this.lblNaam.Name = "lblNaam";
            this.lblNaam.Size = new System.Drawing.Size(69, 13);
            this.lblNaam.TabIndex = 10;
            this.lblNaam.Text = "Deelname ID";
            // 
            // BEDeelname
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.ContextMenuStrip = this.Snelmenu;
            this.Controls.Add(this.lblNaam);
            this.Controls.Add(this.lbDeelnameID);
            this.Controls.Add(this.RbSelectBEDeelname);
            this.Controls.Add(this.RbSelectFEDeelname);
            this.Controls.Add(this.btnSelectieUitvoer);
            this.Controls.Add(this.lbLeeftijd);
            this.Controls.Add(this.lbAfkomst);
            this.Controls.Add(this.lbDeelnemer);
            this.Controls.Add(this.tbLeeftijd);
            this.Controls.Add(this.tbAfkomst);
            this.Controls.Add(this.tbDeelnemer);
            this.Controls.Add(this.lbSelectieDeelname);
            this.Controls.Add(this.lvBEDeelname);
            this.Name = "BEDeelname";
            this.Text = "Backend Deelname";
            this.Load += new System.EventHandler(this.BEDeelname_Load);
            this.Snelmenu.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListView lvBEDeelname;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.Label lbSelectieDeelname;
        private System.Windows.Forms.TextBox tbDeelnemer;
        private System.Windows.Forms.TextBox tbAfkomst;
        private System.Windows.Forms.TextBox tbLeeftijd;
        private System.Windows.Forms.Label lbDeelnemer;
        private System.Windows.Forms.Label lbAfkomst;
        private System.Windows.Forms.Label lbLeeftijd;
        private System.Windows.Forms.Button btnSelectieUitvoer;
        private System.Windows.Forms.ContextMenuStrip Snelmenu;
        private System.Windows.Forms.ToolStripMenuItem InvoerenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem BewerkenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem verwijderenToolStripMenuItem;
        private System.Windows.Forms.RadioButton RbSelectFEDeelname;
        private System.Windows.Forms.RadioButton RbSelectBEDeelname;
        private System.Windows.Forms.Label lbDeelnameID;
        private System.Windows.Forms.Label lblNaam;
    }
}