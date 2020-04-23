/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOpaciente;
import MODELO.mpaciente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class cpaciente {
    DAOpaciente oDAOpaciente=new DAOpaciente();
    mpaciente ompaciente=new mpaciente();
    public DefaultTableModel listar_paciente(String buscar)
    {
        return oDAOpaciente.listar_paciente(buscar);
    }
    public String insertar_paciente(String cod_personal ,
                                    String nombre ,
                                    String apaterno,
                                    String amaterno,
                                    String genero ,
                                    String dia_nace,
                                    String email ,
                                    String direccion,
                                    String telefono ,
                                    String imagen,
                                    String grupo_sanguineo,
                                    String creado_en)
    {
        ompaciente.setCod_personal(cod_personal);
        ompaciente.setNombre(nombre);
        ompaciente.setApaterno(apaterno);
        ompaciente.setAmaterno(amaterno);
        ompaciente.setGenero(genero);
        ompaciente.setDia_nace(dia_nace);
        ompaciente.setEmail(email);
        ompaciente.setDireccion(direccion);
        ompaciente.setTelefono(telefono);
        ompaciente.setImagen(imagen);
        ompaciente.setGrupo_sanguineo(grupo_sanguineo);
        ompaciente.setCreado_en(creado_en);
        return oDAOpaciente.insertar_paciente(ompaciente);
    }
    public String modificar_paciente(int id_paciente ,
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
                                    String grupo_sanguineo,
                                    boolean es_favorito,
                                    boolean es_activo,
                                    String creado_en)
    {
        ompaciente.setId_paciente(id_paciente);
        ompaciente.setCod_personal(cod_personal);
        ompaciente.setNombre(nombre);
        ompaciente.setApaterno(apaterno);
        ompaciente.setAmaterno(amaterno);
        ompaciente.setGenero(genero);
        ompaciente.setDia_nace(dia_nace);
        ompaciente.setEmail(email);
        ompaciente.setDireccion(direccion);
        ompaciente.setTelefono(telefono);
        ompaciente.setImagen(imagen);
        ompaciente.setGrupo_sanguineo(grupo_sanguineo);
        ompaciente.setEs_favorito(es_favorito);
        ompaciente.setEs_activo(es_activo);
        ompaciente.setCreado_en(creado_en);
        return oDAOpaciente.modificar_paciente(ompaciente);
    }
    public String eliminar_paciente(int id_paciente) 
    {   //cargamos el atributo
        ompaciente.setId_paciente(id_paciente);
        //eliminamos
        return oDAOpaciente.eliminar_paciente(ompaciente);
    }
}