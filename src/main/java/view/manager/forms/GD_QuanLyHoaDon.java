package view.manager.forms;

import component.SimpleForm;
import dao.imlp.HoaDonDAO;
import dao.imlp.KhachHangDAO;
import dao.imlp.MonDAO;
import dao.imlp.NhanVienDAO;
import datechooser.SelectedDate;
import entity.*;
import icon.FontAwesome;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import jiconfont.swing.IconFontSwing;
import raven.toast.Notifications;
import static utils.AppUtils._NORMAL_;

public class GD_QuanLyHoaDon extends SimpleForm {

    public GD_QuanLyHoaDon() {
        initComponents();
        dao = new HoaDonDAO();
        calender3.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 24, new Color(31, 29, 43)));
        calender4.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 24, new Color(31, 29, 43)));
        populateTable();
        autoResizeColumnWidths(jTable1);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tại

        List<HoaDon> hoaDons = dao.findByState(utils.Enum.LoaiTrangThaiHoaDon.DA_THANH_TOAN);

        for (HoaDon h : hoaDons) {
            if (!listNV.contains(h.getNhanVien())) {
                listNV.add(h.getNhanVien());
                jComboBox4.addItem(h.getNhanVien().getHoTen());
            }
            if (h.getKhachHang() != null) {
                if (!listKH.contains(h.getKhachHang())) {
                    listKH.add(h.getKhachHang());
                    jComboBox2.addItem(h.getKhachHang().getHoTen());
                }
            }
        }

        for (int i = 0; i < hoaDons.size(); i++) {
            HoaDon h = hoaDons.get(i);

            model.addRow(new Object[]{
                i + 1,
                h.getMaHoaDon(),
                h.getNgayLapHoaDon(),
                h.getTongThanhToan(),
                h.getTienPhaiThu(),
                h.getBan().getMaBan(),
                h.getNhanVien().getMaNV(),
                h.getSoLuongNguoi()
            });
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void populateTableByTenNhanVien() {
        String ten = jComboBox4.getSelectedItem().toString();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tạ

        List<HoaDon> hoaDons = dao.findByState(utils.Enum.LoaiTrangThaiHoaDon.DA_THANH_TOAN);

        List<HoaDon> hoaDonList = new ArrayList<HoaDon>();

        for (HoaDon h : hoaDons) {
            if (ten.equals(h.getNhanVien().getHoTen())) {
                hoaDonList.add(h);
            }
        }
        if (hoaDonList.size() == 0) {
            return;
        }
        for (int i = 0; i < hoaDonList.size(); i++) {
            HoaDon h = hoaDonList.get(i);

            model.addRow(new Object[]{
                i + 1,
                h.getMaHoaDon(),
                h.getNgayLapHoaDon(),
                h.getTongThanhToan(),
                h.getTienPhaiThu(),
                h.getBan().getMaBan(),
                h.getNhanVien().getMaNV(),
                h.getSoLuongNguoi()
            });
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void populateTableByTenKhachHang() {
        String ten = jComboBox2.getSelectedItem().toString();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tạ

        List<HoaDon> hoaDons = dao.findByState(utils.Enum.LoaiTrangThaiHoaDon.DA_THANH_TOAN);

        List<HoaDon> hoaDonList = new ArrayList<HoaDon>();

        for (HoaDon h : hoaDons) {
            if (ten.equals(h.getKhachHang().getHoTen())) {
                hoaDonList.add(h);
            }
        }
        if (hoaDonList.size() == 0) {
            return;
        }
        for (int i = 0; i < hoaDonList.size(); i++) {
            HoaDon h = hoaDonList.get(i);

            model.addRow(new Object[]{
                i + 1,
                h.getMaHoaDon(),
                h.getNgayLapHoaDon(),
                h.getTongThanhToan(),
                h.getTienPhaiThu(),
                h.getBan().getMaBan(),
                h.getNhanVien().getMaNV(),
                h.getSoLuongNguoi()
            });
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void populateTableByFromDateToDate() {
        SelectedDate dateSelect1 = dateChooser1.getSelectedDate();
        LocalDateTime ngayBatDau = LocalDateTime.of(dateSelect1.getYear(), dateSelect1.getMonth(), dateSelect1.getDay(), 0, 0);
        SelectedDate dateSelect2 = dateChooser2.getSelectedDate();
        LocalDateTime ngayKetThuc = LocalDateTime.of(dateSelect2.getYear(), dateSelect2.getMonth(), dateSelect2.getDay(), 0, 0);

        if (ngayBatDau.isAfter(ngayKetThuc)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Ngày bắt đầu phải bằng hoặc trước ngày kết thúc !");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tạ

        List<HoaDon> hoaDons = dao.findFromDateToDate(ngayBatDau, ngayKetThuc);

        for (int i = 0; i < hoaDons.size(); i++) {
            HoaDon h = hoaDons.get(i);

            model.addRow(new Object[]{
                i + 1,
                h.getMaHoaDon(),
                h.getNgayLapHoaDon(),
                h.getTongThanhToan(),
                h.getTienPhaiThu(),
                h.getBan().getMaBan(),
                h.getNhanVien().getMaNV(),
                h.getSoLuongNguoi()
            });
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void clearData() {
        txtMa.setText("");
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
        dateChooser1 = new datechooser.DateChooser();
        dateChooser2 = new datechooser.DateChooser();
        panelRound2 = new component.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fromDateJLabel = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        tenMon = new javax.swing.JLabel();
        JButtonUpdate = new component.MyButton();
        panelRound4 = new component.PanelRound();
        txtMa = new javax.swing.JTextField();
        donVi = new javax.swing.JLabel();
        loaiMon = new javax.swing.JLabel();
        panelRound1 = new component.PanelRound();
        jComboBox2 = new javax.swing.JComboBox<>();
        panelRound10 = new component.PanelRound();
        jComboBox4 = new javax.swing.JComboBox<>();
        myButton1 = new component.MyButton();
        myButton2 = new component.MyButton();
        date3 = new component.PanelRound();
        calender3 = new javax.swing.JLabel();
        txtNgay3 = new javax.swing.JTextField();
        date4 = new component.PanelRound();
        calender4 = new javax.swing.JLabel();
        txtNgay4 = new javax.swing.JTextField();
        tenMon1 = new javax.swing.JLabel();
        tenMon2 = new javax.swing.JLabel();
        myButton3 = new component.MyButton();

        dateChooser1.setTextRefernce(txtNgay3);

        dateChooser2.setTextRefernce(txtNgay4);

        setBackground(new java.awt.Color(83, 86, 99));

        panelRound2.setBackground(new java.awt.Color(31, 29, 43));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày lập hóa đơn", "Tổng thanh toán", "Tiền phải thu", "Mã bàn", "Mã nhân viên", "Số lượng người"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        fromDateJLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fromDateJLabel.setForeground(new java.awt.Color(255, 255, 255));
        fromDateJLabel.setText("TRA CỨU HÓA ĐƠN");

        panelRound3.setBackground(new java.awt.Color(31, 29, 43));
        panelRound3.setForeground(new java.awt.Color(31, 29, 43));
        panelRound3.setToolTipText("");

        tenMon.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        tenMon.setForeground(new java.awt.Color(255, 255, 255));
        tenMon.setText("Từ ngày ");

        JButtonUpdate.setBackground(new java.awt.Color(234, 124, 105));
        JButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        JButtonUpdate.setText("XEM LẠI HÓA ĐƠN");
        JButtonUpdate.setColor(new java.awt.Color(234, 124, 105));
        JButtonUpdate.setColorClick(new java.awt.Color(234, 124, 5));
        JButtonUpdate.setColorOver(new java.awt.Color(234, 124, 5));
        JButtonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JButtonUpdate.setRadius(10);
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

        txtMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtMaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addComponent(txtMa)
                .addGap(0, 0, 0))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMa)
        );

        donVi.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        donVi.setForeground(new java.awt.Color(255, 255, 255));
        donVi.setText("Nhân Viên");
        donVi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donViMouseClicked(evt);
            }
        });

        loaiMon.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        loaiMon.setForeground(new java.awt.Color(255, 255, 255));
        loaiMon.setText("Khách Hàng");
        loaiMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loaiMonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2)
        );

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox4, 0, 117, Short.MAX_VALUE)
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jComboBox4)
                .addGap(0, 0, 0))
        );

        myButton1.setBackground(new java.awt.Color(51, 51, 51));
        myButton1.setText("Tìm theo tên nhân viên");
        myButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton1MouseClicked(evt);
            }
        });
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton2.setBackground(new java.awt.Color(51, 51, 51));
        myButton2.setText("Tìm theo tên khách hàng");
        myButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton2MouseClicked(evt);
            }
        });

        date3.setBackground(new java.awt.Color(51, 51, 51));
        date3.setRoundBottomLeft(8);
        date3.setRoundBottomRight(8);
        date3.setRoundTopLeft(8);
        date3.setRoundTopRight(8);

        calender3.setBackground(new java.awt.Color(51, 51, 51));
        calender3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calender3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calender3MouseClicked(evt);
            }
        });

        txtNgay3.setEditable(false);
        txtNgay3.setBackground(new java.awt.Color(51, 51, 51));
        txtNgay3.setBorder(null);

        javax.swing.GroupLayout date3Layout = new javax.swing.GroupLayout(date3);
        date3.setLayout(date3Layout);
        date3Layout.setHorizontalGroup(
            date3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, date3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNgay3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calender3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        date3Layout.setVerticalGroup(
            date3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calender3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNgay3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        date4.setBackground(new java.awt.Color(51, 51, 51));
        date4.setRoundBottomLeft(8);
        date4.setRoundBottomRight(8);
        date4.setRoundTopLeft(8);
        date4.setRoundTopRight(8);

        calender4.setBackground(new java.awt.Color(51, 51, 51));
        calender4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calender4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calender4MouseClicked(evt);
            }
        });

        txtNgay4.setEditable(false);
        txtNgay4.setBackground(new java.awt.Color(51, 51, 51));
        txtNgay4.setBorder(null);

        javax.swing.GroupLayout date4Layout = new javax.swing.GroupLayout(date4);
        date4.setLayout(date4Layout);
        date4Layout.setHorizontalGroup(
            date4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, date4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNgay4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calender4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        date4Layout.setVerticalGroup(
            date4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calender4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNgay4)
        );

        tenMon1.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        tenMon1.setForeground(new java.awt.Color(255, 255, 255));
        tenMon1.setText("Mã hóa đơn");

        tenMon2.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        tenMon2.setForeground(new java.awt.Color(255, 255, 255));
        tenMon2.setText("Đến ngày ");

        myButton3.setBackground(new java.awt.Color(51, 51, 51));
        myButton3.setText("Tìm theo ngày");
        myButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(donVi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenMon1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loaiMon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(myButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addComponent(tenMon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelRound4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRound3Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(date4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tenMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(JButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(donVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loaiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(myButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(fromDateJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
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

    }//GEN-LAST:event_jTable1MouseClicked

    private void loaiMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loaiMonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiMonMouseClicked

    private void donViMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donViMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_donViMouseClicked

    private void JButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonUpdateActionPerformed
        // TODO add your handling code here:
        HoaDon h = dao.findById(txtMa.getText(), HoaDon.class);
        dao.createInvoice(h, h.getTienPhaiThu(), 0, h.getBan().getMaBan());
    }//GEN-LAST:event_JButtonUpdateActionPerformed

    private void JButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonUpdateMouseClicked

    }//GEN-LAST:event_JButtonUpdateMouseClicked

    private void txtMaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaMouseEntered
        // Lấy ngày giờ hiện tại
    }//GEN-LAST:event_txtMaMouseEntered

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseClicked
        // TODO add your handling code here:
        populateTableByTenNhanVien();

    }//GEN-LAST:event_myButton1MouseClicked

    private void myButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton2MouseClicked
        // TODO add your handling code here:
        populateTableByTenKhachHang();
    }//GEN-LAST:event_myButton2MouseClicked

    private void calender3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calender3MouseClicked
        // TODO add your handling code here:
        dateChooser1.showPopup();
    }//GEN-LAST:event_calender3MouseClicked

    private void calender4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calender4MouseClicked
        // TODO add your handling code here:
        dateChooser2.showPopup();
    }//GEN-LAST:event_calender4MouseClicked

    private void myButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton3MouseClicked
        // TODO add your handling code here:
        populateTableByFromDateToDate();

    }//GEN-LAST:event_myButton3MouseClicked

    private MonDAO daoM;
    private HoaDonDAO dao;
    private NhanVienDAO nvDAO;
    private KhachHangDAO khDAO;
    private List<NhanVien> listNV = new ArrayList<>();
    private List<KhachHang> listKH = new ArrayList<>();
    private static int sequenceNumber = 0; // Biến số tự tăng
    private static String lastGeneratedDate = ""; // Ngày cuối cùng tạo mã dưới dạng chuỗi


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton JButtonUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel calender3;
    private javax.swing.JLabel calender4;
    private component.PanelRound date3;
    private component.PanelRound date4;
    private datechooser.DateChooser dateChooser1;
    private datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel donVi;
    private javax.swing.JLabel fromDateJLabel;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel loaiMon;
    private component.MyButton myButton1;
    private component.MyButton myButton2;
    private component.MyButton myButton3;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound10;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private javax.swing.JLabel tenMon;
    private javax.swing.JLabel tenMon1;
    private javax.swing.JLabel tenMon2;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgay3;
    private javax.swing.JTextField txtNgay4;
    // End of variables declaration//GEN-END:variables
}
