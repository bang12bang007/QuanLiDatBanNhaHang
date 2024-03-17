/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author dmx
 */
public class DichVu {
    private String maDichVu;
    private String tenDichVu;
    private String quyMo;
    private Double gia;

    public DichVu(String tenDichVu, String quyMo, Double gia) {
        this.tenDichVu = tenDichVu;
        this.quyMo = quyMo;
        this.gia = gia;
    }

    public DichVu() {
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getQuyMo() {
        return quyMo;
    }

    public void setQuyMo(String quyMo) {
        this.quyMo = quyMo;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "DichVu{" + "maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", quyMo=" + quyMo + ", gia=" + gia + '}';
    }
}
