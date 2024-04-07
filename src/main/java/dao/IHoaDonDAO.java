/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.HoaDon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dmx
 */
public interface IHoaDonDAO<T> extends GenericDAO<T>{
    HoaDon findLast();
    boolean insertHoaDon(HoaDon hoadon);
    List<HoaDon> findOnOrder();
}
