package view.manager.forms;

import dao.imlp.KhuyenMaiDAO;
import entity.KhuyenMai;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import raven.toast.Notifications;
import static utils.AppUtils._NORMAL_;
import utils.Enum.LoaiKhuyenMai;
import view.manager.components.SimpleForm;

public class GD_QuanLyKhuyenMai extends SimpleForm {

    public GD_QuanLyKhuyenMai() {
        initComponents();

        daoKM = new KhuyenMaiDAO();
        jComboBox3.addItem(utils.Enum.LoaiKhuyenMai.SU_KIEN_DAC_BIET.toString());
        jComboBox3.addItem(utils.Enum.LoaiKhuyenMai.VOUCHER.toString());

        jTextFieldMaKM.setEditable(false);
        populateTable();
    }

    private void populateTable() {
        // Xóa tất cả các dòng hiện có trong bảng
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        List<KhuyenMai> allKhuyenMais = daoKM.findAll(KhuyenMai.class);

        // Thêm dữ liệu từ danh sách vào bảng
        for (int i = 0; i < allKhuyenMais.size(); i++) {
            KhuyenMai km = allKhuyenMais.get(i);
            model.addRow(new Object[]{i + 1, km.getMaKhuyenMai(), km.getTenKhuyenMai(), km.getLoaiKhuyenMai().toString(), km.getNgayBatDau().toLocalDate().toString(), km.getNgayKetThuc().toLocalDate().toString(), km.getChietKhau(), km.getMenhGia(), km.getGhiChu()});
        }

        // Tạo renderer tùy chỉnh để căn giữa văn bản
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Gán renderer này cho tất cả các cột
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void clearData() {
        jTextFieldTenKM.setText("");
        jTextFieldMaKM.setText("");
        jTextFieldNgayKT.setText("");
        jTextFieldCKMG.setText("");
        jTextFieldNgayBD.setText("");
        jTextFieldNgayKT.setText("");
        jTextFieldGhiChu.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new component.PanelRound();
        fromDateJLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelRound3 = new component.PanelRound();
        tenKM = new javax.swing.JLabel();
        ngayKT = new javax.swing.JLabel();
        loaiKM = new javax.swing.JLabel();
        cKMG = new javax.swing.JLabel();
        JButtonAdd = new component.MyButton();
        JButtonUpdate = new component.MyButton();
        panelRound4 = new component.PanelRound();
        jTextFieldTenKM = new javax.swing.JTextField();
        panelRound5 = new component.PanelRound();
        jTextFieldNgayBD = new javax.swing.JTextField();
        panelRound6 = new component.PanelRound();
        jComboBox3 = new javax.swing.JComboBox<>();
        panelRound7 = new component.PanelRound();
        jTextFieldNgayKT = new javax.swing.JTextField();
        ngayBD = new javax.swing.JLabel();
        panelRound1 = new component.PanelRound();
        jTextFieldMaKM = new javax.swing.JTextField();
        maKM = new javax.swing.JLabel();
        panelRound8 = new component.PanelRound();
        jTextFieldCKMG = new javax.swing.JTextField();
        maKM1 = new javax.swing.JLabel();
        panelRound9 = new component.PanelRound();
        jTextFieldGhiChu = new javax.swing.JTextField();

        setBackground(new java.awt.Color(83, 86, 99));

        panelRound2.setBackground(new java.awt.Color(31, 29, 43));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        fromDateJLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fromDateJLabel.setForeground(new java.awt.Color(255, 255, 255));
        fromDateJLabel.setText("QUẢN LÝ KHUYẾN MÃI");

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mãi khuyến mãi", "Tên khuyến mãi", "Loại khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc", "Chiết khấu", "Mệnh giá", "Ghi chú"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        panelRound3.setBackground(new java.awt.Color(31, 29, 43));
        panelRound3.setForeground(new java.awt.Color(31, 29, 43));
        panelRound3.setToolTipText("");

        tenKM.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        tenKM.setForeground(new java.awt.Color(255, 255, 255));
        tenKM.setText("Tên khuyến mãi");
        tenKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tenKMMouseClicked(evt);
            }
        });

        ngayKT.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        ngayKT.setForeground(new java.awt.Color(255, 255, 255));
        ngayKT.setText("Ngày kết thúc");
        ngayKT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ngayKTMouseClicked(evt);
            }
        });

        loaiKM.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        loaiKM.setForeground(new java.awt.Color(255, 255, 255));
        loaiKM.setText("Loại khuyến mãi");
        loaiKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loaiKMMouseClicked(evt);
            }
        });

        cKMG.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        cKMG.setForeground(new java.awt.Color(255, 255, 255));
        cKMG.setText("Chiết khấu/Mệnh giá");
        cKMG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cKMGMouseClicked(evt);
            }
        });

        JButtonAdd.setBackground(new java.awt.Color(51, 204, 0));
        JButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        JButtonAdd.setText("THÊM KHUYẾN MÃI");
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
        JButtonUpdate.setText("SỬA KHUYỄN MÃI");
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

        jTextFieldTenKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldTenKMMouseExited(evt);
            }
        });
        jTextFieldTenKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldTenKM, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTextFieldTenKM)
                .addGap(0, 0, 0))
        );

        jTextFieldNgayBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNgayBDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTextFieldNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldNgayBD)
        );

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        jTextFieldNgayKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNgayKTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addComponent(jTextFieldNgayKT)
                .addGap(0, 0, 0))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldNgayKT)
        );

        ngayBD.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        ngayBD.setForeground(new java.awt.Color(255, 255, 255));
        ngayBD.setText("Ngày bắt đầu ");
        ngayBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ngayBDMouseClicked(evt);
            }
        });

        jTextFieldMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMaKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTextFieldMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldMaKM, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        maKM.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        maKM.setForeground(new java.awt.Color(255, 255, 255));
        maKM.setText("Ghi chú");
        maKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maKMMouseClicked(evt);
            }
        });

        jTextFieldCKMG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldCKMGMouseEntered(evt);
            }
        });
        jTextFieldCKMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCKMGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldCKMG)
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTextFieldCKMG, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        maKM1.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        maKM1.setForeground(new java.awt.Color(255, 255, 255));
        maKM1.setText("Mã khuyến mãi");
        maKM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maKM1MouseClicked(evt);
            }
        });

        jTextFieldGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGhiChuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addComponent(jTextFieldGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldGhiChu)
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cKMG, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(tenKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loaiKM, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(maKM1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ngayBD, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(maKM, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(ngayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(JButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(tenKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(17, 17, 17)))
                        .addComponent(cKMG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ngayBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loaiKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JButtonUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(maKM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelRound3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5))))))
        );

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromDateJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addComponent(fromDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
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

    private void JButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JButtonAddActionPerformed

    private void JButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JButtonUpdateActionPerformed

    private void tenKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tenKMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tenKMMouseClicked

    private void ngayKTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngayKTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayKTMouseClicked

    private void loaiKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loaiKMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiKMMouseClicked

    private void cKMGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cKMGMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cKMGMouseClicked

    private void jTextFieldTenKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenKMActionPerformed

    private void jTextFieldNgayKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNgayKTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNgayKTActionPerformed

    private void JButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAddMouseClicked
        // TODO add your handling code here:
        try {
            // Kiểm tra mã khuyến mãi
            String maKhuyenMai = jTextFieldMaKM.getText();
            if (!maKhuyenMai.matches("KM[1-3]-\\d{15}")) {
                throw new IllegalArgumentException("Mã khuyến mãi không hợp lệ!");
            }

            // Kiểm tra tên khuyến mãi
            String tenKhuyenMai = jTextFieldTenKM.getText();
            if (tenKhuyenMai.isEmpty()) {
                throw new IllegalArgumentException("Tên khuyến mãi không được trống!");
            }

            // Kiểm tra ngày bắt đầu và ngày kết thúc
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ngayBD = LocalDate.parse(jTextFieldNgayBD.getText(), dateFormatter);
            LocalDate ngayKT = LocalDate.parse(jTextFieldNgayKT.getText(), dateFormatter);
            LocalDateTime ngayBatDau = ngayBD.atStartOfDay();
            LocalDateTime ngayKetThuc = ngayKT.atStartOfDay();

            if (ngayBatDau.isAfter(ngayKetThuc)) {
                throw new IllegalArgumentException("Ngày kết thúc phải sau ngày bắt đầu!");
            }

            // Lấy loại khuyến mãi và các giá trị liên quan
            LoaiKhuyenMai loaiKhuyenMai = LoaiKhuyenMai.valueOf(jComboBox3.getSelectedItem().toString());
            double chietKhau = 0.0;
            double menhGia = 0.0;

            if (loaiKhuyenMai == LoaiKhuyenMai.SU_KIEN_DAC_BIET) {
                chietKhau = Double.parseDouble(jTextFieldCKMG.getText());
            } else if (loaiKhuyenMai == LoaiKhuyenMai.VOUCHER) {
                menhGia = Double.parseDouble(jTextFieldCKMG.getText());
            }

            KhuyenMai khuyenMai = new KhuyenMai();
            khuyenMai.setMaKhuyenMai(maKhuyenMai);
            khuyenMai.setTenKhuyenMai(tenKhuyenMai);
            khuyenMai.setNgayBatDau(ngayBatDau);
            khuyenMai.setNgayKetThuc(ngayKetThuc);
            khuyenMai.setLoaiKhuyenMai(loaiKhuyenMai);
            khuyenMai.setChietKhau(chietKhau);
            khuyenMai.setMenhGia(menhGia);
            
            // Thêm khuyến mãi vào cơ sở dữ liệu (không khai báo đối tượng KhuyenMai riêng)
            if (daoKM.insert(khuyenMai)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Thêm khuyến mãi thành công !");
                populateTable();
                clearData();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Chưa thêm được khuyến mãi !");
            }
        } catch (DateTimeParseException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Định dạng không hợp lệ !");
        } catch (NumberFormatException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Không hợp lệ !");
        } 
    }//GEN-LAST:event_JButtonAddMouseClicked

    private void jTextFieldTenKMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTenKMMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldTenKMMouseExited

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        // TODO add your handling code here:
        List<KhuyenMai> allKhuyenMais = daoKM.findAll(KhuyenMai.class);

        // Lấy chỉ số của hàng được chọn
        int rowIndex = jTable1.getSelectedRow();

        // Kiểm tra nếu hàng được chọn hợp lệ
        if (rowIndex >= 0) {
            // Lấy đối tượng KhuyenMai từ hàng được chọn
            KhuyenMai khuyenMai = allKhuyenMais.get(rowIndex);

            // Hiển thị dữ liệu của đối tượng KhuyenMai lên các JTextField tương ứng
            jTextFieldMaKM.setText(khuyenMai.getMaKhuyenMai());
            jTextFieldTenKM.setText(khuyenMai.getTenKhuyenMai());
            jTextFieldNgayBD.setText(String.valueOf(khuyenMai.getNgayBatDau().toLocalDate().toString()));
            jTextFieldNgayKT.setText(String.valueOf(khuyenMai.getNgayKetThuc().toLocalDate().toString()));
            jTextFieldGhiChu.setText(khuyenMai.getGhiChu());
            LoaiKhuyenMai loaiKhuyenMai = null;
            String loaiKhuyenMaiStr = jComboBox3.getSelectedItem().toString();
            if (khuyenMai.getLoaiKhuyenMai().SU_KIEN_DAC_BIET.equals(LoaiKhuyenMai.SU_KIEN_DAC_BIET)) {
                jComboBox3.setSelectedItem("SU_KIEN_DAC_BIET");
                jTextFieldCKMG.setText(String.valueOf(khuyenMai.getChietKhau()));
            } else if (khuyenMai.getLoaiKhuyenMai().VOUCHER.equals(LoaiKhuyenMai.VOUCHER)) {
                jComboBox3.setSelectedItem("VOUCHER");
                jTextFieldCKMG.setText(String.valueOf(khuyenMai.getMenhGia()));
            }

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void JButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonUpdateMouseClicked
        // TODO add your handling code here:
        try {
            // Kiểm tra mã khuyến mãi
            String maKhuyenMai = jTextFieldMaKM.getText();
            if (!maKhuyenMai.matches("KM[1-3]-\\d{15}")) {
                throw new IllegalArgumentException("Mã khuyến mãi không hợp lệ!");
            }

            // Kiểm tra tên khuyến mãi
            String tenKhuyenMai = jTextFieldTenKM.getText();
            if (tenKhuyenMai.isEmpty()) {
                throw new IllegalArgumentException("Tên khuyến mãi không được trống!");
            }

            // Kiểm tra ngày bắt đầu và ngày kết thúc
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ngayBD = LocalDate.parse(jTextFieldNgayBD.getText(), dateFormatter);
            LocalDate ngayKT = LocalDate.parse(jTextFieldNgayKT.getText(), dateFormatter);
            LocalDateTime ngayBatDau = ngayBD.atStartOfDay();
            LocalDateTime ngayKetThuc = ngayKT.atStartOfDay();

            if (ngayBatDau.isAfter(ngayKetThuc)) {
                throw new IllegalArgumentException("Ngày kết thúc phải sau ngày bắt đầu!");
            }

            // Lấy loại khuyến mãi và các giá trị liên quan
            LoaiKhuyenMai loaiKhuyenMai = LoaiKhuyenMai.valueOf(jComboBox3.getSelectedItem().toString());
            double chietKhau = 0.0;
            double menhGia = 0.0;

            if (loaiKhuyenMai == LoaiKhuyenMai.SU_KIEN_DAC_BIET) {
                chietKhau = Double.parseDouble(jTextFieldCKMG.getText());
            } else if (loaiKhuyenMai == LoaiKhuyenMai.VOUCHER) {
                menhGia = Double.parseDouble(jTextFieldCKMG.getText());
            }

            KhuyenMai khuyenMai = new KhuyenMai();
            khuyenMai.setMaKhuyenMai(maKhuyenMai);
            khuyenMai.setTenKhuyenMai(tenKhuyenMai);
            khuyenMai.setNgayBatDau(ngayBatDau);
            khuyenMai.setNgayKetThuc(ngayKetThuc);
            khuyenMai.setLoaiKhuyenMai(loaiKhuyenMai);
            khuyenMai.setChietKhau(chietKhau);
            khuyenMai.setMenhGia(menhGia);
            
            // Thêm khuyến mãi vào cơ sở dữ liệu (không khai báo đối tượng KhuyenMai riêng)
            if (daoKM.update(khuyenMai)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Thay đổi khuyến mãi thành công !");
                populateTable();
                clearData();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Chưa thay đổi được khuyến mãi !");
            }
        } catch (DateTimeParseException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Định dạng không hợp lệ !");
        } catch (NumberFormatException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Không hợp lệ !");
        } 
    }//GEN-LAST:event_JButtonUpdateMouseClicked

    private void ngayBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngayBDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayBDMouseClicked

    private void jTextFieldNgayBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNgayBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNgayBDActionPerformed

    private void jTextFieldMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMaKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMaKMActionPerformed

    private void maKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maKMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_maKMMouseClicked

    private void jTextFieldCKMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCKMGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCKMGActionPerformed

    private void maKM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maKM1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_maKM1MouseClicked

    private void jTextFieldGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGhiChuActionPerformed

    private void jTextFieldCKMGMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCKMGMouseEntered
        // TODO add your handling code here:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate ngayBD = LocalDate.parse(jTextFieldNgayBD.getText());
        String ngayBatDauStr = ngayBD.format(formatter);
        LocalDate ngayKT = LocalDate.parse(jTextFieldNgayKT.getText());
        String ngayKetThucStr = ngayKT.format(formatter);

        // Lấy ngày giờ hiện tại
        LocalDateTime now = LocalDateTime.now();
        String datePart = now.format(formatter);

        // Kiểm tra nếu ngày đã thay đổi thì reset sequenceNumber
        if (!datePart.equals(lastGeneratedDate)) {
            sequenceNumber = 0;
            lastGeneratedDate = datePart;
        }

        // Tăng sequenceNumber và đảm bảo nó có 3 chữ số
        String sequencePart = String.format("%03d", sequenceNumber);

        String km = "";
        String loaiKhuyenMaiStr = jComboBox3.getSelectedItem().toString();
        switch (loaiKhuyenMaiStr) {
            case "SU_KIEN_DAC_BIET":
                km = "0";
                break;
            case "VOUCHER":
                km = "1";
                break;
        }
        // Tạo mã món
        String itemCode = "KM" + km + ngayBatDauStr + ngayKetThucStr + sequencePart;

        jTextFieldMaKM.setText(itemCode);
    }//GEN-LAST:event_jTextFieldCKMGMouseEntered

    private KhuyenMaiDAO daoKM;
    private static int sequenceNumber = 0; // Biến số tự tăng
    private static String lastGeneratedDate = ""; // Ngày cuối cùng tạo mã dưới dạng chuỗi


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton JButtonAdd;
    private component.MyButton JButtonUpdate;
    private javax.swing.JLabel cKMG;
    private javax.swing.JLabel fromDateJLabel;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCKMG;
    private javax.swing.JTextField jTextFieldGhiChu;
    private javax.swing.JTextField jTextFieldMaKM;
    private javax.swing.JTextField jTextFieldNgayBD;
    private javax.swing.JTextField jTextFieldNgayKT;
    private javax.swing.JTextField jTextFieldTenKM;
    private javax.swing.JLabel loaiKM;
    private javax.swing.JLabel maKM;
    private javax.swing.JLabel maKM1;
    private javax.swing.JLabel ngayBD;
    private javax.swing.JLabel ngayKT;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private component.PanelRound panelRound5;
    private component.PanelRound panelRound6;
    private component.PanelRound panelRound7;
    private component.PanelRound panelRound8;
    private component.PanelRound panelRound9;
    private javax.swing.JLabel tenKM;
    // End of variables declaration//GEN-END:variables
}
