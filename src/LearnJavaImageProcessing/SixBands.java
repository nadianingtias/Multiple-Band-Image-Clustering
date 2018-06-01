/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearnJavaImageProcessing;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author Nadian
 */
public class SixBands extends javax.swing.JFrame {

    /**
     * Creates new form SixBands
     */
    public SixBands() {
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

        jLabel_image1 = new javax.swing.JLabel();
        jTextField_Path1 = new javax.swing.JTextField();
        jButton_Attach1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel_image2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_loadfiles = new javax.swing.JButton();
        jLabel_band2 = new javax.swing.JLabel();
        jLabel_band1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_Attach1.setText("Attach band 1");
        jButton_Attach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Attach1ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel_image2.setText("jLabel1");

        jPanel2.setBackground(java.awt.Color.white);

        jButton_loadfiles.setText("load files");
        jButton_loadfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loadfilesActionPerformed(evt);
            }
        });

        jLabel_band2.setBackground(java.awt.Color.gray);
        jLabel_band2.setText("band 2");
        jLabel_band2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_band1.setBackground(java.awt.Color.gray);
        jLabel_band1.setText("band 1");
        jLabel_band1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_band1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel_band2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_loadfiles))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_loadfiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel_band2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                    .addComponent(jLabel_band1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Path1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Attach1))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_image2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_image2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Path1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton_Attach1))
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Image image;
    BufferedImage bi;
    ImageIcon icon;
    private void jButton_Attach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Attach1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        //siapkan file
        File f2 = new File(filename);
        jTextField_Path1.setText(filename);
        //file into bufferedimage
        try {
            
            bi = ImageIO.read(f2);
        } catch (IOException ex) {
            Logger.getLogger(SixBands.class.getName()).log(Level.SEVERE, null, ex);
        }
        //konversi buffered to ImageIcon
        icon = new ImageIcon(bi.getScaledInstance(jLabel_image1.getWidth(), jLabel_image1.getHeight(),
                jLabel_image1.getWidth()));
        jLabel_image1.setIcon(icon);
//        image = icon.getImage().getScaledInstance(jLabel_image1.getWidth(), jLabel_image1.getHeight(), Image.SCALE_SMOOTH);
        //apply casted Image as ImageIcon
//        jLabel_image1.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_jButton_Attach1ActionPerformed
public static BufferedImage toBufferedImage(Image img)
{
    if (img instanceof BufferedImage)
    {
        return (BufferedImage) img;
    }

    // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    // Draw the image on to the buffered image
//    Graphics2D bGr = bimage.createGraphics();
//    bGr.drawImage(img, 0, 0, null);
//    bGr.dispose();

    // Return the buffered image
    return bimage;
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BufferedImage bimage2;
        bimage2 = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
        BufferedImage.TYPE_BYTE_BINARY);
        int width, height;
            width = bimage2.getWidth();
            height = bimage2.getHeight();
            int count=0;
            for(int i=0 ; i<height ; i++){
                for(int j=0 ; j<width ; j++){
                    count++;
                    Color c =  new Color(bimage2.getRGB(j, i));
//                    Color c = new Color(icon)
                    System.out.println("S.No: "+ count + " Red: "+ c.getRed()+ " Green: "+ c.getGreen() +" Blue: "+ c.getBlue());
                    int red = (int)(c.getRed()*0.299);
                    int green = (int)(c.getGreen()*0.587);
                    int blue = (int)(c.getBlue()*0.114);
                    float gray =red+green+blue;
                    System.out.println("nilai : "+c.getRed());
                    Color newColor = new Color(gray, gray, gray);
                        bimage2.setRGB(j, i, newColor.getRGB());
                }
            }
        ImageIcon newIcon = new ImageIcon(bimage2.getScaledInstance(jLabel_image2.getWidth(), jLabel_image2.getHeight(), jLabel_image2.getWidth()));
//        image3 = newIcon.getImage().getScaledInstance(jLabel_image2.getWidth(), jLabel_image2.getHeight(), Image.SCALE_SMOOTH);
        jLabel_image2.setIcon(newIcon);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_loadfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loadfilesActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.showOpenDialog(null);
        
        //get path of selected files
        File[] f = chooser.getSelectedFiles();
        File[] filefile = f;
        String[] filenames = new String[f.length];
        BufferedImage[] buffImages = new BufferedImage[f.length];
        ImageIcon[] icons = new ImageIcon[f.length];
        int count=0;
        for(File file : f ){
            filenames[count] = file.getAbsolutePath();
            filefile[count] = new File(filenames[count]);
            try {
                buffImages[count] = ImageIO.read(filefile[count]);
            } catch (IOException ex) {
                Logger.getLogger(SixBands.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(filenames[count]);
            System.out.println(buffImages[count].getRGB(2, 2));
            icons[count] = new ImageIcon(buffImages[count].getScaledInstance(145, 145, 145));
            count++;
        }
        if(icons[0]!=null){
            jLabel_band1.setIcon(icons[0]);
        }
        if(icons[1]!=null){
            jLabel_band2.setIcon(icons[1]);
        }
    }//GEN-LAST:event_jButton_loadfilesActionPerformed

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
            java.util.logging.Logger.getLogger(SixBands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SixBands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SixBands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SixBands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SixBands().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Attach1;
    private javax.swing.JButton jButton_loadfiles;
    private javax.swing.JLabel jLabel_band1;
    private javax.swing.JLabel jLabel_band2;
    private javax.swing.JLabel jLabel_image1;
    private javax.swing.JLabel jLabel_image2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField_Path1;
    // End of variables declaration//GEN-END:variables
}