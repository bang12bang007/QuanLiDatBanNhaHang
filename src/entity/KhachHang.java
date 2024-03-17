/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Laptop
 */
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String sdt;
    private String diaChi;

    public KhachHang(String tenKH, String sdt, String diaChi) {
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", diaChi=" + diaChi + '}';
    }
}
