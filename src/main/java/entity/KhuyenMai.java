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
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import utils.Enum.LoaiKhuyenMai;
import utils.Enum.LoaiTrangThaiKhuyenMai;

/**
 *
 * @author Laptop
 */
@Entity
public class KhuyenMai {

    @Id
    @Column(name = "MaKhuyenMai", length = 21)
    private String maKhuyenMai;
    @Column(name = "TenKhuyenMai", length = 100)
    private String tenKhuyenMai;
    @Column(name = "NgayBatDau")
    private Date ngayBatDau;
    @Column(name = "NgayKetThuc", nullable = true)
    private Date ngayKetThuc;
    @Column(name = "ChietKhau")
    private Double chietKhau;
    @Column(name = "LoaiKhuyenMai")
    @Enumerated(EnumType.ORDINAL)
    private LoaiKhuyenMai loaiKhuyenMai;
    @Column(name = "GhiChu", nullable = true, length = 100)
    private String ghiChu;
    @Column(name = "TrangThai")
    @Enumerated(EnumType.ORDINAL)
    private LoaiTrangThaiKhuyenMai trangThai;
    @OneToMany(mappedBy = "khuyenMai")
    private List<Mon> mon;

    public KhuyenMai(String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, Double chietKhau, LoaiKhuyenMai loaiKhuyenMai, String ghiChu) {
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.chietKhau = chietKhau;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.ghiChu = ghiChu;
    }

    public KhuyenMai() {
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Double getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(Double chietKhau) {
        this.chietKhau = chietKhau;
    }

    public LoaiKhuyenMai getLoaiKhuyenMai() {
        return loaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(LoaiKhuyenMai loaiKhuyenMai) {
        this.loaiKhuyenMai = loaiKhuyenMai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", chietKhau=" + chietKhau + ", loaiKhuyenMai=" + loaiKhuyenMai + ", ghiChu=" + ghiChu + '}';
    }
}
