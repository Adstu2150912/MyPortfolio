/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     VerenigingslidBL.cs

Omschrijving:    Business Logic Verenigingslid

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
    public class VerenigingslidBL
    {
        public VerenigingslidBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            VerenigingslidDA VerenigingslidDA = new VerenigingslidDA();
            return VerenigingslidDA.Read();
        }

        public int Create(VerenigingslidBO Verenigingslid)
        {
            VerenigingslidDA VerenigingslidDA = new VerenigingslidDA();
            return VerenigingslidDA.Create(Verenigingslid);
        }

        public int Update(VerenigingslidBO Verenigingslid)
        {
            VerenigingslidDA VerenigingslidDA = new VerenigingslidDA();
            return VerenigingslidDA.Update(Verenigingslid);
        }

        public int Delete(List<int> selectedVerenigingsliden)
        {
            VerenigingslidDA VerenigingslidDA = new VerenigingslidDA();
            return VerenigingslidDA.Delete(selectedVerenigingsliden);
        }

        public void DeleteAll()
        {
            VerenigingslidDA VerenigingslidDA = new VerenigingslidDA();
            VerenigingslidDA.DeleteAll();
        }

        public DataSet Select(List<string> selectVerenigingsliden)
        {
            VerenigingslidDA VerenigingslidDA = new VerenigingslidDA();
            return VerenigingslidDA.Select(selectVerenigingsliden);
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterVerenigingslid)
        {
            VerenigingslidDA VerenigingslidDA = new VerenigingslidDA();
            return VerenigingslidDA.Sort(selectedColumns, filterVerenigingslid);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterVerenigingslid)
        {
            VerenigingslidDA VerenigingslidDA = new VerenigingslidDA();
            return VerenigingslidDA.Group(selectedColumns, filterVerenigingslid);
        }
    }
}
