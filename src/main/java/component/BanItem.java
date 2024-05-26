/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import entity.Ban;
import icon.FontAwesome;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import static javax.swing.SwingConstants.LEFT;

import javax.swing.SwingUtilities;

import jiconfont.swing.IconFontSwing;
import raven.toast.Notifications;

import static utils.AppUtils.*;

import view.employee.GD_Ban;
import view.employee.GD_DatBanTaiCho;
import view.employee.GD_DatMon;

/**
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
    private int trangThai;
    private GD_Ban gD_Ban;
    private GD_DatMon gD_datMon;
    private int maxPeople;

    public BanItem(Ban ban, int trangThai, JPanel main, String type) {
        this.main = main;
        this.type = type;
        this.ban = ban;
        this.trangThai = trangThai;
        initComponents();
        jLabel1.setText(ban.getMaBan());
        if (trangThai == utils.Enum.LoaiTrangThai.BAN_CO_KHACH.ordinal()) {
            image_type = "/images/my_table.png";
        } else if (trangThai == utils.Enum.LoaiTrangThai.BAN_DA_DUOC_DAT.ordinal()) {
            image_type = "/images/my_table_gray.png";
        } else if (trangThai == utils.Enum.LoaiTrangThai.BAN_TRONG.ordinal()) {
            image_type = "/images/my_table_blue.png";
        } else if (trangThai == utils.Enum.LoaiTrangThai.KHAC.ordinal()) {
            image_type = "/images/my_table_grayv2.png";
        }

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(image_type)));
    }

    private void createListTacVu() {
        tacVuList.setPreferredSize(new Dimension(250, 50));
        tacVuList.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        tacVuList.add(createTacVu("Đặt món", IconFontSwing.buildIcon(FontAwesome.SPOON, 25, Color.WHITE), (e) -> {
            gD_Ban.setFormMessageOrderConfirm(this);
            menu.setVisible(false);
        }));
        if (gD_Ban.getBanItems().size() == 1) {
            tacVuList.add(createTacVu("Đặt món", IconFontSwing.buildIcon(FontAwesome.SPOON, 25, Color.WHITE), (e) -> {
                menu.setVisible(false);
            }));
        }
    }

    private void createListTacVuForMergeInvoice() {
        tacVuList.setPreferredSize(new Dimension(250, 50));
        tacVuList.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        tacVuList.add(createTacVu("Ghép hóa đơn", IconFontSwing.buildIcon(FontAwesome.SPOON, 25, Color.WHITE), (e) -> {
            gD_Ban.mergeInvoice();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Ghép hóa đơn thành công");
            utils.AppUtils.setUI(this.main, () -> new GD_DatBanTaiCho(this.main, NHANVIEN));
            menu.setVisible(false);
        }));
    }

    private MyButton createTacVu(String content, Icon icon, ActionListener action) {
        IconFontSwing.register(FontAwesome.getIconFont());
        MyButton button = new MyButton();
        button.setIcon(icon);
        button.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        button.setForeground(Color.WHITE);
        button.setColor(new Color(83, 86, 99));
        button.setColorOver(new Color(234, 124, 105));
        button.setColorClick(new Color(234, 124, 105));
        button.setPreferredSize(new Dimension(250, 50));
        button.setText(content);
        button.setHorizontalAlignment(LEFT);
        button.addActionListener(action);
        return button;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        morePanel = new javax.swing.JPanel();
        tacVuList = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        check_icon = new javax.swing.JLabel();
        myButton1 = new component.MyButton();

        menu.setBackground(new java.awt.Color(83, 86, 99));
        menu.setBorder(null);

        morePanel.setBackground(new java.awt.Color(83, 86, 99));

        tacVuList.setBackground(new java.awt.Color(83, 86, 99));

        javax.swing.GroupLayout tacVuListLayout = new javax.swing.GroupLayout(tacVuList);
        tacVuList.setLayout(tacVuListLayout);
        tacVuListLayout.setHorizontalGroup(tacVuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 256, Short.MAX_VALUE));
        tacVuListLayout.setVerticalGroup(tacVuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 160, Short.MAX_VALUE));

        javax.swing.GroupLayout morePanelLayout = new javax.swing.GroupLayout(morePanel);
        morePanel.setLayout(morePanelLayout);
        morePanelLayout.setHorizontalGroup(morePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(tacVuList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        morePanelLayout.setVerticalGroup(morePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(tacVuList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        setBackground(new java.awt.Color(83, 86, 99));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(utils.AppUtils.getFont(16f, _BOLD_));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("101");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 300, 40));

        check_icon.setForeground(new java.awt.Color(0, 0, 0));
        add(check_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 50, 50));

        myButton1.setBackground(new java.awt.Color(83, 86, 99));
        myButton1.setBorder(null);
        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/my_table.png"))); // NOI18N
        myButton1.setColor(new java.awt.Color(83, 86, 99));
        myButton1.setColorClick(new java.awt.Color(83, 86, 99));
        myButton1.setColorOver(new java.awt.Color(83, 86, 99));
        myButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton1MouseClicked(evt);
            }

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
        add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseEntered

        if (trangThai == utils.Enum.LoaiTrangThai.BAN_TRONG.ordinal() || trangThai == utils.Enum.LoaiTrangThai.BAN_DA_DUOC_DAT.ordinal()) {
            ImageIcon handIcon = new ImageIcon("./src/main/java/icon/icon_close.png");
            Cursor handCursor = Toolkit.getDefaultToolkit().createCustomCursor(handIcon.getImage(), new Point(0, 0), "Hand Cursor");
            myButton1.setCursor(handCursor);
        }
    }//GEN-LAST:event_myButton1MouseEntered

    private void myButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseExited
        // TODO add your handling code here:
//        myButton1.setBorder(null);
    }//GEN-LAST:event_myButton1MouseExited

    public void setActive() {
        ImageIcon icon = new ImageIcon("./src/main/java/icon/check_50.png");
        check_icon.setIcon(icon);
        gD_Ban.addBanItem(this);
    }

    public void setSelected() {
        ImageIcon icon = new ImageIcon("./src/main/java/icon/check_50.png");
        boolean isSelected = check_icon.getIcon() != null ? true : false;
        if (!isSelected) {
            check_icon.setIcon(icon);
            gD_Ban.addBanItem(this);
        } else {
            check_icon.setIcon(null);
            gD_Ban.removeBanItem(this);
        }
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

    public JPanel getMain() {
        return this.main;
    }


    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:

        switch (type) {
            case "DAT_BAN": {
                if (image_type.equals("/images/my_table_blue.png") || image_type.equals("/images/my_table_gray.png")) {
                    gD_Ban.setFormDatBan(ban);
                }
                break;
            }
            case "DAT_MON": {
                if (image_type.equals("/images/my_table_blue.png")) {
                    setSelected();
                } else if (image_type.equals("/images/my_table_gray.png")) {
                    if (gD_Ban.isTimeValidate(LocalDateTime.now(), ban)) {
                        setSelected();
                    } else {
                        gD_Ban.showMessage("Bàn đã đặt trước");
                    }
                }
                break;
            }
            case "CHUYEN_BAN": {
                if (image_type.equals("/images/my_table_blue.png")) {
                    gD_Ban.setFormMessageMoveTable(this);
                }
                break;
            }
            case "GHEP_HOA_DON": {
                if (image_type.equals("/images/my_table_gray.png")) {
                    if (gD_Ban.isTimeValidate(LocalDateTime.now(), ban)) {
                        setSelected();
                    } else {
                        gD_Ban.showMessage("Bàn đã đặt trước");
                    }
                } else {
                    setSelected();
                }
                gD_Ban.updateBanGopByBan(ban);
                break;
            }
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseClicked
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt) && check_icon.getIcon() != null) {
            tacVuList.removeAll();
            if (type.equals("GHEP_HOA_DON")) {
                createListTacVuForMergeInvoice();
            } else {
                createListTacVu();
            }
            menu.removeAll();
            menu.add(morePanel);
            menu.show(this, 20, this.getHeight() / 2);
        }
    }//GEN-LAST:event_myButton1MouseClicked

    public void toGD_DatMon() {
        utils.AppUtils.setUI(main, () -> {
            GD_DatMon gd;
            if (gD_Ban.getGd_Datmon() == null) {//chưa có thì tạo
                gd = new GD_DatMon(main, gD_Ban.getMainBan(), utils.Enum.DatMon_ThemMon.DATMON);
                gd.setBranch(utils.Enum.TypeDatMon_Branch.DATMON);
                gd.setgD_Ban(gD_Ban);
                gd.setMaxPeople(maxPeople);
            } else {//có load vào rồi thì gọi lại
                gd = gD_Ban.getGd_Datmon();
                gd.getBtnBack().setBackground(new Color(83, 86, 99));
            }
            return gd;
        });
    }

    public void move() {
        gD_Ban.moveTable(this.ban);
    }

    public GD_DatMon getgD_datMon() {
        return gD_datMon;
    }

    public void setgD_datMon(GD_DatMon gD_datMon) {
        this.gD_datMon = gD_datMon;
    }

    public void setMaxPeople(GD_DatMon gd, int max) {
        gd.setMaxPeople(max);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel check_icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel morePanel;
    private component.MyButton myButton1;
    private javax.swing.JPanel tacVuList;
    // End of variables declaration//GEN-END:variables

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}
