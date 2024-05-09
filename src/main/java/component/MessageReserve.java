/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import com.formdev.flatlaf.FlatIntelliJLaf;
import entity.Ban;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

import raven.toast.Notifications;
import view.employee.GD_DatBanTruoc;

import static utils.AppUtils.*;

import view.employee.Form_DatBan;
import view.employee.GD_DatBanTaiCho;

/**
 * @author Laptop
 */
public class MessageReserve extends javax.swing.JPanel {

    /**
     * Creates new form Message
     */
    private JFrame jFrame;
    private Form_DatBan form_DatBan;
    private List<Ban> bans;
    private int floor;

    public MessageReserve(JFrame jFrame, Form_DatBan form_DatBan, String message) {
        this.jFrame = jFrame;
        this.form_DatBan = form_DatBan;
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0.7f));
        jLabel2.setText(message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new component.PanelRound();
        panelRound2 = new component.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        myButton1 = new component.MyButton();
        myButton2 = new component.MyButton();
        jLabel2 = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        btnDongY = new component.MyButton();
        btnHuy = new component.MyButton();

        setFont(utils.AppUtils.getFont(16f, _NORMAL_));

        panelRound1.setBackground(new java.awt.Color(83, 86, 99));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);

        panelRound2.setBackground(new java.awt.Color(31, 29, 43));
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);

        jLabel1.setFont(utils.AppUtils.getFont(14f, _BOLD_));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chọn bàn");

        myButton1.setBackground(new java.awt.Color(31, 29, 43));
        myButton1.setColor(new java.awt.Color(31, 29, 43));
        myButton1.setColorClick(new java.awt.Color(31, 29, 43));
        myButton1.setColorOver(new java.awt.Color(31, 29, 43));
        myButton1.setRadius(60);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton2.setBackground(new java.awt.Color(31, 29, 43));
        myButton2.setColor(new java.awt.Color(31, 29, 43));
        myButton2.setColorClick(new java.awt.Color(31, 29, 43));
        myButton2.setColorOver(new java.awt.Color(31, 29, 43));
        myButton2.setRadius(60);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(325, 325, 325)
                                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        panelRound2Layout.setVerticalGroup(
                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(myButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10))
        );

        jLabel2.setFont(utils.AppUtils.getFont(18f, _BOLD_));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bạn có muốn chuyển từ BAN0110 đến BAN0121");

        panelRound3.setBackground(new java.awt.Color(31, 29, 43));
        panelRound3.setRoundBottomLeft(10);
        panelRound3.setRoundBottomRight(10);

        btnDongY.setBackground(new java.awt.Color(83, 86, 99));
        btnDongY.setForeground(new java.awt.Color(255, 255, 255));
        btnDongY.setText("Đồng ý");
        btnDongY.setColor(new java.awt.Color(83, 86, 99));
        btnDongY.setColorClick(new java.awt.Color(234, 124, 105));
        btnDongY.setColorOver(new java.awt.Color(234, 124, 105));
        btnDongY.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        btnDongY.setRadius(10);
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(83, 86, 99));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.setColor(new java.awt.Color(83, 86, 99));
        btnHuy.setColorClick(new java.awt.Color(234, 124, 105));
        btnHuy.setColorOver(new java.awt.Color(234, 124, 105));
        btnHuy.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        btnHuy.setRadius(10);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
                panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                                .addContainerGap(346, Short.MAX_VALUE)
                                .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        panelRound3Layout.setVerticalGroup(
                panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnDongY, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
                panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
                panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(395, Short.MAX_VALUE)
                                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(396, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(220, Short.MAX_VALUE)
                                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(221, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton2ActionPerformed

    public void setBans(List<Ban> bans) {
        this.bans = bans;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
        // TODO add your handling code here:
        form_DatBan.insertPhieuDatBan(bans, floor);
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnDongYActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:;
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnDongY;
    private component.MyButton btnHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private component.MyButton myButton1;
    private component.MyButton myButton2;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}