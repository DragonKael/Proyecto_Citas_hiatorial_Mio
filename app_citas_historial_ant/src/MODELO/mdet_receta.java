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
public class mdet_receta {
    int id_det_receta, 
	cantidad,
        id_medicamento,
        id_receta;
    String dosis,
    frecuencia; 

    public mdet_receta() {
    }

    public mdet_receta(int id_det_receta, int cantidad, int id_medicamento, int id_receta, String dosis, String frecuencia) {
        this.id_det_receta = id_det_receta;
        this.cantidad = cantidad;
        this.id_medicamento = id_medicamento;
        this.id_receta = id_receta;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
    }

    public int getId_det_receta() {
        return id_det_receta;
    }

    public void setId_det_receta(int id_det_receta) {
        this.id_det_receta = id_det_receta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }
}
