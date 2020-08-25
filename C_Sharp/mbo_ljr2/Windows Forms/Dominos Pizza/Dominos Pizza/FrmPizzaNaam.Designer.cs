namespace Dominos_Pizza
{
    partial class FrmPizzaNaam
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
            this.lblPizzaNm = new System.Windows.Forms.Label();
            this.lvPizzaNaam = new System.Windows.Forms.ListView();
            this.cmnLvPizza = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.verwijderPizzaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.allePizzasVerwijderenToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.txtPizzaNaam = new System.Windows.Forms.TextBox();
            this.cmnLvPizza.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnInvoeren
            // 
            this.btnInvoeren.Location = new System.Drawing.Point(33, 79);
            this.btnInvoeren.Margin = new System.Windows.Forms.Padding(2);
            this.btnInvoeren.Name = "btnInvoeren";
            this.btnInvoeren.Size = new System.Drawing.Size(178, 26);
            this.btnInvoeren.TabIndex = 5;
            this.btnInvoeren.Text = "Pizza Invoeren";
            this.btnInvoeren.UseVisualStyleBackColor = true;
            this.btnInvoeren.Click += new System.EventHandler(this.btnBevestigen_Click);
            // 
            // lblPizzaNm
            // 
            this.lblPizzaNm.AutoSize = true;
            this.lblPizzaNm.Location = new System.Drawing.Point(31, 17);
            this.lblPizzaNm.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblPizzaNm.Name = "lblPizzaNm";
            this.lblPizzaNm.Size = new System.Drawing.Size(58, 13);
            this.lblPizzaNm.TabIndex = 3;
            this.lblPizzaNm.Text = "Pizzanaam";
            // 
            // lvPizzaNaam
            // 
            this.lvPizzaNaam.ContextMenuStrip = this.cmnLvPizza;
            this.lvPizzaNaam.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
            this.lvPizzaNaam.HoverSelection = true;
            this.lvPizzaNaam.Location = new System.Drawing.Point(33, 133);
            this.lvPizzaNaam.Margin = new System.Windows.Forms.Padding(2);
            this.lvPizzaNaam.MultiSelect = false;
            this.lvPizzaNaam.Name = "lvPizzaNaam";
            this.lvPizzaNaam.Size = new System.Drawing.Size(180, 119);
            this.lvPizzaNaam.TabIndex = 7;
            this.lvPizzaNaam.UseCompatibleStateImageBehavior = false;
            this.lvPizzaNaam.View = System.Windows.Forms.View.List;
            // 
            // cmnLvPizza
            // 
            this.cmnLvPizza.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.verwijderPizzaToolStripMenuItem,
            this.allePizzasVerwijderenToolStripMenuItem});
            this.cmnLvPizza.Name = "cmnLvPizza";
            this.cmnLvPizza.Size = new System.Drawing.Size(196, 48);
            // 
            // verwijderPizzaToolStripMenuItem
            // 
            this.verwijderPizzaToolStripMenuItem.Name = "verwijderPizzaToolStripMenuItem";
            this.verwijderPizzaToolStripMenuItem.Size = new System.Drawing.Size(195, 22);
            this.verwijderPizzaToolStripMenuItem.Text = "Verwijder pizza";
            this.verwijderPizzaToolStripMenuItem.Click += new System.EventHandler(this.verwijderPizzaToolStripMenuItem_Click);
            // 
            // allePizzasVerwijderenToolStripMenuItem
            // 
            this.allePizzasVerwijderenToolStripMenuItem.Name = "allePizzasVerwijderenToolStripMenuItem";
            this.allePizzasVerwijderenToolStripMenuItem.Size = new System.Drawing.Size(195, 22);
            this.allePizzasVerwijderenToolStripMenuItem.Text = "Alle pizza\'s verwijderen";
            this.allePizzasVerwijderenToolStripMenuItem.Click += new System.EventHandler(this.allePizzasVerwijderenToolStripMenuItem_Click);
            // 
            // txtPizzaNaam
            // 
            this.txtPizzaNaam.Location = new System.Drawing.Point(33, 46);
            this.txtPizzaNaam.Margin = new System.Windows.Forms.Padding(2);
            this.txtPizzaNaam.Name = "txtPizzaNaam";
            this.txtPizzaNaam.Size = new System.Drawing.Size(180, 20);
            this.txtPizzaNaam.TabIndex = 8;
            // 
            // FrmPizzaNaam
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(248, 284);
            this.Controls.Add(this.txtPizzaNaam);
            this.Controls.Add(this.lvPizzaNaam);
            this.Controls.Add(this.btnInvoeren);
            this.Controls.Add(this.lblPizzaNm);
            this.Name = "FrmPizzaNaam";
            this.Text = "Pizza";
            this.Load += new System.EventHandler(this.FrmPizzaNaam_Load);
            this.cmnLvPizza.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnInvoeren;
        private System.Windows.Forms.Label lblPizzaNm;
        private System.Windows.Forms.ListView lvPizzaNaam;
        private System.Windows.Forms.TextBox txtPizzaNaam;
        private System.Windows.Forms.ContextMenuStrip cmnLvPizza;
        private System.Windows.Forms.ToolStripMenuItem verwijderPizzaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem allePizzasVerwijderenToolStripMenuItem;
    }
}