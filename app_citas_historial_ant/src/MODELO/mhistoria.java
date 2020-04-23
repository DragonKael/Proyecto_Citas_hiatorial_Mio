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
public class mhistoria {
    int id_historia,
        id_paciente,
        id_usuario,
        id_antecedente;
    String nombre_clinica ,
        creado_en;

    public mhistoria() {
    }

    public mhistoria(int id_historia, int id_paciente, int id_usuario, int id_antecedente, String nombre_clinica, String creado_en) {
        this.id_historia = id_historia;
        this.id_paciente = id_paciente;
        this.id_usuario = id_usuario;
        this.id_antecedente = id_antecedente;
        this.nombre_clinica = nombre_clinica;
        this.creado_en = creado_en;
    }

    public int getId_historia() {
        return id_historia;
    }

    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_antecedente() {
        return id_antecedente;
    }

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public String getNombre_clinica() {
        return nombre_clinica;
    }

    public void setNombre_clinica(String nombre_clinica) {
        this.nombre_clinica = nombre_clinica;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }
}
