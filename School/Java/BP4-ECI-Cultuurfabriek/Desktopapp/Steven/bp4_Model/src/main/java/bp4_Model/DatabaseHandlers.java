/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp4_Model;

import bp4_Model.Database.DatabaseConnection;
import bp4_Model.Database.Emails;
import bp4_Model.Database.Gebruikers;
import bp4_Model.Database.Reserveringen;

/**
 *
 * @author swkoe
 */
public class DatabaseHandlers
{
    public static DatabaseConnection connection;
    public static Emails emails;
    public static Gebruikers gebruikers;
    public static Reserveringen reserveringen;
}
