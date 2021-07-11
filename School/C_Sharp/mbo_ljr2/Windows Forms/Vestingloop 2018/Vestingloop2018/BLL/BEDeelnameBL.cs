/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     BEDeelnameBO.cs

Omschrijving:    Business Logic Layer Backend Deelname(s) Vestingloop

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;              //Voor de klasse DataSet, Datatable en SQL

namespace Vestingloop2018
{
    public class BEDeelnameBL
    {
        //constructor
        public BEDeelnameBL()
        {

        }

        public int CreateFE(FEDeelnameBO deelname)
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            return deelnameDAL.CreateFE(deelname);
        }

        public int CreateBE(BEDeelnameBO deelname)
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            return deelnameDAL.CreateBE(deelname);
        }

        public int UpdateFE(FEDeelnameBO deelname)
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            return deelnameDAL.UpdateFE(deelname);
        }

        public int UpdateBE(BEDeelnameBO deelname)
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            return deelnameDAL.UpdateBE(deelname);
        }

        public int DeleteFE(List<int> selectedDeelnamens)
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            return deelnameDAL.DeleteFE(selectedDeelnamens);
        }

        public int DeleteBE(List<int> selectedDeelnamens)
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            return deelnameDAL.DeleteBE(selectedDeelnamens);
        }

        public void DeleteAllFE()
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            deelnameDAL.DeleteAllFE();
        }

        public void DeleteAllBE()
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            deelnameDAL.DeleteAllBE();
        }

        public DataSet ReadFE()
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            return deelnameDAL.ReadFE();
        }

        public DataSet ReadBE()
        {
            BEDeelnameDA deelnameDAL = new BEDeelnameDA();
            return deelnameDAL.ReadBE();
        }

    }
}
