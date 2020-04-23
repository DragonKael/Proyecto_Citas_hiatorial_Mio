/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOtriaje;
import MODELO.mtriaje;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class ctriaje {
    DAOtriaje oDAOtriaje=new DAOtriaje();
    mtriaje omtriaje=new mtriaje();
    public DefaultTableModel listar_triaje(String buscar)
    {
        return oDAOtriaje.listar_triaje(buscar);
    }
    public String insertar_triaje(double peso,
                                    double talla ,
                                    double presion_sanguinea,
                                    String nivel ,
                                    String color,
                                    String categoria,
                                    String tiempo_atencion,
                                    String detalles)
    {
        
        omtriaje.setPeso(peso);
        omtriaje.setTalla(talla);
        omtriaje.setPresion_sanguinea(presion_sanguinea);
        omtriaje.setNivel(nivel);
        omtriaje.setColor(color);
        omtriaje.setCategoria(categoria);
        omtriaje.setTiempo_atencion(tiempo_atencion);
        omtriaje.setDetalles(detalles);
        return oDAOtriaje.insertar_triaje(omtriaje);
    }
    public String modificar_triaje(int id_triaje ,
                                    double peso,
                                    double talla ,
                                    double presion_sanguinea,
                                    String nivel ,
                                    String color,
                                    String categoria,
                                    String tiempo_atencion,
                                    String detalles)
    {
        omtriaje.setId_triaje(id_triaje);
        omtriaje.setPeso(peso);
        omtriaje.setTalla(talla);
        omtriaje.setPresion_sanguinea(presion_sanguinea);
        omtriaje.setNivel(nivel);
        omtriaje.setColor(color);
        omtriaje.setCategoria(categoria);
        omtriaje.setTiempo_atencion(tiempo_atencion);
        omtriaje.setDetalles(detalles);
        return oDAOtriaje.modificar_triaje(omtriaje);
    }
    public String eliminar_triaje(int id_triaje) 
    {   //cargamos el atributo
        omtriaje.setId_triaje(id_triaje);
        //eliminamos
        return oDAOtriaje.eliminar_triaje(omtriaje);
    }
}