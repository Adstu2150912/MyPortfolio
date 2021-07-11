/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     EvenementBL.cs

Omschrijving:    Business Logic Evenement

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
    public class EvenementBL
    {
        //constructor
        public EvenementBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            EvenementDA evenementDA = new EvenementDA();
            return evenementDA.Read();
        }

        public int Create(EvenementBO evenement)
        {
            EvenementDA evenementDA = new EvenementDA();
            return evenementDA.Create(evenement);
        }

        public int Update(EvenementBO evenement)
        {
            EvenementDA evenementDA = new EvenementDA();
            return evenementDA.Update(evenement);
        }

        public int Delete(List<int> selectedEvenementen, List<int> selectedVerenigingsleden)
        {
            EvenementDA evenementDA = new EvenementDA();
            return evenementDA.Delete(selectedEvenementen, selectedVerenigingsleden);
        }

        public void DeleteAll()
        {
            EvenementDA evenementDA = new EvenementDA();
            evenementDA.DeleteAll();
        }

        public DataSet Select(List<string> selectEvenementen)
        {
            EvenementDA evenementDA = new EvenementDA();
            return evenementDA.Select(selectEvenementen);
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterEvenement)
        {
            EvenementDA evenementDA = new EvenementDA();
            return evenementDA.Sort(selectedColumns, filterEvenement);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterEvenement)
        {
            EvenementDA evenementDA = new EvenementDA();
            return evenementDA.Group(selectedColumns, filterEvenement);
        }
    }
}
