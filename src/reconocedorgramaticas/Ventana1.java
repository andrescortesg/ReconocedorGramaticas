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
        eliminarProdBoton = new javax.swing.JButton();
        eliminarTextfield = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        botonAbrir = new javax.swing.JButton();
        botonGuardarArchivo = new javax.swing.JButton();
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

        jLabel4.setText("Terminales Vivos");

        jLabel5.setText("Terminales Muertos");

        labelTVivos.setText("Sin Determinar");

        LabelTMuertos.setText("Sin Determinar");

        eliminarProdBoton.setText("Eliminar P");
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

        botonAbrir.setText("Cargar Archivo");
        botonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirActionPerformed(evt);
            }
        });

        botonGuardarArchivo.setText("Guardar Archivo");
        botonGuardarArchivo.setEnabled(false);
        botonGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
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
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(labelTVivos))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelTMuertos)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(eliminarProdBoton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(eliminarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(detectarVMboton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(botonAbrir)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonGuardarArchivo)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSeparator2))
                .addContainerGap())
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detectarVMboton)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminarProdBoton)
                        .addComponent(eliminarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 101, Short.MAX_VALUE))
        );

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
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areaDeTexto)
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
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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
        simplificarBoton.setEnabled(true);
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
            "Se eliminaran las producciones de"+eliminarTextfield.getText()+ "porfavor confirme", "",
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelEspecial;
    private javax.swing.JLabel labelLineal;
    private javax.swing.JLabel labelRegular;
    private javax.swing.JLabel labelTVivos;
    private javax.swing.JButton simplificarBoton;
    // End of variables declaration//GEN-END:variables
}
