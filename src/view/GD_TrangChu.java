/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.NhanVien_Dao;
import entity.NhanVien;
import icon.FontAwesome;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JComponent;
import javax.swing.JPanel;
import jiconfont.swing.IconFontSwing;
import utils.AppUtils.*;
/**
 *
 * @author Laptop
 */
public class GD_TrangChu extends javax.swing.JFrame {

    /**
     * Creates new form GD_TrangChu
     */
    
    //default test //sau này xóa
//    NhanVien_Dao nv_dao = new NhanVien_Dao();
//    NhanVien nhanVien = nv_dao.getNhanVien("NV1181524049", "12345678");
    
    
    //dùng cho run
    public GD_TrangChu() {
        set_up_UI();
        setExtendedState(MAXIMIZED_BOTH);
//        setResizable(false);
        utils.AppUtils.setUI(mainJpanel, new GD_Order(mainJpanel));
//        label_AVT.setText(nhanVien.getHoTen());
    }
    //dùng cho đi từ login vào
    public GD_TrangChu(NhanVien nv) {
        set_up_UI();
//        setUI(new GD_Order());
//        nhanVien = nv;
//        NhanVien_Dao nvd = new NhanVien_Dao();
//        label_AVT.setText(nv.getHoTen());
    }
    
    private void set_up_UI(){
        initComponents();
        label_week_day.setText(""+LocalDate.now().getDayOfWeek());
        label_day_month_year.setText(LocalDate.now().getDayOfMonth() +"/" + 
                LocalDate.now().getMonthValue()+"/"+
                LocalDate.now().getYear());
        IconFontSwing.register(FontAwesome.getIconFont());
        btnAVT.setIcon(IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE, 40,Color.WHITE));
        buttonHelp.setIcon(IconFontSwing.buildIcon(FontAwesome.QUESTION_CIRCLE, 30,Color.WHITE));
        buttonHome.setIcon(IconFontSwing.buildIcon(FontAwesome.HOME, 40,Color.WHITE));
        buttonDatBan.setIcon(IconFontSwing.buildIcon(FontAwesome.CHECK_SQUARE_O, 30,new Color(20, 174, 92)));
        buttonDatMon.setIcon(IconFontSwing.buildIcon(FontAwesome.COFFEE, 30,new Color(192,192,192)));
        buttonThongKe.setIcon(IconFontSwing.buildIcon(FontAwesome.BAR_CHART, 30,new Color(255, 205, 41)));
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
        buttonHome = new component.MyButton();
        buttonDatMon = new component.MyButton();
        buttonDatBan = new component.MyButton();
        buttonThongKe = new component.MyButton();
        btnAVT = new component.MyButton();
        label_AVT = new javax.swing.JLabel();
        label_week_day = new javax.swing.JLabel();
        label_day_month_year = new javax.swing.JLabel();
        buttonHelp = new component.MyButton();
        gap = new component.PanelRound();
        mainJpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(83, 86, 99));
        jPanel1.setForeground(new java.awt.Color(83, 86, 99));

        buttonHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonHome.setForeground(new java.awt.Color(255, 255, 255));
        buttonHome.setBorderColor(new java.awt.Color(31, 29, 43));
        buttonHome.setColor(new java.awt.Color(234, 124, 105));
        buttonHome.setColorClick(new java.awt.Color(31, 29, 43));
        buttonHome.setColorOver(new java.awt.Color(31, 29, 43));
        buttonHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonHome.setRadius(8);
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });

        buttonDatMon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonDatMon.setForeground(new java.awt.Color(255, 255, 255));
        buttonDatMon.setText("ĐẶT MÓN");
        buttonDatMon.setBorderColor(new java.awt.Color(31, 29, 43));
        buttonDatMon.setColor(new java.awt.Color(234, 124, 105));
        buttonDatMon.setColorClick(new java.awt.Color(31, 29, 43));
        buttonDatMon.setColorOver(new java.awt.Color(31, 29, 43));
        buttonDatMon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonDatMon.setIconTextGap(8);
        buttonDatMon.setRadius(8);
        buttonDatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDatMonActionPerformed(evt);
            }
        });

        buttonDatBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonDatBan.setForeground(new java.awt.Color(255, 255, 255));
        buttonDatBan.setText("ĐẶT BÀN");
        buttonDatBan.setBorderColor(new java.awt.Color(31, 29, 43));
        buttonDatBan.setColor(new java.awt.Color(234, 124, 105));
        buttonDatBan.setColorClick(new java.awt.Color(31, 29, 43));
        buttonDatBan.setColorOver(new java.awt.Color(31, 29, 43));
        buttonDatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonDatBan.setIconTextGap(8);
        buttonDatBan.setRadius(8);
        buttonDatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDatBanActionPerformed(evt);
            }
        });

        buttonThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonThongKe.setForeground(new java.awt.Color(255, 255, 255));
        buttonThongKe.setText("THỐNG KÊ");
        buttonThongKe.setBorderColor(new java.awt.Color(31, 29, 43));
        buttonThongKe.setColor(new java.awt.Color(234, 124, 105));
        buttonThongKe.setColorClick(new java.awt.Color(31, 29, 43));
        buttonThongKe.setColorOver(new java.awt.Color(31, 29, 43));
        buttonThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonThongKe.setIconTextGap(8);
        buttonThongKe.setRadius(8);
        buttonThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThongKeActionPerformed(evt);
            }
        });

        btnAVT.setColor(new java.awt.Color(31, 29, 43));
        btnAVT.setColorClick(new java.awt.Color(234, 124, 105));
        btnAVT.setColorOver(new java.awt.Color(234, 124, 105));
        btnAVT.setRadius(50);
        btnAVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAVTActionPerformed(evt);
            }
        });

        label_AVT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_AVT.setForeground(new java.awt.Color(255, 255, 255));
        label_AVT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_AVT.setText("Nguyễn Đức Cường");

        label_week_day.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_week_day.setForeground(new java.awt.Color(255, 255, 255));
        label_week_day.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_week_day.setText("MONDAY");

        label_day_month_year.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_day_month_year.setForeground(new java.awt.Color(255, 255, 255));
        label_day_month_year.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_day_month_year.setText("16/09/2003");

        buttonHelp.setColor(new java.awt.Color(31, 29, 43));
        buttonHelp.setColorClick(new java.awt.Color(234, 124, 105));
        buttonHelp.setColorOver(new java.awt.Color(234, 124, 105));
        buttonHelp.setRadius(37);
        buttonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHelpActionPerformed(evt);
            }
        });

        gap.setBackground(new java.awt.Color(83, 86, 99));

        javax.swing.GroupLayout gapLayout = new javax.swing.GroupLayout(gap);
        gap.setLayout(gapLayout);
        gapLayout.setHorizontalGroup(
            gapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        gapLayout.setVerticalGroup(
            gapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(buttonHome, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(buttonDatMon, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(buttonDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(buttonThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label_day_month_year, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label_week_day, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addComponent(btnAVT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_AVT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAVT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonDatMon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonDatBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_AVT)
                                    .addGap(11, 11, 11))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_week_day, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(label_day_month_year))))))
                .addContainerGap())
        );

        mainJpanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        utils.AppUtils.setUI(mainJpanel, new GD_DatMon());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAVTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAVTActionPerformed

    private void buttonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHelpActionPerformed

    private void buttonThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonThongKeActionPerformed

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonDatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDatMonActionPerformed
        // TODO add your handling code here:
        utils.AppUtils.setUI(mainJpanel, new GD_Order(mainJpanel));
    }//GEN-LAST:event_buttonDatMonActionPerformed

    private void buttonDatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDatBanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonDatBanActionPerformed


//    private void setUI(JComponent jComponent) {
//        mainJpanel.removeAll();
//        mainJpanel.add(jComponent);
//        mainJpanel.repaint();
//        mainJpanel.revalidate();
//    }
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
            java.util.logging.Logger.getLogger(GD_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnAVT;
    private component.MyButton buttonDatBan;
    private component.MyButton buttonDatMon;
    private component.MyButton buttonHelp;
    private component.MyButton buttonHome;
    private component.MyButton buttonThongKe;
    private component.PanelRound gap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_AVT;
    private javax.swing.JLabel label_day_month_year;
    private javax.swing.JLabel label_week_day;
    private javax.swing.JPanel mainJpanel;
    // End of variables declaration//GEN-END:variables
}