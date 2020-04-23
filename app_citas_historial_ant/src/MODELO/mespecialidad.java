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
public class mespecialidad {
    int id_especialidad,
        id_categoria,
        id_laboratorio;
    String nombre,
        creado_en;

    public mespecialidad() {
    }

    public mespecialidad(int id_especialidad, int id_categoria, int id_laboratorio, String nombre, String creado_en) {
        this.id_especialidad = id_especialidad;
        this.id_categoria = id_categoria;
        this.id_laboratorio = id_laboratorio;
        this.nombre = nombre;
        this.creado_en = creado_en;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }
}
