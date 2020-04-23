/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOusuario;
import MODELO.musuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class cusuario {
    DAOusuario oDAOusuario=new DAOusuario();
    musuario omusuario=new musuario();
    public DefaultTableModel listar_usuario(String buscar)
    {
        return oDAOusuario.listar_usuario(buscar);
    }
    public DefaultTableModel recuperar_usuario(String pemail,String pcontrasenia)
    {
//        omusuario.setEmail(pemail);
//        omusuario.setContrasenia(pcontrasenia);
        return oDAOusuario.recuperar_usuario(pemail, pcontrasenia);
    }
    public String insertar_usuario( String nombre_usuario,
                                    String nombre ,
                                    String apaterno ,
                                    String amaterno ,
                                    String email ,
                                    String contrasenia,
                                    String creado_en)
    {
        omusuario.setNombre_usuario(nombre_usuario);
        omusuario.setNombre(nombre);
        omusuario.setApaterno(apaterno);
        omusuario.setAmaterno(amaterno);
        omusuario.setEmail(email);
        omusuario.setContrasenia(contrasenia);
        omusuario.setCreado_en(creado_en);
        return oDAOusuario.insertar_usuario(omusuario);
    }
    public String modificar_usuario(int id_usuario,
                                    String nombre_usuario,
                                    String nombre ,
                                    String apaterno ,
                                    String amaterno ,
                                    String email ,
                                    String contrasenia,
                                    boolean es_activo ,
                                    boolean es_administrador,
                                    String creado_en)
    {
        omusuario.setId_usuario(id_usuario);
        omusuario.setNombre_usuario(nombre_usuario);
        omusuario.setNombre(nombre);
        omusuario.setApaterno(apaterno);
        omusuario.setAmaterno(amaterno);
        omusuario.setEmail(email);
        omusuario.setContrasenia(contrasenia);
        omusuario.setEs_activo(es_activo);
        omusuario.setEs_administrador(es_administrador);
        omusuario.setCreado_en(creado_en);
        return oDAOusuario.modificar_usuario(omusuario);
    }
    public String eliminar_usuario(int id_usuario) 
    {   //cargamos el atributo
        omusuario.setId_usuario(id_usuario);
        //eliminamos
        return oDAOusuario.eliminar_usuario(omusuario);
    }
}