namespace Dominos_Pizza
{
    partial class WinForms_Dominos_Opdr25
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
            this.pizzanaamToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.bestellingToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.bezorgingToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripSeparator();
            this.AlleVenstersSluitenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuHoofd.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuHoofd
            // 
            this.menuHoofd.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bestandToolStripMenuItem,
            this.toevoegenToolStripMenuItem});
            this.menuHoofd.Location = new System.Drawing.Point(0, 0);
            this.menuHoofd.Name = "menuHoofd";
            this.menuHoofd.Size = new System.Drawing.Size(800, 24);
            this.menuHoofd.TabIndex = 0;
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
            this.afsluitenToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.afsluitenToolStripMenuItem.Text = "Afsluiten";
            this.afsluitenToolStripMenuItem.Click += new System.EventHandler(this.afsluitenToolStripMenuItem_Click);
            // 
            // toevoegenToolStripMenuItem
            // 
            this.toevoegenToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.pizzanaamToolStripMenuItem,
            this.bestellingToolStripMenuItem,
            this.bezorgingToolStripMenuItem,
            this.toolStripMenuItem1,
            this.AlleVenstersSluitenToolStripMenuItem});
            this.toevoegenToolStripMenuItem.Name = "toevoegenToolStripMenuItem";
            this.toevoegenToolStripMenuItem.Size = new System.Drawing.Size(77, 20);
            this.toevoegenToolStripMenuItem.Text = "Toevoegen";
            // 
            // pizzanaamToolStripMenuItem
            // 
            this.pizzanaamToolStripMenuItem.Name = "pizzanaamToolStripMenuItem";
            this.pizzanaamToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.pizzanaamToolStripMenuItem.Text = "Pizza";
            this.pizzanaamToolStripMenuItem.Click += new System.EventHandler(this.pizzanaamToolStripMenuItem_Click);
            // 
            // bestellingToolStripMenuItem
            // 
            this.bestellingToolStripMenuItem.Name = "bestellingToolStripMenuItem";
            this.bestellingToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.bestellingToolStripMenuItem.Text = "Bestelling";
            this.bestellingToolStripMenuItem.Click += new System.EventHandler(this.bestellingToolStripMenuItem_Click);
            // 
            // bezorgingToolStripMenuItem
            // 
            this.bezorgingToolStripMenuItem.Name = "bezorgingToolStripMenuItem";
            this.bezorgingToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.bezorgingToolStripMenuItem.Text = "Bezorging";
            this.bezorgingToolStripMenuItem.Click += new System.EventHandler(this.bezorgingToolStripMenuItem_Click);
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(177, 6);
            // 
            // AlleVenstersSluitenToolStripMenuItem
            // 
            this.AlleVenstersSluitenToolStripMenuItem.Name = "AlleVenstersSluitenToolStripMenuItem";
            this.AlleVenstersSluitenToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.AlleVenstersSluitenToolStripMenuItem.Text = "Alle vensters sluiten";
            this.AlleVenstersSluitenToolStripMenuItem.Click += new System.EventHandler(this.alleVenstersSluitenToolStripMenuItem_Click);
            // 
            // WinForms_Dominos_Opdr25
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.menuHoofd);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuHoofd;
            this.Name = "WinForms_Dominos_Opdr25";
            this.Text = "Domino\'s Pizza";
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
        private System.Windows.Forms.ToolStripMenuItem pizzanaamToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem bestellingToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem bezorgingToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem AlleVenstersSluitenToolStripMenuItem;
    }
}