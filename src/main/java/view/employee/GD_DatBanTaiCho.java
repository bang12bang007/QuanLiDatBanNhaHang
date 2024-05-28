/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.employee;

import component.Loading;
import component.MyButton;
import component.OrderCard;
import component.ScrollBarCustom;
import component.WrapLayout;
import dao.IBanDAO;
import dao.IChiTietHoaDonDAO;
import dao.IHoaDonDAO;
import dao.imlp.BanDAO;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import entity.Ban;
import entity.HoaDon;
import entity.NhanVien;
import icon.FontAwesome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

import jiconfont.swing.IconFontSwing;

import javax.swing.*;

import static utils.AppUtils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import raven.toast.Notifications;
import utils.AppUtils;

/**
 * @author Laptop
 */
public class GD_DatBanTaiCho extends javax.swing.JPanel {

    /**
     * Creates new form GD_Order
     */
    private JPanel mainPanel;
    private NhanVien nv;
    private IHoaDonDAO hoaDonDAO = new HoaDonDAO();
    private IBanDAO banDAO = new BanDAO();
    private List<HoaDon> hoadons;
    private IChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    private boolean waitForPayment = true;
    private List<JButton> tabs = new ArrayList<>();

    public GD_DatBanTaiCho(JPanel main, NhanVien nv) {
        this.mainPanel = main;

        initComponents();

        txtMaBan.setBackground(new Color(0, 0, 0, 1));
        filterBan.setBackground(new Color(0, 0, 0, 0));
        filterBan.getEditor().getEditorComponent().setBackground(new Color(0, 0, 0, 0));
        filterBan.getEditor().getEditorComponent().setForeground(Color.WHITE);
        this.main.setLayout(new WrapLayout(FlowLayout.LEADING, 52, 20));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        IconFontSwing.register(FontAwesome.getIconFont());
        iconSearch.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 20, Color.WHITE));
        btnDown.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_DOWN, 10, Color.WHITE));
        btnUp.setIcon(IconFontSwing.buildIcon(FontAwesome.CHEVRON_UP, 10, Color.WHITE));
        btnDD.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_DOUBLE_DOWN, 20, Color.WHITE));
        btnDU.setIcon(IconFontSwing.buildIcon(FontAwesome.ANGLE_DOUBLE_UP, 20, Color.WHITE));
        tabs.add(btnCheckout);
        tabs.add(btnReserve);
        tabs.add(btnSaveTemple);
        loadData();
        setupKeyBindings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCheckout = new component.MyButton();
        btnReserve = new component.MyButton();
        panelRound2 = new component.PanelRound();
        txtMaBan = new javax.swing.JTextField();
        iconSearch = new javax.swing.JLabel();
        panelRound3 = new component.PanelRound();
        filterBan = new component.ComboBoxSuggestion();
        myButton1 = new component.MyButton();
        btnSaveTemple = new component.MyButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        orderNumber = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDU = new component.MyButton();
        btnDD = new component.MyButton();
        btnDown = new component.MyButton();
        btnUp = new component.MyButton();
        scroll = new javax.swing.JScrollPane();
        main = new javax.swing.JPanel();

        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(31, 29, 43));
        jPanel1.setToolTipText("");

        btnCheckout.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckout.setText("Chờ thanh toán (0)");
        btnCheckout.setColor(new java.awt.Color(83, 86, 99));
        btnCheckout.setColorClick(new java.awt.Color(234, 124, 105));
        btnCheckout.setColorOver(new java.awt.Color(234, 124, 105));
        btnCheckout.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        btnCheckout.setRadius(8);
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        btnReserve.setForeground(new java.awt.Color(255, 255, 255));
        btnReserve.setText("Đặt trước (0)");
        btnReserve.setToolTipText("");
        btnReserve.setColor(new java.awt.Color(83, 86, 99));
        btnReserve.setColorClick(new java.awt.Color(234, 124, 105));
        btnReserve.setColorOver(new java.awt.Color(234, 124, 105));
        btnReserve.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        btnReserve.setRadius(8);
        btnReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });

        panelRound2.setBackground(new java.awt.Color(83, 86, 99));
        panelRound2.setRoundBottomLeft(8);
        panelRound2.setRoundBottomRight(8);
        panelRound2.setRoundTopLeft(8);
        panelRound2.setRoundTopRight(8);

        txtMaBan.setBackground(new java.awt.Color(83, 86, 99));
        txtMaBan.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        txtMaBan.setForeground(new java.awt.Color(255, 255, 255));
        txtMaBan.setBorder(null);
        txtMaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBanActionPerformed(evt);
            }
        });
        txtMaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaBanKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(0, 202, Short.MAX_VALUE)
                .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound2Layout.createSequentialGroup()
                    .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelRound3.setBackground(new java.awt.Color(83, 86, 99));
        panelRound3.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        panelRound3.setRoundBottomLeft(8);
        panelRound3.setRoundBottomRight(8);
        panelRound3.setRoundTopLeft(8);
        panelRound3.setRoundTopRight(8);

        filterBan.setBorder(null);
        filterBan.setForeground(new java.awt.Color(255, 255, 255));
        filterBan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tìm bàn" }));
        filterBan.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        filterBan.setOpaque(false);
        filterBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterBan, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterBan, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        myButton1.setBackground(new java.awt.Color(83, 86, 99));
        myButton1.setForeground(new java.awt.Color(255, 255, 255));
        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        myButton1.setText("Gọi món");
        myButton1.setColor(new java.awt.Color(83, 86, 99));
        myButton1.setColorClick(new java.awt.Color(234, 124, 105));
        myButton1.setColorOver(new java.awt.Color(234, 124, 105));
        myButton1.setFont(utils.AppUtils.getFont(14f, _BOLD_)
        );
        myButton1.setIconTextGap(15);
        myButton1.setRadius(10);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        btnSaveTemple.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveTemple.setText("Lưu tạm (0)");
        btnSaveTemple.setToolTipText("");
        btnSaveTemple.setColor(new java.awt.Color(83, 86, 99));
        btnSaveTemple.setColorClick(new java.awt.Color(234, 124, 105));
        btnSaveTemple.setColorOver(new java.awt.Color(234, 124, 105));
        btnSaveTemple.setFont(utils.AppUtils.getFont(14f, _NORMAL_)
        );
        btnSaveTemple.setRadius(8);
        btnSaveTemple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTempleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveTemple, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSaveTemple, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(31, 29, 43));

        jLabel1.setFont(utils.AppUtils.getFont(16f, _ITALIC_)
        );
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tổng số order: ");

        orderNumber.setFont(utils.AppUtils.getFont(16f, _ITALIC_)
        );
        orderNumber.setForeground(new java.awt.Color(255, 255, 255));
        orderNumber.setText("3");

        jLabel2.setFont(utils.AppUtils.getFont(16f, _ITALIC_)
        );
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thêm Order: F2 hoặc ALT + T");

        btnDU.setForeground(new java.awt.Color(255, 255, 255));
        btnDU.setColor(new java.awt.Color(83, 86, 99));
        btnDU.setColorClick(new java.awt.Color(234, 124, 105));
        btnDU.setColorOver(new java.awt.Color(234, 124, 105));
        btnDU.setRadius(8);
        btnDU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDUActionPerformed(evt);
            }
        });

        btnDD.setForeground(new java.awt.Color(255, 255, 255));
        btnDD.setColor(new java.awt.Color(83, 86, 99));
        btnDD.setColorClick(new java.awt.Color(234, 124, 105));
        btnDD.setColorOver(new java.awt.Color(234, 124, 105));
        btnDD.setRadius(8);
        btnDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDDActionPerformed(evt);
            }
        });

        btnDown.setForeground(new java.awt.Color(255, 255, 255));
        btnDown.setColor(new java.awt.Color(83, 86, 99));
        btnDown.setColorClick(new java.awt.Color(234, 124, 105));
        btnDown.setColorOver(new java.awt.Color(234, 124, 105));
        btnDown.setRadius(8);
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnUp.setForeground(new java.awt.Color(255, 255, 255));
        btnUp.setColor(new java.awt.Color(83, 86, 99));
        btnUp.setColorClick(new java.awt.Color(234, 124, 105));
        btnUp.setColorOver(new java.awt.Color(234, 124, 105));
        btnUp.setRadius(8);
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnDD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnDU, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(orderNumber)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDU, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        scroll.setBorder(null);

        main.setBackground(new java.awt.Color(83, 86, 99));
        main.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1288, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        scroll.setViewportView(main);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setupKeyBindings() {
        InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = mainPanel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.ALT_DOWN_MASK), "ALT_T");

        actionMap.put("F2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.AppUtils.setUI(mainPanel, () -> new GD_Ban(mainPanel, "DAT_MON"));
                repaint();
                revalidate();
            }
        });

        actionMap.put("ALT_T", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.AppUtils.setUI(mainPanel, () -> new GD_Ban(mainPanel, "DAT_MON"));
                repaint();
                revalidate();
            }
        });
    }

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        setWaitForPayment(true);
        showOrderByState(utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN);
        setActiveTab(evt);
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveActionPerformed
        setWaitForPayment(false);
        showOrderByState(utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC);
        setActiveTab(evt);
    }//GEN-LAST:event_btnReserveActionPerformed

    private void txtMaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaBanActionPerformed

    private void btnDUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDUActionPerformed
        // TODO add your handling code here:
        scroll.getVerticalScrollBar().setValue(0);
    }//GEN-LAST:event_btnDUActionPerformed

    private void btnDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDDActionPerformed
        // TODO add your handling code here:
        int max = scroll.getVerticalScrollBar().getMaximum();
        scroll.getVerticalScrollBar().setValue(max);
    }//GEN-LAST:event_btnDDActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        // TODO add your handling code here:
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getValue() + 30);
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        // TODO add your handling code here:
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getValue() - 30);
    }//GEN-LAST:event_btnUpActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        utils.AppUtils.setUI(mainPanel, () -> new GD_Ban(mainPanel, "DAT_MON"));
        repaint();
        revalidate();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void filterBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBanActionPerformed
        // TODO add your handling code here:
        filterByBan(filterBan.getSelectedItem() + "");
    }//GEN-LAST:event_filterBanActionPerformed

    private void btnSaveTempleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTempleActionPerformed
        // TODO add your handling code here:
        showOrderByState(utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN);
        setActiveTab(evt);
    }//GEN-LAST:event_btnSaveTempleActionPerformed

    private void txtMaBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaBanKeyReleased
        // TODO add your handling code here:
        main.removeAll();
        for (HoaDon hoaDon : hoadons) {
            if (AppUtils.CheckContainsAbbreviation(hoaDon.getBan().getMaBan(), txtMaBan.getText().trim())) {
                OrderCard orderCard = new OrderCard(hoaDon, mainPanel);
                orderCard.setToTal(chiTietHoaDonDAO.TotalFoodCurrency(hoaDon));
                orderCard.setQl_datMon(this);
                main.add(orderCard);
            }
        }
        main.repaint();
        main.revalidate();
    }//GEN-LAST:event_txtMaBanKeyReleased

    public void loadOrdering() {
        hoadons = hoaDonDAO.findOnOrder();
//        filterBan.removeAllItems();
        ArrayList<String> list = new ArrayList<>();
        list.add("Tìm bàn");
        for (HoaDon hoaDon : hoadons) {
            list.add(hoaDon.getBan().getMaBan());
            OrderCard orderCard = new OrderCard(hoaDon, mainPanel);
            orderCard.setToTal(chiTietHoaDonDAO.TotalFoodCurrency(hoaDon));
            orderCard.setQl_datMon(this);
            main.add(orderCard);
        }
        filterBan.setModel(new DefaultComboBoxModel<>(new Vector<>(list)));
        main.repaint();
        main.revalidate();
    }

    private void showOrderByState(Enum e) {
        main.removeAll();
        Loading loading = new Loading();
        main.setLayout(new BorderLayout());
        main.add(loading, BorderLayout.CENTER);
        main.repaint();
        main.revalidate();
        GD_DatBanTaiCho ql_datMon = this;
        SwingWorker<List<OrderCard>, Void> worker = new SwingWorker<List<OrderCard>, Void>() {
            @Override
            protected List<OrderCard> doInBackground() throws Exception {
                List<OrderCard> listOrderCard = new ArrayList<>();
                hoadons = hoaDonDAO.findByState(e);
                ArrayList<String> list = new ArrayList<>();
                list.add("Tìm bàn");
                for (HoaDon hoaDon : hoadons) {
                    list.add(hoaDon.getBan().getMaBan());
                    OrderCard orderCard = new OrderCard(hoaDon, mainPanel);
                    orderCard.setToTal(chiTietHoaDonDAO.TotalFoodCurrency(hoaDon));
                    orderCard.setQl_datMon(ql_datMon);
                    listOrderCard.add(orderCard);
                }
                filterBan.setModel(new DefaultComboBoxModel<>(new Vector<>(list)));
                return listOrderCard;
            }

            @Override
            protected void done() {
                try {
                    List<OrderCard> listOrderCard = get();
                    main.removeAll();
                    main.setLayout(new WrapLayout(FlowLayout.LEADING, 52, 20));
                    for (OrderCard orderCard : listOrderCard) {
                        main.add(orderCard);
                    }
                    main.repaint();
                    main.revalidate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        worker.execute();
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    private void filterByBan(String maBan) {
        main.removeAll();
        boolean isMaBan = maBan.equals("Tìm bàn") ? false : true;
        for (HoaDon hoaDon : hoadons) {
            if (isMaBan) {
                if (hoaDon.getBan().getMaBan().equals(maBan)) {
                    OrderCard orderCard = new OrderCard(hoaDon, mainPanel);
                    orderCard.setToTal(chiTietHoaDonDAO.TotalFoodCurrency(hoaDon));
                    orderCard.setQl_datMon(this);
                    main.add(orderCard);
                }
            } else {
                OrderCard orderCard = new OrderCard(hoaDon, mainPanel);
                orderCard.setToTal(chiTietHoaDonDAO.TotalFoodCurrency(hoaDon));
                orderCard.setQl_datMon(this);
                main.add(orderCard);
            }
        }
        main.repaint();
        main.revalidate();
    }

    public boolean isWaitForPayment() {
        return waitForPayment;
    }

    public void setWaitForPayment(boolean waitForPayment) {
        this.waitForPayment = waitForPayment;
    }

    private void loadData() {
        loadOrdering();
        setInitActive(tabs.get(0));
        setTextBtns(btnCheckout, utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN, "Chờ thanh toán (");
        setTextBtns(btnReserve, utils.Enum.LoaiTrangThaiHoaDon.DAT_TRUOC, "Đặt trước (");
        setTextBtns(btnSaveTemple, utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN, "Lưu tạm (");
        orderNumber.setText(hoaDonDAO.findByState(utils.Enum.LoaiTrangThaiHoaDon.CHUA_THANH_TOAN).size() + "");
    }

    private void setTextBtns(JButton btn, Enum e, String content) {
        int count = hoaDonDAO.findByState(e).size();
        content += count + ")";
        btn.setText(content);
    }

    private void setActiveTab(ActionEvent e) {
        Color transparent = new Color(83, 86, 99);
        Color activeColor = new Color(234, 124, 105);
        for (JButton button : tabs) {
            boolean isButton = e.getSource().equals(button);
            ((MyButton) button).setColor(isButton ? activeColor : transparent);
        }
    }

    private void setInitActive(JButton button) {
        ActionEvent fakeEvent = new ActionEvent(button, ActionEvent.ACTION_PERFORMED, "");
        setActiveTab(fakeEvent);
    }

    public void cutInvoice(HoaDon hoaDon) {
        boolean isSuccess = false;
        List<Ban> listBan = banDAO.findAll(Ban.class);
        for (Ban ban : listBan) {
            if (ban.getOldBanGop() != null && !ban.getOldBanGop().equals("null,") && !ban.getOldBanGop().equals("null")) {
                List<String> oldBanGops = new ArrayList<>(Arrays.asList(ban.getOldBanGop().split(",")));
                List<Integer> oldStates = new ArrayList<>();
                String[] oldStateStrings = ban.getOldState().split(",");
                for (String stateString : oldStateStrings) {
                    oldStates.add(Integer.parseInt(stateString));
                }
                int lastIndex = oldBanGops.size() - 1;
                List<String> oldHoaDonAndBanGop = new ArrayList<>(Arrays.asList(oldBanGops.get(lastIndex).split("-")));
                if (oldHoaDonAndBanGop.get(0).equals(hoaDon.getMaHoaDon()) || oldHoaDonAndBanGop.get(0).equals("")) {
                    ban.setBanGop((Ban) banDAO.findById(oldHoaDonAndBanGop.get(1), Ban.class));
                    ban.setTrangThai(utils.Enum.LoaiTrangThai.values()[oldStates.get(lastIndex)]);
                    oldBanGops.remove(oldBanGops.size() - 1);
                    oldStates.remove(oldStates.size() - 1);
                    String oldBanGop = oldBanGops.size() > 0 ? String.join(",", oldBanGops) : null;
                    String oldState = oldStates.size() > 0 ? (oldStates.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(",")))
                            : null;
                    ban.setOldBanGop(!oldBanGop.endsWith(",") ? oldBanGop + "," : oldBanGop);
                    ban.setOldState(!oldState.endsWith(",") ? oldState + "," : oldState);
                    hoaDon.setBan((Ban) banDAO.findById(oldHoaDonAndBanGop.get(1), Ban.class));
                    isSuccess = true;
                }
                banDAO.update(ban);
                hoaDonDAO.update(hoaDon);
            }
        }
        if (!isSuccess) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 1000, "Đây là hóa đơn gốc");
        } else {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 1500, "Khôi phục hóa đơn thành công!");
        }
    }

    public boolean canMoveTable(HoaDon hoaDon) {
        return hoaDon.getBan().getBanGop() == null ? false : true;
    }

    public Double getTienPhaiThu(HoaDon hoaDon) {
        double result = 0;
        List<HoaDon> hoaDons = hoaDonDAO.getListHoaDonGhep(hoaDon, utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN);
        for (HoaDon hd : hoaDons) {
            result += hd.getTienPhaiThu();
        }
        return result;
    }

    public List<HoaDon> getHoaDons(HoaDon hoaDon) {
        List<HoaDon> hoaDons = hoaDonDAO.getListHoaDonGhep(hoaDon, utils.Enum.LoaiTrangThaiHoaDon.CHO_THANH_TOAN);
        return hoaDons;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnCheckout;
    private component.MyButton btnDD;
    private component.MyButton btnDU;
    private component.MyButton btnDown;
    private component.MyButton btnReserve;
    private component.MyButton btnSaveTemple;
    private component.MyButton btnUp;
    private component.ComboBoxSuggestion filterBan;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel main;
    private component.MyButton myButton1;
    private javax.swing.JLabel orderNumber;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound3;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txtMaBan;
    // End of variables declaration//GEN-END:variables

}
