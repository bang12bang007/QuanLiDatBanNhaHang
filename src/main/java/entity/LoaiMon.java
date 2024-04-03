/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author dmx
 */
public class LoaiMon {
    private String maLoaiMon;
    private String tenLoai;
    private String chuThich;

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
