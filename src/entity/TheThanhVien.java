/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import utils.Enum.LoaiTheThanhVien;

/**
 *
 * @author dmx
 */
public class TheThanhVien {
    private String maThe;
    private Double diemTich;
    private KhachHang khachHang;
    private LoaiTheThanhVien loaiThe;

    public TheThanhVien(Double diemTich, KhachHang khachHang, LoaiTheThanhVien loaiThe) {
        this.diemTich = diemTich;
        this.khachHang = khachHang;
        this.loaiThe = loaiThe;
    }

    public TheThanhVien() {
    }

    public String getMaThe() {
        return maThe;
    }

    public Double getDiemTich() {
        return diemTich;
    }

    public void setDiemTich(Double diemTich) {
        this.diemTich = diemTich;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public LoaiTheThanhVien getLoaiThe() {
        return loaiThe;
    }

    public void setLoaiThe(LoaiTheThanhVien loaiThe) {
        this.loaiThe = loaiThe;
    }

    @Override
    public String toString() {
        return "TheThanhVien{" + "maThe=" + maThe + ", diemTich=" + diemTich + ", khachHang=" + khachHang + ", loaiThe=" + loaiThe + '}';
    }
}
