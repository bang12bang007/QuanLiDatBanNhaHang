/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Persistence;
import utils.Enum.LoaiTrangThai;
import utils.Enum.LoaiViTri;

/**
 *
 * @author Laptop
 */
@Entity
public class Ban {
    @Id
    private String maBan;
    private LoaiViTri viTri;
    private int soGhe;
    private LoaiTrangThai trangThai;
    private String maBanGop;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="maTang")
    private Tang tang;

    public Ban(LoaiViTri viTri, int soGhe, LoaiTrangThai trangThai, Tang tang) {
        this.viTri = viTri;
        this.soGhe = soGhe;
        this.trangThai = trangThai;
        this.tang = tang;
    }

    public Ban() {
    }

    public String getMaBan() {
        return maBan;
    }

    public LoaiViTri getViTri() {
        return viTri;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public LoaiTrangThai getTrangThai() {
        return trangThai;
    }

    public String getMaBanGop() {
        return maBanGop;
    }

    public Tang getTang() {
        return tang;
    }

    public void setViTri(LoaiViTri viTri) {
        this.viTri = viTri;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public void setTrangThai(LoaiTrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public void setMaBanGop(String maBanGop) {
        this.maBanGop = maBanGop;
    }

    public void setTang(Tang tang) {
        this.tang = tang;
    }

    @Override
    public String toString() {
        return "Ban{" + "maBan=" + maBan + ", viTri=" + viTri + ", soGhe=" + soGhe + ", trangThai=" + trangThai + ", maBanGop=" + maBanGop + ", tang=" + tang + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.maBan);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ban other = (Ban) obj;
        return Objects.equals(this.maBan, other.maBan);
    }
    
    
    public static void main(String[] args) {
		Persistence.createEntityManagerFactory("QLNH_mssql");
	}
}
