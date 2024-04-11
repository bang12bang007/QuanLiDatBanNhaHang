/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import LIB.FadeEffect;
import datechooser.EventDateChooser;
import datechooser.SelectedAction;
import datechooser.SelectedDate;
import component.BookingItem;
import component.Food;
import component.OrderItem_forUIDatMon;
import component.ScrollBarCustom;
import component.WrapLayout;
import dao.IBanDAO;
import dao.IChiTietHoaDonDAO;
import dao.IHoaDonDAO;
import dao.IKhachHangDAO;
import dao.IMonDAO;
import dao.IPhieuDatBanDAO;
import dao.imlp.BanDAO;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.KhachHangDAO;
import dao.imlp.MonDAO;
import dao.imlp.PhieuDatBanDAO;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.PhieuDatBan;
import icon.FontAwesome;
import java.awt.Color;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author Laptop
 */
public class GD_DatBan extends javax.swing.JPanel implements UIUpdatable {

    /**
     * Creates new form GD_DatBan
     */
    private int active = -1;
    private JPanel mainJPanel;
    private ArrayList<BookingItem> bookingItems = new ArrayList<>();
    private IPhieuDatBanDAO phieuDatBanDAO = new PhieuDatBanDAO();
    private IBanDAO banDAO = new BanDAO();
    private IChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    private IHoaDonDAO hoaDonDAO = new HoaDonDAO();
    private IKhachHangDAO khachHangDAO = new KhachHangDAO();
    private List<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
    private JFrame jFrameForm;

    public GD_DatBan(JPanel jPanel) {
        this.mainJPanel = jPanel;
        initComponents();
        IconFontSwing.register(FontAwesome.getIconFont());
        btnDatCho.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 20, Color.WHITE));
        btnThayDoi.setIcon(IconFontSwing.buildIcon(FontAwesome.PENCIL, 20, Color.WHITE));
        tableBody.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        tableScroll.setVerticalScrollBar(new ScrollBarCustom());
        tableScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        calender.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 24, new Color(31, 29, 43)));
        btnSearch.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 24, Color.WHITE));
        dateChooser.addEventDateChooser(new EventDateChooser() {
            public void dateSelected(SelectedAction action, SelectedDate date) {
                if (action.getAction() == com.raven.datechooser.SelectedAction.DAY_SELECTED) {
                    filterByDate(date);
                }
            }
        });
        tableBody.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (tableBody.getWidth() != 0 && tableBody.getHeight() != 0) {
//                    loadData();
                    Date date = new Date();
                    filterByDate(new SelectedDate(date.getDate(), date.getMonth() + 1, date.getYear() + 1900));
                    // Loại bỏ lắng nghe sự kiện sau khi đã được kích hoạt một lần
                    tableBody.removeComponentListener(this);
                }
            }
        });

    }

    public void setUI() {
        initComponents();
        IconFontSwing.register(FontAwesome.getIconFont());
        btnDatCho.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 20, Color.WHITE));
        btnThayDoi.setIcon(IconFontSwing.buildIcon(FontAwesome.PENCIL, 20, Color.WHITE));
        tableBody.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        tableScroll.setVerticalScrollBar(new ScrollBarCustom());
        tableScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        calender.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 24, new Color(31, 29, 43)));
        btnSearch.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 24, Color.WHITE));
        dateChooser.addEventDateChooser(new EventDateChooser() {
            public void dateSelected(SelectedAction action, SelectedDate date) {
                if (action.getAction() == com.raven.datechooser.SelectedAction.DAY_SELECTED) {
//                    filterByDate(date.getDay(), date.getMonth(), date.getYear());
                }
            }

        });
        FirstTimeLoadItem();
    }

    private void FirstTimeLoadItem() {
//        GD_DatBan dat_ban = this;
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Thực hiện công việc lâu dài ở đây
                Timer hideTimer = new Timer(1520, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loadData();
                        tableBody.repaint();
                        tableBody.revalidate();
                    }
                });
                hideTimer.setRepeats(false);
                hideTimer.start();

                return null;
            }

            @Override
            protected void done() {
            }
        };
        worker.execute();
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
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date = new component.PanelRound();
        calender = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        state = new component.PanelRound();
        trangThaiCombobox = new component.ComboBoxSuggestion();
        jLabel3 = new javax.swing.JLabel();
        txtTKKH = new component.PanelRound();
        jTextField1 = new javax.swing.JTextField();
        btnSearch = new component.MyButton();
        container = new component.PanelRound();
        table = new component.PanelRound();
        tableScroll = new javax.swing.JScrollPane();
        tableBody = new javax.swing.JPanel();
        tableService = new component.PanelRound();
        btnDatCho = new javax.swing.JLabel();
        btnThayDoi = new javax.swing.JLabel();
        btnHuyCho = new javax.swing.JLabel();
        tableHeader = new javax.swing.JPanel();
        tableHaderLeft = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tableHeaderRight = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yeuCauDatMon = new javax.swing.JLabel();
        yeuCauKhac = new javax.swing.JLabel();
        ban = new javax.swing.JLabel();
        btnDownTable = new component.MyButton();
        btnUpTable = new component.MyButton();

        dateChooser.setDateFormat("dd/MM/yyyy");
        dateChooser.setInheritsPopupMenu(true);
        dateChooser.setTextRefernce(txtNgay);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        wrapper.setBackground(new java.awt.Color(31, 29, 43));

        header.setBackground(new java.awt.Color(31, 29, 43));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lọc theo ngày");

        date.setBackground(new java.awt.Color(255, 255, 255));
        date.setRoundBottomLeft(8);
        date.setRoundBottomRight(8);
        date.setRoundTopLeft(8);
        date.setRoundTopRight(8);

        calender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtNgay.setBorder(null);

        javax.swing.GroupLayout dateLayout = new javax.swing.GroupLayout(date);
        date.setLayout(dateLayout);
        dateLayout.setHorizontalGroup(
            dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calender, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dateLayout.setVerticalGroup(
            dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calender, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(txtNgay)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trạng thái");

        state.setBackground(new java.awt.Color(255, 255, 255));
        state.setRoundBottomLeft(8);
        state.setRoundBottomRight(8);
        state.setRoundTopLeft(8);
        state.setRoundTopRight(8);

        trangThaiCombobox.setBorder(null);
        trangThaiCombobox.setEditable(false);
        trangThaiCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chưa nhận bàn", "Đã nhận bàn" }));
        trangThaiCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangThaiComboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stateLayout = new javax.swing.GroupLayout(state);
        state.setLayout(stateLayout);
        stateLayout.setHorizontalGroup(
            stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trangThaiCombobox, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );
        stateLayout.setVerticalGroup(
            stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trangThaiCombobox, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Khách hàng/SĐT");

        txtTKKH.setBackground(new java.awt.Color(255, 255, 255));
        txtTKKH.setRoundBottomLeft(8);
        txtTKKH.setRoundBottomRight(8);
        txtTKKH.setRoundTopLeft(8);
        txtTKKH.setRoundTopRight(8);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.setBorder(null);

        javax.swing.GroupLayout txtTKKHLayout = new javax.swing.GroupLayout(txtTKKH);
        txtTKKH.setLayout(txtTKKHLayout);
        txtTKKHLayout.setHorizontalGroup(
            txtTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTKKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        );
        txtTKKHLayout.setVerticalGroup(
            txtTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btnSearch.setBorder(null);
        btnSearch.setColor(new java.awt.Color(83, 86, 99));
        btnSearch.setColorClick(new java.awt.Color(234, 124, 105));
        btnSearch.setColorOver(new java.awt.Color(234, 124, 105));
        btnSearch.setRadius(8);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTKKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(state, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTKKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(headerLayout.createSequentialGroup()
                                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(9, 9, 9)))
                                .addContainerGap())))
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        container.setBackground(new java.awt.Color(31, 29, 43));

        table.setBackground(new java.awt.Color(31, 29, 43));
        table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        table.setRoundBottomLeft(8);
        table.setRoundBottomRight(8);
        table.setRoundTopLeft(8);
        table.setRoundTopRight(8);

        tableScroll.setBackground(new java.awt.Color(83, 86, 99));
        tableScroll.setBorder(null);

        tableBody.setBackground(new java.awt.Color(83, 86, 99));
        tableBody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBodyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tableBodyLayout = new javax.swing.GroupLayout(tableBody);
        tableBody.setLayout(tableBodyLayout);
        tableBodyLayout.setHorizontalGroup(
            tableBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        tableBodyLayout.setVerticalGroup(
            tableBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        tableScroll.setViewportView(tableBody);

        tableService.setBackground(new java.awt.Color(83, 86, 99));

        btnDatCho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDatCho.setForeground(new java.awt.Color(255, 255, 255));
        btnDatCho.setText("Đặt chỗ");
        btnDatCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDatChoMouseClicked(evt);
            }
        });

        btnThayDoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThayDoi.setForeground(new java.awt.Color(255, 255, 255));
        btnThayDoi.setText("Thay đổi");
        btnThayDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThayDoiMouseClicked(evt);
            }
        });

        btnHuyCho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHuyCho.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyCho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_close.png"))); // NOI18N
        btnHuyCho.setText("Hủy đặt chỗ");
        btnHuyCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyChoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tableServiceLayout = new javax.swing.GroupLayout(tableService);
        tableService.setLayout(tableServiceLayout);
        tableServiceLayout.setHorizontalGroup(
            tableServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDatCho)
                .addGap(30, 30, 30)
                .addComponent(btnThayDoi)
                .addGap(30, 30, 30)
                .addComponent(btnHuyCho)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tableServiceLayout.setVerticalGroup(
            tableServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tableServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThayDoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatCho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyCho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap())
        );

        tableHeader.setBackground(new java.awt.Color(31, 29, 43));
        tableHeader.setLayout(new java.awt.GridLayout(1, 2));

        tableHaderLeft.setBackground(new java.awt.Color(31, 29, 43));
        tableHaderLeft.setLayout(new java.awt.GridLayout(1, 5));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Xếp bàn");
        jLabel7.setToolTipText("");
        tableHaderLeft.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Đặt món");
        jLabel8.setToolTipText("");
        tableHaderLeft.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Nhận bàn");
        jLabel9.setToolTipText("");
        tableHaderLeft.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("   Giờ đến");
        jLabel10.setToolTipText("");
        tableHaderLeft.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Khách hàng");
        jLabel11.setToolTipText("");
        tableHaderLeft.add(jLabel11);

        tableHeader.add(tableHaderLeft);

        tableHeaderRight.setBackground(new java.awt.Color(31, 29, 43));
        tableHeaderRight.setLayout(new java.awt.GridLayout(1, 4));
        tableHeaderRight.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Số người");
        tableHeaderRight.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Trạng thái");
        tableHeaderRight.add(jLabel14);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Tiền đặt trước");
        tableHeaderRight.add(jLabel15);

        tableHeader.add(tableHeaderRight);

        javax.swing.GroupLayout tableLayout = new javax.swing.GroupLayout(table);
        table.setLayout(tableLayout);
        tableLayout.setHorizontalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(tableService, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tableHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tableLayout.setVerticalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableLayout.createSequentialGroup()
                .addComponent(tableService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        footer.setBackground(new java.awt.Color(31, 29, 43));
        footer.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bàn:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Yêu cầu đặt món:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Yêu cầu khác:");

        yeuCauDatMon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        yeuCauDatMon.setForeground(new java.awt.Color(255, 255, 255));

        yeuCauKhac.setForeground(new java.awt.Color(255, 255, 255));
        yeuCauKhac.setText("    ");

        ban.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ban.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(footerLayout.createSequentialGroup()
                        .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(yeuCauDatMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yeuCauKhac, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yeuCauDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(14, 14, 14)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(yeuCauKhac))
                .addGap(22, 22, 22))
        );

        btnDownTable.setBackground(new java.awt.Color(83, 86, 99));
        btnDownTable.setForeground(new java.awt.Color(255, 255, 255));
        btnDownTable.setColor(new java.awt.Color(83, 86, 99));
        btnDownTable.setColorClick(new java.awt.Color(234, 124, 105));
        btnDownTable.setColorOver(new java.awt.Color(234, 124, 105));
        btnDownTable.setRadius(8);
        btnDownTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownTableActionPerformed(evt);
            }
        });

        btnUpTable.setBackground(new java.awt.Color(83, 86, 99));
        btnUpTable.setForeground(new java.awt.Color(255, 255, 255));
        btnUpTable.setColor(new java.awt.Color(83, 86, 99));
        btnUpTable.setColorClick(new java.awt.Color(234, 124, 105));
        btnUpTable.setColorOver(new java.awt.Color(234, 124, 105));
        btnUpTable.setRadius(8);
        btnUpTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnUpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDownTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDownTable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDownTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDownTableActionPerformed

    private void btnUpTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpTableActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnUpTableActionPerformed

    private void btnDatChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatChoMouseClicked
        // TODO add your handling code here:
        utils.AppUtils.setUI(mainJPanel, () -> new GD_Ban(mainJPanel, "DAT_BAN", null));
    }//GEN-LAST:event_btnDatChoMouseClicked

    private void tableBodyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBodyMouseClicked
        // TODO add your handling code here:
        setBookingActive(-1);
    }//GEN-LAST:event_tableBodyMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        setBookingActive(-1);
    }//GEN-LAST:event_formMouseClicked

    private void btnHuyChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyChoMouseClicked
        // TODO add your handling code here:
        banDAO.updateStateById(bookingItems.get(active).getPhieuDatBan().getBan().getMaBan(), utils.Enum.LoaiTrangThai.BAN_TRONG);
        this.deleteBooking();
    }//GEN-LAST:event_btnHuyChoMouseClicked

    private void btnThayDoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThayDoiMouseClicked
        // TODO add your handling code here:
        if (active >= 0) {
            if (jFrameForm == null || !jFrameForm.isVisible()) {
                jFrameForm = new JFrame();
                jFrameForm.setUndecorated(true);
                jFrameForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
                jFrameForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Form_DatBan form_DatBan = new Form_DatBan(jFrameForm, bookingItems.get(active).getPhieuDatBan().getBan());
                form_DatBan.setMainJpanel(mainJPanel);
                form_DatBan.setData(bookingItems.get(active).getPhieuDatBan());
                form_DatBan.setType("UPDATE");
                jFrameForm.add(form_DatBan);
                jFrameForm.setBackground(new Color(0, 0, 0, 0));
                FadeEffect.fadeInFrame(jFrameForm, 8, 0.1f);
                jFrameForm.setVisible(true);
            } else {
                jFrameForm.toFront();
            }
        }
    }//GEN-LAST:event_btnThayDoiMouseClicked

    private void trangThaiComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangThaiComboboxActionPerformed
        // TODO add your handling code here:
//      FindByState in PhieuDatBan
        System.out.println(trangThaiCombobox.getSelectedIndex());
    }//GEN-LAST:event_trangThaiComboboxActionPerformed

    public void deleteBooking() {
        if (active >= 0) {
            phieuDatBanDAO.delete(bookingItems.get(active).getPhieuDatBan().getMaPhieuDatBan(), PhieuDatBan.class);
            HoaDon hoaDon = null;
            for (HoaDon hd : bookingItems.get(active).getPhieuDatBan().getBan().getHoaDon()) {
                if (hd.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC) || hd.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN)) {
                    hoaDon = hd;
                    break;
                }
            }
            if (hoaDon != null) {
                hoaDonDAO.updateStateById(hoaDon.getMaHoaDon(), utils.Enum.LoaiTrangThaiHoaDon.HUY_BO);
            }
            bookingItems.remove(active);
            tableBody.removeAll();
            if (!bookingItems.isEmpty()) {
                for (int i = 0; i < bookingItems.size(); i++) {
                    bookingItems.get(i).setIndex(i);
                    tableBody.add(bookingItems.get(i));
                }
            }
            setBookingActive(-1);
        }
    }

//    NDK: đã nhận bàn và cập nhập lại trạng thái của phiếu đặt cũng như là chuyển trạng thái bàn, trạng thái hóa đơn
    public void received() {
        if (active >= 0) {
            String id = bookingItems.get(active).getPhieuDatBan().getMaPhieuDatBan();
            HoaDon hoaDon = null;
            for (HoaDon hd : bookingItems.get(active).getPhieuDatBan().getBan().getHoaDon()) {
                if (hd.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC) || hd.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN)) {
                    hoaDon = hd;
                    break;
                }
            }
            if (hoaDon == null) {
//                suawr lai nhan ban
                KhachHang kh = (KhachHang) khachHangDAO.findByPhoneNumber(bookingItems.get(active).getPhieuDatBan().getSdt());
                hoaDon = new HoaDon(utils.AppUtils.NHANVIEN, kh, LocalDate.now());
                hoaDon.setTrangThai(utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN);
                hoaDon.setBan(bookingItems.get(active).getPhieuDatBan().getBan());
                boolean result = hoaDonDAO.insertHoaDon(hoaDon);
            } else {
                hoaDonDAO.updateStateById(hoaDon.getMaHoaDon(), utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN);
            }
            banDAO.updateStateById(bookingItems.get(active).getPhieuDatBan().getBan().getMaBan(), utils.Enum.LoaiTrangThai.BAN_CO_KHACH);
            phieuDatBanDAO.updateStateById(id, 1);
            bookingItems.get(active).setTrangThai("Đã nhận bàn");
            setBookingActive(-1);
        }

    }

    public void setBookingActive(int active) {
        this.active = active;
        for (BookingItem bookingItem : bookingItems) {
            bookingItem.setActive(active);
        }
        tableBody.repaint();
        tableBody.revalidate();
    }

    public List<ChiTietHoaDon> getChiTietHoaDonByBan(Ban ban) {
        HoaDon _hoaDon = null;
        for (HoaDon hoaDon : ban.getHoaDon()) {
            if (hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC) || hoaDon.getTrangThai().equals(utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN)) {
                _hoaDon = hoaDon;
                break;
            }
        }
        List<ChiTietHoaDon> dsChiTietHoaDon = chiTietHoaDonDAO.getListByHoaDon(_hoaDon);
        return dsChiTietHoaDon;
    }

    public void setInfoForActiveItem(PhieuDatBan phieuDatBan) {
        String yeuCauDatMon = "";
        dsChiTietHoaDon = getChiTietHoaDonByBan(phieuDatBan.getBan());
        for (ChiTietHoaDon chiTiet : dsChiTietHoaDon) {
            String isQuote = chiTiet.equals(dsChiTietHoaDon.get(dsChiTietHoaDon.size() - 1)) ? "" : ", ";
            yeuCauDatMon += chiTiet.getMon().getTenMon() + " (" + chiTiet.getSoLuong() + " Suất)" + isQuote;
        }
        ban.setText(phieuDatBan.getBan().getMaBan() + " - Tầng " + phieuDatBan.getBan().getMaTang());
        this.yeuCauDatMon.setText(yeuCauDatMon);
        yeuCauKhac.setText(phieuDatBan.getYeuCauKhac());
    }

    private String[] getContents(PhieuDatBan phieuDatBan) {
        String trangThai = phieuDatBan.getTrangThai() == 0 ? "Chưa nhận bàn" : "Đã nhận bàn";
        return new String[]{phieuDatBan.getNgayGioDat().toString(), phieuDatBan.getHoTen(), phieuDatBan.getSoLuongNguoi() + "", trangThai, phieuDatBan.getTienDatCoc() + ""};
    }

    public JPanel getMainJpanel() {
        return mainJPanel;
    }

    private void loadData() {
        int width = tableBody.getWidth();
        List<PhieuDatBan> dsPhieu = phieuDatBanDAO.findAll(PhieuDatBan.class);
        for (int i = 0; i < dsPhieu.size(); i++) {
            BookingItem bookingItem = new BookingItem(i, getContents(dsPhieu.get(i)), width, this);
            bookingItem.setPhieuDatBan(dsPhieu.get(i));
            bookingItems.add(bookingItem);
            tableBody.add(bookingItem);
        }
    }

    private void filterByDate(SelectedDate date) {
        int width = tableBody.getWidth();
        bookingItems = new ArrayList<>();
        List<PhieuDatBan> dsPhieu = phieuDatBanDAO.filterByDate(new Date(date.getYear(), date.getMonth(), date.getDay()));
        tableBody.removeAll();
        for (int i = 0; i < dsPhieu.size(); i++) {
            BookingItem bookingItem = new BookingItem(i, getContents(dsPhieu.get(i)), width, this);
            bookingItem.setPhieuDatBan(dsPhieu.get(i));
            bookingItems.add(bookingItem);
            tableBody.add(bookingItem);
        }
        tableBody.repaint();
        tableBody.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ban;
    private javax.swing.JLabel btnDatCho;
    private component.MyButton btnDownTable;
    private javax.swing.JLabel btnHuyCho;
    private component.MyButton btnSearch;
    private javax.swing.JLabel btnThayDoi;
    private component.MyButton btnUpTable;
    private javax.swing.JLabel calender;
    private component.PanelRound container;
    private component.PanelRound date;
    private datechooser.DateChooser dateChooser;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private component.PanelRound state;
    private component.PanelRound table;
    private javax.swing.JPanel tableBody;
    private javax.swing.JPanel tableHaderLeft;
    private javax.swing.JPanel tableHeader;
    private javax.swing.JPanel tableHeaderRight;
    private javax.swing.JScrollPane tableScroll;
    private component.PanelRound tableService;
    private component.ComboBoxSuggestion trangThaiCombobox;
    private javax.swing.JTextField txtNgay;
    private component.PanelRound txtTKKH;
    private javax.swing.JPanel wrapper;
    private javax.swing.JLabel yeuCauDatMon;
    private javax.swing.JLabel yeuCauKhac;
    // End of variables declaration//GEN-END:variables

}
