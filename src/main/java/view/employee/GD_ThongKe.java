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
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.util.Rotation;
import java.awt.Color;
import java.util.List;
import component.ModelChart;

/**
 * @author quanvo
 */
public class GD_ThongKe extends javax.swing.JPanel {

    private JFrame jFrame;
    private List<HoaDon> hoaDon;
    private HoaDonDAO hd_Dao;
    private String trangThai;

    /**
     * Creates new form GD_ThongKe
     */
    private void test() {
        curveLineChart1.setTitle("Thống Kê");
//      Thống kê theo tiêu chí
        curveLineChart1.addLegend("Doanh Thu (Triệu VNĐ)", Color.decode("#7b4397"), Color.decode("#dc2430"));
        curveLineChart1.addLegend("Số Lượng Hoá đơn", Color.decode("#e65c00"), Color.decode("#F9D423"));
        curveLineChart1.addLegend("Khách hàng (Người)", Color.decode("#0099F7"), Color.decode("#F11712"));
    }

    private void setData() {
        hd_Dao = new HoaDonDAO();
        curveLineChart1.clear();
        createLineChart(7, 22);
        curveLineChart1.start();

    }

    private void createLineChart(int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
//              get HoaDon theo gio
            double totalbill = 0.0;
            double totalpeople = 0.0;
            double countbill = 0.0;
            List<HoaDon> orders = hd_Dao.findByHour(i);

            for (HoaDon order : orders) {
                totalbill += order.getTienPhaiThu() / 1000000;
                totalpeople += order.getSoLuongNguoi();
                countbill += 1;
            }
            curveLineChart1.addData(new ModelChart(i + "h", new double[]{totalbill, countbill, totalpeople}));
        }
    }

    private void set_up_UI() {
        if (NHANVIEN.isTrangThai()) {
            trangThai = "Đang làm";
        } else {
            trangThai = "Đã nghỉ";
        }
        ten.setText(NHANVIEN.getHoTen());
        mnv.setText(String.valueOf(NHANVIEN.getMaNV()));
        date.setText(String.valueOf(NHANVIEN.getNgayBatDauLam()));
        sdt.setText(NHANVIEN.getSoDienThoai());
        vaitro.setText(
                NHANVIEN.getVaiTro().equals(utils.Enum.LoaiVaiTro.NHAN_VIEN_PHUC_VU) ? "Nhân viên phục vụ" : "Nhân viên"
        );
        jLabel25.setText(trangThai);
    }

    private void danhGiaTinhTrang() {
        String sleep = "/icons/sleep.png";
        String cool = "/icons/cool.png";
        String perfect = "/icons/perfect.jpeg";
        if (hd_Dao.getTongDoanhThu(NHANVIEN) >= 50000000) {
            status.setIcon(new javax.swing.ImageIcon(getClass().getResource(perfect)));
        } else if (hd_Dao.getTongDoanhThu(NHANVIEN) >= 100000) {
            status.setIcon(new javax.swing.ImageIcon(getClass().getResource(cool)));
        } else {
            status.setIcon(new javax.swing.ImageIcon(getClass().getResource(sleep)));
        }
    }

    private void pieChart() {
        Color cus = new Color(14, 36, 51);
        Color cus1 = new Color(60, 63, 65);
        hd_Dao = new HoaDonDAO();
//        jLabel5.setText(hd_Dao.getFormatter().format(hd_Dao.getTongDoanhThu(NHANVIEN) + 5000000));
        jLabel8.setText(Integer.toString(hd_Dao.getTongHoaDon(NHANVIEN)));
        jLabel6.setText(hd_Dao.getFormatter().format(hd_Dao.getTongDoanhThu(NHANVIEN)));
        khachhang.setText(Integer.toString(hd_Dao.getSoLuongKhachHang(NHANVIEN)));
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart3D("Báo Cáo", dataset, true, true, false);
        dataset.setValue("Doanh Thu nhân viên", (hd_Dao.getTongDoanhThu(NHANVIEN)));
        dataset.setValue("Tiền đầu ca", (5000000));
        PiePlot3D P = (PiePlot3D) chart.getPlot();
        P.setLabelFont(utils.AppUtils.getFont(12f, _NORMAL_));
        P.setBackgroundPaint(cus);
        P.setLabelPaint(cus1);
        P.setStartAngle(ABORT);
        P.setDirection(Rotation.CLOCKWISE);
        P.setForegroundAlpha(0.7f);
        P.setBaseSectionPaint(cus);
        TextTitle title = chart.getTitle();
        title.setPaint(Color.WHITE);
        title.setFont(utils.AppUtils.getFont(20f, _ITALIC_));
        chart.setBackgroundPaint(cus);
        ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setSize(230, 200);
        jPanel2.add(chartpanel);
    }

    public GD_ThongKe() {
        initComponents();
//      pieChart3D
        pieChart();
        test();
        setData();
        panelShadow2.add(curveLineChart1);
        danhGiaTinhTrang();
        set_up_UI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new component.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        panelRound4 = new component.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRound5 = new component.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelRound6 = new component.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        khachhang = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelRound7 = new component.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ten = new javax.swing.JLabel();
        sdt = new javax.swing.JLabel();
        mnv = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        vaitro = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelShadow2 = new component.PanelShadow();
        curveLineChart1 = new component.CurveLineChart();

        setBackground(new java.awt.Color(31, 29, 43));

        panelRound1.setBackground(new java.awt.Color(83, 86, 99));
        panelRound1.setForeground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(31, 29, 43));

        panelRound4.setBackground(new java.awt.Color(0, 110, 211));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        jLabel3.setFont(utils.AppUtils.getFont(15f, _BOLD_)
        );
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TỔNG DOANH THU");
        jLabel3.setPreferredSize(new java.awt.Dimension(101, 17));

        jLabel6.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_moneys.png"))); // NOI18N

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelRound5.setBackground(new java.awt.Color(0, 154, 56));
        panelRound5.setPreferredSize(new java.awt.Dimension(237, 94));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel7.setFont(utils.AppUtils.getFont(15f, _BOLD_)
        );
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TỔNG HOÁ ĐƠN");

        jLabel8.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/invoice.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelRound6.setBackground(new java.awt.Color(23, 145, 194));
        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);

        jLabel4.setFont(utils.AppUtils.getFont(15f, _BOLD_)
        );
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SỐ LƯỢNG KHÁCH HÀNG");

        jLabel9.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        khachhang.setBackground(new java.awt.Color(255, 255, 255));
        khachhang.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        khachhang.setForeground(new java.awt.Color(255, 255, 255));
        khachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        khachhang.setText("jLabel1");

        jLabel11.setBackground(new java.awt.Color(255, 0, 51));
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer.png"))); // NOI18N

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound6Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 50, Short.MAX_VALUE))
                    .addGroup(panelRound6Layout.createSequentialGroup()
                        .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRound6Layout.createSequentialGroup()
                                .addComponent(khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addContainerGap())))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        );

        panelRound7.setBackground(new java.awt.Color(156, 39, 176));
        panelRound7.setRoundBottomLeft(50);
        panelRound7.setRoundBottomRight(50);
        panelRound7.setRoundTopLeft(50);
        panelRound7.setRoundTopRight(50);

        jLabel5.setFont(utils.AppUtils.getFont(15f, _BOLD_)
        );
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TRẠNG THÁI ");

        jLabel10.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        status.setBackground(new java.awt.Color(255, 255, 255));
        status.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(panelRound7Layout.createSequentialGroup()
                        .addGroup(panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(31, 29, 43));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Avatar.png"))); // NOI18N
        jLabel12.setSize(new java.awt.Dimension(49, 49));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(utils.AppUtils.getFont(20f, _BOLD_)
        );
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Thông tin nhân viên");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(utils.AppUtils.getFont(16f,_BOLD_)
        );
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Họ và Tên      :");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(utils.AppUtils.getFont(16f,_BOLD_)
        );
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mã nhân viên :");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(utils.AppUtils.getFont(16f,_BOLD_)
        );
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Số điện thoại  :");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(utils.AppUtils.getFont(16f,_BOLD_)
        );
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ngày bắt đầu :");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(utils.AppUtils.getFont(16f,_BOLD_)
        );
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Vai trò            :");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(utils.AppUtils.getFont(16f,_BOLD_)
        );
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Trạng thái       :");

        ten.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        ten.setForeground(new java.awt.Color(255, 255, 255));
        ten.setText("jLabel20");

        sdt.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        sdt.setForeground(new java.awt.Color(255, 255, 255));
        sdt.setText("jLabel20");

        mnv.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        mnv.setForeground(new java.awt.Color(255, 255, 255));
        mnv.setText("jLabel20");

        date.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("jLabel20");

        vaitro.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        vaitro.setForeground(new java.awt.Color(255, 255, 255));
        vaitro.setText("jLabel20");

        jLabel25.setFont(utils.AppUtils.getFont(16f, _NORMAL_)
        );
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("jLabel20");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel12)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(2, 2, 2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(vaitro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mnv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9))
                            .addComponent(ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ten))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(mnv))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(sdt))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(date))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(vaitro))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel25)))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(83, 86, 99));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(31, 29, 43));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        panelShadow2.setBackground(new java.awt.Color(14, 36, 51));
        panelShadow2.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        curveLineChart1.setFillColor(true);
        curveLineChart1.setPreferredSize(new java.awt.Dimension(650, 460));
        curveLineChart1.setTitleFont(utils.AppUtils.getFont(20f, _ITALIC_)
        );
        panelShadow2.add(curveLineChart1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.CurveLineChart curveLineChart1;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel khachhang;
    private javax.swing.JLabel mnv;
    private component.PanelRound panelRound1;
    private component.PanelRound panelRound4;
    private component.PanelRound panelRound5;
    private component.PanelRound panelRound6;
    private component.PanelRound panelRound7;
    private component.PanelShadow panelShadow2;
    private javax.swing.JLabel sdt;
    private javax.swing.JLabel status;
    private javax.swing.JLabel ten;
    private javax.swing.JLabel vaitro;
    // End of variables declaration//GEN-END:variables
}
