package app_citas_historial_ant;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author UNSAAC
 */
public class Conexion {
    public String db="bd_cita_medica";
    public String url="jdbc:mysql://127.0.0.1/"+db;
    public String user="root";
    //public String pass="";
    //public String pass="123456";
    //public String url="jdbc:mysql://localhost:2048/"+db;
    //public String url="jdbc:mysql://localhost:3306/"+db;
    public String pass="100%f0r3v3r@L0n3";
    public String serverTimezone="-5";
    public Conexion(){        
    }
    //metodos
    public Connection conectar()
    {
        Connection link=null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            link=DriverManager.getConnection(this.url,this.user,this.pass);
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            JOptionPane.showConfirmDialog(null,e);
        }
        return link;
    }
    
}
