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
public class ChiTietHoaDon {
    @Id
    @ManyToOne
    @JoinColumn(name="MaMon",unique = true,nullable = false)
    private Mon mon;
    @Id
    @ManyToOne
    @JoinColumn(name="MaHoaDon",unique = true,nullable = false)
    private HoaDon hoaDon;
    @Column(name="SoLuong")
    private int soLuong;
}
