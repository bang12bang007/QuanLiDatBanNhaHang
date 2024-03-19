/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import utils.Enum.LoaiVaiTro;
import java.lang.annotation.*;
/**
 *
 * @author Laptop
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private String diaChi;
    private boolean trangThai;
    private int tuoi;
    private String soDienThoai;
    private Date ngayBatDauLam;
    private LoaiVaiTro vaiTro;
    private boolean gioiTinh;

    public NhanVien(String hoTen, String diaChi, boolean trangThai, int tuoi, String soDienThoai, Date ngayBatDauLam, LoaiVaiTro vaiTro, boolean gioiTinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.tuoi = tuoi;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauLam = ngayBatDauLam;
        this.vaiTro = vaiTro;
        this.gioiTinh = gioiTinh;
    }

    public NhanVien() {
    }
    
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayBatDauLam() {
        return ngayBatDauLam;
    }

    public void setNgayBatDauLam(Date ngayBatDauLam) {
        this.ngayBatDauLam = ngayBatDauLam;
    }

    public LoaiVaiTro getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(LoaiVaiTro vaiTro) {
        this.vaiTro = vaiTro;
    }
    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", trangThai=" + trangThai + ", tuoi=" + tuoi + ", soDienThoai=" + soDienThoai + ", ngayBatDauLam=" + ngayBatDauLam + ", vaiTro=" + vaiTro + ", gioiTinh=" + gioiTinh + '}';
    }
       
}
