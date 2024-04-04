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
    @Column(name="MaNhanVien")
    private String maNV;
    @Column(name="HoTen",length = 50)
    private String hoTen;
    @Column(name="DiaChi",length = 50)
    private String diaChi;
    @Column(name="TrangThai")
    private boolean trangThai;
    @Column(name="Tuoi")
    private int tuoi;
    @Column(name="SoDienThoai")
    private String soDienThoai;
    @Column(name="NgayBatDauLam")
    private Date ngayBatDauLam;
    @Column(name="VaiTro")
    @Enumerated(EnumType.ORDINAL)
    private LoaiVaiTro vaiTro;
    @Column(name="GioiTinh")
    private boolean gioiTinh;
    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<HoaDon> hoaDon;
    @OneToOne(mappedBy = "nhanVien", cascade = CascadeType.ALL)
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
