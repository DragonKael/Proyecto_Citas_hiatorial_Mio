package REPORTES;



import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UNSAAC
 */
public class cReportes {
    DAOreportes oDAOreportes = new DAOreportes();
    
    public DefaultTableModel listar_citas_x_dia(){
            return oDAOreportes.listar_citas_x_dia();
    } 
    public DefaultTableModel listar_citas_x_rango(String pfecha1, String pfecha2){
            return oDAOreportes.listar_citas_x_rango(pfecha1, pfecha2);
    }
    public DefaultTableModel listar_atencion_x_rango(String pfecha1, String pfecha2){
            return oDAOreportes.listar_atencion_x_rango(pfecha1, pfecha2);
    }
    
    public DefaultTableModel medicos_x_especialidad(){
            return oDAOreportes.medicos_x_especialidad();
    }
    
}
