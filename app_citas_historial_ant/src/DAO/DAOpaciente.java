/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.mpaciente;
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
public class DAOpaciente {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_paciente(String pbuscar)
    {
        DefaultTableModel modelo_paciente;
        String[]titulos={   "id_paciente",
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
                            "grupo_sanguineo",
                            "es_favorito", 
                            "es_activo", 
                            "creado_en"};
        Object[]registro=new Object[titulos.length];
        modelo_paciente=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_paciente (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_paciente");
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
                registro[11]=rs.getString("grupo_sanguineo");
                registro[12]=rs.getString("es_favorito");
                registro[13]=rs.getString("es_activo");
                registro[14]=rs.getString("creado_en");
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_paciente.addRow(registro);
            }
            return modelo_paciente;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    public String insertar_paciente(mpaciente ompaciente)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_paciente(?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString(1, ompaciente.getCod_personal());
            cst.setString(2, ompaciente.getNombre());
            cst.setString(3, ompaciente.getApaterno());
            cst.setString(4, ompaciente.getAmaterno());
            cst.setString(5, ompaciente.getGenero());
            cst.setString(6, ompaciente.getDia_nace());
            cst.setString(7, ompaciente.getEmail());
            cst.setString(8, ompaciente.getDireccion());
            cst.setString(9, ompaciente.getTelefono());
            cst.setString(10, ompaciente.getImagen());
            cst.setString(11, ompaciente.getGrupo_sanguineo());
            cst.setString(12, ompaciente.getCreado_en());
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
    
    
    
    public String modificar_paciente(mpaciente ompaciente)
    {
        query="call usp_modificar_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,ompaciente.getId_paciente());
            cst.setString(2, ompaciente.getCod_personal());
            cst.setString(3, ompaciente.getNombre());
            cst.setString(4, ompaciente.getApaterno());
            cst.setString(5, ompaciente.getAmaterno());
            cst.setString(6, ompaciente.getGenero());
            cst.setString(7, ompaciente.getDia_nace());
            cst.setString(8, ompaciente.getEmail());
            cst.setString(9, ompaciente.getDireccion());
            cst.setString(10, ompaciente.getTelefono());
            cst.setString(11, ompaciente.getImagen());
            cst.setString(12, ompaciente.getGrupo_sanguineo());
            cst.setBoolean(13, ompaciente.isEs_favorito());
            cst.setBoolean(14, ompaciente.isEs_activo());
            cst.setString(15, ompaciente.getCreado_en());
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
    public String eliminar_paciente(mpaciente ompaciente)
    {
        query="call usp_eliminar_paciente(?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,ompaciente.getId_paciente());
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
