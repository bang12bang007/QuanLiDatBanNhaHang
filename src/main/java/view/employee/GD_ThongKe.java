/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.employee;


import dao.imlp.HoaDonDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.JFrame;
import org.jfree.data.general.DefaultPieDataset;

import static utils.AppUtils.*;

import entity.HoaDon;
import entity.ChiTietHoaDon;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.util.Rotation;
import java.awt.Color;
import java.util.List;
import component.ModelChart;
import raven.chart.CurveLineChart;

/**
 * @author quanvo
 */
public class GD_ThongKe extends javax.swing.JPanel {

    private JFrame jFrame;
    private List<HoaDon> hoaDon;
    private ChiTietHoaDon info;
    private HoaDonDAO hd_Dao;
    private component.CurveLineChart chart;
    /**
     * Creates new form GD_ThongKe
     */

    public GD_ThongKe() {
        initComponents();
        Color cus = new Color(83, 86, 99);
        Color cus1 = new Color(255, 255, 255);
        hd_Dao = new HoaDonDAO();

//      pieChart3D
        jLabel5.setText(hd_Dao.getFormatter().format(hd_Dao.getTongDoanhThu(NHANVIEN)+5000000));
        jLabel8.setText(Integer.toString(hd_Dao.getTongHoaDon(NHANVIEN)));
        jLabel6.setText(hd_Dao.getFormatter().format(hd_Dao.getTongDoanhThu(NHANVIEN)));
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart3D("BaoCao", dataset, true, true, false);
        dataset.setValue("Nhân Viên",(hd_Dao.getTongDoanhThu(NHANVIEN)));
        dataset.setValue("Nhà Hàng", (hd_Dao.getTongDoanhThu(NHANVIEN)+5000000));
        PiePlot3D P = (PiePlot3D) chart.getPlot();
        P.setLabelFont(utils.AppUtils.getFont(20f, _BOLD_));
        P.setBackgroundPaint(Color.white);
        P.setLabelPaint(cus);
        P.setStartAngle(ABORT);
        P.setDirection(Rotation.CLOCKWISE);
        P.setForegroundAlpha(0.7f);
        TextTitle title = chart.getTitle();
        title.setPaint(Color.WHITE);
        jLabel5.setText(hd_Dao.getFormatter().format(hd_Dao.getTongDoanhThu(NHANVIEN) + 5000000));
        jLabel8.setText(Integer.toString(hd_Dao.getTongHoaDon(NHANVIEN)));
        jLabel6.setText(hd_Dao.getFormatter().format(hd_Dao.getTongDoanhThu(NHANVIEN)));
//        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Doanh thu nhân viên", (hd_Dao.getTongDoanhThu(NHANVIEN)));
        dataset.setValue("Tổng doanh thu", (hd_Dao.getTongDoanhThu(NHANVIEN) + 5000000));
        dataset.setValue("Hóa đơn", (hd_Dao.getTongHoaDon(NHANVIEN)));
        P.setLabelPaint(new Color(0, 0, 0));
        chart.setBackgroundPaint(cus1);
        ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setSize(250, 200);
        jPanel2.add(chartpanel);
        LocalDate time = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        jLabel4.setText(df.format(time));
//        CurveLineChart line = new CurveLineChart();
//        LineChart
        curveLineChart1.addLegend("Doanh Thu", Color.decode("#7b4397"), Color.decode("#dc2430"));
        curveLineChart1.addLegend("Hoá đơn", Color.decode("#e65c00"), Color.decode("#F9D423"));
        curveLineChart1.addLegend("Tổng số món ăn", Color.decode("#0099F7"), Color.decode("#F11712"));
        double[] amountTotal = {300}; // Dữ liệu cho "Amount"
        double[] amountBill = {0};     // Dữ liệu cho "Cost"
        double[] amountFood = {50};     // Dữ liệu cho "Profit"

// Thêm dữ liệu vào biểu đồ
        curveLineChart1.addData(new ModelChart("Doanh Thu", amountTotal));
        curveLineChart1.addData(new ModelChart("Hoá đơn", amountBill));
        curveLineChart1.addData(new ModelChart("Món ăn", amountFood));
        panelShadow1.add(curveLineChart1);
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new component.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        panelRound2 = new component.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelRound4 = new component.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelRound5 = new component.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelShadow1 = new component.PanelShadow();
        curveLineChart1 = new component.CurveLineChart();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(31, 29, 43));

        panelRound1.setBackground(new java.awt.Color(83, 86, 99));
        panelRound1.setForeground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(31, 29, 43));

        panelRound2.setBackground(new java.awt.Color(83, 86, 99));
        panelRound2.setPreferredSize(new java.awt.Dimension(237, 94));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        jLabel1.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TỔNG TIỀN KÉT CA");

        jLabel5.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound2Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(25, 25, 25)))
        );
        panelRound2Layout.setVerticalGroup(
                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(68, 68, 68))
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addGap(30, 30, 30)))
        );
        panelRound4.setBackground(new java.awt.Color(102, 102, 102));
        panelRound4.setPreferredSize(new java.awt.Dimension(237, 94));

        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        jLabel3.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TỔNG DOANH THU");

        jLabel6.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
                panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound4Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(68, 68, 68))
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound4Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(36, 36, 36)))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(68, 68, 68))
            .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound4Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGap(30, 30, 30)))
        );

        panelRound5.setBackground(new java.awt.Color(83, 86, 99));
        panelRound5.setPreferredSize(new java.awt.Dimension(237, 94));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel7.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TỔNG HOÁ ĐƠN");

        jLabel8.setFont(utils.AppUtils.getFont(20f, _NORMAL_)
        );
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
                panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound5Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound5Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(25, 25, 25)))
        );
        panelRound5Layout.setVerticalGroup(
                panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(68, 68, 68))
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound5Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addGap(30, 30, 30)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(83, 86, 99));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        panelShadow1.setBackground(new java.awt.Color(32, 37, 44));
        panelShadow1.setColorGradient(new java.awt.Color(27, 40, 55));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, 0)

                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(utils.AppUtils.getFont(20f, _ITALIC_)
        );
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thời gian làm việc:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(utils.AppUtils.getFont(20f, _ITALIC_)
        );
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(753, 753, 753))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)));
    }// </editor-fold>//GEN-END:initComponents
//    private void initCompoment(){
//        panelShadow1 = new component.PanelShadow();
//        component.CurveLineChart charta = new component.CurveLineChart();
//        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
//        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));
//        
//        chart.setForeground(new java.awt.Color(237, 237, 237));
//        chart.setFillColor(true);
//            javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
//        panelShadow1.setLayout(panelShadow1Layout);
//        panelShadow1Layout.setHorizontalGroup(
//            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//         panelShadow1Layout.setVerticalGroup(
//            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(panelShadow1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//
//        pack();
//        setLocationRelativeTo(null);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.CurveLineChart curveLineChart1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound2;
    private component.PanelRound panelRound4;
    private component.PanelRound panelRound5;
    private component.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
