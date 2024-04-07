/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import LIB.FadeEffect;
import component.MenuItem;
import component.ScrollBarCustom;
import dao.IBanDAO;
import dao.IChiTietHoaDonDAO;
import dao.IHoaDonDAO;
import dao.IKhachHangDAO;
import dao.INhanVienDAO;
import dao.IPhieuDatBanDAO;
import dao.imlp.BanDAO;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.KhachHangDAO;
import dao.imlp.NhanVienDAO;
import dao.imlp.PhieuDatBanDAO;
import datechooser.EventDateChooser;
import datechooser.SelectedAction;
import datechooser.SelectedDate;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatBan;
import icon.FontAwesome;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author Laptop
 */
public class Form_DatBan extends javax.swing.JPanel {

    /**
     * Creates new form Form_DatBan
     */
    private JFrame jFrame;
    private JPanel mainJpanel;
    private Ban ban;
    private HoaDon hoaDon = null;
    private List<MenuItem> dsMon = new ArrayList<MenuItem>();
    private static final Color TRANSPERANT = new Color(0, 0, 0, 0);
    private IPhieuDatBanDAO phieuDatBanDAO = new PhieuDatBanDAO();
    private IBanDAO banDAO = new BanDAO();
    
    public Form_DatBan(JFrame jFrame, Ban ban) {
        this.jFrame = jFrame;
        this.ban = ban;
        initComponents();
        IconFontSwing.register(FontAwesome.getIconFont());
        this.setBackground(new Color(0, 0, 0, 0.7f));
        btnPlus.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 20, Color.WHITE));
        btnMinus.setIcon(IconFontSwing.buildIcon(FontAwesome.MINUS, 20, Color.WHITE));
        txtSoNguoi.setBackground(TRANSPERANT);
        txtYeuCau.setBackground(TRANSPERANT);
        txtYeuCauDatMon.setBackground(TRANSPERANT);
        txtDate.setBackground(TRANSPERANT);
//        txtGioDen.setBackground(TRANSPERANT);
        txtKhachHang.setBackground(TRANSPERANT);
        txtSoDienThoai.setBackground(TRANSPERANT);
        scrollYCMD.setVerticalScrollBar(new ScrollBarCustom());
        scrollYCMD.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        calendar.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 24, new Color(31, 29, 43)));
        iconClock.setIcon(IconFontSwing.buildIcon(FontAwesome.CLOCK_O, 24, new Color(31, 29, 43)));
        dateChooser.addEventDateChooser(new EventDateChooser() {
            public void dateSelected(SelectedAction action, SelectedDate date) {
                LocalDate localDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
                if (localDate.isBefore(LocalDate.now())) {
                    System.out.println("Trước ngay hiện tại");
                    dateChooser.toDay();
                }
                if (action.getAction() == com.raven.datechooser.SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jLabel3 = new javax.swing.JLabel();
        panelRound2 = new component.PanelRound();
        iconClock = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        txtKhachHang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelRound4 = new component.PanelRound();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        yeuCauDatMon = new component.PanelRound();
        scrollYCMD = new javax.swing.JScrollPane();
        txtYeuCauDatMon = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        yeuCauKhac = new component.PanelRound();
        txtYeuCau = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        panelRound7 = new component.PanelRound();
        txtSoNguoi = new javax.swing.JTextField();
        btnPlus = new component.MyButton();
        btnXemThucDon = new component.MyButton();
        btnMinus = new component.MyButton();

        dateChooser.setDateFormat("dd/MM/yyyy");
        dateChooser.setTextRefernce(txtDate);

        setForeground(new java.awt.Color(255, 255, 255));

        wrapper.setBackground(new java.awt.Color(83, 86, 99));

        header.setBackground(new java.awt.Color(31, 29, 43));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đặt chỗ");

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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 707, Short.MAX_VALUE)
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
        btnCat.setText("CẤT");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ngày");

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

        txtDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtDate.setBorder(null);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtDate)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Giờ đến");

        panelRound2.setRoundBottomLeft(8);
        panelRound2.setRoundBottomRight(8);
        panelRound2.setRoundTopLeft(8);
        panelRound2.setRoundTopRight(8);

        iconClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(iconClock, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRound3.setRoundBottomLeft(8);
        panelRound3.setRoundBottomRight(8);
        panelRound3.setRoundTopLeft(8);
        panelRound3.setRoundTopRight(8);

        txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtKhachHang.setBorder(null);

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Khách hàng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số điện thoại");

        panelRound4.setRoundBottomLeft(8);
        panelRound4.setRoundBottomRight(8);
        panelRound4.setRoundTopLeft(8);
        panelRound4.setRoundTopRight(8);

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Yêu cầu đặt món");

        yeuCauDatMon.setRoundBottomLeft(8);
        yeuCauDatMon.setRoundBottomRight(8);
        yeuCauDatMon.setRoundTopLeft(8);
        yeuCauDatMon.setRoundTopRight(8);

        scrollYCMD.setBorder(null);

        txtYeuCauDatMon.setColumns(4);
        txtYeuCauDatMon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtYeuCauDatMon.setLineWrap(true);
        txtYeuCauDatMon.setRows(5);
        txtYeuCauDatMon.setBorder(null);
        txtYeuCauDatMon.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtYeuCauDatMon.setOpaque(false);
        scrollYCMD.setViewportView(txtYeuCauDatMon);

        javax.swing.GroupLayout yeuCauDatMonLayout = new javax.swing.GroupLayout(yeuCauDatMon);
        yeuCauDatMon.setLayout(yeuCauDatMonLayout);
        yeuCauDatMonLayout.setHorizontalGroup(
            yeuCauDatMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yeuCauDatMonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollYCMD))
        );
        yeuCauDatMonLayout.setVerticalGroup(
            yeuCauDatMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yeuCauDatMonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollYCMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Yêu cầu khác");

        yeuCauKhac.setRoundBottomLeft(8);
        yeuCauKhac.setRoundBottomRight(8);
        yeuCauKhac.setRoundTopLeft(8);
        yeuCauKhac.setRoundTopRight(8);

        txtYeuCau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtYeuCau.setBorder(null);
        txtYeuCau.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout yeuCauKhacLayout = new javax.swing.GroupLayout(yeuCauKhac);
        yeuCauKhac.setLayout(yeuCauKhacLayout);
        yeuCauKhacLayout.setHorizontalGroup(
            yeuCauKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yeuCauKhacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtYeuCau))
        );
        yeuCauKhacLayout.setVerticalGroup(
            yeuCauKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtYeuCau)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số người");

        panelRound7.setRoundBottomLeft(8);
        panelRound7.setRoundBottomRight(8);
        panelRound7.setRoundTopLeft(8);
        panelRound7.setRoundTopRight(8);

        txtSoNguoi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSoNguoi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoNguoi.setText("1");
        txtSoNguoi.setBorder(null);
        txtSoNguoi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSoNguoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoNguoiKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSoNguoi, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSoNguoi)
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

        btnXemThucDon.setBackground(new java.awt.Color(31, 29, 43));
        btnXemThucDon.setForeground(new java.awt.Color(255, 255, 255));
        btnXemThucDon.setText("Xem thực đơn");
        btnXemThucDon.setColor(new java.awt.Color(31, 29, 43));
        btnXemThucDon.setColorClick(new java.awt.Color(234, 124, 105));
        btnXemThucDon.setColorOver(new java.awt.Color(234, 124, 105));
        btnXemThucDon.setRadius(8);
        btnXemThucDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemThucDonActionPerformed(evt);
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

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(yeuCauDatMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yeuCauKhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXemThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnMinus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yeuCauDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yeuCauKhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        // TODO add your handling code here:
        int sl = Integer.parseInt(txtSoNguoi.getText());
        txtSoNguoi.setText(++sl + "");
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnXemThucDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemThucDonActionPerformed
        // TODO add your handling code here:
        JFrame jFrame = new JFrame();
        jFrame.setUndecorated(true);
        jFrame.setExtendedState(MAXIMIZED_BOTH);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.add(new Form_XemThucDon(jFrame, txtYeuCauDatMon, hoaDon, dsMon));
        jFrame.setBackground(new Color(0, 0, 0, 0));
        FadeEffect.fadeInFrame(jFrame, 8, 0.1f);
        jFrame.setVisible(true);
    }//GEN-LAST:event_btnXemThucDonActionPerformed

    private void btnCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatActionPerformed
        // TODO add your handling code here:
        SelectedDate date = dateChooser.getSelectedDate();
        Date ngay = new Date(date.getYear(), date.getMonth(), date.getDay());
        String khachHang = txtKhachHang.getText();
        String sdt = txtSoDienThoai.getText();
        int soLuong = Integer.parseInt(txtSoNguoi.getText());
        int trangThai = 0;
        double tienDatCoc = 0;
        String yeuCauKhac = txtYeuCau.getText();
        PhieuDatBan phieuDatBan = new PhieuDatBan(ngay, soLuong, khachHang, sdt, trangThai, tienDatCoc, yeuCauKhac, ban);
        phieuDatBan.setMaPhieuDatBan("PDB" + ban.getMaBan());
        if (!dsMon.isEmpty()) {
            IChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
            INhanVienDAO nhanVienDAO = new NhanVienDAO();
            IKhachHangDAO khachHangDAO = new KhachHangDAO();
            IHoaDonDAO hoaDonDAO = new HoaDonDAO();
            NhanVien nv = (NhanVien) nhanVienDAO.findById("NV120060424290", NhanVien.class);
            KhachHang kh = (KhachHang) khachHangDAO.findById("KH384851291", KhachHang.class);
            hoaDon = new HoaDon(nv, kh, null, null, new Date());
            hoaDon.setBan(ban);
            hoaDon.setMaHoaDon("HD240406082");
            hoaDon.setTrangThai(utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN);
            hoaDonDAO.insert(hoaDon);
            for (MenuItem item : dsMon) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setHoaDon(hoaDon);
                chiTietHoaDon.setMon(item.getMon());
                chiTietHoaDon.setSoLuong(item.getSoLuong());
                chiTietHoaDonDAO.insert(chiTietHoaDon);
            }
        }
        phieuDatBanDAO.insert(phieuDatBan);
        banDAO.updateStateById(ban.getMaBan(), utils.Enum.LoaiTrangThai.BAN_DA_DUOC_DAT);
        this.jFrame.setVisible(false);
        this.jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        utils.AppUtils.setUI(this.mainJpanel, new GD_DatBan(this.mainJpanel));
    }//GEN-LAST:event_btnCatActionPerformed

    private void txtSoNguoiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNguoiKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_txtSoNguoiKeyTyped

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        // TODO add your handling code here:
        int sl = Integer.parseInt(txtSoNguoi.getText());
        txtSoNguoi.setText(sl - 1 > 0 ? --sl + "" : sl + "");
    }//GEN-LAST:event_btnMinusActionPerformed

    private void calendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarMouseClicked
        // TODO add your handling code here:
        dateChooser.showPopup();
    }//GEN-LAST:event_calendarMouseClicked
    
    public void setMainJpanel(JPanel main) {
        this.mainJpanel = main;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnCat;
    private component.MyButton btnHuy;
    private component.MyButton btnMinus;
    private component.MyButton btnPlus;
    private component.MyButton btnXemThucDon;
    private javax.swing.JLabel calendar;
    private datechooser.DateChooser dateChooser;
    private component.PanelRound footer;
    private component.PanelRound header;
    private javax.swing.JLabel iconClock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private component.PanelRound panelRound7;
    private javax.swing.JScrollPane scrollYCMD;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoNguoi;
    private javax.swing.JTextField txtYeuCau;
    private javax.swing.JTextArea txtYeuCauDatMon;
    private javax.swing.JPanel wrapper;
    private component.PanelRound yeuCauDatMon;
    private component.PanelRound yeuCauKhac;
    // End of variables declaration//GEN-END:variables

}
