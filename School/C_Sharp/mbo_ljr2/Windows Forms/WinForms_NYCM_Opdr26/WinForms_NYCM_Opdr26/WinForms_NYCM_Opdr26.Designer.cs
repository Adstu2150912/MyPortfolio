namespace WinForms_NYCM_Opdr26
{
    partial class WinForms_NYCM_Opdr26
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
            this.menuHoofd = new System.Windows.Forms.MenuStrip();
            this.bestandToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.afsluitenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toevoegenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.deelnemerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.registratieToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripSeparator();
            this.alleVenstersAfsluitenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuHoofd.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuHoofd
            // 
            this.menuHoofd.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuHoofd.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bestandToolStripMenuItem,
            this.toevoegenToolStripMenuItem});
            this.menuHoofd.Location = new System.Drawing.Point(0, 0);
            this.menuHoofd.Name = "menuHoofd";
            this.menuHoofd.Padding = new System.Windows.Forms.Padding(4, 2, 0, 2);
            this.menuHoofd.Size = new System.Drawing.Size(212, 24);
            this.menuHoofd.TabIndex = 1;
            this.menuHoofd.Text = "menuHoofd";
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
            // toevoegenToolStripMenuItem
            // 
            this.toevoegenToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.deelnemerToolStripMenuItem,
            this.registratieToolStripMenuItem,
            this.toolStripMenuItem1,
            this.alleVenstersAfsluitenToolStripMenuItem});
            this.toevoegenToolStripMenuItem.Name = "toevoegenToolStripMenuItem";
            this.toevoegenToolStripMenuItem.Size = new System.Drawing.Size(77, 20);
            this.toevoegenToolStripMenuItem.Text = "Toevoegen";
            // 
            // deelnemerToolStripMenuItem
            // 
            this.deelnemerToolStripMenuItem.Name = "deelnemerToolStripMenuItem";
            this.deelnemerToolStripMenuItem.Size = new System.Drawing.Size(188, 22);
            this.deelnemerToolStripMenuItem.Text = "Deelnemer";
            this.deelnemerToolStripMenuItem.Click += new System.EventHandler(this.deelnemerToolStripMenuItem_Click);
            // 
            // registratieToolStripMenuItem
            // 
            this.registratieToolStripMenuItem.Name = "registratieToolStripMenuItem";
            this.registratieToolStripMenuItem.Size = new System.Drawing.Size(188, 22);
            this.registratieToolStripMenuItem.Text = "Registratie";
            this.registratieToolStripMenuItem.Click += new System.EventHandler(this.registratieToolStripMenuItem_Click);
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(185, 6);
            // 
            // alleVenstersAfsluitenToolStripMenuItem
            // 
            this.alleVenstersAfsluitenToolStripMenuItem.Name = "alleVenstersAfsluitenToolStripMenuItem";
            this.alleVenstersAfsluitenToolStripMenuItem.Size = new System.Drawing.Size(188, 22);
            this.alleVenstersAfsluitenToolStripMenuItem.Text = "Alle vensters afsluiten";
            this.alleVenstersAfsluitenToolStripMenuItem.Click += new System.EventHandler(this.alleVenstersAfsluitenToolStripMenuItem_Click);
            // 
            // WinForms_NYCM_Opdr26
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(212, 206);
            this.Controls.Add(this.menuHoofd);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuHoofd;
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "WinForms_NYCM_Opdr26";
            this.Text = "New York City Marathon";
            this.menuHoofd.ResumeLayout(false);
            this.menuHoofd.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuHoofd;
        private System.Windows.Forms.ToolStripMenuItem bestandToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem afsluitenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem toevoegenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem deelnemerToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem registratieToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem alleVenstersAfsluitenToolStripMenuItem;
    }
}

