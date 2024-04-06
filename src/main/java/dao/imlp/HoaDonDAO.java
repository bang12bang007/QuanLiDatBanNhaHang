/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IHoaDonDAO;
import entity.HoaDon;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class HoaDonDAO extends AbstractDAO<HoaDon> implements IHoaDonDAO<HoaDon> {

    public List<HoaDon> findAllBooking() {
        return em.createNamedQuery("HoaDon.findAllBooking", HoaDon.class).getResultList();
    }

}
