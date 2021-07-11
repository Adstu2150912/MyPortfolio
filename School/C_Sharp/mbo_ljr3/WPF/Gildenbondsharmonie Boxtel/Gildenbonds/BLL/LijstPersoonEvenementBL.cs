/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstPersoonEvenementBL.cs

Omschrijving:    Business Logic LijstPersoonEvenement

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
    public class LijstPersoonEvenementBL
    {
        public LijstPersoonEvenementBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            LijstPersoonEvenementDA LijstPersoonEvenementDA = new LijstPersoonEvenementDA();
            return LijstPersoonEvenementDA.Read();
        }

        public DataSet Sort(List<string> filterLijstPersoonEvenement)
        {
            LijstPersoonEvenementDA LijstPersoonEvenementDA = new LijstPersoonEvenementDA();
            return LijstPersoonEvenementDA.Sort(filterLijstPersoonEvenement);
        }
    }
}
