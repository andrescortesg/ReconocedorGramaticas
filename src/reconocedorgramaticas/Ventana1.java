/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocedorgramaticas;

import com.sun.javafx.geom.transform.BaseTransform;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author andres.cortesg
 */
public class Ventana1 extends javax.swing.JFrame {
    String texto;
    JFileChooser fileChooser;
    private Gramatica gram = new Gramatica();
    /**
     * Creates new form NewJFrame
     */
    public Ventana1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        areaDeTexto = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        labelEspecial = new javax.swing.JLabel();
        labelLineal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelRegular = new javax.swing.JLabel();
        botonVerificar = new javax.swing.JButton();
        botonGuardarGramatica = new javax.swing.JButton();
        simplificarBoton = new javax.swing.JButton();
        detectarVMboton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelTVivos = new javax.swing.JLabel();
        LabelTMuertos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        botonAbrir = new javax.swing.JButton();
        botonGuardarArchivo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        labelAlcanzables = new javax.swing.JLabel();
        labelInalcanzables = new javax.swing.JLabel();
        eliminarProdBoton = new javax.swing.JButton();
        eliminarTextfield = new javax.swing.JTextField();
        botonEliminarMI = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reconocedor de Gramaticas");
        setBounds(new java.awt.Rectangle(10, 10, 300, 500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Las gramaticas deben ser escritas asi:\n<S> = a<A><B><S>\n<S> =b<C><A><C>d\n<A> =λ | &\n<C> =c");

        areaDeTexto.setColumns(20);
        areaDeTexto.setRows(5);
        areaDeTexto.setText("<S> = a<A><B><S>\n<S> =b<C><A><C> d\n<A> =b<A><B>\n<A> =c<S><A>\n<A> =c<C><C>\n<B> =b<A><B>\n<B> =c<S><B>\n<C> =c<S>\n<C> =c\n");
        areaDeTexto.setToolTipText("Utiliza el boton Cargar Archivo o digita manualmente la gramatica");
        areaDeTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        areaDeTexto.setDragEnabled(true);
        areaDeTexto.setName("Editor"); // NOI18N

        labelEspecial.setText("Es Especial: _____");

        labelLineal.setText("Es Lineal por la Derecha: _____");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Verificaciones");

        labelRegular.setText("Es Regular: _____");

        botonVerificar.setText("Verificar");
        botonVerificar.setEnabled(false);
        botonVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerificarActionPerformed(evt);
            }
        });

        botonGuardarGramatica.setText("Almacenar Gramatica");
        botonGuardarGramatica.setToolTipText("Guarda la gramatica en memoria para poder verificar");
        botonGuardarGramatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarGramaticaActionPerformed(evt);
            }
        });

        simplificarBoton.setText("Simplificar");
        simplificarBoton.setEnabled(false);
        simplificarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simplificarBotonActionPerformed(evt);
            }
        });

        detectarVMboton.setText("Detectar");
        detectarVMboton.setEnabled(false);
        detectarVMboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detectarVMbotonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Terminales Vivos");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Terminales Muertos");

        labelTVivos.setText("Sin Determinar");

        LabelTMuertos.setText("Sin Determinar");

        botonAbrir.setText("Cargar Archivo");
        botonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirActionPerformed(evt);
            }
        });

        botonGuardarArchivo.setText("Guardar Archivo");
        botonGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarArchivoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText(" Alcanzables");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Inalcanzables");

        labelAlcanzables.setText("Sin determinar");

        labelInalcanzables.setText("Sin determinar");

        eliminarProdBoton.setText("Eliminar");
        eliminarProdBoton.setEnabled(false);
        eliminarProdBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProdBotonActionPerformed(evt);
            }
        });

        eliminarTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTextfieldActionPerformed(evt);
            }
        });

        botonEliminarMI.setText("Eliminar Muertos e Inalcanzables");
        botonEliminarMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarMIActionPerformed(evt);
            }
        });

        jLabel8.setText("Eliminar Produccion de:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonGuardarGramatica)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelRegular)
                                            .addComponent(labelEspecial)
                                            .addComponent(labelLineal))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(simplificarBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(botonVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(botonAbrir)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonGuardarArchivo))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(labelTVivos)
                                            .addComponent(labelAlcanzables))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelTMuertos)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(labelInalcanzables)))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(eliminarProdBoton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(eliminarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(98, 98, 98)
                                        .addComponent(detectarVMboton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(botonEliminarMI)
                                        .addGap(41, 41, 41)))
                                .addGap(0, 20, Short.MAX_VALUE))
                            .addComponent(jSeparator3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAbrir)
                    .addComponent(botonGuardarArchivo))
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonGuardarGramatica)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelRegular)
                        .addGap(8, 8, 8)
                        .addComponent(labelEspecial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelLineal))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonVerificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(simplificarBoton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelTMuertos)
                    .addComponent(labelTVivos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detectarVMboton)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAlcanzables)
                    .addComponent(labelInalcanzables))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEliminarMI)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarProdBoton)
                    .addComponent(eliminarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Operaciones con archivos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaDeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areaDeTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        areaDeTexto.getAccessibleContext().setAccessibleName("");

        jLabel2.setText("Editor de Gramáticas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirActionPerformed
        // TODO add your handling code here:
        String archivo=abrirArchivo();
	areaDeTexto.setText(archivo);
        botonGuardarGramatica.setEnabled(true);
        botonGuardarArchivo.setEnabled(true);
    }//GEN-LAST:event_botonAbrirActionPerformed

    private void botonGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarArchivoActionPerformed
        // TODO add your handling code here:
        guardarArchivo();
    }//GEN-LAST:event_botonGuardarArchivoActionPerformed

    private void botonGuardarGramaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarGramaticaActionPerformed
        guardarGramatica();
        botonVerificar.setEnabled(true);
        eliminarProdBoton.setEnabled(true);
        detectarVMboton.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGuardarGramaticaActionPerformed

    private void botonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerificarActionPerformed
        // TODO add your handling code here:
        if(gram.esRegular()){
        labelRegular.setText("Es regular: TRUE");
             if(gram.esFormaEspecial()){
                labelEspecial.setText("Ës especial: TRUE");
                labelLineal.setText("Es Lineal por la Derecha: FALSE");
                }else{
                  labelEspecial.setText("Ës especial: FALSE");
                labelLineal.setText("Es Lineal por la Derecha: TRUE");
            }
        }else{
        labelRegular.setText("Es regular: FALSE");
        labelEspecial.setText("Ës especial: FALSE");
        labelLineal.setText("Es Lineal por la Derecha: FALSE");
        }
        if(gram.esRegular()){
        JOptionPane.showMessageDialog(null,"" +
           "\nEsta Gramatica puede ser simplificada",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        simplificarBoton.setEnabled(true);
         }
        else{
            JOptionPane.showMessageDialog(null,"" +
           "\nEsta Gramatica NO puede ser simplificada",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
            
        simplificarBoton.setEnabled(false);
        }
        System.out.println(gram.detectarNTAlcanzables().getNT1());
    }//GEN-LAST:event_botonVerificarActionPerformed

    private void simplificarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simplificarBotonActionPerformed
        // TODO add your handling code here:
        gram.simplificarGramatica();
        actualizarGramatica();
        
    }//GEN-LAST:event_simplificarBotonActionPerformed

    private void detectarVMbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detectarVMbotonActionPerformed
        // TODO add your handling code here:
        NTListas NTS = gram.detectarNTVivos();
        NTListas NTS1 = gram.detectarNTAlcanzables();
        if(!NTS.getNT0().isEmpty()){
        LabelTMuertos.setText(Arrays.toString(NTS.getNT0().toArray()));
        }else{
            LabelTMuertos.setText("No enontrados");
            }
        if(!NTS.getNT1().isEmpty()){
        labelTVivos.setText(Arrays.toString(NTS.getNT1().toArray()));
        }else{
            labelTVivos.setText("No enontrados");
            }
        
           if(!NTS1.getNT0().isEmpty()){
        labelInalcanzables.setText(Arrays.toString(NTS1.getNT0().toArray()));
        }else{
            labelInalcanzables.setText("No enontrados");
            }
        if(!NTS1.getNT1().isEmpty()){
        labelAlcanzables.setText(Arrays.toString(NTS1.getNT1().toArray()));
        }else{
            labelAlcanzables.setText("No enontrados");
            }
        
        System.out.println(Arrays.toString(NTS.getNT1().toArray()));
        System.out.println(Arrays.toString(NTS.getNT0().toArray()));
        
    }//GEN-LAST:event_detectarVMbotonActionPerformed

    private void eliminarTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarTextfieldActionPerformed

    private void eliminarProdBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProdBotonActionPerformed
        // TODO add your handling code here:
         Object[] options = { "Yes", "No" };
    int n = JOptionPane.showOptionDialog(new JFrame(),
            "Se eliminaran las producciones de "+eliminarTextfield.getText()+ " porfavor confirme", "",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            options, options[1]);
    if(n == JOptionPane.OK_OPTION){ // Afirmative
        //.... 
        gram.eliminarProduccion(eliminarTextfield.getText());
        gram.limpiarGramatica(eliminarTextfield.getText());
        actualizarGramatica();
        
    }
    if(n == JOptionPane.NO_OPTION){ // negative
        //....
    }
    if(n == JOptionPane.CLOSED_OPTION){ // closed the dialog
        //....
    }
         
        
                
    }//GEN-LAST:event_eliminarProdBotonActionPerformed

    private void botonEliminarMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarMIActionPerformed
        // TODO add your handling code here:
        gram.limpiarInalcanzables();
        gram.limpiarMuertos();
        //areaDeTexto.setText(gram.imprimirGramaticaFormal().toString());
        actualizarGramatica();
    }//GEN-LAST:event_botonEliminarMIActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }
    
    private String abrirArchivo() {
  String aux="";   
  texto="";
  try
  {
   /**llamamos el metodo que permite cargar la ventana*/
   JFileChooser file=new JFileChooser();
   file.showOpenDialog(this);
   /**abrimos el archivo seleccionado*/
   File abre=file.getSelectedFile();
 
   /**recorremos el archivo, lo leemos para plasmarlo
   *en el area de texto*/
   if(abre!=null)
   {     
      FileReader archivos=new FileReader(abre);
      BufferedReader lee=new BufferedReader(archivos);
      while((aux=lee.readLine())!=null)
      {
         texto+= aux+ "\n";
      }
         lee.close();
    }    
   }
   catch(IOException ex)
   {
     JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
    }
  return texto;//El texto se almacena en el JTextArea
}

 private void guardarArchivo() {
 try
 {
  String nombre="";
  JFileChooser file=new JFileChooser();
  file.showSaveDialog(this);
  File guarda =file.getSelectedFile();
 
  if(guarda !=null)
  {
   /*guardamos el archivo y le damos el formato directamente,
    * si queremos que se guarde en formato doc lo definimos como .doc*/
    FileWriter  save=new FileWriter(guarda+".txt");
    save.write(areaDeTexto.getText());
    save.close();
    JOptionPane.showMessageDialog(null,
         "El archivo se a guardado Exitosamente",
             "Información",JOptionPane.INFORMATION_MESSAGE);
    }
 }
  catch(IOException ex)
  {
   JOptionPane.showMessageDialog(null,
        "Su archivo no se ha guardado",
           "Advertencia",JOptionPane.WARNING_MESSAGE);
  }
 }
 
 private void guardarGramatica(){
     
        gram = new Gramatica();
        String texto = areaDeTexto.getText();
        String [] lineas = texto.split("\n");
        System.out.println("Texto original:\n"+texto);
        System.out.println("Texto modificado:\n");
        System.out.println("lista de strings"+lineas);
        for(int i=0;i<lineas.length;i++){
            if(gram.crearProduccion(lineas[i])==0){
            //gram.crearProduccion(lineas[i]);
            System.out.println("Se ha ingresado la producción " + lineas[i]);
            //System.out.println("Linea "+i+ ": "+lineas[i]);
            }else{
            JOptionPane.showMessageDialog(null,
        "La gramatica no esta escrita correctamente revisa linea "+(i+1),
           "Advertencia",JOptionPane.WARNING_MESSAGE);
            return;
            }}
        //hay que castear cuando la produccion esta mal escrita y termina en =
 gram.imprimirGramatica();
 //areaDeTexto.setEditable(false);
  JOptionPane.showMessageDialog(null,
        "La gramatica se ha guardado, para verificarla presiona el boton verificar",
           "Información",JOptionPane.WARNING_MESSAGE);
  
 
 }
 
 private void actualizarGramatica(){
     
       areaDeTexto.setText(gram.imprimirGramaticaFormal().toString());
       
        
 //areaDeTexto.setEditable(false);
  JOptionPane.showMessageDialog(null,
        "La gramatica ha sido actualizada revisa el area de texto",
           "Información",JOptionPane.WARNING_MESSAGE);
  
 
 }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTMuertos;
    private javax.swing.JTextArea areaDeTexto;
    private javax.swing.JButton botonAbrir;
    private javax.swing.JButton botonEliminarMI;
    private javax.swing.JButton botonGuardarArchivo;
    private javax.swing.JButton botonGuardarGramatica;
    private javax.swing.JButton botonVerificar;
    private javax.swing.JButton detectarVMboton;
    private javax.swing.JButton eliminarProdBoton;
    private javax.swing.JTextField eliminarTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelAlcanzables;
    private javax.swing.JLabel labelEspecial;
    private javax.swing.JLabel labelInalcanzables;
    private javax.swing.JLabel labelLineal;
    private javax.swing.JLabel labelRegular;
    private javax.swing.JLabel labelTVivos;
    private javax.swing.JButton simplificarBoton;
    // End of variables declaration//GEN-END:variables
}
