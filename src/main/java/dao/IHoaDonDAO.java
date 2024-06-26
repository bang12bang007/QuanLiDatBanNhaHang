
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
import java.time.LocalTime;

import java.util.List;

/**
 * @author dmx
 */
public interface IHoaDonDAO<T> extends GenericDAO<T> {

    HoaDon findLast();

    boolean insertHoaDon(HoaDon hoadon);

    List<HoaDon> findOnOrder();

    List<HoaDon> findByState(Enum state);

    boolean updateStateById(String id, Enum state);

    boolean updateBanById(String id, Ban ban);

    void createInvoice(HoaDon hoaDon, double tienKhachTra, double tienThua, String banGop);

    double getTongDoanhThu(NhanVien nv);

    List<HoaDon> filterByDate(LocalDate date);

    List<HoaDon> findFromDateToDate(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);

    double getTotalRevenueFromDateToDate(LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc);

    List<HoaDon> findOrdersByMonth(int month);

    double getTotalRevenueByMonth(int month);

    int getTotalInVoicesByMonth(int month);

    public List<HoaDon> findByStateAndIdTable(Enum loaiTrangThai, String oldBanGop);

    public List<HoaDon> findByHour(int hour);

    public List<HoaDon> getListHoaDonGhep(HoaDon hoaDon, utils.Enum.LoaiTrangThaiHoaDon trangThai);

    public List<HoaDon> getListHoaDonGhepDatTruoc(HoaDon hoaDon);

}
