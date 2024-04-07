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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "ChiTietHoaDon.HoaDon", query = "SELECT c FROM ChiTietHoaDon c WHERE c.hoaDon = :hoaDon")
})
public class ChiTietHoaDon {
    @Id
    @ManyToOne
    @JoinColumn(name="MaMon",nullable = false)
    private Mon mon;
    @Id
    @ManyToOne
    @JoinColumn(name="MaHoaDon",nullable = false)
    private HoaDon hoaDon;
    @Column(name="SoLuong",nullable = false)
    private int soLuong;
}
