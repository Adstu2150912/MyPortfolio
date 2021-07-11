/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstKNMOBL.cs

Omschrijving:    Business Logic LijstKNMO

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
    public class LijstKNMOBL
    {
        public LijstKNMOBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            LijstKNMODA LijstKNMODA = new LijstKNMODA();
            return LijstKNMODA.Read();
        }

        public DataSet Select(int selectJaar)
        {
            LijstKNMODA LijstKNMODA = new LijstKNMODA();
            return LijstKNMODA.Select(selectJaar);
        }

        public DataSet Sort(List<string> filterLijstKNMO)
        {
            LijstKNMODA LijstKNMODA = new LijstKNMODA();
            return LijstKNMODA.Sort(filterLijstKNMO);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterLijstKNMO)
        {
            LijstKNMODA LijstKNMODA = new LijstKNMODA();
            return LijstKNMODA.Group(filterLijstKNMO);
        }
    }
}
