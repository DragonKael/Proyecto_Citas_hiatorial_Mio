/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOmedico;
import MODELO.mmedico;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class cmedico {
    DAOmedico oDAOmedico=new DAOmedico();
    mmedico ommedico=new mmedico();
    public DefaultTableModel listar_medico(String buscar)
    {
        return oDAOmedico.listar_medico(buscar);
    }
    public String insertar_medico(String cod_personal ,
                                    String nombre ,
                                    String apaterno,
                                    String amaterno,
                                    String genero ,
                                    String dia_nace,
                                    String email ,
                                    String direccion,
                                    String telefono ,
                                    String imagen,
                                    String creado_en,
                                    int id_especialidad)
    {
        ommedico.setCod_personal(cod_personal);
        ommedico.setNombre(nombre);
        ommedico.setApaterno(apaterno);
        ommedico.setAmaterno(amaterno);
        ommedico.setGenero(genero);
        ommedico.setDia_nace(dia_nace);
        ommedico.setEmail(email);
        ommedico.setDireccion(direccion);
        ommedico.setTelefono(telefono);
        ommedico.setImagen(imagen);
        ommedico.setCreado_en(creado_en);
        ommedico.setId_especialidad(id_especialidad);
        return oDAOmedico.insertar_medico(ommedico);
    }
    public String modificar_medico(int id_medico ,
                                    String cod_personal ,
                                    String nombre ,
                                    String apaterno,
                                    String amaterno,
                                    String genero ,
                                    String dia_nace,
                                    String email ,
                                    String direccion,
                                    String telefono ,
                                    String imagen,
                                    boolean es_activo,
                                    String creado_en,
                                    int id_especialidad)
    {
        ommedico.setId_medico(id_medico);
        ommedico.setCod_personal(cod_personal);
        ommedico.setNombre(nombre);
        ommedico.setApaterno(apaterno);
        ommedico.setAmaterno(amaterno);
        ommedico.setGenero(genero);
        ommedico.setDia_nace(dia_nace);
        ommedico.setEmail(email);
        ommedico.setDireccion(direccion);
        ommedico.setTelefono(telefono);
        ommedico.setImagen(imagen);
        ommedico.setEs_activo(es_activo);
        ommedico.setCreado_en(creado_en);
        ommedico.setId_especialidad(id_especialidad);
        return oDAOmedico.modificar_medico(ommedico);
    }
    public String eliminar_medico(int id_medico) 
    {   //cargamos el atributo
        ommedico.setId_medico(id_medico);
        //eliminamos
        return oDAOmedico.eliminar_medico(ommedico);
    }
}