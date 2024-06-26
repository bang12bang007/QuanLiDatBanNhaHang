/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IMonDAO;
import entity.Mon;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Laptop
 */
public class MonDAO extends AbstractDAO<Mon> implements IMonDAO<Mon> {
    public List<Mon> findService() {
        return em.createNamedQuery("Mon.Service", Mon.class)
                .setParameter("trangThai", utils.Enum.LoaiTrangThaiMon.DANG_KINH_DOANH)
                .getResultList();
    }

    ;

    public Map<Mon, Long> findPopular() {
        Map<Mon, Long> map = new LinkedHashMap<>();
        List<?> list = em.createNamedQuery("Mon.Popular5")
                .getResultList();
        list.stream()
                .map(o -> (Object[]) o)
                .forEach(a -> {
                    long soLuong = (long) a[0];
                    Mon mon = (Mon) a[1];
                    map.put(mon, soLuong);
                });
        return map;
    }

    ;

    @Override
    public List<Mon> findOthers() {
        return em.createNamedQuery("Mon.Other", Mon.class)
                .getResultList();
    }
}
