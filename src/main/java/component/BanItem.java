/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import LIB.FadeEffect;
import dao.IBanDAO;
import dao.IHoaDonDAO;
import dao.IPhieuDatBanDAO;
import dao.imlp.BanDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.PhieuDatBanDAO;
import entity.Ban;
import entity.HoaDon;
import entity.NhanVien;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import static utils.AppUtils.*;
import view.Form_DatBan;
import view.GD_Ban;
import view.GD_DatBan;
import view.GD_DatMon;

/**
 *
 * @author dmx
 */
public class BanItem extends javax.swing.JPanel {

    /**
     * Creates new form BanItem
     */
    private JPanel main;
    private String type;
    private String image_type;
    private Ban ban;
    private NhanVien nv;
    private int trangThai;
    private GD_Ban gD_Ban;

    public BanItem(Ban ban, int trangThai, JPanel main, String type) {
        this.main = main;
        this.type = type;
        this.ban = ban;
        this.nv = NHANVIEN;
        this.trangThai = trangThai;
        initComponents();
        jLabel1.setText(ban.getMaBan());

        if (trangThai == utils.Enum.LoaiTrangThai.BAN_CO_KHACH.ordinal()) {
            image_type = "/images/my_table.png";
        } else if (trangThai == utils.Enum.LoaiTrangThai.BAN_DA_DUOC_DAT.ordinal()) {
            image_type = "/images/my_table_gray.png";
        } else if (trangThai == utils.Enum.LoaiTrangThai.BAN_TRONG.ordinal()) {
            image_type = "/images/my_table_blue.png";
        }

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(image_type)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        myButton1 = new component.MyButton();

        setBackground(new java.awt.Color(83, 86, 99));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("101");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 300, 40));

        myButton1.setBackground(new java.awt.Color(83, 86, 99));
        myButton1.setBorder(null);
        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/my_table.png"))); // NOI18N
        myButton1.setColor(new java.awt.Color(83, 86, 99));
        myButton1.setColorClick(new java.awt.Color(83, 86, 99));
        myButton1.setColorOver(new java.awt.Color(83, 86, 99));
        myButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myButton1MouseExited(evt);
            }
        });
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseEntered

        if (trangThai == utils.Enum.LoaiTrangThai.BAN_TRONG.ordinal()) {
            ImageIcon handIcon = new ImageIcon("./src/main/java/icon/icon_close.png");
            Cursor handCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                    handIcon.getImage(), new Point(0, 0), "Hand Cursor");
            myButton1.setCursor(handCursor);
        }
//        myButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_myButton1MouseEntered

    private void myButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseExited
        // TODO add your handling code here:
//        myButton1.setBorder(null);

    }//GEN-LAST:event_myButton1MouseExited

    public void setActive() {
//       Hien thi de test
        myButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(255, 255, 255)));

    }

    public void setGDBan(GD_Ban gD_Ban) {
        this.gD_Ban = gD_Ban;
    }

    public GD_Ban getGDBan() {
        return this.gD_Ban;
    }

    public Ban getBan() {
        return this.ban;
    }

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:

        switch (type) {
            case "DAT_BAN": {
                if (image_type.equals("/images/my_table_blue.png")) {
                    JFrame jFrame = new JFrame();
                    jFrame.setUndecorated(true);
                    jFrame.setExtendedState(MAXIMIZED_BOTH);
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    Form_DatBan form_DatBan = new Form_DatBan(jFrame, ban);
                    form_DatBan.setMainJpanel(main);
                    jFrame.add(form_DatBan);
                    jFrame.setBackground(new Color(0, 0, 0, 0));
                    FadeEffect.fadeInFrame(jFrame, 8, 0.1f);
                    jFrame.setVisible(true);
                }

                break;
            }
            case "DAT_MON": {
                if (image_type.equals("/images/my_table_blue.png")) {
                    utils.AppUtils.setUI(main, new GD_DatMon(main, ban, utils.Enum.DatMon_ThemMon.DATMON));
                }
            }
            case "CHUYEN_BAN": {
                if (image_type.equals("/images/my_table_blue.png")) {
                    String fromBan = this.gD_Ban.getBanActive().getMaBan();
                    String toBan = this.ban.getMaBan();
                    JFrame jFrame = new JFrame();
                    jFrame.setUndecorated(true);
                    jFrame.setExtendedState(MAXIMIZED_BOTH);
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    Message message = new Message(jFrame, this);
                    jFrame.add(message);
                    jFrame.setBackground(new Color(0, 0, 0, 0));
                    FadeEffect.fadeInFrame(jFrame, 8, 0.1f);
                    jFrame.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    public void move() {
        gD_Ban.moveTable(this.ban);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private component.MyButton myButton1;
    // End of variables declaration//GEN-END:variables

}
