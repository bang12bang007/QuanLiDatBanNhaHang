/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import LIB.FadeEffect;
import component.Food;
import component.Loading;
import component.OrderItem_forUIDatMon;
import component.RoundJTextField;
import component.ScrollBarCustom;
import component.WrapLayout;
import dao.IBanDAO;
import dao.IChiTietHoaDonDAO;
import dao.IHoaDonDAO;
import dao.IMonDAO;
import dao.imlp.BanDAO;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.MonDAO;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Mon;
import entity.NhanVien;
import icon.FontAwesome;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import jiconfont.swing.IconFontSwing;
import utils.AppUtils;
import utils.Enum.DatMon_ThemMon;
import utils.Enum.TypeDatMon_Branch;
import utils.ModelColor;

/**
 *
 * @author Laptop
 */
public class GD_DatMon extends javax.swing.JPanel {

    /**
     * Creates new form GD_DatMon
     */
    private JPanel main;
    private List<Mon> mons;
    private List<Mon> beverages;
    private List<Mon> popular;
    private Ban ban;
    private ArrayList<Mon> orders;
    private ArrayList<Integer> list_quantity = new ArrayList<Integer>();
    private NhanVien nv;
    private String type_datMon;
    private DatMon_ThemMon loai;
    private TypeDatMon_Branch branch = TypeDatMon_Branch.KHAC_DATMON;//duccuong1609 : phân loại luồng đi vào (đặt món,sửa món)
    private DecimalFormat tien_format = new DecimalFormat("###,###.0 VNĐ");

    public GD_DatMon(JPanel main, Ban ban, utils.Enum.DatMon_ThemMon loai) {
        this.nv = AppUtils.NHANVIEN;
        this.main = main;
        this.ban = ban;
        this.loai = loai;
        run();
    }

    private void run() {
        GD_DatMon gd_datmon = this;
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loading loading = new Loading();
                utils.AppUtils.setLoading(main, true, loading, gd_datmon);

                initComponents();
                setVisible(true);
                IconFontSwing.register(FontAwesome.getIconFont());
                btnSearch.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 30, Color.WHITE));
                FoodList.setLayout(new WrapLayout(FlowLayout.CENTER, 20, 20));
                scrollFoodList.setVerticalScrollBar(new ScrollBarCustom());
                scrollFoodList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                Scroll_Order.setVerticalScrollBar(new ScrollBarCustom());
                Scroll_Order.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                panelGradient1.addColor(new ModelColor(new Color(31, 29, 43), 0f), new ModelColor(new Color(31, 29, 43, 0), 0.5f), new ModelColor(new Color(31, 29, 43, 0), 1f));
                IconFontSwing.register(FontAwesome.getIconFont());
                btnDD.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_DOUBLE_DOWN, 20, Color.WHITE));
                btnDU.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_DOUBLE_UP, 20, Color.WHITE));
                btnUp.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_DOUBLE_DOWN, 20, Color.WHITE));
                btnHelpCaculator.setIcon(IconFontSwing.buildIcon(FontAwesome.QUESTION, 20, Color.WHITE));
                btnDown.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_DOUBLE_UP, 20, Color.WHITE));
                btnBack.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_LEFT, 20, Color.WHITE));
                btnNV.setIcon(IconFontSwing.buildIcon(FontAwesome.USER, 20, Color.WHITE));
                btnGhiChu.setIcon(IconFontSwing.buildIcon(FontAwesome.BOOK, 20, Color.WHITE));
                btnKhuyenMai.setIcon(IconFontSwing.buildIcon(FontAwesome.GIFT, 20, Color.WHITE));
                btnTime.setIcon(IconFontSwing.buildIcon(FontAwesome.CLOCK_O, 20, Color.WHITE));
                PanelOrder.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 0));
                banTextField.setText(ban.getMaBan());
                banTextField.setEditable(false);
                labelTongTien.setText("0,0 VNĐ");
                nhanVienName.setText(nv.getHoTen());
                First_LoadData();

                Timer hideTimer = new Timer(1500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        utils.AppUtils.setLoading(main, false, loading, gd_datmon);
                    }
                });
                hideTimer.setRepeats(false);
                hideTimer.start();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton5 = new component.MyButton();
        list1 = new java.awt.List();
        panelMon = new component.PanelRound();
        btnHayDung = new component.MyButton();
        btnMonAn = new component.MyButton();
        btnDoUong = new component.MyButton();
        btnKhac = new component.MyButton();
        jTextFieldSearch = new RoundJTextField(10);
        btnSearch = new component.MyButton();
        panelMenuMon = new component.PanelRound();
        panelRound1 = new component.PanelRound();
        btnDD = new component.MyButton();
        btnDU = new component.MyButton();
        scrollFoodList = new javax.swing.JScrollPane();
        FoodList = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelOrder = new component.PanelRound();
        btnBack = new component.MyButton();
        banTextField = new RoundJTextField(10);
        btnNV = new component.MyButton();
        btnGhiChu = new component.MyButton();
        panelRound2 = new component.PanelRound();
        btnThem = new component.MyButton();
        btnKhuyenMai = new component.MyButton();
        btnTime = new component.MyButton();
        btnUp = new component.MyButton();
        btnDown = new component.MyButton();
        panelRound3 = new component.PanelRound();
        btnGuiBep = new component.MyButton();
        btnHuyBo = new component.MyButton();
        btnTinhTien = new component.MyButton();
        btnCat = new component.MyButton();
        jLabel1 = new javax.swing.JLabel();
        labelTongTien = new javax.swing.JLabel();
        panelRound4 = new component.PanelRound();
        panelRound5 = new component.PanelRound();
        panelGradient1 = new component.PanelGradient();
        nhanVienName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnHelpCaculator = new component.MyButton();
        TABLE_ORDER = new component.PanelRound();
        HEADER_ORDER = new component.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Scroll_Order = new javax.swing.JScrollPane();
        PanelOrder = new javax.swing.JPanel();

        myButton5.setText("myButton5");

        setBackground(new java.awt.Color(31, 29, 43));

        panelMon.setBackground(new java.awt.Color(31, 29, 43));

        btnHayDung.setForeground(new java.awt.Color(255, 255, 255));
        btnHayDung.setText("Hay Dùng");
        btnHayDung.setColor(new java.awt.Color(83, 86, 99));
        btnHayDung.setColorClick(new java.awt.Color(234, 124, 105));
        btnHayDung.setColorOver(new java.awt.Color(234, 124, 105));
        btnHayDung.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHayDung.setRadius(10);
        btnHayDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHayDungActionPerformed(evt);
            }
        });

        btnMonAn.setForeground(new java.awt.Color(255, 255, 255));
        btnMonAn.setText("Món Ăn");
        btnMonAn.setColor(new java.awt.Color(83, 86, 99));
        btnMonAn.setColorClick(new java.awt.Color(234, 124, 105));
        btnMonAn.setColorOver(new java.awt.Color(234, 124, 105));
        btnMonAn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMonAn.setRadius(10);
        btnMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonAnActionPerformed(evt);
            }
        });

        btnDoUong.setForeground(new java.awt.Color(255, 255, 255));
        btnDoUong.setText("Đồ Uống");
        btnDoUong.setColor(new java.awt.Color(83, 86, 99));
        btnDoUong.setColorClick(new java.awt.Color(234, 124, 105));
        btnDoUong.setColorOver(new java.awt.Color(234, 124, 105));
        btnDoUong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoUong.setRadius(10);
        btnDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoUongActionPerformed(evt);
            }
        });

        btnKhac.setForeground(new java.awt.Color(255, 255, 255));
        btnKhac.setText("Khác");
        btnKhac.setColor(new java.awt.Color(83, 86, 99));
        btnKhac.setColorClick(new java.awt.Color(234, 124, 105));
        btnKhac.setColorOver(new java.awt.Color(234, 124, 105));
        btnKhac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhac.setRadius(10);

        jTextFieldSearch.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(83, 86, 99));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setColor(new java.awt.Color(83, 86, 99));
        btnSearch.setColorClick(new java.awt.Color(234, 124, 105));
        btnSearch.setColorOver(new java.awt.Color(234, 124, 105));
        btnSearch.setRadius(10);

        javax.swing.GroupLayout panelMonLayout = new javax.swing.GroupLayout(panelMon);
        panelMon.setLayout(panelMonLayout);
        panelMonLayout.setHorizontalGroup(
            panelMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMonLayout.createSequentialGroup()
                        .addComponent(btnHayDung, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(btnMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(btnDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(btnKhac, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addGroup(panelMonLayout.createSequentialGroup()
                        .addComponent(jTextFieldSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        panelMonLayout.setVerticalGroup(
            panelMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHayDung, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelMenuMon.setBackground(new java.awt.Color(31, 29, 43));

        panelRound1.setBackground(new java.awt.Color(83, 86, 99));

        btnDD.setBackground(new java.awt.Color(31, 29, 43));
        btnDD.setForeground(new java.awt.Color(255, 255, 255));
        btnDD.setColor(new java.awt.Color(31, 29, 43));
        btnDD.setColorClick(new java.awt.Color(234, 124, 105));
        btnDD.setColorOver(new java.awt.Color(234, 124, 105));
        btnDD.setRadius(50);
        btnDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDDActionPerformed(evt);
            }
        });

        btnDU.setBackground(new java.awt.Color(31, 29, 43));
        btnDU.setForeground(new java.awt.Color(255, 255, 255));
        btnDU.setColor(new java.awt.Color(31, 29, 43));
        btnDU.setColorClick(new java.awt.Color(234, 124, 105));
        btnDU.setColorOver(new java.awt.Color(234, 124, 105));
        btnDU.setRadius(50);
        btnDU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(321, Short.MAX_VALUE)
                .addComponent(btnDD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnDU, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDD, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(btnDU, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        btnDU.getAccessibleContext().setAccessibleDescription("");

        scrollFoodList.setBackground(new java.awt.Color(83, 86, 99));

        FoodList.setBackground(new java.awt.Color(83, 86, 99));
        FoodList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FoodListMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout FoodListLayout = new javax.swing.GroupLayout(FoodList);
        FoodList.setLayout(FoodListLayout);
        FoodListLayout.setHorizontalGroup(
            FoodListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        FoodListLayout.setVerticalGroup(
            FoodListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1121, Short.MAX_VALUE)
        );

        scrollFoodList.setViewportView(FoodList);

        javax.swing.GroupLayout panelMenuMonLayout = new javax.swing.GroupLayout(panelMenuMon);
        panelMenuMon.setLayout(panelMenuMonLayout);
        panelMenuMonLayout.setHorizontalGroup(
            panelMenuMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuMonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelMenuMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollFoodList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        panelMenuMonLayout.setVerticalGroup(
            panelMenuMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuMonLayout.createSequentialGroup()
                .addComponent(scrollFoodList)
                .addGap(0, 0, 0)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.setBackground(new java.awt.Color(31, 29, 43));

        panelOrder.setBackground(new java.awt.Color(31, 29, 43));

        btnBack.setColor(new java.awt.Color(83, 86, 99));
        btnBack.setColorClick(new java.awt.Color(234, 124, 105));
        btnBack.setColorOver(new java.awt.Color(234, 124, 105));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setRadius(10);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        banTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        banTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        banTextField.setText("101");
        banTextField.setEditable(false);
        banTextField.setPreferredSize(new java.awt.Dimension(150, 22));
        banTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                banTextFieldActionPerformed(evt);
            }
        });

        btnNV.setColor(new java.awt.Color(83, 86, 99));
        btnNV.setColorClick(new java.awt.Color(234, 124, 105));
        btnNV.setColorOver(new java.awt.Color(234, 124, 105));
        btnNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNV.setRadius(10);
        btnNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNVActionPerformed(evt);
            }
        });

        btnGhiChu.setColor(new java.awt.Color(83, 86, 99));
        btnGhiChu.setColorClick(new java.awt.Color(234, 124, 105));
        btnGhiChu.setColorOver(new java.awt.Color(234, 124, 105));
        btnGhiChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGhiChu.setRadius(10);

        javax.swing.GroupLayout panelOrderLayout = new javax.swing.GroupLayout(panelOrder);
        panelOrder.setLayout(panelOrderLayout);
        panelOrderLayout.setHorizontalGroup(
            panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(banTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnNV, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelOrderLayout.setVerticalGroup(
            panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNV, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(banTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGhiChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(31, 29, 43));

        btnThem.setBackground(new java.awt.Color(83, 86, 99));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm Món");
        btnThem.setColor(new java.awt.Color(83, 86, 99));
        btnThem.setColorClick(new java.awt.Color(234, 124, 105));
        btnThem.setColorOver(new java.awt.Color(234, 124, 105));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setRadius(10);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnKhuyenMai.setBackground(new java.awt.Color(83, 86, 99));
        btnKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnKhuyenMai.setColor(new java.awt.Color(83, 86, 99));
        btnKhuyenMai.setColorClick(new java.awt.Color(234, 124, 105));
        btnKhuyenMai.setColorOver(new java.awt.Color(234, 124, 105));
        btnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhuyenMai.setRadius(10);

        btnTime.setBackground(new java.awt.Color(83, 86, 99));
        btnTime.setForeground(new java.awt.Color(255, 255, 255));
        btnTime.setColor(new java.awt.Color(83, 86, 99));
        btnTime.setColorClick(new java.awt.Color(234, 124, 105));
        btnTime.setColorOver(new java.awt.Color(234, 124, 105));
        btnTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTime.setRadius(10);
        btnTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeActionPerformed(evt);
            }
        });

        btnUp.setBackground(new java.awt.Color(83, 86, 99));
        btnUp.setForeground(new java.awt.Color(255, 255, 255));
        btnUp.setColor(new java.awt.Color(83, 86, 99));
        btnUp.setColorClick(new java.awt.Color(234, 124, 105));
        btnUp.setColorOver(new java.awt.Color(234, 124, 105));
        btnUp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUp.setRadius(50);

        btnDown.setBackground(new java.awt.Color(83, 86, 99));
        btnDown.setForeground(new java.awt.Color(255, 255, 255));
        btnDown.setColor(new java.awt.Color(83, 86, 99));
        btnDown.setColorClick(new java.awt.Color(234, 124, 105));
        btnDown.setColorOver(new java.awt.Color(234, 124, 105));
        btnDown.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDown.setRadius(50);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addComponent(btnKhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRound3.setBackground(new java.awt.Color(83, 86, 99));
        panelRound3.setRoundBottomLeft(10);
        panelRound3.setRoundBottomRight(10);
        panelRound3.setRoundTopLeft(10);
        panelRound3.setRoundTopRight(10);

        btnGuiBep.setForeground(new java.awt.Color(255, 255, 255));
        btnGuiBep.setText("GỬI BẾP");
        btnGuiBep.setColor(new java.awt.Color(31, 29, 43));
        btnGuiBep.setColorClick(new java.awt.Color(234, 124, 105));
        btnGuiBep.setColorOver(new java.awt.Color(234, 124, 105));
        btnGuiBep.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuiBep.setRadius(20);
        btnGuiBep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiBepActionPerformed(evt);
            }
        });

        btnHuyBo.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyBo.setText("HỦY BỎ");
        btnHuyBo.setColor(new java.awt.Color(31, 29, 43));
        btnHuyBo.setColorClick(new java.awt.Color(234, 124, 105));
        btnHuyBo.setColorOver(new java.awt.Color(234, 124, 105));
        btnHuyBo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuyBo.setRadius(20);
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        btnTinhTien.setForeground(new java.awt.Color(255, 255, 255));
        btnTinhTien.setText("TÍNH TIỀN");
        btnTinhTien.setColor(new java.awt.Color(31, 29, 43));
        btnTinhTien.setColorClick(new java.awt.Color(234, 124, 105));
        btnTinhTien.setColorOver(new java.awt.Color(234, 124, 105));
        btnTinhTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTinhTien.setRadius(20);

        btnCat.setForeground(new java.awt.Color(255, 255, 255));
        btnCat.setText("CẤT VÀ THÊM");
        btnCat.setColor(new java.awt.Color(31, 29, 43));
        btnCat.setColorClick(new java.awt.Color(234, 124, 105));
        btnCat.setColorOver(new java.awt.Color(234, 124, 105));
        btnCat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCat.setRadius(20);
        btnCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TỔNG TIỀN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelTongTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTongTien.setForeground(new java.awt.Color(255, 255, 255));
        labelTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTongTien.setText("5000000 VND");

        panelRound4.setBackground(new java.awt.Color(83, 86, 99));

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        panelRound5.setBackground(new java.awt.Color(83, 86, 99));
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setBackground(new java.awt.Color(83, 86, 99));
        panelGradient1.setBorder(null);

        nhanVienName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nhanVienName.setForeground(new java.awt.Color(255, 255, 255));
        nhanVienName.setText("NGUYỄN ĐỨC CƯỜNG");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nhân Viên Phục Vụ");

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nhanVienName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhanVienName)
                .addGap(23, 23, 23))
        );

        panelRound5.add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 90));

        btnHelpCaculator.setBackground(new java.awt.Color(31, 29, 43));
        btnHelpCaculator.setForeground(new java.awt.Color(255, 255, 255));
        btnHelpCaculator.setColor(new java.awt.Color(31, 29, 43));
        btnHelpCaculator.setColorClick(new java.awt.Color(234, 124, 105));
        btnHelpCaculator.setColorOver(new java.awt.Color(234, 124, 105));
        btnHelpCaculator.setRadius(55);
        btnHelpCaculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpCaculatorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(btnGuiBep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(btnHuyBo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnTinhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(btnCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(btnHelpCaculator, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHelpCaculator, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTongTien)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCat, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGuiBep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        TABLE_ORDER.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(255, 255, 255), null, new java.awt.Color(255, 255, 255)));
        TABLE_ORDER.setRoundBottomLeft(10);
        TABLE_ORDER.setRoundBottomRight(10);
        TABLE_ORDER.setRoundTopLeft(10);
        TABLE_ORDER.setRoundTopRight(10);

        HEADER_ORDER.setBackground(new java.awt.Color(83, 86, 99));
        HEADER_ORDER.setRoundTopLeft(10);
        HEADER_ORDER.setRoundTopRight(10);
        HEADER_ORDER.setLayout(new java.awt.GridLayout(1, 4));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("  TÊN MÓN");
        HEADER_ORDER.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" SL");
        HEADER_ORDER.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("THÀNH TIỀN");
        HEADER_ORDER.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("HỦY");
        HEADER_ORDER.add(jLabel7);

        Scroll_Order.setBorder(null);

        PanelOrder.setBackground(new java.awt.Color(83, 86, 99));

        javax.swing.GroupLayout PanelOrderLayout = new javax.swing.GroupLayout(PanelOrder);
        PanelOrder.setLayout(PanelOrderLayout);
        PanelOrderLayout.setHorizontalGroup(
            PanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        PanelOrderLayout.setVerticalGroup(
            PanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
        );

        Scroll_Order.setViewportView(PanelOrder);

        javax.swing.GroupLayout TABLE_ORDERLayout = new javax.swing.GroupLayout(TABLE_ORDER);
        TABLE_ORDER.setLayout(TABLE_ORDERLayout);
        TABLE_ORDERLayout.setHorizontalGroup(
            TABLE_ORDERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HEADER_ORDER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Scroll_Order, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        TABLE_ORDERLayout.setVerticalGroup(
            TABLE_ORDERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABLE_ORDERLayout.createSequentialGroup()
                .addComponent(HEADER_ORDER, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Scroll_Order, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TABLE_ORDER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TABLE_ORDER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenuMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelMenuMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoUongActionPerformed
        // TODO add your handling code here:
        FoodList.removeAll();
        beverages = new ArrayList<Mon>();
        for (Mon mon : mons) {
            if (mon.getLoaiMon().getMaLoaiMon().equals("ML01")) {
                beverages.add(mon);
            }
        }
        for (Mon mon : beverages) {
            FoodList.add(new Food(this, mon, PanelOrder, mons, orders));
        }
        FoodList.revalidate();
    }//GEN-LAST:event_btnDoUongActionPerformed

    private void btnHayDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHayDungActionPerformed
        // TODO add your handling code here:
        GD_DatMon datmon = this;
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loading loading = new Loading();
                utils.AppUtils.setLoadingForTable(scrollFoodList, true, loading, FoodList);

                popular = new ArrayList<Mon>();
                IMonDAO dao = new MonDAO();
                popular = dao.findPopular();
                FoodList.removeAll();
                for (Mon mon : popular) {
                    FoodList.add(new Food(datmon, mon, PanelOrder, mons, orders));
                }
                FoodList.revalidate();

                Timer hideTimer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        utils.AppUtils.setLoadingForTable(scrollFoodList, false, loading, FoodList);
                    }
                });
                hideTimer.setRepeats(false);
                hideTimer.start();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_btnHayDungActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if(branch==TypeDatMon_Branch.DATMON)
            AppUtils.setUI(main, new GD_Ban(main, "DAT_MON",null));
        else
            AppUtils.setUI(main, new GD_QuanLyDatMon(main, AppUtils.NHANVIEN));
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNVActionPerformed

    private void banTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_banTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_banTextFieldActionPerformed

    private void btnDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDDActionPerformed

    private void btnDUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDUActionPerformed

    private void btnTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimeActionPerformed

    private void btnCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatActionPerformed
        // TODO add your handling code here:
        AppUtils.setUI(main, new GD_QuanLyDatMon(main, nv));
    }//GEN-LAST:event_btnCatActionPerformed

    int index = 1;
    private void btnMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonAnActionPerformed
        // TODO add your handling code here:
        FoodList.removeAll();
        ArrayList<Mon> food = new ArrayList<Mon>();
        food.addAll(mons);
        if (beverages != null) {
            food.removeAll(beverages);
        } else {
            beverages = new ArrayList<Mon>();
            for (Mon mon : mons) {
                if (mon.getLoaiMon().getMaLoaiMon().equals("ML01")) {
                    beverages.add(mon);
                }
            }
            food.removeAll(beverages);
        }
        for (Mon mon : food) {
            FoodList.add(new Food(this, mon, PanelOrder, mons, orders));
        };
        FoodList.revalidate();
    }//GEN-LAST:event_btnMonAnActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnHelpCaculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpCaculatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHelpCaculatorActionPerformed

    private void FoodListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FoodListMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_FoodListMouseEntered

    private void btnGuiBepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiBepActionPerformed
        // TODO add your handling code here:
        Create_OrUpdate_Order();
    }//GEN-LAST:event_btnGuiBepActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        JFrame jFrame = new JFrame();
        jFrame.setUndecorated(true);
        jFrame.setExtendedState(MAXIMIZED_BOTH);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Form_ThemMonKhac form = new Form_ThemMonKhac(jFrame);
        jFrame.add(form,BorderLayout.CENTER);
        jFrame.setBackground(new Color(0, 0, 0, 0));
        FadeEffect.fadeInFrame(jFrame, 8, 0.1f);
        jFrame.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:
        GD_DatMon datMon = this;
        String input = jTextFieldSearch.getText().trim();
        FoodList.removeAll();
        for(Mon mon:mons){
            if(AppUtils.CheckContainsAbbreviation(mon.getTenMon(), input)){
                System.out.println(mon.getTenMon());
                FoodList.add(new Food(datMon,mon,PanelOrder,mons,orders));
            }
        }
        FoodList.repaint();
        FoodList.revalidate();
    }//GEN-LAST:event_jTextFieldSearchKeyReleased
    public void First_LoadData() {
        GD_DatMon gd_mon = this;
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Thực hiện công việc lâu dài ở đây
                if(branch.equals(TypeDatMon_Branch.DATMON)){
                    orders = new ArrayList<Mon>();
                }
                mons = new ArrayList<Mon>();
                IMonDAO dao = new MonDAO();
                mons = dao.findService();
                for (Mon mon : mons) {
                    FoodList.add(new Food(gd_mon, mon, PanelOrder, mons, orders));
                }
                if(branch.equals(TypeDatMon_Branch.DAT_TRUOC_MON)){
                    System.out.println(list_quantity);
                    for(int i=0;i<orders.size();i++){
                            String[] title = new String[]{orders.get(i).getTenMon(), "1", tien_format.format(orders.get(i).getGia()*gd_mon.getList_quantity().get(i)), ""};
                            gd_mon.getPanelOrder().add(new OrderItem_forUIDatMon(gd_mon, orders.get(i), gd_mon.getPanelOrder().getWidth(), i+1, title, orders));
                        }
                }
                return null;
            }
            @Override
            protected void done() {
            }
        };
        worker.execute();
    }

    public void Create_OrUpdate_Order() {
        IHoaDonDAO hoaDonDAO = new HoaDonDAO();
        IBanDAO banDAO = new BanDAO();
        IChiTietHoaDonDAO chitietDAO = new ChiTietHoaDonDAO();
        Ban ban = (Ban) banDAO.findById(this.ban.getMaBan(), Ban.class);
        HoaDon hoaDon = new HoaDon(nv, LocalDate.now(), ban, utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN);
        if (loai.equals(DatMon_ThemMon.DATMON)) {
            hoaDonDAO.insertHoaDon(hoaDon);
            for (int i = 0; i < orders.size(); i++) {
                ChiTietHoaDon chiTiet = new ChiTietHoaDon(orders.get(i), hoaDon, list_quantity.get(i));
                chitietDAO.insert(chiTiet);
            }
        }
        AppUtils.setUI(main, new GD_QuanLyDatMon(main, nv));
    }

    public void setOrders(ArrayList<Mon> orders) {
        this.orders = orders;
    }

    public void setLabelTongTien(String text) {
        this.labelTongTien.setText(text);
    }

    public JPanel getPanelOrder() {
        return PanelOrder;
    }

    public void setList_quantity(ArrayList<Integer> list_quantity) {
        this.list_quantity = new ArrayList<Integer>();
        this.list_quantity = list_quantity;
    }

    public ArrayList<Integer> getList_quantity() {
        return list_quantity;
    }

    public NhanVien getNv() {
        return nv;
    }

    public TypeDatMon_Branch getBranch() {
        return branch;
    }

    public void setBranch(TypeDatMon_Branch branch) {
        this.branch = branch;
    }

    public JPanel getFoodList() {
        return FoodList;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FoodList;
    private component.PanelRound HEADER_ORDER;
    private javax.swing.JPanel PanelOrder;
    private javax.swing.JScrollPane Scroll_Order;
    private component.PanelRound TABLE_ORDER;
    private javax.swing.JTextField banTextField;
    private component.MyButton btnBack;
    private component.MyButton btnCat;
    private component.MyButton btnDD;
    private component.MyButton btnDU;
    private component.MyButton btnDoUong;
    private component.MyButton btnDown;
    private component.MyButton btnGhiChu;
    private component.MyButton btnGuiBep;
    private component.MyButton btnHayDung;
    private component.MyButton btnHelpCaculator;
    private component.MyButton btnHuyBo;
    private component.MyButton btnKhac;
    private component.MyButton btnKhuyenMai;
    private component.MyButton btnMonAn;
    private component.MyButton btnNV;
    private component.MyButton btnSearch;
    private component.MyButton btnThem;
    private component.MyButton btnTime;
    private component.MyButton btnTinhTien;
    private component.MyButton btnUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JLabel labelTongTien;
    private java.awt.List list1;
    private component.MyButton myButton5;
    private javax.swing.JLabel nhanVienName;
    private component.PanelGradient panelGradient1;
    private component.PanelRound panelMenuMon;
    private component.PanelRound panelMon;
    private component.PanelRound panelOrder;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private component.PanelRound panelRound5;
    private javax.swing.JScrollPane scrollFoodList;
    // End of variables declaration//GEN-END:variables
}
