/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import component.OrderCard;
import component.ScrollBarCustom;
import component.WrapLayout;
import entity.HoaDon;
import icon.FontAwesome;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import jiconfont.swing.IconFontSwing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Laptop
 */
public class GD_QuanLyDatMon extends javax.swing.JPanel {

    /**
     * Creates new form GD_Order
     */
    private JPanel mainPanel;
    public GD_QuanLyDatMon(JPanel main) {
        this.mainPanel = main;
        initComponents();
        txtMaBan.setBackground(new Color(0,0,0, 1));
        this.main.setLayout(new WrapLayout(FlowLayout.LEADING, 52, 20));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        IconFontSwing.register(FontAwesome.getIconFont());
        iconSearch.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 20, Color.WHITE));
        btnDown.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_DOWN, 10, Color.WHITE));
        btnUp.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_UP, 10, Color.WHITE));
        btnDD.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_DOUBLE_DOWN, 20, Color.WHITE));
        btnDU.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_DOUBLE_UP, 20, Color.WHITE));
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
        btnCheckout = new component.MyButton();
        btnReserve = new component.MyButton();
        panelRound2 = new component.PanelRound();
        txtMaBan = new javax.swing.JTextField();
        iconSearch = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        orderNumber = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDU = new component.MyButton();
        btnDD = new component.MyButton();
        btnDown = new component.MyButton();
        btnUp = new component.MyButton();
        scroll = new javax.swing.JScrollPane();
        main = new javax.swing.JPanel();

        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(31, 29, 43));
        jPanel1.setToolTipText("");

        btnCheckout.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckout.setText("Chờ thanh toán (0)");
        btnCheckout.setColor(new java.awt.Color(83, 86, 99));
        btnCheckout.setColorClick(new java.awt.Color(234, 124, 105));
        btnCheckout.setColorOver(new java.awt.Color(234, 124, 105));
        btnCheckout.setRadius(8);
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        btnReserve.setForeground(new java.awt.Color(255, 255, 255));
        btnReserve.setText("Đặt trước (0)");
        btnReserve.setToolTipText("");
        btnReserve.setColor(new java.awt.Color(83, 86, 99));
        btnReserve.setColorClick(new java.awt.Color(234, 124, 105));
        btnReserve.setColorOver(new java.awt.Color(234, 124, 105));
        btnReserve.setRadius(8);
        btnReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });

        panelRound2.setBackground(new java.awt.Color(83, 86, 99));
        panelRound2.setRoundBottomLeft(8);
        panelRound2.setRoundBottomRight(8);
        panelRound2.setRoundTopLeft(8);
        panelRound2.setRoundTopRight(8);

        txtMaBan.setBackground(new java.awt.Color(83, 86, 99));
        txtMaBan.setForeground(new java.awt.Color(255, 255, 255));
        txtMaBan.setBorder(null);
        txtMaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(0, 202, Short.MAX_VALUE)
                .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtMaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(83, 86, 99));
        panelRound3.setRoundBottomLeft(8);
        panelRound3.setRoundBottomRight(8);
        panelRound3.setRoundTopLeft(8);
        panelRound3.setRoundTopRight(8);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(31, 29, 43));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tổng số order: ");

        orderNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        orderNumber.setForeground(new java.awt.Color(255, 255, 255));
        orderNumber.setText("3");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thêm Order: F2 hoặc ALT + T");

        btnDU.setForeground(new java.awt.Color(255, 255, 255));
        btnDU.setColor(new java.awt.Color(83, 86, 99));
        btnDU.setColorClick(new java.awt.Color(234, 124, 105));
        btnDU.setColorOver(new java.awt.Color(234, 124, 105));
        btnDU.setRadius(8);
        btnDU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDUActionPerformed(evt);
            }
        });

        btnDD.setForeground(new java.awt.Color(255, 255, 255));
        btnDD.setColor(new java.awt.Color(83, 86, 99));
        btnDD.setColorClick(new java.awt.Color(234, 124, 105));
        btnDD.setColorOver(new java.awt.Color(234, 124, 105));
        btnDD.setRadius(8);
        btnDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDDActionPerformed(evt);
            }
        });

        btnDown.setForeground(new java.awt.Color(255, 255, 255));
        btnDown.setColor(new java.awt.Color(83, 86, 99));
        btnDown.setColorClick(new java.awt.Color(234, 124, 105));
        btnDown.setColorOver(new java.awt.Color(234, 124, 105));
        btnDown.setRadius(8);
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnUp.setForeground(new java.awt.Color(255, 255, 255));
        btnUp.setColor(new java.awt.Color(83, 86, 99));
        btnUp.setColorClick(new java.awt.Color(234, 124, 105));
        btnUp.setColorOver(new java.awt.Color(234, 124, 105));
        btnUp.setRadius(8);
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnDD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnDU, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(orderNumber)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDU, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        scroll.setBorder(null);

        main.setBackground(new java.awt.Color(83, 86, 99));

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1288, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        scroll.setViewportView(main);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private int count = 1;
    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here: 1 -> 4
//        main.removeAll();
        
//        main.setLayout(new GridLayout(row, orderNumbers++));
        HoaDon hoaDon = new HoaDon(null, null, null, null, null);
        hoaDon.setMaHoaDon("OKE" + count++);
        OrderCard orderCard = new OrderCard(hoaDon, mainPanel);
        main.add(orderCard);
        main.repaint();
        main.revalidate();

    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReserveActionPerformed

    private void txtMaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaBanActionPerformed

    private void btnDUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDUActionPerformed
        // TODO add your handling code here:
        scroll.getVerticalScrollBar().setValue(0);
    }//GEN-LAST:event_btnDUActionPerformed

    private void btnDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDDActionPerformed
        // TODO add your handling code here:
        int max = scroll.getVerticalScrollBar().getMaximum();
        scroll.getVerticalScrollBar().setValue(max);
    }//GEN-LAST:event_btnDDActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        // TODO add your handling code here:
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getValue() + 30);
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        // TODO add your handling code here:
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getValue() - 30);
    }//GEN-LAST:event_btnUpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnCheckout;
    private component.MyButton btnDD;
    private component.MyButton btnDU;
    private component.MyButton btnDown;
    private component.MyButton btnReserve;
    private component.MyButton btnUp;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel main;
    private javax.swing.JLabel orderNumber;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txtMaBan;
    // End of variables declaration//GEN-END:variables
}
