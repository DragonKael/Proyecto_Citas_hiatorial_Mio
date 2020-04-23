/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.mreserva;
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
public class DAOreserva {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_reserva(String pbuscar)
    {
        DefaultTableModel modelo_reserva;
        String[]titulos={   "id_reserva",
                            "titulo",
                            "nota",
                            "mensaje",
                            "fecha_de_cita",
                            "hora_de_cita",
                            "precio",
                            "esta_en_web", 
                            "creado_en",
                            "estado", 
                            "pago", 
                            "id_medico",
                            "id_usuario", 
                            "id_historia", 
                            "id_especialidad"};
        Object[]registro=new Object[titulos.length];
        modelo_reserva=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_reserva (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_reserva");
                registro[1]=rs.getString("titulo");
                registro[2]=rs.getString("nota");
                registro[3]=rs.getString("mensaje");
                registro[4]=rs.getString("fecha_de_cita");
                registro[5]=rs.getString("hora_de_cita");
                registro[6]=rs.getString("precio");
                registro[7]=rs.getString("esta_en_web");
                registro[8]=rs.getString("creado_en");
                registro[9]=rs.getString("estado");
                registro[10]=rs.getString("pago");
                registro[11]=rs.getString("id_medico");
                registro[12]=rs.getString("id_usuario");
                registro[13]=rs.getString("id_historia");
                registro[14]=rs.getString("id_especialidad");
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_reserva.addRow(registro);
            }
            return modelo_reserva;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    public String insertar_reserva(mreserva omreserva)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_reserva(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString(1, omreserva.getTitulo());
            cst.setString(2, omreserva.getNota());
            cst.setString(3, omreserva.getMensaje());
            cst.setString(4, omreserva.getFecha_de_cita());
            cst.setString(5, omreserva.getHora_de_cita());
            cst.setDouble(6, omreserva.getPrecio());
            cst.setString(7, omreserva.getCreado_en());
            cst.setString(8, omreserva.getEstado());
            cst.setString(9, omreserva.getPago());
            cst.setInt(10, omreserva.getId_medico());
            cst.setInt(11, omreserva.getId_usuario());
            cst.setInt(12, omreserva.getId_historia());
            cst.setInt(13, omreserva.getId_especialidad());
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
    
    
    
    public String modificar_reserva(mreserva omreserva)
    {
        query="call usp_modificar_reserva(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omreserva.getId_reserva());
            cst.setString(2, omreserva.getTitulo());
            cst.setString(3, omreserva.getNota());
            cst.setString(4, omreserva.getMensaje());
            cst.setString(5, omreserva.getFecha_de_cita());
            cst.setString(6, omreserva.getHora_de_cita());
            cst.setDouble(7, omreserva.getPrecio());
            cst.setBoolean(8, omreserva.isEsta_en_web());
            cst.setString(9, omreserva.getCreado_en());
            cst.setString(10, omreserva.getEstado());
            cst.setString(11, omreserva.getPago());
            cst.setInt(12, omreserva.getId_medico());
            cst.setInt(13, omreserva.getId_usuario());
            cst.setInt(14, omreserva.getId_historia());
            cst.setInt(15, omreserva.getId_especialidad());
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
    public String eliminar_reserva(mreserva omreserva)
    {
        query="call usp_eliminar_reserva(?)";
        try
        {
            DefaultTableModel verificacion;
            String[]titulos={   "mensaje",
                                "id_error"};
            Object[]registro=new Object[titulos.length];
            verificacion=new DefaultTableModel(null,titulos);
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omreserva.getId_reserva());
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
