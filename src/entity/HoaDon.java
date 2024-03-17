/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Laptop
 */
public class HoaDon {
    private String maHoaDon;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private KhuyenMai khuyenMai;
    private DichVu dichVu;
    private Date ngayLapHoaDon;

    public HoaDon(NhanVien nhanVien, KhachHang khachHang, KhuyenMai khuyenMai, DichVu dichVu, Date ngayLapHoaDon) {
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.khuyenMai = khuyenMai;
        this.dichVu = dichVu;
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public HoaDon() {
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", khuyenMai=" + khuyenMai + ", dichVu=" + dichVu + ", ngayLapHoaDon=" + ngayLapHoaDon + '}';
    }
}
