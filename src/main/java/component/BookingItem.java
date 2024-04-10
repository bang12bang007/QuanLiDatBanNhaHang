/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import dao.IBanDAO;
import dao.IHoaDonDAO;
import dao.IKhachHangDAO;
import dao.IPhieuDatBanDAO;
import dao.imlp.BanDAO;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.KhachHangDAO;
import dao.imlp.PhieuDatBanDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.Mon;
import entity.NhanVien;
import entity.PhieuDatBan;
import icon.FontAwesome;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;
import jiconfont.swing.IconFontSwing;
import utils.AppUtils;
import view.GD_Ban;
import view.GD_DatBan;
import view.GD_DatMon;

/**
 *
 * @author Laptop
 */
public class BookingItem extends javax.swing.JPanel {

    /**
     * Creates new form BookingItem
     */
    private GD_DatBan GD;
    private int index;
    private PhieuDatBan phieuDatBan;

    public BookingItem() {
        initComponents();
        wrapper.setPreferredSize(new Dimension(1076, 60));
    }

    public void setActive(int active) {
        if (active == index) {
            this.setBorder(new LineBorder(new Color(234, 124, 105)));
        } else {
            this.setBorder(null);
        }
    }

    public BookingItem(int index, String[] data, int width, GD_DatBan GD) {
        this.index = index;
        this.GD = GD;
        initComponents();
        setIndex(index);
        wrapper.setPreferredSize(new Dimension(width, 65));
        IconFontSwing.register(FontAwesome.getIconFont());
        btnNhanBan.setIcon(IconFontSwing.buildIcon(FontAwesome.CHECK_SQUARE_O, 40, new Color(20, 174, 92)));
        btnGoiMon.setColor(new Color(0, 0, 0, 0));
        btnSapCho.setColor(new Color(0, 0, 0, 0));
        btnNhanBan.setColor(new Color(0, 0, 0, 0));
        push(data);
    }

    public void setIndex(int index) {
        Color color = index % 2 == 0 ? new Color(83, 86, 99) : new Color(31, 29, 43);
        left.setBackground(color);
        right.setBackground(color);
        this.index = index;
    }

    private void push(String[] data) {
        gioDen.setText("   " + forrmater(data[0]));
        khachHang.setText(data[1]);
        soNguoi.setText(data[2]);
        trangThai.setText(data[3]);
        datCoc.setText(data[4] + "    ");
    }

    public PhieuDatBan getPhieuDatBan() {
        return phieuDatBan;
    }

    public void setPhieuDatBan(PhieuDatBan phieuDatBan) {
        this.phieuDatBan = phieuDatBan;
    }

    public void setData(String[] data) {
        push(data);
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
        left = new javax.swing.JPanel();
        btnSapCho = new component.MyButton();
        btnGoiMon = new component.MyButton();
        btnNhanBan = new component.MyButton();
        gioDen = new javax.swing.JLabel();
        khachHang = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        soNguoi = new javax.swing.JLabel();
        trangThai = new javax.swing.JLabel();
        datCoc = new javax.swing.JLabel();

        wrapper.setForeground(new java.awt.Color(255, 255, 255));
        wrapper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wrapperMouseClicked(evt);
            }
        });
        wrapper.setLayout(new java.awt.GridLayout(1, 0));

        left.setLayout(new java.awt.GridLayout(1, 5));

        btnSapCho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/table_icon.png"))); // NOI18N
        btnSapCho.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSapCho.setMaximumSize(new java.awt.Dimension(30, 60));
        btnSapCho.setMinimumSize(new java.awt.Dimension(30, 60));
        btnSapCho.setName(""); // NOI18N
        btnSapCho.setRadius(12);
        btnSapCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapChoActionPerformed(evt);
            }
        });
        left.add(btnSapCho);

        btnGoiMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fork_icon.png"))); // NOI18N
        btnGoiMon.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGoiMon.setMaximumSize(new java.awt.Dimension(30, 60));
        btnGoiMon.setMinimumSize(new java.awt.Dimension(30, 60));
        btnGoiMon.setName(""); // NOI18N
        btnGoiMon.setRadius(12);
        btnGoiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoiMonActionPerformed(evt);
            }
        });
        left.add(btnGoiMon);

        btnNhanBan.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnNhanBan.setMaximumSize(new java.awt.Dimension(30, 60));
        btnNhanBan.setMinimumSize(new java.awt.Dimension(30, 60));
        btnNhanBan.setName(""); // NOI18N
        btnNhanBan.setRadius(12);
        btnNhanBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanBanActionPerformed(evt);
            }
        });
        left.add(btnNhanBan);

        gioDen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gioDen.setForeground(new java.awt.Color(255, 255, 255));
        left.add(gioDen);

        khachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        khachHang.setForeground(new java.awt.Color(255, 255, 255));
        left.add(khachHang);

        wrapper.add(left);

        right.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        right.add(jLabel1);

        soNguoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        soNguoi.setForeground(new java.awt.Color(255, 255, 255));
        soNguoi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        right.add(soNguoi);

        trangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        trangThai.setForeground(new java.awt.Color(255, 255, 255));
        trangThai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        right.add(trangThai);

        datCoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        datCoc.setForeground(new java.awt.Color(255, 255, 255));
        datCoc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        right.add(datCoc);

        wrapper.add(right);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSapChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapChoActionPerformed
        // TODO add your handling code here:
        utils.AppUtils.setUI(GD.getMainJpanel(), new GD_Ban(GD.getMainJpanel(), "CHUYEN_BAN", phieuDatBan));
    }//GEN-LAST:event_btnSapChoActionPerformed

    private void wrapperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wrapperMouseClicked
        // TODO add your handling code here:
        GD.setBookingActive(index);
        GD.setInfoForActiveItem(phieuDatBan);
    }//GEN-LAST:event_wrapperMouseClicked

    private void btnNhanBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanBanActionPerformed
        GD.setBookingActive(index);
        GD.received();
    }//GEN-LAST:event_btnNhanBanActionPerformed

    private void btnGoiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoiMonActionPerformed
        // TODO add your handling code here:
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            GD_DatMon datMon = new GD_DatMon(GD.getMainJpanel(), phieuDatBan.getBan(), utils.Enum.DatMon_ThemMon.THEMMON);
            @Override
            protected Void doInBackground() throws Exception {
                // Thực hiện công việc lâu dài ở đây
                List<ChiTietHoaDon> list = GD.getChiTietHoaDonByBan(phieuDatBan.getBan());
                ArrayList<Mon> mons = new ArrayList<Mon>();
                ArrayList<Integer> quantity = new ArrayList<Integer>();
//                Double total = 0.0;
                for (ChiTietHoaDon chitiet : list) {
                    mons.add(chitiet.getMon());
                    quantity.add(chitiet.getSoLuong());
//                    total = chitiet.getMon().getGia()*chitiet.getSoLuong();
                }
                datMon.setList_quantity(quantity);
                datMon.setOrders(mons);
                datMon.setBranch(utils.Enum.TypeDatMon_Branch.DAT_TRUOC_MON);
//                datMon.setLabelTongTien(AppUtils.tien_format.format(total));
                return null;
            }

            @Override
            protected void done() {
                utils.AppUtils.setUI(GD.getMainJpanel(), datMon);
            }
        };
        worker.execute();
    }//GEN-LAST:event_btnGoiMonActionPerformed

    private String forrmater(String date) {
        String dateTimeString = date;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
        String formattedTime = "";
        try {
            Date dateTime = inputFormat.parse(dateTimeString);
            formattedTime = outputFormat.format(dateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formattedTime;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai.setText(trangThai);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnGoiMon;
    private component.MyButton btnNhanBan;
    private component.MyButton btnSapCho;
    private javax.swing.JLabel datCoc;
    private javax.swing.JLabel gioDen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel khachHang;
    private javax.swing.JPanel left;
    private javax.swing.JPanel right;
    private javax.swing.JLabel soNguoi;
    private javax.swing.JLabel trangThai;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables

}
