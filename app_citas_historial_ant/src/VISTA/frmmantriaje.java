package VISTA;

import CONTROLADOR.ctriaje;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.GregorianCalendar;

public class frmmantriaje extends javax.swing.JFrame {

    Calendar gregcal = new GregorianCalendar();
    ctriaje octriaje = new ctriaje();
    boolean es_activo, es_favorito;
    Date fecha_datetime;
    String fecha_texto;
    String fecha_hora;
    String ruta = null;
    String gen;
    String tiempo_atencion, nivel, color, categoria;
    String nu, no, apa, ama, em, co;
    int hora, minutos, segundos;

    public frmmantriaje() {
        initComponents();
        listar_triaje("");
        txtid_triaje.setEnabled(false);
        txtusuariolog.setEnabled(false);
        txtnombreuserlog.setEnabled(false);
        estado_inicial();
    }

    void estado_inicial() {
        txtpeso.setEnabled(false);
        txttalla.setEnabled(false);
        txtpresion_sanguinea.setEnabled(false);
        cbotiempo_atencion.setEnabled(false);
        cbocategoria.setEnabled(false);
        cbocolor.setEnabled(false);
        cbonivel.setEnabled(false);
        txadescripcion.setEnabled(false);
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
    }

    void estado_nuevo() {
        txtpeso.setEnabled(true);
        txttalla.setEnabled(true);
        txtpresion_sanguinea.setEnabled(true);
        cbotiempo_atencion.setEnabled(true);
        cbocategoria.setEnabled(true);
        cbocolor.setEnabled(true);
        cbonivel.setEnabled(true);
        txadescripcion.setEnabled(true);
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
    }

    void listar_triaje(String pbuscar) {
        DefaultTableModel modelotriaje = octriaje.listar_triaje(pbuscar);
        tbltriaje.setModel(modelotriaje);
    }

    void insertar_triaje() {
        String mensaje = "";
        /////
        grupo_categoria_string();
        /////
        grupo_color_string();
        /////
        grupo_nivel_string();
        /////
        grupo_tiempo_antecion_string();
        /////
        if (cbotiempo_atencion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione tiempo");
        } else {
            if (cbocolor.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione color");
            } else {
                if (cbocategoria.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione categoria");
                } else {
                    if (cbonivel.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Seleccione nivel");
                    } else {
                        if (txtpresion_sanguinea.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Agrege precion");
                        } else {
                            if (txadescripcion.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Agrege descripcion");
                            } else {
                                if (txttalla.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Agrege talla");
                                } else {
                                    if (txtpeso.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Agrege peso");
                                        sin_perdida();
                                    } else {
                                        mensaje = octriaje.insertar_triaje(Double.parseDouble(
                                                txtpeso.getText()), Double.parseDouble(
                                                txttalla.getText()), Double.parseDouble(
                                                txtpresion_sanguinea.getText()),
                                                nivel,
                                                color,
                                                categoria,
                                                tiempo_atencion,
                                                txadescripcion.getText()
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

        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void modificar_triaje() {
        String mensaje = "";
        /////
        grupo_categoria_string();
        /////
        grupo_color_string();
        /////
        grupo_nivel_string();
        /////
        grupo_tiempo_antecion_string();
        /////        
        if (cbotiempo_atencion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione tiempo");
        } else {
            if (cbocolor.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione color");
            } else {
                if (cbocategoria.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione categoria");
                } else {
                    if (cbonivel.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Seleccione nivel");
                    } else {
                        if (txtpresion_sanguinea.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Agrege precion");
                        } else {
                            if (txadescripcion.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Agrege descripcion");
                            } else {
                                if (txttalla.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Agrege talla");
                                } else {
                                    if (txtpeso.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Agrege peso");
                                        sin_perdida();
                                    } else {
                                        mensaje = octriaje.modificar_triaje(Integer.parseInt(
                                                txtid_triaje.getText()), Double.parseDouble(
                                                txtpeso.getText()), Double.parseDouble(
                                                txttalla.getText()), Double.parseDouble(
                                                txtpresion_sanguinea.getText()),
                                                nivel,
                                                color,
                                                categoria,
                                                tiempo_atencion,
                                                txadescripcion.getText()
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

        JOptionPane.showConfirmDialog(null, mensaje);
    }

    void grupo_tiempo_antecion_string() {
        int cbosel = cbotiempo_atencion.getSelectedIndex();
        switch (cbosel) {
            case 1:
                tiempo_atencion = "Inmediatamente";
                break;
            case 2:
                tiempo_atencion = "< 7 min";
                break;
            case 3:
                tiempo_atencion = "< 30 min";
                break;
            case 4:
                tiempo_atencion = "< 48 min";
                break;
            case 5:
                tiempo_atencion = "< 60 min";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la seleccion del tiempo de atencion");

        }
    }

    void recuperar_tiempo_antencion() {
        int filasel = tbltriaje.getSelectedRow();
        String g_s = tbltriaje.getValueAt(filasel, 7) + "";
        //int cbosel=cbogrupo_sanguineo.getSelectedIndex();
        switch (g_s) {
            case "Inmediatamente":
                cbotiempo_atencion.setSelectedIndex(1);
                break;
            case "< 7 min":
                cbotiempo_atencion.setSelectedIndex(2);
                break;
            case "< 30 min":
                cbotiempo_atencion.setSelectedIndex(3);
                break;
            case "< 48 min":
                cbotiempo_atencion.setSelectedIndex(4);
                break;
            case "< 60 min":
                cbotiempo_atencion.setSelectedIndex(5);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la recuperacion de tiempo de atencion");
                cbotiempo_atencion.setSelectedIndex(0);
        }
    }

    void grupo_color_string() {
        int cbosel = cbocolor.getSelectedIndex();
        switch (cbosel) {
            case 1:
                color = "Azul";
                break;
            case 2:
                color = "Rojo";
                break;
            case 3:
                color = "Anaranjado";
                break;
            case 4:
                color = "Verde";
                break;
            case 5:
                color = "Negro";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la seleccion del color");
        }
    }

    void recuperar_color() {
        int filasel = tbltriaje.getSelectedRow();
        String g_s = tbltriaje.getValueAt(filasel, 5) + "";
        //int cbosel=cbogrupo_sanguineo.getSelectedIndex();
        switch (g_s) {
            case "Azul":
                cbocolor.setSelectedIndex(1);
                this.getContentPane().setBackground(Color.blue);
                break;
            case "Rojo":
                cbocolor.setSelectedIndex(2);
                this.getContentPane().setBackground(Color.red);
                break;
            case "Anaranjado":
                cbocolor.setSelectedIndex(3);
                this.getContentPane().setBackground(Color.orange);
                break;
            case "Verde":
                cbocolor.setSelectedIndex(4);
                this.getContentPane().setBackground(Color.green);
                break;
            case "Negro":
                cbocolor.setSelectedIndex(5);
                this.getContentPane().setBackground(Color.darkGray);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la recuperacion del color");
                cbocolor.setSelectedIndex(0);
                this.getContentPane().setBackground(null);
        }
    }

    void grupo_nivel_string() {
        int cbosel = cbonivel.getSelectedIndex();
        switch (cbosel) {
            case 1:
                nivel = "Nivel I";
                break;
            case 2:
                nivel = "Nivel II";
                break;
            case 3:
                nivel = "Nivel III";
                break;
            case 4:
                nivel = "Nivel IV";
                break;
            case 5:
                nivel = "Nivel V";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la seleccion del nivel");
        }
    }

    void recuperar_nivel() {
        int filasel = tbltriaje.getSelectedRow();
        String g_s = tbltriaje.getValueAt(filasel, 4) + "";
        //int cbosel=cbogrupo_sanguineo.getSelectedIndex();
        switch (g_s) {
            case "Nivel I":
                cbonivel.setSelectedIndex(1);
                break;
            case "Nivel II":
                cbonivel.setSelectedIndex(2);
                break;
            case "Nivel III":
                cbonivel.setSelectedIndex(3);
                break;
            case "Nivel IV":
                cbonivel.setSelectedIndex(4);
                break;
            case "Nivel V":
                cbonivel.setSelectedIndex(5);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la recuperacion del nivel ");
                cbonivel.setSelectedIndex(0);
        }
    }

    void grupo_categoria_string() {
        int cbosel = cbocategoria.getSelectedIndex();
        switch (cbosel) {
            case 1:
                categoria = "Reanimacion";
                break;
            case 2:
                categoria = "Emergencia";
                break;
            case 3:
                categoria = "Urgente";
                break;
            case 4:
                categoria = "Menos Urg.";
                break;
            case 5:
                categoria = "No Urgente";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la seleccion de la categoria");
        }
    }

    void recuperar_categoria() {
        int filasel = tbltriaje.getSelectedRow();
        String g_s = tbltriaje.getValueAt(filasel, 6) + "";
        //int cbosel=cbogrupo_sanguineo.getSelectedIndex();
        switch (g_s) {
            case "Reanimacion":
                cbocategoria.setSelectedIndex(1);
                break;
            case "Emergencia":
                cbocategoria.setSelectedIndex(2);
                break;
            case "Urgente":
                cbocategoria.setSelectedIndex(3);
                break;
            case "Menos Urg.":
                cbocategoria.setSelectedIndex(4);
                break;
            case "No Urgente":
                cbocategoria.setSelectedIndex(5);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error en la recuperacion de la categoria");
                cbocategoria.setSelectedIndex(0);
        }
    }

    void sin_perdida() {
        nu = txtpeso.getText();
        no = txttalla.getText();
        apa = txtpresion_sanguinea.getText();
        txtpeso.setText(nu);
        txttalla.setText(no);
        txtpresion_sanguinea.setText(apa);
    }

    public void recuperardatos() {
        int filasel = tbltriaje.getSelectedRow();
        if (filasel >= 0) {
            txtid_triaje.setText(tbltriaje.getValueAt(filasel, 0) + "");
            txtpeso.setText(tbltriaje.getValueAt(filasel, 1) + "");
            txttalla.setText(tbltriaje.getValueAt(filasel, 2) + "");
            txtpresion_sanguinea.setText(tbltriaje.getValueAt(filasel, 3) + "");
            recuperar_nivel();
            recuperar_color();
            recuperar_categoria();
            recuperar_tiempo_antencion();
            txadescripcion.setText(tbltriaje.getValueAt(filasel, 8) + "");

        }
    }

    void limpiar() {
        txtid_triaje.setText(null);
        txtpeso.setText(null);
        txttalla.setText(null);
        txtpresion_sanguinea.setText(null);
        txadescripcion.setText(null);
        cbotiempo_atencion.setSelectedIndex(0);
        cbocolor.setSelectedIndex(0);
        cbocategoria.setSelectedIndex(0);
        cbonivel.setSelectedIndex(0);
        this.getContentPane().setBackground(null);
    }

    void eliminar_registro() {
        octriaje.eliminar_triaje(Integer.parseInt(txtid_triaje.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btggenero = new javax.swing.ButtonGroup();
        fcruta = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        txtid_triaje = new javax.swing.JTextField();
        txtpresion_sanguinea = new javax.swing.JTextField();
        txttalla = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltriaje = new javax.swing.JTable();
        txtpeso = new javax.swing.JTextField();
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
        cbotiempo_atencion = new javax.swing.JComboBox<>();
        cbocategoria = new javax.swing.JComboBox<>();
        cbocolor = new javax.swing.JComboBox<>();
        cbonivel = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txadescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO DE TRIAJE");

        txtid_triaje.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Triaje"));

        txtpresion_sanguinea.setBorder(javax.swing.BorderFactory.createTitledBorder("Presion Sanguinea"));
        txtpresion_sanguinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpresion_sanguineaKeyTyped(evt);
            }
        });

        txttalla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Talla"));
        txttalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttallaKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA DE REGISTRO DE PACIENTE"));

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

        tbltriaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltriajeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltriaje);

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

        txtpeso.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Peso"));
        txtpeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpesoKeyTyped(evt);
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

        cbotiempo_atencion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECCION-", "Inmediato", "< 7 min", "< 30 min", "< 48 min", "< 60 min" }));
        cbotiempo_atencion.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiempo Atencion"));

        cbocategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECCION-", "Reanimacion", "Emergencia", "Urgente", "Menos Urg.", "No Urgente" }));
        cbocategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));

        cbocolor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECCION-", "Azul", "Rojo", "Anaranjado", "Verde", "Negro" }));
        cbocolor.setBorder(javax.swing.BorderFactory.createTitledBorder("Color"));
        cbocolor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocolorActionPerformed(evt);
            }
        });

        cbonivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECCION-", "NIVEL I", "NIVEL II", "NIVEL III", "NIVEL IV", "NIVEL V" }));
        cbonivel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nivel"));

        txadescripcion.setColumns(20);
        txadescripcion.setRows(5);
        txadescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jScrollPane2.setViewportView(txadescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbocolor, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbonivel, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpresion_sanguinea, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotiempo_atencion, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid_triaje, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttalla, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(559, 559, 559)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbocategoria, cbocolor, cbonivel, cbotiempo_atencion, jScrollPane2, txtid_triaje, txtpeso, txtpresion_sanguinea, txttalla});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid_triaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpresion_sanguinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbonivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbocolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbotiempo_atencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbotiempo_atencion, txtid_triaje, txtpeso, txtpresion_sanguinea, txttalla});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        insertar_triaje();
        listar_triaje("");

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar_triaje();
        listar_triaje("");
        limpiar();
        estado_inicial();

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tbltriajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltriajeMouseClicked
        recuperardatos();
        estado_nuevo();
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_tbltriajeMouseClicked

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
        listar_triaje(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        listar_triaje(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_registro();
        listar_triaje("");
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        MessageFormat cabeceradocumento = new MessageFormat("Lista de Triaje");
        MessageFormat piedocumento = new MessageFormat("-pagina(0) -");
        try {
            tbltriaje.print(JTable.PrintMode.FIT_WIDTH, cabeceradocumento, piedocumento);
        } catch (PrinterException ex) {
            JOptionPane.showConfirmDialog(rootPane, "No se puede imprimir este documento");
        }
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtpresion_sanguineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpresion_sanguineaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtpresion_sanguineaKeyTyped

    private void txttallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttallaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txttallaKeyTyped

    private void txtpesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtpesoKeyTyped

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
        estado_inicial();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void cbocolorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocolorActionPerformed
        int cbosel = cbocolor.getSelectedIndex();
        if (cbosel >= 0) {
            switch (cbosel) {
                case 1:
                    this.getContentPane().setBackground(Color.blue);
                    break;
                case 2:
                    this.getContentPane().setBackground(Color.red);
                    break;
                case 3:
                    this.getContentPane().setBackground(Color.orange);
                    break;
                case 4:
                    this.getContentPane().setBackground(Color.green);
                    break;
                case 5:
                    this.getContentPane().setBackground(Color.darkGray);
                    break;
                default:
                    this.getContentPane().setBackground(null);
            }
        }
    }//GEN-LAST:event_cbocolorActionPerformed

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
//            java.util.logging.Logger.getLogger(frmmantriaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmmantriaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmmantriaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmmantriaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmmantriaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btggenero;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbocategoria;
    private javax.swing.JComboBox<String> cbocolor;
    private javax.swing.JComboBox<String> cbonivel;
    private javax.swing.JComboBox<String> cbotiempo_atencion;
    private javax.swing.JFileChooser fcruta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbltriaje;
    private javax.swing.JTextArea txadescripcion;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtid_triaje;
    public static javax.swing.JTextField txtnombreuserlog;
    private javax.swing.JTextField txtpeso;
    private javax.swing.JTextField txtpresion_sanguinea;
    private javax.swing.JTextField txttalla;
    public static javax.swing.JTextField txtusuariolog;
    // End of variables declaration//GEN-END:variables
}
