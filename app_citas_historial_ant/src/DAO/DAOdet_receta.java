/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.mdet_receta;
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
public class DAOdet_receta {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_det_receta(String pbuscar)
    {
        DefaultTableModel modelo_det_receta;
        String[]titulos={   "id_det_receta",
                            "cantidad",
                            "dosis",
                            "frecuencia",
                            "id_medicamento",
                            "id_receta"};
        Object[]registro=new Object[titulos.length];
        modelo_det_receta=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_det_receta (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_det_receta");
                registro[1]=rs.getString("cantidad");                
                registro[2]=rs.getString("dosis");                
                registro[3]=rs.getString("frecuencia");                
                registro[4]=rs.getString("id_medicamento");                
                registro[5]=rs.getString("id_receta");                
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_det_receta.addRow(registro);
            }
            return modelo_det_receta;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    //insertar
    public String insertar_det_receta(mdet_receta omdet_receta)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_det_receta(?,?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1, omdet_receta.getCantidad());
            cst.setString(2, omdet_receta.getDosis());
            cst.setString(3, omdet_receta.getFrecuencia());
            cst.setInt(4, omdet_receta.getId_medicamento());
            cst.setInt(5, omdet_receta.getId_receta());
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
    public String modificar_det_receta(mdet_receta omdet_receta)
    {
        query="call usp_modificar_det_receta(?,?,?,?,?,?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omdet_receta.getId_det_receta());
            cst.setInt(2,omdet_receta.getCantidad());
            cst.setString(3,omdet_receta.getDosis());
            cst.setString(4,omdet_receta.getFrecuencia());
            cst.setInt(5,omdet_receta.getId_medicamento());
            cst.setInt(6,omdet_receta.getId_receta());
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
    public String eliminar_det_receta(mdet_receta omdet_receta)
    {
        query="call usp_eliminar_det_receta(?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omdet_receta.getId_det_receta());
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
