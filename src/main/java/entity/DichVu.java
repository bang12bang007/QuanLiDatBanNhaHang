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
    @Column(name="MaDichVu",length=11)
    private String maDichVu;
    @Column(name="TenDichVu",length = 50)
    private String tenDichVu;
    @Column(name="QuyMo",length = 50)
    private String quyMo;
    @Column(name="Gia")
    private Double gia;
    @Column(name="TrangThai")
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
