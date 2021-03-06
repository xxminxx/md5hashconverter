package md5generator;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class md5 extends javax.swing.JFrame {

    /**
     * Creates new form md5
     */
    public md5() {
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

        button = new javax.swing.JButton();
        hashstring = new javax.swing.JTextField();
        encrypted = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MD5 Hash Generator");
        setMaximumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(450, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        button.setText("Generate");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        getContentPane().add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 270, 30));

        hashstring.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        hashstring.setToolTipText("Enter string here");
        hashstring.setBorder(null);
        getContentPane().add(hashstring, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 270, 40));

        encrypted.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        encrypted.setBorder(null);
        getContentPane().add(encrypted, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 270, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/md5generator/file.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        int width = this.getWidth()/2;
        int height = this.getHeight()/2;
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-width;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-height;
        this.setLocation(x, y);
        
        encrypted.setEditable(false);
        button.setForeground(Color.WHITE);
        button.setBackground(new java.awt.Color(12, 226, 197));
        Border line = new LineBorder(new java.awt.Color(12, 226, 197));
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        Border line2 = new LineBorder(Color.LIGHT_GRAY);
        Border margin2 = new EmptyBorder(5, 15, 5, 15);
        Border compound2 = new CompoundBorder(line2, margin2);
        encrypted.setBorder(compound2);
        hashstring.setBorder(compound2);
    }//GEN-LAST:event_formWindowOpened

       String getMD5(String input) {
        byte[] source;
        try {
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexa[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte temp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = temp[i];
                str[k++] = hexa[byte0 >>> 4 & 0xf];
                str[k++] = hexa[byte0 & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    
    }
    
    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
       String string = hashstring.getText();
        encrypted.setText(getMD5(string));
    }//GEN-LAST:event_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(md5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(md5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(md5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(md5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new md5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton button;
    private javax.swing.JTextField encrypted;
    private javax.swing.JTextField hashstring;
    // End of variables declaration//GEN-END:variables
}
