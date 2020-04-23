/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.mmedico;
import app_citas_historial_ant.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DragonKael
 */
public class DAOmedico {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_medico(String pbuscar)
    {
        DefaultTableModel modelo_medico;
        String[]titulos={   "id_medico",
                            "cod_personal",
                            "nombre",
                            "apaterno",
                            "amaterno",
                            "genero",
                            "dia_nace",
                            "email", 
                            "direccion",
                            "telefono", 
                            "imagen", 
                            "es_activo", 
                            "creado_en",                            
                            "id_especialidad"}; 
        Object[]registro=new Object[titulos.length];
        modelo_medico=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_medico (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_medico");
                registro[1]=rs.getString("cod_personal");
                registro[2]=rs.getString("nombre");
                registro[3]=rs.getString("apaterno");
                registro[4]=rs.getString("amaterno");
                registro[5]=rs.getString("genero");
                registro[6]=rs.getString("dia_nace");
                registro[7]=rs.getString("email");
                registro[8]=rs.getString("direccion");
                registro[9]=rs.getString("telefono");
                registro[10]=rs.getString("imagen");
                registro[11]=rs.getString("es_activo");
                registro[12]=rs.getString("creado_en");
                registro[13]=rs.getString("id_especialidad");
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_medico.addRow(registro);
            }
            return modelo_medico;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    public String insertar_medico(mmedico ommedico)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_medico(?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString(1, ommedico.getCod_personal());
            cst.setString(2, ommedico.getNombre());
            cst.setString(3, ommedico.getApaterno());
            cst.setString(4, ommedico.getAmaterno());
            cst.setString(5, ommedico.getGenero());
            cst.setString(6, ommedico.getDia_nace());
            cst.setString(7, ommedico.getEmail());
            cst.setString(8, ommedico.getDireccion());
            cst.setString(9, ommedico.getTelefono());
            cst.setString(10, ommedico.getImagen());
            cst.setString(11, ommedico.getCreado_en());
            cst.setInt(12, ommedico.getId_especialidad());
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
    
    
    
    public String modificar_medico(mmedico ommedico)
    {
        query="call usp_modificar_medico(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,ommedico.getId_medico());
            cst.setString(2, ommedico.getCod_personal());
            cst.setString(3, ommedico.getNombre());
            cst.setString(4, ommedico.getApaterno());
            cst.setString(5, ommedico.getAmaterno());
            cst.setString(6, ommedico.getGenero());
            cst.setString(7, ommedico.getDia_nace());
            cst.setString(8, ommedico.getEmail());
            cst.setString(9, ommedico.getDireccion());
            cst.setString(10, ommedico.getTelefono());
            cst.setString(11, ommedico.getImagen());
            cst.setBoolean(12, ommedico.isEs_activo());
            cst.setString(13, ommedico.getCreado_en());
            cst.setInt(14, ommedico.getId_especialidad());
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
    public String eliminar_medico(mmedico ommedico)
    {
        query="call usp_eliminar_medico(?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,ommedico.getId_medico());
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
