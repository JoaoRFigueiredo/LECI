using System.Drawing.Text;

namespace Plataforma
{
    internal static class Program
    {
        /// <summary>
        ///  The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {

           

            // To customize application configuration such as set high DPI settings or default font,
            // see https://aka.ms/applicationconfiguration.
            Movies_db db = Movies_db.Instance;
            List<string> movies = db.GetAllMovies();
            ApplicationConfiguration.Initialize();
            Application.Run(new HomeForm());
        }
    }
}