
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Ban;
import entity.HoaDon;
import entity.NhanVien;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

/**
 * @author dmx
 */
public interface IHoaDonDAO<T> extends GenericDAO<T> {

    HoaDon findLast();

    boolean insertHoaDon(HoaDon hoadon);

    List<HoaDon> findOnOrder();

    //    find by state (NDK)
    List<HoaDon> findByState(Enum state);

    boolean updateStateById(String id, Enum state);

    boolean updateBanById(String id, Ban ban);

//    <<<<<< < HEAD //    use to move from this table to other table
//         boolean updateBanById(String id, Ban ban);
//
//    void createInvoice(HoaDon hoaDon, double tienKhachTra, double tienThua);
//
//    double getTongDoanhThu(NhanVien nv);
//
//    List<HoaDon> findHoaDonTuNgayDenNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);
//
//    int getTongHoaDonTheoNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);
//
//    double getTongTienHoaDonTheoNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);
//
//    int getTongSoLuongMonTheoNgay(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);
//
//    List<HoaDon> filterByDate(LocalDate date);
//
//}
//=======
    void createInvoice(HoaDon hoaDon, double tienKhachTra, double tienThua);

    double getTongDoanhThu(NhanVien nv);

    List<HoaDon> filterByDate(LocalDate date);

    List<HoaDon> findFromDateToDate(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);

    double getTotalRevenueFromDateToDate(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);

    List<HoaDon> findOrdersByMonth(int month);

    double getTotalRevenueByMonth(int month);

    int getTotalInVoicesByMonth(int month);

    public List<HoaDon> findByStateAndIdTable(Enum loaiTrangThai, String oldBanGop);
    public List<HoaDon> findByHour(int hour);

}
