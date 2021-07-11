/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     BEResultaatBL.cs

Omschrijving:    Business Logic Layer Backend Resultaat(en) Vestingloop

\************************************************************************/

using System.Collections.Generic;
using System.Data;              //Voor de klasse DataSet, Datatable en SQL

namespace Vestingloop2018
{
    public class BEResultaatBL
    {
        //constructor
        public BEResultaatBL()
        {

        }

        public int CreateFE(FEResultaatBO resultaat)
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            return resultaatDAL.CreateFE(resultaat);
        }

        public int CreateBE(BEResultaatBO resultaat)
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            return resultaatDAL.CreateBE(resultaat);
        }

        public int UpdateFE(FEResultaatBO resultaat)
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            return resultaatDAL.UpdateFE(resultaat);
        }

        public int UpdateBE(BEResultaatBO resultaat)
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            return resultaatDAL.UpdateBE(resultaat);
        }

        public int DeleteFE(List<int> selectedResultaten)
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            return resultaatDAL.DeleteFE(selectedResultaten);
        }

        public int DeleteBE(List<int> selectedResultaten)
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            return resultaatDAL.DeleteBE(selectedResultaten);
        }

        public void DeleteAllFE()
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            resultaatDAL.DeleteAllFE();
        }

        public void DeleteAllBE()
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            resultaatDAL.DeleteAllBE();
        }

        public DataSet ReadFE()
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            return resultaatDAL.ReadFE();
        }

        public DataSet ReadBE()
        {
            BEResultaatDA resultaatDAL = new BEResultaatDA();
            return resultaatDAL.ReadBE();
        }
    }
}
