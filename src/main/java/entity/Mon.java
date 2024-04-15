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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Enum.LoaiTrangThaiMon;

/**
 *
 * @author Laptop
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(name = "Mon.Service", query = "SELECT m FROM Mon m WHERE m.trangThai = :trangThai"),
})
public class Mon {

    @Id
    @Column(name = "MaMon", length = 12, nullable = false)
    private String maMon;
    @Column(name = "TenMon", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String tenMon;
    @Column(name = "Gia", nullable = false)
    private Double gia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhuyenMai", nullable = true)
    private KhuyenMai khuyenMai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLoaiMon", nullable = false)
    private LoaiMon loaiMon;
    @Column(name = "HinhAnh", length = 255, nullable = true)
    private String hinhAnh;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TrangThai", nullable = false)
    private LoaiTrangThaiMon trangThai;
    @OneToMany(mappedBy = "mon", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDon;

    public Mon(String tenMon, Double gia, KhuyenMai khuyenMai, LoaiMon loaiMon, String hinhAnh, LoaiTrangThaiMon trangThai, List<ChiTietHoaDon> chiTietHoaDon) {
        this.tenMon = tenMon;
        this.gia = gia;
        this.khuyenMai = khuyenMai;
        this.loaiMon = loaiMon;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
        this.chiTietHoaDon = chiTietHoaDon;
    }

}
