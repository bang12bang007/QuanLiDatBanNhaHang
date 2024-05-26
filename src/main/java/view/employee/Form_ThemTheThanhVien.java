/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.employee;

import com.formdev.flatlaf.FlatIntelliJLaf;
import dao.IKhachHangDAO;
import dao.ITheThanhVienDAO;
import dao.imlp.KhachHangDAO;
import dao.imlp.TheThanhVienDAO;
import datechooser.EventDateChooser;
import datechooser.SelectedAction;
import datechooser.SelectedDate;
import entity.KhachHang;
import entity.TheThanhVien;
import icon.FontAwesome;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import jiconfont.swing.IconFontSwing;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import raven.toast.Notifications;

import static utils.AppUtils.*;

/**
 * @author Laptop
 */
public class Form_ThemTheThanhVien extends javax.swing.JPanel {

    private JFrame jFrame;
    private static final Color TRANSPERANT = new Color(0, 0, 0, 0);
    private List<String> items = new ArrayList<String>();
    private List<KhachHang> khachHangs = new ArrayList<KhachHang>();
    private IKhachHangDAO khachHangDAO = new KhachHangDAO();
    private ITheThanhVienDAO theThanhVienDAO = new TheThanhVienDAO();
    private GD_ThanhToan GDThanhToan;

    public Form_ThemTheThanhVien(JFrame jFrame) {
        this.jFrame = jFrame;
        initComponents();
        Notifications.getInstance().setJFrame(jFrame);
        FlatIntelliJLaf.setup();
        IconFontSwing.register(FontAwesome.getIconFont());
        this.setBackground(new Color(0, 0, 0, 0.6f));
        txtYeuCau.setBackground(TRANSPERANT);
        txtDate.setBackground(TRANSPERANT);
        txtKhachHang.setBackground(TRANSPERANT);
        txtSoDienThoai.setBackground(TRANSPERANT);
        calendar.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 24, new Color(31, 29, 43)));
        dateChooser.addEventDateChooser(new EventDateChooser() {
            public void dateSelected(SelectedAction action, SelectedDate date) {
                if (action.getAction() == com.raven.datechooser.SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
        });
        autoComplete();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new datechooser.DateChooser();
        wrapper = new javax.swing.JPanel();
        header = new component.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        footer = new component.PanelRound();
        btnCat = new component.MyButton();
        btnHuy = new component.MyButton();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new component.PanelRound();
        calendar = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        panelRound3 = new component.PanelRound();
        txtKhachHang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelRound4 = new component.PanelRound();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        yeuCauKhac = new component.PanelRound();
        txtYeuCau = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        dateChooser.setDateFormat("dd/MM/yyyy");
        dateChooser.setTextRefernce(txtDate);

        setForeground(new java.awt.Color(255, 255, 255));

        wrapper.setBackground(new java.awt.Color(83, 86, 99));

        header.setBackground(new java.awt.Color(31, 29, 43));

        jLabel1.setFont(utils.AppUtils.getFont(16f, _BOLD_));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thêm thẻ thành viên");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_close.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(623, 623, 623)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        footer.setBackground(new java.awt.Color(31, 29, 43));

        btnCat.setForeground(new java.awt.Color(255, 255, 255));
        btnCat.setText("ĐỒNG Ý");
        btnCat.setColor(new java.awt.Color(83, 86, 99));
        btnCat.setColorClick(new java.awt.Color(234, 124, 105));
        btnCat.setColorOver(new java.awt.Color(234, 124, 105));
        btnCat.setRadius(8);
        btnCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatActionPerformed(evt);
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
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(btnCat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnCat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ngày sinh");

        panelRound1.setBackground(java.awt.Color.white);
        panelRound1.setRoundBottomLeft(8);
        panelRound1.setRoundBottomRight(8);
        panelRound1.setRoundTopLeft(8);
        panelRound1.setRoundTopRight(8);

        calendar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarMouseClicked(evt);
            }
        });

        txtDate.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtDate.setBorder(null);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtDate)
        );

        panelRound3.setBackground(java.awt.Color.white);
        panelRound3.setRoundBottomLeft(8);
        panelRound3.setRoundBottomRight(8);
        panelRound3.setRoundTopLeft(8);
        panelRound3.setRoundTopRight(8);

        txtKhachHang.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtKhachHang.setBorder(null);
        txtKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachHangKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtKhachHang))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtKhachHang)
        );

        jLabel4.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên thành viên");

        jLabel5.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số điện thoại");

        panelRound4.setBackground(java.awt.Color.white);
        panelRound4.setRoundBottomLeft(8);
        panelRound4.setRoundBottomRight(8);
        panelRound4.setRoundTopLeft(8);
        panelRound4.setRoundTopRight(8);

        txtSoDienThoai.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtSoDienThoai.setBorder(null);

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSoDienThoai))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSoDienThoai)
        );

        jLabel7.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Địa chỉ");

        yeuCauKhac.setBackground(java.awt.Color.white);
        yeuCauKhac.setRoundBottomLeft(8);
        yeuCauKhac.setRoundBottomRight(8);
        yeuCauKhac.setRoundTopLeft(8);
        yeuCauKhac.setRoundTopRight(8);

        txtYeuCau.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtYeuCau.setBorder(null);
        txtYeuCau.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout yeuCauKhacLayout = new javax.swing.GroupLayout(yeuCauKhac);
        yeuCauKhac.setLayout(yeuCauKhacLayout);
        yeuCauKhacLayout.setHorizontalGroup(
            yeuCauKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yeuCauKhacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtYeuCau)
                .addContainerGap())
        );
        yeuCauKhacLayout.setVerticalGroup(
            yeuCauKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtYeuCau)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("*");

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yeuCauKhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(yeuCauKhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, wrapperLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatActionPerformed
        KhachHang khachHang = khachHangDAO.findByPhoneNumber(txtSoDienThoai.getText());
        if (isValidate()) {
            if (!isExistTheThanhVien(khachHang)) {
                if (khachHang == null) {
                    String sdt = txtSoDienThoai.getText();
                    khachHang = new KhachHang(txtKhachHang.getText(), txtSoDienThoai.getText(), txtYeuCau.getText());
                    sdt = txtSoDienThoai.getText().substring(1, txtSoDienThoai.getText().length());
                    khachHang.setMaKhachHang("KH" + sdt);
                    khachHangDAO.insert(khachHang);
                }
                TheThanhVien theThanhVien = new TheThanhVien(0.0, khachHang, utils.Enum.LoaiTheThanhVien.TIEUCHUAN);
                theThanhVien.setMaThe(createMaThe(khachHang));
                boolean isSuccess = theThanhVienDAO.insert(theThanhVien);
                if (isSuccess) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 1500, "Thêm thẻ thành viên thành công");
                    jFrame.setVisible(false);
                    jFrame.dispose();
                    utils.AppUtils.setUI(GDThanhToan.getMainPanel(), () -> {
                        GD_ThanhToan gd = new GD_ThanhToan(GDThanhToan.getHoaDon(), GDThanhToan.getMainPanel());
                        gd.setThe(theThanhVien);
                        return gd;
                    });
                }
            } else {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 1500, "Khách hàng đã có thẻ thành viên");
            }
        }
    }//GEN-LAST:event_btnCatActionPerformed

    private String createMaThe(KhachHang khachHang) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String formattedDate = date.format(formatter);
        String maKhachHang = khachHang.getMaKhachHang();

        // Lấy 3 số cuối của mã khách hàng
        String threeLastDigits = maKhachHang.substring(maKhachHang.length() - 3);

        // Tạo mã thẻ
        return formattedDate + threeLastDigits;
    }

    private boolean isValidate() {
        String khachHang = txtKhachHang.getText();
        String sdt = txtSoDienThoai.getText();
        if (khachHang.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 1500, "Không được rỗng");
            return false;
        }
        if (sdt.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 1500, "Không được rỗng");
            return false;
        }
        if (!sdt.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 1500, "Số điện thoại không hợp lệ");
            return false;
        }
        return true;
    }

    private boolean isExistTheThanhVien(KhachHang khachHang) {
        if (khachHang == null) {
            return false;
        }
        List<TheThanhVien> theThanhViens = theThanhVienDAO.findAll(TheThanhVien.class);
        for (TheThanhVien theThanhVien : theThanhViens) {
            if (theThanhVien.getKhachHang().getHoTen().equals(khachHang.getHoTen())) {
                return true;
            }
        }
        return false;
    }

    void setGDThanhToan(GD_ThanhToan aThis) {
        this.GDThanhToan = aThis;
    }

    private void calendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarMouseClicked
        // TODO add your handling code here:
        dateChooser.showPopup();
    }//GEN-LAST:event_calendarMouseClicked

    private void autoComplete() {
        khachHangs = khachHangDAO.findAll(KhachHang.class);
        for (KhachHang khachHang : khachHangs) {
            items.add((khachHang).getHoTen());
        }
        AutoCompleteDecorator.decorate(txtKhachHang, items, false);
    }

    private void txtKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachHangKeyReleased
        String value = txtKhachHang.getText();
        if (items.contains(value)) {
            for (KhachHang kh : khachHangs) {
                if (kh.getHoTen().equals(value)) {
                    txtSoDienThoai.setText(kh.getSoDienThoai());
                    break;
                }
            }
        }
    }//GEN-LAST:event_txtKhachHangKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnCat;
    private component.MyButton btnHuy;
    private javax.swing.JLabel calendar;
    private datechooser.DateChooser dateChooser;
    private component.PanelRound footer;
    private component.PanelRound header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtYeuCau;
    private javax.swing.JPanel wrapper;
    private component.PanelRound yeuCauKhac;
    // End of variables declaration//GEN-END:variables

}
