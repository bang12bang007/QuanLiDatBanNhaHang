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
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.sql.Date;
import utils.Enum.LoaiVaiTro;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Laptop
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class NhanVien {

    @Id
    @Column(name = "MaNhanVien", nullable = false)
    private String maNV;
    @Column(name = "HoTen", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String hoTen;
    @Column(name = "DiaChi", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String diaChi;
    @Column(name = "TrangThai", nullable = false)
    private boolean trangThai;
    @Column(name = "Tuoi", nullable = false)
    private int tuoi;
    @Column(name = "SoDienThoai", nullable = false)
    private String soDienThoai;
    @Column(name = "NgayBatDauLam", nullable = false)
    private Date ngayBatDauLam;
    @Column(name = "VaiTro", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LoaiVaiTro vaiTro;
    @Column(name = "GioiTinh", nullable = false)
    private boolean gioiTinh;
    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<HoaDon> hoaDon;
    @OneToOne(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    @ToString.Exclude
    private TaiKhoan taiKhoan;

    public NhanVien(String hoTen, String diaChi, boolean trangThai, int tuoi, String soDienThoai, Date ngayBatDauLam, LoaiVaiTro vaiTro, boolean gioiTinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.tuoi = tuoi;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauLam = ngayBatDauLam;
        this.vaiTro = vaiTro;
        this.gioiTinh = gioiTinh;
    }

}