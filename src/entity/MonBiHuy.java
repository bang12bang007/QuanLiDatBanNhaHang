/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author dmx
 */
public class MonBiHuy {
    private String maMonBiHuy;
    private Mon mon;
    private int soLuong;
    private String lyDo;

    public MonBiHuy(Mon mon, int soLuong, String lyDo) {
        this.mon = mon;
        this.soLuong = soLuong;
        this.lyDo = lyDo;
    }

    public MonBiHuy() {
    }
    
    public String getMaMonBiHuy() {
        return maMonBiHuy;
    }

    public Mon getMon() {
        return mon;
    }

    public void setMon(Mon mon) {
        this.mon = mon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    @Override
    public String toString() {
        return "MonBiHuy{" + "maMonBiHuy=" + maMonBiHuy + ", mon=" + mon + ", soLuong=" + soLuong + ", lyDo=" + lyDo + '}';
    }
}
