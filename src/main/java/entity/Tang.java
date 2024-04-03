/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *
 * @author dmx
 */
@Entity
public class Tang {
	@Id
    private String maTang;
    private String tenTang;
    private int sucChua;
    private String moTa;

    public String getMaTang() {
        return maTang;
    }

    public String getTenTang() {
        return tenTang;
    }

    public int getSucChua() {
        return sucChua;
    }

    public String getMoTa() {
        return moTa;
    }

    public Tang() {
    }

    public Tang(String tenTang, int sucChua, String moTa) {
        this.tenTang = tenTang;
        this.sucChua = sucChua;
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "Tang{" + "maTang=" + maTang + ", tenTang=" + tenTang + ", sucChua=" + sucChua + ", moTa=" + moTa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.maTang);
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
        final Tang other = (Tang) obj;
        return Objects.equals(this.maTang, other.maTang);
    }

    public void setTenTang(String tenTang) {
        this.tenTang = tenTang;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
}
