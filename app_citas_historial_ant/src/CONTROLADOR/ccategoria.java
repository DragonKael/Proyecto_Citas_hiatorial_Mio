/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOcategoria;
import MODELO.mcategoria;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class ccategoria {
    DAOcategoria oDAOcategoria=new DAOcategoria();
    mcategoria omcategoria=new mcategoria();
    public DefaultTableModel listar_categoria(String pbuscar)
    {
        return oDAOcategoria.listar_categoria(pbuscar);
    }
    public String insertar_categoria(String nombre,
                                        String creado_en)
    {
        
        omcategoria.setNombre(nombre);
        omcategoria.setCreado_en(creado_en);
        return oDAOcategoria.insertar_categoria(omcategoria);
    }
    public String modificar_categoria(int id_categoria ,
                                        String nombre,
                                        String creado_en)
    {
        omcategoria.setId_categoria(id_categoria);
        omcategoria.setNombre(nombre);
        omcategoria.setCreado_en(creado_en);
        return oDAOcategoria.modificar_categoria(omcategoria);
    }
    public String eliminar_categoria(int id_categoria) 
    {   //cargamos el atributo
        omcategoria.setId_categoria(id_categoria);
        //eliminamos
        return oDAOcategoria.eliminar_categoria(omcategoria);
    }
}