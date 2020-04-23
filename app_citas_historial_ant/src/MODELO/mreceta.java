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
public class mreceta {
    int id_receta,
        id_atencion ;
    boolean interno;
    String tiempo_tratamiento;

    public mreceta() {
    }

    public mreceta(int id_receta, int id_atencion, boolean interno, String tiempo_tratamiento) {
        this.id_receta = id_receta;
        this.id_atencion = id_atencion;
        this.interno = interno;
        this.tiempo_tratamiento = tiempo_tratamiento;
    }

    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    public int getId_atencion() {
        return id_atencion;
    }

    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public boolean isInterno() {
        return interno;
    }

    public void setInterno(boolean interno) {
        this.interno = interno;
    }

    public String getTiempo_tratamiento() {
        return tiempo_tratamiento;
    }

    public void setTiempo_tratamiento(String tiempo_tratamiento) {
        this.tiempo_tratamiento = tiempo_tratamiento;
    }
}
