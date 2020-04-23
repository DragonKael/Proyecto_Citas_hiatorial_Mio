package VISTA;

import CONSULTAS.frmcons_medicamento;
import CONSULTAS.frmcons_receta;
import CONTROLADOR.cdet_receta;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.GregorianCalendar;

public class frmmandet_receta extends javax.swing.JFrame {

    Calendar gregcal = new GregorianCalendar();
    cdet_receta ocdet_receta = new cdet_receta();
    boolean es_activo, es_administrador;
    Date fecha_datetime;
    String fecha_texto;
    String fecha_hora;
    String no, ica, ila;
    int hora, minutos, segundos;

    public frmmandet_receta() {
        initComponents();
        listar_det_receta("");
        txtid_det_receta.setEnabled(false);
        txtid_medicamento.setEnabled(false);
        txtnombre_medicamento.setEnabled(false);
        txtnombre_receta.setEnabled(false);
        txtid_receta.setEnabled(false);
        txtusuariolog.setEnabled(false);
        txtnombreuserlog.setEnabled(false);
        estado_inicial();
    }

    void estado_inicial() {
        btnconsulta_medicamento.setEnabled(false);
        btnconsulta_receta.setEnabled(false);
        txtcantidad.setEnabled(false);
        txadosis.setEnabled(false);
        txafrecuencia.setEnabled(false);
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
    }

    void estado_nuevo() {
        btnconsulta_medicamento.setEnabled(true);
        btnconsulta_receta.setEnabled(true);
        txtcantidad.setEnabled(true);
        txadosis.setEnabled(true);
        txafrecuencia.setEnabled(true);
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
    }

    void listar_det_receta(String pbuscar) {
        DefaultTableModel modelodet_receta = ocdet_receta.listar_det_receta(pbuscar);
        tbldet_receta.setModel(modelodet_receta);
    }

    void insertar_det_receta() {
        String mensaje = "";
        /////      
        /////
        if (txafrecuencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una frecuencia");
        } else {
            if (txadosis.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese una dosis");
            } else {
                if (txtid_medicamento.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Id con el boton");
                } else {
                    if (txtid_receta.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Seleccione un Id con el boton");
                    } else {
                        if (txtcantidad.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese un cantidad");
                        } else {

                            mensaje = ocdet_receta.insertar_det_receta(Integer.parseInt(
                                    txtcantidad.getText()),
                                    txadosis.getText(),
                                    txafrecuencia.getText(), Integer.parseInt(
                                    txtid_medicamento.getText()), Integer.parseInt(
                                    txtid_receta.getText())
                            );
                            limpiar();
                            estado_inicial();
                        }
                    }
                }
            }
        }
        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void modificar_det_receta() {
        String mensaje = "";
        /////
        /////
        if (txafrecuencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una frecuencia");
        } else {
            if (txadosis.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese una dosis");
            } else {
                if (txtid_medicamento.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Id con el boton");
                } else {
                    if (txtid_receta.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Seleccione un Id con el boton");
                    } else {
                        if (txtcantidad.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese un cantidad");
                        } else {

                            mensaje = ocdet_receta.modificar_det_receta(Integer.parseInt(
                                    txtid_det_receta.getText()), Integer.parseInt(
                                    txtcantidad.getText()),
                                    txadosis.getText(),
                                    txafrecuencia.getText(), Integer.parseInt(
                                    txtid_medicamento.getText()), Integer.parseInt(
                                    txtid_receta.getText())
                            );
//                                    limpiar();
//                                    estado_inicial();
                        }
                    }
                }
            }
        }
        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void sin_perdida() {

        no = txtcantidad.getText();
        ica = txtid_medicamento.getText();
        ila = txtid_receta.getText();
        txtcantidad.setText(no);
        txtid_medicamento.setText(ica);
        txtid_receta.setText(ila);
    }

    public void recuperardatos() {
        int filasel = tbldet_receta.getSelectedRow();
        if (filasel >= 0) {
            txtid_det_receta.setText(tbldet_receta.getValueAt(filasel, 0) + "");
            txtcantidad.setText(tbldet_receta.getValueAt(filasel, 1) + "");
            txadosis.setText(tbldet_receta.getValueAt(filasel, 2) + "");
            txafrecuencia.setText(tbldet_receta.getValueAt(filasel, 3) + "");
            txtid_medicamento.setText(tbldet_receta.getValueAt(filasel, 4) + "");
            txtid_receta.setText(tbldet_receta.getValueAt(filasel, 5) + "");

        }
    }

    void limpiar() {
        txtid_det_receta.setText(null);
        txtcantidad.setText(null);
        txadosis.setText(null);
        txafrecuencia.setText(null);
        txtid_medicamento.setText(null);
        txtnombre_medicamento.setText(null);
        txtid_receta.setText(null);
        txtnombre_receta.setText(null);
    }

    void eliminar_registro() {
        ocdet_receta.eliminar_det_receta(Integer.parseInt(txtid_det_receta.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtid_det_receta = new javax.swing.JTextField();
        txtid_medicamento = new javax.swing.JTextField();
        txtid_receta = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldet_receta = new javax.swing.JTable();
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
        btnconsulta_receta = new javax.swing.JButton();
        btnconsulta_medicamento = new javax.swing.JButton();
        txtnombre_receta = new javax.swing.JTextField();
        txtnombre_medicamento = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txadosis = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txafrecuencia = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO DETALLE RECETA");

        txtid_det_receta.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Especialidad"));

        txtid_medicamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Medicamento"));
        txtid_medicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_medicamentoKeyTyped(evt);
            }
        });

        txtid_receta.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Receta"));
        txtid_receta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_recetaKeyTyped(evt);
            }
        });

        txtcantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Cantidad"));
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA DE REGISTRO DE DETALLE RECETA"));

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

        tbldet_receta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldet_recetaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldet_receta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1627, Short.MAX_VALUE)
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

        btnconsulta_receta.setText("+");
        btnconsulta_receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_recetaActionPerformed(evt);
            }
        });

        btnconsulta_medicamento.setText("+");
        btnconsulta_medicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_medicamentoActionPerformed(evt);
            }
        });

        txadosis.setColumns(20);
        txadosis.setRows(5);
        txadosis.setBorder(javax.swing.BorderFactory.createTitledBorder("Dosis"));
        jScrollPane4.setViewportView(txadosis);

        txafrecuencia.setColumns(20);
        txafrecuencia.setRows(5);
        txafrecuencia.setBorder(javax.swing.BorderFactory.createTitledBorder("Frecuencia"));
        jScrollPane3.setViewportView(txafrecuencia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtid_medicamento, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtid_receta)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtnombre_receta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnconsulta_receta))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtnombre_medicamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnconsulta_medicamento))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtid_det_receta, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(375, 375, 375))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane3, jScrollPane4, txtcantidad, txtid_det_receta, txtid_medicamento, txtid_receta});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid_det_receta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_medicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre_medicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsulta_medicamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_receta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnombre_receta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsulta_receta))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnconsulta_medicamento, btnconsulta_receta, txtcantidad, txtid_det_receta, txtid_medicamento, txtid_receta, txtnombre_medicamento, txtnombre_receta});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        insertar_det_receta();
        listar_det_receta("");

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar_det_receta();
        listar_det_receta("");
        limpiar();
        estado_inicial();

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tbldet_recetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldet_recetaMouseClicked
        recuperardatos();
        estado_nuevo();
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_tbldet_recetaMouseClicked

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiar();
        estado_nuevo();
        btnnuevo.setEnabled(false);
        btnmodificar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        listar_det_receta(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        listar_det_receta(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_registro();
        listar_det_receta("");
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        MessageFormat cabeceradocumento = new MessageFormat("Lista de Detalles de Receta");
        MessageFormat piedocumento = new MessageFormat("-pagina(0) -");
        try {
            tbldet_receta.print(JTable.PrintMode.FIT_WIDTH, cabeceradocumento, piedocumento);
        } catch (PrinterException ex) {
            JOptionPane.showConfirmDialog(rootPane, "No se puede imprimir este documento");
        }
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtid_medicamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_medicamentoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_medicamentoKeyTyped

    private void txtid_recetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_recetaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_recetaKeyTyped

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnconsulta_recetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_recetaActionPerformed
        // TODO add your handling code here:
        frmcons_receta cre = new frmcons_receta();
        cre.setVisible(true);
    }//GEN-LAST:event_btnconsulta_recetaActionPerformed

    private void btnconsulta_medicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_medicamentoActionPerformed
        // TODO add your handling code here:
        frmcons_medicamento cme = new frmcons_medicamento();
        cme.setVisible(true);
    }//GEN-LAST:event_btnconsulta_medicamentoActionPerformed

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
//            java.util.logging.Logger.getLogger(frmmandet_receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmmandet_receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmmandet_receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmmandet_receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmmandet_receta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsulta_medicamento;
    private javax.swing.JButton btnconsulta_receta;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbldet_receta;
    private javax.swing.JTextArea txadosis;
    private javax.swing.JTextArea txafrecuencia;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtid_det_receta;
    public static javax.swing.JTextField txtid_medicamento;
    public static javax.swing.JTextField txtid_receta;
    public static javax.swing.JTextField txtnombre_medicamento;
    public static javax.swing.JTextField txtnombre_receta;
    public static javax.swing.JTextField txtnombreuserlog;
    public static javax.swing.JTextField txtusuariolog;
    // End of variables declaration//GEN-END:variables
}
