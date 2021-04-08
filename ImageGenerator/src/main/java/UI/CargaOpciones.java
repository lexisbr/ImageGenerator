/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Analizadores.CapasLexer;
import Analizadores.CapasParser;
import Analizadores.ImgLexer;
import Analizadores.ImgParser;
import Nodos.NodoListaDoble;
import Nodos.NodoListaSimple;
import Nucleo.Estructuras;
import Objetos.Imagen;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lex
 */
public class CargaOpciones extends javax.swing.JFrame {

    /**
     * Creates new form CargaOpciones
     */
    private String cadena = "";

    public CargaOpciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionesRadio = new javax.swing.ButtonGroup();
        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        limpiarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        capasRadio = new javax.swing.JRadioButton();
        usuariosRadio = new javax.swing.JRadioButton();
        imagenesRadio = new javax.swing.JRadioButton();
        pathTxt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        archivoButton = new javax.swing.JButton();
        datosButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("FreeMono", 0, 24)); // NOI18N
        label1.setText("Carga de Datos");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 102), null, null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        limpiarButton.setText("Limpiar archivo");
        limpiarButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 102, 102)));
        limpiarButton.setEnabled(false);
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(limpiarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 200, 40));

        jLabel1.setText("Datos a cargar:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 8, -1, -1));

        opcionesRadio.add(capasRadio);
        capasRadio.setText("Capas");
        jPanel1.add(capasRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        opcionesRadio.add(usuariosRadio);
        usuariosRadio.setText("Usuarios");
        jPanel1.add(usuariosRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        opcionesRadio.add(imagenesRadio);
        imagenesRadio.setText("Imagenes");
        jPanel1.add(imagenesRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));
        jPanel1.add(pathTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 480, 20));

        jLabel3.setText("Archivo seleccionado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        archivoButton.setText("Cargar archivo");
        archivoButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 102, 102)));
        archivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(archivoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 200, 40));

        datosButton.setText("Cargar datos");
        datosButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 102, 102)));
        datosButton.setEnabled(false);
        datosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datosButtonActionPerformed(evt);
            }
        });
        jPanel1.add(datosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        // TODO add your handling code here:
        datosButton.setEnabled(false);
        limpiarButton.setEnabled(false);
        capasRadio.setEnabled(true);
        imagenesRadio.setEnabled(true);
        usuariosRadio.setEnabled(true);
        archivoButton.setEnabled(true);
        pathTxt.setText("");
        cadena = "";

    }//GEN-LAST:event_limpiarButtonActionPerformed

    private void archivoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filtro = null;
        if (capasRadio.isSelected())
        {
            filtro = new FileNameExtensionFilter("*.cap", "cap");
        } else if (imagenesRadio.isSelected())
        {
            filtro = new FileNameExtensionFilter("*.im", "im");
        } else if (usuariosRadio.isSelected())
        {
            filtro = new FileNameExtensionFilter("*.us", "us");
        } else
        {
            JOptionPane.showMessageDialog(this, "No ha seleccionado tipo de archivo");
            return;
        }
        fc.setFileFilter(filtro);
        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
            File fichero = fc.getSelectedFile();

            this.pathTxt.setText(fichero.getAbsolutePath());

            try ( FileReader fr = new FileReader(fichero))
            {
                cadena = "";
                int valor = fr.read();
                while (valor != -1)
                {
                    cadena = cadena + (char) valor;
                    valor = fr.read();
                }
                System.out.println(cadena);
                datosButton.setEnabled(true);
                limpiarButton.setEnabled(true);
                capasRadio.setEnabled(false);
                imagenesRadio.setEnabled(false);
                usuariosRadio.setEnabled(false);
                archivoButton.setEnabled(false);

            } catch (IOException ex)
            {
                System.out.println("Error al obtener archivo");
            }
        }
    }//GEN-LAST:event_archivoButtonActionPerformed

    private void datosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datosButtonActionPerformed
        // TODO add your handling code here:
        StringReader reader = new StringReader(cadena);
        if (capasRadio.isSelected())
        {
            CapasLexer lexer = new CapasLexer(reader);
            CapasParser parser = new CapasParser(lexer);
            try
            {
                parser.parse();
                JOptionPane.showMessageDialog(this, "Se han cargado capas correctamente.");
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }else if(imagenesRadio.isSelected()){
            ImgLexer lexer = new ImgLexer(reader);
            ImgParser parser = new ImgParser(lexer);
            try
            {
                parser.parse();
                JOptionPane.showMessageDialog(this, "Se han cargado imagenes correctamente.");
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_datosButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(CargaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CargaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CargaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CargaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaOpciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton archivoButton;
    private javax.swing.JRadioButton capasRadio;
    private javax.swing.JButton datosButton;
    private javax.swing.JRadioButton imagenesRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private javax.swing.JButton limpiarButton;
    private javax.swing.ButtonGroup opcionesRadio;
    private javax.swing.JLabel pathTxt;
    private javax.swing.JRadioButton usuariosRadio;
    // End of variables declaration//GEN-END:variables
}
