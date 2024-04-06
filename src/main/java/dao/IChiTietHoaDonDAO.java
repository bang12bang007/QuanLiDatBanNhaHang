/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IChiTietHoaDonDAO<T> extends GenericDAO<T> {

    List<T> findByMaHoaDon(HoaDon hoaDon);
}
