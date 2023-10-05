using System;
using System.Collections.Generic;
using System.Text;
using Microsoft.Data.SqlClient;
using System.Data;

namespace Plataforma
{

    
    class Movies_db
    {
        private static Movies_db instance = null;
        private SqlConnection conn;

        private Movies_db()
        {
            conn = new SqlConnection("Data Source=tcp:mednat.ieeta.pt\\SQLSERVER,8101;User ID=p2g9;Password=Tiago_joao2;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
        }

        public static Movies_db Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new Movies_db();
                }
                return instance;
            }
        }

        public int GetNextPersonagemId()
        {
            conn.Open();

            string query = "SELECT MAX(personagem_id) FROM personagem";
            SqlCommand command = new SqlCommand(query, conn);

            object result = command.ExecuteScalar();
            if (result != null && result != DBNull.Value)
            {
                int maxPersonagemId = Convert.ToInt32(result);
                conn.Close();
                return maxPersonagemId + 1;
            }
            else
            {
                conn.Close();
                return 1; // Start from 1 if no personagem_id exists in the table
            }
        }

        public List<int> GetAllActorIds()
        {
            conn.Open();

            string query = "SELECT ator_id FROM ator";
            SqlCommand command = new SqlCommand(query, conn);
            SqlDataReader reader = command.ExecuteReader();

            List<int> actorIds = new List<int>();
            while (reader.Read())
            {
                int actorId = Convert.ToInt32(reader["ator_id"]);
                actorIds.Add(actorId);
            }

            reader.Close();
            conn.Close();

            return actorIds;
        }

        public int GetNextEpisodeNumber(int seasonId, int contentId)
        {
            int nextEpisodeNumber = 1;

            try
            {
                conn.Open();

                SqlCommand command = new SqlCommand(
                                "SELECT MAX(num_episodio) " +
                                "FROM episodio " +
                                "INNER JOIN temporada ON episodio.season_id = temporada.season_id " +
                                "INNER JOIN serie_televisiva ON temporada.content_id = serie_televisiva.content_id " +
                                "WHERE episodio.season_id = @seasonId AND serie_televisiva.content_id = @contentId;", conn);
                command.Parameters.AddWithValue("@seasonId", seasonId);
                command.Parameters.AddWithValue("@contentId", contentId);
                object result = command.ExecuteScalar();

                if (result != DBNull.Value)
                {
                    nextEpisodeNumber = Convert.ToInt32(result) + 1;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return nextEpisodeNumber;
        }


        public void InsertPersonagem(int personagemId, string nome, string papel)
        {
            conn.Open();

            string query = "INSERT INTO personagem (personagem_id, nome, papel) VALUES (@personagemId, @nome, @papel)";
            SqlCommand command = new SqlCommand(query, conn);
            command.Parameters.AddWithValue("@personagemId", personagemId);
            command.Parameters.AddWithValue("@nome", nome);
            command.Parameters.AddWithValue("@papel", papel);
            command.ExecuteNonQuery();

            conn.Close();
        }

        public void LinkPersonagemToActor(int personagemId, int atorId)
        {
            conn.Open();

            string query = "INSERT INTO interpreta (ator_id, personagem_id) VALUES (@atorId, @personagemId)";
            SqlCommand command = new SqlCommand(query, conn);
            command.Parameters.AddWithValue("@atorId", atorId);
            command.Parameters.AddWithValue("@personagemId", personagemId);
            command.ExecuteNonQuery();

            conn.Close();
        }

        public void LinkPersonagemToConteudo(int personagemId, int contentId)
        {
            conn.Open();

            string query = "INSERT INTO figura_em (content_id, personagem_id) VALUES (@contentId, @personagemId)";
            SqlCommand command = new SqlCommand(query, conn);
            command.Parameters.AddWithValue("@contentId", contentId);
            command.Parameters.AddWithValue("@personagemId", personagemId);
            command.ExecuteNonQuery();

            conn.Close();
        }





        public List<string> GetAvailableSeasons()
        {
            List<string> seasons = new List<string>();

            try
            {
                conn.Open();

                SqlCommand command = new SqlCommand("SELECT serie_televisiva.content_id, serie_televisiva.nome, temporada.numero_season FROM serie_televisiva INNER JOIN temporada ON serie_televisiva.content_id = temporada.content_id;", conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    int contentId = reader.GetInt32(0);
                    string seriesName = reader.GetString(1);
                    int seasonNumber = reader.GetInt32(2);
                    string season = $"{seriesName}, {seasonNumber}, {contentId}";
                    seasons.Add(season);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return seasons;
        }



        public int GetNextStudioID()
        {
            int nextID = 0;
            string query = "SELECT ISNULL(MAX(estudio_id), 0) + 1 FROM estudio";

            try
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand(query, conn);
                nextID = (int)cmd.ExecuteScalar();
            }
            catch (Exception ex)
            {
                // Handle the exception here
            }
            finally
            {
                conn.Close();
            }

            return nextID;
        }


        public void AddEpisode(int numEpisodio, int seasonId, int runtime, string synopsis, DateTime dataEstreia, int rating, int contentId)
        {
            try
            {
                conn.Open();

                // Check if the specified seasonId exists in temporada table for the specified contentId
                SqlCommand seasonCheckCommand = new SqlCommand("SELECT COUNT(*) FROM temporada WHERE season_id = @seasonId AND content_id = @contentId;", conn);
                seasonCheckCommand.Parameters.AddWithValue("@seasonId", seasonId);
                seasonCheckCommand.Parameters.AddWithValue("@contentId", contentId);
                //int seasonExists = Convert.ToInt32(seasonCheckCommand.ExecuteScalar());

                // Check if the specified contentId exists in serie_televisiva table
                SqlCommand serieCheckCommand = new SqlCommand("SELECT COUNT(*) FROM serie_televisiva WHERE content_id = @contentId;", conn);
                serieCheckCommand.Parameters.AddWithValue("@contentId", contentId);
                int serieExists = Convert.ToInt32(serieCheckCommand.ExecuteScalar());

                MessageBox.Show(serieExists + " ");

                if ( serieExists > 0)
                {
                    // Add the episode to episodio table
                    SqlCommand command = new SqlCommand("INSERT INTO episodio (num_episodio, season_id, runtime, synopsis, data_estreia, rating) " +
                                                        "VALUES (@numEpisodio, @seasonId, @runtime, @synopsis, @dataEstreia, @rating);", conn);
                    command.Parameters.AddWithValue("@numEpisodio", numEpisodio);
                    command.Parameters.AddWithValue("@seasonId", seasonId);
                    command.Parameters.AddWithValue("@runtime", runtime);
                    command.Parameters.AddWithValue("@synopsis", synopsis);
                    command.Parameters.AddWithValue("@dataEstreia", dataEstreia);
                    command.Parameters.AddWithValue("@rating", rating);
                    command.ExecuteNonQuery();
                }
                else
                {
                    MessageBox.Show("The specified seasonId or contentId does not exist.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }



        public bool VerifyLogin(string username, string password)
        {
            bool isValid = false;

            try
            {
                conn.Open();

                string query = "SELECT COUNT(*) FROM utilizador WHERE nome = @username AND password = @password";
                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@username", username);
                command.Parameters.AddWithValue("@password", password);
                int result = (int)command.ExecuteScalar();

                if (result > 0)
                {
                    isValid = true;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error verifying login: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return isValid;
        }

        public List<string> GetSeriesCombo()
        {
            List<string> comboData = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT content_id, nome FROM serie_televisiva";
                SqlCommand cmd = new SqlCommand(query, conn);

                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    int contentId = reader.GetInt32(0);
                    string seriesName = reader.GetString(1);
                    string comboItem = $"{contentId}, {seriesName}";

                    comboData.Add(comboItem);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return comboData;
        }
        public int GetNextSeasonID()
        {
            int nextID = 0;
            string query = "SELECT ISNULL(MAX(season_id), 0) + 1 FROM temporada";

            try
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand(query, conn);
                nextID = (int)cmd.ExecuteScalar();
            }
            catch (Exception ex)
            {
                // Handle the exception here
            }
            finally
            {
                conn.Close();
            }

            return nextID;
        }

        public List<string> GetAllMovies()
        {
            List<string> movies = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT nome FROM Filme";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    string movieName = reader["nome"].ToString();
                    movies.Add(movieName);
                    Console.WriteLine(movieName);
                   // MessageBox.Show(movieName);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving movies: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return movies;
        }

        public DataTable SearchContent(string nome, string estudio, string tipo)
        {
            DataTable dataTable = new DataTable();

            try
            {
                conn.Open();

                string query = "SELECT c.content_id, c.nome, f.runtime, f.synopsis, f.data_estreia, f.rating, s.nome AS serie_nome, s.synopsis AS serie_synopsis, s.rating AS serie_rating " +
                               "FROM conteudo c " +
                               "INNER JOIN estudio e ON c.estudio_id = e.estudio_id " +
                               "LEFT JOIN Filme f ON c.content_id = f.content_id " +
                               "LEFT JOIN serie_televisiva s ON c.content_id = s.content_id " +
                               "WHERE c.nome LIKE @nome ";

                if (!string.IsNullOrEmpty(estudio))
                {
                    query += "AND e.nome = @estudio ";
                }

                if (!string.IsNullOrEmpty(tipo))
                {
                    query += "AND ((@tipo = 'Filme' AND f.nome IS NOT NULL) OR (@tipo = 'Série' AND s.nome IS NOT NULL)) ";
                }

                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@nome", "%" + nome + "%");

                if (!string.IsNullOrEmpty(estudio))
                {
                    command.Parameters.AddWithValue("@estudio", estudio);
                }

                if (!string.IsNullOrEmpty(tipo))
                {
                    command.Parameters.AddWithValue("@tipo", tipo);
                }

                SqlDataAdapter adapter = new SqlDataAdapter(command);
                adapter.Fill(dataTable);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving search results: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return dataTable;
        }











        public DataTable GetAllConteudos()
        {
            DataTable dataTable = new DataTable();

            try
            {
                conn.Open();

                string query = "SELECT c.content_id, c.nome, f.runtime, f.synopsis, f.data_estreia, f.rating, s.nome AS serie_nome, s.synopsis AS serie_synopsis, s.rating AS serie_rating " +
                               "FROM conteudo c " +
                               "LEFT JOIN Filme f ON c.content_id = f.content_id " +
                               "LEFT JOIN serie_televisiva s ON c.content_id = s.content_id";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                // Add columns to the DataTable
                dataTable.Columns.Add("content_id");
                dataTable.Columns.Add("nome");
                dataTable.Columns.Add("runtime");
                dataTable.Columns.Add("synopsis");
                dataTable.Columns.Add("data_estreia");
                dataTable.Columns.Add("rating");
                dataTable.Columns.Add("serie_nome");
                dataTable.Columns.Add("serie_synopsis");
                dataTable.Columns.Add("serie_rating");

                while (reader.Read())
                {
                    // Create a new row
                    DataRow row = dataTable.NewRow();

                    // Set the values for each column in the row
                    row["content_id"] = reader["content_id"].ToString();
                    row["nome"] = reader["nome"].ToString();
                    row["runtime"] = reader["runtime"].ToString();
                    row["synopsis"] = reader["synopsis"].ToString();
                    row["data_estreia"] = reader["data_estreia"].ToString();
                    row["rating"] = reader["rating"].ToString();
                    row["serie_nome"] = reader["serie_nome"].ToString();
                    row["serie_synopsis"] = reader["serie_synopsis"].ToString();
                    row["serie_rating"] = reader["serie_rating"].ToString();

                    // Add the row to the DataTable
                    dataTable.Rows.Add(row);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving conteudos: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return dataTable;
        }



        public List<string> GetAllConteudos_String()
        {
            List<string> conteudos = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT c.content_id, c.nome, f.runtime, f.synopsis, f.data_estreia, f.rating, s.nome AS serie_nome, s.synopsis AS serie_synopsis, s.rating AS serie_rating " +
                               "FROM conteudo c " +
                               "LEFT JOIN Filme f ON c.content_id = f.content_id " +
                               "LEFT JOIN serie_televisiva s ON c.content_id = s.content_id";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    // Format the content information as a string
                    string contentInfo = string.Format("Content ID: {0}, Nome: {1}, Runtime: {2}, Synopsis: {3}, Data Estreia: {4}, Rating: {5}, Serie Nome: {6}, Serie Synopsis: {7}, Serie Rating: {8}",
                        reader["content_id"], reader["nome"], reader["runtime"], reader["synopsis"], reader["data_estreia"],
                        reader["rating"], reader["serie_nome"], reader["serie_synopsis"], reader["serie_rating"]);

                    // Add the content information to the list
                    conteudos.Add(contentInfo);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving conteudos: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return conteudos;
        }

        public List<string> GetAllStudios()
        {
            List<string> studios = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT * FROM estudio";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    int estudioId = Convert.ToInt32(reader["estudio_id"]);
                    string nome = reader["nome"].ToString();
                    DateTime anoCriacao = Convert.ToDateTime(reader["ano_criacao"]);
                    string localizacao = reader["localizacao"].ToString();

                    string studioInfo = $"Studio ID: {estudioId}\nNome: {nome}\nAno de Criacao: {anoCriacao}\nLocalizacao: {localizacao}\n";
                    studios.Add(studioInfo);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving studios: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return studios;
        }


        public bool AddEstudio(int id, string nome, string localizacao, DateTime anoCriacao)
        {
            try
            {
                conn.Open();

                string query = "INSERT INTO estudio (estudio_id, nome, localizacao, ano_criacao) " +
                               "VALUES (@id, @nome, @localizacao, @anoCriacao)";

                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@id", id);
                command.Parameters.AddWithValue("@nome", nome);
                command.Parameters.AddWithValue("@localizacao", localizacao);
                command.Parameters.AddWithValue("@anoCriacao", anoCriacao);

                int rowsAffected = command.ExecuteNonQuery();

                if (rowsAffected > 0)
                {
                    // Studio added successfully
                    return true;
                }
                else
                {
                    // Failed to add studio
                    return false;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error adding studio: " + ex.Message);
                return false;
            }
            finally
            {
                conn.Close();
            }
        }


        public bool EditEstudio(int id, string nome, string localizacao, DateTime anoCriacao)
        {
            try
            {
                conn.Open();

                string query = "UPDATE estudio " +
                               "SET nome = @nome, localizacao = @localizacao, ano_criacao = @anoCriacao " +
                               "WHERE estudio_id = @id";

                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@nome", nome);
                command.Parameters.AddWithValue("@localizacao", localizacao);
                command.Parameters.AddWithValue("@anoCriacao", anoCriacao);
                command.Parameters.AddWithValue("@id", id);

                int rowsAffected = command.ExecuteNonQuery();

                if (rowsAffected > 0)
                {
                    // Studio edited successfully
                    return true;
                }
                else
                {
                    // Failed to edit studio (ID not found or no changes made)
                    return false;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error editing studio: " + ex.Message);
                return false;
            }
            finally
            {
                conn.Close();
            }
        }


        public bool DeleteEstudio(int id)
        {
            try
            {
                conn.Open();
                SqlTransaction transaction = conn.BeginTransaction();

                try
                {
                    // Delete content associated with the studio
                    string deleteContentQuery = "DELETE FROM conteudo WHERE estudio_id = @id";
                    SqlCommand deleteContentCommand = new SqlCommand(deleteContentQuery, conn, transaction);
                    deleteContentCommand.Parameters.AddWithValue("@id", id);
                    deleteContentCommand.ExecuteNonQuery();

                    // Delete the studio
                    string deleteStudioQuery = "DELETE FROM estudio WHERE estudio_id = @id";
                    SqlCommand deleteStudioCommand = new SqlCommand(deleteStudioQuery, conn, transaction);
                    deleteStudioCommand.Parameters.AddWithValue("@id", id);
                    int rowsAffected = deleteStudioCommand.ExecuteNonQuery();

                    if (rowsAffected > 0)
                    {
                        // Commit the transaction if all queries succeed
                        transaction.Commit();
                        return true;
                    }
                    else
                    {
                        // Rollback the transaction if studio deletion fails (ID not found)
                        transaction.Rollback();
                        return false;
                    }
                }
                catch (Exception ex)
                {
                    // Rollback the transaction if any exception occurs
                    transaction.Rollback();
                    Console.WriteLine("Error deleting studio: " + ex.Message);
                    return false;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error opening connection: " + ex.Message);
                return false;
            }
            finally
            {
                conn.Close();
            }
        }

        public List<string> GetAllTemporada()
        {
            List<string> temporadaList = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT * FROM temporada";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    int seasonId = Convert.ToInt32(reader["season_id"]);
                    int contentId = Convert.ToInt32(reader["content_id"]);
                    int numeroSeason = Convert.ToInt32(reader["numero_season"]);

                    string temporadaInfo = $"Season ID: {seasonId}\n" +
                                            $"Content ID: {contentId}\n" +
                                            $"Season Number: {numeroSeason}";

                    temporadaList.Add(temporadaInfo);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving temporada: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return temporadaList;
        }

        public List<string> GetAllEpisodios()
        {
            List<string> episodioList = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT * FROM episodio";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    int numEpisodio = Convert.ToInt32(reader["num_episodio"]);
                    int seasonId = Convert.ToInt32(reader["season_id"]);
                    int runtime = Convert.ToInt32(reader["runtime"]);
                    string synopsis = reader["synopsis"].ToString();
                    DateTime dataEstreia = Convert.ToDateTime(reader["data_estreia"]);
                    int rating = Convert.ToInt32(reader["rating"]);

                    string episodioInfo = $"Episode Number: {numEpisodio}\n" +
                                          $"Season ID: {seasonId}\n" +
                                          $"Runtime: {runtime} minutes\n" +
                                          $"Synopsis: {synopsis}\n" +
                                          $"Release Date: {dataEstreia}\n" +
                                          $"Rating: {rating}";

                    episodioList.Add(episodioInfo);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving episodios: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return episodioList;
        }

        public List<string> GetAllPessoas()
        {
            List<string> pessoasList = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT p.num_cc, p.nome, p.data_nasc, " +
                               "CASE " +
                               "WHEN a.ator_id IS NOT NULL THEN 'Ator' " +
                               "WHEN r.num_filmes IS NOT NULL THEN 'Realizador' " +
                               "WHEN d.num_filmes IS NOT NULL THEN 'Diretor' " +
                               "ELSE 'Pessoa' " +
                               "END AS tipo_pessoa " +
                               "FROM pessoa p " +
                               "LEFT JOIN ator a ON p.num_cc = a.num_cc " +
                               "LEFT JOIN realizador r ON p.num_cc = r.num_cc " +
                               "LEFT JOIN diretor d ON p.num_cc = d.num_cc";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    int numCC = Convert.ToInt32(reader["num_cc"]);
                    string nome = reader["nome"].ToString();
                    DateTime dataNasc = Convert.ToDateTime(reader["data_nasc"]);
                    string tipoPessoa = reader["tipo_pessoa"].ToString();

                    string pessoaInfo = $"Num CC: {numCC}\n" +
                                        $"Nome: {nome}\n" +
                                        $"Data de Nascimento: {dataNasc}\n" +
                                        $"Tipo de Pessoa: {tipoPessoa}";

                    pessoasList.Add(pessoaInfo);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving pessoas: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return pessoasList;
        }


        public List<string> GetAllStudioNames()
        {
            List<string> studioNames = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT nome FROM estudio";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    string studioName = reader["nome"].ToString();
                    studioNames.Add(studioName);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving studio names: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return studioNames;
        }


        public bool AddMovie(int conteudo_id, string estudio_name, string nome, int runtime, string synopsis, DateTime data_estreia, int rating, List<string> genres, List<string> premios)
        {
            try
            {
                conn.Open();

                // Step 1: Find the estudio_id for the given estudio_name
                SqlCommand estudioCommand = new SqlCommand("SELECT estudio_id FROM estudio WHERE nome = @estudio_name;", conn);
                estudioCommand.Parameters.AddWithValue("@estudio_name", estudio_name);
                int estudio_id = (int)estudioCommand.ExecuteScalar();

                // Step 2: Insert movie data into conteudo table
                SqlCommand conteudoCommand = new SqlCommand("INSERT INTO conteudo (estudio_id, nome, content_id) VALUES (@estudio_id, @nome, @content_id);", conn);
                conteudoCommand.Parameters.AddWithValue("@estudio_id", estudio_id);
                conteudoCommand.Parameters.AddWithValue("@nome", nome);
                conteudoCommand.Parameters.AddWithValue("@content_id", conteudo_id);
                conteudoCommand.ExecuteNonQuery();

                // Step 3: Insert movie data into Filme table
                SqlCommand filmeCommand = new SqlCommand("INSERT INTO Filme (content_id, runtime, synopsis, data_estreia, rating) VALUES (@content_id, @runtime, @synopsis, @data_estreia, @rating);", conn);
                filmeCommand.Parameters.AddWithValue("@content_id", conteudo_id);
                filmeCommand.Parameters.AddWithValue("@runtime", runtime);
                filmeCommand.Parameters.AddWithValue("@synopsis", synopsis);
                filmeCommand.Parameters.AddWithValue("@data_estreia", data_estreia);
                filmeCommand.Parameters.AddWithValue("@rating", rating);
                filmeCommand.ExecuteNonQuery();

                // Step 4: Add genres if they exist
                if (genres.Count > 0)
                {
                    foreach (string genre in genres)
                    {
                        // Retrieve the genre ID from lista_generos based on the genre name
                        SqlCommand selectGenreCommand = new SqlCommand("SELECT nome_genero_id FROM lista_generos WHERE nome_genero = @nome_genero;", conn);
                        selectGenreCommand.Parameters.AddWithValue("@nome_genero", genre);
                        int nome_genero_id = (int)selectGenreCommand.ExecuteScalar();

                        // Insert into genero table using the retrieved genre ID
                        SqlCommand genreCommand = new SqlCommand("INSERT INTO genero (content_id, nome_genero_id) VALUES (@content_id, @nome_genero_id);", conn);
                        genreCommand.Parameters.AddWithValue("@content_id", conteudo_id);
                        genreCommand.Parameters.AddWithValue("@nome_genero_id", nome_genero_id);
                        genreCommand.ExecuteNonQuery();
                    }
                }

                // Step 5: Add prizes if they exist
                // Step 5: Add premios if they exist
                if (premios.Count > 0)
                {
                    foreach (string premio in premios)
                    {
                        // Retrieve the premio ID from lista_premios based on the premio name
                        SqlCommand selectPremioCommand = new SqlCommand("SELECT nome_premio_id FROM lista_premios WHERE nome_premio = @nome_premio;", conn);
                        selectPremioCommand.Parameters.AddWithValue("@nome_premio", premio);
                        int nome_premio_id = (int)selectPremioCommand.ExecuteScalar();

                        // Insert into premio table using the retrieved premio ID
                        SqlCommand premioCommand = new SqlCommand("INSERT INTO premio (content_id, nome_premio_id) VALUES (@content_id, @nome_premio_id);", conn);
                        premioCommand.Parameters.AddWithValue("@content_id", conteudo_id);
                        premioCommand.Parameters.AddWithValue("@nome_premio_id", nome_premio_id);
                        premioCommand.ExecuteNonQuery();
                    }
                }

                Console.WriteLine("Movie added successfully with content_id: " + conteudo_id);
                return true;
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error adding movie: " + ex.Message);
                MessageBox.Show("Error adding movie: " + ex.Message);
                return false;
            }
            finally
            {
                conn.Close();
            }
        }

        public List<string> GetAllPersonagens()
        {
            List<string> personagensList = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT nome, papel, personagem_id FROM personagem";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    string nome = reader["nome"].ToString();
                    string papel = reader["papel"].ToString();
                    int personagemId = Convert.ToInt32(reader["personagem_id"]);

                    string personagemInfo = $"Nome: {nome}\n" +
                                            $"Papel: {papel}\n" +
                                            $"Personagem ID: {personagemId}";

                    personagensList.Add(personagemInfo);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving personagens: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return personagensList;
        }

        public List<string> GetAllUtilizadores()
        {
            List<string> utilizadoresList = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT user_id, nome FROM utilizador";
                SqlCommand command = new SqlCommand(query, conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    int userId = Convert.ToInt32(reader["user_id"]);
                    string nome = reader["nome"].ToString();

                    string utilizadorInfo = $"User ID: {userId}\n" +
                                            $"Nome: {nome}";

                    utilizadoresList.Add(utilizadorInfo);
                }

                reader.Close();
                //MessageBox.Show(utilizadoresList[0]);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving utilizadores: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return utilizadoresList;
        }


        public void InsertReview(int userId, int contentId, string review)
        {
            try
            {
                conn.Open();

                string query = "INSERT INTO avalia (user_id, content_id, review) VALUES (@userId, @contentId, @review)";
                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@userId", userId);
                command.Parameters.AddWithValue("@contentId", contentId);
                command.Parameters.AddWithValue("@review", review);

                command.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error inserting review: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }


        public int GetUserId(string username)
        {
            int userId = -1;

            try
            {
                conn.Open();

                string query = "SELECT user_id FROM utilizador WHERE nome = @username";
                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@username", username);

                object result = command.ExecuteScalar();
                if (result != null)
                {
                    userId = Convert.ToInt32(result);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving user_id: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return userId;
        }


        public DataTable GetReviewsByContentId(int contentId)
        {
            DataTable reviews = new DataTable();

            try
            {
                conn.Open();

                string query = "SELECT utilizador.nome, avalia.review FROM avalia INNER JOIN utilizador ON avalia.user_id = utilizador.user_id WHERE avalia.content_id = @contentId";
                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@contentId", contentId);

                SqlDataAdapter adapter = new SqlDataAdapter(command);
                adapter.Fill(reviews);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving reviews: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return reviews;
        }

        public int GetNextContentId()
        {
            int nextId = 0;

            try
            {
                conn.Open();

                // Execute SQL query to retrieve the maximum existing content ID
                SqlCommand command = new SqlCommand("SELECT MAX(content_id) FROM conteudo", conn);
                object result = command.ExecuteScalar();

                if (result != null && result != DBNull.Value)
                {
                    int maxId = Convert.ToInt32(result);
                    nextId = maxId + 1;
                }
                else
                {
                    // If no content exists in the database, start with ID 1
                    nextId = 1;
                }
            }
            catch (Exception ex)
            {
                // Handle the exception or log the error
            }
            finally
            {
                conn.Close();
            }

            return nextId;
        }


        public bool AddSeries(int content_id, string estudio_name, string nome, string synopsis, int rating, List<string> genres, List<string> premios)
        {
            bool success = false;

            try
            {
                conn.Open();

                // First, insert the series into the conteudo table
                string insertConteudoQuery = "INSERT INTO conteudo (estudio_id, nome, content_id) VALUES (@estudio_id, @nome, @content_id)";
                SqlCommand insertConteudoCommand = new SqlCommand(insertConteudoQuery, conn);
                insertConteudoCommand.Parameters.AddWithValue("@estudio_id", 1); // Replace 1 with the actual studio_id you want to link
                insertConteudoCommand.Parameters.AddWithValue("@nome", nome);
                insertConteudoCommand.Parameters.AddWithValue("@content_id", content_id);
                int conteudoRowsAffected = insertConteudoCommand.ExecuteNonQuery();

                // Then, insert the series details into the serie_televisiva table
                string insertSeriesQuery = "INSERT INTO serie_televisiva (content_id, nome, synopsis, rating) VALUES (@content_id, @nome, @synopsis, @rating)";
                SqlCommand insertSeriesCommand = new SqlCommand(insertSeriesQuery, conn);
                insertSeriesCommand.Parameters.AddWithValue("@content_id", content_id);
                insertSeriesCommand.Parameters.AddWithValue("@nome", nome);
                insertSeriesCommand.Parameters.AddWithValue("@synopsis", synopsis);
                insertSeriesCommand.Parameters.AddWithValue("@rating", rating);
                int seriesRowsAffected = insertSeriesCommand.ExecuteNonQuery();

                if (genres.Count > 0)
                {
                    foreach (string genre in genres)
                    {
                        // Retrieve the genre ID from lista_generos based on the genre name
                        SqlCommand selectGenreCommand = new SqlCommand("SELECT nome_genero_id FROM lista_generos WHERE nome_genero = @nome_genero;", conn);
                        selectGenreCommand.Parameters.AddWithValue("@nome_genero", genre);
                        int nome_genero_id = (int)selectGenreCommand.ExecuteScalar();

                        // Insert into genero table using the retrieved genre ID
                        SqlCommand genreCommand = new SqlCommand("INSERT INTO genero (content_id, nome_genero_id) VALUES (@content_id, @nome_genero_id);", conn);
                        genreCommand.Parameters.AddWithValue("@content_id", content_id);
                        genreCommand.Parameters.AddWithValue("@nome_genero_id", nome_genero_id);
                        genreCommand.ExecuteNonQuery();
                    }
                }

                // Step 5: Add prizes if they exist
                // Step 5: Add premios if they exist
                if (premios.Count > 0)
                {
                    foreach (string premio in premios)
                    {
                        // Retrieve the premio ID from lista_premios based on the premio name
                        SqlCommand selectPremioCommand = new SqlCommand("SELECT nome_premio_id FROM lista_premios WHERE nome_premio = @nome_premio;", conn);
                        selectPremioCommand.Parameters.AddWithValue("@nome_premio", premio);
                        int nome_premio_id = (int)selectPremioCommand.ExecuteScalar();

                        // Insert into premio table using the retrieved premio ID
                        SqlCommand premioCommand = new SqlCommand("INSERT INTO premio (content_id, nome_premio_id) VALUES (@content_id, @nome_premio_id);", conn);
                        premioCommand.Parameters.AddWithValue("@content_id", content_id);
                        premioCommand.Parameters.AddWithValue("@nome_premio_id", nome_premio_id);
                        premioCommand.ExecuteNonQuery();
                    }
                }

                success = true;
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error adding series: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return success;
        }



        public List<string> GetPremiosFromDatabase()
        {
            List<string> premios = new List<string>();

            try
            {
                conn.Open();

                string selectQuery = "SELECT nome_premio FROM lista_premios";
                SqlCommand selectCommand = new SqlCommand(selectQuery, conn);
                SqlDataReader reader = selectCommand.ExecuteReader();

                while (reader.Read())
                {
                    string nomePremio = reader["nome_premio"].ToString();
                    premios.Add(nomePremio);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving premios: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return premios;
        }


        public List<string> GetGenresFromDatabase()
        {
            List<string> genres = new List<string>();

            try
            {
                conn.Open();

                string selectQuery = "SELECT nome_genero FROM lista_generos";
                SqlCommand selectCommand = new SqlCommand(selectQuery, conn);
                SqlDataReader reader = selectCommand.ExecuteReader();

                while (reader.Read())
                {
                    string nomeGenero = reader["nome_genero"].ToString();
                    genres.Add(nomeGenero);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error retrieving genres: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return genres;
        }

        public bool AddSeasonToDatabase(int content_id, int season_id, int season_num)
        {
            try
            {
               
                    conn.Open();

                    // Insert the season into the 'temporada' table
                    string insertQuery = "INSERT INTO temporada (season_id, content_id, numero_season) VALUES (@season_id, @content_id, @season_num)";
                    using (SqlCommand command = new SqlCommand(insertQuery, conn))
                    {
                        command.Parameters.AddWithValue("@season_id", season_id);
                        command.Parameters.AddWithValue("@content_id", content_id);
                        command.Parameters.AddWithValue("@season_num", season_num);
                        command.ExecuteNonQuery();
                    }

                // Perform any additional operations, if necessary
                conn.Close();
                    return true;
                }
            
            catch (Exception ex)
            {
               MessageBox.Show("Error: " + ex.Message);
                return false;
            }
        }

        public List<int> GetAllContentIds()
        {
            List<int> contentIds = new List<int>();

            try
            {
                conn.Open();

                SqlCommand command = new SqlCommand("SELECT content_id FROM conteudo;", conn);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    int contentId = Convert.ToInt32(reader["content_id"]);
                    contentIds.Add(contentId);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return contentIds;
        }





        public int GetNextActorId()
        {
            int nextActorId = 0;

            try
            {
                conn.Open();

                SqlCommand command = new SqlCommand("SELECT MAX(actor_id) FROM ator;", conn);
                object result = command.ExecuteScalar();

                if (result != DBNull.Value)
                {
                    nextActorId = Convert.ToInt32(result) + 1;
                }
                else
                {
                    nextActorId = 1;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return nextActorId;
        }


        public void InsertRealizador(int numCc, string nome, DateTime dataNasc)
        {
            try
            {
                conn.Open();

                // Insert data into pessoa table
                SqlCommand pessoaCommand = new SqlCommand("INSERT INTO pessoa (num_cc, nome, data_nasc) VALUES (@numCc, @nome, @dataNasc);", conn);
                pessoaCommand.Parameters.AddWithValue("@numCc", numCc);
                pessoaCommand.Parameters.AddWithValue("@nome", nome);
                pessoaCommand.Parameters.AddWithValue("@dataNasc", dataNasc);
                pessoaCommand.ExecuteNonQuery();

                // Generate a random value for num_filmes
                Random random = new Random();
                int numFilmes = random.Next(1, 11); // Random value between 1 and 10

                // Insert data into realizador table
                SqlCommand realizadorCommand = new SqlCommand("INSERT INTO realizador (num_cc, nome, data_nasc, num_filmes) VALUES (@numCc, @nome, @dataNasc, @numFilmes);", conn);
                realizadorCommand.Parameters.AddWithValue("@numCc", numCc);
                realizadorCommand.Parameters.AddWithValue("@nome", nome);
                realizadorCommand.Parameters.AddWithValue("@dataNasc", dataNasc);
                realizadorCommand.Parameters.AddWithValue("@numFilmes", numFilmes);
                realizadorCommand.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        public void InsertAtor(int numCc, string nome, DateTime dataNasc, int atorId)
        {
            try
            {
                conn.Open();

                // Insert data into pessoa table
                SqlCommand pessoaCommand = new SqlCommand("INSERT INTO pessoa (num_cc, nome, data_nasc) VALUES (@numCc, @nome, @dataNasc);", conn);
                pessoaCommand.Parameters.AddWithValue("@numCc", numCc);
                pessoaCommand.Parameters.AddWithValue("@nome", nome);
                pessoaCommand.Parameters.AddWithValue("@dataNasc", dataNasc);
                pessoaCommand.ExecuteNonQuery();

                // Insert data into ator table
                SqlCommand atorCommand = new SqlCommand("INSERT INTO ator (num_cc, nome, data_nasc, ator_id) VALUES (@numCc, @nome, @dataNasc, @atorId);", conn);
                atorCommand.Parameters.AddWithValue("@numCc", numCc);
                atorCommand.Parameters.AddWithValue("@nome", nome);
                atorCommand.Parameters.AddWithValue("@dataNasc", dataNasc);
                atorCommand.Parameters.AddWithValue("@atorId", atorId);
                atorCommand.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        public void InsertDiretor(int numCc, string nome, DateTime dataNasc)
        {
            try
            {
                conn.Open();

                // Insert data into pessoa table
                SqlCommand pessoaCommand = new SqlCommand("INSERT INTO pessoa (num_cc, nome, data_nasc) VALUES (@numCc, @nome, @dataNasc);", conn);
                pessoaCommand.Parameters.AddWithValue("@numCc", numCc);
                pessoaCommand.Parameters.AddWithValue("@nome", nome);
                pessoaCommand.Parameters.AddWithValue("@dataNasc", dataNasc);
                pessoaCommand.ExecuteNonQuery();

                // Generate a random value for num_filmes
                Random random = new Random();
                int numFilmes = random.Next(1, 11); // Random value between 1 and 10

                // Insert data into diretor table
                SqlCommand diretorCommand = new SqlCommand("INSERT INTO diretor (num_cc, nome, data_nasc, num_filmes) VALUES (@numCc, @nome, @dataNasc, @numFilmes);", conn);
                diretorCommand.Parameters.AddWithValue("@numCc", numCc);
                diretorCommand.Parameters.AddWithValue("@nome", nome);
                diretorCommand.Parameters.AddWithValue("@dataNasc", dataNasc);
                diretorCommand.Parameters.AddWithValue("@numFilmes", numFilmes);
                diretorCommand.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }





        public void InsertPessoaContent(int cc, int contentId)
        {

            try
            {
                conn.Open();
                string query = "INSERT INTO pessoa_content (num_cc, content_id) VALUES (@cc, @contentId)";
                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@cc", cc);
                command.Parameters.AddWithValue("@contentId", contentId);

                command.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        

       

        public int GetNextAvailableUserId()
        {
            int nextUserId = 0;

            try
            {
                conn.Open();

                string query = "SELECT MAX(user_id) + 1 FROM utilizador";
                SqlCommand command = new SqlCommand(query, conn);

                object result = command.ExecuteScalar();
                if (result != null && !DBNull.Value.Equals(result))
                {
                    nextUserId = Convert.ToInt32(result);
                }
            }
            catch (Exception ex)
            {
                // Handle the exception
                Console.WriteLine("Error: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return nextUserId;
        }


        public bool InsertUser(int id, string nome, string password)
        {
            bool isInserted = false;
            try
            {
                conn.Open();

                string query = "INSERT INTO utilizador (user_id, nome, password) VALUES (@id, @nome, @password)";
                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@id", id);
                command.Parameters.AddWithValue("@nome", nome);
                command.Parameters.AddWithValue("@password", password);
                int rowsAffected = command.ExecuteNonQuery();

                if (rowsAffected > 0)
                {
                    isInserted = true;
                }
            }
            catch (Exception ex)
            {
                // Handle the exception
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return isInserted;
        }

        // Inside the Movies_db class
        public Dictionary<string, string> GetPeopleAndTypesInContent(int contentId)
        {
            Dictionary<string, string> peopleAndTypes = new Dictionary<string, string>();

            try
            {
                conn.Open();

                string query = @"SELECT p.nome, 
                                CASE WHEN d.num_cc IS NOT NULL THEN 'Director'
                                     WHEN a.num_cc IS NOT NULL THEN 'Actor'
                                     ELSE 'Unknown'
                                END AS pessoa_type
                        FROM pessoa p
                        LEFT JOIN diretor d ON p.num_cc = d.num_cc
                        LEFT JOIN ator a ON p.num_cc = a.num_cc
                        INNER JOIN pessoa_content pc ON p.num_cc = pc.num_cc
                        WHERE pc.content_id = @contentId";
                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@contentId", contentId);

                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    string personName = reader["nome"].ToString();
                    string personType = reader["pessoa_type"].ToString();
                    peopleAndTypes.Add(personName, personType);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                // Handle the exception
                Console.WriteLine("Error: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return peopleAndTypes;
        }



        public List<string> GetPremiosInContent(int contentId)
        {
            List<string> premios = new List<string>();

            try
            {
                conn.Open();

                string query = "SELECT lp.nome_premio FROM premio p " +
                               "JOIN lista_premios lp ON p.nome_premio_id = lp.nome_premio_id " +
                               "WHERE p.content_id = @contentId";

                SqlCommand command = new SqlCommand(query, conn);
                command.Parameters.AddWithValue("@contentId", contentId);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    string premio = reader.GetString(0);
                    premios.Add(premio);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }

            return premios;
        }



    }
}
