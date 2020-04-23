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
public class mreserva {
    int id_reserva ,
	id_medico,
	id_usuario ,
        id_historia,
        id_especialidad;
    String titulo,
	nota,
	mensaje,
	fecha_de_cita ,
	hora_de_cita ,
        creado_en,
        estado ,
        pago ;
    double precio;
    boolean esta_en_web;

    public mreserva() {
    }

    public mreserva(int id_reserva, int id_medico, int id_usuario, int id_historia, int id_especialidad, String titulo, String nota, String mensaje, String fecha_de_cita, String hora_de_cita, String creado_en, String estado, String pago, double precio, boolean esta_en_web) {
        this.id_reserva = id_reserva;
        this.id_medico = id_medico;
        this.id_usuario = id_usuario;
        this.id_historia = id_historia;
        this.id_especialidad = id_especialidad;
        this.titulo = titulo;
        this.nota = nota;
        this.mensaje = mensaje;
        this.fecha_de_cita = fecha_de_cita;
        this.hora_de_cita = hora_de_cita;
        this.creado_en = creado_en;
        this.estado = estado;
        this.pago = pago;
        this.precio = precio;
        this.esta_en_web = esta_en_web;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_historia() {
        return id_historia;
    }

    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha_de_cita() {
        return fecha_de_cita;
    }

    public void setFecha_de_cita(String fecha_de_cita) {
        this.fecha_de_cita = fecha_de_cita;
    }

    public String getHora_de_cita() {
        return hora_de_cita;
    }

    public void setHora_de_cita(String hora_de_cita) {
        this.hora_de_cita = hora_de_cita;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEsta_en_web() {
        return esta_en_web;
    }

    public void setEsta_en_web(boolean esta_en_web) {
        this.esta_en_web = esta_en_web;
    }
}
