/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOhistoria;
import MODELO.mhistoria;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class chistoria {
    DAOhistoria oDAOhistoria=new DAOhistoria();
    mhistoria omhistoria=new mhistoria();
    public DefaultTableModel listar_historia(String buscar)
    {
        return oDAOhistoria.listar_historia(buscar);
    }
    public String insertar_historia(int id_paciente,
                                    String nombre_clinica ,
                                    String creado_en,
                                    int id_usuario,
                                    int id_antecedente)
    {
        
        omhistoria.setId_paciente(id_paciente);
        omhistoria.setNombre_clinica(nombre_clinica);
        omhistoria.setCreado_en(creado_en);
        omhistoria.setId_usuario(id_usuario);
        omhistoria.setId_antecedente(id_antecedente);
        return oDAOhistoria.insertar_historia(omhistoria);
    }
    public String modificar_historia(int id_historia ,
                                    int id_paciente,
                                    String nombre_clinica ,
                                    String creado_en,
                                    int id_usuario,
                                    int id_antecedente)
    {
        omhistoria.setId_historia(id_historia);
        omhistoria.setId_paciente(id_paciente);
        omhistoria.setNombre_clinica(nombre_clinica);
        omhistoria.setCreado_en(creado_en);
        omhistoria.setId_usuario(id_usuario);
        omhistoria.setId_antecedente(id_antecedente);
        return oDAOhistoria.modificar_historia(omhistoria);
    }
    public String eliminar_historia(int id_historia) 
    {   //cargamos el atributo
        omhistoria.setId_historia(id_historia);
        //eliminamos
        return oDAOhistoria.eliminar_historia(omhistoria);
    }
}