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
    public partial class filtersForm : Form
    {
        public filtersForm()
        {
            InitializeComponent();
        }

        public delegate void FilterAppliedCallback(string filterJson);
        public FilterAppliedCallback OnFilterApplied;
        private void filterButton_Click(object sender, EventArgs e)
        {
            string order = "";
            string person = "";
            if(!string.IsNullOrEmpty(orderCombo.SelectedItem?.ToString()))
            {
                order = orderCombo.SelectedItem?.ToString();
            }

            if (!string.IsNullOrEmpty(personTextBox.Text))
            {
                person = personTextBox.Text;
            }
            
            
            List<string> genres = new List<string>();

            if (genresCheckListBox.CheckedItems.Count > 0)
            {
                foreach (string item in genresCheckListBox.CheckedItems)
                {
                    genres.Add(item.ToString());
                }
            }

            string[] genresArray = genres.ToArray();

            var filterData = new
            {
                Order = order,
                Person = person,
                Genres = genresArray,
            };

            string filterJson = JsonSerializer.Serialize(filterData);
            filterJson = filterJson.Replace("\\", "\\\\"); // Escape backslashes

            // Invoke the callback function
            OnFilterApplied?.Invoke(filterJson);

            this.Close();
        }



    }
}
