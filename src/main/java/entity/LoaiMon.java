/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
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
@NoArgsConstructor
@ToString
public class LoaiMon {
    @Id
    @Column(name = "MaLoaiMon",length = 4)
    private String maLoaiMon;
    @Column(name = "TenLoai",length = 50)
    private String tenLoai;
    @Column(name = "ChuThich",length = 100)
    private String chuThich;
    @OneToMany(mappedBy = "loaiMon")
    private List<Mon> mon;

    public LoaiMon(String tenLoai, String chuThich, List<Mon> mon) {
        this.tenLoai = tenLoai;
        this.chuThich = chuThich;
        this.mon = mon;
    }
}
