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
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Enum.LoaiTrangThaiDichVu;

/**
 *
 * @author dmx
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DichVu {
    @Id
    @Column(name="MaDichVu",length=11,nullable = false)
    private String maDichVu;
    @Column(name="TenDichVu",columnDefinition = "NVARCHAR(50)",nullable = false)
    private String tenDichVu;
    @Column(name="QuyMo",columnDefinition = "NVARCHAR(100)",nullable = false)
    private String quyMo;
    @Column(name="Gia",nullable = false)
    private Double gia;
    @Column(name="TrangThai",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LoaiTrangThaiDichVu trangThai;
    @OneToMany(mappedBy = "dichVu", cascade = CascadeType.ALL)
    private List<HoaDon> hoaDon;

    public DichVu(String tenDichVu, String quyMo, Double gia, LoaiTrangThaiDichVu trangThai) {
        this.tenDichVu = tenDichVu;
        this.quyMo = quyMo;
        this.gia = gia;
        this.trangThai = trangThai;
    }
}
