/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOlaboratorio;
import MODELO.mlaboratorio;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class claboratorio {
    DAOlaboratorio oDAOlaboratorio=new DAOlaboratorio();
    mlaboratorio omlaboratorio=new mlaboratorio();
    public DefaultTableModel listar_laboratorio(String buscar)
    {
        return oDAOlaboratorio.listar_laboratorio(buscar);
    }
    public String insertar_laboratorio(String nombre ,
                                        int aforo,
                                        String descripcion,
                                        String creado_en)
    {
        omlaboratorio.setAforo(aforo);
        omlaboratorio.setNombre(nombre);
        omlaboratorio.setDescripcion(descripcion);
        omlaboratorio.setCreado_en(creado_en);
        return oDAOlaboratorio.insertar_laboratorio(omlaboratorio);
    }
    public String modificar_laboratorio(int id_laboratorio ,
                                        String nombre ,
                                        int aforo,
                                        String descripcion,
                                        String creado_en)
    {
        omlaboratorio.setId_laboratorio(id_laboratorio);
        omlaboratorio.setAforo(aforo);
        omlaboratorio.setNombre(nombre);
        omlaboratorio.setDescripcion(descripcion);
        omlaboratorio.setCreado_en(creado_en);
        return oDAOlaboratorio.modificar_laboratorio(omlaboratorio);
    }
    public String eliminar_laboratorio(int id_laboratorio) 
    {   //cargamos el atributo
        omlaboratorio.setId_laboratorio(id_laboratorio);
        //eliminamos
        return oDAOlaboratorio.eliminar_laboratorio(omlaboratorio);
    }
}