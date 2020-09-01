namespace Vestingloop2018
{
    partial class Hoofdvenster
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
            this.Hoofdmenu = new System.Windows.Forms.MenuStrip();
            this.BestandToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.AfsluitenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.frontendToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.FEDeelnameToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.FEResultaatToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.AlleFrontendVenstersAfsluitenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.backendToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.BEDeelnameToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.BEResultaatToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.AlleBackendVenstersAfsluitenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.Snelmenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.alleSubvenstersAfsluitenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.Hoofdmenu.SuspendLayout();
            this.Snelmenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // Hoofdmenu
            // 
            this.Hoofdmenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.BestandToolStripMenuItem,
            this.frontendToolStripMenuItem,
            this.backendToolStripMenuItem});
            this.Hoofdmenu.Location = new System.Drawing.Point(0, 0);
            this.Hoofdmenu.Name = "Hoofdmenu";
            this.Hoofdmenu.Size = new System.Drawing.Size(800, 24);
            this.Hoofdmenu.TabIndex = 0;
            this.Hoofdmenu.Text = "menuStrip1";
            // 
            // BestandToolStripMenuItem
            // 
            this.BestandToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.AfsluitenToolStripMenuItem});
            this.BestandToolStripMenuItem.Name = "BestandToolStripMenuItem";
            this.BestandToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.BestandToolStripMenuItem.Text = "Bestand";
            // 
            // AfsluitenToolStripMenuItem
            // 
            this.AfsluitenToolStripMenuItem.Name = "AfsluitenToolStripMenuItem";
            this.AfsluitenToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.AfsluitenToolStripMenuItem.Text = "Afsluiten";
            this.AfsluitenToolStripMenuItem.Click += new System.EventHandler(this.AfsluitenToolStripMenuItem_Click);
            // 
            // frontendToolStripMenuItem
            // 
            this.frontendToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.FEDeelnameToolStripMenuItem,
            this.FEResultaatToolStripMenuItem,
            this.AlleFrontendVenstersAfsluitenToolStripMenuItem});
            this.frontendToolStripMenuItem.Name = "frontendToolStripMenuItem";
            this.frontendToolStripMenuItem.Size = new System.Drawing.Size(67, 20);
            this.frontendToolStripMenuItem.Text = "Frontend";
            // 
            // FEDeelnameToolStripMenuItem
            // 
            this.FEDeelnameToolStripMenuItem.Name = "FEDeelnameToolStripMenuItem";
            this.FEDeelnameToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.FEDeelnameToolStripMenuItem.Text = "Deelname";
            this.FEDeelnameToolStripMenuItem.Click += new System.EventHandler(this.FEDeelnameToolStripMenuItem_Click);
            // 
            // FEResultaatToolStripMenuItem
            // 
            this.FEResultaatToolStripMenuItem.Name = "FEResultaatToolStripMenuItem";
            this.FEResultaatToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.FEResultaatToolStripMenuItem.Text = "Resultaat";
            this.FEResultaatToolStripMenuItem.Click += new System.EventHandler(this.FEResultaatToolStripMenuItem_Click);
            // 
            // AlleFrontendVenstersAfsluitenToolStripMenuItem
            // 
            this.AlleFrontendVenstersAfsluitenToolStripMenuItem.Name = "AlleFrontendVenstersAfsluitenToolStripMenuItem";
            this.AlleFrontendVenstersAfsluitenToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.AlleFrontendVenstersAfsluitenToolStripMenuItem.Text = "Alle subvensters afsluiten";
            this.AlleFrontendVenstersAfsluitenToolStripMenuItem.Click += new System.EventHandler(this.AlleFrontendVenstersAfsluitenToolStripMenuItem_Click);
            // 
            // backendToolStripMenuItem
            // 
            this.backendToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.BEDeelnameToolStripMenuItem,
            this.BEResultaatToolStripMenuItem,
            this.AlleBackendVenstersAfsluitenToolStripMenuItem});
            this.backendToolStripMenuItem.Name = "backendToolStripMenuItem";
            this.backendToolStripMenuItem.Size = new System.Drawing.Size(64, 20);
            this.backendToolStripMenuItem.Text = "Backend";
            // 
            // BEDeelnameToolStripMenuItem
            // 
            this.BEDeelnameToolStripMenuItem.Name = "BEDeelnameToolStripMenuItem";
            this.BEDeelnameToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.BEDeelnameToolStripMenuItem.Text = "Deelname";
            this.BEDeelnameToolStripMenuItem.Click += new System.EventHandler(this.BEDeelnameToolStripMenuItem_Click);
            // 
            // BEResultaatToolStripMenuItem
            // 
            this.BEResultaatToolStripMenuItem.Name = "BEResultaatToolStripMenuItem";
            this.BEResultaatToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.BEResultaatToolStripMenuItem.Text = "Resultaat";
            this.BEResultaatToolStripMenuItem.Click += new System.EventHandler(this.BEResultaatToolStripMenuItem_Click);
            // 
            // AlleBackendVenstersAfsluitenToolStripMenuItem
            // 
            this.AlleBackendVenstersAfsluitenToolStripMenuItem.Name = "AlleBackendVenstersAfsluitenToolStripMenuItem";
            this.AlleBackendVenstersAfsluitenToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.AlleBackendVenstersAfsluitenToolStripMenuItem.Text = "Alle subvensters afsluiten";
            this.AlleBackendVenstersAfsluitenToolStripMenuItem.Click += new System.EventHandler(this.AlleBackendVenstersAfsluitenToolStripMenuItem_Click);
            // 
            // Snelmenu
            // 
            this.Snelmenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.alleSubvenstersAfsluitenToolStripMenuItem});
            this.Snelmenu.Name = "Snelmenu";
            this.Snelmenu.Size = new System.Drawing.Size(208, 26);
            this.Snelmenu.Text = "Snelmenu";
            // 
            // alleSubvenstersAfsluitenToolStripMenuItem
            // 
            this.alleSubvenstersAfsluitenToolStripMenuItem.Name = "alleSubvenstersAfsluitenToolStripMenuItem";
            this.alleSubvenstersAfsluitenToolStripMenuItem.Size = new System.Drawing.Size(207, 22);
            this.alleSubvenstersAfsluitenToolStripMenuItem.Text = "Alle subvensters afsluiten";
            // 
            // Hoofdvenster
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.ContextMenuStrip = this.Snelmenu;
            this.Controls.Add(this.Hoofdmenu);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.Hoofdmenu;
            this.Name = "Hoofdvenster";
            this.Text = "Vestingloop 2018";
            this.Hoofdmenu.ResumeLayout(false);
            this.Hoofdmenu.PerformLayout();
            this.Snelmenu.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip Hoofdmenu;
        private System.Windows.Forms.ToolStripMenuItem BestandToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem AfsluitenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem frontendToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem FEDeelnameToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem FEResultaatToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem AlleFrontendVenstersAfsluitenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem backendToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem BEDeelnameToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem BEResultaatToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem AlleBackendVenstersAfsluitenToolStripMenuItem;
        private System.Windows.Forms.ContextMenuStrip Snelmenu;
        private System.Windows.Forms.ToolStripMenuItem alleSubvenstersAfsluitenToolStripMenuItem;
    }
}

