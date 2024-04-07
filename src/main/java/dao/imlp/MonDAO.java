/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IMonDAO;
import entity.Mon;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class MonDAO extends AbstractDAO<Mon> implements IMonDAO<Mon>{
    public List<Mon> findService() {
        return em.createNamedQuery("Mon.Service", Mon.class)
                .setParameter("trangThai",utils.Enum.LoaiTrangThaiMon.DANG_KINH_DOANH)
                .getResultList();
    };

    public List<Mon> findPopular() {
        return em.createNamedQuery("Mon.Popular").getResultList();
    };
}
