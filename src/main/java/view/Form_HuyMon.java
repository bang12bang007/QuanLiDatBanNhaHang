/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import component.OrderItem_forUIDatMon;
import entity.ChiTietHoaDon;
import entity.Mon;
import icon.FontAwesome;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author dmx
 */
public class Form_HuyMon extends javax.swing.JPanel {

    /**
     * Creates new form Form_HuyMon
     */
    private JFrame main;
    private OrderItem_forUIDatMon parent;
    private Mon monHuy;

    public Form_HuyMon(JFrame frame, OrderItem_forUIDatMon parent) {
        initComponents();
        this.main = frame;
        this.parent = parent;
        this.setBackground(new Color(0, 0, 0, 0.7f));
        IconFontSwing.register(FontAwesome.getIconFont());
        btnHelp.setIcon(IconFontSwing.buildIcon(FontAwesome.QUESTION, 20, Color.WHITE));
        btnClose.setIcon(IconFontSwing.buildIcon(FontAwesome.WINDOW_CLOSE, 20, Color.WHITE));
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
        btnHelp = new component.MyButton();
        btnClose = new component.MyButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BoxLyDo = new javax.swing.JComboBox<>();
        panelRound3 = new component.PanelRound();
        myButton3 = new component.MyButton();
        myButton4 = new component.MyButton();

        panelRound1.setBackground(new java.awt.Color(83, 86, 99));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);

        panelRound2.setBackground(new java.awt.Color(31, 29, 43));
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hủy Món");

        btnHelp.setBackground(new java.awt.Color(31, 29, 43));
        btnHelp.setColor(new java.awt.Color(31, 29, 43));
        btnHelp.setColorClick(new java.awt.Color(31, 29, 43));
        btnHelp.setColorOver(new java.awt.Color(31, 29, 43));
        btnHelp.setRadius(60);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(31, 29, 43));
        btnClose.setColor(new java.awt.Color(31, 29, 43));
        btnClose.setColorClick(new java.awt.Color(31, 29, 43));
        btnClose.setColorOver(new java.awt.Color(31, 29, 43));
        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnClose.setRadius(60);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
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
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bạn có chắc muốn hủy món không ?");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lý do hủy");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("*");

        BoxLyDo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        BoxLyDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hủy món do đợi lâu", "Khách không hài lòng", "Khách yêu cầu đổi món", "Khách yêu cầu hủy món","Nhân viên ghi sai order","Khác" }));
        BoxLyDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxLyDoActionPerformed(evt);
            }
        });

        panelRound3.setBackground(new java.awt.Color(31, 29, 43));
        panelRound3.setRoundBottomLeft(10);
        panelRound3.setRoundBottomRight(10);

        myButton3.setBackground(new java.awt.Color(83, 86, 99));
        myButton3.setForeground(new java.awt.Color(255, 255, 255));
        myButton3.setText("CÓ");
        myButton3.setColor(new java.awt.Color(83, 86, 99));
        myButton3.setColorClick(new java.awt.Color(234, 124, 105));
        myButton3.setColorOver(new java.awt.Color(234, 124, 105));
        myButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton3.setRadius(10);
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });

        myButton4.setBackground(new java.awt.Color(83, 86, 99));
        myButton4.setForeground(new java.awt.Color(255, 255, 255));
        myButton4.setText("KHÔNG");
        myButton4.setColor(new java.awt.Color(83, 86, 99));
        myButton4.setColorClick(new java.awt.Color(234, 124, 105));
        myButton4.setColorOver(new java.awt.Color(234, 124, 105));
        myButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton4.setRadius(10);
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(myButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(BoxLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)))
            .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(BoxLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        main.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        main.dispose();
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
//        parent.getDatMon().getList_quantity().remove(parent.getDatMon().getOrders().indexOf(parent.getMon()));
        monHuy = parent.getMon();
        parent.update_PanelOrder(true);
        List<ChiTietHoaDon> list = parent.getDatMon().getDetails();
        for(ChiTietHoaDon c : list){
            if(c.getMon().getTenMon().equals(monHuy.getTenMon())){
                //chỗ này bỏ ghi chú vào
                c.setGhiChu(BoxLyDo.getSelectedItem().toString());
                c.setSoLuong(0);
            }
        }
        parent.getDatMon().getList_CancelFood().add(monHuy);
        parent.getDatMon().setDetails(list);
        main.dispose();
    }//GEN-LAST:event_myButton3ActionPerformed

    private void BoxLyDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxLyDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxLyDoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxLyDo;
    private component.MyButton btnClose;
    private component.MyButton btnHelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private component.MyButton myButton3;
    private component.MyButton myButton4;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
