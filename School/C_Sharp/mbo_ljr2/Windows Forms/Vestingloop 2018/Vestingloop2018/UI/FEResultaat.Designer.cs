namespace Vestingloop2018
{
    partial class FEResultaat
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
            this.lvFEResultaat = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader5 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Snelmenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.SelecterenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.GroeperenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.SorterenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lblSelectieWeergave = new System.Windows.Forms.Label();
            this.clbFilterResultaat = new System.Windows.Forms.CheckedListBox();
            this.lbFilter = new System.Windows.Forms.Label();
            this.Snelmenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // lvFEResultaat
            // 
            this.lvFEResultaat.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4,
            this.columnHeader5});
            this.lvFEResultaat.ContextMenuStrip = this.Snelmenu;
            this.lvFEResultaat.FullRowSelect = true;
            this.lvFEResultaat.GridLines = true;
            this.lvFEResultaat.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.Nonclickable;
            this.lvFEResultaat.Location = new System.Drawing.Point(57, 97);
            this.lvFEResultaat.Name = "lvFEResultaat";
            this.lvFEResultaat.Size = new System.Drawing.Size(521, 266);
            this.lvFEResultaat.TabIndex = 0;
            this.lvFEResultaat.UseCompatibleStateImageBehavior = false;
            this.lvFEResultaat.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "FE_Resultaat_ID";
            this.columnHeader1.Width = 0;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Deelnemer";
            this.columnHeader2.Width = 240;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "Route";
            this.columnHeader3.Width = 73;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "Tijd";
            this.columnHeader4.Width = 124;
            // 
            // columnHeader5
            // 
            this.columnHeader5.Text = "Rang";
            this.columnHeader5.Width = 80;
            // 
            // Snelmenu
            // 
            this.Snelmenu.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.Snelmenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.SelecterenToolStripMenuItem,
            this.GroeperenToolStripMenuItem,
            this.SorterenToolStripMenuItem});
            this.Snelmenu.Name = "Snelmenu";
            this.Snelmenu.Size = new System.Drawing.Size(130, 70);
            this.Snelmenu.Text = "Snelmenu";
            // 
            // SelecterenToolStripMenuItem
            // 
            this.SelecterenToolStripMenuItem.Name = "SelecterenToolStripMenuItem";
            this.SelecterenToolStripMenuItem.Size = new System.Drawing.Size(129, 22);
            this.SelecterenToolStripMenuItem.Text = "Selecteren";
            this.SelecterenToolStripMenuItem.Click += new System.EventHandler(this.SelecterenToolStripMenuItem_Click);
            // 
            // GroeperenToolStripMenuItem
            // 
            this.GroeperenToolStripMenuItem.Name = "GroeperenToolStripMenuItem";
            this.GroeperenToolStripMenuItem.Size = new System.Drawing.Size(129, 22);
            this.GroeperenToolStripMenuItem.Text = "Groeperen";
            this.GroeperenToolStripMenuItem.Click += new System.EventHandler(this.GroeperenToolStripMenuItem_Click);
            // 
            // SorterenToolStripMenuItem
            // 
            this.SorterenToolStripMenuItem.Name = "SorterenToolStripMenuItem";
            this.SorterenToolStripMenuItem.Size = new System.Drawing.Size(129, 22);
            this.SorterenToolStripMenuItem.Text = "Sorteren";
            this.SorterenToolStripMenuItem.Click += new System.EventHandler(this.SorterenToolStripMenuItem_Click);
            // 
            // lblSelectieWeergave
            // 
            this.lblSelectieWeergave.AutoSize = true;
            this.lblSelectieWeergave.Location = new System.Drawing.Point(59, 381);
            this.lblSelectieWeergave.Name = "lblSelectieWeergave";
            this.lblSelectieWeergave.Size = new System.Drawing.Size(138, 13);
            this.lblSelectieWeergave.TabIndex = 2;
            this.lblSelectieWeergave.Text = "*Visuele weergave selectie*";
            this.lblSelectieWeergave.Visible = false;
            // 
            // clbFilterResultaat
            // 
            this.clbFilterResultaat.FormattingEnabled = true;
            this.clbFilterResultaat.Items.AddRange(new object[] {
            "Deelnemer",
            "Route",
            "Tijd",
            "Rang"});
            this.clbFilterResultaat.Location = new System.Drawing.Point(106, 19);
            this.clbFilterResultaat.Margin = new System.Windows.Forms.Padding(2);
            this.clbFilterResultaat.Name = "clbFilterResultaat";
            this.clbFilterResultaat.Size = new System.Drawing.Size(91, 64);
            this.clbFilterResultaat.TabIndex = 7;
            this.clbFilterResultaat.ItemCheck += new System.Windows.Forms.ItemCheckEventHandler(this.ClbFilterResultaat_ItemCheck);
            // 
            // lbFilter
            // 
            this.lbFilter.AutoSize = true;
            this.lbFilter.Location = new System.Drawing.Point(54, 19);
            this.lbFilter.Name = "lbFilter";
            this.lbFilter.Size = new System.Drawing.Size(47, 13);
            this.lbFilter.TabIndex = 6;
            this.lbFilter.Text = "Filter op:";
            // 
            // FEResultaat
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(636, 450);
            this.Controls.Add(this.clbFilterResultaat);
            this.Controls.Add(this.lbFilter);
            this.Controls.Add(this.lblSelectieWeergave);
            this.Controls.Add(this.lvFEResultaat);
            this.Name = "FEResultaat";
            this.Text = "Frontend Resultaat";
            this.Load += new System.EventHandler(this.FEResultaat_Load);
            this.Snelmenu.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListView lvFEResultaat;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        private System.Windows.Forms.ContextMenuStrip Snelmenu;
        private System.Windows.Forms.ToolStripMenuItem SelecterenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem GroeperenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem SorterenToolStripMenuItem;
        private System.Windows.Forms.Label lblSelectieWeergave;
        private System.Windows.Forms.CheckedListBox clbFilterResultaat;
        private System.Windows.Forms.Label lbFilter;
    }
}