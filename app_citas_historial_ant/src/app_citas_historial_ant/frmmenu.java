/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_citas_historial_ant;

import CONSULTAS.frmcons_antecedente;
import CONSULTAS.frmcons_atencion;
import CONSULTAS.frmcons_categoria;
import CONSULTAS.frmcons_det_receta;
import CONSULTAS.frmcons_especialidad;
import CONSULTAS.frmcons_historia;
import CONSULTAS.frmcons_laboratorio;
import CONSULTAS.frmcons_medicamento;
import CONSULTAS.frmcons_medico;
import CONSULTAS.frmcons_paciente;
import CONSULTAS.frmcons_receta;
import CONSULTAS.frmcons_reserva;
import CONSULTAS.frmcons_triaje;
import CONSULTAS.frmcons_usuario;
import REPORTES.frm_rep_atencion_x_rango;
import REPORTES.frm_rep_citas_x_dia;
import REPORTES.frm_rep_citas_x_rango;
import REPORTES.frm_rep_medicos_x_especialidad;
import VISTA.frmmanantecedente;
import VISTA.frmmanatencion;
import VISTA.frmmancategoria;
import VISTA.frmmandet_receta;
import VISTA.frmmanespecialidad;
import VISTA.frmmanhistoria;
import VISTA.frmmanlaboratorio;
import VISTA.frmmanmedicamento;
import VISTA.frmmanmedico;
import VISTA.frmmanpaciente;
import VISTA.frmmanreceta;
import VISTA.frmmanreserva;
import VISTA.frmmantriaje;
import VISTA.frmmanusuario;



public class frmmenu extends javax.swing.JFrame {

    /**
     * Creates new form frmmenu
     */
    public frmmenu() {
        initComponents();
        txtusuariolog.setEnabled(false);
        txtnombreuserlog.setEnabled(false);
    }
    public void ventana_estandar()
    {
        mimantenimiento.setVisible(false);
        miconsultas.setVisible(false);
        
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        txtusuariolog = new javax.swing.JTextField();
        txtnombreuserlog = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        mimantenimiento = new javax.swing.JMenu();
        miusuario = new javax.swing.JMenuItem();
        mipaciente = new javax.swing.JMenuItem();
        micategoria = new javax.swing.JMenuItem();
        milaboratorio = new javax.swing.JMenuItem();
        miespecialidad = new javax.swing.JMenuItem();
        mimedico = new javax.swing.JMenuItem();
        miantecedente = new javax.swing.JMenuItem();
        mitriaje = new javax.swing.JMenuItem();
        mimedicamento = new javax.swing.JMenuItem();
        mihistoria = new javax.swing.JMenuItem();
        mireserva = new javax.swing.JMenuItem();
        miatencion = new javax.swing.JMenuItem();
        mireceta = new javax.swing.JMenuItem();
        midet_receta = new javax.swing.JMenuItem();
        misalir = new javax.swing.JMenuItem();
        miconsultas = new javax.swing.JMenu();
        micons_usuario = new javax.swing.JMenuItem();
        micons_paciente = new javax.swing.JMenuItem();
        micons_laboratorio = new javax.swing.JMenuItem();
        micons_categoria = new javax.swing.JMenuItem();
        micons_especialidad = new javax.swing.JMenuItem();
        micons_medico = new javax.swing.JMenuItem();
        micons_antecedente = new javax.swing.JMenuItem();
        micons_triaje = new javax.swing.JMenuItem();
        micons_medicamento = new javax.swing.JMenuItem();
        micons_historia = new javax.swing.JMenuItem();
        micons_reserva = new javax.swing.JMenuItem();
        micons_atencion = new javax.swing.JMenuItem();
        micons_receta = new javax.swing.JMenuItem();
        miconsdet_receta = new javax.swing.JMenuItem();
        mireportes = new javax.swing.JMenu();
        mi_r1 = new javax.swing.JMenuItem();
        mi_r2 = new javax.swing.JMenuItem();
        mi_r3 = new javax.swing.JMenuItem();
        mi_r4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.add(txtusuariolog);
        txtusuariolog.setBounds(30, 190, 540, 70);
        desktopPane.add(txtnombreuserlog);
        txtnombreuserlog.setBounds(30, 270, 540, 70);

        mimantenimiento.setMnemonic('f');
        mimantenimiento.setText("MANTENIMIENTO");

        miusuario.setMnemonic('s');
        miusuario.setText("Usuario");
        miusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miusuarioActionPerformed(evt);
            }
        });
        mimantenimiento.add(miusuario);

        mipaciente.setMnemonic('o');
        mipaciente.setText("Paciente");
        mipaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mipacienteActionPerformed(evt);
            }
        });
        mimantenimiento.add(mipaciente);

        micategoria.setMnemonic('x');
        micategoria.setText("Categoria");
        micategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micategoriaActionPerformed(evt);
            }
        });
        mimantenimiento.add(micategoria);

        milaboratorio.setMnemonic('a');
        milaboratorio.setText("Laboratorio");
        milaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milaboratorioActionPerformed(evt);
            }
        });
        mimantenimiento.add(milaboratorio);

        miespecialidad.setText("Especialidad");
        miespecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miespecialidadActionPerformed(evt);
            }
        });
        mimantenimiento.add(miespecialidad);

        mimedico.setText("Medico");
        mimedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mimedicoActionPerformed(evt);
            }
        });
        mimantenimiento.add(mimedico);

        miantecedente.setText("Antecedente");
        miantecedente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miantecedenteActionPerformed(evt);
            }
        });
        mimantenimiento.add(miantecedente);

        mitriaje.setText("Triaje");
        mitriaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitriajeActionPerformed(evt);
            }
        });
        mimantenimiento.add(mitriaje);

        mimedicamento.setText("Medicamento");
        mimedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mimedicamentoActionPerformed(evt);
            }
        });
        mimantenimiento.add(mimedicamento);

        mihistoria.setText("Historia");
        mihistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mihistoriaActionPerformed(evt);
            }
        });
        mimantenimiento.add(mihistoria);

        mireserva.setText("Reserva");
        mireserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mireservaActionPerformed(evt);
            }
        });
        mimantenimiento.add(mireserva);

        miatencion.setText("Atencion");
        miatencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miatencionActionPerformed(evt);
            }
        });
        mimantenimiento.add(miatencion);

        mireceta.setText("Receta");
        mireceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mirecetaActionPerformed(evt);
            }
        });
        mimantenimiento.add(mireceta);

        midet_receta.setText("Detalle Receta");
        midet_receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midet_recetaActionPerformed(evt);
            }
        });
        mimantenimiento.add(midet_receta);

        misalir.setText("Salir");
        misalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misalirActionPerformed(evt);
            }
        });
        mimantenimiento.add(misalir);

        menuBar.add(mimantenimiento);

        miconsultas.setMnemonic('h');
        miconsultas.setText("CONSULTAS");

        micons_usuario.setMnemonic('s');
        micons_usuario.setText("Usuario");
        micons_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_usuarioActionPerformed(evt);
            }
        });
        miconsultas.add(micons_usuario);

        micons_paciente.setMnemonic('o');
        micons_paciente.setText("Paciente");
        micons_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_pacienteActionPerformed(evt);
            }
        });
        miconsultas.add(micons_paciente);

        micons_laboratorio.setMnemonic('a');
        micons_laboratorio.setText("Laboratorio");
        micons_laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_laboratorioActionPerformed(evt);
            }
        });
        miconsultas.add(micons_laboratorio);

        micons_categoria.setMnemonic('x');
        micons_categoria.setText("Categoria");
        micons_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_categoriaActionPerformed(evt);
            }
        });
        miconsultas.add(micons_categoria);

        micons_especialidad.setText("Especialidad");
        micons_especialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_especialidadActionPerformed(evt);
            }
        });
        miconsultas.add(micons_especialidad);

        micons_medico.setText("Medico");
        micons_medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_medicoActionPerformed(evt);
            }
        });
        miconsultas.add(micons_medico);

        micons_antecedente.setText("Antecedente");
        micons_antecedente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_antecedenteActionPerformed(evt);
            }
        });
        miconsultas.add(micons_antecedente);

        micons_triaje.setText("Triaje");
        micons_triaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_triajeActionPerformed(evt);
            }
        });
        miconsultas.add(micons_triaje);

        micons_medicamento.setText("Medicamento");
        micons_medicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_medicamentoActionPerformed(evt);
            }
        });
        miconsultas.add(micons_medicamento);

        micons_historia.setText("Historia");
        micons_historia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_historiaActionPerformed(evt);
            }
        });
        miconsultas.add(micons_historia);

        micons_reserva.setText("Reserva");
        micons_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_reservaActionPerformed(evt);
            }
        });
        miconsultas.add(micons_reserva);

        micons_atencion.setText("Atencion");
        micons_atencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_atencionActionPerformed(evt);
            }
        });
        miconsultas.add(micons_atencion);

        micons_receta.setText("Receta");
        micons_receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micons_recetaActionPerformed(evt);
            }
        });
        miconsultas.add(micons_receta);

        miconsdet_receta.setText("Detalle Receta");
        miconsdet_receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miconsdet_recetaActionPerformed(evt);
            }
        });
        miconsultas.add(miconsdet_receta);

        menuBar.add(miconsultas);

        mireportes.setMnemonic('e');
        mireportes.setText("REPORTES");

        mi_r1.setMnemonic('t');
        mi_r1.setText("Atencion x Rango");
        mi_r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_r1ActionPerformed(evt);
            }
        });
        mireportes.add(mi_r1);

        mi_r2.setMnemonic('y');
        mi_r2.setText("Citas x Dia");
        mi_r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_r2ActionPerformed(evt);
            }
        });
        mireportes.add(mi_r2);

        mi_r3.setMnemonic('p');
        mi_r3.setText("Citas x Rango");
        mi_r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_r3ActionPerformed(evt);
            }
        });
        mireportes.add(mi_r3);

        mi_r4.setMnemonic('d');
        mi_r4.setText("Medicos x Especialidad");
        mi_r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_r4ActionPerformed(evt);
            }
        });
        mireportes.add(mi_r4);

        menuBar.add(mireportes);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void micategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micategoriaActionPerformed
        //algunos retoque mas y ya queda ...
        frmmancategoria frmocat=new frmmancategoria();
        frmocat.setVisible(true);
        frmocat.txtusuariolog.setText(txtusuariolog.getText());
        frmocat.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micategoriaActionPerformed

    private void mipacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mipacienteActionPerformed
        //algunos retoque mas y ya queda...
        frmmanpaciente frmopac=new frmmanpaciente();
        frmopac.setVisible(true);
        frmopac.txtusuariolog.setText(txtusuariolog.getText());
        frmopac.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mipacienteActionPerformed

    private void miespecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miespecialidadActionPerformed
        //algunos retoque mas y ya queda...
        frmmanespecialidad frmoesp=new frmmanespecialidad();
        frmoesp.setVisible(true);
        frmoesp.txtusuariolog.setText(txtusuariolog.getText());
        frmoesp.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_miespecialidadActionPerformed

    private void miusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miusuarioActionPerformed
        //algunos retoque mas y ya queda...
        frmmanusuario frmotrabajador=new frmmanusuario();
        frmotrabajador.setVisible(true);
        frmotrabajador.txtusuariolog.setText(txtusuariolog.getText());
        frmotrabajador.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_miusuarioActionPerformed

    private void misalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_misalirActionPerformed

    private void milaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milaboratorioActionPerformed
        //algunos retoque mas y ya queda...
        frmmanlaboratorio frmoautor=new frmmanlaboratorio();
        frmoautor.setVisible(true);
        frmoautor.txtusuariolog.setText(txtusuariolog.getText());
        frmoautor.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_milaboratorioActionPerformed

    private void mimedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mimedicoActionPerformed
        //algunos retoque mas y ya queda...
        frmmanmedico frmolibro=new frmmanmedico();
        frmolibro.setVisible(true);
        frmolibro.txtusuariolog.setText(txtusuariolog.getText());
        frmolibro.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mimedicoActionPerformed

    private void miantecedenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miantecedenteActionPerformed
        //algunos retoque mas y ya queda...
        frmmanantecedente frmoprestamo=new frmmanantecedente();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_miantecedenteActionPerformed

    private void mitriajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitriajeActionPerformed
        //algunos retoque mas y ya queda...
        frmmantriaje frmoprestamo=new frmmantriaje();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mitriajeActionPerformed

    private void mimedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mimedicamentoActionPerformed
        //algunos retoque mas y ya queda...
        frmmanmedicamento frmoprestamo=new frmmanmedicamento();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mimedicamentoActionPerformed

    private void mihistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mihistoriaActionPerformed
        //algunos retoque mas y ya queda...
        frmmanhistoria frmoprestamo=new frmmanhistoria();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mihistoriaActionPerformed

    private void mireservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mireservaActionPerformed
        //algunos retoque mas y ya queda...
        frmmanreserva frmoprestamo=new frmmanreserva();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mireservaActionPerformed

    private void miatencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miatencionActionPerformed
        //algunos retoque mas y ya queda...
        frmmanatencion frmoprestamo=new frmmanatencion();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_miatencionActionPerformed

    private void mirecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirecetaActionPerformed
        //algunos retoque mas y ya queda...
        frmmanreceta frmoprestamo=new frmmanreceta();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mirecetaActionPerformed

    private void midet_recetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midet_recetaActionPerformed
        frmmandet_receta frmoprestamo=new frmmandet_receta();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_midet_recetaActionPerformed

    private void micons_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_usuarioActionPerformed
        frmcons_usuario frmoprestamo=new frmcons_usuario();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_usuarioActionPerformed

    private void micons_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_pacienteActionPerformed
        frmcons_paciente frmoprestamo=new frmcons_paciente();
        frmoprestamo.setVisible(true);
        frmoprestamo.txtusuariolog.setText(txtusuariolog.getText());
        frmoprestamo.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_pacienteActionPerformed

    private void micons_laboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_laboratorioActionPerformed
        frmcons_laboratorio frmolab=new frmcons_laboratorio();
        frmolab.setVisible(true);
        frmolab.txtusuariolog.setText(txtusuariolog.getText());
        frmolab.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_laboratorioActionPerformed

    private void micons_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_categoriaActionPerformed
        frmcons_categoria frmocat=new frmcons_categoria();
        frmocat.setVisible(true);
        frmocat.txtusuariolog.setText(txtusuariolog.getText());
        frmocat.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_categoriaActionPerformed

    private void micons_especialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_especialidadActionPerformed
        frmcons_especialidad frmoesp=new frmcons_especialidad();
        frmoesp.setVisible(true);
        frmoesp.txtusuariolog.setText(txtusuariolog.getText());
        frmoesp.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_especialidadActionPerformed

    private void micons_medicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_medicoActionPerformed
        frmcons_medico frmomeco=new frmcons_medico();
        frmomeco.setVisible(true);
        frmomeco.txtusuariolog.setText(txtusuariolog.getText());
        frmomeco.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_medicoActionPerformed

    private void micons_antecedenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_antecedenteActionPerformed
        frmcons_antecedente frmoant=new frmcons_antecedente();
        frmoant.setVisible(true);
        frmoant.txtusuariolog.setText(txtusuariolog.getText());
        frmoant.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_antecedenteActionPerformed

    private void micons_triajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_triajeActionPerformed
        frmcons_triaje frmotri=new frmcons_triaje();
        frmotri.setVisible(true);
        frmotri.txtusuariolog.setText(txtusuariolog.getText());
        frmotri.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_triajeActionPerformed

    private void micons_medicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_medicamentoActionPerformed
        frmcons_medicamento frmomedi=new frmcons_medicamento();
        frmomedi.setVisible(true);
        frmomedi.txtusuariolog.setText(txtusuariolog.getText());
        frmomedi.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_medicamentoActionPerformed

    private void micons_historiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_historiaActionPerformed
        frmcons_historia frmohis=new frmcons_historia();
        frmohis.setVisible(true);
        frmohis.txtusuariolog.setText(txtusuariolog.getText());
        frmohis.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_historiaActionPerformed

    private void micons_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_reservaActionPerformed
        frmcons_reserva frmores=new frmcons_reserva();
        frmores.setVisible(true);
        frmores.txtusuariolog.setText(txtusuariolog.getText());
        frmores.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_reservaActionPerformed

    private void micons_atencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_atencionActionPerformed
        frmcons_atencion frmoate=new frmcons_atencion();
        frmoate.setVisible(true);
        frmoate.txtusuariolog.setText(txtusuariolog.getText());
        frmoate.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_atencionActionPerformed

    private void micons_recetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micons_recetaActionPerformed
        frmcons_receta frmorec=new frmcons_receta();
        frmorec.setVisible(true);
        frmorec.txtusuariolog.setText(txtusuariolog.getText());
        frmorec.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_micons_recetaActionPerformed

    private void miconsdet_recetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miconsdet_recetaActionPerformed
        frmcons_det_receta frmodet_rec=new frmcons_det_receta();
        frmodet_rec.setVisible(true);
        frmodet_rec.txtusuariolog.setText(txtusuariolog.getText());
        frmodet_rec.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_miconsdet_recetaActionPerformed

    private void mi_r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_r1ActionPerformed
        frm_rep_atencion_x_rango frmo_rep_1=new frm_rep_atencion_x_rango();
        frmo_rep_1.setVisible(true);
        frmo_rep_1.txtusuariolog.setText(txtusuariolog.getText());
        frmo_rep_1.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mi_r1ActionPerformed

    private void mi_r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_r2ActionPerformed
        frm_rep_citas_x_dia frmo_rep_2=new frm_rep_citas_x_dia();
        frmo_rep_2.setVisible(true);
        frmo_rep_2.txtusuariolog.setText(txtusuariolog.getText());
        frmo_rep_2.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mi_r2ActionPerformed

    private void mi_r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_r3ActionPerformed
        frm_rep_citas_x_rango frmo_rep_3=new frm_rep_citas_x_rango();
        frmo_rep_3.setVisible(true);
        frmo_rep_3.txtusuariolog.setText(txtusuariolog.getText());
        frmo_rep_3.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mi_r3ActionPerformed

    private void mi_r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_r4ActionPerformed
        frm_rep_medicos_x_especialidad frmo_rep_4=new frm_rep_medicos_x_especialidad();
        frmo_rep_4.setVisible(true);
        frmo_rep_4.txtusuariolog.setText(txtusuariolog.getText());
        frmo_rep_4.txtnombreuserlog.setText(txtnombreuserlog.getText());
    }//GEN-LAST:event_mi_r4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mi_r1;
    private javax.swing.JMenuItem mi_r2;
    private javax.swing.JMenuItem mi_r3;
    private javax.swing.JMenuItem mi_r4;
    private javax.swing.JMenuItem miantecedente;
    private javax.swing.JMenuItem miatencion;
    private javax.swing.JMenuItem micategoria;
    private javax.swing.JMenuItem micons_antecedente;
    private javax.swing.JMenuItem micons_atencion;
    private javax.swing.JMenuItem micons_categoria;
    private javax.swing.JMenuItem micons_especialidad;
    private javax.swing.JMenuItem micons_historia;
    private javax.swing.JMenuItem micons_laboratorio;
    private javax.swing.JMenuItem micons_medicamento;
    private javax.swing.JMenuItem micons_medico;
    private javax.swing.JMenuItem micons_paciente;
    private javax.swing.JMenuItem micons_receta;
    private javax.swing.JMenuItem micons_reserva;
    private javax.swing.JMenuItem micons_triaje;
    private javax.swing.JMenuItem micons_usuario;
    private javax.swing.JMenuItem miconsdet_receta;
    private javax.swing.JMenu miconsultas;
    private javax.swing.JMenuItem midet_receta;
    private javax.swing.JMenuItem miespecialidad;
    private javax.swing.JMenuItem mihistoria;
    private javax.swing.JMenuItem milaboratorio;
    private javax.swing.JMenu mimantenimiento;
    private javax.swing.JMenuItem mimedicamento;
    private javax.swing.JMenuItem mimedico;
    private javax.swing.JMenuItem mipaciente;
    private javax.swing.JMenuItem mireceta;
    private javax.swing.JMenu mireportes;
    private javax.swing.JMenuItem mireserva;
    private javax.swing.JMenuItem misalir;
    private javax.swing.JMenuItem mitriaje;
    private javax.swing.JMenuItem miusuario;
    public static javax.swing.JTextField txtnombreuserlog;
    public static javax.swing.JTextField txtusuariolog;
    // End of variables declaration//GEN-END:variables

}
