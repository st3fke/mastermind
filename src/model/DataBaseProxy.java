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
        try {
            PreparedStatement myStmt; 
            myStmt = c.prepareStatement("INSERT INTO Igra(Datum,Igrac,igracevPotez,ZamisljenBr) VALUES (NOW(),?,?,?)");
            myStmt.setString(1,igr.user);
            myStmt.setInt(2,igr.pokusaj);
            myStmt.setInt(3,igr.rnd);
            myStmt.execute();  
        } 
        catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DataBaseProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Igra loadGame(String date, String name)
    {
        try {
            Igra igr = new Igra();
            PreparedStatement myStmt; 
            myStmt = c.prepareStatement("SELECT * FROM Igra WHERE Datum = ? AND Igrac = ?");
            myStmt.setString(1,date);
            myStmt.setString(2,name);
            ResultSet rs = myStmt.executeQuery();
            while(rs.next())
            {
                igr.user = rs.getString("Igrac");
                igr.pokusaj = rs.getInt("igracevPotez");
                igr.rnd = rs.getInt("ZamisljenBr");
            }
            return igr;
        } 
        catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DataBaseProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
