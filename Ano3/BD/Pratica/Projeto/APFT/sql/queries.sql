 --algumas queries

 
 "SELECT lp.nome_premio FROM premio p " +
                               "JOIN lista_premios lp ON p.nome_premio_id = lp.nome_premio_id " +
                               "WHERE p.content_id = @contentId";


                                SqlCommand command = new SqlCommand(
                                "SELECT MAX(num_episodio) " +
                                "FROM episodio " +
                                "INNER JOIN temporada ON episodio.season_id = temporada.season_id " +
                                "INNER JOIN serie_televisiva ON temporada.content_id = serie_televisiva.content_id " +
                                "WHERE episodio.season_id = @seasonId AND serie_televisiva.content_id = @contentId;", conn);




                                            string query = "INSERT INTO personagem (personagem_id, nome, papel) VALUES (@personagemId, @nome, @papel)";



            string query = "INSERT INTO figura_em (content_id, personagem_id) VALUES (@contentId, @personagemId)";


                SqlCommand command = new SqlCommand("SELECT serie_televisiva.content_id, serie_televisiva.nome, temporada.numero_season FROM serie_televisiva INNER JOIN temporada ON serie_televisiva.content_id = temporada.content_id;", conn);


            string query = "SELECT ISNULL(MAX(estudio_id), 0) + 1 FROM estudio";


                SqlCommand seasonCheckCommand = new SqlCommand("SELECT COUNT(*) FROM temporada WHERE season_id = @seasonId AND content_id = @contentId;", conn);


 SqlCommand command = new SqlCommand("INSERT INTO episodio (num_episodio, season_id, runtime, synopsis, data_estreia, rating) " +
                                                        "VALUES (@numEpisodio, @seasonId, @runtime, @synopsis, @dataEstreia, @rating);", conn);




                                                                        string query = "SELECT COUNT(*) FROM utilizador WHERE nome = @username AND password = @password";



                string query = "SELECT content_id, nome FROM serie_televisiva";


            string query = "SELECT ISNULL(MAX(season_id), 0) + 1 FROM temporada";



                string query = "SELECT c.content_id, c.nome, f.runtime, f.synopsis, f.data_estreia, f.rating, s.nome AS serie_nome, s.synopsis AS serie_synopsis, s.rating AS serie_rating " +
                               "FROM conteudo c " +
                               "INNER JOIN estudio e ON c.estudio_id = e.estudio_id " +
                               "LEFT JOIN Filme f ON c.content_id = f.content_id " +
                               "LEFT JOIN serie_televisiva s ON c.content_id = s.content_id " +
                               "WHERE c.nome LIKE @nome ";



                               string query = "SELECT c.content_id, c.nome, f.runtime, f.synopsis, f.data_estreia, f.rating, s.nome AS serie_nome, s.synopsis AS serie_synopsis, s.rating AS serie_rating " +
                               "FROM conteudo c " +
                               "LEFT JOIN Filme f ON c.content_id = f.content_id " +
                               "LEFT JOIN serie_televisiva s ON c.content_id = s.content_id"