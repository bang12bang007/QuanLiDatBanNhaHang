/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Enum.LoaiKhuyenMai;
import utils.Enum.LoaiTrangThaiKhuyenMai;

/**
 *
 * @author Laptop
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class KhuyenMai {

    @Id
    @Column(name = "MaKhuyenMai", length = 21, nullable = false)
    private String maKhuyenMai;
    @Column(name = "TenKhuyenMai", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String tenKhuyenMai;
    @Column(name = "NgayBatDau", nullable = false)
    private Date ngayBatDau;
    @Column(name = "NgayKetThuc", nullable = true)
    private Date ngayKetThuc;
    @Column(name = "ChietKhau", nullable = false)
    private Double chietKhau;
    @Column(name = "LoaiKhuyenMai", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LoaiKhuyenMai loaiKhuyenMai;
    @Column(name = "GhiChu", nullable = true, columnDefinition = "NVARCHAR(255)")
    private String ghiChu;
    @Column(name = "TrangThai", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LoaiTrangThaiKhuyenMai trangThai;
    @OneToMany(mappedBy = "khuyenMai")
    private List<Mon> mon;
    @ManyToMany(mappedBy = "khuyenMai")
    private List<HoaDon> hoaDon;

    public KhuyenMai(String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, Double chietKhau, LoaiKhuyenMai loaiKhuyenMai, String ghiChu, LoaiTrangThaiKhuyenMai trangThai, List<Mon> mon) {
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.chietKhau = chietKhau;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.mon = mon;
    }
}
