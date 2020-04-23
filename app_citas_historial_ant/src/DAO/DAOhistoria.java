/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.mhistoria;
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
public class DAOhistoria {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_historia(String pbuscar)
    {
        DefaultTableModel modelo_historia;
        String[]titulos={   "id_historia",
                            "id_paciente",
                            "nombre_clinica",
                            "creado_en",
                            "id_usuario",
                            "id_antecedente"};
        Object[]registro=new Object[titulos.length];
        modelo_historia=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_historia (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_historia");
                registro[1]=rs.getString("id_paciente");                
                registro[2]=rs.getString("nombre_clinica");                
                registro[3]=rs.getString("creado_en");                
                registro[4]=rs.getString("id_usuario");                
                registro[5]=rs.getString("id_antecedente");                
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_historia.addRow(registro);
            }
            return modelo_historia;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    //insertar
    public String insertar_historia(mhistoria omhistoria)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_historia(?,?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1, omhistoria.getId_paciente());
            cst.setString(2, omhistoria.getNombre_clinica());
            cst.setString(3, omhistoria.getCreado_en());
            cst.setInt(4, omhistoria.getId_usuario());
            cst.setInt(5, omhistoria.getId_antecedente());
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
    public String modificar_historia(mhistoria omhistoria)
    {
        query="call usp_modificar_historia(?,?,?,?,?,?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omhistoria.getId_historia());
            cst.setInt(2,omhistoria.getId_paciente());
            cst.setString(3,omhistoria.getNombre_clinica());
            cst.setString(4,omhistoria.getCreado_en());
            cst.setInt(5,omhistoria.getId_usuario());
            cst.setInt(6,omhistoria.getId_antecedente());
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
    public String eliminar_historia(mhistoria omhistoria)
    {
        query="call usp_eliminar_historia(?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omhistoria.getId_historia());
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
