/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.util.List;

/**
 *
 * @author dmx
 */
public interface IChiTietHoaDonDAO<T> extends GenericDAO<T>{
    Double TotalFoodCurrency(HoaDon hoaDon);
    List<ChiTietHoaDon> getListByHoaDon(HoaDon hoaDon);
}
