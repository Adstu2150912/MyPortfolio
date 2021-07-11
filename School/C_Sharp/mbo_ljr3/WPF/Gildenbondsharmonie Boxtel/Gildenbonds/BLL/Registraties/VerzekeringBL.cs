/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     VerzekeringBL.cs

Omschrijving:    Business Logic voor verzekeringen

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
    public class VerzekeringBL
    {
        //constructor
        public VerzekeringBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            VerzekeringDA VerzekeringDA = new VerzekeringDA();
            return VerzekeringDA.Read();
        }

        public int Create(VerzekeringBO Verzekering)
        {
            VerzekeringDA VerzekeringDA = new VerzekeringDA();
            return VerzekeringDA.Create(Verzekering);
        }

        public int Update(VerzekeringBO Verzekering)
        {
            VerzekeringDA VerzekeringDA = new VerzekeringDA();
            return VerzekeringDA.Update(Verzekering);
        }

        public int Delete(List<int> selectedVerzekeringen)
        {
            VerzekeringDA VerzekeringDA = new VerzekeringDA();
            return VerzekeringDA.Delete(selectedVerzekeringen);
        }

        public void DeleteAll()
        {
            VerzekeringDA VerzekeringDA = new VerzekeringDA();
            VerzekeringDA.DeleteAll();
        }

        public DataSet Select(List<string> selectVerzekeringen)
        {
            VerzekeringDA VerzekeringDA = new VerzekeringDA();
            return VerzekeringDA.Select(selectVerzekeringen);
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterVerzekering)
        {
            VerzekeringDA VerzekeringDA = new VerzekeringDA();
            return VerzekeringDA.Sort(selectedColumns, filterVerzekering);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterVerzekering)
        {
            VerzekeringDA VerzekeringDA = new VerzekeringDA();
            return VerzekeringDA.Group(selectedColumns, filterVerzekering);
        }
    }
}
