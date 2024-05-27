package view.manager.forms;

import dao.imlp.HoaDonDAO;
import dao.imlp.KhachHangDAO;
import dao.imlp.MonDAO;
import dao.imlp.NhanVienDAO;
import entity.*;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import static utils.AppUtils._NORMAL_;
import view.manager.components.SimpleForm;

public class GD_QuanLyHoaDon extends SimpleForm {

    public GD_QuanLyHoaDon() {
        initComponents();
        dao = new HoaDonDAO();

        populateTable();
        autoResizeColumnWidths(jTable1);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tại

        List<HoaDon> hoaDons = dao.findByState(utils.Enum.LoaiTrangThaiHoaDon.DA_THANH_TOAN);

        for (HoaDon h : hoaDons) {
            if(!listNV.contains(h.getNhanVien())){
                listNV.add(h.getNhanVien());
            }
            jComboBox4.addItem(h.getNhanVien().getHoTen());
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
        panelRound2 = new component.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fromDateJLabel = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        tenMon = new javax.swing.JLabel();
        maMon = new javax.swing.JLabel();
        JButtonUpdate = new component.MyButton();
        panelRound4 = new component.PanelRound();
        txtMa = new javax.swing.JTextField();
        donVi = new javax.swing.JLabel();
        loaiMon = new javax.swing.JLabel();
        panelRound1 = new component.PanelRound();
        jComboBox2 = new javax.swing.JComboBox<>();
        panelRound10 = new component.PanelRound();
        jComboBox4 = new javax.swing.JComboBox<>();

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
                "STT", "Mã hóa đơn", "Ngày lập hóa đơn", "Tổng thanh toán", "Tiền phải thu", "mã bàn", "Mã nhân viên", "Số lượng người"
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
        tenMon.setText("Mã hóa đơn");

        maMon.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        maMon.setForeground(new java.awt.Color(255, 255, 255));

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
                .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2)
        );

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox4, 0, 142, Short.MAX_VALUE)
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jComboBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tenMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(donVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loaiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(391, 391, 391)
                .addComponent(JButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tenMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(donVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loaiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
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
                .addComponent(fromDateJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
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
        if (jTable1.getSelectedRow() != -1)
            txtMa.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());
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
        dao.createInvoice(h, h.getTienPhaiThu(), 0);
    }//GEN-LAST:event_JButtonUpdateActionPerformed

    private void JButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonUpdateMouseClicked

    }//GEN-LAST:event_JButtonUpdateMouseClicked

    private void txtMaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaMouseEntered
        // Lấy ngày giờ hiện tại
    }//GEN-LAST:event_txtMaMouseEntered

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
    private javax.swing.JLabel donVi;
    private javax.swing.JLabel fromDateJLabel;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel loaiMon;
    private javax.swing.JLabel maMon;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound10;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private javax.swing.JLabel tenMon;
    private javax.swing.JTextField txtMa;
    // End of variables declaration//GEN-END:variables
}
