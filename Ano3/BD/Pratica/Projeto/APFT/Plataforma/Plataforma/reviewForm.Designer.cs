namespace Plataforma
{
    partial class reviewForm
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
            this.label16 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.reviewText = new System.Windows.Forms.TextBox();
            this.addReview = new System.Windows.Forms.Button();
            this.passwordText = new System.Windows.Forms.TextBox();
            this.Password = new System.Windows.Forms.Label();
            this.userBox = new System.Windows.Forms.TextBox();
            this.userText = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Font = new System.Drawing.Font("Segoe UI", 30F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label16.Location = new System.Drawing.Point(14, 12);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(286, 67);
            this.label16.TabIndex = 17;
            this.label16.Text = "Add Review";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(14, 233);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(56, 20);
            this.label3.TabIndex = 20;
            this.label3.Text = "Review";
            // 
            // reviewText
            // 
            this.reviewText.Location = new System.Drawing.Point(117, 229);
            this.reviewText.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.reviewText.Name = "reviewText";
            this.reviewText.Size = new System.Drawing.Size(260, 27);
            this.reviewText.TabIndex = 23;
            // 
            // addReview
            // 
            this.addReview.Location = new System.Drawing.Point(117, 315);
            this.addReview.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.addReview.Name = "addReview";
            this.addReview.Size = new System.Drawing.Size(261, 73);
            this.addReview.TabIndex = 26;
            this.addReview.Text = "Add Review";
            this.addReview.UseVisualStyleBackColor = true;
            this.addReview.Click += new System.EventHandler(this.addReview_Click_1);
            // 
            // passwordText
            // 
            this.passwordText.Location = new System.Drawing.Point(117, 165);
            this.passwordText.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.passwordText.Name = "passwordText";
            this.passwordText.Size = new System.Drawing.Size(260, 27);
            this.passwordText.TabIndex = 28;
            // 
            // Password
            // 
            this.Password.AutoSize = true;
            this.Password.Location = new System.Drawing.Point(14, 169);
            this.Password.Name = "Password";
            this.Password.Size = new System.Drawing.Size(70, 20);
            this.Password.TabIndex = 27;
            this.Password.Text = "Password";
            // 
            // userBox
            // 
            this.userBox.Location = new System.Drawing.Point(117, 101);
            this.userBox.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.userBox.Name = "userBox";
            this.userBox.Size = new System.Drawing.Size(260, 27);
            this.userBox.TabIndex = 30;
            // 
            // userText
            // 
            this.userText.AutoSize = true;
            this.userText.Location = new System.Drawing.Point(14, 105);
            this.userText.Name = "userText";
            this.userText.Size = new System.Drawing.Size(75, 20);
            this.userText.TabIndex = 29;
            this.userText.Text = "Username";
            // 
            // reviewForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(519, 424);
            this.Controls.Add(this.userBox);
            this.Controls.Add(this.userText);
            this.Controls.Add(this.passwordText);
            this.Controls.Add(this.Password);
            this.Controls.Add(this.addReview);
            this.Controls.Add(this.reviewText);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label16);
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.Name = "reviewForm";
            this.Text = "reviewForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private Label label16;
        private Label label3;
        private TextBox reviewText;
        private Button addReview;
        private TextBox passwordText;
        private Label Password;
        private TextBox userBox;
        private Label userText;
    }
}