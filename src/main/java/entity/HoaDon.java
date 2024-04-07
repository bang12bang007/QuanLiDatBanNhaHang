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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Enum.LoaiTrangThaiHoaDon;

/**
 *
 * @author Laptop
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@NamedQueries({
    @NamedQuery(name = "HoaDon.Last", query = "SELECT h FROM HoaDon h ORDER BY h.maHoaDon DESC"),
    @NamedQuery(name = "HoaDon.OnOrdering", query = "SELECT h FROM HoaDon h WHERE h.trangThai = :trangThai"),
    @NamedQuery(name = "HoaDon.updateStateById", query = "UPDATE HoaDon SET trangThai = :trangThai WHERE maHoaDon = :maBan")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhuyenMai", nullable = true)
    private KhuyenMai khuyenMai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDichVu", nullable = true)
    private DichVu dichVu;
    @Column(name = "NgayLapHoaDon", nullable = false)
    private LocalDate ngayLapHoaDon;
    @ManyToOne
    @JoinColumn(name = "MaBan", nullable = false)
    private Ban ban;
    @Column(name = "TrangThai", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LoaiTrangThaiHoaDon trangThai;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDon;
    
    public HoaDon(NhanVien nhanVien, LocalDate ngayLapHoaDon, Ban ban, LoaiTrangThaiHoaDon trangThai) {
        this.nhanVien = nhanVien;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.ban = ban;
        this.trangThai = trangThai;
    }

    public HoaDon(NhanVien nhanVien, KhachHang khachHang, LocalDate ngayLapHoaDon) {
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayLapHoaDon = ngayLapHoaDon;
    }
}
