/*
 * to change this license header, choose License Headers in project properties.
 * to change this template file, choose tools | templates
 * and open the template in the editor.
 */
package REPORTES;

import app_citas_historial_ant.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UNSAAC
 */
public class DAOreportes {
    //atributos

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String query = "";
    public Integer totalregistros;

    //listar
    public DefaultTableModel listar_citas_x_dia() {
        DefaultTableModel modeloo;
        String[] titulos = {"Cita Programada", "Paciente", "Telefono", "Titulo"};
        Object[] registro = new Object[titulos.length];
        modeloo = new DefaultTableModel(null, titulos);
        query = "call usp_listar_citas_x_dia()";
        try {
            CallableStatement cst = cn.prepareCall(query);
            cst.execute();
            ResultSet rs = cst.getResultSet();
            while (rs.next()) {
                registro[0] = rs.getString("creado_en");
                registro[1] = rs.getString("Paciente");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("titulo");
                modeloo.addRow(registro);
            }
            return modeloo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel listar_citas_x_rango(String pfecha1, String pfecha2) {
        DefaultTableModel modeloo;
        String[] titulos = {"Citas Hechas", "Paciente", "Telefono", "Titulo"};
        Object[] registro = new Object[titulos.length];
        modeloo = new DefaultTableModel(null, titulos);
        query = "call usp_listar_citas_x_rango(?,?)";
        try {
            CallableStatement cst = cn.prepareCall(query);
            cst.setString("pfecha1", pfecha1);
            cst.setString("pfecha2", pfecha2);
            cst.execute();
            ResultSet rs = cst.getResultSet();
            while (rs.next()) {
                registro[0] = rs.getString("creado_en");
                registro[1] = rs.getString("Paciente");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("titulo");
                modeloo.addRow(registro);
            }
            return modeloo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel listar_atencion_x_rango(String pfecha1, String pfecha2) {
        DefaultTableModel modeloo;
        String[] titulos = {"Atenciones por hacer", "Paciente", "Telefono", "Titulo"};
        Object[] registro = new Object[titulos.length];
        modeloo = new DefaultTableModel(null, titulos);
        query = "call usp_listar_atenciones_x_rango(?,?)";
        try {
            CallableStatement cst = cn.prepareCall(query);
            cst.setString("pfecha1", pfecha1);
            cst.setString("pfecha2", pfecha2);
            cst.execute();
            ResultSet rs = cst.getResultSet();
            while (rs.next()) {
                registro[0] = rs.getString("fecha_de_cita");
                registro[1] = rs.getString("Paciente");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("titulo");
                modeloo.addRow(registro);
            }
            return modeloo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel medicos_x_especialidad() {
        DefaultTableModel modeloo;
        String[] titulos = {"Nombre Especialidad", "Medico"};
        Object[] registro = new Object[titulos.length];
        modeloo = new DefaultTableModel(null, titulos);
        query = "call usp_medicos_x_especialidad()";
        try {
            CallableStatement cst = cn.prepareCall(query);
            cst.execute();
            ResultSet rs = cst.getResultSet();
            while (rs.next()) {
                registro[0] = rs.getString("nombre");
                registro[1] = rs.getString("Medico");
                modeloo.addRow(registro);
            }
            return modeloo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}
