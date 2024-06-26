/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.employee;

import LIB.FadeEffect;
import component.DiscountItem;
import component.OrderItem;
import component.ScrollBarCustom;
import component.WrapLayout;
import dao.IChiTietHoaDonDAO;
import dao.IHoaDonDAO;
import dao.IKhachHangDAO;
import dao.IKhuyenMaiDAO;
import dao.IMonDAO;
import dao.ITheThanhVienDAO;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.KhachHangDAO;
import dao.imlp.KhuyenMaiDAO;
import dao.imlp.MonDAO;
import dao.imlp.TheThanhVienDAO;
import entity.ChiTietKhuyenMai;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.Mon;
import entity.TheThanhVien;
import icon.FontAwesome;
import java.awt.Color;
import jiconfont.swing.IconFontSwing;
import javax.swing.*;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import static utils.AppUtils.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import raven.toast.Notifications;

/**
 * @author Laptop
 */
public class GD_ThanhToan extends javax.swing.JPanel {
    
    private HoaDon hoaDon;
    private IChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    private IHoaDonDAO hoaDonDAO = new HoaDonDAO();
    private IMonDAO monDAO = new MonDAO();
    private ITheThanhVienDAO theThanhVienDAO = new TheThanhVienDAO();
    private IKhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
    private IKhachHangDAO khachHangDAO = new KhachHangDAO();
    
    private JPanel mJPanel;
    private DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a");
    private DecimalFormat tien_format = new DecimalFormat("###,### VNĐ");
    private JFrame thuTienJFrame;
    
    private List<String> loaiThe = List.of("STANDARD", "BRONZE", "SILVER", "GOLD", "DIAMOND");
    private List<DiscountItem> discountItems = new ArrayList<>();
    private List<String> items = new ArrayList<>();
    private List<TheThanhVien> theThanhViens = new ArrayList<>();
    private List<KhuyenMai> khuyenMais = new ArrayList<>();
    private TheThanhVien theThanhVien = null;
    private int indexIsActive = -1;
    private JPanel branch;
    private List<HoaDon> hoaDonGhep = new ArrayList<>();
    private double oldPoint = 0;
    
    public GD_ThanhToan(HoaDon hoaDon, JPanel mJPanel) {
        this.hoaDon = hoaDon;
        this.mJPanel = mJPanel;
        this.hoaDonGhep = hoaDonDAO.getListHoaDonGhep(hoaDon, utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN);
        initComponents();
        IconFontSwing.register(FontAwesome.getIconFont());
        theThanhVienLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.CREDIT_CARD, 20, Color.WHITE));
        chuongTrinhKhuyenMai.setIcon(IconFontSwing.buildIcon(FontAwesome.GIFT, 20, Color.WHITE));
        btnAddKM.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 20, Color.WHITE));
        btnDown.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_DOWN, 10, Color.WHITE));
        btnUp.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_UP, 10, Color.WHITE));
        btnDownTable.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_DOWN, 10, Color.WHITE));
        btnUpTable.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_UP, 10, Color.WHITE));
        btnBack.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_LEFT, 10, Color.WHITE));
        btnScanQR.setIcon(IconFontSwing.buildIcon(FontAwesome.QRCODE, 20, Color.WHITE));
        khuyenMai.setIcon(IconFontSwing.buildIcon(FontAwesome.TAG, 20, Color.WHITE));
        iconSearch.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 20));
        btnThemThanhVien.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 20));
        iconSearch_KM.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 20));
        maHoaDon.setIcon(IconFontSwing.buildIcon(FontAwesome.PENCIL, 20, Color.WHITE));
        txtMTV.setBackground(new Color(0, 0, 0, 0));
        txtMKM.setBackground(new Color(0, 0, 0, 0));
        tableContainer.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        MKMcontainer.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        tableBody.setVerticalScrollBar(new ScrollBarCustom());
        tableBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tableContainer.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (tableContainer.getWidth() != 0 && tableContainer.getHeight() != 0) {
                    loadData();
                    tableContainer.removeComponentListener(this);
                }
            }
        });
        MKMcontainer.setPreferredSize(new Dimension(500, MKMcontainer.getPreferredSize().height));
        MKMcontainer.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (MKMcontainer.getWidth() != 0 && tableContainer.getHeight() != 0) {
                    loadDataMKM();
                    MKMcontainer.removeComponentListener(this);
                }
            }
        });
        maHoaDon.setText(hoaDon.getMaHoaDon() + " - " + hoaDon.getBan().getMaBan());
        setTotalAndSubTotal();
        ngayGioHienTai.setText(myFormatObj.format(LocalDateTime.now()));
        btnInTamTinh.setIcon(IconFontSwing.buildIcon(FontAwesome.PRINT, 20, Color.WHITE));
        btnLuuTam.setIcon(IconFontSwing.buildIcon(FontAwesome.FLOPPY_O, 20, Color.WHITE));
        btnThuTien.setIcon(IconFontSwing.buildIcon(FontAwesome.MONEY, 20, Color.WHITE));
        autoComplete();
        onChangeMutipl();
    }
    
    private void setTotalAndSubTotal() {
        Double[] results = getTotalAndSubTotal();
        thanhTien.setText(tien_format.format(results[1]));
//        tongThanhToan.setText(FORMAT_MONEY.format(results[2]));
        tienThu.setText(tien_format.format(results[0]));
        thanhTienKMKhac.setText("");
    }
    
    private Double[] getTotalAndSubTotal() {
        double tienThu = 0;
        double thanhTien = 0;
        
        for (HoaDon hd : this.hoaDonGhep) {
            tienThu += hd.getTienPhaiThu();
            thanhTien += chiTietHoaDonDAO.TotalFoodCurrency(hd);
        }
        
        return new Double[]{tienThu, thanhTien, tienThu * THUE};
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftContainer = new javax.swing.JPanel();
        theThanhVienContainer = new javax.swing.JPanel();
        theThanhVienLabel = new javax.swing.JLabel();
        maTheContainer = new component.PanelRound();
        iconSearch = new javax.swing.JLabel();
        txtMTV = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        maTheContainer1 = new component.PanelRound();
        txtTenThanhVien = new javax.swing.JTextField();
        btnThemThanhVien = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        maTheContainer2 = new component.PanelRound();
        txtHangThe = new javax.swing.JTextField();
        ctkmContainer = new javax.swing.JPanel();
        chuongTrinhKhuyenMai = new javax.swing.JLabel();
        btnAddKM = new component.MyButton();
        btnDown = new component.MyButton();
        btnUp = new component.MyButton();
        ctkmContainer1 = new javax.swing.JPanel();
        khuyenMai = new javax.swing.JLabel();
        maTheContainer3 = new component.PanelRound();
        txtMKM = new javax.swing.JTextField();
        iconSearch_KM = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MKMcontainer = new javax.swing.JPanel();
        btnScanQR = new component.MyButton();
        rightContainer = new javax.swing.JPanel();
        theThanhVienContainer1 = new javax.swing.JPanel();
        maHoaDon = new javax.swing.JLabel();
        ngayGioHienTai = new javax.swing.JLabel();
        btnBack = new component.MyButton();
        jPanel2 = new javax.swing.JPanel();
        btnThuTien = new component.MyButton();
        btnLuuTam = new component.MyButton();
        btnInTamTinh = new component.MyButton();
        btnUpTable = new component.MyButton();
        btnDownTable = new component.MyButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        table = new javax.swing.JPanel();
        headerTable = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tableBody = new javax.swing.JScrollPane();
        tableContainer = new javax.swing.JPanel();
        tongThanhToan = new javax.swing.JLabel();
        voucher = new component.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        panelRound2 = new component.PanelRound();
        diem = new javax.swing.JLabel();
        tienThu = new javax.swing.JLabel();
        thanhTienKMKhac = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        thanhTien = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        thue = new javax.swing.JLabel();

        leftContainer.setBackground(new java.awt.Color(83, 86, 99));

        theThanhVienContainer.setBackground(new java.awt.Color(31, 29, 43));

        theThanhVienLabel.setFont(utils.AppUtils.getFont(16f, _BOLD_)
        );
        theThanhVienLabel.setForeground(new java.awt.Color(255, 255, 255));
        theThanhVienLabel.setText("Thể thành viên");

        javax.swing.GroupLayout theThanhVienContainerLayout = new javax.swing.GroupLayout(theThanhVienContainer);
        theThanhVienContainer.setLayout(theThanhVienContainerLayout);
        theThanhVienContainerLayout.setHorizontalGroup(
            theThanhVienContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theThanhVienContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(theThanhVienLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        theThanhVienContainerLayout.setVerticalGroup(
            theThanhVienContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theThanhVienContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(theThanhVienLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        maTheContainer.setBackground(new java.awt.Color(255, 255, 255));
        maTheContainer.setRoundBottomLeft(8);
        maTheContainer.setRoundBottomRight(8);
        maTheContainer.setRoundTopLeft(8);
        maTheContainer.setRoundTopRight(8);

        txtMTV.setEditable(false);
        txtMTV.setBorder(null);

        javax.swing.GroupLayout maTheContainerLayout = new javax.swing.GroupLayout(maTheContainer);
        maTheContainer.setLayout(maTheContainerLayout);
        maTheContainerLayout.setHorizontalGroup(
            maTheContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maTheContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMTV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        maTheContainerLayout.setVerticalGroup(
            maTheContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(txtMTV)
        );

        jLabel1.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã thành viên");

        jLabel2.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên Thành viên");

        maTheContainer1.setBackground(new java.awt.Color(255, 255, 255));
        maTheContainer1.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        maTheContainer1.setRoundBottomLeft(8);
        maTheContainer1.setRoundBottomRight(8);
        maTheContainer1.setRoundTopLeft(8);
        maTheContainer1.setRoundTopRight(8);

        txtTenThanhVien.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        txtTenThanhVien.setBorder(null);
        txtTenThanhVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenThanhVienKeyReleased(evt);
            }
        });

        btnThemThanhVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThemThanhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemThanhVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout maTheContainer1Layout = new javax.swing.GroupLayout(maTheContainer1);
        maTheContainer1.setLayout(maTheContainer1Layout);
        maTheContainer1Layout.setHorizontalGroup(
            maTheContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maTheContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemThanhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        maTheContainer1Layout.setVerticalGroup(
            maTheContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTenThanhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(btnThemThanhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hạng Thẻ");

        maTheContainer2.setBackground(new java.awt.Color(255, 255, 255));
        maTheContainer2.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        maTheContainer2.setRoundBottomLeft(8);
        maTheContainer2.setRoundBottomRight(8);
        maTheContainer2.setRoundTopLeft(8);
        maTheContainer2.setRoundTopRight(8);

        txtHangThe.setEditable(false);
        txtHangThe.setBackground(java.awt.Color.white);
        txtHangThe.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        txtHangThe.setBorder(null);

        javax.swing.GroupLayout maTheContainer2Layout = new javax.swing.GroupLayout(maTheContainer2);
        maTheContainer2.setLayout(maTheContainer2Layout);
        maTheContainer2Layout.setHorizontalGroup(
            maTheContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maTheContainer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHangThe)
                .addContainerGap())
        );
        maTheContainer2Layout.setVerticalGroup(
            maTheContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtHangThe, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        ctkmContainer.setBackground(new java.awt.Color(31, 29, 43));

        chuongTrinhKhuyenMai.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        chuongTrinhKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        chuongTrinhKhuyenMai.setText("Chương trình khuyến mãi");

        javax.swing.GroupLayout ctkmContainerLayout = new javax.swing.GroupLayout(ctkmContainer);
        ctkmContainer.setLayout(ctkmContainerLayout);
        ctkmContainerLayout.setHorizontalGroup(
            ctkmContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctkmContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(chuongTrinhKhuyenMai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ctkmContainerLayout.setVerticalGroup(
            ctkmContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctkmContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chuongTrinhKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAddKM.setForeground(new java.awt.Color(255, 255, 255));
        btnAddKM.setText("SỬ DỤNG ĐIỂM");
        btnAddKM.setColor(new java.awt.Color(31, 29, 43));
        btnAddKM.setColorClick(new java.awt.Color(234, 124, 105));
        btnAddKM.setColorOver(new java.awt.Color(234, 124, 105));
        btnAddKM.setFont(utils.AppUtils.getFont(15f, _NORMAL_)
        );
        btnAddKM.setRadius(8);
        btnAddKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKMActionPerformed(evt);
            }
        });

        btnDown.setForeground(new java.awt.Color(255, 255, 255));
        btnDown.setColor(new java.awt.Color(31, 29, 43));
        btnDown.setColorClick(new java.awt.Color(234, 124, 105));
        btnDown.setColorOver(new java.awt.Color(234, 124, 105));
        btnDown.setRadius(8);
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnUp.setForeground(new java.awt.Color(255, 255, 255));
        btnUp.setColor(new java.awt.Color(31, 29, 43));
        btnUp.setColorClick(new java.awt.Color(234, 124, 105));
        btnUp.setColorOver(new java.awt.Color(234, 124, 105));
        btnUp.setRadius(8);
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        ctkmContainer1.setBackground(new java.awt.Color(31, 29, 43));

        khuyenMai.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        khuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        khuyenMai.setText("Mã khuyến mãi");

        maTheContainer3.setBackground(new java.awt.Color(255, 255, 255));
        maTheContainer3.setRoundBottomLeft(8);
        maTheContainer3.setRoundBottomRight(8);
        maTheContainer3.setRoundTopLeft(8);
        maTheContainer3.setRoundTopRight(8);

        txtMKM.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        txtMKM.setBorder(null);
        txtMKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout maTheContainer3Layout = new javax.swing.GroupLayout(maTheContainer3);
        maTheContainer3.setLayout(maTheContainer3Layout);
        maTheContainer3Layout.setHorizontalGroup(
            maTheContainer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maTheContainer3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMKM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconSearch_KM, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        maTheContainer3Layout.setVerticalGroup(
            maTheContainer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconSearch_KM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtMKM, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout ctkmContainer1Layout = new javax.swing.GroupLayout(ctkmContainer1);
        ctkmContainer1.setLayout(ctkmContainer1Layout);
        ctkmContainer1Layout.setHorizontalGroup(
            ctkmContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctkmContainer1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(khuyenMai)
                .addGap(31, 31, 31)
                .addComponent(maTheContainer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        ctkmContainer1Layout.setVerticalGroup(
            ctkmContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctkmContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ctkmContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctkmContainer1Layout.createSequentialGroup()
                        .addComponent(maTheContainer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(khuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);

        MKMcontainer.setBackground(new java.awt.Color(83, 86, 99));
        MKMcontainer.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );

        javax.swing.GroupLayout MKMcontainerLayout = new javax.swing.GroupLayout(MKMcontainer);
        MKMcontainer.setLayout(MKMcontainerLayout);
        MKMcontainerLayout.setHorizontalGroup(
            MKMcontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        MKMcontainerLayout.setVerticalGroup(
            MKMcontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(MKMcontainer);

        btnScanQR.setForeground(new java.awt.Color(255, 255, 255));
        btnScanQR.setText("Quét mã QR");
        btnScanQR.setColor(new java.awt.Color(31, 29, 43));
        btnScanQR.setColorClick(new java.awt.Color(234, 124, 105));
        btnScanQR.setColorOver(new java.awt.Color(234, 124, 105));
        btnScanQR.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        btnScanQR.setRadius(8);
        btnScanQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanQRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftContainerLayout = new javax.swing.GroupLayout(leftContainer);
        leftContainer.setLayout(leftContainerLayout);
        leftContainerLayout.setHorizontalGroup(
            leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(theThanhVienContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ctkmContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ctkmContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftContainerLayout.createSequentialGroup()
                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftContainerLayout.createSequentialGroup()
                        .addComponent(btnAddKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(220, 220, 220)
                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftContainerLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnScanQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(leftContainerLayout.createSequentialGroup()
                                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maTheContainer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(maTheContainer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(maTheContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(16, 16, 16))
            .addComponent(jScrollPane1)
        );
        leftContainerLayout.setVerticalGroup(
            leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftContainerLayout.createSequentialGroup()
                .addComponent(theThanhVienContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftContainerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(maTheContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftContainerLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftContainerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(maTheContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftContainerLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)))
                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftContainerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(maTheContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftContainerLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)))
                .addGap(15, 15, 15)
                .addComponent(btnScanQR, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ctkmContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnAddKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(ctkmContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        rightContainer.setBackground(new java.awt.Color(83, 86, 99));
        rightContainer.setForeground(new java.awt.Color(255, 255, 255));

        theThanhVienContainer1.setBackground(new java.awt.Color(31, 29, 43));

        maHoaDon.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        maHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        maHoaDon.setText("11122003-Ban101");
        maHoaDon.setToolTipText("");

        ngayGioHienTai.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        ngayGioHienTai.setForeground(new java.awt.Color(255, 255, 255));
        ngayGioHienTai.setText("13/3/2024 5:10 SA");
        ngayGioHienTai.setToolTipText("");

        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setColor(new java.awt.Color(83, 86, 99));
        btnBack.setColorClick(new java.awt.Color(234, 124, 105));
        btnBack.setColorOver(new java.awt.Color(234, 124, 105));
        btnBack.setRadius(8);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout theThanhVienContainer1Layout = new javax.swing.GroupLayout(theThanhVienContainer1);
        theThanhVienContainer1.setLayout(theThanhVienContainer1Layout);
        theThanhVienContainer1Layout.setHorizontalGroup(
            theThanhVienContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, theThanhVienContainer1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(maHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ngayGioHienTai)
                .addContainerGap())
        );
        theThanhVienContainer1Layout.setVerticalGroup(
            theThanhVienContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theThanhVienContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(theThanhVienContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(theThanhVienContainer1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(theThanhVienContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(ngayGioHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(31, 29, 43));

        btnThuTien.setForeground(new java.awt.Color(255, 255, 255));
        btnThuTien.setText("Thu tiền");
        btnThuTien.setToolTipText("");
        btnThuTien.setColor(new java.awt.Color(83, 86, 99));
        btnThuTien.setColorClick(new java.awt.Color(234, 124, 105));
        btnThuTien.setColorOver(new java.awt.Color(234, 124, 105));
        btnThuTien.setFont(utils.AppUtils.getFont(13f, _BOLD_)
        );
        btnThuTien.setRadius(8);
        btnThuTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuTienActionPerformed(evt);
            }
        });

        btnLuuTam.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuTam.setText("Lưu tạm");
        btnLuuTam.setToolTipText("");
        btnLuuTam.setColor(new java.awt.Color(83, 86, 99));
        btnLuuTam.setColorClick(new java.awt.Color(234, 124, 105));
        btnLuuTam.setColorOver(new java.awt.Color(234, 124, 105));
        btnLuuTam.setFont(utils.AppUtils.getFont(13f, _BOLD_)
        );
        btnLuuTam.setRadius(8);
        btnLuuTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTamActionPerformed(evt);
            }
        });

        btnInTamTinh.setForeground(new java.awt.Color(255, 255, 255));
        btnInTamTinh.setText("In tạm tính");
        btnInTamTinh.setToolTipText("");
        btnInTamTinh.setColor(new java.awt.Color(83, 86, 99));
        btnInTamTinh.setColorClick(new java.awt.Color(234, 124, 105));
        btnInTamTinh.setColorOver(new java.awt.Color(234, 124, 105));
        btnInTamTinh.setFont(utils.AppUtils.getFont(13f, _BOLD_)
        );
        btnInTamTinh.setRadius(8);
        btnInTamTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInTamTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInTamTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnLuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnThuTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThuTien, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInTamTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnUpTable.setForeground(new java.awt.Color(255, 255, 255));
        btnUpTable.setColor(new java.awt.Color(31, 29, 43));
        btnUpTable.setColorClick(new java.awt.Color(234, 124, 105));
        btnUpTable.setColorOver(new java.awt.Color(234, 124, 105));
        btnUpTable.setRadius(8);
        btnUpTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpTableActionPerformed(evt);
            }
        });

        btnDownTable.setForeground(new java.awt.Color(255, 255, 255));
        btnDownTable.setColor(new java.awt.Color(31, 29, 43));
        btnDownTable.setColorClick(new java.awt.Color(234, 124, 105));
        btnDownTable.setColorOver(new java.awt.Color(234, 124, 105));
        btnDownTable.setRadius(8);
        btnDownTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownTableActionPerformed(evt);
            }
        });

        jLabel4.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tổng thanh toán:");

        jLabel5.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Còn phải thu:");

        headerTable.setBackground(new java.awt.Color(31, 29, 43));
        headerTable.setLayout(new java.awt.GridLayout(1, 4));

        jLabel6.setFont(utils.AppUtils.getFont(18f, _NORMAL_)
        );
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("  Tên món");
        headerTable.add(jLabel6);

        jLabel7.setFont(utils.AppUtils.getFont(18f, _NORMAL_)
        );
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" SL");
        headerTable.add(jLabel7);

        jLabel8.setFont(utils.AppUtils.getFont(18f, _NORMAL_)
        );
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" Đơn giá");
        headerTable.add(jLabel8);

        jLabel9.setFont(utils.AppUtils.getFont(18f, _NORMAL_)
        );
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Thành tiền");
        headerTable.add(jLabel9);

        tableBody.setBackground(new java.awt.Color(83, 86, 99));
        tableBody.setBorder(null);

        tableContainer.setBackground(new java.awt.Color(83, 86, 99));
        tableContainer.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );

        javax.swing.GroupLayout tableContainerLayout = new javax.swing.GroupLayout(tableContainer);
        tableContainer.setLayout(tableContainerLayout);
        tableContainerLayout.setHorizontalGroup(
            tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
        );
        tableContainerLayout.setVerticalGroup(
            tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        tableBody.setViewportView(tableContainer);

        javax.swing.GroupLayout tableLayout = new javax.swing.GroupLayout(table);
        table.setLayout(tableLayout);
        tableLayout.setHorizontalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tableBody, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );
        tableLayout.setVerticalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableLayout.createSequentialGroup()
                .addComponent(headerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableBody, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
        );

        tongThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        tongThanhToan.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        tongThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        tongThanhToan.setText("1000000");

        voucher.setBackground(new java.awt.Color(234, 124, 105));
        voucher.setRoundBottomLeft(12);
        voucher.setRoundBottomRight(12);
        voucher.setRoundTopLeft(12);
        voucher.setRoundTopRight(12);
        voucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voucherMouseClicked(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(234, 124, 105));
        jLabel10.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("VOUCHER");

        javax.swing.GroupLayout voucherLayout = new javax.swing.GroupLayout(voucher);
        voucher.setLayout(voucherLayout);
        voucherLayout.setHorizontalGroup(
            voucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        voucherLayout.setVerticalGroup(
            voucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(12);
        panelRound2.setRoundBottomRight(12);
        panelRound2.setRoundTopLeft(12);
        panelRound2.setRoundTopRight(12);

        diem.setBackground(new java.awt.Color(255, 255, 255));
        diem.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        diem.setForeground(new java.awt.Color(31, 29, 43));
        diem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diem.setText("ĐIỂM");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diem, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tienThu.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        tienThu.setForeground(new java.awt.Color(255, 255, 255));
        tienThu.setText("100000");

        thanhTienKMKhac.setBackground(new java.awt.Color(255, 255, 255));
        thanhTienKMKhac.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        thanhTienKMKhac.setForeground(new java.awt.Color(255, 255, 255));
        thanhTienKMKhac.setText("1111111");

        jLabel11.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Thành tiền:");

        thanhTien.setBackground(new java.awt.Color(255, 255, 255));
        thanhTien.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        thanhTien.setForeground(new java.awt.Color(255, 255, 255));
        thanhTien.setText("1000000");

        jLabel12.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Thuế  GTGT 5%");

        thue.setBackground(new java.awt.Color(255, 255, 255));
        thue.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        thue.setForeground(new java.awt.Color(255, 255, 255));
        thue.setText("1000000");

        javax.swing.GroupLayout rightContainerLayout = new javax.swing.GroupLayout(rightContainer);
        rightContainer.setLayout(rightContainerLayout);
        rightContainerLayout.setHorizontalGroup(
            rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(theThanhVienContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightContainerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightContainerLayout.createSequentialGroup()
                        .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(rightContainerLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rightContainerLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(thue, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(rightContainerLayout.createSequentialGroup()
                                    .addComponent(voucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)))
                            .addGroup(rightContainerLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(186, 186, 186)))
                        .addGap(40, 40, 40)
                        .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tienThu, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thanhTienKMKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightContainerLayout.createSequentialGroup()
                        .addComponent(btnUpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDownTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))))
        );
        rightContainerLayout.setVerticalGroup(
            rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightContainerLayout.createSequentialGroup()
                .addComponent(theThanhVienContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDownTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tongThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(thanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(rightContainerLayout.createSequentialGroup()
                        .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(voucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(rightContainerLayout.createSequentialGroup()
                        .addComponent(thanhTienKMKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tienThu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(rightContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(leftContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKMActionPerformed
        // TODO add your handling code here:
        if (thuTienJFrame == null || !thuTienJFrame.isVisible()) {
            thuTienJFrame = new JFrame();
            thuTienJFrame.setUndecorated(true);
            thuTienJFrame.setExtendedState(MAXIMIZED_BOTH);
            thuTienJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            if (this.theThanhVien == null) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1000, "Vui lòng nhập thông tin thành viên");
            } else {
                Form_SuDungDiem form_SuDungDiem = new Form_SuDungDiem(thuTienJFrame, this.theThanhVien);
                form_SuDungDiem.setTienPhaiThu(tienThu);
                form_SuDungDiem.setThanhTienKMKhac(thanhTienKMKhac);
                form_SuDungDiem.setHoaDons(hoaDonGhep);
                form_SuDungDiem.setGDThanhToan(this);
                form_SuDungDiem.setTongThanhToan(Double.parseDouble(tongThanhToan.getText().replace("VNĐ", "").replace(",", "")));
                thuTienJFrame.add(form_SuDungDiem);
                thuTienJFrame.setBackground(new Color(0, 0, 0, 0));
                FadeEffect.fadeInFrame(thuTienJFrame, 8, 0.1f);
                thuTienJFrame.setVisible(true);
            }
        } else {
            thuTienJFrame.toFront();
        }
    }//GEN-LAST:event_btnAddKMActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        // TODO add your handling code here:
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getValue() + 30);
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        // TODO add your handling code here:
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getValue() - 30);
    }//GEN-LAST:event_btnUpActionPerformed

    private void txtMKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMKMActionPerformed

    private void btnScanQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScanQRActionPerformed
        // TODO add your handling code here:

        if (thuTienJFrame == null || !thuTienJFrame.isVisible()) {
            thuTienJFrame = new JFrame();
            thuTienJFrame.setUndecorated(true);
            thuTienJFrame.setExtendedState(MAXIMIZED_BOTH);
            thuTienJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Form_QRCODE form_QRCODE = new Form_QRCODE(thuTienJFrame, this);
            thuTienJFrame.add(form_QRCODE);
            thuTienJFrame.setBackground(new Color(0, 0, 0, 0));
            FadeEffect.fadeInFrame(thuTienJFrame, 8, 0.1f);
            thuTienJFrame.setVisible(true);
        } else {
            thuTienJFrame.toFront();
        }
    }//GEN-LAST:event_btnScanQRActionPerformed

    private void btnUpTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpTableActionPerformed
        // TODO add your handling code here:
        tableBody.getVerticalScrollBar().setValue(tableBody.getVerticalScrollBar().getValue() - 30);
    }//GEN-LAST:event_btnUpTableActionPerformed

    private void btnDownTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownTableActionPerformed
        // TODO add your handling code here:
        tableBody.getVerticalScrollBar().setValue(tableBody.getVerticalScrollBar().getValue() + 30);
    }//GEN-LAST:event_btnDownTableActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        utils.AppUtils.setUI(mJPanel, () -> new GD_DatBanTaiCho(mJPanel, utils.AppUtils.NHANVIEN));
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnThuTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuTienActionPerformed
        // TODO add your handling code here:
        showFormThuTien(Double.parseDouble(tienThu.getText().replace("VNĐ", "").replace(",", "")), this.hoaDonGhep);
    }//GEN-LAST:event_btnThuTienActionPerformed
    
    public void showFormThuTien(Double tienPhaiThu, List<HoaDon> hoaDons) {
        if (thuTienJFrame == null || !thuTienJFrame.isVisible()) {
            thuTienJFrame = new JFrame();
            thuTienJFrame.setUndecorated(true);
            thuTienJFrame.setExtendedState(MAXIMIZED_BOTH);
            thuTienJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Form_ThuTien form_ThuTien = new Form_ThuTien(thuTienJFrame, hoaDons);
            form_ThuTien.setTienPhaiThu(tienPhaiThu);
            form_ThuTien.setThue(Double.parseDouble(thue.getText().replace("VNĐ", "").replace(",", "")));
            form_ThuTien.setMainJPanel(mJPanel);
            form_ThuTien.setTheThanhVien(theThanhVien);
            thuTienJFrame.add(form_ThuTien);
            thuTienJFrame.setBackground(new Color(0, 0, 0, 0));
            FadeEffect.fadeInFrame(thuTienJFrame, 8, 0.1f);
            thuTienJFrame.setVisible(true);
        } else {
            thuTienJFrame.toFront();
        }
    }

    private void btnLuuTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuTamActionPerformed
        // TODO add your handling code here:
        if (thuTienJFrame == null || !thuTienJFrame.isVisible()) {
            thuTienJFrame = new JFrame();
            thuTienJFrame.setUndecorated(true);
            thuTienJFrame.setExtendedState(MAXIMIZED_BOTH);
            thuTienJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Form_LuuTam form_LuuTam = new Form_LuuTam(thuTienJFrame, mJPanel, Double.parseDouble(thue.getText().replace("VNĐ", "").replace(",", "")));
            form_LuuTam.setHoaDons(hoaDonGhep);
            thuTienJFrame.add(form_LuuTam);
            thuTienJFrame.setBackground(new Color(0, 0, 0, 0));
            FadeEffect.fadeInFrame(thuTienJFrame, 8, 0.1f);
            thuTienJFrame.setVisible(true);
        } else {
            thuTienJFrame.toFront();
        }
    }//GEN-LAST:event_btnLuuTamActionPerformed

    private void btnInTamTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInTamTinhActionPerformed
        // TODO add your handling code here:
        if (thuTienJFrame == null || !thuTienJFrame.isVisible()) {
            thuTienJFrame = new JFrame();
            thuTienJFrame.setUndecorated(true);
            thuTienJFrame.setExtendedState(MAXIMIZED_BOTH);
            thuTienJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Form_LuuTam form_LuuTam = new Form_LuuTam(thuTienJFrame, mJPanel, Double.parseDouble(thue.getText().replace("VNĐ", "").replace(",", "")));
            form_LuuTam.setHoaDons(hoaDonGhep);
            form_LuuTam.setType("IN_LUU_TAM");
            thuTienJFrame.add(form_LuuTam);
            thuTienJFrame.setBackground(new Color(0, 0, 0, 0));
            FadeEffect.fadeInFrame(thuTienJFrame, 8, 0.1f);
            thuTienJFrame.setVisible(true);
        } else {
            thuTienJFrame.toFront();
        }
    }//GEN-LAST:event_btnInTamTinhActionPerformed

    private void txtTenThanhVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenThanhVienKeyReleased
        // TODO add your handling code here:
        String value = txtTenThanhVien.getText();
        if (items.contains(value)) {
            for (TheThanhVien the : theThanhViens) {
                if (the.getKhachHang().getHoTen().equals(value)) {
                    theThanhVien = the;
                    setThe(theThanhVien);
                    break;
                }
            }
        } else {
            theThanhVien = null;
            setThe(theThanhVien);
        }
    }//GEN-LAST:event_txtTenThanhVienKeyReleased

    private void voucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voucherMouseClicked
        // TODO add your handling code here:
        if (thuTienJFrame == null || !thuTienJFrame.isVisible()) {
            thuTienJFrame = new JFrame();
            thuTienJFrame.setUndecorated(true);
            thuTienJFrame.setExtendedState(MAXIMIZED_BOTH);
            thuTienJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Form_Voucher form_Voucher = new Form_Voucher(thuTienJFrame);
            form_Voucher.setHoaDons(hoaDonGhep);
            form_Voucher.setThanhTienKMKhach(thanhTienKMKhac);
            form_Voucher.setTienPhaiThu(tienThu);
            form_Voucher.setTongThanhToan(tongThanhToan);
            thuTienJFrame.add(form_Voucher);
            thuTienJFrame.setBackground(new Color(0, 0, 0, 0));
            FadeEffect.fadeInFrame(thuTienJFrame, 8, 0.1f);
            thuTienJFrame.setVisible(true);
        } else {
            thuTienJFrame.toFront();
        }
    }//GEN-LAST:event_voucherMouseClicked

    private void btnThemThanhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemThanhVienMouseClicked
        // TODO add your handling code here:
        if (thuTienJFrame == null || !thuTienJFrame.isVisible()) {
            thuTienJFrame = new JFrame();
            thuTienJFrame.setUndecorated(true);
            thuTienJFrame.setExtendedState(MAXIMIZED_BOTH);
            thuTienJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Form_ThemTheThanhVien form_ThemTheThanhVien = new Form_ThemTheThanhVien(thuTienJFrame);
            form_ThemTheThanhVien.setGDThanhToan(this);
            thuTienJFrame.add(form_ThemTheThanhVien);
            thuTienJFrame.setBackground(new Color(0, 0, 0, 0));
            FadeEffect.fadeInFrame(thuTienJFrame, 8, 0.1f);
            thuTienJFrame.setVisible(true);
        } else {
            thuTienJFrame.toFront();
        }
    }//GEN-LAST:event_btnThemThanhVienMouseClicked
    
    public void loadData() {
        int width = tableContainer.getWidth();
        int index = 1;
        Map<Mon, Long> map = chiTietHoaDonDAO.getListByBan(hoaDon, utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN);
        for (Map.Entry<Mon, Long> entry : map.entrySet()) {
            Mon mon = entry.getKey();
            Long soLuong = entry.getValue();
            tableContainer.add(new OrderItem(width, index, new String[]{mon.getTenMon(), soLuong + "", mon.getGiaBan() + "", soLuong * mon.getGiaBan() + ""}));
            index = index == 1 ? 2 : 1;
        }
    }
    
    private void loadDataMKM() {
        int width = MKMcontainer.getWidth();
        AtomicInteger index = new AtomicInteger(0);
        khuyenMaiDAO.findAll(KhuyenMai.class)
                .stream()
                .filter((t) -> ((KhuyenMai) t).getLoaiKhuyenMai().equals(utils.Enum.LoaiKhuyenMai.SU_KIEN_DAC_BIET))
                .sorted(Comparator.comparingDouble(KhuyenMai::getChietKhau).reversed())
                .toList().forEach((object) -> {
                    KhuyenMai khuyenMai = (KhuyenMai) object;
                    DiscountItem khuyenMaiItem = new DiscountItem(index.getAndIncrement(), width, khuyenMai);
                    khuyenMaiItem.setGDThanhToan(this);
                    if (khuyenMaiItem.getIndex() == 0) {
                        khuyenMaiItem.active();
                        setIndexIsActive(khuyenMaiItem.getIndex());
                    }
                    discountItems.add(khuyenMaiItem);
                    MKMcontainer.add(khuyenMaiItem);
                });
    }
    
    public void setActive(int index) {
        boolean isAllNotActive = true;
        khuyenMais = new ArrayList<>();
        onChangeMutipl();
        for (DiscountItem discountItem : discountItems) {
            if (discountItem.getIndex() == index && index != indexIsActive()) {
                discountItem.active();
                setIndexIsActive(index);
                isAllNotActive = false;
            } else {
                discountItem.notActive();
            }
        }
        if (isAllNotActive) {
            setIndexIsActive(-1);
        }
    }
    
    public void setDataOfCustomer(String maThe) {
        theThanhVien = (TheThanhVien) theThanhVienDAO.findById(maThe, TheThanhVien.class);
        setThe(theThanhVien);
    }
    
    public void setThe(TheThanhVien theThanhVien) {
        if (theThanhVien != null) {
            KhachHang khachHang = theThanhVien.getKhachHang();
            txtMTV.setText(theThanhVien.getMaThe());
            if (!txtTenThanhVien.getText().trim().equals(khachHang.getHoTen())) {
                txtTenThanhVien.setText(khachHang.getHoTen());
            }
            txtHangThe.setText(loaiThe.get(theThanhVien.getLoaiThe().ordinal()));
            diem.setText("Điểm: " + theThanhVien.getDiemTich());
        } else {
            txtMTV.setText("");
            txtHangThe.setText("");
            diem.setText("Điểm");
        }
    }
    
    public void addKM(KhuyenMai khuyenMai) {
        khuyenMais.add(khuyenMai);
        onChangeMutipl();
    }
    
    public void removeKM(KhuyenMai khuyenMai) {
        if (khuyenMais.removeIf(km -> km.equals(khuyenMai))) {
            onChangeMutipl();
        }
        
    }
    
    private void onChange(HoaDon hoaDon) {
        List<ChiTietKhuyenMai> chiTietKhuyenMais = new ArrayList<>();
        for (KhuyenMai khuyenMai : khuyenMais) {
            chiTietKhuyenMais.add(new ChiTietKhuyenMai(hoaDon, khuyenMai));
        }
        hoaDon.setChiTietKhuyenMai(chiTietKhuyenMais);
        hoaDon.tienPhaiThu();
    }
    
    private void onChangeMutipl() {
        double tienPhaiThu = 0;
        for (HoaDon hoaDon : this.hoaDonGhep) {
            onChange(hoaDon);
            tienPhaiThu += hoaDon.getTienPhaiThu();
        }
        thanhTienKMKhac.setText("");
        oldPoint = 0;
        thue.setText(tien_format.format(tienPhaiThu * THUE));
        tongThanhToan.setText(FORMAT_MONEY.format(tienPhaiThu * THUE + tienPhaiThu));
        tienThu.setText(tien_format.format(tienPhaiThu * THUE + tienPhaiThu));
    }
    
    private void autoComplete() {
        theThanhViens = theThanhVienDAO.findAll(TheThanhVien.class);
        for (TheThanhVien theThanhVien : theThanhViens) {
            items.add(theThanhVien.getKhachHang().getHoTen());
        }
        AutoCompleteDecorator.decorate(txtTenThanhVien, items, false);
    }
    
    public double getOldPoint() {
        return oldPoint;
    }
    
    public void setOldPoint(double oldPoint) {
        this.oldPoint = oldPoint;
    }
    
    public int indexIsActive() {
        return this.indexIsActive;
    }
    
    public void setIndexIsActive(int indexIsActive) {
        this.indexIsActive = indexIsActive;
    }
    
    public JPanel getMainPanel() {
        return mJPanel;
    }
    
    public HoaDon getHoaDon() {
        return this.hoaDon;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MKMcontainer;
    private component.MyButton btnAddKM;
    private component.MyButton btnBack;
    private component.MyButton btnDown;
    private component.MyButton btnDownTable;
    private component.MyButton btnInTamTinh;
    private component.MyButton btnLuuTam;
    private component.MyButton btnScanQR;
    private javax.swing.JLabel btnThemThanhVien;
    private component.MyButton btnThuTien;
    private component.MyButton btnUp;
    private component.MyButton btnUpTable;
    private javax.swing.JLabel chuongTrinhKhuyenMai;
    private javax.swing.JPanel ctkmContainer;
    private javax.swing.JPanel ctkmContainer1;
    private javax.swing.JLabel diem;
    private javax.swing.JPanel headerTable;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JLabel iconSearch_KM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel khuyenMai;
    private javax.swing.JPanel leftContainer;
    private javax.swing.JLabel maHoaDon;
    private component.PanelRound maTheContainer;
    private component.PanelRound maTheContainer1;
    private component.PanelRound maTheContainer2;
    private component.PanelRound maTheContainer3;
    private javax.swing.JLabel ngayGioHienTai;
    private component.PanelRound panelRound2;
    private javax.swing.JPanel rightContainer;
    private javax.swing.JPanel table;
    private javax.swing.JScrollPane tableBody;
    private javax.swing.JPanel tableContainer;
    private javax.swing.JLabel thanhTien;
    private javax.swing.JLabel thanhTienKMKhac;
    private javax.swing.JPanel theThanhVienContainer;
    private javax.swing.JPanel theThanhVienContainer1;
    private javax.swing.JLabel theThanhVienLabel;
    private javax.swing.JLabel thue;
    private javax.swing.JLabel tienThu;
    private javax.swing.JLabel tongThanhToan;
    private javax.swing.JTextField txtHangThe;
    private javax.swing.JTextField txtMKM;
    private javax.swing.JPasswordField txtMTV;
    private javax.swing.JTextField txtTenThanhVien;
    private component.PanelRound voucher;
    // End of variables declaration//GEN-END:variables
}
