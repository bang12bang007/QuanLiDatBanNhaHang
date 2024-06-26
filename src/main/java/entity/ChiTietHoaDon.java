/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Enum.LoaiTrangThaiHoaDon;

/**
 * @author dmx
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQueries({
//<<<<<<< HEAD
//        @NamedQuery(name = "ChiTietHoaDon.HoaDon", query = "SELECT c FROM ChiTietHoaDon c WHERE c.hoaDon = :hoaDon"),
//        @NamedQuery(name = "ChiTietHoaDon.DS_SoLuong", query = "SELECT c FROM ChiTietHoaDon c WHERE c.soLuong = :soLuong"),
//        @NamedQuery(name = "ChiTietHoaDon.DS_MonThinhHanh", query = "SELECT c.mon, SUM(c.soLuong) FROM ChiTietHoaDon c JOIN c.hoaDon h WHERE h.trangThai = 0 GROUP BY c.mon"),})
//=======
//    SELECT * FROM ChiTietHoaDon ct JOIN HoaDon hd ON ct.MaHoaDon = hd.MaHoaDon  WHERE hd.MaBan = 'BAN0102' AND hd.TrangThai = 1
//    SELECT c, SUM(c.soLuong) FROM ChiTietHoaDon c JOIN c.hoaDon hd WHERE hd.ban = :ban AND hd.trangThai = LoaiTrangThaiHoaDon.CHUA_THANH_TOAN GROUP BY c
    @NamedQuery(name = "ChiTietHoaDon.listChiTietByBan", query = "SELECT c.mon, SUM(c.soLuong) FROM ChiTietHoaDon c JOIN c.hoaDon hd WHERE hd.ban = :ban AND hd.trangThai = :trangThai GROUP BY c.mon"),
    @NamedQuery(name = "ChiTietHoaDon.HoaDon", query = "SELECT c FROM ChiTietHoaDon c WHERE c.hoaDon = :hoaDon"),
    @NamedQuery(name = "ChiTietHoaDon.DS_SoLuong", query = "SELECT c FROM ChiTietHoaDon c WHERE c.soLuong = :soLuong"),
    @NamedQuery(name = "ChiTietHoaDon.sumSoLuongByMaMon", query = "SELECT c.mon, SUM(c.soLuong) FROM ChiTietHoaDon c GROUP BY c.mon"),
    @NamedQuery(name = "ChiTietHoaDon.sumSoLuongByMaMonByDate", query = "SELECT c.mon, SUM(c.soLuong) FROM ChiTietHoaDon c inner JOIN HoaDon h on c.hoaDon =h WHERE CAST(h.ngayLapHoaDon AS date) = CAST(:ngayYeuCau AS date) GROUP BY c.mon"),
})                                                                       
public class ChiTietHoaDon {

    @Id
    @ManyToOne
    @JoinColumn(name = "MaMon", nullable = false)
    private Mon mon;
    @Id
    @ManyToOne
    @JoinColumn(name = "MaHoaDon", nullable = false)
    private HoaDon hoaDon;
    @Setter(AccessLevel.NONE)
    @Column(name = "SoLuong", nullable = false)
    private int soLuong;
    @Column(name = "GhiChu", columnDefinition = "NVARCHAR(255)")
    private String ghiChu;
    @Setter(AccessLevel.NONE)
    @Column(name = "ThanhTien")
    private Double thanhTien;

    public ChiTietHoaDon(Mon mon, HoaDon hoaDon, int soLuong) {
        this.mon = mon;
        this.hoaDon = hoaDon;
        this.soLuong = soLuong;
        thanhTien();
    }

    public ChiTietHoaDon(Mon mon, HoaDon hoaDon, String ghiChu, int soLuong) {
        this.mon = mon;
        this.hoaDon = hoaDon;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        thanhTien();
    }

    private void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        thanhTien();
    }

    public void thanhTien() {
        Double tong = this.mon.getGiaBan() * this.soLuong;
        setThanhTien(tong);
    }

}