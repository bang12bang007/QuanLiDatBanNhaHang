/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.employee;

import com.formdev.flatlaf.FlatIntelliJLaf;
import dao.IBanDAO;
import dao.IHoaDonDAO;
import dao.IKhachHangDAO;
import dao.imlp.BanDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.KhachHangDAO;
import entity.Ban;
import entity.HoaDon;
import entity.KhachHang;
import icon.FontAwesome;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jiconfont.swing.IconFontSwing;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import raven.toast.Notifications;

import static utils.AppUtils.*;

/**
 * @author Laptop
 */
public class Form_LuuTam extends javax.swing.JPanel {

    private JFrame jFrame;
    private JPanel mainJPanel;
    private static final Color TRANSPERANT = new Color(0, 0, 0, 0);
    private List<String> items = new ArrayList<String>();
    private List<String> SDTitems = new ArrayList<>();
    private List<KhachHang> khachHangs = new ArrayList<KhachHang>();
    private IKhachHangDAO khachHangDAO = new KhachHangDAO();
    private IBanDAO banDAO = new BanDAO();
    private IHoaDonDAO hoaDonDAO = new HoaDonDAO();
    private List<HoaDon> hoaDons = new ArrayList<>();
    private double thue;
    private String type;

    public Form_LuuTam(JFrame jFrame, JPanel mainJPanel, double thue) {
        this.jFrame = jFrame;
        this.mainJPanel = mainJPanel;
        this.thue = thue;
        initComponents();
        Notifications.getInstance().setJFrame(jFrame);
        FlatIntelliJLaf.setup();
        IconFontSwing.register(FontAwesome.getIconFont());
        this.setBackground(new Color(0, 0, 0, 0.6f));
        txtKhachHang.setBackground(TRANSPERANT);
        txtSoDienThoai.setBackground(TRANSPERANT);
        autoComplete();
        autoCompleteSDT();
    }

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
        panelRound3 = new component.PanelRound();
        txtKhachHang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelRound4 = new component.PanelRound();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        dateChooser.setDateFormat("dd/MM/yyyy");

        setForeground(new java.awt.Color(255, 255, 255));

        wrapper.setBackground(new java.awt.Color(83, 86, 99));

        header.setBackground(new java.awt.Color(31, 29, 43));

        jLabel1.setFont(utils.AppUtils.getFont(16f, _BOLD_));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lưu tạm tính");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(623, 623, 623)
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
        btnCat.setText("ĐỒNG Ý");
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
                .addContainerGap(153, Short.MAX_VALUE)
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

        panelRound3.setBackground(java.awt.Color.white);
        panelRound3.setRoundBottomLeft(8);
        panelRound3.setRoundBottomRight(8);
        panelRound3.setRoundTopLeft(8);
        panelRound3.setRoundTopRight(8);

        txtKhachHang.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtKhachHang.setBorder(null);
        txtKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachHangKeyReleased(evt);
            }
        });

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

        jLabel4.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên thành viên");

        jLabel5.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số điện thoại");

        panelRound4.setBackground(java.awt.Color.white);
        panelRound4.setRoundBottomLeft(8);
        panelRound4.setRoundBottomRight(8);
        panelRound4.setRoundTopLeft(8);
        panelRound4.setRoundTopRight(8);

        txtSoDienThoai.setFont(utils.AppUtils.getFont(16f, _NORMAL_));
        txtSoDienThoai.setBorder(null);
        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });
        txtSoDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoDienThoaiKeyReleased(evt);
            }
        });

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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("*");

        jLabel2.setFont(utils.AppUtils.getFont(18f, _BOLD_)
        );
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vui lòng điền đầy đủ thông tin để lưu tạm tính");

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, Short.MAX_VALUE)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wrapperLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createSequentialGroup()
                        .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(wrapperLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(wrapperLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatActionPerformed
        if (isValidate()) {
            if (type.equals("IN_LUU_TAM")) {
                saveAndPrint();
            } else {
                save();
                updateHoaDon();
            }
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1000, "Lưu tạm hóa đơn thành công");
            jFrame.setVisible(false);
            jFrame.dispose();
            utils.AppUtils.setUI(mainJPanel, () -> new GD_DatBanTaiCho(mainJPanel, NHANVIEN));
        }
    }//GEN-LAST:event_btnCatActionPerformed

    private boolean isValidate() {
        String khachHang = txtKhachHang.getText();
        String sdt = txtSoDienThoai.getText();
        if (khachHang.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 1500, "Không được rỗng");
            return false;
        }
        if (sdt.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 1500, "Không được rỗng");
            return false;
        }
        if (!sdt.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 1500, "Số điện thoại không hợp lệ");
            return false;
        }
        return true;
    }

    private void save() {
        Ban _ban_ = hoaDons.get(0).getBan();
        List<Ban> listBanGop = banDAO.getListBanGopInvoice(_ban_.getMaBan());
        listBanGop.forEach(ban -> {
            updateBanAfterPay(ban);
        });
        if (listBanGop.size() == 0) {
            updateBanAfterPay(_ban_);
        }
    }

    private void saveAndPrint() {
        save();
        updateHoaDon();
        createInvoice();
    }

    private void createInvoice() {
        hoaDonDAO.createInvoice(hoaDons.get(0), 0, 0);
    }

    private void updateHoaDon() {
        hoaDons.get(0).addThue(thue);
        hoaDons.forEach(hoaDon -> {
            hoaDon.setTrangThai(utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN);
            hoaDonDAO.update(hoaDon);
        });
    }

    private void updateBanAfterPay(Ban ban) {
        List<String> oldBanGops = new ArrayList<>();
        List<Integer> oldState = new ArrayList<>();
        if (ban.getOldBanGop() != null) {
            oldBanGops = new ArrayList<>(Arrays.asList(ban.getOldBanGop().split(",")));
            oldState = new ArrayList<>();
            String[] oldStateStrings = ban.getOldState().split(",");
            for (String stateString : oldStateStrings) {
                oldState.add(Integer.parseInt(stateString));
            }
        }
        if (oldBanGops.size() == 0) {
            ban.setBanGop(null);
            ban.setTrangThai(utils.Enum.LoaiTrangThai.BAN_TRONG);
        } else if (oldBanGops.size() > 0) {
            while (oldState.get(oldState.size() - 1) == 0 || oldState.get(oldState.size() - 1) == 3) {
                String lastItem = oldBanGops.get(oldBanGops.size() - 1);
                ban.setBanGop((Ban) banDAO.findById(lastItem, Ban.class));
                ban.setTrangThai(utils.Enum.LoaiTrangThai.values()[oldState.get(oldState.size() - 1)]);
                oldBanGops.remove(oldBanGops.size() - 1);
                oldState.remove(oldState.size() - 1);
                String oldBanGop = oldBanGops.size() > 0 ? String.join(",", oldBanGops) : null;
                String oldStateString = oldState.size() > 0 ? (oldState.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",")))
                        : null;
                ban.setOldBanGop(oldBanGop);
                ban.setOldState(oldStateString);
            }
            String lastItem = oldBanGops.get(oldBanGops.size() - 1);
            ban.setBanGop((Ban) banDAO.findById(lastItem, Ban.class));
            ban.setTrangThai(utils.Enum.LoaiTrangThai.values()[oldState.get(oldState.size() - 1)]);
            oldBanGops.remove(oldBanGops.size() - 1);
            oldState.remove(oldState.size() - 1);
            String oldBanGop = oldBanGops.size() > 0 ? String.join(",", oldBanGops) : null;
            String oldStateString = oldState.size() > 0 ? (oldState.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(",")))
                    : null;
            ban.setOldBanGop(oldBanGop);
            ban.setOldState(oldStateString);
        }

        banDAO.update(ban);
    }

    private void autoComplete() {
        khachHangs = khachHangDAO.findAll(KhachHang.class);
        for (KhachHang khachHang : khachHangs) {
            items.add((khachHang).getHoTen());
        }
        AutoCompleteDecorator.decorate(txtKhachHang, items, false);
    }

    private void autoCompleteSDT() {
        for (KhachHang khachHang : khachHangs) {
            SDTitems.add((khachHang).getSoDienThoai());
        }
        AutoCompleteDecorator.decorate(txtSoDienThoai, SDTitems, false);
    }

    private void txtKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachHangKeyReleased
        String value = txtKhachHang.getText();
        if (items.contains(value)) {
            for (KhachHang kh : khachHangs) {
                if (kh.getHoTen().equals(value)) {
                    txtSoDienThoai.setText(kh.getSoDienThoai());
                    break;
                }
            }
        }
    }//GEN-LAST:event_txtKhachHangKeyReleased

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void txtSoDienThoaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKeyReleased
        // TODO add your handling code here:
        String value = txtSoDienThoai.getText();
        if (SDTitems.contains(value)) {
            for (KhachHang kh : khachHangs) {
                if (kh.getSoDienThoai().equals(value)) {
                    txtKhachHang.setText(kh.getHoTen());
                    break;
                }
            }
        }
    }//GEN-LAST:event_txtSoDienThoaiKeyReleased

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnCat;
    private component.MyButton btnHuy;
    private datechooser.DateChooser dateChooser;
    private component.PanelRound footer;
    private component.PanelRound header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound4;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables

}
