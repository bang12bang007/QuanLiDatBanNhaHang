/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import dao.IChiTietHoaDonDAO;
import dao.IHoaDonDAO;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Mon;
import entity.NhanVien;
import entity.ChiTietKhuyenMai;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import static java.awt.Frame.MAXIMIZED_BOTH;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import utils.Enum.LoaiTrangThaiHoaDon;

/**
 * @author dmx
 */
public class HoaDonDAO extends AbstractDAO<HoaDon> implements IHoaDonDAO<HoaDon> {

    private LocalDateTime timeNow = LocalDateTime.now();
    private String month_format = String.format("%02d", timeNow.getMonthValue());
    private String date_format = String.format("%02d", timeNow.getDayOfMonth());
    private String hour_format = String.format("%02d", timeNow.getHour());
    private String generateTime = Integer.toString(timeNow.getYear()).substring(2, 4) + month_format + date_format + hour_format;
    private IChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    private DecimalFormat formatter = new DecimalFormat("###,###đ");

    public HoaDon findLast() {
        return em.createNamedQuery("HoaDon.Last", HoaDon.class)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    public String generateID() {
        HoaDon hoaDon = findLast();

        if (hoaDon != null) {
            String lastID = hoaDon.getMaHoaDon();
            if (checkSameDateTime(lastID)) {//truong hop cung ngay cung gio
                String increase_xxx = lastID.substring(10, 13);
                int generate_xxx = Integer.parseInt(increase_xxx);
                generate_xxx++;
                return "HD" + generateTime + String.format("%03d", generate_xxx);
            } else {//truong hop khac gio
                return "HD" + generateTime + String.format("%03d", 1);
            }
        }
        return "HD" + generateTime + String.format("%03d", 1);
    }

    public boolean checkSameDateTime(String lastID) {
        String regex = lastID.substring(2, 10);
        return regex.equalsIgnoreCase(generateTime);
    }

    public boolean insertHoaDon(HoaDon hoaDon) {
        hoaDon.setMaHoaDon(generateID());
        return insert(hoaDon);
    }

    public List<HoaDon> findOnOrder() {
        return em.createNamedQuery("HoaDon.OnOrdering", HoaDon.class)
                .setParameter("trangThai", LoaiTrangThaiHoaDon.CHUA_THANH_TOAN)
                .getResultList();
    }

    public List<HoaDon> findByState(Enum e) {
        return em.createNamedQuery("HoaDon.OnOrdering", HoaDon.class)
                .setParameter("trangThai", e)
                .getResultList();
    }

    public boolean updateStateById(String id, Enum state) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Query query = em.createNamedQuery("HoaDon.updateStateById");
            query.setParameter("maHoaDon", id);
            query.setParameter("trangThai", state);
            int rowsUpdated = query.executeUpdate();
            transaction.commit();
            return rowsUpdated > 0;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBanById(String id, Ban ban) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Query query = em.createNamedQuery("HoaDon.updateBanById");
            query.setParameter("maHoaDon", id);
            query.setParameter("ban", ban);
            int rowsUpdated = query.executeUpdate();
            transaction.commit();
            return rowsUpdated > 0;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void createInvoice(HoaDon hoaDon, double tienKhachTra, double tienThua) {

        PdfWriter pdfWriter = null;
        double tongThanhToan = 0;
//      asyn await chỗ này
        Map<Mon, Long> map = chiTietHoaDonDAO.getListByBan(hoaDon, LoaiTrangThaiHoaDon.CHUA_THANH_TOAN);
        List<HoaDon> list = getListHoaDonGhep(hoaDon, LoaiTrangThaiHoaDon.CHUA_THANH_TOAN);
        list = list.size() == 0 ? getListHoaDonGhep(hoaDon, LoaiTrangThaiHoaDon.CHO_THANH_TOAN) : list;
        map = map.size() == 0 ? chiTietHoaDonDAO.getListByBan(hoaDon, LoaiTrangThaiHoaDon.CHO_THANH_TOAN) : map;
        for (HoaDon hd : list) {
            tongThanhToan += chiTietHoaDonDAO.TotalFoodCurrency(hd);
        }

        try {
            String path = "invoice.pdf";
            pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            Document document = new Document(pdfDocument);
            PdfFont font = PdfFontFactory.createFont("src/main/java/font/OpenSans-VariableFont_wdth,wght.ttf", PdfEncodings.IDENTITY_H);
            float pageWidth = pdfDocument.getDefaultPageSize().getWidth() - 70;
            document.setFont(font);

            document.add(new Paragraph("KTQD Gò vấp - 244 Lê Văn Thọ").setTextAlignment(TextAlignment.CENTER).setBold().setMargin(0));
            document.add(new Paragraph("246, Lê Văn Thọ, Phường 11, Q.Gò Vấp").setTextAlignment(TextAlignment.CENTER).setMargin(0));
            document.add(new Paragraph("Thành phố Hồ Chí Minh    Hotline: 0902 777 600").setTextAlignment(TextAlignment.CENTER).setMargin(0));
            document.add(new Image(ImageDataFactory.create("./src/main/resources/images/logo_2.png")).setHorizontalAlignment(HorizontalAlignment.CENTER));
            document.add(new Paragraph("PHIẾU HÓA ĐƠN").setTextAlignment(TextAlignment.CENTER).setBold().setMargin(0));
            document.add(new Paragraph("Số: " + hoaDon.getMaHoaDon()).setTextAlignment(TextAlignment.CENTER).setBold().setMargin(0));
//          ---Ngày---
            LocalDateTime inputDateTime = LocalDateTime.parse(LocalDateTime.now().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String formattedDateTime = inputDateTime.format(DateTimeFormatter.ofPattern("hh:mma"));
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime createDate = LocalDateTime.parse(hoaDon.getNgayLapHoaDon().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String formatCreateDate = createDate.format(DateTimeFormatter.ofPattern("hh:mma"));
            Paragraph paragraphDate = new Paragraph().setMargin(0);
            paragraphDate.add(new Text("Ngày: ").setBold());
            paragraphDate.add(new Text(formatterDate.format(hoaDon.getNgayLapHoaDon()) + " (" + formatCreateDate + "  " + formattedDateTime + ")"));
            document.add(paragraphDate);
//          ---Bàn---
            Paragraph paragraphTable = new Paragraph().setMargin(0);
            paragraphTable.add(new Text("Bàn: ").setBold());
            paragraphTable.add(new Text(hoaDon.getBan().getMaBan()));
            document.add(paragraphTable);
//          ---Nhân viên---
            Paragraph paragraphEmp = new Paragraph().setMargin(0);
            paragraphEmp.add(new Text("Nhân viên: ").setBold());
            paragraphEmp.add(new Text(hoaDon.getNhanVien().getHoTen()));
            document.add(paragraphEmp);
//          ------Table-----
            Table table = new Table(6);
            table.setWidth(pageWidth);
            table.setMarginBottom(4f);
            table.addCell(new Paragraph("#").setBold());
            table.addCell(new Paragraph("Tên món").setBold());
            table.addCell(new Paragraph("SL").setBold());
            table.addCell(new Paragraph("ĐG").setBold());
            table.addCell(new Paragraph("KM (%)").setBold());
            table.addCell(new Paragraph("TT").setBold());
            int stt = 1;
            System.out.println("Map<Mon, Long>: " + map.entrySet().size());
            for (Map.Entry<Mon, Long> entry : map.entrySet()) {
                table.addCell(stt++ + "");
                table.addCell(entry.getKey().getTenMon());
                table.addCell(entry.getValue() + "");
                table.addCell(formatter.format(entry.getKey().getGiaBan()) + "");
                table.addCell(" ");
                table.addCell(formatter.format(entry.getValue() * entry.getKey().getGiaBan()) + "");
            }
            document.add(table);
//          -----Tổng thanh toán----
            document.add(createCost(new Paragraph("Tổng thanh toán").setBold(), formatter.format(tongThanhToan), pageWidth));
//          -----Còn phải thu----
            document.add(createCost(new Paragraph("Còn phải thu").setBold(), formatter.format(tienKhachTra - tienThua), pageWidth));
//          -----Tiền Khách trả----
            document.add(createCost(new Paragraph("Tiền khách trả").setBold(), formatter.format(tienKhachTra), pageWidth));
//          -----Tiền thừa----
            document.add(createCost(new Paragraph("Tiền thừa").setBold(), formatter.format(tienThua), pageWidth));

            document.add(new Paragraph("Quý khách vui lòng kiểm tra kỹ lại nội dung trước khi thanh toán! Trân trọng cảm ơn!").setTextAlignment(TextAlignment.CENTER).setBold());
            document.add(new Paragraph("HẸN GẶP LẠI QUÝ KHÁCH").setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(20f));
            document.add(new Paragraph("Một sản phẩm của Team The Chosen Ones - NDK").setTextAlignment(TextAlignment.CENTER));
            document.close();

            SwingController controller = new SwingController();
            SwingViewBuilder factory = new SwingViewBuilder(controller);
            JPanel viewerComponentPanel = factory.buildViewerPanel();
            controller.getDocumentViewController().setAnnotationCallback(new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));
            JFrame frame = new JFrame("PDF Viewer");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setExtendedState(MAXIMIZED_BOTH);
            frame.setLocationRelativeTo(null);
            controller.openDocument(path);
            frame.add(viewerComponentPanel);
            frame.setVisible(true);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Đóng PdfWriter
            if (pdfWriter != null) {
                try {
                    pdfWriter.close();
                    Files.deleteIfExists(Paths.get("invoice.pdf"));
                } catch (IOException ex) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private Table createCost(IBlockElement label, String content, float width) {
        Table table = new Table(2);
        table.setWidth(width);
        table.setBorderLeft(Border.NO_BORDER);
        table.setBorderRight(Border.NO_BORDER);
        table.setBorderTop(Border.NO_BORDER);
        table.setBorderBottom(new SolidBorder(1f));
        Cell cell_1 = new Cell().add(label);
        Cell cell_2 = new Cell().add(new Paragraph(content).setTextAlignment(TextAlignment.RIGHT).setBold());
        cell_1.setBorder(Border.NO_BORDER);
        cell_2.setBorder(Border.NO_BORDER);
        table.addCell(cell_1);
        table.addCell(cell_2);
        table.setPaddingBottom(6f);

        return table;
    }

    public int getTongHoaDon(NhanVien nv) {
        int sum = 0;
        List<HoaDon> hoaDons = findAll(HoaDon.class);
        for (HoaDon hd_total : hoaDons) {
            if (hd_total.getNgayLapHoaDon().getDayOfYear() == LocalDateTime.now().getDayOfYear()) {
                if (hd_total.getTrangThai().equals(LoaiTrangThaiHoaDon.DA_THANH_TOAN) && nv.getMaNV().equals(hd_total.getNhanVien().getMaNV())) {
                    sum += 1;
                    // chưa áp dụng khuyến mãi 
                }
            }
        }
        return sum;
    }

    public int getSoLuongKhachHang(NhanVien nv) {
        int sum = 0;
        List<HoaDon> hoaDons = findAll(HoaDon.class);
        for (HoaDon hd_total : hoaDons) {
            if (hd_total.getNgayLapHoaDon().getDayOfYear() == LocalDateTime.now().getDayOfYear()) {
                if (hd_total.getTrangThai().equals(LoaiTrangThaiHoaDon.DA_THANH_TOAN) && nv.getMaNV().equals(hd_total.getNhanVien().getMaNV())) {
                    sum += hd_total.getSoLuongNguoi();
                    // chưa áp dụng khuyến mãi 
                }
            }
        }
        return sum;
    }

    public double[] getThongKeTheoCa(NhanVien nv, int startHour, int endHour) {
        double dt = 0;
        double hd = 0;
        double kh = 0;
        String ngay = generateTime.substring(0, 6);
        List<HoaDon> hoaDons = findAll(HoaDon.class);
        ChiTietHoaDonDAO tien = new ChiTietHoaDonDAO();
        for (HoaDon h : hoaDons) {
            int gio = h.getNgayLapHoaDon().getHour();
            if (nv.getMaNV().equals(h.getNhanVien().getMaNV())) {  //            KiemTraTheoMaNhanVien
                if (ngay.equals(h.getMaHoaDon().substring(2, 8))) {
                    hd += 1;
                    dt += tien.TotalFoodCurrency(h) / 1000000;   // phần trăm theo tổng doanh thu
                    kh += h.getSoLuongNguoi();
                }
            }
        }

        double[] result = {dt, hd, kh};
        return result;
    }

    @Override
    public double getTongDoanhThu(NhanVien nv) {
        ChiTietKhuyenMai km = new ChiTietKhuyenMai();
        double sum = 0.0;
        ChiTietHoaDonDAO tien = new ChiTietHoaDonDAO();
        List<HoaDon> hd = findAll(HoaDon.class);
        for (HoaDon hd_total : hd) {
            if (hd_total.getNgayLapHoaDon().getDayOfYear() == LocalDateTime.now().getDayOfYear()) {
                if (hd_total.getTrangThai().equals(LoaiTrangThaiHoaDon.DA_THANH_TOAN) && nv.getMaNV().equals(hd_total.getNhanVien().getMaNV())) {
                    sum += tien.TotalFoodCurrency(hd_total);
                    // chưa áp dụng khuyến mãi 
                }
            }
        }
        return sum;
    }

    public DecimalFormat getFormatter() {
        return formatter;
    }

    public List<HoaDon> findHoaDonTheoNgay(LocalDateTime ngay) {
        List<HoaDon> list = findAll(HoaDon.class);
        List<HoaDon> listHoaDonTheoNgay = new ArrayList<>();
        String month_format = String.format("%02d", ngay.getMonthValue());
        String date_format = String.format("%02d", ngay.getDayOfMonth());
        String ngayString = Integer.toString(ngay.getYear()).substring(2, 4) + month_format + date_format;
        for (int i = 0; i < list.size(); i++) {
            String ngay_hoadon = list.get(i).getMaHoaDon().substring(2, 8);
            if (ngayString.equals(ngay_hoadon)) {
                listHoaDonTheoNgay.add(list.get(i));
            }
        }
        System.out.println(listHoaDonTheoNgay.size());
        return listHoaDonTheoNgay;
    }

    @Override
    public List<HoaDon> findFromDateToDate(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) {
        TypedQuery<HoaDon> query = em.createNamedQuery("HoaDon.findFromDateToDate", HoaDon.class);
        query.setParameter("ngayBatDau", ngayBatDau);
        query.setParameter("ngayKetThuc", ngayKetThuc);
        return query.getResultList();
    }

    @Override
    public double getTotalRevenueFromDateToDate(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) {
        Double total = 0.0;
        ChiTietHoaDonDAO dao = new ChiTietHoaDonDAO();
        List<HoaDon> list = findFromDateToDate(ngayBatDau, ngayKetThuc);
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).getTienPhaiThu();
        }
        return total;
    }

    @Override
    public List<HoaDon> filterByDate(LocalDate date) {
        TypedQuery<HoaDon> query = em.createNamedQuery("HoaDon.filterByDate", HoaDon.class);
        query.setParameter("date", date);

        return query.getResultList();
    }

    @Override
    public List<HoaDon> findOrdersByMonth(int month) {
        TypedQuery<HoaDon> query = em.createNamedQuery("HoaDon.findOrdersByMonth", HoaDon.class);
        query.setParameter("month", month);
        return query.getResultList();
    }

    @Override
    public double getTotalRevenueByMonth(int month) {
        Double total = 0.0;
        List<HoaDon> list = findOrdersByMonth(month);
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).getTienPhaiThu();
        }
        return total;
    }

    @Override
    public int getTotalInVoicesByMonth(int month) {
        int soLuongHoaDon = 0;
        List<HoaDon> list = findOrdersByMonth(month);
        for (HoaDon h : list) {
            soLuongHoaDon += 1;
        }
        return soLuongHoaDon;
    }

    @Override
    public List<HoaDon> findByStateAndIdTable(Enum loaiTrangThai, String oldBanGop) {
        return em.createNamedQuery("HoaDon.findStateAndTableId", HoaDon.class)
                .setParameter("ban", oldBanGop)
                .setParameter("trangThai", loaiTrangThai)
                .getResultList();
    }

    @Override
    public List<HoaDon> findByHour(int hour) {
        return em.createNamedQuery("HoaDon.findOrdersByHour", HoaDon.class)
                .setParameter("hour", hour)
                .setParameter("date", LocalDate.now())
                .getResultList();
    }

    public List<HoaDon> getListHoaDonGhep(HoaDon hoaDon, LoaiTrangThaiHoaDon trangThai) {
        return em.createNamedQuery("HoaDon.getListHoaDonGhep", HoaDon.class)
                .setParameter("ban", hoaDon.getBan())
                .setParameter("trangThai", trangThai)
                .getResultList();
    }

    @Override
    public List<HoaDon> getListHoaDonGhepDatTruoc(HoaDon hoaDon) {
        return em.createNamedQuery("HoaDon.getListHoaDonGhepDatTruoc", HoaDon.class)
                .setParameter("ban", hoaDon.getBan())
                .setParameter("ngay", hoaDon.getNgayLapHoaDon())
                .getResultList();
    }
}
