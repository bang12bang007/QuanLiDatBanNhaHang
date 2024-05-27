package view.manager.forms;

import com.formdev.flatlaf.FlatClientProperties;
import dao.imlp.ChiTietHoaDonDAO;
import dao.imlp.HoaDonDAO;
import dao.imlp.TheThanhVienDAO;
import entity.Mon;
import entity.TheThanhVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raven.chart.bar.HorizontalBarChart;
import raven.chart.data.category.DefaultCategoryDataset;
import raven.chart.data.pie.DefaultPieDataset;
import raven.chart.line.LineChart;
import raven.chart.pie.PieChart;
import view.manager.components.SimpleForm;

/**
 * @author dmx
 */
public class GD_Dashboard extends SimpleForm {

    public GD_Dashboard() {
        init();
    }

    @Override
    public void formRefresh() {
        lineChart.startAnimation();
        pieChart1.startAnimation();
        pieChart2.startAnimation();
        pieChart3.startAnimation();
        barChart1.startAnimation();
        barChart2.startAnimation();
    }

    @Override
    public void formInitAndOpen() {
        System.out.println("init and open");
        setBackground(new Color(83, 86, 99));
    }

    @Override
    public void formOpen() {
        System.out.println("Open");
        setBackground(new Color(83, 86, 99));
    }

    private void init() {
        setLayout(new MigLayout("wrap,fill,gap 10", "fill"));
        setBackground(new Color(83, 86, 99));
        createPieChart();
        createLineChart();
        createBarChart();

    }

    private void createPieChart() {
        pieChart1 = new PieChart();
        JLabel header1 = new JLabel("Doanh thu của tuần này");
        header1.putClientProperty(FlatClientProperties.STYLE, "" + "font:+1");
        pieChart1.setHeader(header1);
        pieChart1.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart1.putClientProperty(FlatClientProperties.STYLE, "" + "border:5,5,5,5,$Component.borderColor,,20;");
        pieChart1.setDataset(staticticsRevenueByWeek());
        add(pieChart1, "split 3,height 290");

        pieChart2 = new PieChart();
        JLabel header2 = new JLabel("Top món được gọi nhiều nhất");
        header2.putClientProperty(FlatClientProperties.STYLE, "" + "font:+1");
        pieChart2.setHeader(header2);
        pieChart2.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart2.putClientProperty(FlatClientProperties.STYLE, "" + "border:5,5,5,5,$Component.borderColor,,20");
        pieChart2.setDataset(staticticsFookRanking());
        add(pieChart2, "height 290");

        pieChart3 = new PieChart();
        JLabel header3 = new JLabel("Khách hàng thân thiết nhất");
        header3.putClientProperty(FlatClientProperties.STYLE, "" + "font:+1");
        pieChart3.setHeader(header3);
        pieChart3.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart3.setChartType(PieChart.ChartType.DONUT_CHART);
        pieChart3.putClientProperty(FlatClientProperties.STYLE, "" + "border:5,5,5,5,$Component.borderColor,,20");
        pieChart3.setDataset(staticticsLoyalCustomer());
        add(pieChart3, "height 290");
    }

    private void createLineChart() {
        lineChart = new LineChart();
        lineChart.setChartType(LineChart.ChartType.CURVE);
        add(lineChart);
        createLineChartData();
    }

    private void createBarChart() {
        // BarChart 1
        barChart1 = new HorizontalBarChart();
        JLabel header1 = new JLabel("Tổng doanh thu theo tháng");
        header1.putClientProperty(FlatClientProperties.STYLE, "" + "font:+1;" + "border:0,0,5,0");
        barChart1.setHeader(header1);
        barChart1.setBarColor(Color.decode("#f97316"));
        barChart1.setDataset(staticticsTotalRevenueByMonth());
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.putClientProperty(FlatClientProperties.STYLE, "" + "border:5,5,5,5,$Component.borderColor,,20");
        panel1.add(barChart1);
        add(panel1, "split 2,gap 0 20");

        // BarChart 2
        barChart2 = new HorizontalBarChart();
        JLabel header2 = new JLabel("Tổng số hoá đơn theo tháng");
        header2.putClientProperty(FlatClientProperties.STYLE, "" + "font:+1;" + "border:0,0,5,0");
        barChart2.setHeader(header2);
        barChart2.setBarColor(Color.decode("#10b981"));
        barChart2.setDataset(staticticsTotalInVoicesByMonth());
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.putClientProperty(FlatClientProperties.STYLE, "" + "border:5,5,5,5,$Component.borderColor,,20");
        panel2.add(barChart2);
        add(panel2);
    }

    private DefaultPieDataset staticticsTotalRevenueByMonth() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        int monthValue = LocalDateTime.now().getMonth().getValue();
        for (int i = monthValue; i > 0; i--) {
            dataset.addValue("Tháng " + i, daoHD.getTotalRevenueByMonth(i));
        }
        return dataset;
    }

    private DefaultPieDataset staticticsTotalInVoicesByMonth() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        int monthValue = LocalDateTime.now().getMonth().getValue();
        for (int i = monthValue; i > 0; i--) {
            dataset.addValue("Tháng " + i, daoHD.getTotalInVoicesByMonth(i));
        }
        return dataset;
    }

    private DefaultPieDataset staticticsRevenueByWeek() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime monday = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDateTime currentDay = monday;
        while (!currentDay.toLocalDate().isEqual(now.toLocalDate().plusDays(1))) {
            dataset.addValue(currentDay.getDayOfWeek().toString(), daoHD.getTotalRevenueFromDateToDate(currentDay, currentDay));
            currentDay = currentDay.plusDays(1);
        }
        return dataset;
    }

    private DefaultPieDataset staticticsFookRanking() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        List<Object[]> listCTHD = daoCTHD.sumSoLuongByMaMon();
        List<Object[]> sortedListCTHD = listCTHD.stream()
                .sorted((arr1, arr2) -> ((Comparable) arr2[1]).compareTo(arr1[1])) // Sắp xếp theo giảm dần
                .collect(Collectors.toList());
        for (Object[] x : sortedListCTHD) {
            Mon mon = (Mon) x[0];
            String tenMon = mon.getTenMon();
            Long tongSoLuong = (Long) x[1];
            dataset.addValue(tenMon, tongSoLuong);
        }
        return dataset;
    }

    private DefaultPieDataset staticticsLoyalCustomer() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        List<TheThanhVien> listTTV = daoTTV.findAll(TheThanhVien.class);
        List<TheThanhVien> sortedListTTV = listTTV.stream()
                .sorted(Comparator.comparingDouble(TheThanhVien::getDiemTich).reversed()) // Sắp xếp theo giảm dần
                .collect(Collectors.toList());
        int i = 0;
        while (i < 5 && i < sortedListTTV.size()) {
            dataset.addValue(sortedListTTV.get(i).getKhachHang().getHoTen(), sortedListTTV.get(i).getDiemTich());
            i++;
        }
        return dataset;
    }

    private void createLineChartData() {
        DefaultCategoryDataset<String, String> categoryDataset = new DefaultCategoryDataset<>();
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime date = today.minusDays(30);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM dd, yyyy");

        Map<String, Long> totalCounts = new HashMap<>(); // Map to store total counts per dish

        while (!date.isAfter(today)) {
            List<Object[]> listCTHD = daoCTHD.sumSoLuongByMaMonByDate(date);

            // Sum up quantities for each dish across all dates
            for (Object[] x : listCTHD) {
                Mon mon = (Mon) x[0];
                String tenMon = mon.getTenMon();
                Long tongSoLuong = (Long) x[1];
                totalCounts.put(tenMon, totalCounts.getOrDefault(tenMon, 0L) + tongSoLuong);
            }

            date = date.plusDays(1);
        }

        // Sort the total counts in descending order and take the top 3
        List<Map.Entry<String, Long>> top3 = totalCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());

        // Reset date to start iterating again
        date = today.minusDays(30);

        while (!date.isAfter(today)) {
            String dateString = date.format(df);
            List<Object[]> listCTHD = daoCTHD.sumSoLuongByMaMonByDate(date);
            for (Object[] x : listCTHD) {
                Mon mon = (Mon) x[0];
                String tenMon = mon.getTenMon();
                Long tongSoLuong = (Long) x[1];

                // Only add data for the top 3 dishes
                if (top3.stream().anyMatch(entry -> entry.getKey().equals(tenMon))) {
                    categoryDataset.addValue(tongSoLuong, tenMon, dateString);
                }
            }
            date = date.plusDays(1);
        }

//        try {
//            Date date = df.parse(categoryDataset.getColumnKey(0));
//            Date dateEnd = df.parse(categoryDataset.getColumnKey(categoryDataset.getColumnCount() - 1));
//
//            DateCalculator dcal = new DateCalculator(date, dateEnd);
//            long diff = dcal.getDifferenceDays();
//
//            double d = Math.ceil((diff / 10f));
//            lineChart.setLegendRenderer(new ChartLegendRenderer() {
//                @Override
//                public Component getLegendComponent(Object legend, int index) {
//                    if (index % d == 0) {
//                        return super.getLegendComponent(legend, index);
//                    } else {
//                        return null;
//                    }
//                }
//            });
//        } catch (ParseException e) {
//            System.err.println(e);
//        }
        lineChart.setCategoryDataset(categoryDataset);
        lineChart.getChartColor().addColor(Color.decode("#38bdf8"), Color.decode("#fb7185"), Color.decode("#34d399"));
        JLabel header = new JLabel("Top 3 món được sử dụng trong 30 ngày gần nhất");
        header.putClientProperty(FlatClientProperties.STYLE, "" + "font:+1;" + "border:0,0,5,0");
        lineChart.setHeader(header);
    }

    private LineChart lineChart;
    private HorizontalBarChart barChart1;
    private HorizontalBarChart barChart2;
    private PieChart pieChart1;
    private PieChart pieChart2;
    private PieChart pieChart3;
    private HoaDonDAO daoHD = new HoaDonDAO();
    private TheThanhVienDAO daoTTV = new TheThanhVienDAO();
    private ChiTietHoaDonDAO daoCTHD = new ChiTietHoaDonDAO();

}
