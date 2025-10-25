

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormCekNomor extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCekNomor.class.getName());

    public FormCekNomor() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        inputLabel = new javax.swing.JLabel();
        inputField = new javax.swing.JTextField();
        cekButton = new javax.swing.JButton();
        hasilLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        judulLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        judulLabel.setText("Aplikasi Cek Nomor Genap / Ganjil");

        inputLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        inputLabel.setText("Masukan Angka:");

        inputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputFieldFocusGained(evt);
            }
        });
        inputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputFieldKeyTyped(evt);
            }
        });

        cekButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        cekButton.setText("Cek Nomor");
        cekButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekButtonActionPerformed(evt);
            }
        });

        hasilLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); 
        hasilLabel.setText("Hasil akan muncul di sini");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(judulLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputField)))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(hasilLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(judulLabel)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLabel)
                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(cekButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(hasilLabel)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }

    private void cekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekButtonActionPerformed
        // TODO add your handling code here:
         try {
        int angka = Integer.parseInt(inputField.getText());
        String hasil;

        if (angka % 2 == 0) {
            hasil = "Angka " + angka + " adalah Genap.";
        } else {
            hasil = "Angka " + angka + " adalah Ganjil.";
        }


        boolean prima = true;
        if (angka <= 1) prima = false;
        for (int i = 2; i <= Math.sqrt(angka); i++) {
            if (angka % i == 0) {
                prima = false;
                break;
            }
        }

        if (prima) {
            hasil += "\nAngka ini juga merupakan bilangan prima.";
        } else {
            hasil += "\nAngka ini bukan bilangan prima.";
        }

        
        JOptionPane.showMessageDialog(this, hasil, "Hasil Cek", JOptionPane.INFORMATION_MESSAGE);
        hasilLabel.setText("<html>" + hasil.replace("\n", "<br>") + "</html>");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }

    
    private void inputFieldFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
         inputField.setText(""); 
    hasilLabel.setText(""); 
    }

    private void inputFieldKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        char c = evt.getKeyChar();
    if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
        evt.consume(); 
        JOptionPane.showMessageDialog(this, "Hanya boleh angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
    }

    
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        


        java.awt.EventQueue.invokeLater(() -> new FormCekNomor().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton cekButton;
    private javax.swing.JLabel hasilLabel;
    private javax.swing.JTextField inputField;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel judulLabel;
    // End of variables declaration
}
