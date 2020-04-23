/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.mtriaje;
import app_citas_historial_ant.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UNSAAC
 */
public class DAOtriaje {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_triaje(String pbuscar)
    {
        DefaultTableModel modelo_triaje;
        String[]titulos={   "id_triaje",
                            "peso",
                            "talla",
                            "presion_sanguinea",
                            "nivel",
                            "color",
                            "categoria",
                            "tiempo_atencion",
                            "detalles"};
        Object[]registro=new Object[titulos.length];
        modelo_triaje=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_triaje (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_triaje");
                registro[1]=rs.getString("peso");                
                registro[2]=rs.getString("talla");                
                registro[3]=rs.getString("presion_sanguinea");                
                registro[4]=rs.getString("nivel");                
                registro[5]=rs.getString("color");                
                registro[6]=rs.getString("categoria");                
                registro[7]=rs.getString("tiempo_atencion");                
                registro[8]=rs.getString("detalles");                
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_triaje.addRow(registro);
            }
            return modelo_triaje;
        }
        
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    //insertar
    public String insertar_triaje(mtriaje omtriaje)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_triaje(?,?,?,?,?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setDouble(1, omtriaje.getPeso());
            cst.setDouble(2, omtriaje.getTalla());
            cst.setDouble(3, omtriaje.getPresion_sanguinea());
            cst.setString(4, omtriaje.getNivel());
            cst.setString(5, omtriaje.getColor());
            cst.setString(6, omtriaje.getCategoria());
            cst.setString(7, omtriaje.getTiempo_atencion());
            cst.setString(8, omtriaje.getDetalles());
            ///////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("@mensaje");
                registro[1]=rs.getString("@id_error");
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                verificacion.addRow(registro);
            }
            return verificacion.getValueAt(0,0).toString();
            ///////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////
            
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return "error al insertar";
        }
    }   
    public String modificar_triaje(mtriaje omtriaje)
    {
        query="call usp_modificar_triaje(?,?,?,?,?,?,?,?,?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omtriaje.getId_triaje());
            cst.setDouble(2, omtriaje.getPeso());
            cst.setDouble(3, omtriaje.getTalla());
            cst.setDouble(4, omtriaje.getPresion_sanguinea());
            cst.setString(5, omtriaje.getNivel());
            cst.setString(6, omtriaje.getColor());
            cst.setString(7, omtriaje.getCategoria());
            cst.setString(8, omtriaje.getTiempo_atencion());
            cst.setString(9, omtriaje.getDetalles());
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("@mensaje");
                registro[1]=rs.getString("@id_error");
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                verificacion.addRow(registro);
            }
            return verificacion.getValueAt(0,0).toString();
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return "error al insertar";
        }      
    }
    public String eliminar_triaje(mtriaje omtriaje)
    {
        query="call usp_eliminar_triaje(?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omtriaje.getId_triaje());
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("@mensaje");
                registro[1]=rs.getString("@id_error");
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                verificacion.addRow(registro);
            }
            return verificacion.getValueAt(0,0).toString();
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return "error al eliminar";
        }
    }
}
