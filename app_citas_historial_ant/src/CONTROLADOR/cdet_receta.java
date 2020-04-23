/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOdet_receta;
import MODELO.mdet_receta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class cdet_receta {
    DAOdet_receta oDAOdet_receta=new DAOdet_receta();
    mdet_receta omdet_receta=new mdet_receta();
    public DefaultTableModel listar_det_receta(String buscar)
    {
        return oDAOdet_receta.listar_det_receta(buscar);
    }
    public String insertar_det_receta(int cantidad,
                                        String dosis,
                                        String frecuencia,
                                        int id_medicamento,
                                        int id_receta)
    {        
        omdet_receta.setCantidad(cantidad);
        omdet_receta.setId_medicamento(id_medicamento);
        omdet_receta.setId_receta(id_receta);
        omdet_receta.setDosis(dosis);
        omdet_receta.setFrecuencia(frecuencia);
        return oDAOdet_receta.insertar_det_receta(omdet_receta);
    }
    public String modificar_det_receta(int id_det_receta ,
                                        int cantidad,
                                        String dosis,
                                        String frecuencia,
                                        int id_medicamento,
                                        int id_receta)
    {
        omdet_receta.setId_det_receta(id_det_receta);
        omdet_receta.setCantidad(cantidad);
        omdet_receta.setId_medicamento(id_medicamento);
        omdet_receta.setId_receta(id_receta);
        omdet_receta.setDosis(dosis);
        omdet_receta.setFrecuencia(frecuencia);
        return oDAOdet_receta.modificar_det_receta(omdet_receta);
    }
    public String eliminar_det_receta(int id_det_receta) 
    {   //cargamos el atributo
        omdet_receta.setId_det_receta(id_det_receta);
        //eliminamos
        return oDAOdet_receta.eliminar_det_receta(omdet_receta);
    }
}