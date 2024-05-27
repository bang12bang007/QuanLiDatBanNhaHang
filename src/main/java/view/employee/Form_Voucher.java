/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.employee;

import com.formdev.flatlaf.FlatIntelliJLaf;
import component.MenuItem;
import dao.IBanDAO;
import dao.IChiTietHoaDonDAO;
import dao.IHoaDonDAO;
import dao.IKhachHangDAO;
import dao.imlp.BanDAO;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.KhachHangDAO;
import dao.imlp.KhuyenMaiDAO;
import entity.Ban;
import entity.ChiTietKhuyenMai;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhanVien;
import icon.FontAwesome;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jiconfont.swing.IconFontSwing;
import raven.toast.Notifications;
import static utils.AppUtils.*;

/**
 * @author Laptop
 */
public class Form_Voucher extends javax.swing.JPanel {

    /**
     * Creates new form Form_DatBan
     */
    private JFrame jFrame;
    private KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
    private static final Color TRANSPERANT = new Color(0, 0, 0, 0);
    private List<KhuyenMai> voucherKhuyenMai;
    private List<HoaDon> hoaDons = new ArrayList<>();
    private KhuyenMai voucherSelected = null;
    private JLabel thanhTienKMKhach;
    private JLabel tienPhaiThu;
    private JLabel tongThanhToan;

    public Form_Voucher(JFrame jFrame) {
        this.jFrame = jFrame;
        initComponents();
        Notifications.getInstance().setJFrame(jFrame);
        FlatIntelliJLaf.setup();
        IconFontSwing.register(FontAwesome.getIconFont());
        this.setBackground(new Color(0, 0, 0, 0.6f));
        btnPlus.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 20, Color.WHITE));
        btnMinus.setIcon(IconFontSwing.buildIcon(FontAwesome.MINUS, 20, Color.WHITE));
        txtSoLuong.setBackground(TRANSPERANT);
        txtMaThe.setBackground(TRANSPERANT);
        txtMenhGia.setBackground(TRANSPERANT);
        setDataLoaiThe();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new datechooser.DateChooser();
        wrapper = new javax.swing.JPanel();
        header = new component.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        footer = new component.PanelRound();
        btnDongY = new component.MyButton();
        btnHuy = new component.MyButton();
        jLabel3 = new javax.swing.JLabel();
        panelRound2 = new component.PanelRound();
        loaiTheComboBox = new javax.swing.JComboBox<>();
        panelRound3 = new component.PanelRound();
        txtMenhGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        maTheContainer = new component.PanelRound();
        txtMaThe = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        panelRound7 = new component.PanelRound();
        txtSoLuong = new javax.swing.JTextField();
        btnPlus = new component.MyButton();
        btnMinus = new component.MyButton();
        jLabel10 = new javax.swing.JLabel();

        dateChooser.setDateFormat("dd/MM/yyyy");

        setForeground(new java.awt.Color(255, 255, 255));

        wrapper.setBackground(new java.awt.Color(83, 86, 99));

        header.setBackground(new java.awt.Color(31, 29, 43));

        jLabel1.setFont(utils.AppUtils.getFont(16f, _BOLD_));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sử dụng voucher");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_close.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_close.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(632, 632, 632)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(33, 33, 33))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(headerLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        footer.setBackground(new java.awt.Color(31, 29, 43));

        btnDongY.setForeground(new java.awt.Color(255, 255, 255));
        btnDongY.setText("ĐỒNG Ý");
        btnDongY.setColor(new java.awt.Color(83, 86, 99));
        btnDongY.setColorClick(new java.awt.Color(234, 124, 105));
        btnDongY.setColorOver(new java.awt.Color(234, 124, 105));
        btnDongY.setRadius(8);
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
            }
        });

        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HỦY BỎ");
        btnHuy.setColor(new java.awt.Color(83, 86, 99));
        btnHuy.setColorClick(new java.awt.Color(234, 124, 105));
        btnHuy.setColorOver(new java.awt.Color(234, 124, 105));
        btnHuy.setRadius(8);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Loại Thẻ");

        panelRound2.setBackground(java.awt.Color.white);
        panelRound2.setRoundBottomLeft(8);
        panelRound2.setRoundBottomRight(8);
        panelRound2.setRoundTopLeft(8);
        panelRound2.setRoundTopRight(8);

        loaiTheComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loaiTheComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"","Ít Cay","Nhiều Cay","Cay Vừa","Không Đá","Ít Ngọt","Ngọt","Nhiều Đá"}));
        loaiTheComboBox.setBorder(null);
        loaiTheComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiTheComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(loaiTheComboBox, 0, 590, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(loaiTheComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );

        panelRound3.setBackground(java.awt.Color.white);
        panelRound3.setRoundBottomLeft(8);
        panelRound3.setRoundBottomRight(8);
        panelRound3.setRoundTopLeft(8);
        panelRound3.setRoundTopRight(8);

        txtMenhGia.setEditable(false);
        txtMenhGia.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtMenhGia.setBorder(null);
        txtMenhGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMenhGiaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMenhGia)
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMenhGia)
        );

        jLabel4.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mệnh giá");

        jLabel7.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mã thẻ");

        maTheContainer.setBackground(java.awt.Color.white);
        maTheContainer.setRoundBottomLeft(8);
        maTheContainer.setRoundBottomRight(8);
        maTheContainer.setRoundTopLeft(8);
        maTheContainer.setRoundTopRight(8);

        txtMaThe.setEditable(false);
        txtMaThe.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtMaThe.setBorder(null);
        txtMaThe.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout maTheContainerLayout = new javax.swing.GroupLayout(maTheContainer);
        maTheContainer.setLayout(maTheContainerLayout);
        maTheContainerLayout.setHorizontalGroup(
            maTheContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maTheContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaThe)
                .addContainerGap())
        );
        maTheContainerLayout.setVerticalGroup(
            maTheContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMaThe)
        );

        jLabel8.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số Lượng");

        panelRound7.setBackground(new java.awt.Color(255, 255, 255));
        panelRound7.setRoundBottomLeft(8);
        panelRound7.setRoundBottomRight(8);
        panelRound7.setRoundTopLeft(8);
        panelRound7.setRoundTopRight(8);

        txtSoLuong.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("1");
        txtSoLuong.setBorder(null);
        txtSoLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        btnPlus.setBackground(new java.awt.Color(31, 29, 43));
        btnPlus.setForeground(new java.awt.Color(255, 255, 255));
        btnPlus.setColor(new java.awt.Color(31, 29, 43));
        btnPlus.setColorClick(new java.awt.Color(234, 124, 105));
        btnPlus.setColorOver(new java.awt.Color(234, 124, 105));
        btnPlus.setRadius(8);
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        btnMinus.setBackground(new java.awt.Color(31, 29, 43));
        btnMinus.setForeground(new java.awt.Color(255, 255, 255));
        btnMinus.setColor(new java.awt.Color(31, 29, 43));
        btnMinus.setColorClick(new java.awt.Color(234, 124, 105));
        btnMinus.setColorOver(new java.awt.Color(234, 124, 105));
        btnMinus.setRadius(8);
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("*");

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 773, Short.MAX_VALUE)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maTheContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelRound7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPlus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maTheContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setDataLoaiThe() {
        List<KhuyenMai> allKhuyenMai = khuyenMaiDAO.findAll(KhuyenMai.class);
        voucherKhuyenMai = allKhuyenMai.stream()
                .filter(km -> km.getLoaiKhuyenMai().equals(utils.Enum.LoaiKhuyenMai.VOUCHER))
                .sorted(Comparator.comparingDouble(KhuyenMai::getChietKhau).reversed())
                .collect(Collectors.toList());
        List<String> dataList = new ArrayList<>();
        dataList.add("");
        dataList.addAll(voucherKhuyenMai.stream()
                .map(KhuyenMai::getTenKhuyenMai)
                .collect(Collectors.toList()));
        String[] data = dataList.toArray(new String[0]);
        loaiTheComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(data));
    }

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        // TODO add your handling code here:
        int sl = Integer.parseInt(txtSoLuong.getText());
        if (sl + 1 > hoaDons.size()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1000, "Không thể áp dụng thêm voucher!");
        } else {
            txtSoLuong.setText(++sl + "");
        }
    }//GEN-LAST:event_btnPlusActionPerformed

    private boolean isExistVoucher(HoaDon hoaDon) {
        for (ChiTietKhuyenMai chiTietKhuyenMai : hoaDon.getChiTietKhuyenMai()) {
            if (chiTietKhuyenMai.getKhuyenMai().getLoaiKhuyenMai().equals(utils.Enum.LoaiKhuyenMai.VOUCHER)) {
                return true;
            }
        }
        return false;
    }

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
        if (voucherSelected != null) {
            if (Integer.parseInt(txtSoLuong.getText()) <= hoaDons.size()) {
                boolean isSuccess = false;
                for (int i = 0; i < Integer.parseInt(txtSoLuong.getText()); i++) {
                    HoaDon hoaDon = hoaDons.get(i);
                    ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(hoaDon, voucherSelected);
                    if (!isExistVoucher(hoaDon)) {
                        hoaDon.getChiTietKhuyenMai().add(chiTietKhuyenMai);
                        hoaDon.tienPhaiThu();
                        isSuccess = true;
                    }
                }
                double thanhTienKhac = thanhTienKMKhach.getText().trim().equals("")
                        ? 0
                        : Double.parseDouble(thanhTienKMKhach.getText().replace("VNĐ", "").replace(",", ""));
                if (!isSuccess) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1000, "Mỗi voucher chỉ áp dụng cho 1 hóa đơn");
                } else {
                    thanhTienKMKhach.setText(FORMAT_MONEY.format(thanhTienKhac + voucherSelected.getChietKhau()));
                    tienPhaiThu.setText(FORMAT_MONEY.format((Double.parseDouble(tongThanhToan.getText().replace("VNĐ", "").replace(",", "")) - Double.parseDouble(thanhTienKMKhach.getText().replace("VNĐ", "").replace(",", "")))));
                    jFrame.setVisible(false);
                    jFrame.dispose();
                }
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1000, "Không thể áp dụng thêm voucher!");
                txtSoLuong.setText("1");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1000, "Vui lòng chọn vào voucher!");
        }
    }//GEN-LAST:event_btnDongYActionPerformed


    private void txtSoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_txtSoLuongKeyTyped

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        // TODO add your handling code here:
        int sl = Integer.parseInt(txtSoLuong.getText());
        txtSoLuong.setText(sl - 1 > 0 ? --sl + "" : sl + "");
    }//GEN-LAST:event_btnMinusActionPerformed

    private void txtMenhGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMenhGiaKeyReleased

    }//GEN-LAST:event_txtMenhGiaKeyReleased

    private void loaiTheComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiTheComboBoxActionPerformed
        // TODO add your handling code here
        List<KhuyenMai> khuyenMais = voucherKhuyenMai.stream().filter(km -> km.getTenKhuyenMai().equals(loaiTheComboBox.getSelectedItem().toString())).toList();
        if (!khuyenMais.isEmpty()) {
            voucherSelected = khuyenMais.get(0);
            txtMenhGia.setText(khuyenMais.get(0).getChietKhau() > 1 ? FORMAT_MONEY.format(khuyenMais.get(0).getChietKhau()) : khuyenMais.get(0).getChietKhau() * 100 + "%");
            txtMaThe.setText(khuyenMais.get(0).getMaKhuyenMai());
        } else {
            voucherSelected = null;
            txtMenhGia.setText("");
            txtMaThe.setText("");
        }
    }//GEN-LAST:event_loaiTheComboBoxActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel12MouseClicked

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public void setThanhTienKMKhach(JLabel thanhTienKMKhach) {
        this.thanhTienKMKhach = thanhTienKMKhach;
    }

    public void setTienPhaiThu(JLabel tienPhaiThu) {
        this.tienPhaiThu = tienPhaiThu;
    }

    public void setTongThanhToan(JLabel tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnDongY;
    private component.MyButton btnHuy;
    private component.MyButton btnMinus;
    private component.MyButton btnPlus;
    private datechooser.DateChooser dateChooser;
    private component.PanelRound footer;
    private component.PanelRound header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> loaiTheComboBox;
    private component.PanelRound maTheContainer;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound7;
    private javax.swing.JTextField txtMaThe;
    private javax.swing.JTextField txtMenhGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables

}
