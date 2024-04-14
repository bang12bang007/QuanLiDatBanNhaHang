/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import dao.IChiTietHoaDonDAO;
import dao.IHoaDonDAO;
import dao.IMonDAO;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.MonDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Mon;
import icon.FontAwesome;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import jiconfont.swing.IconFontSwing;
import utils.AppUtils;
import static utils.AppUtils.setUI;
import view.GD_DatMon;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import jiconfont.swing.IconFontSwing;
import view.GD_QuanLyDatMon;
import view.GD_ThanhToan;
import static utils.AppUtils.*;
/**
 *
 * @author Laptop
 */
public class OrderCard extends javax.swing.JPanel {

    /**
     * Creates new form OrderCard
     */
    private JPanel mainPanel;
    private HoaDon hoaDon;
    private Double total = 0.0;
    private DecimalFormat tien_format = new DecimalFormat("###,### VNĐ");
    private GD_QuanLyDatMon ql_datMon;//khai biến để back về không cần tạo mới
    private IHoaDonDAO hoaDonDAO;

    public OrderCard() {
        initComponents();
        setIconBtn();
    }

    public OrderCard(HoaDon hoaDon, JPanel main) {
        mainPanel = main;
        this.hoaDon = hoaDon;
        initComponents();
        setIconBtn();
        maBan.setText(hoaDon.getBan().getMaBan());
//        jLabel2.setText(hoaDon.getBan().getMaBan());
//        jLabel3.setText(tien_format.format(total));
//        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new component.PanelRound();
        panelRound2 = new component.PanelRound();
        soLuongNguoi = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        maBan = new javax.swing.JLabel();
        panelRound8 = new component.PanelRound();
        jSeparator1 = new javax.swing.JSeparator();
        tongTien = new javax.swing.JLabel();
        iconEadting = new javax.swing.JLabel();
        btnChinhSua = new component.MyButton();
        btnThanhToan = new component.MyButton();
        btnTacVu = new component.MyButton();
        btnCheck = new component.MyButton();

        setBackground(new java.awt.Color(83, 86, 99));

        panelRound1.setBackground(new java.awt.Color(31, 29, 43));
        panelRound1.setRoundBottomLeft(8);
        panelRound1.setRoundBottomRight(8);
        panelRound1.setRoundTopLeft(8);
        panelRound1.setRoundTopRight(8);

        panelRound2.setBackground(new java.awt.Color(234, 124, 105));
        panelRound2.setRoundTopLeft(8);
        panelRound2.setRoundTopRight(8);

        soLuongNguoi.setFont(utils.AppUtils.getFont(12f, _NORMAL_));
        soLuongNguoi.setForeground(new java.awt.Color(255, 255, 255));
        soLuongNguoi.setText("8");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(soLuongNguoi)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(soLuongNguoi)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(253, 193, 182));
        panelRound3.setForeground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(8);
        panelRound3.setRoundBottomRight(8);
        panelRound3.setRoundTopLeft(8);
        panelRound3.setRoundTopRight(8);
        panelRound3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound3MouseClicked(evt);
            }
        });

        maBan.setFont(utils.AppUtils.getFont(14f, _BOLD_));
        maBan.setForeground(new java.awt.Color(255, 255, 255));
        maBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maBan.setText("BAN0110");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(maBan)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(maBan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound8.setBackground(new java.awt.Color(83, 86, 99));
        panelRound8.setRoundBottomLeft(8);
        panelRound8.setRoundBottomRight(8);
        panelRound8.setRoundTopLeft(8);
        panelRound8.setRoundTopRight(8);

        tongTien.setFont(utils.AppUtils.getFont(12f, _NORMAL_));
        tongTien.setForeground(new java.awt.Color(255, 255, 255));
        tongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tongTien.setText("0");

        iconEadting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eating_icon.png"))); // NOI18N

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconEadting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(tongTien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconEadting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        btnChinhSua.setForeground(new java.awt.Color(255, 255, 255));
        btnChinhSua.setColor(new java.awt.Color(83, 86, 99));
        btnChinhSua.setColorClick(new java.awt.Color(234, 124, 105));
        btnChinhSua.setColorOver(new java.awt.Color(234, 124, 105));
        btnChinhSua.setRadius(8);
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setColor(new java.awt.Color(83, 86, 99));
        btnThanhToan.setColorClick(new java.awt.Color(234, 124, 105));
        btnThanhToan.setColorOver(new java.awt.Color(234, 124, 105));
        btnThanhToan.setRadius(8);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTacVu.setColor(new java.awt.Color(83, 86, 99));
        btnTacVu.setColorClick(new java.awt.Color(234, 124, 105));
        btnTacVu.setColorOver(new java.awt.Color(234, 124, 105));
        btnTacVu.setRadius(8);
        btnTacVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTacVuActionPerformed(evt);
            }
        });

        btnCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnCheck.setColor(new java.awt.Color(83, 86, 99));
        btnCheck.setColorClick(new java.awt.Color(234, 124, 105));
        btnCheck.setColorOver(new java.awt.Color(234, 124, 105));
        btnCheck.setRadius(8);
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(btnCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTacVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTacVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        utils.AppUtils.setUI(mainPanel, () -> new GD_ThanhToan(hoaDon, mainPanel));
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTacVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTacVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTacVuActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckActionPerformed

    private void panelRound3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound3MouseClicked
        // TODO add your handling code here:
        GD_DatMon gD_DatMon = new GD_DatMon(mainPanel, hoaDon.getBan(), utils.Enum.DatMon_ThemMon.THEMMON);
        gD_DatMon.setHoaDon(hoaDon);
        gD_DatMon.setGd_qlDatMon(ql_datMon);
        if(ql_datMon.isWaitForPayment()){
            gD_DatMon.setBranch(utils.Enum.TypeDatMon_Branch.THEMMON);
        }
        else{
            hoaDonDAO = new HoaDonDAO();
            gD_DatMon.setPhieuDatBan(hoaDonDAO.getPhieuDatBanByHoaDon(hoaDon));
            gD_DatMon.setBranch(utils.Enum.TypeDatMon_Branch.DAT_TRUOC_MON);
        }
        AppUtils.setUI(mainPanel, () -> gD_DatMon);
    }//GEN-LAST:event_panelRound3MouseClicked

    private void setIconBtn() {
        IconFontSwing.register(FontAwesome.getIconFont());
        btnThanhToan.setIcon(IconFontSwing.buildIcon(FontAwesome.CALCULATOR, 20, Color.WHITE));
        btnChinhSua.setIcon(IconFontSwing.buildIcon(FontAwesome.PENCIL, 20, Color.WHITE));
        btnTacVu.setIcon(IconFontSwing.buildIcon(FontAwesome.ELLIPSIS_H, 20, Color.WHITE));
        btnCheck.setIcon(IconFontSwing.buildIcon(FontAwesome.CHECK_SQUARE_O, 20, Color.WHITE));
        soLuongNguoi.setIcon(IconFontSwing.buildIcon(FontAwesome.USER, 20, Color.WHITE));
    }

    public void setToTal(double total) {
        tongTien.setText(tien_format.format(total));
    }
    
//    NDK: T tính trong orderCard luôn á 
//    NDK: xóa luôn đi
//    duccuong1609 : ?? :DD

    public GD_QuanLyDatMon getQl_datMon() {
        return ql_datMon;
    }

    public void setQl_datMon(GD_QuanLyDatMon ql_datMon) {
        this.ql_datMon = ql_datMon;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnCheck;
    private component.MyButton btnChinhSua;
    private component.MyButton btnTacVu;
    private component.MyButton btnThanhToan;
    private javax.swing.JLabel iconEadting;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel maBan;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private component.PanelRound panelRound8;
    private javax.swing.JLabel soLuongNguoi;
    private javax.swing.JLabel tongTien;
    // End of variables declaration//GEN-END:variables
}
