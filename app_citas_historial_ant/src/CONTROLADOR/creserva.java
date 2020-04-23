/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOreserva;
import MODELO.mreserva;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class creserva {
    DAOreserva oDAOreserva=new DAOreserva();
    mreserva omreserva=new mreserva();
    public DefaultTableModel listar_reserva(String buscar)
    {
        return oDAOreserva.listar_reserva(buscar);
    }
    public String insertar_reserva(String titulo,
                                    String nota,
                                    String mensaje,
                                    String fecha_de_cita ,
                                    String hora_de_cita ,
                                    double precio,
                                    String creado_en,
                                    String estado ,
                                    String pago ,
                                    int id_medico,
                                    int id_usuario ,
                                    int id_historia,
                                    int id_especialidad)
    {
        omreserva.setTitulo(titulo);
        omreserva.setNota(nota);
        omreserva.setMensaje(mensaje);
        omreserva.setFecha_de_cita(fecha_de_cita);
        omreserva.setHora_de_cita(hora_de_cita);
        omreserva.setPrecio(precio);
        omreserva.setCreado_en(creado_en);
        omreserva.setEstado(estado);
        omreserva.setPago(pago);
        omreserva.setId_medico(id_medico);
        omreserva.setId_usuario(id_usuario);
        omreserva.setId_historia(id_historia);
        omreserva.setId_especialidad(id_especialidad);
        return oDAOreserva.insertar_reserva(omreserva);
    }
    public String modificar_reserva(int id_reserva ,
                                    String titulo,
                                    String nota,
                                    String mensaje,
                                    String fecha_de_cita ,
                                    String hora_de_cita ,
                                    double precio,
                                    boolean esta_en_web,
                                    String creado_en,
                                    String estado ,
                                    String pago ,
                                    int id_medico,
                                    int id_usuario ,
                                    int id_historia,
                                    int id_especialidad)
    {
        omreserva.setId_reserva(id_reserva);
        omreserva.setTitulo(titulo);
        omreserva.setNota(nota);
        omreserva.setMensaje(mensaje);
        omreserva.setFecha_de_cita(fecha_de_cita);
        omreserva.setHora_de_cita(hora_de_cita);
        omreserva.setPrecio(precio);
        omreserva.setCreado_en(creado_en);
        omreserva.setEstado(estado);
        omreserva.setPago(pago);
        omreserva.setId_medico(id_medico);
        omreserva.setId_usuario(id_usuario);
        omreserva.setId_historia(id_historia);
        omreserva.setId_especialidad(id_especialidad);
        return oDAOreserva.modificar_reserva(omreserva);
    }
    public String eliminar_reserva(int id_reserva) 
    {   //cargamos el atributo
        omreserva.setId_reserva(id_reserva);
        //eliminamos
        return oDAOreserva.eliminar_reserva(omreserva);
    }
}