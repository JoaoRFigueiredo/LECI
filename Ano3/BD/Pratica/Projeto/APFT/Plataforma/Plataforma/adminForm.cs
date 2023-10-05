using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;


namespace Plataforma
{
    public partial class adminForm : Form
    {
        

        // Simulação de Items da Base dados
        static List<string> estudiosList = new List<string>() { "Walt disney", "Marvel" };
        static Dictionary<int, string> seasonDict = new Dictionary<int, string>() { { 1, "Key1" }, { 2, "Key2" }, { 3, "Key3" } };
        static Dictionary<int, string> conteudoDict = new Dictionary<int, string>() { { 1, "BladeRunner" }, { 2, "Matrix" }, { 3, "Borak" } };
        static Dictionary<int, string> atorDict = new Dictionary<int, string>() { { 1, "Toretto" }, { 2, "Rock" }, { 3, "FAMILY" } };



        public adminForm()
        {

            InitializeComponent();
            List<string> season_combo = Movies_db.Instance.GetSeriesCombo();
            id_contentSeasonCombo.DataSource = null; // Clear the existing DataSource
            id_contentSeasonCombo.Items.Clear(); // Clear the existing items

            // Add the items from the list to the ComboBox
            foreach (string item in season_combo)
            {
                id_contentSeasonCombo.Items.Add(item);
            }
            Movies_db moviesDb = Movies_db.Instance;
            List<string> studiosNames  = moviesDb.GetAllStudioNames();
            List<string> premios = Movies_db.Instance.GetPremiosFromDatabase();
            premiosConteudoCheckBox.Items.AddRange(premios.ToArray());

            List<string> genres = Movies_db.Instance.GetGenresFromDatabase();
            genresConteudoCheckBox.Items.AddRange(genres.ToArray());

            nameestudioConteudoCombo.Items.Clear();
            nameestudioConteudoCombo.Items.AddRange(studiosNames.ToArray());
            //id_contentSeasonCombo.Items.Clear();
            //id_contentSeasonCombo.Items.AddRange(seasonDict.Keys.Select(key => key.ToString()).ToArray());
            //id_seasonEpisodioCombo.Items.Clear();
            //id_seasonEpisodioCombo.Items.AddRange(conteudoDict.Keys.Select(key => key.ToString()).ToArray());
            List<string> seasons = Movies_db.Instance.GetAvailableSeasons();
            foreach (string item in seasons)
            {
                id_seasonEpisodioCombo.Items.Add(item);
            }
            id_contentPersonagemCombo.Items.Clear();
            id_contentPersonagemCombo.Items.AddRange(conteudoDict.Keys.Select(key => key.ToString()).ToArray());
            ator_idPersonagemCombo.Items.Clear();
            ator_idPersonagemCombo.Items.AddRange(atorDict.Keys.Select(key => key.ToString()).ToArray());

            List<int> ids = Movies_db.Instance.GetAllContentIds();
            foreach (int id in ids)
            {
                comboBoxContent.Items.Add(id);
                id_contentPersonagemCombo.Items.Add(id);
            }

            List<int> actorIds = Movies_db.Instance.GetAllActorIds();
            foreach (int id in actorIds)
            {
                ator_idPersonagemCombo.Items.Add(id);
                
            }

            List<string> studios = moviesDb.GetAllStudios();
            listBox1.DataSource = studios;
            listBox2.DataSource = moviesDb.GetAllConteudos_String();
            List<string> temporadas = moviesDb.GetAllTemporada();
            listBox6.DataSource = temporadas;
            listBox4.DataSource = moviesDb.GetAllEpisodios();
            listBox3.DataSource = moviesDb.GetAllPessoas();
            listBox7.DataSource = moviesDb.GetAllUtilizadores();
            listBox5.DataSource = moviesDb.GetAllPersonagens();
            

        }

       

        private void randomEstudio_Click(object sender, EventArgs e)
        {
            Random random = new Random();
            int number = random.Next(0, 1000);
            estudioIDTextBox.Text = number.ToString();
        }

       

       

        private void randomConteudoButton_Click(object sender, EventArgs e)
        {
            Random random = new Random();
            idConteudoText.Text = random.Next(0, 1000).ToString();
        }

      

        private void addConteudoButton_Click(object sender, EventArgs e)
        {
            try
            {
                int content_id = int.Parse(idConteudoText.Text);
                string nome = nomeConteudoText.Text;
                string estudio_name = nameestudioConteudoCombo.Text;
                string synopsis = synopsisConteudoText.Text;
                List<string> genres_send = new List<string>();
                List<string> premios_send = new List<string>();

               




                if (content_id >= 0 && content_id < 1000 && !string.IsNullOrEmpty(nome) && !string.IsNullOrEmpty(synopsis) && tipoConteudoCombo.SelectedItem != null)
                {
                    if (tipoConteudoCombo.SelectedIndex == 0)
                    {
                        int runtime = int.Parse(runtimeConteudoText.Text);
                        DateTime ano_estreia = DateTime.ParseExact(dateConteudoText.Text, "dd-MM-yyyy", CultureInfo.InvariantCulture);
                        int rating = int.Parse(ratingConteudoText.Text);

                        if (runtime >= 0 && runtime < 1000 && rating >= 0 && rating <= 10)
                        {
                            // Introduzir código aqui para adicionar Filmes à base de dados
                            if (genresConteudoCheckBox.CheckedItems.Count > 0)
                            {
                                foreach (string item in genresConteudoCheckBox.CheckedItems)
                                {
                                    genres_send.Add(item.ToString());
                                }
                            }
                            if (premiosConteudoCheckBox.CheckedItems.Count > 0)
                            {
                                foreach (string item in premiosConteudoCheckBox.CheckedItems)
                                {
                                    premios_send.Add(item.ToString());
                                }
                            }


                            MessageBox.Show("ok");
                        }
                    }
                    else
                    {
                        // Introduzir código aqui para adicionar Serie à base de dados
                        MessageBox.Show("ok2");

                    }


                }
                else
                {
                    MessageBox.Show("Introduza Valores válidos");

                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }
        }

        private void randomTemporadaButton_Click(object sender, EventArgs e)
        {
            Random random = new Random();
            id_seasonSeasonText.Text = random.Next(0, 1000).ToString();
        }

        private void id_contentSeasonCombo_SelectedIndexChanged(object sender, EventArgs e)
        {
            name_contentSeasonLabel.Text = seasonDict[int.Parse(id_contentSeasonCombo.SelectedItem?.ToString())];
        }

        private void addSeasonButton_Click(object sender, EventArgs e)
        {
            try
            {
                int season_id = int.Parse(id_seasonSeasonText.Text);
                string selectedItem = id_contentSeasonCombo.SelectedItem?.ToString();
                string[] selectedItemParts = selectedItem?.Split(',');

                int content_id = int.Parse(selectedItemParts[0]);
                int season_num = int.Parse(num_seasonSeasonText.Text);



                if (content_id >= 0 && content_id < 1000 && season_id >= 0 && season_id < 1000 && season_num > 0 && season_num < 100)
                {

                    // Introduzir código aqui para adicionar Temporada à base de dados
                    MessageBox.Show("ok");



                }
                else
                {
                    MessageBox.Show("Introduza Valores válidos");

                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }

        }

        private void id_seasonEpisodioCombo_SelectedIndexChanged(object sender, EventArgs e)
        {
            name_contentEpisodioLabel.Text = conteudoDict[int.Parse(id_seasonEpisodioCombo.SelectedItem?.ToString())];

        }

        private void addEpisodio_Click(object sender, EventArgs e)
        {
            try
            {
                int id_seasonEpisodio = int.Parse(id_seasonEpisodioCombo.SelectedItem.ToString());
                int num_episodio = int.Parse(num_episodioEpisodioText.Text);
                if (num_episodio < 1 || num_episodio > 100)
                {
                    throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                }

                string synopsisEpisodio = synopsisEpisodioText.Text;
                if (string.IsNullOrEmpty(synopsisEpisodio))
                {
                    throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                }

                int runtime = int.Parse(runtimeEpisodioText.Text);
                if (runtime < 0 || runtime > 1000)
                {
                    throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                }

                DateTime data = DateTime.ParseExact(dataEpisodioText.Text, "dd-MM-yyyy", CultureInfo.InvariantCulture);
                if (data.Year < 1 || data.Year > 9999 || data.Month < 1 || data.Month > 12 || data.Day < 1 || data.Day > 31)
                {
                    throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                }

                double rating = double.Parse(ratingEpisodioText.Text);
                if (rating < 0 || rating > 10)
                {
                    throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                }

                // Introduzir código aqui para adicionar Episódio à base de dados
                MessageBox.Show("Episódio adicionado com sucesso");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }
        }

        private void randomCCPessoa_Click(object sender, EventArgs e)
        {
            Random random = new Random();
            numCCPessoaText.Text = random.Next(1000, 10000).ToString();
        }

        private void randomidPessoa_Click(object sender, EventArgs e)
        {
            Random random = new Random();
            id_atorPessoaText.Text = random.Next(0, 1000).ToString();
        }

        private void addPessoa_Click(object sender, EventArgs e)
        {
            try
            {
                int numCC = int.Parse(numCCPessoaText.Text);
                if (numCC < 1000 || numCC > 9999)
                {
                    throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                }

                string nomePessoa = nomePessoaText.Text;
                if (string.IsNullOrEmpty(nomePessoa))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                DateTime datePessoa = DateTime.Parse(datePessoaText.Text);

                if (tipoPessoaCombo.SelectedIndex == 0)
                {
                    int id_ator = int.Parse(id_atorPessoaText.Text);
                    if (id_ator < 0 || id_ator > 1000)
                    {
                        throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                    }
                }
                else
                {
                    int numFilmes = int.Parse(numFIlmesPessoaText.Text);
                    if (numFilmes < 0 || numFilmes > 1000)
                    {
                        throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                    }
                }

                // Introduzir código aqui para adicionar Pessoa à base de dados
                MessageBox.Show("Pessoa adicionada com sucesso");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }
        }


        private void tipoPessoaCombo_SelectedIndexChanged(object sender, EventArgs e)
        {

            if (tipoPessoaCombo.SelectedIndex == 0)
            {
                id_atorPessoaLabel.Show();
                id_atorPessoaText.Show();
                randomidPessoa.Show();
                //numFilmePessoaLabel.Hide();
                numFIlmesPessoaText.Hide();
            }
            else
            {
                id_atorPessoaLabel.Hide();
                id_atorPessoaText.Hide();
                randomidPessoa.Hide();
               // numFilmePessoaLabel.Show();
                numFIlmesPessoaText.Show(); ;
            }

        }

        private void randomPersonagem_Click(object sender, EventArgs e)
        {
            Random random = new Random();
            id_personagemPersonagemText.Text = random.Next(0, 1000).ToString();
        }

        private void id_contentPersonagemCombo_SelectedIndexChanged(object sender, EventArgs e)
        {
            name_contentPersonagemLabel.Text = conteudoDict[int.Parse(id_contentPersonagemCombo.SelectedItem?.ToString())];
        }

        private void ator_idPersonagemCombo_SelectedIndexChanged(object sender, EventArgs e)
        {
            name_atorPersonagemLabel.Text = atorDict[int.Parse(ator_idPersonagemCombo.SelectedItem?.ToString())];
        }

        private void addPersonagem_Click(object sender, EventArgs e)
        {
            try
            {
                int personagemID = int.Parse(id_personagemPersonagemText.Text);
                if (personagemID < 0 || personagemID > 1000)
                {
                    throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                }

                int contentID = int.Parse(id_contentPersonagemCombo.SelectedItem?.ToString());
                int estudio_id = int.Parse(ator_idPersonagemCombo.SelectedItem?.ToString());

                string nomePersonagem = nomePersonagemText.Text;
                if (string.IsNullOrEmpty(nomePersonagem))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                string papel = papelPersonagemCombo.SelectedItem?.ToString();
                if (string.IsNullOrEmpty(papel))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                // Introduzir código aqui para adicionar Pessoa à base de dados
                MessageBox.Show("Pessoa adicionada com sucesso");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }
        }

        private void randomUser_Click(object sender, EventArgs e)
        {
            Random random = new Random();
            idUserText.Text = random.Next(0, 1000).ToString();
        }

        private void addUser_Click(object sender, EventArgs e)
        {
            try
            {
                int userID = int.Parse(idUserText.Text);
                if (userID < 0 || userID > 1000)
                {
                    throw new ArgumentOutOfRangeException("Introduza Valores válidos");
                }

                string nomeUser = nomeUserText.Text;
                if (string.IsNullOrEmpty(nomeUser))
                {
                    throw new ArgumentException("Introduza Valores válidos");
                }

                // Introduzir código aqui para adicionar Pessoa à base de dados
                MessageBox.Show("Pessoa adicionada com sucesso");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Movies_db moviesDb = Movies_db.Instance;
            List<string> studios = moviesDb.GetAllStudios();
            listBox1.DataSource = studios;
        }

        private void addEstudioButton_Click_1(object sender, EventArgs e)
        {
            try
            {
                int id = int.Parse(estudioIDTextBox.Text);
                string nome = nomeEstudioText.Text;
                string localizacao = localizacaoEstudioText.Text;
                DateTime anoCriacao = DateTime.ParseExact(dateEstudioText.Text, "dd-MM-yyyy", CultureInfo.InvariantCulture);

                if (id >= 0 && id < 1000 && nome != "" && localizacao != "")
                {
                    Movies_db moviesDb = Movies_db.Instance;
                    bool success = moviesDb.AddEstudio(id, nome, localizacao, anoCriacao);

                    if (success)
                    {
                        MessageBox.Show("Estudio adicionado com sucesso!");
                    }
                    else
                    {
                        MessageBox.Show("Erro ao adicionar o estudio.");
                    }
                }
                else
                {
                    MessageBox.Show("Introduza valores válidos.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza valores válidos.");
            }
        }

        private void editStudioButton_Click(object sender, EventArgs e)
        {
            try
            {
                int id = int.Parse(estudioIDTextBox.Text);
                string nome = nomeEstudioText.Text;
                string localizacao = localizacaoEstudioText.Text;
                DateTime anoCriacao = DateTime.ParseExact(dateEstudioText.Text, "dd-MM-yyyy", CultureInfo.InvariantCulture);

                if (id >= 0 && id < 1000 && nome != "" && localizacao != "")
                {
                    Movies_db moviesDb = Movies_db.Instance;
                    bool success = moviesDb.EditEstudio(id, nome, localizacao, anoCriacao);

                    if (success)
                    {
                        MessageBox.Show("Estudio editado com sucesso!");
                    }
                    else
                    {
                        MessageBox.Show("Erro ao editar o estudio.");
                    }
                }
                else
                {
                    MessageBox.Show("Introduza valores válidos.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza valores válidos.");
            }

        }

        private void deleteEstudioButton_Click(object sender, EventArgs e)
        {
            try
            {
                int id = int.Parse(estudioIDTextBox.Text);

                // Call the DeleteEstudio method to delete the estudio
                bool deleted = Movies_db.Instance.DeleteEstudio(id);

                if (deleted)
                {
                    MessageBox.Show("Estudio and associated content deleted successfully.");
                }
                else
                {
                    MessageBox.Show("Failed to delete estudio. Invalid ID or estudio does not exist.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error deleting estudio: " + ex.Message);
            }

        }


private void addConteudoButton_Click_1(object sender, EventArgs e)
    {
            int content_id = int.Parse(idConteudoText.Text);
            string nome = nomeConteudoText.Text;
            string estudio_name = nameestudioConteudoCombo.Text;
            string synopsis = synopsisConteudoText.Text;
            List<string> genres_send  = new List<string>();
            List<string> premios_send = new List<string>();
            if (genresConteudoCheckBox.CheckedItems.Count > 0)
            {
                foreach (string item in genresConteudoCheckBox.CheckedItems)
                {
                    genres_send.Add(item.ToString());
                }
            }
            if (premiosConteudoCheckBox.CheckedItems.Count > 0)
            {
                foreach (string item in premiosConteudoCheckBox.CheckedItems)
                {
                    premios_send.Add(item.ToString());
                }
            }

            if (content_id >= 0 && content_id < 1000 && !string.IsNullOrEmpty(nome) && !string.IsNullOrEmpty(synopsis) && tipoConteudoCombo.SelectedItem != null)
            {
                if (tipoConteudoCombo.SelectedIndex == 0)
                {
                    int runtime = int.Parse(runtimeConteudoText.Text);
                    DateTime ano_estreia = DateTime.ParseExact(dateConteudoText.Text, "dd-MM-yyyy", CultureInfo.InvariantCulture);
                    int rating = int.Parse(ratingConteudoText.Text);

                    if (runtime >= 0 && runtime < 1000 && rating >= 0 && rating <= 10)
                    {
                        // Add your code to retrieve genre and award data from the checkboxes
                        // Assuming you have checkboxes named genreCheckBox1, genreCheckBox2, awardCheckBox1, awardCheckBox2

                        //foreach (Control control in this.Controls)
                        //{
                        //    if (control is CheckBox)
                        //    {
                        //        CheckBox checkBox = (CheckBox)control;

                        //        if (checkBox.Checked)
                        //        {
                        //            if (checkBox.Name.StartsWith("genresConteudoCheckBox"))
                        //            {
                        //                string genre = checkBox.Text;
                        //                genres.Add(genre);
                        //            }
                        //            else if (checkBox.Name.StartsWith("premiosConteudoCheckBox"))
                        //            {
                        //                string premio = checkBox.Text;
                        //                premios.Add(premio);
                        //            }
                        //        }
                        //    }
                        //}
                        //MessageBox.Show(content_id.ToString());
                        //foreach (string premio in premios_send)
                        //{
                        //    MessageBox.Show(premio);
                        //}
                        bool success = Movies_db.Instance.AddMovie(content_id, estudio_name, nome, runtime, synopsis, ano_estreia, rating, genres_send, premios_send);

                        if (success)
                        {
                            MessageBox.Show("Movie added successfully");
                        }
                        else
                        {
                            MessageBox.Show("Error adding movie");
                        }
                    }
                    else
                    {
                        MessageBox.Show("Invalid runtime or rating");
                    }
                }
                else
                {
                    // Handle Series Televisiva
                    int rating = int.Parse(ratingConteudoText.Text);

                    if (rating >= 0 && rating <= 10)
                    {
                        bool success = Movies_db.Instance.AddSeries(content_id, estudio_name, nome, synopsis, rating, genres_send, premios_send);

                        if (success)
                        {
                            MessageBox.Show("Series added successfully");
                        }
                        else
                        {
                            MessageBox.Show("Error adding series");
                        }
                    }
                    else
                    {
                        MessageBox.Show("Invalid rating");
                    }
                }
            }
            else
            {
                MessageBox.Show("Please enter valid values");
            }

        }


        private void runtimeConteudoText_TextChanged(object sender, EventArgs e)
        {

        }

        private void tipoConteudoCombo_SelectedIndexChanged_1(object sender, EventArgs e)
        {
            if (tipoConteudoCombo.SelectedIndex == 0)
            {
                runtimeConteudoLabel.Show();
                runtimeConteudoText.Show();
                ratingConteudoLabel.Show();
                ratingConteudoText.Show();
                dateConteudoLabel.Show();
                dateConteudoText.Show();
            }
            else
            {
                runtimeConteudoLabel.Hide();
                runtimeConteudoText.Hide();
                ratingConteudoLabel.Show();
                ratingConteudoText.Show();
                dateConteudoLabel.Hide();
                dateConteudoText.Hide();
            }
        }

        private void randomConteudoButton_Click_1(object sender, EventArgs e)
        {
            int id = Movies_db.Instance.GetNextContentId();
            idConteudoText.Text = id.ToString();

        }

        

        

        private void randomEstudio_Click_1(object sender, EventArgs e)
        {
            int id = Movies_db.Instance.GetNextStudioID();
            estudioIDTextBox.Text = id.ToString();

        }

        private void randomTemporadaButton_Click_1(object sender, EventArgs e)
        {
            int id = Movies_db.Instance.GetNextSeasonID();
            id_seasonSeasonText.Text = id.ToString();
        }

        private void addSeasonButton_Click_1(object sender, EventArgs e)
        {
            try
            {
                int season_id = int.Parse(id_seasonSeasonText.Text);
                string selectedItem = id_contentSeasonCombo.SelectedItem?.ToString();
                string[] selectedItemParts = selectedItem?.Split(',');

                int content_id = int.Parse(selectedItemParts[0]);
                int season_num = int.Parse(num_seasonSeasonText.Text);
                MessageBox.Show("id="+ content_id.ToString());
                if (content_id >= 0 && content_id < 1000 && season_id >= 0 && season_id < 1000 && season_num > 0 && season_num < 100)


                        // Call a function to add the season to the database and link it to its corresponding series
                        if (Movies_db.Instance.AddSeasonToDatabase(content_id, season_id, season_num))
                    {
                        MessageBox.Show("Season added successfully.");
                    }
                    else
                    {
                        MessageBox.Show("Failed to add season.");
                    }
                
                else
                {
                    MessageBox.Show("Introduza Valores válidos");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Introduza Valores válidos");
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Assuming id_seasonEpisodioCombo is the combo box containing the "seriesName, SeasonID" values
            // Assuming num_episodioEpisodioText is the text box for displaying the next episode number

            // Check if an item is selected
            if (id_seasonEpisodioCombo.SelectedItem != null)
            {
                // Get the selected item from the combo box
                string selectedItem = id_seasonEpisodioCombo.SelectedItem.ToString();
                MessageBox.Show(selectedItem);

                // Split the selected item using the comma as the delimiter
                string[] parts = selectedItem.Split(',');

                if (parts.Length == 3)
                {
                    // Extract the seriesName and seasonId
                    string seriesName = parts[0].Trim();
                    int seasonId;
                    int contentId;

                    // Parse the seasonId
                    if (int.TryParse(parts[1].Trim(), out seasonId))
                    {
                        if (int.TryParse(parts[2].Trim(), out contentId))
                        {
                            // Call the function to get the next episode number
                            int nextEpisodeNumber = Movies_db.Instance.GetNextEpisodeNumber(seasonId, contentId);

                            // Set the next episode number in the text box
                            num_episodioEpisodioText.Text = nextEpisodeNumber.ToString();
                        }
                    }
                    else
                    {
                        // Invalid seasonId, handle the case accordingly
                        // ...
                    }
                }
                else
                {
                    // Invalid format, handle the case accordingly
                    // ...
                }
            }
            else
            {
                // No item selected, handle the case accordingly
                // ...
            }
        }

        private void addEpisodio_Click_1(object sender, EventArgs e)
        {

            string selectedItem = id_seasonEpisodioCombo.SelectedItem.ToString();
            //MessageBox.Show(selectedItem);
            string seriesName;
            int seasonId;
            int contentId;

            // Split the selected item using the comma as the delimiter
            string[] parts = selectedItem.Split(',');

            if (parts.Length == 3)
            {
                // Extract the seriesName, seasonId, and contentId
                seriesName = parts[0].Trim();
                seasonId = int.Parse(parts[1].Trim());
                contentId = int.Parse(parts[2].Trim());

                int numEpisodio = int.Parse(num_episodioEpisodioText.Text);
                string synopsis = synopsisEpisodioText.Text;
                int runtime = int.Parse(runtimeEpisodioText.Text);
                DateTime dataEstreia = DateTime.ParseExact(dataEpisodioText.Text, "dd-MM-yyyy", CultureInfo.InvariantCulture);
                int rating = int.Parse(ratingEpisodioText.Text);

                // Call the AddEpisode method with the extracted values
                Movies_db.Instance.AddEpisode(numEpisodio, seasonId, runtime, synopsis, dataEstreia, rating, contentId);
            }


            MessageBox.Show("Episode added!");

        }

        private void randomCCPessoa_Click_1(object sender, EventArgs e)
        {
            Random random = new Random();
            int randomNumCC = random.Next(100000000, 999999999);

            numCCPessoaText.Text = randomNumCC.ToString();
        }

        private void tipoPessoaCombo_SelectedIndexChanged_1(object sender, EventArgs e)
        {
            if (tipoPessoaCombo.SelectedIndex == 0)
            {
                id_atorPessoaLabel.Show();
                id_atorPessoaText.Show();
                randomidPessoa.Show();
                //numFilmePessoaLabel.Hide();
                numFIlmesPessoaText.Hide();
            }
            else
            {
                id_atorPessoaLabel.Hide();
                id_atorPessoaText.Hide();
                randomidPessoa.Hide();
                // numFilmePessoaLabel.Show();
                //numFIlmesPessoaText.Show(); ;
            }
        }

        private void randomidPessoa_Click_1(object sender, EventArgs e)
        {
            id_atorPessoaText.Text = Movies_db.Instance.GetNextActorId().ToString();
        }

        private void addPessoa_Click_1(object sender, EventArgs e)
        {
            int cc = int.Parse(numCCPessoaText.Text.ToString());
            string nome = nomePessoaText.Text.ToString();
            DateTime dataNascimento = DateTime.ParseExact(datePessoaText.Text, "dd-MM-yyyy", CultureInfo.InvariantCulture);
            int content_id = int.Parse(comboBoxContent.SelectedItem.ToString());

            if (tipoPessoaCombo.SelectedIndex == 1)
            {
                // Insert a director/realizador as pessoa
                //int numFilmes = int.Parse(numFilmesText.Text.ToString());
                Movies_db.Instance.InsertRealizador(cc, nome, dataNascimento);
                Movies_db.Instance.InsertDiretor(cc, nome, dataNascimento);
            }
            else if (tipoPessoaCombo.SelectedIndex == 0)
            {
                // Insert an actor in the db who is a pessoa
                int actorId = int.Parse(id_atorPessoaText.Text.ToString());
                Movies_db.Instance.InsertAtor(cc, nome, dataNascimento, actorId);
            }

            // Insert a row into pessoa table
            //Movies_db.Instance.InsertPessoa(cc, nome, dataNascimento);

            // Insert a row into pessoa_content table to link the pessoa with the content
            Movies_db.Instance.InsertPessoaContent(cc, content_id);

            MessageBox.Show("Pessoa added!");
        }

        private void nextPersonagemId_Click(object sender, EventArgs e)
        {
            int id = Movies_db.Instance.GetNextPersonagemId();
            id_personagemPersonagemText.Text = id.ToString();
        }

        private void addPersonagem_Click_1(object sender, EventArgs e)
        {
            int perso_id = int.Parse(id_personagemPersonagemText.Text.ToString());
            int content_id = int.Parse(id_contentPersonagemCombo.SelectedItem.ToString());
            int ator_id = int.Parse(ator_idPersonagemCombo.SelectedItem.ToString());
            string nome = nomePersonagemText.Text.ToString();
            string papel = papelPersonagemCombo.SelectedItem.ToString();

            // Insert the personagem
            Movies_db.Instance.InsertPersonagem(perso_id, nome, papel);

            // Link the personagem to the actor
            Movies_db.Instance.LinkPersonagemToActor(perso_id, ator_id);

            // Link the personagem to conteudo
            Movies_db.Instance.LinkPersonagemToConteudo(perso_id, content_id);

            MessageBox.Show("Personagem added!");

        }

        private void randomUser_Click_1(object sender, EventArgs e)
        {
            int id = Movies_db.Instance.GetNextAvailableUserId();
            idUserText.Text = id.ToString();
        }

        private void addUser_Click_1(object sender, EventArgs e)
        {
            int id = int.Parse(idUserText.Text.ToString());
            string nome = nomeUserText.Text.ToString();
            string pass = passwordUserText.Text.ToString();

            // Call the InsertUser function to insert the new user
            Movies_db.Instance.InsertUser(id, nome, pass);

            // Clear the input fields
            idUserText.Text = "";
            nomeUserText.Text = "";
            passwordUserText.Text = "";

            // Show a success message
            MessageBox.Show("User added successfully!");

        }
    }
}
