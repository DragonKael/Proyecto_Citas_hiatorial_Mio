package VISTA;

import CONSULTAS.frmcons_antecedente;
import CONSULTAS.frmcons_paciente;
import CONSULTAS.frmcons_usuario;
import CONTROLADOR.chistoria;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.GregorianCalendar;

public class frmmanhistoria extends javax.swing.JFrame {

    Calendar gregcal = new GregorianCalendar();
    chistoria ochistoria = new chistoria();
    boolean es_activo, es_administrador;
    Date fecha_datetime;
    String fecha_texto;
    String fecha_hora;
    String no, ica, ila;
    int hora, minutos, segundos;

    public frmmanhistoria() {
        initComponents();
        listar_historia("");
        txtid_historia.setEnabled(false);
        txtid_usuario.setEnabled(false);
        txtid_antecedente.setEnabled(false);
        txtid_paciente.setEnabled(false);
        txtnombre_paciente.setEnabled(false);
        txtnombre_usuario.setEnabled(false);
        txtnombre_antecedente.setEnabled(false);
        txtusuariolog.setEnabled(false);
        txtnombreuserlog.setEnabled(false);
        estado_inicial();
    }

    void estado_inicial() {
        txtnombre_clinica.setEnabled(false);
        btnconsulta_usuario.setEnabled(false);
        btnconsulta_antecedente.setEnabled(false);
        btnconsulta_paciente.setEnabled(false);
        dtcreado_en.setEnabled(false);
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
    }

    void estado_nuevo() {
        txtnombre_clinica.setEnabled(true);
        btnconsulta_usuario.setEnabled(true);
        btnconsulta_paciente.setEnabled(true);
        btnconsulta_antecedente.setEnabled(true);
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
    }

    void mostar_fecha() {
        try {
            String formato = dtcreado_en.getDateFormatString();
            Date date = dtcreado_en.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            fecha_texto = String.valueOf(sdf.format(date));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    //metodos
    void recuperar_fecha() {
        try {
            String formato = "yyyy/MM/dd";
            DateFormat sdf = new SimpleDateFormat(formato);
            fecha_datetime = dtcreado_en.getDate();
            fecha_texto = sdf.format(fecha_datetime);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }

    void fecha_hora_cancat() {
        try {
            recuperar_fecha();
            hora = gregcal.get(Calendar.HOUR_OF_DAY);
            minutos = gregcal.get(Calendar.MINUTE);
            segundos = gregcal.get(Calendar.SECOND);
            fecha_hora = fecha_texto + " " + hora + ":" + minutos + ":" + segundos;
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }

    void listar_historia(String pbuscar) {
        DefaultTableModel modelohistoria = ochistoria.listar_historia(pbuscar);
        tblhistoria.setModel(modelohistoria);
    }

    void insertar_historia() {
        String mensaje = "";
        /////
        fecha_hora_cancat();//        
        /////
        if (txtid_usuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un Id de usuario con el boton");
        } else {
            if (txtid_antecedente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Seleccione un Id de antecedente con el boton");
            } else {
                if (txtid_paciente.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un Id de paciente con el boton");
                } else {

                    mensaje = ochistoria.insertar_historia(Integer.parseInt(
                            txtid_paciente.getText()), 
                            txtnombre_clinica.getText(),
                            fecha_hora, Integer.parseInt(
                            txtid_usuario.getText()),Integer.parseInt(
                            txtid_antecedente.getText())
                    );
                    limpiar();
                    estado_inicial();
                }
            }
        }

        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void modificar_historia() {
        String mensaje = "";
        /////
        fecha_hora_cancat();
        /////
        /////
        if (txtid_usuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un Id de usuario con el boton");
        } else {
            if (txtid_antecedente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Seleccione un Id de antecedente con el boton");
            } else {
                if (txtid_paciente.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un Id de paciente con el boton");
                } else {
                    mensaje = ochistoria.modificar_historia(Integer.parseInt(
                            txtid_historia.getText()),Integer.parseInt(
                            txtid_paciente.getText()), 
                            txtnombre_clinica.getText(),
                            fecha_hora, Integer.parseInt(
                            txtid_usuario.getText()),Integer.parseInt(
                            txtid_antecedente.getText())
                    );
//                                    limpiar();
//                                    estado_inicial();
                }
            }
        }

        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void sin_perdida() {

        no = txtid_paciente.getText();
        ica = txtid_usuario.getText();
        ila = txtid_antecedente.getText();
        txtid_paciente.setText(no);
        txtid_usuario.setText(ica);
        txtid_antecedente.setText(ila);
    }

    public void recuperardatos() {
        int filasel = tblhistoria.getSelectedRow();
        if (filasel >= 0) {
            txtid_historia.setText(tblhistoria.getValueAt(filasel, 0) + "");
            txtid_paciente.setText(tblhistoria.getValueAt(filasel, 1) + "");
            txtnombre_clinica.setText(tblhistoria.getValueAt(filasel, 2) + "");
            String fecha = tblhistoria.getValueAt(filasel, 3) + "";
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fecha_datetime = formato.parse(fecha);
                dtcreado_en.setDate(fecha_datetime);
            } catch (ParseException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
            txtid_usuario.setText(tblhistoria.getValueAt(filasel, 4) + "");
            txtid_antecedente.setText(tblhistoria.getValueAt(filasel, 5) + "");
        }
    }

    void limpiar() {
        txtid_historia.setText(null);
        txtid_paciente.setText(null);
        txtid_usuario.setText(null);
        txtid_antecedente.setText(null);
        txtnombre_usuario.setText(null);
        txtnombre_antecedente.setText(null);
        txtnombre_clinica.setText(null);
        txtnombre_paciente.setText(null);
        dtcreado_en.setDate(null);
    }

    void eliminar_registro() {
        ochistoria.eliminar_historia(Integer.parseInt(txtid_historia.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtid_historia = new javax.swing.JTextField();
        txtid_usuario = new javax.swing.JTextField();
        txtid_antecedente = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhistoria = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtusuariolog = new javax.swing.JTextField();
        txtnombreuserlog = new javax.swing.JTextField();
        dtcreado_en = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnconsulta_antecedente = new javax.swing.JButton();
        btnconsulta_usuario = new javax.swing.JButton();
        txtnombre_antecedente = new javax.swing.JTextField();
        txtnombre_usuario = new javax.swing.JTextField();
        btnconsulta_paciente = new javax.swing.JButton();
        txtnombre_paciente = new javax.swing.JTextField();
        txtid_paciente = new javax.swing.JTextField();
        txtnombre_clinica = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO HISTORIA");

        txtid_historia.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Historia"));

        txtid_usuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Usuario"));
        txtid_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_usuarioKeyTyped(evt);
            }
        });

        txtid_antecedente.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Antecedentes"));
        txtid_antecedente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_antecedenteKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA DE REGISTRO DE HISTORIA"));

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

        tblhistoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhistoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblhistoria);

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

        dtcreado_en.setBorder(javax.swing.BorderFactory.createTitledBorder("Creado en:"));
        dtcreado_en.setDateFormatString("yyyy/MM/dd");

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

        btnconsulta_antecedente.setText("+");
        btnconsulta_antecedente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_antecedenteActionPerformed(evt);
            }
        });

        btnconsulta_usuario.setText("+");
        btnconsulta_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_usuarioActionPerformed(evt);
            }
        });

        btnconsulta_paciente.setText("+");
        btnconsulta_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_pacienteActionPerformed(evt);
            }
        });

        txtid_paciente.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Paciente"));
        txtid_paciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_pacienteKeyTyped(evt);
            }
        });

        txtnombre_clinica.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Nombre Clinica"));
        txtnombre_clinica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre_clinicaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtid_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtid_historia, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtid_antecedente)
                    .addComponent(dtcreado_en, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtnombre_antecedente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnconsulta_antecedente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtnombre_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnconsulta_usuario))
                    .addComponent(txtid_paciente, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtnombre_paciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnconsulta_paciente))
                    .addComponent(txtnombre_clinica))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(420, 420, 420)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dtcreado_en, txtid_antecedente, txtid_historia, txtid_paciente, txtid_usuario, txtnombre_clinica});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid_historia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsulta_paciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombre_clinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtcreado_en, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsulta_usuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid_antecedente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnombre_antecedente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsulta_antecedente)))
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

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnconsulta_antecedente, btnconsulta_paciente, btnconsulta_usuario, dtcreado_en, txtid_antecedente, txtid_historia, txtid_paciente, txtid_usuario, txtnombre_antecedente, txtnombre_clinica, txtnombre_paciente, txtnombre_usuario});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        insertar_historia();
        listar_historia("");

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar_historia();
        listar_historia("");
        limpiar();
        estado_inicial();

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tblhistoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhistoriaMouseClicked
        dtcreado_en.setEnabled(true);
        recuperardatos();
        estado_nuevo();
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_tblhistoriaMouseClicked

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiar();
        dtcreado_en.setCalendar(gregcal);
        estado_nuevo();
        btnnuevo.setEnabled(false);
        btnmodificar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        listar_historia(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        listar_historia(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_registro();
        listar_historia("");
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        MessageFormat cabeceradocumento = new MessageFormat("Lista de Historia");
        MessageFormat piedocumento = new MessageFormat("-pagina(0) -");
        try {
            tblhistoria.print(JTable.PrintMode.FIT_WIDTH, cabeceradocumento, piedocumento);
        } catch (PrinterException ex) {
            JOptionPane.showConfirmDialog(rootPane, "No se puede imprimir este documento");
        }
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtid_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_usuarioKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_usuarioKeyTyped

    private void txtid_antecedenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_antecedenteKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_antecedenteKeyTyped

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnconsulta_antecedenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_antecedenteActionPerformed
        // TODO add your handling code here:
        frmcons_antecedente can = new frmcons_antecedente();
        can.setVisible(true);
    }//GEN-LAST:event_btnconsulta_antecedenteActionPerformed

    private void btnconsulta_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_usuarioActionPerformed
        // TODO add your handling code here:
        frmcons_usuario cus = new frmcons_usuario();
        cus.setVisible(true);
    }//GEN-LAST:event_btnconsulta_usuarioActionPerformed

    private void btnconsulta_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_pacienteActionPerformed
        frmcons_paciente cpa = new frmcons_paciente();
        cpa.setVisible(true);
    }//GEN-LAST:event_btnconsulta_pacienteActionPerformed

    private void txtid_pacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_pacienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_pacienteKeyTyped

    private void txtnombre_clinicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre_clinicaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_txtnombre_clinicaKeyTyped

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
//            java.util.logging.Logger.getLogger(frmmanhistoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmmanhistoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmmanhistoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmmanhistoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmmanhistoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsulta_antecedente;
    private javax.swing.JButton btnconsulta_paciente;
    private javax.swing.JButton btnconsulta_usuario;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser dtcreado_en;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblhistoria;
    private javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtid_antecedente;
    private javax.swing.JTextField txtid_historia;
    public static javax.swing.JTextField txtid_paciente;
    public static javax.swing.JTextField txtid_usuario;
    public static javax.swing.JTextField txtnombre_antecedente;
    private javax.swing.JTextField txtnombre_clinica;
    public static javax.swing.JTextField txtnombre_paciente;
    public static javax.swing.JTextField txtnombre_usuario;
    public static javax.swing.JTextField txtnombreuserlog;
    public static javax.swing.JTextField txtusuariolog;
    // End of variables declaration//GEN-END:variables
}
