/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     PersoonBL.cs

Omschrijving:    Business Logic Persoon

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
    public class PersoonBL
    {
        public PersoonBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            PersoonDA persoonDA = new PersoonDA();
            return persoonDA.Read();
        }

        public int Create(PersoonBO persoon)
        {
            PersoonDA persoonDA = new PersoonDA();
            return persoonDA.Create(persoon);
        }

        public int Update(PersoonBO persoon)
        {
            PersoonDA persoonDA = new PersoonDA();
            return persoonDA.Update(persoon);
        }

        public int Delete(List<int> selectedPersonen)
        {
            PersoonDA persoonDA = new PersoonDA();
            return persoonDA.Delete(selectedPersonen);
        }

        public void DeleteAll()
        {
            PersoonDA persoonDA = new PersoonDA();
            persoonDA.DeleteAll();
        }

        public DataSet Select(List<string> selectPersonen)
        {
            PersoonDA persoonDA = new PersoonDA();
            return persoonDA.Select(selectPersonen);
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterPersooon)
        {
            PersoonDA persoonDA = new PersoonDA();
            return persoonDA.Sort(selectedColumns, filterPersooon);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterPersoon)
        {
            PersoonDA persoonDA = new PersoonDA();
            return persoonDA.Group(selectedColumns, filterPersoon);
        }
    }
}
