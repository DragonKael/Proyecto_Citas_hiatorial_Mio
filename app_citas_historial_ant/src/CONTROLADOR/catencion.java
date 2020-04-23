/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOatencion;
import MODELO.matencion;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class catencion {
    DAOatencion oDAOatencion=new DAOatencion();
    matencion omatencion=new matencion();
    public DefaultTableModel listar_atencion(String buscar)
    {
        return oDAOatencion.listar_atencion(buscar);
    }
    public String insertar_atencion(int id_reserva ,
                                    int id_triaje ,
                                    String diagnostico ,
                                    String hora_atencion)
    {
        
        omatencion.setId_reserva(id_reserva);
        omatencion.setId_triaje(id_triaje);
        omatencion.setDiagnostico(diagnostico);
        omatencion.setHora_atencion(hora_atencion);
        return oDAOatencion.insertar_atencion(omatencion);
    }
    public String modificar_atencion(int id_atencion ,
                                    int id_reserva ,
                                    int id_triaje ,
                                    String diagnostico ,
                                    String hora_atencion)
    {
        omatencion.setId_atencion(id_atencion);
        omatencion.setId_reserva(id_reserva);
        omatencion.setId_triaje(id_triaje);
        omatencion.setDiagnostico(diagnostico);
        omatencion.setHora_atencion(hora_atencion);
        return oDAOatencion.modificar_atencion(omatencion);
    }
    public String eliminar_atencion(int id_atencion) 
    {   //cargamos el atributo
        omatencion.setId_atencion(id_atencion);
        //eliminamos
        return oDAOatencion.eliminar_atencion(omatencion);
    }
}