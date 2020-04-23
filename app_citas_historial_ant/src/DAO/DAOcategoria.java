/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.mcategoria;
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
public class DAOcategoria {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_categoria(String pbuscar)
    {
        DefaultTableModel modelo_categoria;
        String[]titulos={   "id_categoria",
                            "nombre",
                            "creado_en"};
        Object[]registro=new Object[titulos.length];
        modelo_categoria=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_categoria (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_categoria");
                registro[1]=rs.getString("nombre");                
                registro[2]=rs.getString("creado_en");                
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_categoria.addRow(registro);
            }
            return modelo_categoria;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    //insertar
    public String insertar_categoria(mcategoria omcategoria)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_categoria(?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString (1, omcategoria.getNombre());
            cst.setString (2, omcategoria.getCreado_en());
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
    public String modificar_categoria(mcategoria omcategoria)
    {
        query="call usp_modificar_categoria(?,?,?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omcategoria.getId_categoria());
            cst.setString(2,omcategoria.getNombre());
            cst.setString(3,omcategoria.getCreado_en());
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
            return "error al modificar";
        }      
    }
    public String eliminar_categoria(mcategoria omcategoria)
    {
        query="call usp_eliminar_categoria(?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omcategoria.getId_categoria());
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
