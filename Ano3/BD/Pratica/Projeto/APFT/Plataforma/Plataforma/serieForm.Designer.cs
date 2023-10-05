namespace Plataforma
{
    partial class serieForm
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
            label9 = new Label();
            selectButton = new Button();
            label8 = new Label();
            listBox2 = new ListBox();
            addReview = new Button();
            label7 = new Label();
            listBox1 = new ListBox();
            label6 = new Label();
            label5 = new Label();
            label4 = new Label();
            label3 = new Label();
            label2 = new Label();
            label1 = new Label();
            label10 = new Label();
            SuspendLayout();
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(281, -17);
            label9.Name = "label9";
            label9.Size = new Size(10, 480);
            label9.TabIndex = 47;
            label9.Text = "|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n|\r\n";
            // 
            // selectButton
            // 
            selectButton.Location = new Point(214, 20);
            selectButton.Name = "selectButton";
            selectButton.Size = new Size(59, 29);
            selectButton.TabIndex = 46;
            selectButton.Text = "Select";
            selectButton.UseVisualStyleBackColor = true;
            selectButton.Click += selectButton_Click;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Segoe UI", 20F, FontStyle.Regular, GraphicsUnit.Point);
            label8.Location = new Point(2, 15);
            label8.Name = "label8";
            label8.Size = new Size(206, 37);
            label8.TabIndex = 45;
            label8.Text = "List of Episodes:";
            // 
            // listBox2
            // 
            listBox2.FormattingEnabled = true;
            listBox2.ItemHeight = 15;
            listBox2.Location = new Point(2, 59);
            listBox2.Name = "listBox2";
            listBox2.Size = new Size(271, 379);
            listBox2.TabIndex = 44;
            // 
            // addReview
            // 
            addReview.Location = new Point(679, 261);
            addReview.Name = "addReview";
            addReview.Size = new Size(99, 25);
            addReview.TabIndex = 43;
            addReview.Text = "Add Review +";
            addReview.UseVisualStyleBackColor = true;
            addReview.Click += addReview_Click;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            label7.Location = new Point(299, 255);
            label7.Name = "label7";
            label7.Size = new Size(84, 28);
            label7.TabIndex = 42;
            label7.Text = "Reviews:";
            // 
            // listBox1
            // 
            listBox1.FormattingEnabled = true;
            listBox1.ItemHeight = 15;
            listBox1.Location = new Point(299, 291);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(479, 154);
            listBox1.TabIndex = 41;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(299, 58);
            label6.Name = "label6";
            label6.Size = new Size(87, 15);
            label6.TabIndex = 40;
            label6.Text = "Data de Estreia:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(299, 76);
            label5.Name = "label5";
            label5.Size = new Size(55, 15);
            label5.TabIndex = 39;
            label5.Text = "Runtime:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            label4.Location = new Point(661, 23);
            label4.Name = "label4";
            label4.Size = new Size(73, 28);
            label4.TabIndex = 38;
            label4.Text = "Rating:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(299, 158);
            label3.Name = "label3";
            label3.Size = new Size(38, 15);
            label3.TabIndex = 37;
            label3.Text = "label3";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            label2.Location = new Point(297, 121);
            label2.Name = "label2";
            label2.Size = new Size(92, 28);
            label2.TabIndex = 36;
            label2.Text = "Synopsis:";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 30F, FontStyle.Regular, GraphicsUnit.Point);
            label1.Location = new Point(290, 4);
            label1.Name = "label1";
            label1.Size = new Size(273, 54);
            label1.TabIndex = 35;
            label1.Text = "Name of Serie";
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(299, 97);
            label10.Name = "label10";
            label10.Size = new Size(53, 15);
            label10.TabIndex = 48;
            label10.Text = "Premios:";
            // 
            // serieForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(label10);
            Controls.Add(label9);
            Controls.Add(selectButton);
            Controls.Add(label8);
            Controls.Add(listBox2);
            Controls.Add(addReview);
            Controls.Add(label7);
            Controls.Add(listBox1);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "serieForm";
            Text = "serieForm";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label9;
        private Button selectButton;
        private Label label8;
        private ListBox listBox2;
        private Button addReview;
        private Label label7;
        private ListBox listBox1;
        private Label label6;
        private Label label5;
        private Label label4;
        private Label label3;
        private Label label2;
        private Label label1;
        private Label label10;
    }
}