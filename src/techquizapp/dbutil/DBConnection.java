/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tasmi
 */
public class DBConnection {
    private static Connection conn;//static isliye qk static block se call krwaenge//1 bar chlana h isliye static block ke andar ,const nhi qk obj bnana padhta
    static
    {     
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            ArrayList<String> connDetails=ConnectionDetails.getConnectionDetails();
            conn=DriverManager.getConnection(connDetails.get(0),connDetails.get(1),connDetails.get(2));
            JOptionPane.showMessageDialog(null, "Connected successfully to the DB");

        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Cannot connect to DB");
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
             conn.close();
             JOptionPane.showMessageDialog(null,"Disconnected successfully to the DB","Success!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Cannot disconnect with the DB");
            ex.printStackTrace();
        } }

    
}
