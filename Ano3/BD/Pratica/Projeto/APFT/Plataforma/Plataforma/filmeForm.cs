using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;

namespace Plataforma
{
    public partial class filmeForm : Form
    {
        int filme_id;
        public filmeForm(int id)
        {
            InitializeComponent();
            filme_id = id;
            MessageBox.Show(filme_id.ToString());
        }


    }
}
