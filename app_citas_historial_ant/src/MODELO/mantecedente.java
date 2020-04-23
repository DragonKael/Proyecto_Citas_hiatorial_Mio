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
public class mantecedente {
    int id_antecedente;
    String alergias ,
        enfermedades ,
        medicamentos ,
        creado_en ;

    public mantecedente() {
    }

    public mantecedente(int id_antecedente, String alergias, String enfermedades, String medicamentos, String creado_en) {
        this.id_antecedente = id_antecedente;
        this.alergias = alergias;
        this.enfermedades = enfermedades;
        this.medicamentos = medicamentos;
        this.creado_en = creado_en;
    }

    public int getId_antecedente() {
        return id_antecedente;
    }

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }
}
