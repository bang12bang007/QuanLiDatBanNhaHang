/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.employee;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jiconfont.swing.IconFontSwing;
import view.employee.GD_DatBanTruoc;

import static utils.AppUtils.NHANVIEN;
//<<<<<<< HEAD
//
//import utils.AppUtils;
//=======
import static utils.AppUtils.*;
//>>>>>>> 718f89ec6b614f67f9ff179eae94343a24dadfec

/**
 * @author Laptop
 */
public class Form_ThongTinCaNhan extends javax.swing.JPanel {

    /**
     * Creates new form Message
     */
    private JFrame jFrame;
    private String gioiTinh;
    private String trangThai;

    public Form_ThongTinCaNhan(JFrame jFrame) {
        initComponents();
        this.jFrame = jFrame;
        set_up_UI();
    }

    private void set_up_UI() {
        if (NHANVIEN.isGioiTinh()) {
            gioiTinh = "Nu";
        } else {
            gioiTinh = "Nam";
        }
        if (NHANVIEN.isTrangThai()) {
            trangThai = "Đang làm";
        } else {
            trangThai = "Đã cút";
        }
        this.setBackground(new Color(0, 0, 0, 0.7f));
        jLabel9.setText(NHANVIEN.getHoTen());
        jLabel29.setText(String.valueOf(NHANVIEN.getMaNV()));
        jLabel22.setText(gioiTinh);
        jLabel23.setText(String.valueOf(NHANVIEN.getNgayBatDauLam()));
        jLabel24.setText(NHANVIEN.getSoDienThoai());
        jLabel25.setText(String.valueOf(NHANVIEN.getTuoi()));
        jLabel26.setText(String.valueOf(NHANVIEN.getVaiTro()));
        jLabel27.setText(trangThai);
        jLabel28.setText(NHANVIEN.getDiaChi());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        wrapper = new component.PanelRound();
        header = new component.PanelRound();
        btnHuy = new component.MyButton();
        jLabel1 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        destop = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btnAvatar = new component.MyButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        jLabel17.setText(":");

        wrapper.setBackground(new java.awt.Color(83, 86, 99));
        wrapper.setRoundBottomLeft(15);
        wrapper.setRoundBottomRight(15);
        wrapper.setRoundTopLeft(15);
        wrapper.setRoundTopRight(15);

        header.setBackground(new java.awt.Color(31, 29, 43));
        header.setRoundTopLeft(10);
        header.setRoundTopRight(10);

        btnHuy.setBackground(new java.awt.Color(83, 86, 99));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("X");
        btnHuy.setColor(new java.awt.Color(83, 86, 99));
        btnHuy.setColorClick(new java.awt.Color(234, 124, 105));
        btnHuy.setColorOver(new java.awt.Color(234, 124, 105));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setRadius(10);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel1.setFont(utils.AppUtils.getFont(20f, _BOLD_)


        );
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thông tin tài khoản");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
        );

        container.setBackground(new java.awt.Color(83, 86, 99));
        container.setForeground(new java.awt.Color(255, 255, 255));

        destop.setBackground(new java.awt.Color(83, 86, 99));
        destop.setForeground(java.awt.Color.white);
        jLabel9.setFont(utils.AppUtils.getFont(20f, _NORMAL_));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("jLabel09");

        jLabel29.setFont(utils.AppUtils.getFont(20f, _NORMAL_));
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("jLabel29");

        btnAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Avatar.png"))); // NOI18N
        btnAvatar.setColor(new java.awt.Color(31, 29, 43));
        btnAvatar.setColorClick(new java.awt.Color(31, 29, 43));
        btnAvatar.setColorOver(new java.awt.Color(31, 29, 43));
        btnAvatar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAvatar.setPreferredSize(new java.awt.Dimension(90, 90));
        btnAvatar.setRadius(210);
        btnAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout destopLayout = new javax.swing.GroupLayout(destop);
        destop.setLayout(destopLayout);
        destopLayout.setHorizontalGroup(
            destopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(destopLayout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addGroup(destopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel9))
                .addGap(0, 145, Short.MAX_VALUE))
        );
        destopLayout.setVerticalGroup(
                destopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(destopLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(btnAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(utils.AppUtils.getFont(20f, _BOLD_));
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Thông tin cá nhân");
        jLabel4.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Giới tính");

        jLabel5.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Ngày bắt đầu");


        jLabel6.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Số điện thoại");

        jLabel7.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Vai trò ");

        jLabel8.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Trạng thái");

        jLabel10.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Địa chỉ");

        jLabel11.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Tuổi");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText(":");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText(":");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setText(":");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText(":");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setForeground(java.awt.Color.white);
        jLabel18.setText(":");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setForeground(java.awt.Color.white);
        jLabel19.setText(":");

        jLabel20.setForeground(java.awt.Color.white);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setForeground(java.awt.Color.white);
        jLabel21.setText(":");


        jLabel22.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel22.setForeground(java.awt.Color.white);
        jLabel22.setText("jLabel22");


        jLabel23.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel23.setForeground(java.awt.Color.white);
        jLabel23.setText("jLabel22");


        jLabel24.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel24.setForeground(java.awt.Color.white);
        jLabel24.setText("jLabel22");


        jLabel25.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel25.setForeground(java.awt.Color.white);
        jLabel25.setText("jLabel22");


        jLabel26.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel26.setForeground(java.awt.Color.white);
        jLabel26.setText("jLabel22");


        jLabel27.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel27.setForeground(java.awt.Color.white);
        jLabel27.setText("jLabel22");

        jLabel28.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel28.setForeground(java.awt.Color.white);
        jLabel28.setText("jLabel22");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
                containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(destop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(containerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(containerLayout.createSequentialGroup()
                                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(18, 18, 18)
                                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(containerLayout.createSequentialGroup()
                                                                .addComponent(jLabel12)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(10, 10, 10))
                                                        .addGroup(containerLayout.createSequentialGroup()
                                                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(containerLayout.createSequentialGroup()
                                                                                .addComponent(jLabel21)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(containerLayout.createSequentialGroup()
                                                                                .addGap(9, 9, 9)
                                                                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(containerLayout.createSequentialGroup()
                                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(containerLayout.createSequentialGroup()
                                                                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(jLabel11)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(jLabel8)
                                                                                .addComponent(jLabel10))
                                                                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(containerLayout.createSequentialGroup()
                                                                                        .addGap(20, 20, 20)
                                                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
                containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(destop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel26))
                                .addGap(4, 4, 4)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel19)
                                                .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
                wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wrapperLayout.setVerticalGroup(
                wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(wrapperLayout.createSequentialGroup()
                                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(

            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(443, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvatarActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:;
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnAvatar;
    private component.MyButton btnHuy;
    private javax.swing.JPanel container;
    private javax.swing.JPanel destop;
    private component.PanelRound header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private component.PanelRound wrapper;
    // End of variables declaration//GEN-END:variables
}
