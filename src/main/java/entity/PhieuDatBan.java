/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author dmx
 */
public class PhieuDatBan {
    private String maPhieuDatBan;
    private Date ngayGioDat;
    private int soLuongNguoi;
    private String hoTen;
    private String sdt;
    private Ban ban;

    public PhieuDatBan(Date ngayGioDat, int soLuongNguoi, String hoTen, String sdt, Ban ban) {
        this.ngayGioDat = ngayGioDat;
        this.soLuongNguoi = soLuongNguoi;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.ban = ban;
    }

    public String getMaPhieuDatBan() {
        return maPhieuDatBan;
    }
    
    public Date getNgayGioDat() {
        return ngayGioDat;
    }

    public void setNgayGioDat(Date ngayGioDat) {
        this.ngayGioDat = ngayGioDat;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Ban getBan() {
        return ban;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    public PhieuDatBan() {
    }

    @Override
    public String toString() {
        return "PhieuDatBan{" + "maPhieuDatBan=" + maPhieuDatBan + ", ngayGioDat=" + ngayGioDat + ", soLuongNguoi=" + soLuongNguoi + ", hoTen=" + hoTen + ", sdt=" + sdt + ", ban=" + ban + '}';
    }
}
