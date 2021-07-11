/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstVerenigingBL.cs

Omschrijving:    Business Logic LijstVereniging

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
    public class LijstVerenigingBL
    {
        public LijstVerenigingBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            LijstVerenigingDA LijstVerenigingDA = new LijstVerenigingDA();
            return LijstVerenigingDA.Read();
        }

        public DataSet Select(string selectInstrumentenGroep)
        {
            LijstVerenigingDA LijstVerenigingDA = new LijstVerenigingDA();
            return LijstVerenigingDA.Select(selectInstrumentenGroep);
        }

        public DataSet Sort(List<string> filterLijstVereniging)
        {
            LijstVerenigingDA LijstVerenigingDA = new LijstVerenigingDA();
            return LijstVerenigingDA.Sort(filterLijstVereniging);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterLijstVereniging)
        {
            LijstVerenigingDA LijstVerenigingDA = new LijstVerenigingDA();
            return LijstVerenigingDA.Group(filterLijstVereniging);
        }
    }
}
