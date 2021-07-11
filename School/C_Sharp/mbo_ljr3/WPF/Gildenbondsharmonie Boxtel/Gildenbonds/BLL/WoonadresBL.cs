/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     WoonadresBL.cs

Omschrijving:    Business Logic voor Woonadressen

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
    public class WoonadresBL
    {
        //constructor
        public WoonadresBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            WoonadresDA WoonadresDA = new WoonadresDA();
            return WoonadresDA.Read();
        }

        public int Create(WoonadresBO Woonadres)
        {
            WoonadresDA WoonadresDA = new WoonadresDA();
            return WoonadresDA.Create(Woonadres);
        }

        public int Update(WoonadresBO Woonadres)
        {
            WoonadresDA WoonadresDA = new WoonadresDA();
            return WoonadresDA.Update(Woonadres);
        }

        public int Delete(List<int> selectedWoonadresen)
        {
            WoonadresDA WoonadresDA = new WoonadresDA();
            return WoonadresDA.Delete(selectedWoonadresen);
        }

        public void DeleteAll()
        {
            WoonadresDA WoonadresDA = new WoonadresDA();
            WoonadresDA.DeleteAll();
        }

        public DataSet Select(List<string> selectWoonadresen)
        {
            WoonadresDA WoonadresDA = new WoonadresDA();
            return WoonadresDA.Select(selectWoonadresen);
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterWoonadres)
        {
            WoonadresDA WoonadresDA = new WoonadresDA();
            return WoonadresDA.Sort(selectedColumns, filterWoonadres);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterWoonadres)
        {
            WoonadresDA WoonadresDA = new WoonadresDA();
            return WoonadresDA.Group(selectedColumns, filterWoonadres);
        }

    }
}
