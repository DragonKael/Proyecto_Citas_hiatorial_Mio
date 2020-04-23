package VISTA;

import CONTROLADOR.cusuario;
import java.awt.Toolkit;
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

public class frmmanusuario extends javax.swing.JFrame {

    Calendar gregcal = new GregorianCalendar();
    cusuario ocusuario = new cusuario();
    boolean es_activo, es_administrador;
    Date fecha_datetime;
    String fecha_texto;
    String fecha_hora;
    String nu, no, apa, ama, em, co;
    int hora, minutos, segundos;

    public frmmanusuario() {
        initComponents();
        listar_usuario("");
        txtid_usuario.setEnabled(false);
        txtusuariolog.setEnabled(false);
        txtnombreuserlog.setEnabled(false);
        estado_inicial();
    }

    void estado_inicial() {
        txtnombre_usuario.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapaterno.setEnabled(false);
        txtamaterno.setEnabled(false);
        txtemail.setEnabled(false);
        chxes_activo.setEnabled(false);
        chxes_administrador.setEnabled(false);
        txpcontrasenia.setEnabled(false);
        txpconfirmarcontrasenia.setEnabled(false);
        dtcreado_en.setEnabled(false);
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
    }

    void estado_nuevo() {
        txtnombre_usuario.setEnabled(true);
        txtapaterno.setEnabled(true);
        txtamaterno.setEnabled(true);
        txtnombre.setEnabled(true);
        txtemail.setEnabled(true);
        txtnombre_usuario.setEnabled(true);
        txpcontrasenia.setEnabled(true);
        txpconfirmarcontrasenia.setEnabled(true);
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

    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
//            System.out.println("[" + mat.group() + "]");
            return true;
        } else {
            return false;
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

    void listar_usuario(String pbuscar) {
        DefaultTableModel modelousuario = ocusuario.listar_usuario(pbuscar);
        tblusuario.setModel(modelousuario);
    }

    void insertar_usuario() {
        String mensaje = "";
        /////
        fecha_hora_cancat();//        
        /////
        if (txtapaterno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agrege APaterno");
        } else {
            if (txtamaterno.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Agrege AMaterno");
            } else {
                if (txtnombre.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Agrege Nombre");
                } else {
                    if (txtemail.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Agrege email");
                    } else {
                        if (txtnombre_usuario.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Agrege nombre_usuario");
                        } else {
                            if (txpcontrasenia.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Agrege contrasenia");
                            } else {
                                if (!txpcontrasenia.getText().equals(txpconfirmarcontrasenia.getText())) {
                                    JOptionPane.showConfirmDialog(null, "las contrasenias no coinciden");
                                    sin_perdida();
                                } else {
                                    mensaje = ocusuario.insertar_usuario(
                                            txtnombre_usuario.getText(),
                                            txtnombre.getText(),
                                            txtapaterno.getText(),
                                            txtamaterno.getText(),
                                            txtemail.getText(),
                                            txpcontrasenia.getText(),
                                            fecha_hora
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
        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void modificar_usuario() {
        String mensaje = "";
        /////
        fecha_hora_cancat();
        /////
        chboxes_boolean();
        /////
        if (txtapaterno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agrege APaterno");
        } else {
            if (txtamaterno.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Agrege AMaterno");
            } else {
                if (txtnombre.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Agrege Nombre");
                } else {
                    if (txtemail.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Agrege email");
                    } else {
                        if (txtnombre_usuario.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Agrege un nombre de usuario apropiado");
                        } else {
                            if (txpcontrasenia.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Agrege contrasenia");
                            } else {
                                if (!txpcontrasenia.getText().equals(txpconfirmarcontrasenia.getText())) {
                                    JOptionPane.showConfirmDialog(null, "las contrasenias no coinciden");
                                } else {
                                    chboxes_boolean();
                                    mensaje = ocusuario.modificar_usuario(Integer.parseInt(
                                            txtid_usuario.getText()),
                                            txtnombre_usuario.getText(),
                                            txtnombre.getText(),
                                            txtapaterno.getText(),
                                            txtamaterno.getText(),
                                            txtemail.getText(),
                                            txpcontrasenia.getText(),
                                            es_activo,
                                            es_administrador,
                                            fecha_hora
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
        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void sin_perdida() {
        nu = txtnombre_usuario.getText();
        no = txtnombre.getText();
        apa = txtapaterno.getText();
        ama = txtamaterno.getText();
        em = txtemail.getText();
        co = txpcontrasenia.getText();
        txtnombre_usuario.setText(nu);
        txtnombre.setText(no);
        txtapaterno.setText(apa);
        txtamaterno.setText(ama);
        txtemail.setText(em);
        txpcontrasenia.setText(co);
    }

    void chboxes_boolean() {
        if (chxes_activo.isSelected() == true) {
            es_activo = true;
        } else {
            es_activo = false;
        }
        if (chxes_administrador.isSelected() == true) {
            es_administrador = true;
        } else {
            es_administrador = false;
        }
    }

    void chboxes_string() {
        int filasel = tblusuario.getSelectedRow();
        if ((tblusuario.getValueAt(filasel, 7)).equals("1")) {
            chxes_activo.setSelected(true);
        } else {
            chxes_activo.setSelected(false);
        }
        if ((tblusuario.getValueAt(filasel, 8)).equals("1")) {
            chxes_administrador.setSelected(true);
        } else {
            chxes_administrador.setSelected(false);
        }
    }

    public void recuperardatos() {
        int filasel = tblusuario.getSelectedRow();
        if (filasel >= 0) {
            txtid_usuario.setText(tblusuario.getValueAt(filasel, 0) + "");
            txtnombre_usuario.setText(tblusuario.getValueAt(filasel, 1) + "");
            txtnombre.setText(tblusuario.getValueAt(filasel, 2) + "");
            txtapaterno.setText(tblusuario.getValueAt(filasel, 3) + "");
            txtamaterno.setText(tblusuario.getValueAt(filasel, 4) + "");
            txtemail.setText(tblusuario.getValueAt(filasel, 5) + "");
            chboxes_string();
//            txpcontrasenia.setText(tblusuario.getValueAt(filasel, 6) + "");
            String fecha = tblusuario.getValueAt(filasel, 9) + "";
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fecha_datetime = formato.parse(fecha);
                dtcreado_en.setDate(fecha_datetime);
            } catch (ParseException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
        }
    }

    void limpiar() {
        txtid_usuario.setText(null);
        txtnombre_usuario.setText(null);
        txtnombre.setText(null);
        txtapaterno.setText(null);
        txtamaterno.setText(null);
        txtemail.setText(null);
        chxes_activo.setSelected(false);
        chxes_administrador.setSelected(false);
        txpcontrasenia.setText(null);
        txpconfirmarcontrasenia.setText(null);
        dtcreado_en.setDate(null);
    }

    void eliminar_registro() {
        ocusuario.eliminar_usuario(Integer.parseInt(txtid_usuario.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtid_usuario = new javax.swing.JTextField();
        txtapaterno = new javax.swing.JTextField();
        txtamaterno = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuario = new javax.swing.JTable();
        txtemail = new javax.swing.JTextField();
        txtnombre_usuario = new javax.swing.JTextField();
        lblnumerocaracteres = new javax.swing.JLabel();
        chxes_activo = new javax.swing.JCheckBox();
        chxes_administrador = new javax.swing.JCheckBox();
        txpconfirmarcontrasenia = new javax.swing.JPasswordField();
        txpcontrasenia = new javax.swing.JPasswordField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO USUARIO");

        txtid_usuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Usuario"));

        txtapaterno.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellido Paterno"));
        txtapaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapaternoKeyTyped(evt);
            }
        });

        txtamaterno.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellido Materno"));
        txtamaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtamaternoKeyTyped(evt);
            }
        });

        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Nombre"));
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA DE REGISTRO DE USUARIO"));

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

        tblusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblusuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblusuario);

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

        txtemail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Email"));
        txtemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemailFocusLost(evt);
            }
        });
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailKeyTyped(evt);
            }
        });

        txtnombre_usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Nombre de Usuario"));
        txtnombre_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre_usuarioKeyTyped(evt);
            }
        });

        chxes_activo.setText("Es activo");

        chxes_administrador.setText("Es Administrador");

        txpconfirmarcontrasenia.setBorder(javax.swing.BorderFactory.createTitledBorder("confirma_contrasenia"));

        txpcontrasenia.setBorder(javax.swing.BorderFactory.createTitledBorder("contrasenia"));
        txpcontrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txpcontraseniaKeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txpcontrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtamaterno)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chxes_activo)
                    .addComponent(chxes_administrador)
                    .addComponent(txpconfirmarcontrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtcreado_en, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnumerocaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(591, 591, 591)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {chxes_activo, chxes_administrador, dtcreado_en, txpconfirmarcontrasenia, txpcontrasenia, txtamaterno, txtapaterno, txtemail, txtid_usuario, txtnombre, txtnombre_usuario});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtamaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chxes_activo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chxes_administrador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txpcontrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblnumerocaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txpconfirmarcontrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtcreado_en, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(22, 22, 22)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chxes_activo, chxes_administrador, dtcreado_en, txpconfirmarcontrasenia, txpcontrasenia, txtamaterno, txtapaterno, txtemail, txtid_usuario, txtnombre, txtnombre_usuario});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        insertar_usuario();
        listar_usuario("");

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar_usuario();
        listar_usuario("");
        limpiar();
        estado_inicial();

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tblusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblusuarioMouseClicked
        chxes_activo.setEnabled(true);
        chxes_administrador.setEnabled(true);
        dtcreado_en.setEnabled(true);
        recuperardatos();
        estado_nuevo();
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_tblusuarioMouseClicked

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
        listar_usuario(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        listar_usuario(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_registro();
        listar_usuario("");
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        MessageFormat cabeceradocumento = new MessageFormat("Lista de Usuarios");
        MessageFormat piedocumento = new MessageFormat("-pagina(0) -");
        try {
            tblusuario.print(JTable.PrintMode.FIT_WIDTH, cabeceradocumento, piedocumento);
        } catch (PrinterException ex) {
            JOptionPane.showConfirmDialog(rootPane, "No se puede imprimir este documento");
        }
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtapaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapaternoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_txtapaternoKeyTyped

    private void txtamaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtamaternoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_txtamaternoKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
//        char validar=evt.getKeyChar();
//        
//        if(Character.isLetter(validar)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(rootPane,"Ingresar solo numeros");
//        }
//        if(txtemail.getText().length() >= 8){
//            evt.consume();
//            Toolkit.getDefaultToolkit().beep();
//        }
//        if(txtemail.getText().length() == 8){
//            JOptionPane.showMessageDialog(null, "numeros llenos");
//        }
    }//GEN-LAST:event_txtemailKeyTyped

    private void txtnombre_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre_usuarioKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_txtnombre_usuarioKeyTyped

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusLost
        if (isEmail(txtemail.getText())) {

        } else {
            JOptionPane.showMessageDialog(null, "email incorecto", "verificacion de email", JOptionPane.WARNING_MESSAGE);
            txtemail.requestFocus();
        }
    }//GEN-LAST:event_txtemailFocusLost

    private void txpcontraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpcontraseniaKeyReleased
         char validar=evt.getKeyChar();
        if(txpcontrasenia.getText().length() <= 7){
            Toolkit.getDefaultToolkit().beep();
            lblnumerocaracteres.setText("necesita 8 caracteres como minimo");
        }
        else
        {
            lblnumerocaracteres.setText(null);
        }
    }//GEN-LAST:event_txpcontraseniaKeyReleased

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
//            java.util.logging.Logger.getLogger(frmmanusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmmanusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmmanusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmmanusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmmanusuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JCheckBox chxes_activo;
    private javax.swing.JCheckBox chxes_administrador;
    private com.toedter.calendar.JDateChooser dtcreado_en;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnumerocaracteres;
    private javax.swing.JTable tblusuario;
    private javax.swing.JPasswordField txpconfirmarcontrasenia;
    private javax.swing.JPasswordField txpcontrasenia;
    private javax.swing.JTextField txtamaterno;
    private javax.swing.JTextField txtapaterno;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid_usuario;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombre_usuario;
    public static javax.swing.JTextField txtnombreuserlog;
    public static javax.swing.JTextField txtusuariolog;
    // End of variables declaration//GEN-END:variables
}
