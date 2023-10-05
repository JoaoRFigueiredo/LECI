namespace Plataforma
{
    partial class episodioForm
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
            numSeasonLabel = new Label();
            numeroEpisodioLabel = new Label();
            dataLabel = new Label();
            runtimeLabel = new Label();
            ratingLabel = new Label();
            synopsisLabel = new Label();
            label15 = new Label();
            nameLabel = new Label();
            SuspendLayout();
            // 
            // numSeasonLabel
            // 
            numSeasonLabel.AutoSize = true;
            numSeasonLabel.Location = new Point(12, 88);
            numSeasonLabel.Name = "numSeasonLabel";
            numSeasonLabel.Size = new Size(94, 15);
            numSeasonLabel.TabIndex = 24;
            numSeasonLabel.Text = "Numero Season:";
            // 
            // numeroEpisodioLabel
            // 
            numeroEpisodioLabel.AutoSize = true;
            numeroEpisodioLabel.Location = new Point(11, 112);
            numeroEpisodioLabel.Name = "numeroEpisodioLabel";
            numeroEpisodioLabel.Size = new Size(102, 15);
            numeroEpisodioLabel.TabIndex = 23;
            numeroEpisodioLabel.Text = "Numero Episodio:";
            // 
            // dataLabel
            // 
            dataLabel.AutoSize = true;
            dataLabel.Location = new Point(12, 63);
            dataLabel.Name = "dataLabel";
            dataLabel.Size = new Size(87, 15);
            dataLabel.TabIndex = 22;
            dataLabel.Text = "Data de Estreia:";
            // 
            // runtimeLabel
            // 
            runtimeLabel.AutoSize = true;
            runtimeLabel.Location = new Point(11, 142);
            runtimeLabel.Name = "runtimeLabel";
            runtimeLabel.Size = new Size(55, 15);
            runtimeLabel.TabIndex = 21;
            runtimeLabel.Text = "Runtime:";
            // 
            // ratingLabel
            // 
            ratingLabel.AutoSize = true;
            ratingLabel.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            ratingLabel.Location = new Point(558, 29);
            ratingLabel.Name = "ratingLabel";
            ratingLabel.Size = new Size(73, 28);
            ratingLabel.TabIndex = 20;
            ratingLabel.Text = "Rating:";
            // 
            // synopsisLabel
            // 
            synopsisLabel.AutoSize = true;
            synopsisLabel.Location = new Point(12, 205);
            synopsisLabel.Name = "synopsisLabel";
            synopsisLabel.Size = new Size(44, 15);
            synopsisLabel.TabIndex = 19;
            synopsisLabel.Text = "label14";
            // 
            // label15
            // 
            label15.AutoSize = true;
            label15.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            label15.Location = new Point(12, 168);
            label15.Name = "label15";
            label15.Size = new Size(92, 28);
            label15.TabIndex = 18;
            label15.Text = "Synopsis:";
            // 
            // nameLabel
            // 
            nameLabel.AutoSize = true;
            nameLabel.Font = new Font("Segoe UI", 30F, FontStyle.Regular, GraphicsUnit.Point);
            nameLabel.Location = new Point(12, 9);
            nameLabel.Name = "nameLabel";
            nameLabel.Size = new Size(337, 54);
            nameLabel.TabIndex = 17;
            nameLabel.Text = "Name of Episodio";
            // 
            // episodioForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(692, 292);
            Controls.Add(numSeasonLabel);
            Controls.Add(numeroEpisodioLabel);
            Controls.Add(dataLabel);
            Controls.Add(runtimeLabel);
            Controls.Add(ratingLabel);
            Controls.Add(synopsisLabel);
            Controls.Add(label15);
            Controls.Add(nameLabel);
            Name = "episodioForm";
            Text = "episodioForm";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label numSeasonLabel;
        private Label numeroEpisodioLabel;
        private Label dataLabel;
        private Label runtimeLabel;
        private Label ratingLabel;
        private Label synopsisLabel;
        private Label label15;
        private Label nameLabel;
    }
}