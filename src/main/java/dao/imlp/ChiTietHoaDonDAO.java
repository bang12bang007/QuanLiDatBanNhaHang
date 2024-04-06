/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IChiTietHoaDonDAO;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class ChiTietHoaDonDAO extends AbstractDAO<ChiTietHoaDon> implements IChiTietHoaDonDAO<ChiTietHoaDon> {
    
    public List<ChiTietHoaDon> findByMaHoaDon(HoaDon hoaDon) {
        TypedQuery<ChiTietHoaDon> query = em.createNamedQuery("ChiTietHoaDon.findByMaHoaDon", ChiTietHoaDon.class);
        query.setParameter("hoaDon", hoaDon);
        return query.getResultList();
    }

}
