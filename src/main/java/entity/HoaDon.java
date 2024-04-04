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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class HoaDon {
    @Id
    @Column(name="MaHoaDon",nullable = false)
    private String maHoaDon;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNhanVien",nullable = false)
    private NhanVien nhanVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhachHang",nullable = false)
    private KhachHang khachHang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhuyenMai",nullable = true)
    private KhuyenMai khuyenMai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDichVu",nullable = true)
    private DichVu dichVu;
    @Column(name="NgayLapHoaDon",nullable = false)
    private Date ngayLapHoaDon;
    @OneToOne
    @JoinColumn(name = "MaBan", unique = true, nullable = false)
    private Ban ban;
    @Column(name="TrangThai",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LoaiTrangThaiHoaDon trangThai;
    @OneToMany(mappedBy = "hoaDon",cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDon;

    public HoaDon(NhanVien nhanVien, KhachHang khachHang, KhuyenMai khuyenMai, DichVu dichVu, Date ngayLapHoaDon) {
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.khuyenMai = khuyenMai;
        this.dichVu = dichVu;
        this.ngayLapHoaDon = ngayLapHoaDon;
    }
}
