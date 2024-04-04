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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Enum.LoaiTrangThai;
import utils.Enum.LoaiViTri;

/**
 *
 * @author Laptop
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ban {
    @Id
    @Column(name="MaBan")
    private String maBan;
    @Column(name="ViTri")
    @Enumerated(EnumType.ORDINAL)
    private LoaiViTri viTri;
    @Column(name="SoGhe")
    private int soGhe;
    @Column(name="TrangThai")
    @Enumerated(EnumType.ORDINAL)
    private LoaiTrangThai trangThai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaBanGop",nullable = true)
    private Ban banGop;
    @Column(name="MaTang")
    private String maTang;
    @OneToOne(mappedBy = "ban", cascade = CascadeType.ALL)
    private HoaDon hoaDon;
    @OneToMany(mappedBy = "ban",cascade = CascadeType.ALL)
    private List<PhieuDatBan> phieuDatBan;
}
