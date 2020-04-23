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
public class mmedicamento {
    int id_medicamento;
    String nombre,
        tipo ,
        medio ,
        unidad_medida,
        descripcion;

    public mmedicamento() {
    }

    public mmedicamento(int id_medicamento, String nombre, String tipo, String medio, String unidad_medida, String descripcion) {
        this.id_medicamento = id_medicamento;
        this.nombre = nombre;
        this.tipo = tipo;
        this.medio = medio;
        this.unidad_medida = unidad_medida;
        this.descripcion = descripcion;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
