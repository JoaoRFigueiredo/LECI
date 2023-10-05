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
    public partial class episodioForm : Form
    {
        int episodio_id;
        public episodioForm(int id)
        {
            InitializeComponent();
            episodio_id = id;
            MessageBox.Show(episodio_id.ToString());
        }
    }
}
