/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author dmx
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
//NDK created
@NamedQueries({
    @NamedQuery(name = "PhieuDatBan.updateState", query = "UPDATE PhieuDatBan SET trangThai = :trangThai WHERE maPhieuDatBan = :maPhieuDatBan"),
    @NamedQuery(name = "PhieuDatBan.updateBanById", query = "UPDATE PhieuDatBan SET ban = :ban WHERE maPhieuDatBan = :maPhieuDatBan"),
    @NamedQuery(name = "PhieuDatBan.filterByDate", query = "SELECT p FROM PhieuDatBan p WHERE CAST(p.ngayGioDat AS date) = CAST(:date AS date)"),})
public class PhieuDatBan {

    @Id
    @Column(name = "MaPhieuDatBan", nullable = false)
    private String maPhieuDatBan;
    @Column(name = "NgayGioDatBan", nullable = false)
    private LocalDateTime ngayGioDat;
    @Column(name = "SoLuongNguoi", nullable = false)
    private int soLuongNguoi;
    @Column(name = "HoTenNguoiDat", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String hoTen;
    @Column(name = "SoDienThoai", nullable = false)
    private String sdt;
    @Column(name = "TrangThai", nullable = false)
    private int trangThai;
    @Column(name = "TienDatCoc", nullable = false)
    private double tienDatCoc;
    @Column(name = "YeuCauKhac", columnDefinition = "NVARCHAR(255)", nullable = true)
    private String yeuCauKhac;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaBan")
    private Ban ban;
    @Column(name = "YeuCauDatMon", columnDefinition = "NVARCHAR(255)", nullable = true)
    private String yeuCauDatMon;

    public PhieuDatBan(LocalDateTime ngayGioDat, int soLuongNguoi, String hoTen, String sdt, int trangThai, double tienDatCoc, String yeuCauKhac, Ban ban) {
        this.ngayGioDat = ngayGioDat;
        this.soLuongNguoi = soLuongNguoi;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.tienDatCoc = tienDatCoc;
        this.yeuCauKhac = yeuCauKhac;
        this.ban = ban;
    }

}
