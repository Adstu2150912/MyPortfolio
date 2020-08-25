/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     FEDeelnameBO.cs

Omschrijving:    Business Logic Layer Frontend Deelname(s) Vestingloop

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
    public class FEDeelnameBL
    {
        //Constructor
        public FEDeelnameBL()
        {

        }

        public DataSet Read()
        {
            FEDeelnameDA deelnameDAL = new FEDeelnameDA();
            return deelnameDAL.Read();
        }

        public DataSet Group(List<string> groepDeelname)
        {
            FEDeelnameDA deelnameDAL = new FEDeelnameDA();
            return deelnameDAL.Group(groepDeelname);
        }

        public DataSet Filter(ListView.ColumnHeaderCollection selectedColumns, List<string> filterDeelname)
        {
            FEDeelnameDA deelnameDAL = new FEDeelnameDA();
            return deelnameDAL.Sort(selectedColumns, filterDeelname);
        }
    }
}
