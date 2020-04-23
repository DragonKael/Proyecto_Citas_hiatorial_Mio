package VISTA;

import CONSULTAS.frmcons_especialidad;
import CONTROLADOR.cmedico;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class frmmanmedico extends javax.swing.JFrame {

    Calendar gregcal = new GregorianCalendar();
    cmedico ocmedico = new cmedico();
    boolean es_activo, es_favorito;
    Date fecha_datetime;
    String fecha_texto;
    String fecha_hora;
    String ruta = null;
    String gen;
    String grupo_sangre;
    String nu, no, apa, ama, em, co;
    int hora, minutos, segundos;

    public frmmanmedico() {
        initComponents();
        listar_medico("");
        txtid_medico.setEnabled(false);
        txtid_especialidad.setEnabled(false);
        txtnombre_especialidad.setEnabled(false);
        btnnuevo.setEnabled(true);
        txtusuariolog.setEnabled(false);
        txtnombreuserlog.setEnabled(false);
        estado_inicial();
    }

    void estado_inicial() {
        txtcod_personal.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapaterno.setEnabled(false);
        txtamaterno.setEnabled(false);
        rbman.setEnabled(false);
        rbwoman.setEnabled(false);
        txtemail.setEnabled(false);
        dtfecha_nace.setEnabled(false);
        txtdireccion.setEnabled(false);
        txttelefono.setEnabled(false);
        btnseleccionar_imagen.setEnabled(false);
        chxes_activo.setEnabled(false);
        dtcreado_en.setEnabled(false);
        btnconsulta_especialidad.setEnabled(false);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
    }

    void estado_nuevo() {
        txtcod_personal.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapaterno.setEnabled(true);
        txtamaterno.setEnabled(true);
        rbman.setEnabled(true);
        rbwoman.setEnabled(true);
        txtemail.setEnabled(true);
        dtfecha_nace.setEnabled(true);
        txtdireccion.setEnabled(true);
        txttelefono.setEnabled(true);
        btnseleccionar_imagen.setEnabled(true);
        btnconsulta_especialidad.setEnabled(true);
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
    }

    void listar_medico(String pbuscar) {
        DefaultTableModel modelomedico = ocmedico.listar_medico(pbuscar);
        tblmedico.setModel(modelomedico);
    }

    void insertar_medico() {
        String mensaje = "";
        /////
        fecha_hora_cancat();//        
        /////
        genero();
        /////
        probando_jalar_imagen();
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
                        if (txtcod_personal.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Agrege nombre_medico");

                            sin_perdida();
                        } else {
                            mensaje = ocmedico.insertar_medico(
                                    txtcod_personal.getText(),
                                    txtnombre.getText(),
                                    txtapaterno.getText(),
                                    txtamaterno.getText(),
                                    gen,//genero
                                    fecha_hora,//nacimiento
                                    txtemail.getText(),
                                    txtdireccion.getText(),
                                    txttelefono.getText(),
                                    ruta,//imagen
                                    fecha_hora,Integer.parseInt(
                                    txtid_especialidad.getText())
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

    void modificar_medico() {
        String mensaje = "";
        /////
        fecha_hora_cancat();
        /////
        chboxes_boolean();
        /////
        genero();
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
                        if (txtcod_personal.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Agrege un nombre de medico apropiado");
                       } else {
                                    
                                    mensaje = ocmedico.modificar_medico(Integer.parseInt(
                                    txtid_medico.getText()),
                                    txtcod_personal.getText(),
                                    txtnombre.getText(),
                                    txtapaterno.getText(),
                                    txtamaterno.getText(),
                                    gen,//genero
                                    fecha_hora,//nacimiento
                                    txtemail.getText(),
                                    txtdireccion.getText(),
                                    txttelefono.getText(),
                                    ruta,//imagen 
                                    es_activo,
                                    fecha_hora,Integer.parseInt(
                                    txtid_especialidad.getText())
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

    void probando_jalar_imagen() {
        //dao         

        FileInputStream fi = null;

        File file = new File(ruta);
        try {
            fi = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmmanmedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // guardar
        String url = lblurl.getText();
        if (url.trim().length() != 0) {
//             ruta;
        } else {
            JOptionPane.showMessageDialog(null, "No debe dejar los campos vacios: Imagen");
        }
    }
    void seleccionar_ruta(){
        fcruta.setCurrentDirectory(new File("Imagenes/"));
        int ap = fcruta.showOpenDialog(this);

        if (ap == JFileChooser.APPROVE_OPTION) {
            ruta = fcruta.getSelectedFile().getAbsolutePath();
            lbimagen.setIcon(new ImageIcon(ruta));
            lblurl.setText(ruta);
        }
    }
    
    void recuperar_ruta(){
        int filasel = tblmedico.getSelectedRow();
        String ruta_retorno=(tblmedico.getValueAt(filasel, 10))+""; 
        File img_recu=new File("ruta_retorno");
        fcruta.setSelectedFile(img_recu);        
        lbimagen.setIcon(new ImageIcon(ruta_retorno));
        lblurl.setText(ruta_retorno);
        
    }

    void genero() {
        if (rbman.isSelected() == true) {
            gen = "M";
        }
        if (rbwoman.isSelected() == true) {
            gen = "F";
        }        
    }
    void recuperar_genero() {
        int filasel = tblmedico.getSelectedRow();
        if ((tblmedico.getValueAt(filasel, 5)).equals("M")) {
            rbman.setSelected(true);
        } 
        if ((tblmedico.getValueAt(filasel, 5)).equals("F")) {
            rbwoman.setSelected(true);
        } 
    }  
    
    void sin_perdida() {
        nu = txtcod_personal.getText();
        no = txtnombre.getText();
        apa = txtapaterno.getText();
        ama = txtamaterno.getText();
        em = txtemail.getText();
        txtcod_personal.setText(nu);
        txtnombre.setText(no);
        txtapaterno.setText(apa);
        txtamaterno.setText(ama);
        txtemail.setText(em);
    }

    void chboxes_boolean() {
        if (chxes_activo.isSelected() == true) {
            es_activo = true;
        } else {
            es_activo = false;
        }        
    }

    void chboxes_string() {
        int filasel = tblmedico.getSelectedRow();
        if ((tblmedico.getValueAt(filasel, 11)).equals("1")) {
            chxes_activo.setSelected(true);
        } else {
            chxes_activo.setSelected(false);
        }        
    }

    public void recuperardatos() {
        int filasel = tblmedico.getSelectedRow();
        if (filasel >= 0) {
            txtid_medico.setText(tblmedico.getValueAt(filasel, 0) + "");
            txtcod_personal.setText(tblmedico.getValueAt(filasel, 1) + "");
            txtnombre.setText(tblmedico.getValueAt(filasel, 2) + "");
            txtapaterno.setText(tblmedico.getValueAt(filasel, 3) + "");
            txtamaterno.setText(tblmedico.getValueAt(filasel, 4) + "");
            recuperar_genero();
            String fecha_nace = tblmedico.getValueAt(filasel, 6) + "";
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fecha_datetime = formato.parse(fecha_nace);
                dtfecha_nace.setDate(fecha_datetime);
            } catch (ParseException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }            
            txtemail.setText(tblmedico.getValueAt(filasel, 7) + "");
            txtdireccion.setText(tblmedico.getValueAt(filasel,8)+"");
            txttelefono.setText(tblmedico.getValueAt(filasel,9)+"");
            recuperar_ruta();
            chboxes_string();
            String fecha_crea = tblmedico.getValueAt(filasel, 12) + "";
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fecha_datetime = formato.parse(fecha_crea);
                dtcreado_en.setDate(fecha_datetime);
            } catch (ParseException ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
            txtid_especialidad.setText(tblmedico.getValueAt(filasel,13)+"");
        }
    }

    void limpiar() {
        txtid_medico.setText(null);
        txtcod_personal.setText(null);
        txtnombre.setText(null);
        txtapaterno.setText(null);
        txtamaterno.setText(null);
        btggenero.clearSelection();
        dtfecha_nace.setDate(null);
        txtemail.setText(null);
        txtdireccion.setText(null);
        txttelefono.setText(null);
        txtid_especialidad.setText(null);
        txtnombre_especialidad.setText(null);
        lbimagen.setIcon(null);
        lblurl.setText(null);
        chxes_activo.setSelected(false);
        dtcreado_en.setDate(null);
    }

    void eliminar_registro() {
        ocmedico.eliminar_medico(Integer.parseInt(txtid_medico.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btggenero = new javax.swing.ButtonGroup();
        fcruta = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        txtid_medico = new javax.swing.JTextField();
        txtapaterno = new javax.swing.JTextField();
        txtamaterno = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmedico = new javax.swing.JTable();
        txtemail = new javax.swing.JTextField();
        txtcod_personal = new javax.swing.JTextField();
        chxes_activo = new javax.swing.JCheckBox();
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
        dtfecha_nace = new com.toedter.calendar.JDateChooser();
        pgenero = new javax.swing.JPanel();
        rbman = new javax.swing.JRadioButton();
        rbwoman = new javax.swing.JRadioButton();
        txtdireccion = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        lbimagen = new javax.swing.JLabel();
        btnseleccionar_imagen = new javax.swing.JButton();
        lblurl = new javax.swing.JLabel();
        txtid_especialidad = new javax.swing.JTextField();
        txtnombre_especialidad = new javax.swing.JTextField();
        btnconsulta_especialidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO DE MEDICOS");

        txtid_medico.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Medico"));

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA DE REGISTRO DE MEDICO"));

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

        tblmedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmedico);

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

        txtcod_personal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Codigo Personal"));
        txtcod_personal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcod_personalKeyTyped(evt);
            }
        });

        chxes_activo.setText("Es Activo");

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

        dtfecha_nace.setBorder(javax.swing.BorderFactory.createTitledBorder("Dia Nacimiento"));
        dtfecha_nace.setDateFormatString("yyyy/MM/dd");

        pgenero.setBorder(javax.swing.BorderFactory.createTitledBorder("Genero"));

        btggenero.add(rbman);
        rbman.setText("Masculino");

        btggenero.add(rbwoman);
        rbwoman.setText("Femenino");

        javax.swing.GroupLayout pgeneroLayout = new javax.swing.GroupLayout(pgenero);
        pgenero.setLayout(pgeneroLayout);
        pgeneroLayout.setHorizontalGroup(
            pgeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgeneroLayout.createSequentialGroup()
                .addGroup(pgeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbman, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(rbwoman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pgeneroLayout.setVerticalGroup(
            pgeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgeneroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbman)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbwoman)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtdireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Direccion"));
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        txttelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "telefono"));
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        lbimagen.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen"));

        btnseleccionar_imagen.setText("SELECCIONAR");
        btnseleccionar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionar_imagenActionPerformed(evt);
            }
        });

        txtid_especialidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Especialidad"));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblurl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtapaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtid_medico, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtcod_personal, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtamaterno)
                    .addComponent(dtfecha_nace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(lbimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(btnseleccionar_imagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(559, 559, 559))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pgenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chxes_activo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtid_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txtnombre_especialidad)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnconsulta_especialidad)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dtcreado_en, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnseleccionar_imagen, chxes_activo, dtcreado_en, dtfecha_nace, lbimagen, lblurl, pgenero, txtamaterno, txtapaterno, txtcod_personal, txtdireccion, txtemail, txtid_medico, txtnombre, txttelefono});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcod_personal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtamaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtfecha_nace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnseleccionar_imagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblurl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chxes_activo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtid_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtnombre_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnconsulta_especialidad)))
                                    .addComponent(dtcreado_en, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chxes_activo, dtcreado_en, dtfecha_nace, txtamaterno, txtapaterno, txtcod_personal, txtdireccion, txtemail, txtid_medico, txtnombre, txttelefono});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        insertar_medico();
        listar_medico("");

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar_medico();
        listar_medico("");
        limpiar();
        estado_inicial();

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tblmedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmedicoMouseClicked
        chxes_activo.setEnabled(true);
        dtcreado_en.setEnabled(true);
        recuperardatos();
        estado_nuevo();
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_tblmedicoMouseClicked

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
        listar_medico(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        listar_medico(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_registro();
        listar_medico("");
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        MessageFormat cabeceradocumento = new MessageFormat("Lista de Medicos");
        MessageFormat piedocumento = new MessageFormat("-pagina(0) -");
        try {
            tblmedico.print(JTable.PrintMode.FIT_WIDTH, cabeceradocumento, piedocumento);
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

    private void txtcod_personalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcod_personalKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_txtcod_personalKeyTyped

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

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void btnseleccionar_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionar_imagenActionPerformed
        seleccionar_ruta();

    }//GEN-LAST:event_btnseleccionar_imagenActionPerformed

    private void txtid_especialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_especialidadKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtid_especialidadKeyTyped

    private void btnconsulta_especialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta_especialidadActionPerformed
        // TODO add your handling code here:
        frmcons_especialidad ces = new frmcons_especialidad();
        ces.setVisible(true);
        ces.lbltitulo_cons.setText("Consulta Especialidad para Medico");
    }//GEN-LAST:event_btnconsulta_especialidadActionPerformed

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
//            java.util.logging.Logger.getLogger(frmmanmedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmmanmedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmmanmedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmmanmedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmmanmedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btggenero;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsulta_especialidad;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnseleccionar_imagen;
    private javax.swing.JCheckBox chxes_activo;
    private com.toedter.calendar.JDateChooser dtcreado_en;
    private com.toedter.calendar.JDateChooser dtfecha_nace;
    private javax.swing.JFileChooser fcruta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbimagen;
    private javax.swing.JLabel lblurl;
    private javax.swing.JPanel pgenero;
    private javax.swing.JRadioButton rbman;
    private javax.swing.JRadioButton rbwoman;
    private javax.swing.JTable tblmedico;
    private javax.swing.JTextField txtamaterno;
    private javax.swing.JTextField txtapaterno;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcod_personal;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    public static javax.swing.JTextField txtid_especialidad;
    private javax.swing.JTextField txtid_medico;
    private javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtnombre_especialidad;
    public static javax.swing.JTextField txtnombreuserlog;
    private javax.swing.JTextField txttelefono;
    public static javax.swing.JTextField txtusuariolog;
    // End of variables declaration//GEN-END:variables
}
