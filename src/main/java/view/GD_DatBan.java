/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import component.BookingItem;
import component.Loading;
import component.ScrollBarCustom;
import component.WrapLayout;
import dao.IBanDAO;
import dao.IPhieuDatBanDAO;
import dao.imlp.BanDAO;
import dao.imlp.PhieuDatBanDAO;
import entity.PhieuDatBan;
import icon.FontAwesome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

    public GD_DatBan(JPanel jPanel) {
        this.mainJPanel = jPanel;
        utils.AppUtils.run(mainJPanel, this);
    }

    public void setUI() {
        initComponents();
        IconFontSwing.register(FontAwesome.getIconFont());
        btnDatCho.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 20, Color.WHITE));
        btnThayDoi.setIcon(IconFontSwing.buildIcon(FontAwesome.PENCIL, 20, Color.WHITE));
        tableBody.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        tableScroll.setVerticalScrollBar(new ScrollBarCustom());
        tableScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        FirstTimeLoadItem();
    }

    private void FirstTimeLoadItem() {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thêm mã để kích hoạt action listener tại đây
                loadData();
                tableBody.repaint();
                tableBody.revalidate();
            }
        });
        timer.setRepeats(false); // Chỉ chạy một lần sau 5 giây
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

        wrapper = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date = new component.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        state = new component.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        txtTKKH = new component.PanelRound();
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

        date.setBackground(new java.awt.Color(83, 86, 99));
        date.setRoundBottomLeft(8);
        date.setRoundBottomRight(8);
        date.setRoundTopLeft(8);
        date.setRoundTopRight(8);

        javax.swing.GroupLayout dateLayout = new javax.swing.GroupLayout(date);
        date.setLayout(dateLayout);
        dateLayout.setHorizontalGroup(
            dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        dateLayout.setVerticalGroup(
            dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trạng thái");

        state.setBackground(new java.awt.Color(83, 86, 99));
        state.setRoundBottomLeft(8);
        state.setRoundBottomRight(8);
        state.setRoundTopLeft(8);
        state.setRoundTopRight(8);

        javax.swing.GroupLayout stateLayout = new javax.swing.GroupLayout(state);
        state.setLayout(stateLayout);
        stateLayout.setHorizontalGroup(
            stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        stateLayout.setVerticalGroup(
            stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Khách hàng/SĐT");

        txtTKKH.setBackground(new java.awt.Color(83, 86, 99));
        txtTKKH.setRoundBottomLeft(8);
        txtTKKH.setRoundBottomRight(8);
        txtTKKH.setRoundTopLeft(8);
        txtTKKH.setRoundTopRight(8);

        javax.swing.GroupLayout txtTKKHLayout = new javax.swing.GroupLayout(txtTKKH);
        txtTKKH.setLayout(txtTKKHLayout);
        txtTKKHLayout.setHorizontalGroup(
            txtTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        txtTKKHLayout.setVerticalGroup(
            txtTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
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
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(headerLayout.createSequentialGroup()
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(9, 9, 9)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
                .addGap(16, 16, 16)
                .addGroup(tableServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatCho)
                    .addComponent(btnThayDoi)
                    .addComponent(btnHuyCho))
                .addContainerGap(16, Short.MAX_VALUE))
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
            .addComponent(tableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
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
                .addComponent(tableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
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
        yeuCauDatMon.setText("Sushi cá hồi");

        yeuCauKhac.setForeground(new java.awt.Color(255, 255, 255));
        yeuCauKhac.setText("    ");

        ban.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ban.setForeground(new java.awt.Color(255, 255, 255));
        ban.setText("#3 - Tầng 1");

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
                    .addComponent(ban)
                    .addComponent(yeuCauDatMon)
                    .addComponent(yeuCauKhac))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ban))
                .addGap(14, 14, 14)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(yeuCauDatMon))
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yeuCauKhac))
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
        utils.AppUtils.setUI(mainJPanel, new GD_Ban(mainJPanel, "DAT_BAN"));
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

    public void deleteBooking() {
        if (active >= 0) {
            phieuDatBanDAO.delete(bookingItems.get(active).getPhieuDatBan().getMaPhieuDatBan(), PhieuDatBan.class);
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

    public void setBookingActive(int active) {
        this.active = active;
        for (BookingItem bookingItem : bookingItems) {
            bookingItem.setActive(active);
        }
        tableBody.repaint();
        tableBody.revalidate();
    }

    private String[] getContents(PhieuDatBan phieuDatBan) {
        return new String[]{phieuDatBan.getNgayGioDat().toString(), phieuDatBan.getHoTen(), phieuDatBan.getSoLuongNguoi() + "", phieuDatBan.getTrangThai() == 0 ? "Chưa nhận bàn" : "", phieuDatBan.getTienDatCoc() + ""};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ban;
    private javax.swing.JLabel btnDatCho;
    private component.MyButton btnDownTable;
    private javax.swing.JLabel btnHuyCho;
    private component.MyButton btnSearch;
    private javax.swing.JLabel btnThayDoi;
    private component.MyButton btnUpTable;
    private component.PanelRound container;
    private component.PanelRound date;
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
    private component.PanelRound state;
    private component.PanelRound table;
    private javax.swing.JPanel tableBody;
    private javax.swing.JPanel tableHaderLeft;
    private javax.swing.JPanel tableHeader;
    private javax.swing.JPanel tableHeaderRight;
    private javax.swing.JScrollPane tableScroll;
    private component.PanelRound tableService;
    private component.PanelRound txtTKKH;
    private javax.swing.JPanel wrapper;
    private javax.swing.JLabel yeuCauDatMon;
    private javax.swing.JLabel yeuCauKhac;
    // End of variables declaration//GEN-END:variables

}
