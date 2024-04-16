/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.Enum.LoaiTrangThaiHoaDon;

/**
 *
 * @author Laptop
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@NamedQueries({
    @NamedQuery(name = "HoaDon.Last", query = "SELECT h FROM HoaDon h ORDER BY h.maHoaDon DESC"),
    @NamedQuery(name = "HoaDon.OnOrdering", query = "SELECT h FROM HoaDon h WHERE h.trangThai = :trangThai"),
    @NamedQuery(name = "HoaDon.updateStateById", query = "UPDATE HoaDon SET trangThai = :trangThai WHERE maHoaDon = :maHoaDon"),
    @NamedQuery(name = "HoaDon.updateBanById", query = "UPDATE HoaDon SET ban = :ban WHERE maHoaDon = :maHoaDon"),
    @NamedQuery(name = "HoaDon.getPhieuDatBan",query = "SELECT p FROM HoaDon h INNER JOIN Ban b on b.maBan = h.ban.maBan INNER JOIN PhieuDatBan p on p.ban.maBan = b.maBan WHERE h.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "HoaDon.findHoaDonTuNgayDenNgay",query = "SELECT h FROM HoaDon h WHERE CAST(h.ngayLapHoaDon AS date) >= CAST(:ngayBatDau AS date) AND CAST(h.ngayLapHoaDon AS date) <= CAST(:ngayKetThuc AS date)"),

})
public class HoaDon {

    @Id
    @Column(name = "MaHoaDon", nullable = false)
    private String maHoaDon;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNhanVien", nullable = false)
    private NhanVien nhanVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhachHang", nullable = true)
    private KhachHang khachHang;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ChiTietKhuyenMai",
            joinColumns = {
                @JoinColumn(name = "MaHoaDon")},
            inverseJoinColumns = {
                @JoinColumn(name = "MaKhuyenMai")}
    )
    private List<KhuyenMai> khuyenMai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDichVu", nullable = true)
    private DichVu dichVu;
    @Column(name = "NgayLapHoaDon", nullable = false)
    private LocalDateTime ngayLapHoaDon;
    @ManyToOne
    @JoinColumn(name = "MaBan", nullable = false)
    private Ban ban;
    @Column(name = "TrangThai", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LoaiTrangThaiHoaDon trangThai;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDon;

    public HoaDon(NhanVien nhanVien, LocalDateTime ngayLapHoaDon, Ban ban, LoaiTrangThaiHoaDon trangThai) {
        this.nhanVien = nhanVien;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.ban = ban;
        this.trangThai = trangThai;
    }

    public HoaDon(NhanVien nhanVien, KhachHang khachHang, LocalDateTime ngayLapHoaDon) {
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayLapHoaDon = ngayLapHoaDon;
    }
}
