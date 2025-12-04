package edu.loyola.cs485.gfbb;
import edu.loyola.cs485.gfbb.gui.MainFrame;
import java.sql.*;

public class Main {
    static String ConUrl = "jdbc:mysql://localhost"; //protocol + url
    static String Port = "3306"; //default MySQL port
    static String Database = "restaurant_db"; // database/schema name
    static String Username = "admin"; //read this from a local file
    static String Password = "MvHUzGfa0t1xl0"; //Also read this from a file

    static String url = ConUrl+":"+Port+"/"+Database+ "?user="+Username+"&password="+Password;

    public static void main(String[] args) {
    MainFrame frame = new MainFrame();
    frame.setVisible(true);
    }
}