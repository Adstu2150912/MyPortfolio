namespace Vestingloop2018
{
    partial class FEDeelname
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
            this.lvFEDeelname = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Snelmenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.SelecterenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.GroeperenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.SorterenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lblSelectieWeergave = new System.Windows.Forms.Label();
            this.lbFilter = new System.Windows.Forms.Label();
            this.clbFilterDeelname = new System.Windows.Forms.CheckedListBox();
            this.Snelmenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // lvFEDeelname
            // 
            this.lvFEDeelname.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4});
            this.lvFEDeelname.ContextMenuStrip = this.Snelmenu;
            this.lvFEDeelname.FullRowSelect = true;
            this.lvFEDeelname.GridLines = true;
            this.lvFEDeelname.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.Nonclickable;
            this.lvFEDeelname.Location = new System.Drawing.Point(46, 85);
            this.lvFEDeelname.Name = "lvFEDeelname";
            this.lvFEDeelname.Size = new System.Drawing.Size(546, 243);
            this.lvFEDeelname.TabIndex = 0;
            this.lvFEDeelname.UseCompatibleStateImageBehavior = false;
            this.lvFEDeelname.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "FE_Deelname_ID";
            this.columnHeader1.Width = 0;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Deelnemer";
            this.columnHeader2.Width = 165;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "Afkomst";
            this.columnHeader3.Width = 164;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "Leeftijd";
            this.columnHeader4.Width = 210;
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
            this.lblSelectieWeergave.Location = new System.Drawing.Point(43, 371);
            this.lblSelectieWeergave.Name = "lblSelectieWeergave";
            this.lblSelectieWeergave.Size = new System.Drawing.Size(138, 13);
            this.lblSelectieWeergave.TabIndex = 2;
            this.lblSelectieWeergave.Text = "*Visuele weergave selectie*";
            this.lblSelectieWeergave.UseWaitCursor = true;
            this.lblSelectieWeergave.Visible = false;
            // 
            // lbFilter
            // 
            this.lbFilter.AutoSize = true;
            this.lbFilter.Location = new System.Drawing.Point(38, 22);
            this.lbFilter.Name = "lbFilter";
            this.lbFilter.Size = new System.Drawing.Size(47, 13);
            this.lbFilter.TabIndex = 4;
            this.lbFilter.Text = "Filter op:";
            // 
            // clbFilterDeelname
            // 
            this.clbFilterDeelname.FormattingEnabled = true;
            this.clbFilterDeelname.Items.AddRange(new object[] {
            "Deelnemer",
            "Afkomst",
            "Leeftijd"});
            this.clbFilterDeelname.Location = new System.Drawing.Point(90, 22);
            this.clbFilterDeelname.Margin = new System.Windows.Forms.Padding(2);
            this.clbFilterDeelname.Name = "clbFilterDeelname";
            this.clbFilterDeelname.Size = new System.Drawing.Size(91, 49);
            this.clbFilterDeelname.TabIndex = 5;
            this.clbFilterDeelname.ItemCheck += new System.Windows.Forms.ItemCheckEventHandler(this.ClbFilterDeelname_ItemCheck);
            // 
            // FEDeelname
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(642, 450);
            this.Controls.Add(this.clbFilterDeelname);
            this.Controls.Add(this.lbFilter);
            this.Controls.Add(this.lblSelectieWeergave);
            this.Controls.Add(this.lvFEDeelname);
            this.Name = "FEDeelname";
            this.Text = "Frontend Deelname";
            this.Load += new System.EventHandler(this.FEDeelname_Load);
            this.Snelmenu.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListView lvFEDeelname;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ContextMenuStrip Snelmenu;
        private System.Windows.Forms.ToolStripMenuItem SelecterenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem GroeperenToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem SorterenToolStripMenuItem;
        private System.Windows.Forms.Label lblSelectieWeergave;
        private System.Windows.Forms.Label lbFilter;
        private System.Windows.Forms.CheckedListBox clbFilterDeelname;
    }
}