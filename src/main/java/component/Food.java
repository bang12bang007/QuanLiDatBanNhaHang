/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import com.formdev.flatlaf.FlatIntelliJLaf;
import entity.Mon;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import raven.toast.Notifications;
import view.employee.GD_DatMon;

import static utils.AppUtils.*;

/**
 * @author dmx
 */
public class Food extends javax.swing.JPanel {

    /**
     * Creates new form Food
     */
    private DecimalFormat tien_format = new DecimalFormat("###,###.0 VNĐ");
    private JPanel orderPanel;
    private String ten;
    private String gia;
    private ArrayList<Mon> orders = new ArrayList<Mon>();
    private List<Mon> mons;
    private ArrayList<Integer> list_Quantity = new ArrayList<Integer>();
    private Mon mon;
    private GD_DatMon datmon;

    public Food(GD_DatMon datmon, Mon mon, JPanel panelOrder, List<Mon> mons, ArrayList<Mon> orders) {
        initComponents();
        this.orderPanel = panelOrder;
        this.ten = mon.getTenMon();
        this.gia = mon.getGiaBan().toString();
        this.orders = orders;
        this.mon = mon;
        this.mons = mons;
        this.datmon = datmon;
        this.list_Quantity = datmon.getList_quantity();
        try {
            Double giaTien = Double.parseDouble(gia);
            jLabelGia.setText(tien_format.format(giaTien));
            jLabelTen.setText(ten);
            btnFood.setIcon(new javax.swing.ImageIcon(getClass().getResource(mon.getHinhAnh())));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Notifications.getInstance();
        FlatIntelliJLaf.setup();
    }

    public List<Mon> getOrders() {
        return orders;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFood = new component.MyButton();
        panelFood = new component.PanelRound();
        jLabelTen = new javax.swing.JLabel();
        jLabelGia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(83, 86, 99));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFood.setColor(new java.awt.Color(31, 29, 43));
        btnFood.setColorClick(new java.awt.Color(31, 29, 43));
        btnFood.setColorOver(new java.awt.Color(31, 29, 43));
        btnFood.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFood.setPreferredSize(new java.awt.Dimension(90, 90));
        btnFood.setRadius(210);
        btnFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodActionPerformed(evt);
            }
        });
        add(btnFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 210, 210));

        panelFood.setBackground(new java.awt.Color(31, 29, 43));
        panelFood.setRoundBottomLeft(15);
        panelFood.setRoundBottomRight(15);
        panelFood.setRoundTopLeft(15);
        panelFood.setRoundTopRight(15);
        panelFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelFoodMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelFoodMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelFoodMouseExited(evt);
            }
        });

        jLabelTen.setFont(utils.AppUtils.getFont(16f, _BOLD_));
        jLabelTen.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTen.setText("500.000 VNĐ");
        jLabelTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelGia.setFont(utils.AppUtils.getFont(13f, _BOLD_));
        jLabelGia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGia.setText("CƠM GÀ CHIÊN BƠ");
        jLabelGia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelFoodLayout = new javax.swing.GroupLayout(panelFood);
        panelFood.setLayout(panelFoodLayout);
        panelFoodLayout.setHorizontalGroup(
                panelFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelGia, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addComponent(jLabelTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelFoodLayout.setVerticalGroup(
                panelFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFoodLayout.createSequentialGroup()
                                .addContainerGap(118, Short.MAX_VALUE)
                                .addComponent(jLabelGia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
        );

        add(panelFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 270, 240));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodActionPerformed
        // TODO add your handling code here:
        addOrderFood();
    }//GEN-LAST:event_btnFoodActionPerformed

    private void panelFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFoodMouseClicked
        // TODO add your handling code here:
        addOrderFood();
    }//GEN-LAST:event_panelFoodMouseClicked

    public void addOrderFood() {
        panelFood.setBackground(new java.awt.Color(234, 124, 105));
        boolean found = false;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getTenMon().equals(mon.getTenMon())) {
                OrderItem_forUIDatMon item = (OrderItem_forUIDatMon) datmon.getPanelOrder().getComponent(i);
                if (!item.getType_orderItem().equals("PRELOAD")) {
                    found = true;
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 1500, "Món Đã Được Chọn, Vui Lòng Không Chọn Lại !");
                }
            }
        }
        if (found == false) {
            for (Mon m : mons) {
                if (mon.getTenMon().equals(m.getTenMon())) {
                    orders.add(mon);
                }
            }
            list_Quantity = datmon.getList_quantity();
            list_Quantity.add(1);
            datmon.getGhiChus().add(null);
            String[] title = new String[]{ten, "1", tien_format.format(Double.parseDouble(gia)), ""};
            OrderItem_forUIDatMon item = new OrderItem_forUIDatMon(datmon, mon, orderPanel.getWidth(), orders.size(), title, orders);
            item.setListPreOrder(datmon.getListPreOrderItem());
            item.setType("BUTTON");
            orderPanel.add(item);
            orderPanel.revalidate();
            datmon.setOrders(orders);
            datmon.setList_quantity(list_Quantity);
            updateTongTien();
        }
    }

    public void updateTongTien() {
        double tong = 0.0;
        for (int i = 0; i < orders.size(); i++) {
            tong += orders.get(i).getGiaBan() * datmon.getList_quantity().get(i);
        }
        if (tong != 0) {
            datmon.setLabelTongTien(tien_format.format(tong));
        } else {
            datmon.setLabelTongTien("0,0 VNĐ");
        }
    }

    private void panelFoodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFoodMouseEntered
        // TODO add your handling code here:
        panelFood.setBackground(new java.awt.Color(234, 124, 105));
    }//GEN-LAST:event_panelFoodMouseEntered

    private void panelFoodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFoodMouseExited
        // TODO add your handling code here:
        panelFood.setBackground(new java.awt.Color(31, 29, 43));
    }//GEN-LAST:event_panelFoodMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited

    public void setOrders(ArrayList<Mon> orders) {
        this.orders = orders;
    }

    public void setList_Quantity(ArrayList<Integer> list_Quantity) {
        this.list_Quantity = list_Quantity;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnFood;
    private javax.swing.JLabel jLabelGia;
    private javax.swing.JLabel jLabelTen;
    private component.PanelRound panelFood;
    // End of variables declaration//GEN-END:variables
}
