package view.manager.application;

import dao.imlp.MonDAO;
import entity.*;
import java.awt.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import raven.toast.Notifications;
import static utils.AppUtils._NORMAL_;
import utils.Enum.LoaiTrangThaiMon;
import component.SimpleForm;

public class GD_QuanLyMon extends SimpleForm {

    public GD_QuanLyMon() {
        initComponents();

        daoM = new MonDAO();

        jTextFieldMaMon.setEditable(false);

        jComboBox4.addItem("Suất");
        jComboBox4.addItem("Ly");
        jComboBox4.addItem("Chai");
        jComboBox4.addItem("Bao");

        jComboBox2.addItem("Tráng Miệng");
        jComboBox2.addItem("Đồ Uống");
        jComboBox2.addItem("Món Mì");
        jComboBox2.addItem("Món Cơm");
        jComboBox2.addItem("Món Súp");
        jComboBox2.addItem("Món Xào/Nướng");
        jComboBox2.addItem("Khác");

        jComboBox1.addItem("DANG_KINH_DOANH");
        jComboBox1.addItem("NGUNG_KINH_DOANH");
        jComboBox1.addItem("TAM_DUNG_PHUC_VU");

        populateTable();
        autoResizeColumnWidths(jTable1);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tại

        List<Mon> allMon = daoM.findAll(Mon.class);

        for (int i = 0; i < allMon.size(); i++) {
            Mon mon = allMon.get(i);

            // Chuyển trạng thái thành chuỗi để hiển thị trong bảng
            String trangThai;
            switch (mon.getTrangThai()) {
                case DANG_KINH_DOANH:
                    trangThai = "Đang kinh doanh";
                    break;
                case NGUNG_KINH_DOANH:
                    trangThai = "Ngừng kinh doanh";
                    break;
                case TAM_DUNG_PHUC_VU:
                    trangThai = "Tạm dừng phục vụ";
                    break;
                default:
                    trangThai = "Không xác định";
                    break;
            }

            model.addRow(new Object[]{
                i + 1,
                mon.getTenMon(),
                mon.getMaMon(),
                mon.getGiaGoc(),
                mon.getGiaBan(),
                mon.getHinhAnh(),
                mon.getDonVi(),
                mon.getLoaiMon().getTenLoai(),
                trangThai
            });
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void clearData() {
        jTextFieldTenMon.setText("");
        jTextFieldMaMon.setText("");
        jTextFieldGiaGoc.setText("");
        jTextFieldGiaBan.setText("");
        jTextFieldHinhAnh.setText("");
    }

    private void autoResizeColumnWidths(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        panelRound2 = new component.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fromDateJLabel = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        tenMon = new javax.swing.JLabel();
        hinhAnh = new javax.swing.JLabel();
        maMon = new javax.swing.JLabel();
        gia = new javax.swing.JLabel();
        JButtonAdd = new component.MyButton();
        JButtonUpdate = new component.MyButton();
        panelRound4 = new component.PanelRound();
        jTextFieldTenMon = new javax.swing.JTextField();
        panelRound5 = new component.PanelRound();
        jTextFieldGiaGoc = new javax.swing.JTextField();
        panelRound6 = new component.PanelRound();
        jTextFieldMaMon = new javax.swing.JTextField();
        panelRound7 = new component.PanelRound();
        jTextFieldHinhAnh = new javax.swing.JTextField();
        donVi = new javax.swing.JLabel();
        loaiMon = new javax.swing.JLabel();
        trangThai = new javax.swing.JLabel();
        panelRound9 = new component.PanelRound();
        jComboBox1 = new javax.swing.JComboBox<>();
        panelRound1 = new component.PanelRound();
        jComboBox2 = new javax.swing.JComboBox<>();
        panelRound10 = new component.PanelRound();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabelGiaBan = new javax.swing.JLabel();
        panelRound8 = new component.PanelRound();
        jTextFieldGiaBan = new javax.swing.JTextField();

        setBackground(new java.awt.Color(83, 86, 99));

        panelRound2.setBackground(new java.awt.Color(31, 29, 43));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên món", "Mã món", "Giá gốc", "Giá bán", "Hình ảnh", "Đơn vị", "Loại món", "Trạng thái"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        fromDateJLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fromDateJLabel.setForeground(new java.awt.Color(255, 255, 255));
        fromDateJLabel.setText("QUẢN LÝ MÓN");

        panelRound3.setBackground(new java.awt.Color(31, 29, 43));
        panelRound3.setForeground(new java.awt.Color(31, 29, 43));
        panelRound3.setToolTipText("");

        tenMon.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        tenMon.setForeground(new java.awt.Color(255, 255, 255));
        tenMon.setText("Tên món");

        hinhAnh.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        hinhAnh.setForeground(new java.awt.Color(255, 255, 255));
        hinhAnh.setText("Hình ảnh");

        maMon.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        maMon.setForeground(new java.awt.Color(255, 255, 255));
        maMon.setText("Mã món");

        gia.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        gia.setForeground(new java.awt.Color(255, 255, 255));
        gia.setText("Giá gốc");

        JButtonAdd.setBackground(new java.awt.Color(51, 204, 0));
        JButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        JButtonAdd.setText("THÊM MÓN");
        JButtonAdd.setColor(new java.awt.Color(51, 204, 0));
        JButtonAdd.setColorClick(new java.awt.Color(179, 250, 160));
        JButtonAdd.setColorOver(new java.awt.Color(51, 204, 0));
        JButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonAddMouseClicked(evt);
            }
        });
        JButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonAddActionPerformed(evt);
            }
        });

        JButtonUpdate.setBackground(new java.awt.Color(255, 51, 0));
        JButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        JButtonUpdate.setText("SỬA THÔNG TIN");
        JButtonUpdate.setColor(new java.awt.Color(255, 51, 0));
        JButtonUpdate.setColorClick(new java.awt.Color(255, 102, 102));
        JButtonUpdate.setColorOver(new java.awt.Color(255, 51, 0));
        JButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonUpdateMouseClicked(evt);
            }
        });
        JButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonUpdateActionPerformed(evt);
            }
        });

        jTextFieldTenMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldTenMonMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addComponent(jTextFieldTenMon, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldTenMon)
        );

        jTextFieldGiaGoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldGiaGocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                none(evt);
            }
        });
        jTextFieldGiaGoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGiaGocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTextFieldGiaGoc)
                .addGap(0, 0, 0))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldGiaGoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jTextFieldMaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMaMonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTextFieldMaMon)
                .addGap(0, 0, 0))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldMaMon)
        );

        jTextFieldHinhAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHinhAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound7Layout.createSequentialGroup()
                .addComponent(jTextFieldHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldHinhAnh)
        );

        donVi.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        donVi.setForeground(new java.awt.Color(255, 255, 255));
        donVi.setText("Đơn vị");
        donVi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donViMouseClicked(evt);
            }
        });

        loaiMon.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        loaiMon.setForeground(new java.awt.Color(255, 255, 255));
        loaiMon.setText("Loại món");
        loaiMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loaiMonMouseClicked(evt);
            }
        });

        trangThai.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        trangThai.setForeground(new java.awt.Color(255, 255, 255));
        trangThai.setText("Trạng thái");
        trangThai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangThaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 101, Short.MAX_VALUE)
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1)
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jComboBox2, 0, 102, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2)
        );

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox4, 0, 187, Short.MAX_VALUE)
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jComboBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jLabelGiaBan.setForeground(new java.awt.Color(242, 242, 242));
        jLabelGiaBan.setText("Giá Bán");
        jLabelGiaBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelGiaBanMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTextFieldGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldGiaBan, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tenMon, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(donVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loaiMon, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(panelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jLabelGiaBan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addComponent(JButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addGap(1, 1, 1))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tenMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelGiaBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
                    .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(donVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loaiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addComponent(fromDateJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addComponent(fromDateJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        List<Mon> allMon = daoM.findAll(Mon.class);
        // Lấy chỉ số của hàng được chọn
        int rowIndex = jTable1.getSelectedRow();

        // Kiểm tra nếu hàng được chọn hợp lệ
        if (rowIndex >= 0) {
            // Lấy đối tượng Mon từ hàng được chọn
            Mon mon = allMon.get(rowIndex);

            // Hiển thị dữ liệu của đối tượng Mon lên các JTextField tương ứng
            jTextFieldTenMon.setText(mon.getTenMon());
            jTextFieldMaMon.setText(mon.getMaMon());
            jTextFieldGiaGoc.setText(String.valueOf(mon.getGiaGoc()));
            jTextFieldGiaBan.setText(String.valueOf(mon.getGiaBan()));
            jTextFieldHinhAnh.setText(mon.getHinhAnh());
            jComboBox4.setSelectedItem(mon.getDonVi());
            jComboBox2.setSelectedItem(String.valueOf(mon.getLoaiMon().getTenLoai()));
            // Chuyển đổi trạng thái từ LoaiTrangThaiMon sang chuỗi và hiển thị lên JComboBox
            switch (mon.getTrangThai()) {
                case DANG_KINH_DOANH:
                    jComboBox1.setSelectedItem("Đang kinh doanh");
                    break;
                case NGUNG_KINH_DOANH:
                    jComboBox1.setSelectedItem("Ngừng kinh doanh");
                    break;
                case TAM_DUNG_PHUC_VU:
                    jComboBox1.setSelectedItem("Tạm dừng phục vụ");
                    break;
                default:
                    jComboBox1.setSelectedItem("Không xác định");
                    break;
            }

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void trangThaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangThaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangThaiMouseClicked

    private void loaiMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loaiMonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiMonMouseClicked

    private void donViMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donViMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_donViMouseClicked

    private void jTextFieldHinhAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHinhAnhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHinhAnhActionPerformed

    private void jTextFieldMaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMaMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMaMonActionPerformed

    private void jTextFieldGiaGocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGiaGocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGiaGocActionPerformed

    private void none(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void jTextFieldGiaGocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldGiaGocMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGiaGocMouseEntered

    private void JButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JButtonUpdateActionPerformed

    private void JButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonUpdateMouseClicked
        double giaBan;
        double giaGoc;

        try {
            giaBan = Double.parseDouble(jTextFieldGiaBan.getText());
            giaGoc = Double.parseDouble(jTextFieldGiaGoc.getText());
        } catch (NumberFormatException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Giá phải là một số!");
            return; // Thoát khỏi phương thức nếu giá nhập không hợp lệ
        }

        if (giaBan <= 0 || giaGoc <= 0) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Giá phải lớn hơn 0!");
            return; // Thoát khỏi phương thức nếu giá nhập không hợp lệ
        }

        LoaiTrangThaiMon trangThai;
        String trangThaiStr = jComboBox1.getSelectedItem().toString();
        switch (trangThaiStr) {
            case "Đang kinh doanh":
                trangThai = LoaiTrangThaiMon.DANG_KINH_DOANH;
                break;
            case "Ngừng kinh doanh":
                trangThai = LoaiTrangThaiMon.NGUNG_KINH_DOANH;
                break;
            case "Tạm dừng phục vụ":
                trangThai = LoaiTrangThaiMon.TAM_DUNG_PHUC_VU;
                break;
            default:
                trangThai = LoaiTrangThaiMon.DANG_KINH_DOANH; // Default case
                break;
        }

        LoaiMon loaiMon = new LoaiMon();
        String loaiMonStr = jComboBox2.getSelectedItem().toString();
        switch (loaiMonStr) {
            case "Tráng Miệng":
                loaiMon.setMaLoaiMon("ML00");
                loaiMon.setChuThich("\"Món tráng miệng\" là một phần của bữa ăn được thưởng thức sau món chính và trước khi kết thúc bữa ăn. Bao gồm Bánh ngọt,Kem,Trái cây,Pudding,Các loại bánh...");
                loaiMon.setTenLoai("Tráng Miệng");
                break;
            case "Đồ Uống":
                loaiMon.setMaLoaiMon("ML01");
                loaiMon.setChuThich("Là danh sách các loại đồ uống khác nhau có thể được thưởng thức vào bất kỳ thời điểm nào trong ngày. Gồm có : Trà, Cà phê, Nước Ép, Bia,Nước Lọc và Nước Đóng Chai...");
                loaiMon.setTenLoai("Đồ Uống");
                break;
            case "Món Mì":
                loaiMon.setMaLoaiMon("ML02");
                loaiMon.setChuThich("Món mì là một loại món ăn được làm từ mì, một loại thực phẩm có nguồn gốc từ bột mì hoặc các nguồn tinh bột khác, được làm thành dạng sợi, viên hoặc tổ. Gồm Phở,Udon,Linguine...");
                loaiMon.setTenLoai("Món Mì");
                break;
            case "Món Cơm":
                loaiMon.setMaLoaiMon("ML03");
                loaiMon.setChuThich("Món cơm là một loại món ăn chủ yếu được làm từ cơm, một loại thực phẩm cơ bản được chế biến từ hạt gạo. Gồm Cơm Trắng, Cơm Chiên, Cơm Hỗn Hợp...");
                loaiMon.setTenLoai("Món Cơm");
                break;
            case "Món Súp":
                loaiMon.setMaLoaiMon("ML04");
                loaiMon.setChuThich("Món súp là một loại món ăn có dạng lỏng, thường được làm từ nước dùng hoặc nước, kết hợp với các loại thực phẩm như rau củ, thịt, hải sản hoặc đậu. Gồm Súp Gà,Miso, Súp Hành..");
                loaiMon.setTenLoai("Món Súp");
                break;
            case "Món Xào/Nướng":
                loaiMon.setMaLoaiMon("ML05");
                loaiMon.setChuThich("Món ăn nướng và chiên là những món ăn phổ biến trên khắp thế giới, với việc sử dụng nhiệt độ cao để chế biến thức ăn. Bao gồm : Thịt Nướng,Hải Sản,Rau Củ...");
                loaiMon.setTenLoai("Món Xào/Nướng");
                break;
            case "Khác":
                loaiMon.setMaLoaiMon("ML06");
                loaiMon.setChuThich("Các loại món mà nhà hàng không phục vụ");
                loaiMon.setTenLoai("Khác");
                break;
            default:
                loaiMon = null;
        }

        if (loaiMon == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Vui lòng chọn loại món!");
            return; // Thoát khỏi phương thức nếu loại món không hợp lệ
        }

        int rowIndex = jTable1.getSelectedRow();
        if (rowIndex == -1) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Vui lòng chọn một món để cập nhật!");
            return; // Thoát khỏi phương thức nếu không có món nào được chọn
        }

        String maMon = (String) jTable1.getValueAt(rowIndex, 0); // Giả sử cột đầu tiên chứa mã món

        Mon mon = new Mon();
        mon.setMaMon(jTextFieldMaMon.getText());
        mon.setTenMon(jTextFieldTenMon.getText());
        mon.setGiaBan(giaBan);
        mon.setGiaGoc(giaGoc);
        mon.setHinhAnh(jTextFieldHinhAnh.getText()); // Assuming this is the correct field
        mon.setTrangThai(trangThai);
        mon.setDonVi(String.valueOf(jComboBox4.getSelectedItem()));
        mon.setLoaiMon(loaiMon);

        if (daoM.update(mon)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Chỉnh sửa món thành công!");
            sequenceNumber++;
            populateTable();
            clearData();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Chưa chỉnh sửa được món!");
        }
    }//GEN-LAST:event_JButtonUpdateMouseClicked

    private void JButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JButtonAddActionPerformed

    private void JButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAddMouseClicked
        // TODO add your handling code here:
        double giaBan;
        double giaGoc;

        try {
            giaBan = Double.parseDouble(jTextFieldGiaBan.getText());
            giaGoc = Double.parseDouble(jTextFieldGiaGoc.getText());
        } catch (NumberFormatException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Giá phải là một số!");
            return; // Thoát khỏi phương thức nếu giá nhập không hợp lệ
        }

        if (giaBan <= 0 || giaGoc <= 0) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Giá phải lớn hơn 0!");
            return; // Thoát khỏi phương thức nếu giá nhập không hợp lệ
        }

        LoaiTrangThaiMon trangThai;
        String trangThaiStr = jComboBox1.getSelectedItem().toString();
        switch (trangThaiStr) {
            case "Đang kinh doanh":
                trangThai = LoaiTrangThaiMon.DANG_KINH_DOANH;
                break;
            case "Ngừng kinh doanh":
                trangThai = LoaiTrangThaiMon.NGUNG_KINH_DOANH;
                break;
            case "Tạm dừng phục vụ":
                trangThai = LoaiTrangThaiMon.TAM_DUNG_PHUC_VU;
                break;
            default:
                trangThai = LoaiTrangThaiMon.DANG_KINH_DOANH; // Default case
                break;
        }

        LoaiMon loaiMon = new LoaiMon();
        String loaiMonStr = jComboBox2.getSelectedItem().toString();
        switch (loaiMonStr) {
            case "Tráng Miệng":
                loaiMon.setMaLoaiMon("ML00");
                loaiMon.setChuThich("\"Món tráng miệng\" là một phần của bữa ăn được thưởng thức sau món chính và trước khi kết thúc bữa ăn. Bao gồm Bánh ngọt,Kem,Trái cây,Pudding,Các loại bánh...");
                loaiMon.setTenLoai("Tráng Miệng");
                break;
            case "Đồ Uống":
                loaiMon.setMaLoaiMon("ML01");
                loaiMon.setChuThich("Là danh sách các loại đồ uống khác nhau có thể được thưởng thức vào bất kỳ thời điểm nào trong ngày. Gồm có : Trà, Cà phê, Nước Ép, Bia,Nước Lọc và Nước Đóng Chai...");
                loaiMon.setTenLoai("Đồ Uống");
                break;
            case "Món Mì":
                loaiMon.setMaLoaiMon("ML02");
                loaiMon.setChuThich("Món mì là một loại món ăn được làm từ mì, một loại thực phẩm có nguồn gốc từ bột mì hoặc các nguồn tinh bột khác, được làm thành dạng sợi, viên hoặc tổ. Gồm Phở,Udon,Linguine...");
                loaiMon.setTenLoai("Món Mì");
                break;
            case "Món Cơm":
                loaiMon.setMaLoaiMon("ML03");
                loaiMon.setChuThich("Món cơm là một loại món ăn chủ yếu được làm từ cơm, một loại thực phẩm cơ bản được chế biến từ hạt gạo. Gồm Cơm Trắng, Cơm Chiên, Cơm Hỗn Hợp...");
                loaiMon.setTenLoai("Món Cơm");
                break;
            case "Món Súp":
                loaiMon.setMaLoaiMon("ML04");
                loaiMon.setChuThich("Món súp là một loại món ăn có dạng lỏng, thường được làm từ nước dùng hoặc nước, kết hợp với các loại thực phẩm như rau củ, thịt, hải sản hoặc đậu. Gồm Súp Gà,Miso, Súp Hành..");
                loaiMon.setTenLoai("Món Súp");
                break;
            case "Món Xào/Nướng":
                loaiMon.setMaLoaiMon("ML05");
                loaiMon.setChuThich("Món ăn nướng và chiên là những món ăn phổ biến trên khắp thế giới, với việc sử dụng nhiệt độ cao để chế biến thức ăn. Bao gồm : Thịt Nướng,Hải Sản,Rau Củ...");
                loaiMon.setTenLoai("Món Xào/Nướng");
                break;
            case "Khác":
                loaiMon.setMaLoaiMon("ML06");
                loaiMon.setChuThich("Các loại món mà nhà hàng không phục vụ");
                loaiMon.setTenLoai("Khác");
                break;
            default:
                loaiMon = null;
        }

        if (loaiMon == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Vui lòng chọn loại món!");
            return; // Thoát khỏi phương thức nếu loại món không hợp lệ
        }

        Mon mon = new Mon();
        mon.setMaMon(jTextFieldMaMon.getText());
        mon.setTenMon(jTextFieldTenMon.getText());
        mon.setGiaBan(giaBan);
        mon.setGiaGoc(giaGoc);
        mon.setHinhAnh(jTextFieldHinhAnh.getText()); // Assuming this is the correct field
        mon.setTrangThai(trangThai);
        mon.setDonVi(String.valueOf(jComboBox4.getSelectedItem()));
        mon.setLoaiMon(loaiMon);

        if (daoM.insert(mon)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Thêm món thành công!");
            sequenceNumber++;
            populateTable();
            clearData();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Chưa thêm được món!");
        }
    }//GEN-LAST:event_JButtonAddMouseClicked

    private void jTextFieldTenMonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTenMonMouseEntered
        // Lấy ngày giờ hiện tại
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyMMdd");
        String datePart = now.format(dateFormat);

        // Kiểm tra nếu ngày đã thay đổi thì reset sequenceNumber
        if (!datePart.equals(lastGeneratedDate)) {
            sequenceNumber = 0;
            lastGeneratedDate = datePart;
        }

        // Tăng sequenceNumber và đảm bảo nó có 3 chữ số
        String sequencePart = String.format("%03d", sequenceNumber);

        // Tạo mã món
        String itemCode = "MON" + datePart + sequencePart;

        jTextFieldMaMon.setText(itemCode);
    }//GEN-LAST:event_jTextFieldTenMonMouseEntered

    private void jLabelGiaBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGiaBanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelGiaBanMouseEntered

    private MonDAO daoM;
    private static int sequenceNumber = 0; // Biến số tự tăng
    private static String lastGeneratedDate = ""; // Ngày cuối cùng tạo mã dưới dạng chuỗi


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton JButtonAdd;
    private component.MyButton JButtonUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel donVi;
    private javax.swing.JLabel fromDateJLabel;
    private javax.swing.JLabel gia;
    private javax.swing.JLabel hinhAnh;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabelGiaBan;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldGiaBan;
    private javax.swing.JTextField jTextFieldGiaGoc;
    private javax.swing.JTextField jTextFieldHinhAnh;
    private javax.swing.JTextField jTextFieldMaMon;
    private javax.swing.JTextField jTextFieldTenMon;
    private javax.swing.JLabel loaiMon;
    private javax.swing.JLabel maMon;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound10;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private component.PanelRound panelRound5;
    private component.PanelRound panelRound6;
    private component.PanelRound panelRound7;
    private component.PanelRound panelRound8;
    private component.PanelRound panelRound9;
    private javax.swing.JLabel tenMon;
    private javax.swing.JLabel trangThai;
    // End of variables declaration//GEN-END:variables
}
