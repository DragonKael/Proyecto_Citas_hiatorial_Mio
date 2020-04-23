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
public class mtriaje {
    int id_triaje;
    double peso,
        talla ,
        presion_sanguinea;
    String nivel ,
        color,
        categoria,
        tiempo_atencion,
        detalles;

    public mtriaje() {
    }

    public mtriaje(int id_triaje, double peso, double talla, double presion_sanguinea, String nivel, String color, String categoria, String tiempo_atencion, String detalles) {
        this.id_triaje = id_triaje;
        this.peso = peso;
        this.talla = talla;
        this.presion_sanguinea = presion_sanguinea;
        this.nivel = nivel;
        this.color = color;
        this.categoria = categoria;
        this.tiempo_atencion = tiempo_atencion;
        this.detalles = detalles;
    }

    public int getId_triaje() {
        return id_triaje;
    }

    public void setId_triaje(int id_triaje) {
        this.id_triaje = id_triaje;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getPresion_sanguinea() {
        return presion_sanguinea;
    }

    public void setPresion_sanguinea(double presion_sanguinea) {
        this.presion_sanguinea = presion_sanguinea;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTiempo_atencion() {
        return tiempo_atencion;
    }

    public void setTiempo_atencion(String tiempo_atencion) {
        this.tiempo_atencion = tiempo_atencion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
