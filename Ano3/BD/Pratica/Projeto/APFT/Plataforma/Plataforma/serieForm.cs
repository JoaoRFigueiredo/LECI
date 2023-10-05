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
    public partial class serieForm : Form
    {
        int serie_id;
        public serieForm(int id)
        {
            InitializeComponent();
            serie_id = id;
            MessageBox.Show(serie_id.ToString());
        }

        private void selectButton_Click(object sender, EventArgs e)
        {
            var episodioForm = new episodioForm(10);
            episodioForm.ShowDialog();
        }

        private void addReview_Click(object sender, EventArgs e)
        {
            var reviewForm = new reviewForm(123);
            reviewForm.ShowDialog();
        }
    }
}
