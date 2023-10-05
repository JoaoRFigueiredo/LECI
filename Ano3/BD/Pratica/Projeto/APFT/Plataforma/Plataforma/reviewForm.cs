using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Plataforma
{
    public partial class reviewForm : Form
    {

        int content_id;

        public reviewForm(int contentId)
        {

            InitializeComponent();
            Movies_db moviesDb = Movies_db.Instance;
            content_id = contentId;
            MessageBox.Show(content_id.ToString());



        }

        private void addReview_Click(object sender, EventArgs e)
        {
            Movies_db moviesDb = Movies_db.Instance;

            try
            {
                string username = userBox.Text;
                if (string.IsNullOrEmpty(username))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                string password = passwordText.Text;
                if (string.IsNullOrEmpty(password))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                string review = reviewText.Text;
                if (string.IsNullOrEmpty(review))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                // Verify user login
                bool validLogin = moviesDb.VerifyLogin(username, password);
                if (!validLogin)
                {
                    MessageBox.Show("Credenciais de login inválidas\n"+username+"//"+password);
                    return;
                }

                // Get the user_id for the given username
                int userId = moviesDb.GetUserId(username);

                // Insert the review into the 'avalia' table
                moviesDb.InsertReview(userId, content_id, review);

                // You can perform other database operations or any other desired action here

                // For simplicity, let's assume we are printing the content_id, username, and review
                MessageBox.Show("Content ID: " + content_id + "\n" + "Username: " + username + "\n" + "Review: " + review);

                MessageBox.Show("Review adicionada com sucesso");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }
        }

        private void addReview_Click_1(object sender, EventArgs e)
        {
            Movies_db moviesDb = Movies_db.Instance;

            try
            {
                string username = userBox.Text;
                if (string.IsNullOrEmpty(username))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                string password = passwordText.Text;
                if (string.IsNullOrEmpty(password))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                string review = reviewText.Text;
                if (string.IsNullOrEmpty(review))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                // Verify user login
                bool validLogin = moviesDb.VerifyLogin(username, password);
                if (!validLogin)
                {
                    MessageBox.Show("Credenciais de login inválidas\n" + username + "//" + password);
                    return;
                }

                // Get the user_id for the given username
                int userId = moviesDb.GetUserId(username);

                // Insert the review into the 'avalia' table
                moviesDb.InsertReview(userId, content_id, review);

                // You can perform other database operations or any other desired action here

                // For simplicity, let's assume we are printing the content_id, username, and review
                MessageBox.Show("Content ID: " + content_id + "\n" + "Username: " + username + "\n" + "Review: " + review);

                MessageBox.Show("Review adicionada com sucesso");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }

        }
    }
}
