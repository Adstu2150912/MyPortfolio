/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     InstrumentBL.cs

Omschrijving:    Business Logic Instrument

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
    public class InstrumentBL
    {
        //constructor
        public InstrumentBL()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            InstrumentDA instrumentDA = new InstrumentDA();
            return instrumentDA.Read();
        }

        public int Create(InstrumentBO instrument)
        {
            InstrumentDA instrumentDA = new InstrumentDA();
            return instrumentDA.Create(instrument);
        }

        public int Update(InstrumentBO instrument)
        {
            InstrumentDA instrumentDA = new InstrumentDA();
            return instrumentDA.Update(instrument);
        }

        public int Delete(List<int> selectedinstrumenten)
        {
            InstrumentDA instrumentDA = new InstrumentDA();
            return instrumentDA.Delete(selectedinstrumenten);
        }

        public void DeleteAll()
        {
            InstrumentDA instrumentDA = new InstrumentDA();
            instrumentDA.DeleteAll();
        }

        public DataSet Select(List<string> selectinstrumenten)
        {
            InstrumentDA instrumentDA = new InstrumentDA();
            return instrumentDA.Select(selectinstrumenten);
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterinstrument)
        {
            InstrumentDA instrumentDA = new InstrumentDA();
            return instrumentDA.Sort(selectedColumns, filterinstrument);
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterinstrument)
        {
            InstrumentDA instrumentDA = new InstrumentDA();
            return instrumentDA.Group(selectedColumns, filterinstrument);
        }
    }
}
