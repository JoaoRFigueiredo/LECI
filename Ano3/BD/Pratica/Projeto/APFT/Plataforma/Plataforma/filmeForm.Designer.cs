namespace Plataforma
{
    partial class filmeForm
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
            nameLabel = new Label();
            label2 = new Label();
            synopsisLabel = new Label();
            ratingLabel = new Label();
            runtimeLabel = new Label();
            dateLabel = new Label();
            listBox1 = new ListBox();
            label7 = new Label();
            button1 = new Button();
            premiosLabel = new Label();
            generosLabel = new Label();
            SuspendLayout();
            // 
            // nameLabel
            // 
            nameLabel.AutoSize = true;
            nameLabel.Font = new Font("Segoe UI", 30F, FontStyle.Regular, GraphicsUnit.Point);
            nameLabel.Location = new Point(12, 9);
            nameLabel.Name = "nameLabel";
            nameLabel.Size = new Size(260, 54);
            nameLabel.TabIndex = 0;
            nameLabel.Text = "Name of Film";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            label2.Location = new Point(12, 146);
            label2.Name = "label2";
            label2.Size = new Size(92, 28);
            label2.TabIndex = 1;
            label2.Text = "Synopsis:";
            // 
            // synopsisLabel
            // 
            synopsisLabel.AutoSize = true;
            synopsisLabel.Location = new Point(12, 183);
            synopsisLabel.Name = "synopsisLabel";
            synopsisLabel.Size = new Size(38, 15);
            synopsisLabel.TabIndex = 2;
            synopsisLabel.Text = "label3";
            // 
            // ratingLabel
            // 
            ratingLabel.AutoSize = true;
            ratingLabel.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            ratingLabel.Location = new Point(643, 29);
            ratingLabel.Name = "ratingLabel";
            ratingLabel.Size = new Size(73, 28);
            ratingLabel.TabIndex = 3;
            ratingLabel.Text = "Rating:";
            // 
            // runtimeLabel
            // 
            runtimeLabel.AutoSize = true;
            runtimeLabel.Location = new Point(12, 91);
            runtimeLabel.Name = "runtimeLabel";
            runtimeLabel.Size = new Size(55, 15);
            runtimeLabel.TabIndex = 4;
            runtimeLabel.Text = "Runtime:";
            // 
            // dateLabel
            // 
            dateLabel.AutoSize = true;
            dateLabel.Location = new Point(12, 69);
            dateLabel.Name = "dateLabel";
            dateLabel.Size = new Size(87, 15);
            dateLabel.TabIndex = 5;
            dateLabel.Text = "Data de Estreia:";
            // 
            // listBox1
            // 
            listBox1.FormattingEnabled = true;
            listBox1.ItemHeight = 15;
            listBox1.Location = new Point(12, 280);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(776, 169);
            listBox1.TabIndex = 6;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            label7.Location = new Point(12, 252);
            label7.Name = "label7";
            label7.Size = new Size(84, 28);
            label7.TabIndex = 7;
            label7.Text = "Reviews:";
            // 
            // button1
            // 
            button1.Location = new Point(689, 252);
            button1.Name = "button1";
            button1.Size = new Size(99, 25);
            button1.TabIndex = 8;
            button1.Text = "Add Review +";
            button1.UseVisualStyleBackColor = true;
            // 
            // premiosLabel
            // 
            premiosLabel.AutoSize = true;
            premiosLabel.Location = new Point(12, 111);
            premiosLabel.Name = "premiosLabel";
            premiosLabel.Size = new Size(53, 15);
            premiosLabel.TabIndex = 9;
            premiosLabel.Text = "Premios:";
            // 
            // generosLabel
            // 
            generosLabel.AutoSize = true;
            generosLabel.Location = new Point(12, 131);
            generosLabel.Name = "generosLabel";
            generosLabel.Size = new Size(53, 15);
            generosLabel.TabIndex = 10;
            generosLabel.Text = "Generos:";
            // 
            // filmeForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(generosLabel);
            Controls.Add(premiosLabel);
            Controls.Add(button1);
            Controls.Add(label7);
            Controls.Add(listBox1);
            Controls.Add(dateLabel);
            Controls.Add(runtimeLabel);
            Controls.Add(ratingLabel);
            Controls.Add(synopsisLabel);
            Controls.Add(label2);
            Controls.Add(nameLabel);
            Name = "filmeForm";
            Text = "filmeForm";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label nameLabel;
        private Label label2;
        private Label synopsisLabel;
        private Label ratingLabel;
        private Label runtimeLabel;
        private Label dateLabel;
        private ListBox listBox1;
        private Label label7;
        private Button button1;
        private Label premiosLabel;
        private Label generosLabel;
    }
}