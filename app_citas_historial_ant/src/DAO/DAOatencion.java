/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.matencion;
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
public class DAOatencion {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_atencion(String pbuscar)
    {
        DefaultTableModel modelo_atencion;
        String[]titulos={   "id_atencion",
                            "id_reserva",
                            "id_triaje",
                            //"id_medico",
                            "diagnostico",
                            "hora_atencion"};
        Object[]registro=new Object[titulos.length];
        modelo_atencion=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_atencion (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_atencion");
                registro[1]=rs.getString("id_reserva");                
                registro[2]=rs.getString("id_triaje");                
                //registro[3]=rs.getString("id_medico");                
                registro[3]=rs.getString("diagnostico");                
                registro[4]=rs.getString("hora_atencion");                
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_atencion.addRow(registro);
            }
            return modelo_atencion;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    //insertar
    public String insertar_atencion(matencion omatencion)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_atencion(?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1, omatencion.getId_reserva());
            cst.setInt(2, omatencion.getId_triaje());
            //cst.setInt(4, omatencion.getId_medico());
            cst.setString(3, omatencion.getDiagnostico());
            cst.setString(4, omatencion.getHora_atencion());
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
    public String modificar_atencion(matencion omatencion)
    {
        query="call usp_modificar_atencion(?,?,?,?,?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omatencion.getId_atencion());
            cst.setInt(2,omatencion.getId_reserva());
            cst.setInt(3,omatencion.getId_triaje());
            //cst.setInt(4,omatencion.getId_medico());
            cst.setString(4,omatencion.getDiagnostico());
            cst.setString(5,omatencion.getHora_atencion());
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
    public String eliminar_atencion(matencion omatencion)
    {
        query="call usp_eliminar_atencion(?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omatencion.getId_atencion());
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
