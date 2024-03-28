/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.GapContent;

/**
 *
 * @author Laptop
 */
public class OrderItem extends javax.swing.JPanel {

    /**
     * Creates new form OrderItem
     */
    public OrderItem(int width,int index, String[] data) {
        initComponents();
        setBackground(index % 2 != 0 ? new Color(83, 86, 99) : new Color(31, 29, 43));
        setPreferredSize( new Dimension(width, 50));
        
        push(data);
    }
    
    public void push(String[] data) {
        tenMon.setText("  "+data[0]);
        soLuong.setText("  "+data[1]);
        donGia.setText(" "+data[2]);
        thanhTien.setText(" "+data[3]);
    }
    
//    public OrderItem(int index) {
//        initComponents();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tenMon = new javax.swing.JLabel();
        soLuong = new javax.swing.JLabel();
        donGia = new javax.swing.JLabel();
        thanhTien = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        tenMon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tenMon.setForeground(new java.awt.Color(255, 255, 255));
        add(tenMon);

        soLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        soLuong.setForeground(new java.awt.Color(255, 255, 255));
        add(soLuong);

        donGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        donGia.setForeground(new java.awt.Color(255, 255, 255));
        add(donGia);

        thanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        thanhTien.setForeground(new java.awt.Color(255, 255, 255));
        add(thanhTien);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel donGia;
    private javax.swing.JLabel soLuong;
    private javax.swing.JLabel tenMon;
    private javax.swing.JLabel thanhTien;
    // End of variables declaration//GEN-END:variables

}