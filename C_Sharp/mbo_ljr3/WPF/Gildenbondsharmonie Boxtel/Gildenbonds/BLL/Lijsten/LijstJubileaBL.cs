/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstJubileaBL.cs

Omschrijving:    Business Logic LijstJubilea

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
    public class LijstJubileaBL
    {
        public LijstJubileaBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            LijstJubileaDA LijstJubileaDA = new LijstJubileaDA();
            return LijstJubileaDA.Read();
        }

        public DataSet FilterLidmaatschap(int lidmaatschap)
        {
            LijstJubileaDA LijstJubileaDA = new LijstJubileaDA();
            return LijstJubileaDA.FilterJaarLidmaatschap(lidmaatschap);
        }

        public DataSet Sort(List<string> filterLijstJubilea)
        {
            LijstJubileaDA LijstJubileaDA = new LijstJubileaDA();
            return LijstJubileaDA.Sort(filterLijstJubilea);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterLijstJubilea)
        {
            LijstJubileaDA LijstJubileaDA = new LijstJubileaDA();
            return LijstJubileaDA.Group(filterLijstJubilea);
        }
    }
}
