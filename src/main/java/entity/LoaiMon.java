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

/**
 *
 * @author dmx
 */
@Entity
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

    public LoaiMon(String tenLoai, String chuThich) {
        this.tenLoai = tenLoai;
        this.chuThich = chuThich;
    }

    public LoaiMon() {
    }

    public String getMaLoaiMon() {
        return maLoaiMon;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    @Override
    public String toString() {
        return "LoaiMon{" + "maLoaiMon=" + maLoaiMon + ", tenLoai=" + tenLoai + ", chuThich=" + chuThich + '}';
    }
}
