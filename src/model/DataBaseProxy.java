/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import control.Igra;
import java.lang.System.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JOptionPane;
/**
 *
 * @author stefa
 */
public class DataBaseProxy {
    Connection c;
    public DataBaseProxy()
    {
        try{
             c = DriverManager.getConnection("jdbc:ucanaccess://src\\Resources\\Mastermind.accdb");
        }
        catch(SQLException ex)
        {
            System.out.println("Greska sa bazom");
            JOptionPane.showMessageDialog(null, "Ne mogu da se povezem sa bazom", "Greska", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public ArrayList<String> getPrevGames()
    {
        ArrayList<String> games = new ArrayList<String>();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Igra");
            while(rs.next())
            {
                games.add(rs.getString("Datum")+","+rs.getString("Igrac"));
            }
            return games;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DataBaseProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void saveGame(Igra igr)
    {
        PreparedStatement myStmt; 
        try {
            myStmt = c.prepareStatement("INSERT INTO Igra(Datum,Igrac,igracevPotez,ZamisljenBr) VALUES (NOW(),?,?,?)");
            myStmt.setString(1,igr.user);
            myStmt.setInt(2,igr.pokusaj);
            myStmt.setInt(3,igr.rnd);
            ResultSet myRs= myStmt.executeQuery();  
        } 
        catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DataBaseProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
