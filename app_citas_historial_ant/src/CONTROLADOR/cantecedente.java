/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.DAOantecedente;
import MODELO.mantecedente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lab-1 pc15
 */
public class cantecedente {
    DAOantecedente oDAOantecedente=new DAOantecedente();
    mantecedente omantecedente=new mantecedente();
    public DefaultTableModel listar_antecedente(String buscar)
    {
        return oDAOantecedente.listar_antecedente(buscar);
    }
    public String insertar_antecedente(String alergias ,
                                        String enfermedades ,
                                        String medicamentos ,
                                        String creado_en)
    {
        omantecedente.setAlergias(alergias);
        omantecedente.setEnfermedades(enfermedades);
        omantecedente.setMedicamentos(medicamentos);
        omantecedente.setCreado_en(creado_en);
        return oDAOantecedente.insertar_antecedente(omantecedente);
    }
    public String modificar_antecedente(int id_antecedente ,
                                        String alergias ,
                                        String enfermedades ,
                                        String medicamentos ,
                                        String creado_en)
    {
        omantecedente.setId_antecedente(id_antecedente);
        omantecedente.setAlergias(alergias);
        omantecedente.setEnfermedades(enfermedades);
        omantecedente.setMedicamentos(medicamentos);
        omantecedente.setCreado_en(creado_en);
        return oDAOantecedente.modificar_antecedente(omantecedente);
    }
    public String eliminar_antecedente(int id_antecedente) 
    {   //cargamos el atributo
        omantecedente.setId_antecedente(id_antecedente);
        //eliminamos
        return oDAOantecedente.eliminar_antecedente(omantecedente);
    }
}