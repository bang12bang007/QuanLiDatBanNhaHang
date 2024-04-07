/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IChiTietHoaDonDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.util.List;

/**
 *
 * @author dmx
 */
public class ChiTietHoaDonDAO extends AbstractDAO<ChiTietHoaDon> implements IChiTietHoaDonDAO<ChiTietHoaDon>{

    public Double TotalFoodCurrency(HoaDon hoaDon) {
        List<ChiTietHoaDon> details = getListByHoaDon(hoaDon);
        Double total = 0.0;
        for(int i=0;i<details.size();i++){
            total+= details.get(i).getSoLuong()*details.get(i).getMon().getGia();
        }
        return total;
    };

    public List<ChiTietHoaDon> getListByHoaDon(HoaDon hoaDon) {
      return em.createNamedQuery("ChiTietHoaDon.HoaDon", ChiTietHoaDon.class)
              .setParameter("hoaDon", hoaDon)
              .getResultList();  
    };
}
