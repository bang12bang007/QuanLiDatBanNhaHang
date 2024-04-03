/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import component.MenuItem;
import component.ScrollBarCustom;
import component.WrapLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 *
 * @author Laptop
 */
public class Form_XemThucDon extends javax.swing.JPanel {

    /**
     * Creates new form Form_XemThucDon
     */
    private JFrame jFrame;
    private ArrayList<MenuItem> listHuy = new ArrayList<>();

    public Form_XemThucDon(JFrame jFrame) {
        this.jFrame = jFrame;
        initComponents();
        setBackground(new Color(0, 0, 0, 0.8f));
        wrapper.setBackground(new Color(0, 0, 0, 0));
        tableBody.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        tableScrollLeft.setVerticalScrollBar(new ScrollBarCustom());
        tableScrollLeft.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        tableBodyRight.setLayout(new WrapLayout(FlowLayout.LEADING, 0, 0));
        tableScrollRight.setVerticalScrollBar(new ScrollBarCustom());
        tableScrollRight.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        FirstTimeLoadItem();
    }

    private void FirstTimeLoadItem() {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thêm mã để kích hoạt action listener tại đây
                loadData();
                tableBody.repaint();
                tableBody.revalidate();
            }
        });
        timer.setRepeats(false); // Chỉ chạy một lần sau 5 giây
        timer.start();
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
        header = new component.PanelRound();
        title = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        leftContainer = new javax.swing.JPanel();
        table = new component.PanelRound();
        headerTable = new component.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tableScrollLeft = new javax.swing.JScrollPane();
        tableBody = new javax.swing.JPanel();
        btnUpTable = new component.MyButton();
        btnDownTable = new component.MyButton();
        panelRound1 = new component.PanelRound();
        panelRound2 = new component.PanelRound();
        rightContainer = new javax.swing.JPanel();
        tableRight = new component.PanelRound();
        headerTableRight = new component.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tableScrollRight = new javax.swing.JScrollPane();
        tableBodyRight = new javax.swing.JPanel();
        btnUpTable1 = new component.MyButton();
        btnDownTable1 = new component.MyButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelRound5 = new component.PanelRound();
        footer = new component.PanelRound();
        btnDongY = new component.MyButton();
        btnHuy = new component.MyButton();

        header.setBackground(new java.awt.Color(31, 29, 43));
        header.setRoundTopLeft(8);
        header.setRoundTopRight(8);

        title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Xem thực đơn");

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
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(title)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        container.setBackground(new java.awt.Color(83, 86, 99));

        leftContainer.setBackground(new java.awt.Color(83, 86, 99));

        table.setRoundBottomLeft(8);
        table.setRoundBottomRight(8);
        table.setRoundTopLeft(8);
        table.setRoundTopRight(8);

        headerTable.setBackground(new java.awt.Color(31, 29, 43));
        headerTable.setRoundTopLeft(8);
        headerTable.setRoundTopRight(8);
        headerTable.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Món");
        headerTable.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đơn giá");
        headerTable.add(jLabel2);

        tableScrollLeft.setBackground(new java.awt.Color(83, 86, 99));
        tableScrollLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableBody.setBackground(new java.awt.Color(83, 86, 99));

        javax.swing.GroupLayout tableBodyLayout = new javax.swing.GroupLayout(tableBody);
        tableBody.setLayout(tableBodyLayout);
        tableBodyLayout.setHorizontalGroup(
            tableBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );
        tableBodyLayout.setVerticalGroup(
            tableBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        tableScrollLeft.setViewportView(tableBody);

        javax.swing.GroupLayout tableLayout = new javax.swing.GroupLayout(table);
        table.setLayout(tableLayout);
        tableLayout.setHorizontalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tableScrollLeft)
        );
        tableLayout.setVerticalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableLayout.createSequentialGroup()
                .addComponent(headerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableScrollLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
        );

        btnUpTable.setForeground(new java.awt.Color(255, 255, 255));
        btnUpTable.setColor(new java.awt.Color(31, 29, 43));
        btnUpTable.setColorClick(new java.awt.Color(234, 124, 105));
        btnUpTable.setColorOver(new java.awt.Color(234, 124, 105));
        btnUpTable.setRadius(8);
        btnUpTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpTableActionPerformed(evt);
            }
        });

        btnDownTable.setForeground(new java.awt.Color(255, 255, 255));
        btnDownTable.setColor(new java.awt.Color(31, 29, 43));
        btnDownTable.setColorClick(new java.awt.Color(234, 124, 105));
        btnDownTable.setColorOver(new java.awt.Color(234, 124, 105));
        btnDownTable.setRadius(8);
        btnDownTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownTableActionPerformed(evt);
            }
        });

        panelRound1.setRoundBottomLeft(8);
        panelRound1.setRoundBottomRight(8);
        panelRound1.setRoundTopLeft(8);
        panelRound1.setRoundTopRight(8);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelRound2.setRoundBottomLeft(8);
        panelRound2.setRoundBottomRight(8);
        panelRound2.setRoundTopLeft(8);
        panelRound2.setRoundTopRight(8);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout leftContainerLayout = new javax.swing.GroupLayout(leftContainer);
        leftContainer.setLayout(leftContainerLayout);
        leftContainerLayout.setHorizontalGroup(
            leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftContainerLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftContainerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDownTable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftContainerLayout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        leftContainerLayout.setVerticalGroup(
            leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDownTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        rightContainer.setBackground(new java.awt.Color(83, 86, 99));

        tableRight.setRoundBottomLeft(8);
        tableRight.setRoundBottomRight(8);
        tableRight.setRoundTopLeft(8);
        tableRight.setRoundTopRight(8);

        headerTableRight.setBackground(new java.awt.Color(31, 29, 43));
        headerTableRight.setRoundTopLeft(8);
        headerTableRight.setRoundTopRight(8);
        headerTableRight.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("   Món");
        headerTableRight.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Số lượng   ");
        headerTableRight.add(jLabel4);

        tableScrollRight.setBackground(new java.awt.Color(83, 86, 99));
        tableScrollRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableBodyRight.setBackground(new java.awt.Color(83, 86, 99));

        javax.swing.GroupLayout tableBodyRightLayout = new javax.swing.GroupLayout(tableBodyRight);
        tableBodyRight.setLayout(tableBodyRightLayout);
        tableBodyRightLayout.setHorizontalGroup(
            tableBodyRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );
        tableBodyRightLayout.setVerticalGroup(
            tableBodyRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        tableScrollRight.setViewportView(tableBodyRight);

        javax.swing.GroupLayout tableRightLayout = new javax.swing.GroupLayout(tableRight);
        tableRight.setLayout(tableRightLayout);
        tableRightLayout.setHorizontalGroup(
            tableRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerTableRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tableScrollRight)
        );
        tableRightLayout.setVerticalGroup(
            tableRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableRightLayout.createSequentialGroup()
                .addComponent(headerTableRight, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableScrollRight, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
        );

        btnUpTable1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpTable1.setColor(new java.awt.Color(31, 29, 43));
        btnUpTable1.setColorClick(new java.awt.Color(234, 124, 105));
        btnUpTable1.setColorOver(new java.awt.Color(234, 124, 105));
        btnUpTable1.setRadius(8);
        btnUpTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpTable1ActionPerformed(evt);
            }
        });

        btnDownTable1.setForeground(new java.awt.Color(255, 255, 255));
        btnDownTable1.setColor(new java.awt.Color(31, 29, 43));
        btnDownTable1.setColorClick(new java.awt.Color(234, 124, 105));
        btnDownTable1.setColorOver(new java.awt.Color(234, 124, 105));
        btnDownTable1.setRadius(8);
        btnDownTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownTable1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("498.000");

        javax.swing.GroupLayout rightContainerLayout = new javax.swing.GroupLayout(rightContainer);
        rightContainer.setLayout(rightContainerLayout);
        rightContainerLayout.setHorizontalGroup(
            rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableRight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightContainerLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(87, 87, 87)
                        .addComponent(btnUpTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDownTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        rightContainerLayout.setVerticalGroup(
            rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightContainerLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(tableRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnDownTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightContainerLayout.createSequentialGroup()
                        .addGroup(rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Yêu cầu đặt món");

        panelRound5.setRoundBottomLeft(8);
        panelRound5.setRoundBottomRight(8);
        panelRound5.setRoundTopLeft(8);
        panelRound5.setRoundTopRight(8);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(leftContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(rightContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rightContainer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftContainer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        footer.setBackground(new java.awt.Color(31, 29, 43));
        footer.setRoundBottomLeft(8);
        footer.setRoundBottomRight(8);

        btnDongY.setForeground(new java.awt.Color(255, 255, 255));
        btnDongY.setText("ĐỒNG Ý");
        btnDongY.setColor(new java.awt.Color(83, 86, 99));
        btnDongY.setColorClick(new java.awt.Color(234, 124, 105));
        btnDongY.setColorOver(new java.awt.Color(234, 124, 105));
        btnDongY.setRadius(8);
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
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
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(99, 99, 99))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDongYActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnUpTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpTableActionPerformed

    private void btnDownTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDownTableActionPerformed

    private void btnUpTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpTable1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpTable1ActionPerformed

    private void btnDownTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownTable1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDownTable1ActionPerformed

    private void loadData() {
        int width = tableBody.getWidth();
        ArrayList<String[]> list = new ArrayList<>();
        list.add(new String[]{"Cơm sườn", "100.000"});
        list.add(new String[]{"Phở bò", "85.000"});
        list.add(new String[]{"Gà nướng", "120.000"});
        list.add(new String[]{"Bánh mì thịt", "25.000"});
        list.add(new String[]{"Bún chả", "90.000"});
        list.add(new String[]{"Bò né", "150.000"});
        list.add(new String[]{"Hủ tiếu", "70.000"});
        list.add(new String[]{"Bánh xèo", "110.000"});
        list.add(new String[]{"Bún riêu", "80.000"});
        list.add(new String[]{"Cơm chiên dương châu", "95.000"});
        list.add(new String[]{"Hamburger", "70.000"});

        for (int i = 0; i < list.size(); i++) {
            MenuItem menuItem = new MenuItem(width, list.get(i));
            menuItem.setForm(this);
            menuItem.setType("THEM_MON");
            tableBody.add(menuItem);
        }
    }

    public void themMon(MenuItem menuItem) {
        int index = getIndex(menuItem);
        if (index < 0) {
            listHuy.add(menuItem);
        } else {
            String quatity = (Integer.parseInt(listHuy.get(index).getData()[1]) + 1) + "";
            String[] dataAfterUpdateQuantity = new String[]{menuItem.getData()[0], quatity};
            listHuy.get(index).setData(dataAfterUpdateQuantity);
        }
        tableBodyRight.removeAll();
        for (MenuItem item : listHuy) {
            item.setType("HUY_MON");
            item.setForm(this);
            tableBodyRight.add(item);
        }
        tableBodyRight.repaint();
        tableBodyRight.revalidate();
        tableBody.repaint();
        tableBody.revalidate();
    }

    public void huyMon(MenuItem menuItem) {
        listHuy.remove(menuItem);
        tableBodyRight.removeAll();
        for (MenuItem item : listHuy) {
            tableBodyRight.add(item);
        }
        tableBodyRight.repaint();
        tableBodyRight.revalidate();
    }

    private int getIndex(MenuItem menuItem) {
        int index = -1;
        for (int i = 0; i < listHuy.size(); i++) {
            if (menuItem.getData()[0].equals(listHuy.get(i).getData()[0])) {
                return i;
            }
        }
        return index;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnDongY;
    private component.MyButton btnDownTable;
    private component.MyButton btnDownTable1;
    private component.MyButton btnHuy;
    private component.MyButton btnUpTable;
    private component.MyButton btnUpTable1;
    private javax.swing.JPanel container;
    private component.PanelRound footer;
    private component.PanelRound header;
    private component.PanelRound headerTable;
    private component.PanelRound headerTableRight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel leftContainer;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound5;
    private javax.swing.JPanel rightContainer;
    private component.PanelRound table;
    private javax.swing.JPanel tableBody;
    private javax.swing.JPanel tableBodyRight;
    private component.PanelRound tableRight;
    private javax.swing.JScrollPane tableScrollLeft;
    private javax.swing.JScrollPane tableScrollRight;
    private javax.swing.JLabel title;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables
}
