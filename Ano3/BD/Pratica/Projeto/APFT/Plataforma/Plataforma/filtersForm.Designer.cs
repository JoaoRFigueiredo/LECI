namespace Plataforma
{
    partial class filtersForm
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
            genresCheckListBox = new CheckedListBox();
            label1 = new Label();
            label2 = new Label();
            orderCombo = new ComboBox();
            label3 = new Label();
            label4 = new Label();
            personTextBox = new TextBox();
            filterButton = new Button();
            SuspendLayout();
            // 
            // genresCheckListBox
            // 
            genresCheckListBox.FormattingEnabled = true;
            genresCheckListBox.Items.AddRange(new object[] { "Action and Adventure", "Animation", "Comedy", "Drama", "Historical", "Horror", "Scince Fiction", "Western" });
            genresCheckListBox.Location = new Point(11, 71);
            genresCheckListBox.Name = "genresCheckListBox";
            genresCheckListBox.Size = new Size(120, 148);
            genresCheckListBox.TabIndex = 4;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(11, 53);
            label1.Name = "label1";
            label1.Size = new Size(46, 15);
            label1.TabIndex = 5;
            label1.Text = "Genres:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 20F, FontStyle.Regular, GraphicsUnit.Point);
            label2.Location = new Point(90, 9);
            label2.Name = "label2";
            label2.Size = new Size(117, 37);
            label2.TabIndex = 6;
            label2.Text = "Filter By:";
            // 
            // orderCombo
            // 
            orderCombo.FormattingEnabled = true;
            orderCombo.Items.AddRange(new object[] { "A-Z", "Z-A", "Ratings Asc", "Ratings Des", "Most Recent" });
            orderCombo.Location = new Point(159, 71);
            orderCombo.Name = "orderCombo";
            orderCombo.Size = new Size(121, 23);
            orderCombo.TabIndex = 7;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(159, 53);
            label3.Name = "label3";
            label3.Size = new Size(56, 15);
            label3.TabIndex = 8;
            label3.Text = "Order By:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(159, 125);
            label4.Name = "label4";
            label4.Size = new Size(46, 15);
            label4.TabIndex = 9;
            label4.Text = "Person:";
            // 
            // personTextBox
            // 
            personTextBox.Location = new Point(159, 143);
            personTextBox.Name = "personTextBox";
            personTextBox.Size = new Size(121, 23);
            personTextBox.TabIndex = 10;
            // 
            // filterButton
            // 
            filterButton.Location = new Point(159, 193);
            filterButton.Name = "filterButton";
            filterButton.Size = new Size(121, 60);
            filterButton.TabIndex = 11;
            filterButton.Text = "Filter";
            filterButton.UseVisualStyleBackColor = true;
            filterButton.Click += filterButton_Click;
            // 
            // filtersForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(302, 269);
            Controls.Add(filterButton);
            Controls.Add(personTextBox);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(orderCombo);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(genresCheckListBox);
            Name = "filtersForm";
            Text = "filtersForm";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private CheckedListBox genresCheckListBox;
        private Label label1;
        private Label label2;
        private ComboBox orderCombo;
        private Label label3;
        private Label label4;
        private TextBox personTextBox;
        private Button filterButton;
    }
}