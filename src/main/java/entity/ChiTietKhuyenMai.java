/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "ChiTietKhuyenMai")
@Getter
@Setter
@NoArgsConstructor
public class ChiTietKhuyenMai {
    @Id
    @ManyToOne
    @JoinColumn(name = "MaHoaDon",nullable = false)
    private HoaDon hoaDon;
    @Id
    @ManyToOne
    @JoinColumn(name = "MaKhuyenMai",nullable = false)
    private KhuyenMai khuyenMai;
    @Column(name = "ThanhTien")
    private Double thanhTien;

    public ChiTietKhuyenMai(HoaDon hoaDon, KhuyenMai khuyenMai) {
        this.hoaDon = hoaDon;
        this.khuyenMai = khuyenMai;
    }
}
