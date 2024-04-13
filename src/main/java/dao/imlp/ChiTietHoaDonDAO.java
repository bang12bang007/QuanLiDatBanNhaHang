/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IChiTietHoaDonDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 *
 * @author dmx
 */
public class ChiTietHoaDonDAO extends AbstractDAO<ChiTietHoaDon> implements IChiTietHoaDonDAO<ChiTietHoaDon> {

    public Double TotalFoodCurrency(HoaDon hoaDon) {
        List<ChiTietHoaDon> details = getListByHoaDon(hoaDon);
        Double total = 0.0;
        for (int i = 0; i < details.size(); i++) {
            total += details.get(i).getSoLuong() * details.get(i).getMon().getGia();
        }
        return total;
    }

    ;

    public List<ChiTietHoaDon> getListByHoaDon(HoaDon hoaDon) {
        return em.createNamedQuery("ChiTietHoaDon.HoaDon", ChiTietHoaDon.class)
                .setParameter("hoaDon", hoaDon)
                .getResultList();
    }

    ;

    @Override
    public List<ChiTietHoaDon> getListBySoLuong(int soLuong) {
        return em.createNamedQuery("ChiTietHoaDon.DS_SoLuong", ChiTietHoaDon.class)
                .setParameter("soLuong", soLuong)
                .getResultList();
    }

    @Override
    public boolean deleteChiTiet(ChiTietHoaDon t) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
;
}
