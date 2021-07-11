/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstGroepBL.cs

Omschrijving:    Business Logic LijstGroep

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
    public class LijstGroepBL
    {
        public LijstGroepBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            LijstGroepDA LijstGroepDA = new LijstGroepDA();
            return LijstGroepDA.Read();
        }

        public DataSet Select(string selectGroep)
        {
            LijstGroepDA LijstGroepDA = new LijstGroepDA();
            return LijstGroepDA.Select(selectGroep);
        }

        public DataSet Sort(List<string> filterLijstGroep)
        {
            LijstGroepDA LijstGroepDA = new LijstGroepDA();
            return LijstGroepDA.Sort(filterLijstGroep);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterLijstGroep)
        {
            LijstGroepDA LijstGroepDA = new LijstGroepDA();
            return LijstGroepDA.Group(filterLijstGroep);
        }
    }
}
