/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     JubileaBL.cs

Omschrijving:    Business Logic Jubilea

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;      //Voor de klasse DataSet, Datatable en SQL
using Gildenbondsharmonie.BOL; //Voor gebruik van Business objecten
using Gildenbondsharmonie.DAL; //Voor gebruik van Data Access objecten

namespace Gildenbondsharmonie.BLL
{
    public class JubileaBL
    {
        //constructor
        public JubileaBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            JubileaDA jubileaDA = new JubileaDA();
            return jubileaDA.Read();
        }

        public int Create(JubileaBO instrument)
        {
            JubileaDA jubileaDA = new JubileaDA();
            return jubileaDA.Create(instrument);
        }

        public int Update(JubileaBO jubilea)
        {
            JubileaDA jubileaDA = new JubileaDA();
            return jubileaDA.Update(jubilea);
        }

        public int Delete(List<int> selectJubilarissen, List<int> selectVerenigingsleden)
        {
            JubileaDA jubileaDA = new JubileaDA();
            return jubileaDA.Delete(selectJubilarissen, selectVerenigingsleden);
        }

        public void DeleteAll()
        {
            JubileaDA jubileaDA = new JubileaDA();
            jubileaDA.DeleteAll();
        }

        public DataSet Select(List<string> selectJubilarissen)
        {
            JubileaDA jubileaDA = new JubileaDA();
            return jubileaDA.Select(selectJubilarissen);
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterJubilea)
        {
            JubileaDA jubileaDA = new JubileaDA();
            return jubileaDA.Sort(selectedColumns, filterJubilea);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterJubilea)
        {
            JubileaDA jubileaDA = new JubileaDA();
            return jubileaDA.Group(selectedColumns, filterJubilea);
        }

    }
}
