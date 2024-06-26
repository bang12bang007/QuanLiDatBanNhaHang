package view.manager.application;

import dao.imlp.BanDAO;
import entity.Ban;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import raven.toast.Notifications;
import static utils.AppUtils._NORMAL_;
import component.SimpleForm;

public class GD_QuanLyBan extends SimpleForm {

    public GD_QuanLyBan() {
        initComponents();

        daoB = new BanDAO();
        populateTable();
    }

    private void populateTable() {
        // Xóa tất cả các dòng hiện có trong bảng
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        List<Ban> allBans = daoB.findAll(Ban.class);

        // Thêm dữ liệu từ danh sách vào bảng
        for (int i = 0; i < allBans.size(); i++) {
            Ban ban = allBans.get(i);
            // Truy cập các thuộc tính của đối tượng Ban và thêm vào từng cột
            model.addRow(new Object[]{i + 1, ban.getMaBan(), ban.getTang(), ban.getSoGhe()});
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
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new component.PanelRound();
        fromDateJLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelRound3 = new component.PanelRound();
        maBan = new javax.swing.JLabel();
        soGhe = new javax.swing.JLabel();
        trangThai = new javax.swing.JLabel();
        myButton1 = new component.MyButton();
        myButton2 = new component.MyButton();
        panelRound4 = new component.PanelRound();
        jTextField1 = new javax.swing.JTextField();
        panelRound6 = new component.PanelRound();
        jTextField2 = new javax.swing.JTextField();
        panelRound7 = new component.PanelRound();
        jTextField3 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(83, 86, 99));

        panelRound2.setBackground(new java.awt.Color(31, 29, 43));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        fromDateJLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fromDateJLabel.setForeground(new java.awt.Color(255, 255, 255));
        fromDateJLabel.setText("QUẢN LÝ BÀN");

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã bàn", "Tầng", "Số ghế "
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

        maBan.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        maBan.setForeground(new java.awt.Color(255, 255, 255));
        maBan.setText("Tầng");
        maBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maBanMouseClicked(evt);
            }
        });

        soGhe.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        soGhe.setForeground(new java.awt.Color(255, 255, 255));
        soGhe.setText("Số ghế");
        soGhe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soGheMouseClicked(evt);
            }
        });

        trangThai.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        trangThai.setForeground(new java.awt.Color(255, 255, 255));
        trangThai.setText("Mã bàn");
        trangThai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangThaiMouseClicked(evt);
            }
        });

        myButton1.setBackground(new java.awt.Color(51, 204, 0));
        myButton1.setForeground(new java.awt.Color(255, 255, 255));
        myButton1.setText("THÊM BÀN");
        myButton1.setColor(new java.awt.Color(51, 204, 0));
        myButton1.setColorClick(new java.awt.Color(179, 250, 160));
        myButton1.setColorOver(new java.awt.Color(51, 204, 0));
        myButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton1MouseClicked(evt);
            }
        });

        myButton2.setBackground(new java.awt.Color(255, 51, 0));
        myButton2.setForeground(new java.awt.Color(255, 255, 255));
        myButton2.setText("SỬA BÀN");
        myButton2.setColor(new java.awt.Color(255, 51, 0));
        myButton2.setColorClick(new java.awt.Color(255, 102, 102));
        myButton2.setColorOver(new java.awt.Color(255, 51, 0));
        myButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton2MouseClicked(evt);
            }
        });

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField1MouseExited(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
        );

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField2)
        );

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3)
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maBan, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soGhe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(soGhe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(fromDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
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

    private void maBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maBanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_maBanMouseClicked

    private void soGheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soGheMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_soGheMouseClicked

    private void trangThaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangThaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangThaiMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void myButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseClicked
        // TODO add your handling code here:
        Ban ban = new Ban();
        ban.setMaBan(jTextField2.getText());
        ban.setTang(jTextField1.getText());
        ban.setSoGhe(Integer.parseInt(jTextField3.getText()));
        ban.setTrangThai(utils.Enum.LoaiTrangThai.BAN_TRONG);
        if (daoB.insert(ban)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Thêm bàn thành công !");
            populateTable();
            clearData();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Chưa được thêm bàn!");

        }
    }//GEN-LAST:event_myButton1MouseClicked

    private void jTextField1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseExited
        // TODO add your handling code here:
        if (Integer.parseInt(jTextField1.getText()) > 0 && Integer.parseInt(jTextField1.getText()) < 4) {
            List<Ban> bans = daoB.findByFloor(Integer.parseInt(jTextField1.getText()));
            Ban ban = bans.get(bans.size() - 1);
            int maBan = Integer.parseInt(ban.getMaBan().substring(3)) + 1;
            jTextField2.setText("BAN0" + String.valueOf(maBan));
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1500, "Nhà hàng chỉ có 3 tầng !");
        }

    }//GEN-LAST:event_jTextField1MouseExited

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        // TODO add your handling code here:

        List<Ban> allBans = daoB.findAll(Ban.class);

        // Lấy chỉ số của hàng được chọn
        int rowIndex = jTable1.getSelectedRow();

        // Kiểm tra nếu hàng được chọn hợp lệ
        if (rowIndex >= 0) {
            // Lấy đối tượng NhanVien từ hàng được chọn
            Ban ban = allBans.get(rowIndex);

            jTextField1.setText(ban.getTang());
            jTextField2.setText(ban.getMaBan());
            jTextField3.setText(String.valueOf(ban.getSoGhe()));
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void myButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton2MouseClicked
        // TODO add your handling code here:
        Ban ban = new Ban();
        ban.setMaBan(jTextField2.getText());
        ban.setTang(jTextField1.getText());
        ban.setSoGhe(Integer.parseInt(jTextField3.getText()));
        ban.setTrangThai(utils.Enum.LoaiTrangThai.BAN_TRONG);
        if (daoB.update(ban)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Thay đổi thông tin bàn thành công !");
            populateTable();
            clearData();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Chưa thay đổi được thông tin bàn!");

        }
    }//GEN-LAST:event_myButton2MouseClicked

    private BanDAO daoB;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fromDateJLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel maBan;
    private component.MyButton myButton1;
    private component.MyButton myButton2;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private component.PanelRound panelRound6;
    private component.PanelRound panelRound7;
    private javax.swing.JLabel soGhe;
    private javax.swing.JLabel trangThai;
    // End of variables declaration//GEN-END:variables
}
