package VISTA;

import CONSULTAS.frmcons_especialidad;
import CONSULTAS.frmcons_historia;
import CONSULTAS.frmcons_medico;
import CONSULTAS.frmcons_usuario;
import CONTROLADOR.creserva;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class frmmanreserva extends javax.swing.JFrame {

    Calendar gregcal = new GregorianCalendar();
    creserva ocreserva = new creserva();
    boolean web;
    Date fecha_datetime;
    String fecha_texto;
    String fecha_hora;
    String no, ica, ila;
    int hora, minutos, segundos;
    String time;
    String estado, pago;

    public frmmanreserva() {
        initComponents();
        listar_reserva("");
        txtid_reserva.setEnabled(false);
        txtid_usuario.setEnabled(false);
        txtid_medico.setEnabled(false);
        txtid_especialidad.setEnabled(false);
        txtid_historia.setEnabled(false);
        txtnombre_usuario.setEnabled(false);
        txtnombre_medico.setEnabled(false);
        txtnombre_historia.setEnabled(false);
        txtnombre_especialidad.setEnabled(false);
        txtusuariolog.setEnabled(false);
        txtnombreuserlog.setEnabled(false);
        estado_inicial();
    }

    void estado_inicial() {
        txttitulo.setEnabled(false);
        txanota.setEnabled(false);
        txamensaje.setEnabled(false);
        txthora_de_cita.setEnabled(false);
        txtprecio.setEnabled(false);
        chxweb.setEnabled(false);
        cboestado.setEnabled(false);
        cbopago.setEnabled(false);
        btnconsulta_usuario.setEnabled(false);
        btnconsulta_medico.setEnabled(false);
        btnconsulta_especialidad.setEnabled(false);
        btnconsulta_historia.setEnabled(false);
        dtcreado_en.setEnabled(false);
        dtfecha_de_cita.setEnabled(false);
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
    }

    void estado_nuevo() {
        txttitulo.setEnabled(true);
        txanota.setEnabled(true);
        txamensaje.setEnabled(true);
        txthora_de_cita.setEnabled(true);
        txtprecio.setEnabled(true);
        cboestado.setEnabled(true);
        cbopago.setEnabled(true);
        dtfecha_de_cita.setEnabled(true);
        btnconsulta_usuario.setEnabled(true);
        btnconsulta_medico.setEnabled(true);
        btnconsulta_especialidad.setEnabled(true);
        btnconsulta_historia.setEnabled(true);
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
    }

    void listar_reserva(String pbuscar) {
        DefaultTableModel modeloreserva = ocreserva.listar_reserva(pbuscar);
        tblreserva.setModel(modeloreserva);
    }

    void insertar_reserva() {
        String mensaje = "";
        /////
        fecha_hora_cancat();//        
        /////
        grupo_estado_string();
        /////
        grupo_pago_string();
        /////
        if (txttitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una hora");
        } else {
            if (txanota.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese una hora");
            } else {
                if (txamensaje.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese una hora");
                } else {
                    if (dtfecha_de_cita.getDate().equals(null)) {
                        JOptionPane.showMessageDialog(null, "Ingrese una fecha de cita");
                    } else {
                        if (txthora_de_cita.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese una hora");
                        } else {
                            if (txtprecio.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Ingrese Precio");
                            } else {
                                if (cboestado.getSelectedIndex() == 0) {
                                    JOptionPane.showMessageDialog(null, "Seleccione un estado de cita");
                                } else {
                                    if (cbopago.getSelectedIndex() == 0) {
                                        JOptionPane.showMessageDialog(null, "Seleccione un estado de pago");
                                    } else {
                                        if (txtid_especialidad.getText().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Seleccione un Id de usuario con el boton");
                                        } else {
                                            if (txtid_usuario.getText().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Seleccione un Id de usuario con el boton");
                                            } else {
                                                if (txtid_medico.getText().isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "Seleccione un Id de antecedente con el boton");
                                                } else {
                                                    if (txtid_historia.getText().isEmpty()) {
                                                        JOptionPane.showMessageDialog(null, "Ingrese un Id de historia con el boton");
                                                    } else {

                                                        mensaje = ocreserva.insertar_reserva(
                                                                txttitulo.getText(),
                                                                txanota.getText(),
                                                                txamensaje.getText(),
                                                                fecha_hora,//fecha cita
                                                                txthora_de_cita.getText(),/*hora citad*/ Double.parseDouble(
                                                                        txtprecio.getText()),
                                                                fecha_hora,//creado en
                                                                estado,
                                                                pago, Integer.parseInt(
                                                                        txtid_medico.getText()), Integer.parseInt(
                                                                txtid_usuario.getText()), Integer.parseInt(
                                                                txtid_historia.getText()), Integer.parseInt(
                                                                txtid_especialidad.getText())
                                                        );
                                                        limpiar();
                                                        estado_inicial();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void modificar_reserva() {
        String mensaje = "";
        /////
        fecha_hora_cancat();
        /////
        grupo_estado_string();
        /////
        grupo_pago_string();
        /////
        chboxes_boolean();
        /////
        if (txttitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una hora");
        } else {
            if (txanota.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese una hora");
            } else {
                if (txamensaje.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese una hora");
                } else {
                    if (dtfecha_de_cita.getDate().equals(null)) {
                        JOptionPane.showMessageDialog(null, "Ingrese una fecha de cita");
                    } else {
                        if (txthora_de_cita.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese una hora");
                        } else {
                            if (txtprecio.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Ingrese Precio");
                            } else {
                                if (cboestado.getSelectedIndex() == 0) {
                                    JOptionPane.showMessageDialog(null, "Seleccione un estado de cita");
                                } else {
                                    if (cbopago.getSelectedIndex() == 0) {
                                        JOptionPane.showMessageDialog(null, "Seleccione un estado de pago");
                                    } else {
                                        if (txtid_especialidad.getText().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Seleccione un Id de usuario con el boton");
                                        } else {
                                            if (txtid_usuario.getText().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Seleccione un Id de usuario con el boton");
                                            } else {
                                                if (txtid_medico.getText().isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "Seleccione un Id de antecedente con el boton");
                                                } else {
                                                    if (txtid_historia.getText().isEmpty()) {
                                                        JOptionPane.showMessageDialog(null, "Ingrese un Id de historia con el boton");
                                                    } else {
                                                        mensaje = ocreserva.modificar_reserva(Integer.parseInt(
                                                                txtid_reserva.getText()),
                                                                txttitulo.getText(),
                                                                txanota.getText(),
                                                                txamensaje.getText(),
                                                                fecha_hora,//fecha cita
                                                                txthora_de_cita.getText(),/*hora citad*/ Double.parseDouble(
                                                                        txtprecio.getText()),
                                                                web,
                                                                fecha_hora,//creado en
                                                                estado,
                                                                pago, Integer.parseInt(
                                                                        txtid_medico.getText()), Integer.parseInt(
                                                                txtid_usuario.getText()), Integer.parseInt(
                                                                txtid_historia.getText()), Integer.parseInt(
                                                                txtid_especialidad.getText())
                                                        );
//                                    limpiar();
//                                    estado_inicial();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        JOptionPane.showConfirmDialog(null, mensaje);
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
            time = hora + ":" + minutos + ":" + segundos;
            fecha_hora = fecha_texto + " " + hora + ":" + minutos + ":" + segundos;
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
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

    void grupo_estado_string() {
        int cbosel = cboestado.getSelectedIndex();
        switch (cbosel) {
            case 1:
                estado = "Pendiente";
                break;
            case 2:
                estado = "Aplicada";
                break;
            case 3:
                estado = "No Asistio";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la seleccion del estado");

        }
    }

    void recuperar_estado() {
        int filasel = tblreserva.getSelectedRow();
        String g_s = tblreserva.getValueAt(filasel, 9) + "";
        //int cbosel=cbogrupo_sanguineo.getSelectedIndex();
        switch (g_s) {
            case "Pendiente":
                cboestado.setSelectedIndex(1);
                break;
            case "Aplicada":
                cboestado.setSelectedIndex(2);
                break;
            case "No Asistio":
                cboestado.setSelectedIndex(3);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la recuperacion del estado");
                cboestado.setSelectedIndex(0);
        }
    }

    void grupo_pago_string() {
        int cbosel = cbopago.getSelectedIndex();
        switch (cbosel) {
            case 1:
                pago = "Pendiente";
                break;
            case 2:
                pago = "Pagado";
                break;
            case 3:
                pago = "Anulado";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la seleccion del pago");

        }
    }

    void recuperar_pago() {
        int filasel = tblreserva.getSelectedRow();
        String g_s = tblreserva.getValueAt(filasel, 10) + "";
        //int cbosel=cbogrupo_sanguineo.getSelectedIndex();
        switch (g_s) {
            case "Pendiente":
                cbopago.setSelectedIndex(1);
                break;
            case "Pagado":
                cbopago.setSelectedIndex(2);
                break;
            case "Anulado":
                cbopago.setSelectedIndex(3);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la recuperacion del pago");
                cbopago.setSelectedIndex(0);
        }
    }

    void chboxes_boolean() {
        if (chxweb.isSelected() == true) {
            web = true;
        } else {
            web = false;
        }
    }

    void chboxes_string() {
        int filasel = tblreserva.getSelectedRow();
        if ((tblreserva.getValueAt(filasel, 7)).equals("1")) {
            chxweb.setSelected(true);
        } else {
            chxweb.setSelected(false);
        }
    }

    void sin_perdida() {

        no = txtid_reserva.getText();
        ica = txtid_usuario.getText();
        ila = txtid_medico.getText();
        txtid_reserva.setText(no);
        txtid_usuario.setText(ica);
        txtid_medico.setText(ila);
    }

    public void recuperardatos() {
        int filasel = tblreserva.getSelectedRow();
        if (filasel >= 0) {
            txtid_reserva.setText(tblreserva.getValueAt(filasel, 0) + "");
            txttitulo.setText(tblreserva.getValueAt(filasel, 1) + "");
            txanota.setText(tblreserva.getValueAt(filasel, 2) + "");
            txamensaje.setText(tblreserva.getValueAt(filasel, 3) + "");
            String fecha_cita = tblreserva.getValueAt(filasel, 4) + "";
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fecha_datetime = formato.parse(fecha_cita);
                dtfecha_de_cita.setDate(fecha_datetime);
            } catch (ParseException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
            txthora_de_cita.setText(tblreserva.getValueAt(filasel, 5) + "");
            txtprecio.setText(tblreserva.getValueAt(filasel, 6) + "");
            chboxes_string();
            String fecha_crea = tblreserva.getValueAt(filasel, 8) + "";
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fecha_datetime = formato.parse(fecha_crea);
                dtcreado_en.setDate(fecha_datetime);
            } catch (ParseException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
            recuperar_estado();
            recuperar_pago();
            txtid_medico.setText(tblreserva.getValueAt(filasel, 11) + "");
            txtid_usuario.setText(tblreserva.getValueAt(filasel, 12) + "");
            txtid_historia.setText(tblreserva.getValueAt(filasel, 13) + "");
            txtid_especialidad.setText(tblreserva.getValueAt(filasel, 14) + "");
        }
    }

    void limpiar() {
        txtid_reserva.setText(null);
        txttitulo.setText(null);
        txanota.setText(null);
        txamensaje.setText(null);
        txthora_de_cita.setText(null);
        txtprecio.setText(null);
        chxweb.setSelected(false);
        txtid_usuario.setText(null);
        txtid_medico.setText(null);
        txtid_especialidad.setText(null);
        txtid_historia.setText(null);
        txtnombre_usuario.setText(null);
        txtnombre_medico.setText(null);
        txtnombre_especialidad.setText(null);
        txtnombre_historia.setText(null);
        dtcreado_en.setDate(null);
        dtfecha_de_cita.setDate(null);
    }

    void eliminar_registro() {
        ocreserva.eliminar_reserva(Integer.parseInt(txtid_reserva.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtid_reserva = new javax.swing.JTextField();
        txtid_usuario = new javax.swing.JTextField();
        txtid_medico = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblreserva = new javax.swing.JTable();
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
        btnconsulta_medico = new javax.swing.JButton();
        btnconsulta_usuario = new javax.swing.JButton();
        txtnombre_medico = new javax.swing.JTextField();
        txtnombre_usuario = new javax.swing.JTextField();
        btnconsulta_historia = new javax.swing.JButton();
        txtnombre_historia = new javax.swing.JTextField();
        txtid_historia = new javax.swing.JTextField();
        txttitulo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txanota = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txamensaje = new javax.swing.JTextArea();
        dtfecha_de_cita = new com.toedter.calendar.JDateChooser();
        txtprecio = new javax.swing.JTextField();
        chxweb = new javax.swing.JCheckBox();
        txtnombre_especialidad = new javax.swing.JTextField();
        txtid_especialidad = new javax.swing.JTextField();
        btnconsulta_especialidad = new javax.swing.JButton();
        cboestado = new javax.swing.JComboBox<>();
        cbopago = new javax.swing.JComboBox<>();
        txthora_de_cita = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO RESERVA");

        txtid_reserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Reserva"));

        txtid_usuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Usuario"));
        txtid_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_usuarioKeyTyped(evt);
            }
        });

        txtid_medico.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Medico"));
        txtid_medico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_medicoKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA DE REGISTRO DE RESERVA"));

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

        tblreserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblreservaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblreserva);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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
                    .addComponent(txtusuariolog, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
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

        btnconsulta_medico.setText("+");
        btnconsulta_medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_medicoActionPerformed(evt);
            }
        });

        btnconsulta_usuario.setText("+");
        btnconsulta_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_usuarioActionPerformed(evt);
            }
        });

        btnconsulta_historia.setText("+");
        btnconsulta_historia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_historiaActionPerformed(evt);
            }
        });

        txtid_historia.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Historia"));
        txtid_historia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_historiaKeyTyped(evt);
            }
        });

        txttitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Titulo"));
        txttitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttituloKeyTyped(evt);
            }
        });

        txanota.setColumns(20);
        txanota.setRows(5);
        txanota.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota"));
        jScrollPane2.setViewportView(txanota);

        txamensaje.setColumns(20);
        txamensaje.setRows(5);
        txamensaje.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensaje"));
        jScrollPane3.setViewportView(txamensaje);

        dtfecha_de_cita.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Cita"));
        dtfecha_de_cita.setDateFormatString("yyyy/MM/dd");

        txtprecio.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio"));
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        chxweb.setText("Esta en la Web");

        txtid_especialidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Especialidad"));
        txtid_especialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_especialidadActionPerformed(evt);
            }
        });
        txtid_especialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_especialidadKeyTyped(evt);
            }
        });

        btnconsulta_especialidad.setText("+");
        btnconsulta_especialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta_especialidadActionPerformed(evt);
            }
        });

        cboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECCION-", "Pendiente", "Aplicada", "No asistio" }));
        cboestado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        cbopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECCION-", "Pendiente", "Pagado", "Anulado" }));
        cbopago.setBorder(javax.swing.BorderFactory.createTitledBorder("Pago"));

        txthora_de_cita.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora de Cita"));
        txthora_de_cita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txthora_de_citaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbopago, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtcreado_en, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chxweb, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtfecha_de_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthora_de_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtnombre_medico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnconsulta_medico))
                            .addComponent(txtid_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtnombre_usuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnconsulta_usuario))
                            .addComponent(txtid_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnombre_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnconsulta_historia))
                            .addComponent(txtid_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtnombre_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnconsulta_especialidad))
                            .addComponent(txtid_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(504, 504, 504)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboestado, cbopago, chxweb, dtcreado_en, dtfecha_de_cita, jScrollPane2, jScrollPane3, txthora_de_cita, txtid_especialidad, txtid_historia, txtid_medico, txtid_reserva, txtid_usuario, txtprecio, txttitulo});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtnombre_especialidad, txtnombre_historia, txtnombre_medico, txtnombre_usuario});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtid_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnombre_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnconsulta_especialidad)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(22, 22, 22)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtid_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtnombre_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnconsulta_medico)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtid_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtnombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnconsulta_usuario))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtid_historia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtnombre_historia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnconsulta_historia))))))
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtfecha_de_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthora_de_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chxweb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtcreado_en, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnconsulta_especialidad, btnconsulta_historia, btnconsulta_medico, btnconsulta_usuario, dtcreado_en, txthora_de_cita, txtid_especialidad, txtid_historia, txtid_medico, txtid_reserva, txtid_usuario, txtnombre_especialidad, txtnombre_historia, txtnombre_medico, txtnombre_usuario, txtprecio, txttitulo});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        insertar_reserva();
        listar_reserva("");

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar_reserva();
        listar_reserva("");
        limpiar();
        estado_inicial();

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tblreservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblreservaMouseClicked
        chxweb.setEnabled(true);
        dtcreado_en.setEnabled(true);
        recuperardatos();
        estado_nuevo();
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_tblreservaMouseClicked

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        hora = gregcal.get(Calendar.HOUR_OF_DAY);
        minutos = gregcal.get(Calendar.MINUTE);
        segundos = gregcal.get(Calendar.SECOND);
        time = hora + ":" + minutos + ":" + segundos;
        limpiar();
        txthora_de_cita.setText(time);
        dtcreado_en.setCalendar(gregcal);
        estado_nuevo();
        btnnuevo.setEnabled(false);
        btnmodificar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        listar_reserva(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        listar_reserva(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_registro();
        listar_reserva("");
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        MessageFormat cabeceradocumento = new MessageFormat("Lista de Reservas");
        MessageFormat piedocumento = new MessageFormat("-pagina(0) -");
        try {
            tblreserva.print(JTable.PrintMode.FIT_WIDTH, cabeceradocumento, piedocumento);
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

    private void txtid_medicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_medicoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_medicoKeyTyped

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnconsulta_medicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_medicoActionPerformed
        // TODO add your handling code here:
        frmcons_medico cme = new frmcons_medico();
        cme.setVisible(true);
    }//GEN-LAST:event_btnconsulta_medicoActionPerformed

    private void btnconsulta_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_usuarioActionPerformed
        // TODO add your handling code here:
        frmcons_usuario cus = new frmcons_usuario();
        cus.setVisible(true);
        cus.lbltitulo_cons.setText("Consulta Usuario para Reserva");
    }//GEN-LAST:event_btnconsulta_usuarioActionPerformed

    private void btnconsulta_historiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_historiaActionPerformed
        frmcons_historia chi = new frmcons_historia();
        chi.setVisible(true);
    }//GEN-LAST:event_btnconsulta_historiaActionPerformed

    private void txtid_historiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_historiaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_historiaKeyTyped

    private void txttituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttituloKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_txttituloKeyTyped

    private void txtid_especialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_especialidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_especialidadKeyTyped

    private void btnconsulta_especialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_especialidadActionPerformed
        frmcons_especialidad ces = new frmcons_especialidad();
        ces.setVisible(true);
        ces.lbltitulo_cons.setText("Consulta Especialidad para Reserva");
    }//GEN-LAST:event_btnconsulta_especialidadActionPerformed

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtid_especialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_especialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_especialidadActionPerformed

    private void txthora_de_citaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txthora_de_citaFocusLost
        if (isTime(txthora_de_cita.getText())) {

        } else {
            JOptionPane.showMessageDialog(null, "hora incorecta", "verificacion de hora", JOptionPane.WARNING_MESSAGE);
            txthora_de_cita.requestFocus();
        }
    }//GEN-LAST:event_txthora_de_citaFocusLost

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
//            java.util.logging.Logger.getLogger(frmmanreserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmmanreserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmmanreserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmmanreserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmmanreserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsulta_especialidad;
    private javax.swing.JButton btnconsulta_historia;
    private javax.swing.JButton btnconsulta_medico;
    private javax.swing.JButton btnconsulta_usuario;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cboestado;
    private javax.swing.JComboBox<String> cbopago;
    private javax.swing.JCheckBox chxweb;
    private com.toedter.calendar.JDateChooser dtcreado_en;
    private com.toedter.calendar.JDateChooser dtfecha_de_cita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblreserva;
    private javax.swing.JTextArea txamensaje;
    private javax.swing.JTextArea txanota;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txthora_de_cita;
    public static javax.swing.JTextField txtid_especialidad;
    public static javax.swing.JTextField txtid_historia;
    public static javax.swing.JTextField txtid_medico;
    private javax.swing.JTextField txtid_reserva;
    public static javax.swing.JTextField txtid_usuario;
    public static javax.swing.JTextField txtnombre_especialidad;
    public static javax.swing.JTextField txtnombre_historia;
    public static javax.swing.JTextField txtnombre_medico;
    public static javax.swing.JTextField txtnombre_usuario;
    public static javax.swing.JTextField txtnombreuserlog;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txttitulo;
    public static javax.swing.JTextField txtusuariolog;
    // End of variables declaration//GEN-END:variables
}
