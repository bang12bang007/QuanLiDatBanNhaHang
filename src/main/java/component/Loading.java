/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import javax.swing.ImageIcon;

/**
 *
 * @author Laptop
 */
public class Loading extends javax.swing.JPanel {

    /**
     * Creates new form Loading
     */
    public Loading() {
        initComponents();
        String imagePath = "D:\\learning_university_IUH\\hoc_ky_6_(2023-2024)\\Phat_trien_ung_dung\\BaoCaoCK\\QuanLiDatBanNhaHang\\src\\main\\java\\icon\\loading_final.gif";

        // Tạo một ImageIcon từ đường dẫn ảnh
        ImageIcon icon = new ImageIcon(imagePath);
        this.icon.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(83, 86, 99));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 1428, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    // End of variables declaration//GEN-END:variables
}
