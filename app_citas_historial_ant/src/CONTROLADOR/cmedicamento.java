/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOmedicamento;
import MODELO.mmedicamento;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class cmedicamento {
    DAOmedicamento oDAOmedicamento=new DAOmedicamento();
    mmedicamento ommedicamento=new mmedicamento();
    public DefaultTableModel listar_medicamento(String buscar)
    {
        return oDAOmedicamento.listar_medicamento(buscar);
    }
    public String insertar_medicamento(String nombre,
                                        String tipo ,
                                        String medio ,
                                        String unidad_medida,
                                        String descripcion)
    {
        
        ommedicamento.setNombre(nombre);
        ommedicamento.setTipo(tipo);
        ommedicamento.setMedio(medio);
        ommedicamento.setUnidad_medida(unidad_medida);
        ommedicamento.setDescripcion(descripcion);
        return oDAOmedicamento.insertar_medicamento(ommedicamento);
    }
    public String modificar_medicamento(int id_medicamento ,
                                        String nombre,
                                        String tipo ,
                                        String medio ,
                                        String unidad_medida,
                                        String descripcion)
    {
        ommedicamento.setId_medicamento(id_medicamento);
        ommedicamento.setNombre(nombre);
        ommedicamento.setTipo(tipo);
        ommedicamento.setMedio(medio);
        ommedicamento.setUnidad_medida(unidad_medida);
        ommedicamento.setDescripcion(descripcion);
        return oDAOmedicamento.modificar_medicamento(ommedicamento);
    }
    public String eliminar_medicamento(int id_medicamento) 
    {   //cargamos el atributo
        ommedicamento.setId_medicamento(id_medicamento);
        //eliminamos
        return oDAOmedicamento.eliminar_medicamento(ommedicamento);
    }
}