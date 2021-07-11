/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstVerjaardagBL.cs

Omschrijving:    Business Logic LijstVerjaardag

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;              //Voor de klasse DataSet, Datatable en SQL
using Gildenbondsharmonie.BOL; //Voor gebruik van Business objecten
using Gildenbondsharmonie.DAL; //Voor gebruik van Data Access objecten

namespace Gildenbondsharmonie.BLL
{
    public class LijstVerjaardagBL
    {
        public LijstVerjaardagBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            LijstVerjaardagDA LijstVerjaardagDA = new LijstVerjaardagDA();
            return LijstVerjaardagDA.Read();
        }

        public DataSet Sort(List<string> filterLijstVerjaardag)
        {
            LijstVerjaardagDA LijstVerjaardagDA = new LijstVerjaardagDA();
            return LijstVerjaardagDA.Sort(filterLijstVerjaardag);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterLijstVerjaardag)
        {
            LijstVerjaardagDA LijstVerjaardagDA = new LijstVerjaardagDA();
            return LijstVerjaardagDA.Group(filterLijstVerjaardag);
        }
    }
}
