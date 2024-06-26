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
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Enum.LoaiKhuyenMai;

/**
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
    private LocalDateTime ngayBatDau;
    @Column(name = "NgayKetThuc", nullable = true)
    private LocalDateTime ngayKetThuc;
    @Column(name = "ChietKhau", nullable = true)
    private Double chietKhau;
    @Column(name = "MenhGia", nullable = true)
    private Double menhGia;
    @Column(name = "LoaiKhuyenMai", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LoaiKhuyenMai loaiKhuyenMai;
    @Column(name = "GhiChu", nullable = true, columnDefinition = "NVARCHAR(255)")
    private String ghiChu;
    @OneToMany(mappedBy = "khuyenMai", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ChiTietKhuyenMai> chiTietKhuyenMai;

    public KhuyenMai(String tenKhuyenMai, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, Double chietKhau, LoaiKhuyenMai loaiKhuyenMai, String ghiChu) {
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.chietKhau = chietKhau;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.ghiChu = ghiChu;
    }

    public KhuyenMai(String tenKhuyenMai, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, Double chietKhau, Double menhGia, LoaiKhuyenMai loaiKhuyenMai, String ghiChu) {
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.chietKhau = chietKhau;
        this.menhGia = menhGia;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.ghiChu = ghiChu;
    }

}
