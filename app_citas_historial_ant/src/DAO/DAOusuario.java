package DAO;
import MODELO.musuario;
import app_citas_historial_ant.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAOusuario {
    //atributos para las consultas varibles globales
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String query="";
    public Integer totalregistros;
    //metodo
    //listar
    public DefaultTableModel listar_usuario(String pbuscar)
    {
        DefaultTableModel modelo_usuario;
        String[]titulos={   "id_usuario",
                            "nombre_usuario",
                            "nombre",
                            "apaterno",
                            "amaterno",
                            "email", 
                            "contrasenia",
                            "es_activo",
                            "es_administrador",
                            "creado_en"};
        Object[]registro=new Object[titulos.length];
        modelo_usuario=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_listar_usuario (?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pbuscar", pbuscar);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_usuario");
                registro[1]=rs.getString("nombre_usuario");
                registro[2]=rs.getString("nombre");
                registro[3]=rs.getString("apaterno");
                registro[4]=rs.getString("amaterno");
                registro[5]=rs.getString("email");
                registro[6]=rs.getString("contrasenia");
                registro[7]=rs.getString("es_activo");
                registro[8]=rs.getString("es_administrador");
                registro[9]=rs.getString("creado_en");
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_usuario.addRow(registro);
            }
            return modelo_usuario;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    
    public DefaultTableModel recuperar_usuario(String pnombre,String pcontrasenia)
    {
        DefaultTableModel modelo_usuario;
        String[]titulos={   "id_usuario",
                            "nombre_usuario",
                            "nombre",
                            "apaterno",
                            "amaterno",
                            "email",
                            "contrasenia",
                            "es_activo",
                            "es_administrador",
                            "creado_en"};
        Object[]registro=new Object[titulos.length];
        modelo_usuario=new DefaultTableModel(null,titulos);
        //la consulta
        query="call usp_recuperar_usuario (?,?)";
        //cargamoslos datos de la tabla
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString("pemail", pnombre);
            cst.setString("pcontrasenia",pcontrasenia);
            cst.execute();
            ResultSet rs=cst.getResultSet();
            while(rs.next())
            {
                registro[0]=rs.getString("id_usuario");
                registro[1]=rs.getString("nombre_usuario");
                registro[2]=rs.getString("nombre");
                registro[3]=rs.getString("apaterno");
                registro[4]=rs.getString("amaterno");
                registro[5]=rs.getString("email");
                registro[6]=rs.getString("contrasenia");
                registro[7]=rs.getString("es_activo");
                registro[8]=rs.getString("es_administrador");
                registro[9]=rs.getString("creado_en");
                //almacenamos en un arreglo de bytes al objeto grande
                //binario con una longitud mazxima de (2^32-1)caracteres(longblob)
                modelo_usuario.addRow(registro);
            }
            return modelo_usuario;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    
    public String insertar_usuario(musuario omusuario)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_insertar_usuario(?,?,?,?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setString (1, omusuario.getNombre_usuario());
            cst.setString (2, omusuario.getNombre());
            cst.setString (3, omusuario.getApaterno());
            cst.setString (4, omusuario.getAmaterno());
            cst.setString (5, omusuario.getEmail());
            cst.setString (6, omusuario.getContrasenia());
            cst.setString (7, omusuario.getCreado_en());
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
    
    
    
    public String modificar_usuario(musuario omusuario)
    {
        
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_modificar_usuario(?,?,?,?,?,?,?,?,?,?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omusuario.getId_usuario());
            cst.setString (2, omusuario.getNombre_usuario());
            cst.setString (3, omusuario.getNombre());
            cst.setString (4, omusuario.getApaterno());
            cst.setString (5, omusuario.getAmaterno());
            cst.setString (6, omusuario.getEmail());
            cst.setString (7, omusuario.getContrasenia());
            cst.setBoolean(8, omusuario.isEs_activo());
            cst.setBoolean(9, omusuario.isEs_administrador());
            cst.setString (10, omusuario.getCreado_en());
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
    public String eliminar_usuario(musuario omusuario)
    {
        DefaultTableModel verificacion;
        String[]titulos={   "mensaje",
                            "id_error"};
        Object[]registro=new Object[titulos.length];
        verificacion=new DefaultTableModel(null,titulos);
        query="call usp_eliminar_usuario(?)";
        try
        {
            CallableStatement cst=cn.prepareCall(query);
            cst.setInt(1,omusuario.getId_usuario());
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