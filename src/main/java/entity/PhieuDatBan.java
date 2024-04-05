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
public class PhieuDatBan {

    @Id
    @Column(name = "MaPhieuDatBan", nullable = false)
    private String maPhieuDatBan;
    @Column(name = "NgayGioDatBan", nullable = false)
    private Date ngayGioDat;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaBan")
    private Ban ban;

    public PhieuDatBan(Date ngayGioDat, int soLuongNguoi, String hoTen, String sdt, int trangThai, double tienDatCoc, Ban ban) {
        this.ngayGioDat = ngayGioDat;
        this.soLuongNguoi = soLuongNguoi;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.tienDatCoc = tienDatCoc;
        this.ban = ban;
    }

}
