using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Plataforma
{
    public partial class HomeForm : Form
    {
        private Movies_db data;
        private int selectedContentId;
        public HomeForm()
        {
            InitializeComponent();
            data = Movies_db.Instance;
            DataTable conteudos = data.GetAllConteudos();

            dataGridView1.DataSource = conteudos;

        }

        public class FilterData
        {
            public string Order { get; set; }
            public string Person { get; set; }
            public string[] Genres { get; set; }
        }


        public async void ReceiveFilterDataAsync(string filterJson)
        {
            filtersDisplay.Text = "";
            try
            {
                FilterData filter = JsonSerializer.Deserialize<FilterData>(filterJson);
                string o = filter.Order + ",";
                string p = filter.Person + ",";
                string g = "";
                try
                {
                    g = filter.Genres[0];
                    g = string.Join(",", filter.Genres);
                }
                catch (Exception e)
                {
                    g = "";
                }



                if (!string.IsNullOrEmpty(filter.Order) || !string.IsNullOrEmpty(filter.Person) || !string.IsNullOrEmpty(filter.Genres[0]))
                {

                    o = filter.Order;
                    p = filter.Person;


                    filtersDisplay.Text = o + p + g;
                }
                else
                {
                    filtersDisplay.Text = "No Filters";
                }
            }
            catch (Exception ex)
            {
                filtersDisplay.Text = "No Filters";
            }



        }



        private void filterButton_Click(object sender, EventArgs e)
        {
            var filterForm = new filtersForm();
            filterForm.Owner = this;
            filterForm.OnFilterApplied += ReceiveFilterDataAsync; // Set the callback function
            filterForm.Show();
        }





        private void selectButton_Click(object sender, EventArgs e)
        {
            // verifica se id é filme ou série


            MessageBox.Show("ok");
            var serieForm = new serieForm(5);
            serieForm.Owner = this;
            serieForm.Show();
        }





        private void filterButton_Click_1(object sender, EventArgs e)
        {
            var filterForm = new filtersForm();
            filterForm.Owner = this;
            filterForm.OnFilterApplied += ReceiveFilterDataAsync; // Set the callback function
            filterForm.Show();
        }

        private void adminButton_Click_1(object sender, EventArgs e)
        {
            var adminForm = new adminForm();
            adminForm.Owner = this;
            adminForm.Show();
        }

        private void selectButton_Click_1(object sender, EventArgs e)

        {

            //// Convert the text to an integer
            //int searchValue;
            //if (int.TryParse(textBoxValue, out searchValue))
            //{
            //    // Check if the selected item is a film or a serie


            // Open filmeForm
            


            //// Open serieForm
            //var serieForm = new serieForm(5);
            //serieForm.Owner = this;
            //serieForm.Show();
            //}

            //else
            //{
            //    MessageBox.Show("erro");
            //}



        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void nomeTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        //private void selectButton_Click_2(object sender, EventArgs e)
        //{
        //    if (dataGridView1.SelectedRows.Count > 0)
        //    {
        //        // Assuming the content type is stored in the first column (index 0)
        //        string contentType = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();

        //        // Use a switch statement or if-else conditions to redirect to the desired form based on the content type
        //        switch (contentType)
        //        {
        //            case "Type A":
        //                FormTypeA formTypeA = new FormTypeA();
        //                formTypeA.Show();
        //                break;
        //            case "Type B":
        //                FormTypeB formTypeB = new FormTypeB();
        //                formTypeB.Show();
        //                break;
        //            // Add more cases for other content types
        //            default:
        //                // Handle unknown content types or show an error message
        //                break;
        //        }
        //    }
        //}

        private void searchButton_Click(object sender, EventArgs e)
        {
            string nome = nomeTextBox.Text;
            string estudio = estudioTextBox.Text;
            string tipo = tipoCombo.SelectedItem?.ToString() ?? "";

            // Perform the search and get the DataTable
            DataTable searchResults = data.SearchContent(nome, estudio, tipo);

            // Set the DataTable as the data source for the DataGridView
            dataGridView1.DataSource = searchResults;

        }

        private void selectButton_Click_2(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                // Assuming the content_id is stored in a column named "content_id" in the DataTable
                selectedContentId = int.Parse(dataGridView1.SelectedRows[0].Cells["content_id"].Value.ToString());

                // Redirect to the other form
                reviewForm reviewForm = new reviewForm(selectedContentId);
                reviewForm.Show();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                // Assuming the content_id is stored in a column named "content_id" in the DataGridView
                int selectedContentId = int.Parse(dataGridView1.SelectedRows[0].Cells["content_id"].Value.ToString());

                // Retrieve all reviews for the selected content
                DataTable reviews = Movies_db.Instance.GetReviewsByContentId(selectedContentId);

                // Display the reviews in a MessageBox or any other desired way
                StringBuilder sb = new StringBuilder();
                foreach (DataRow row in reviews.Rows)
                {
                    string username = row["nome"].ToString();
                    string review = row["review"].ToString();

                    sb.AppendLine("Username: " + username);
                    sb.AppendLine("Review: " + review);
                    sb.AppendLine();
                }

                MessageBox.Show(sb.ToString(), "Reviews for Content ID: " + selectedContentId);
            }
        }

        private void adminButton_Click(object sender, EventArgs e)
        {
            var adminForm = new adminForm();
            adminForm.Owner = this;
            adminForm.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            // Display the people and their types in that content

            if (dataGridView1.SelectedRows.Count > 0)
            {
                // Assuming the content_id is stored in a column named "content_id" in the DataGridView
                int selectedContentId = int.Parse(dataGridView1.SelectedRows[0].Cells["content_id"].Value.ToString());

                // Call the auxiliary function to get the people and their types associated with the selected content
                Dictionary<string, string> peopleAndTypes = Movies_db.Instance.GetPeopleAndTypesInContent(selectedContentId);

                // Display the people and their types in a MessageBox or any other desired way
                string displayText = "";
                foreach (KeyValuePair<string, string> kvp in peopleAndTypes)
                {
                    string personName = kvp.Key;
                    string personType = kvp.Value;

                    // Replace "unknown" with "diretor" or "realizador" if the type is "unknown"
                    if (personType == "Unknown")
                    {
                        personType = (new Random().Next(2) == 0) ? "diretor" : "realizador";
                    }

                    displayText += "Person: " + personName + ", Type: " + personType + "\n";
                }

                MessageBox.Show("People in the content:\n\n" + displayText);
            }

        }

        private void button3_Click(object sender, EventArgs e)
        {
            // Display the premios (awards) of a given content

            if (dataGridView1.SelectedRows.Count > 0)
            {
                // Assuming the content_id is stored in a column named "content_id" in the DataGridView
                int selectedContentId = int.Parse(dataGridView1.SelectedRows[0].Cells["content_id"].Value.ToString());

                // Call the auxiliary function to get the premios (awards) associated with the selected content
                List<string> premios = Movies_db.Instance.GetPremiosInContent(selectedContentId);

                // Display the premios (awards) in a MessageBox or any other desired way
                string displayText = "";
                foreach (string premio in premios)
                {
                    displayText += "Premio: " + premio + "\n";
                }
                MessageBox.Show("Premios (Awards) of the content:\n\n" + displayText);
            }
        }
    }
}
