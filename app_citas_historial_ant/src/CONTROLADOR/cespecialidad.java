/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOespecialidad;
import MODELO.mespecialidad;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class cespecialidad {
    DAOespecialidad oDAOespecialidad=new DAOespecialidad();
    mespecialidad omespecialidad=new mespecialidad();
    public DefaultTableModel listar_especialidad(String buscar)
    {
        return oDAOespecialidad.listar_especialidad(buscar);
    }
    public String insertar_especialidad(String nombre,
                                        int id_categoria,
                                        String creado_en,
                                        int id_laboratorio)
    {
        
        omespecialidad.setNombre(nombre);
        omespecialidad.setId_categoria(id_categoria);
        omespecialidad.setCreado_en(creado_en);
        omespecialidad.setId_laboratorio(id_laboratorio);
        return oDAOespecialidad.insertar_especialidad(omespecialidad);
    }
    public String modificar_especialidad(int id_especialidad ,
                                        String nombre,
                                        int id_categoria,
                                        String creado_en,
                                        int id_laboratorio)
    {
        omespecialidad.setId_especialidad(id_especialidad);
        omespecialidad.setNombre(nombre);
        omespecialidad.setId_categoria(id_categoria);
        omespecialidad.setCreado_en(creado_en);
        omespecialidad.setId_laboratorio(id_laboratorio);
        return oDAOespecialidad.modificar_especialidad(omespecialidad);
    }
    public String eliminar_especialidad(int id_especialidad) 
    {   //cargamos el atributo
        omespecialidad.setId_especialidad(id_especialidad);
        //eliminamos
        return oDAOespecialidad.eliminar_especialidad(omespecialidad);
    }
}