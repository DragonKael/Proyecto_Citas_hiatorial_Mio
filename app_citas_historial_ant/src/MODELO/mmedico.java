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
public class mmedico {
    int id_medico,
	id_especialidad;
    String cod_personal,
	nombre ,
	apaterno,
        amaterno,
	genero ,
	dia_nace ,
	email ,
	direccion,
	telefono,
	imagen,
	creado_en;
	boolean es_activo;

    public mmedico() {
    }

    public mmedico(int id_medico, int id_especialidad, String cod_personal, String nombre, String apaterno, String amaterno, String genero, String dia_nace, String email, String direccion, String telefono, String imagen, String creado_en, boolean es_activo) {
        this.id_medico = id_medico;
        this.id_especialidad = id_especialidad;
        this.cod_personal = cod_personal;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.genero = genero;
        this.dia_nace = dia_nace;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
        this.creado_en = creado_en;
        this.es_activo = es_activo;
    }    

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getCod_personal() {
        return cod_personal;
    }

    public void setCod_personal(String cod_personal) {
        this.cod_personal = cod_personal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDia_nace() {
        return dia_nace;
    }

    public void setDia_nace(String dia_nace) {
        this.dia_nace = dia_nace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }

    public boolean isEs_activo() {
        return es_activo;
    }

    public void setEs_activo(boolean es_activo) {
        this.es_activo = es_activo;
    }
}

    
