/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Laptop
 */
public class Mon {
    private String maMon;
    private String tenMon;
    private Double gia;
    private KhuyenMai khuyenMai;
    private LoaiMon loaiMon;
    private String hinhAnh;

    public Mon(String tenMon, Double gia, LoaiMon loaiMon, String hinhAnh) {
        this.tenMon = tenMon;
        this.gia = gia;
        this.loaiMon = loaiMon;
        this.hinhAnh = hinhAnh;
    }

    public Mon() {
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public LoaiMon getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(LoaiMon loaiMon) {
        this.loaiMon = loaiMon;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "Mon{" + "maMon=" + maMon + ", tenMon=" + tenMon + ", gia=" + gia + ", khuyenMai=" + khuyenMai + ", loaiMon=" + loaiMon + ", hinhAnh=" + hinhAnh + '}';
    }
}
