/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class KhachHang {
    @Id
    @Column(name="MaKhachHang")
    private String maKH;
    @Column(name="TenKhachHang")
    private String tenKH;
    @Column(name="SoDienThoai")
    private String sdt;
    @Column(name="DiaChi")
    private String diaChi;
    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<HoaDon> hoaDon;
    @OneToOne(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private TheThanhVien theThanhVien;

    public KhachHang(String tenKH, String sdt, String diaChi) {
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }
}
