/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import utils.Enum.LoaiTrangThaiMon;

/**
 *
 * @author Laptop
 */
@Entity
@Getter
@Setter
public class Mon {
    @Id
    @Column(name ="MaMon",length = 12)
    private String maMon;
    @Column(name = "TenMon",length = 50)
    private String tenMon;
    @Column(name = "Gia")
    private Double gia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KhuyenMaiID",nullable = true)
    private KhuyenMai khuyenMai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LoaiMon")
    private LoaiMon loaiMon;
    @Column(name = "HinhAnh",length = 100)
    private String hinhAnh;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="TrangThai")
    private LoaiTrangThaiMon trangThai;

    public Mon(String tenMon, Double gia, LoaiMon loaiMon, String hinhAnh) {
        this.tenMon = tenMon;
        this.gia = gia;
        this.loaiMon = loaiMon;
        this.hinhAnh = hinhAnh;
    }

    public Mon() {
    }

    @Override
    public String toString() {
        return "Mon{" + "maMon=" + maMon + ", tenMon=" + tenMon + ", gia=" + gia + ", khuyenMai=" + khuyenMai + ", loaiMon=" + loaiMon + ", hinhAnh=" + hinhAnh + '}';
    }
}
