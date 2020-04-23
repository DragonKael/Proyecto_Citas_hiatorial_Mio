/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author DragonKael
 */
public class matencion {
    int id_atencion,
	id_reserva ,
        id_triaje ;
        //id_medico ;
        String diagnostico ,
	hora_atencion ;

    public matencion() {
    }

    public matencion(int id_atencion, int id_reserva, int id_triaje, String diagnostico, String hora_atencion) {
        this.id_atencion = id_atencion;
        this.id_reserva = id_reserva;
        this.id_triaje = id_triaje;
        this.diagnostico = diagnostico;
        this.hora_atencion = hora_atencion;
    }

    public int getId_atencion() {
        return id_atencion;
    }

    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_triaje() {
        return id_triaje;
    }

    public void setId_triaje(int id_triaje) {
        this.id_triaje = id_triaje;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getHora_atencion() {
        return hora_atencion;
    }

    public void setHora_atencion(String hora_atencion) {
        this.hora_atencion = hora_atencion;
    }
}
