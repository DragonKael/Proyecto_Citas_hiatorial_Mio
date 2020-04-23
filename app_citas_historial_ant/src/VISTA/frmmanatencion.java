package VISTA;

import CONSULTAS.frmcons_reserva;
import CONSULTAS.frmcons_triaje;
import CONTROLADOR.catencion;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class frmmanatencion extends javax.swing.JFrame {

    Calendar gregcal = new GregorianCalendar();
    catencion ocatencion = new catencion();
    boolean es_activo, es_administrador;
    Date fecha_datetime;
    String fecha_texto;
    String fecha_hora;
    String time;
    String no, ica, ila;
    int hora, minutos, segundos;

    public frmmanatencion() {
        initComponents();
        listar_atencion("");
        txtid_atencion.setEnabled(false);
        txtid_reserva.setEnabled(false);
        txtnombre_reserva.setEnabled(false);
        txtnombre_triaje.setEnabled(false);
        txtid_triaje.setEnabled(false);
        txtusuariolog.setEnabled(false);
        txtnombreuserlog.setEnabled(false);
        estado_inicial();
    }

    void estado_inicial() {
        txadiagnostico.setEnabled(false);
        txthora_de_atencion.setEnabled(false);
        btnconsulta_reserva.setEnabled(false);
        btnconsulta_triaje.setEnabled(false);
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
    }

    void estado_nuevo() {
        txadiagnostico.setEnabled(true);
        txthora_de_atencion.setEnabled(true);
        btnconsulta_reserva.setEnabled(true);
        btnconsulta_triaje.setEnabled(true);
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
    }

    void listar_atencion(String pbuscar) {
        DefaultTableModel modeloatencion = ocatencion.listar_atencion(pbuscar);
        tblatencion.setModel(modeloatencion);
    }

    void insertar_atencion() {
        String mensaje = "";
        /////

        /////
        if (txthora_de_atencion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un hora de atencion");
        } else {
            if (txtid_reserva.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Seleccione un Id con el reserva");
            } else {
                if (txtid_triaje.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Id con el triaje");
                } else {
                    if (txadiagnostico.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese un diagnostico");
                    } else {

                        mensaje = ocatencion.insertar_atencion(Integer.parseInt(
                                txtid_reserva.getText()),Integer.parseInt(
                                txtid_triaje.getText()),
                                txadiagnostico.getText(),
                                txthora_de_atencion.getText()
                        );
                        limpiar();
                        estado_inicial();
                    }
                }
            }
        }

        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void modificar_atencion() {
        String mensaje = "";
        /////
        /////
        if (txthora_de_atencion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un hora de atencion");
        } else {
            if (txtid_reserva.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Seleccione un Id con el reserva");
            } else {
                if (txtid_triaje.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Id con el triaje");
                } else {
                    if (txadiagnostico.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese un diagnostico");
                    } else {
                        mensaje = ocatencion.modificar_atencion(Integer.parseInt(
                                txtid_atencion.getText()),Integer.parseInt(
                                txtid_reserva.getText()),Integer.parseInt(
                                txtid_triaje.getText()),
                                txadiagnostico.getText(),
                                txthora_de_atencion.getText()
                        );
//                                    limpiar();
//                                    estado_inicial();
                    }
                }
            }
        }

        JOptionPane.showConfirmDialog(null, mensaje);
    }

    public boolean isTime(String tiempo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9]{1,2})*:+([0-9]{1,2})*:([0-9]{1,2})$");
        mat = pat.matcher(tiempo);
        if (mat.find()) {
//            System.out.println("[" + mat.group() + "]");
            return true;
        } else {
            return false;
        }
    }

    void sin_perdida() {

        ica = txtid_reserva.getText();
        ila = txtid_triaje.getText();
        txtid_reserva.setText(ica);
        txtid_triaje.setText(ila);
    }

    public void recuperardatos() {
        int filasel = tblatencion.getSelectedRow();
        if (filasel >= 0) {
            txtid_atencion.setText(tblatencion.getValueAt(filasel, 0) + "");
            txtid_reserva.setText(tblatencion.getValueAt(filasel, 1) + "");
            txtid_triaje.setText(tblatencion.getValueAt(filasel, 2) + "");
            txadiagnostico.setText(tblatencion.getValueAt(filasel, 3) + "");
            txthora_de_atencion.setText(tblatencion.getValueAt(filasel, 4) + "");

        }
    }

    void limpiar() {
        txtid_atencion.setText(null);
        txtid_reserva.setText(null);
        txtid_triaje.setText(null);
        txthora_de_atencion.setText(null);
        txadiagnostico.setText(null);
        txtnombre_reserva.setText(null);
        txtnombre_triaje.setText(null);
    }

    void eliminar_registro() {
        ocatencion.eliminar_atencion(Integer.parseInt(txtid_atencion.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtid_atencion = new javax.swing.JTextField();
        txtid_reserva = new javax.swing.JTextField();
        txtid_triaje = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblatencion = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtusuariolog = new javax.swing.JTextField();
        txtnombreuserlog = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnconsulta_triaje = new javax.swing.JButton();
        btnconsulta_reserva = new javax.swing.JButton();
        txtnombre_triaje = new javax.swing.JTextField();
        txtnombre_reserva = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txadiagnostico = new javax.swing.JTextArea();
        txthora_de_atencion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO ATENCION");

        txtid_atencion.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Atencion"));

        txtid_reserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Reserva"));
        txtid_reserva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_reservaKeyTyped(evt);
            }
        });

        txtid_triaje.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Triaje"));
        txtid_triaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_triajeKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA DE REGISTRO DE ATENCION"));

        jLabel3.setText("BUSCAR:");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tblatencion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblatencionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblatencion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar)
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtusuariolog, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(txtnombreuserlog))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtusuariolog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombreuserlog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("BOTONES"));

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnmodificar.setText("MODIFICAR");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnimprimir.setText("IMPRIMIR");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmodificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btncancelar, btneliminar, btnguardar, btnimprimir, btnmodificar, btnnuevo, btnsalir});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btncancelar, btneliminar, btnguardar, btnimprimir, btnmodificar, btnnuevo, btnsalir});

        btnconsulta_triaje.setText("+");
        btnconsulta_triaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_triajeActionPerformed(evt);
            }
        });

        btnconsulta_reserva.setText("+");
        btnconsulta_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_reservaActionPerformed(evt);
            }
        });

        txadiagnostico.setColumns(20);
        txadiagnostico.setRows(5);
        txadiagnostico.setBorder(javax.swing.BorderFactory.createTitledBorder("Diagnostico"));
        jScrollPane2.setViewportView(txadiagnostico);

        txthora_de_atencion.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora de Atencion"));
        txthora_de_atencion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txthora_de_atencionFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtid_atencion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtid_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtid_triaje)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtnombre_triaje)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnconsulta_triaje))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtnombre_reserva)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnconsulta_reserva)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthora_de_atencion, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 503, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(579, 579, 579)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, txthora_de_atencion, txtid_atencion, txtid_reserva, txtid_triaje});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid_atencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsulta_reserva))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_triaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnombre_triaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsulta_triaje))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthora_de_atencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(22, 22, 22)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnconsulta_reserva, btnconsulta_triaje, txthora_de_atencion, txtid_atencion, txtid_reserva, txtid_triaje, txtnombre_reserva, txtnombre_triaje});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        insertar_atencion();
        listar_atencion("");

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar_atencion();
        listar_atencion("");
        limpiar();
        estado_inicial();

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tblatencionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblatencionMouseClicked
        recuperardatos();
        estado_nuevo();
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_tblatencionMouseClicked

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        hora = gregcal.get(Calendar.HOUR_OF_DAY);
        minutos = gregcal.get(Calendar.MINUTE);
        segundos = gregcal.get(Calendar.SECOND);
        time = hora + ":" + minutos + ":" + segundos;
        limpiar();
        txthora_de_atencion.setText(time);
        estado_nuevo();
        btnnuevo.setEnabled(false);
        btnmodificar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        listar_atencion(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        listar_atencion(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_registro();
        listar_atencion("");
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        MessageFormat cabeceradocumento = new MessageFormat("Lista de Atencion");
        MessageFormat piedocumento = new MessageFormat("-pagina(0) -");
        try {
            tblatencion.print(JTable.PrintMode.FIT_WIDTH, cabeceradocumento, piedocumento);
        } catch (PrinterException ex) {
            JOptionPane.showConfirmDialog(rootPane, "No se puede imprimir este documento");
        }
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtid_reservaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_reservaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_reservaKeyTyped

    private void txtid_triajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_triajeKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_triajeKeyTyped

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnconsulta_triajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_triajeActionPerformed
        // TODO add your handling code here:
        frmcons_triaje ctr = new frmcons_triaje();
        ctr.setVisible(true);
    }//GEN-LAST:event_btnconsulta_triajeActionPerformed

    private void btnconsulta_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_reservaActionPerformed
        // TODO add your handling code here:
        frmcons_reserva cre = new frmcons_reserva();
        cre.setVisible(true);
    }//GEN-LAST:event_btnconsulta_reservaActionPerformed

    private void txthora_de_atencionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txthora_de_atencionFocusLost
        if (isTime(txthora_de_atencion.getText())) {

        } else {
            JOptionPane.showMessageDialog(null, "hora incorecta", "verificacion de hora", JOptionPane.WARNING_MESSAGE);
            txthora_de_atencion.requestFocus();
        }
    }//GEN-LAST:event_txthora_de_atencionFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmmanatencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmmanatencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmmanatencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmmanatencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmmanatencion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsulta_reserva;
    private javax.swing.JButton btnconsulta_triaje;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblatencion;
    private javax.swing.JTextArea txadiagnostico;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txthora_de_atencion;
    private javax.swing.JTextField txtid_atencion;
    public static javax.swing.JTextField txtid_reserva;
    public static javax.swing.JTextField txtid_triaje;
    public static javax.swing.JTextField txtnombre_reserva;
    public static javax.swing.JTextField txtnombre_triaje;
    public static javax.swing.JTextField txtnombreuserlog;
    public static javax.swing.JTextField txtusuariolog;
    // End of variables declaration//GEN-END:variables
}
