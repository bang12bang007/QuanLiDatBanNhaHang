/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import com.formdev.flatlaf.FlatIntelliJLaf;
import entity.Ban;
import entity.HoaDon;
import icon.FontAwesome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import utils.AppUtils;
import view.employee.GD_DatMon;

import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.JPanel;

import static javax.swing.SwingConstants.LEFT;

import jiconfont.swing.IconFontSwing;
import raven.toast.Notifications;
import view.employee.GD_DatBanTaiCho;
import view.employee.GD_ThanhToan;

import static utils.AppUtils.*;

import view.employee.GD_Ban;

/**
 * @author Laptop
 */
public class OrderCard extends javax.swing.JPanel {

    /**
     * Creates new form OrderCard
     */
    private JPanel mainPanel;
    private HoaDon hoaDon;
    private Double total = 0.0;
    private DecimalFormat tien_format = new DecimalFormat("###,### VNĐ");
    private GD_DatBanTaiCho ql_datMon;//khai biến để back về không cần tạo mới
    private GD_ThanhToan gD_ThanhToan;

    public OrderCard() {
        initComponents();
        setIconBtn();
    }

    public OrderCard(HoaDon hoaDon, JPanel main) {
        mainPanel = main;
        this.hoaDon = hoaDon;
        initComponents();
        setIconBtn();
        maBan.setText(hoaDon.getBan().getMaBan());
        soLuongNguoi.setText(hoaDon.getSoLuongNguoi() + "");
        tacVuList.setPreferredSize(new Dimension(250, 150));
        tacVuList.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        Notifications.getInstance();
        FlatIntelliJLaf.setup();
        createListTacVu();
//        setWarning();
    }

    private void createListTacVu() {
        tacVuList.add(createTacVu("Chuyển bàn", IconFontSwing.buildIcon(FontAwesome.ARROWS_H, 25, Color.WHITE), (e) -> {
            moveTable();
        }));
        tacVuList.add(createTacVu("Ghép hóa đơn", IconFontSwing.buildIcon(FontAwesome.BOOK, 25, Color.WHITE), (e) -> {
            mergeOrder();
        }));
        tacVuList.add(createTacVu("Khôi phục hóa đơn", IconFontSwing.buildIcon(FontAwesome.REFRESH, 25, Color.WHITE), (e) -> {
            cutInvoice();
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

    private void moveTable() {
        if (ql_datMon.canMoveTable(hoaDon)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Không di chuyển được các bàn gộp");
        } else {
            utils.AppUtils.setUI(mainPanel, () -> {
                GD_Ban gD_Ban = new GD_Ban(mainPanel, "CHUYEN_BAN");
                gD_Ban.setBranchMoveTable("DAT_TAI_CHO");
                gD_Ban.setHoaDon(hoaDon);
                return gD_Ban;
            });
        }
        menu.setVisible(false);
    }

    private void sendCook() {
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Gửi Bếp Thành Công !");
        menu.setVisible(false);
    }

    private void mergeOrder() {
        if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Vui lòng nhận bàn để ghép hóa đơn!");
        } else {
            utils.AppUtils.setUI(mainPanel, () -> {
                GD_Ban gD_Ban = new GD_Ban(mainPanel, "GHEP_HOA_DON");
                gD_Ban.setHoaDon(hoaDon);
                return gD_Ban;
            });
        }
        menu.setVisible(false);
    }

    private void cutInvoice() {
        if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Vui lòng nhận bàn để khôi phục hóa đơn!");
        } else {
            ql_datMon.cutInvoice(hoaDon);
            menu.setVisible(false);
            utils.AppUtils.setUI(mainPanel, () -> new GD_DatBanTaiCho(mainPanel, NHANVIEN));
        }
        menu.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        morePanel = new javax.swing.JPanel();
        tacVuList = new javax.swing.JPanel();
        menu = new javax.swing.JPopupMenu();
        panelRound1 = new component.PanelRound();
        panelRound2 = new component.PanelRound();
        soLuongNguoi = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        maBan = new javax.swing.JLabel();
        panelRound8 = new component.PanelRound();
        jSeparator1 = new javax.swing.JSeparator();
        tongTien = new javax.swing.JLabel();
        iconEadting = new javax.swing.JLabel();
        btnChinhSua = new component.MyButton();
        btnThanhToan = new component.MyButton();
        btnTacVu = new component.MyButton();
        btnCheck = new component.MyButton();

        morePanel.setBackground(new java.awt.Color(83, 86, 99));

        tacVuList.setBackground(new java.awt.Color(83, 86, 99));

        javax.swing.GroupLayout tacVuListLayout = new javax.swing.GroupLayout(tacVuList);
        tacVuList.setLayout(tacVuListLayout);
        tacVuListLayout.setHorizontalGroup(
                tacVuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 256, Short.MAX_VALUE)
        );
        tacVuListLayout.setVerticalGroup(
                tacVuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 160, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout morePanelLayout = new javax.swing.GroupLayout(morePanel);
        morePanel.setLayout(morePanelLayout);
        morePanelLayout.setHorizontalGroup(
                morePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tacVuList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        morePanelLayout.setVerticalGroup(
                morePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tacVuList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        menu.setBackground(new java.awt.Color(83, 86, 99));
        menu.setBorder(null);

        setBackground(new java.awt.Color(83, 86, 99));

        panelRound1.setBackground(new java.awt.Color(31, 29, 43));
        panelRound1.setRoundBottomLeft(8);
        panelRound1.setRoundBottomRight(8);
        panelRound1.setRoundTopLeft(8);
        panelRound1.setRoundTopRight(8);

        panelRound2.setBackground(new java.awt.Color(234, 124, 105));
        panelRound2.setRoundTopLeft(8);
        panelRound2.setRoundTopRight(8);

        soLuongNguoi.setFont(utils.AppUtils.getFont(12f, _NORMAL_));
        soLuongNguoi.setForeground(new java.awt.Color(255, 255, 255));
        soLuongNguoi.setText("8");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(warning, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(soLuongNguoi)
                                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(soLuongNguoi)
                                        .addComponent(warning, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(253, 193, 182));
        panelRound3.setForeground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(8);
        panelRound3.setRoundBottomRight(8);
        panelRound3.setRoundTopLeft(8);
        panelRound3.setRoundTopRight(8);
        panelRound3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound3MouseClicked(evt);
            }
        });

        maBan.setFont(utils.AppUtils.getFont(14f, _BOLD_));
        maBan.setForeground(new java.awt.Color(255, 255, 255));
        maBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maBan.setText("BAN0110");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
                panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound3Layout.createSequentialGroup()
                                .addContainerGap(59, Short.MAX_VALUE)
                                .addComponent(maBan)
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
                panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(maBan)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound8.setBackground(new java.awt.Color(83, 86, 99));
        panelRound8.setRoundBottomLeft(8);
        panelRound8.setRoundBottomRight(8);
        panelRound8.setRoundTopLeft(8);
        panelRound8.setRoundTopRight(8);

        tongTien.setFont(utils.AppUtils.getFont(13f, _NORMAL_));
        tongTien.setForeground(new java.awt.Color(255, 255, 255));
        tongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tongTien.setText("0");

        iconEadting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eating_icon.png"))); // NOI18N

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
                panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(panelRound8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                                                .addGap(0, 109, Short.MAX_VALUE)
                                                .addComponent(iconEadting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panelRound8Layout.setVerticalGroup(
                panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addComponent(tongTien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconEadting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );

        btnChinhSua.setForeground(new java.awt.Color(255, 255, 255));
        btnChinhSua.setColor(new java.awt.Color(83, 86, 99));
        btnChinhSua.setColorClick(new java.awt.Color(234, 124, 105));
        btnChinhSua.setColorOver(new java.awt.Color(234, 124, 105));
        btnChinhSua.setRadius(8);
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setColor(new java.awt.Color(83, 86, 99));
        btnThanhToan.setColorClick(new java.awt.Color(234, 124, 105));
        btnThanhToan.setColorOver(new java.awt.Color(234, 124, 105));
        btnThanhToan.setRadius(8);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTacVu.setColor(new java.awt.Color(83, 86, 99));
        btnTacVu.setColorClick(new java.awt.Color(234, 124, 105));
        btnTacVu.setColorOver(new java.awt.Color(234, 124, 105));
        btnTacVu.setRadius(8);
        btnTacVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTacVuActionPerformed(evt);
            }
        });

        btnCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnCheck.setColor(new java.awt.Color(83, 86, 99));
        btnCheck.setColorClick(new java.awt.Color(234, 124, 105));
        btnCheck.setColorOver(new java.awt.Color(234, 124, 105));
        btnCheck.setRadius(8);
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
                panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound1Layout.createSequentialGroup()
                                                .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound1Layout.createSequentialGroup()
                                                .addComponent(btnCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnTacVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
                panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTacVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        // TODO add your handling code here:
        if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Không thể sửa hóa đơn");
        } else {
            editOrder();
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void editOrder() {
        AppUtils.setUI(mainPanel, () -> {
            GD_DatMon gD_DatMon = new GD_DatMon(mainPanel, hoaDon.getBan(), utils.Enum.DatMon_ThemMon.THEMMON);
            gD_DatMon.setHoaDon(this.hoaDon);
            gD_DatMon.setGd_qlDatMon(ql_datMon);
            if (!ql_datMon.isWaitForPayment()) {
                gD_DatMon.setBranch(utils.Enum.TypeDatMon_Branch.DAT_TRUOC_MON);
            }
            return gD_DatMon;
        });
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Vui lòng nhận bàn để thanh toán!");
        } else if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN)) {
            if (gD_ThanhToan == null) {
                gD_ThanhToan = new GD_ThanhToan(hoaDon, mainPanel);
                gD_ThanhToan.showFormThuTien(ql_datMon.getTienPhaiThu(hoaDon), ql_datMon.getHoaDons(hoaDon));
            } else {
                gD_ThanhToan.showFormThuTien(ql_datMon.getTienPhaiThu(hoaDon), ql_datMon.getHoaDons(hoaDon));
            }
        } else {
            utils.AppUtils.setUI(mainPanel, () -> new GD_ThanhToan(hoaDon, mainPanel));
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTacVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTacVuActionPerformed
        // TODO add your handling code here:
        if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Không thể chọn tác vụ");
        } else {
            tacVuList.removeAll();
            createListTacVu();
            menu.removeAll();
            menu.add(morePanel);
            menu.show(btnTacVu, 0, btnTacVu.getHeight() + 5);
        }
    }//GEN-LAST:event_btnTacVuActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Vui lòng nhận bàn để gửi bếp");
        } else if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Không thể gửi bếp");
        } else {
            sendCook();
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void panelRound3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound3MouseClicked
        // TODO add your handling code here:
        editOrder();
    }//GEN-LAST:event_panelRound3MouseClicked

    private void setIconBtn() {
        IconFontSwing.register(FontAwesome.getIconFont());
        btnThanhToan.setIcon(IconFontSwing.buildIcon(FontAwesome.CALCULATOR, 20, Color.WHITE));
        btnChinhSua.setIcon(IconFontSwing.buildIcon(FontAwesome.PENCIL, 20, Color.WHITE));
        btnTacVu.setIcon(IconFontSwing.buildIcon(FontAwesome.ELLIPSIS_H, 20, Color.WHITE));
        btnCheck.setIcon(IconFontSwing.buildIcon(FontAwesome.CUTLERY, 20, Color.WHITE));
        soLuongNguoi.setIcon(IconFontSwing.buildIcon(FontAwesome.USER, 20, Color.WHITE));
    }

    public void setToTal(double total) {
        tongTien.setText(tien_format.format(total));
    }

    public GD_DatBanTaiCho getQl_datMon() {
        return ql_datMon;
    }

    public void setQl_datMon(GD_DatBanTaiCho ql_datMon) {
        this.ql_datMon = ql_datMon;
    }

    private void setWarning() {
        Ban ban = hoaDon.getBan();
        if (ban.getBanGop() == null) {
            if (ban.getSoGhe() < hoaDon.getSoLuongNguoi()) {
                warning.setText("Số ghế không đủ cho " + hoaDon.getSoLuongNguoi() + " người");
            }
        } else {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnCheck;
    private component.MyButton btnChinhSua;
    private component.MyButton btnTacVu;
    private component.MyButton btnThanhToan;
    private javax.swing.JLabel iconEadting;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel maBan;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel morePanel;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound8;
    private javax.swing.JLabel soLuongNguoi;
    private javax.swing.JPanel tacVuList;
    private javax.swing.JLabel tongTien;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
