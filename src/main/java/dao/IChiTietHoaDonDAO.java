/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Mon;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author dmx
 */
public interface IChiTietHoaDonDAO<T> extends GenericDAO<T> {

    Double TotalFoodCurrency(HoaDon hoaDon);

    List<ChiTietHoaDon> getListByHoaDon(HoaDon hoaDon);

    Map<Mon, Long> getListByBan(HoaDon hoaDon);

    List<ChiTietHoaDon> getListBySoLuong(int soLuong);

    boolean deleteChiTiet(ChiTietHoaDon t);

    List<Object[]> sumSoLuongByMaMon();

    List<Object[]> sumSoLuongByMaMonByDate(LocalDateTime ngayYeuCau);

}
