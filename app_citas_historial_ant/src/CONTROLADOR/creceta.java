/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOreceta;
import MODELO.mreceta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class creceta {
    DAOreceta oDAOreceta=new DAOreceta();
    mreceta omreceta=new mreceta();
    public DefaultTableModel listar_receta(String buscar)
    {
        return oDAOreceta.listar_receta(buscar);
    }
    public String insertar_receta(
                                    boolean interno,
                                    String tiempo_tratamiento,
                                    int id_atencion)
    {
        
        omreceta.setId_atencion(id_atencion);
        omreceta.setInterno(interno);
        omreceta.setTiempo_tratamiento(tiempo_tratamiento);
        return oDAOreceta.insertar_receta(omreceta);
    }
    public String modificar_receta(int id_receta ,
                                    boolean interno,
                                    String tiempo_tratamiento,
                                    int id_atencion)
    {
        omreceta.setId_receta(id_receta);
        omreceta.setId_atencion(id_atencion);
        omreceta.setInterno(interno);
        omreceta.setTiempo_tratamiento(tiempo_tratamiento);
        return oDAOreceta.modificar_receta(omreceta);
    }
    public String eliminar_receta(int id_receta) 
    {   //cargamos el atributo
        omreceta.setId_receta(id_receta);
        //eliminamos
        return oDAOreceta.eliminar_receta(omreceta);
    }
}