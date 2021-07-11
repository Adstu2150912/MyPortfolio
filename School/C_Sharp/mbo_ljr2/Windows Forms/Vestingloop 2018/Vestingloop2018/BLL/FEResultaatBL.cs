/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     FEResultaatBL.cs

Omschrijving:    Business Logic Layer Frontend Resultaat(en) Vestingloop

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;              //Voor de klasse DataSet, Datatable en SQL
using System.Windows.Forms;

namespace Vestingloop2018
{
    public class FEResultaatBL
    {
        //Constructor
        public FEResultaatBL()
        {

        }

        public DataSet Read()
        {
            FEResultaatDA resultaatDAL = new FEResultaatDA();
            return resultaatDAL.Read();
        }

        public DataSet Group(List<string> groepResultaat)
        {
            FEResultaatDA resultaatDAL = new FEResultaatDA();
            return resultaatDAL.Group(groepResultaat);
        }

        public DataSet Filter(ListView.ColumnHeaderCollection selectedColumns, List<string> filterResultaat)
        {
            FEResultaatDA resultaatDAL = new FEResultaatDA();
            return resultaatDAL.Sort(selectedColumns, filterResultaat);
        }
    }
}
