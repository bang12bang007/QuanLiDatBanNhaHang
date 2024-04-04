/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import entity.NhanVien;
import entity.TaiKhoan;
import icon.FontAwesome;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import jiconfont.swing.IconFontSwing;
import static utils.AppUtils.FONT;

/**
 *
 * @author Laptop
 */
public class GD_DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form GD_DangNhap
     */
    public GD_DangNhap() {
        initComponents();
//        nhanVien_Dao.insertNhanVien(new NhanVien("Ngo Dang Khoa", "QN", 1, 18, "0796798049", new Date(), 0, 1));
//        System.out.println(taiKhoanDAO.insertTaiKhoan(new TaiKhoanDTO("NV1181524049")));
        IconFontSwing.register(FontAwesome.getIconFont());
        iconUser.setIcon(IconFontSwing.buildIcon(FontAwesome.USER, 20));
        iconPass.setIcon(IconFontSwing.buildIcon(FontAwesome.LOCK, 20));
        tenDangNhap.setBackground(new Color(0, 0, 0, 1));
        matKhau.setBackground(new Color(0, 0, 0, 1));
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        wrapper = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnDangNhap = new component.MyButton();
        imgae = new javax.swing.JLabel();
        userNameContaier = new javax.swing.JPanel();
        iconUser = new javax.swing.JLabel();
        tenDangNhap = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passContaier = new javax.swing.JPanel();
        iconPass = new javax.swing.JLabel();
        matKhau = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setResizable(false);

        wrapper.setBackground(new java.awt.Color(235, 234, 232));

        title.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo_2.png"))); // NOI18N

        btnDangNhap.setForeground(new java.awt.Color(158, 154, 149));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setColor(new java.awt.Color(38, 32, 25));
        btnDangNhap.setColorClick(new java.awt.Color(47, 41, 33));
        btnDangNhap.setColorOver(new java.awt.Color(68, 58, 45));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDangNhap.setRadius(50);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        imgae.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg.jpg"))); // NOI18N

        userNameContaier.setBackground(new java.awt.Color(235, 234, 232));

        tenDangNhap.setBorder(null);

        javax.swing.GroupLayout userNameContaierLayout = new javax.swing.GroupLayout(userNameContaier);
        userNameContaier.setLayout(userNameContaierLayout);
        userNameContaierLayout.setHorizontalGroup(
            userNameContaierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userNameContaierLayout.createSequentialGroup()
                .addComponent(iconUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenDangNhap))
        );
        userNameContaierLayout.setVerticalGroup(
            userNameContaierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        passContaier.setBackground(new java.awt.Color(235, 234, 232));

        matKhau.setBorder(null);
        matKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout passContaierLayout = new javax.swing.GroupLayout(passContaier);
        passContaier.setLayout(passContaierLayout);
        passContaierLayout.setHorizontalGroup(
            passContaierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passContaierLayout.createSequentialGroup()
                .addComponent(iconPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matKhau))
        );
        passContaierLayout.setVerticalGroup(
            passContaierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconPass, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(matKhau)
        );

        jLabel3.setText("Tên đăng nhập");

        jLabel4.setText("Mật khẩu");

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addComponent(imgae, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(passContaier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(userNameContaier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(100, 100, 100))
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameContaier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passContaier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(imgae, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapper, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapper, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        String tenDangNhap = this.tenDangNhap.getText();
        String matKhau = this.matKhau.getText();
//        if(nv==null) {
//            JOptionPane.showMessageDialog(this, "Đăng Nhập Thất bại");
//        } else {
//            setVisible(false);
//            if(nv.getVaiTro().equals(utils.Enum.LoaiVaiTro.NHAN_VIEN_QL)) {
////                Chuyen qua gd quan ly
//                new GD_TrangChu(nv).setVisible(true);
//            } else {
////                Chuyen qua gd nhan vien
//                new GD_TrangChu(nv).setVisible(true);
//            }
//        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void matKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matKhauActionPerformed

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
            java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnDangNhap;
    private javax.swing.JLabel iconPass;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel imgae;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField matKhau;
    private javax.swing.JPanel passContaier;
    private javax.swing.JTextField tenDangNhap;
    private javax.swing.JLabel title;
    private javax.swing.JPanel userNameContaier;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables
}
