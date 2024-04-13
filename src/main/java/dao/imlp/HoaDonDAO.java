/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IHoaDonDAO;
import entity.Ban;
import entity.HoaDon;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import utils.Enum.LoaiTrangThaiHoaDon;

/**
 *
 * @author dmx
 */
public class HoaDonDAO extends AbstractDAO<HoaDon> implements IHoaDonDAO<HoaDon> {

    private LocalDateTime timeNow = LocalDateTime.now();
    private String month_format = String.format("%02d", timeNow.getMonthValue());
    private String date_format = String.format("%02d", timeNow.getDayOfMonth());
    private String hour_format = String.format("%02d", timeNow.getHour());
    private String generateTime = Integer.toString(timeNow.getYear()).substring(2, 4) + month_format + date_format + hour_format;

    public HoaDon findLast() {
        return em.createNamedQuery("HoaDon.Last", HoaDon.class)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    public String generateID() {
        HoaDon hoaDon = findLast();

        if (hoaDon != null) {
            String lastID = hoaDon.getMaHoaDon();
            if (checkSameDateTime(lastID)) {//truong hop cung ngay cung gio
                String increase_xxx = lastID.substring(10, 13);
                int generate_xxx = Integer.parseInt(increase_xxx);
                generate_xxx++;
                return "HD" + generateTime + String.format("%03d", generate_xxx);
            } else {//truong hop khac gio
                return "HD" + generateTime + String.format("%03d", 1);
            }
        }
        return "HD" + generateTime + String.format("%03d", 1);
    }

    public boolean checkSameDateTime(String lastID) {
        String regex = lastID.substring(2, 10);
        return regex.equalsIgnoreCase(generateTime);
    }

    public boolean insertHoaDon(HoaDon hoaDon) {
        hoaDon.setMaHoaDon(generateID());
        return insert(hoaDon);
    }

    public List<HoaDon> findOnOrder() {
        return em.createNamedQuery("HoaDon.OnOrdering", HoaDon.class)
                .setParameter("trangThai", LoaiTrangThaiHoaDon.CHUA_THANH_TOAN)
                .getResultList();
    }

    public List<HoaDon> findByState(Enum e) {
        return em.createNamedQuery("HoaDon.OnOrdering", HoaDon.class)
                .setParameter("trangThai", e)
                .getResultList();
    }

    public boolean updateStateById(String id, Enum state) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Query query = em.createNamedQuery("HoaDon.updateStateById");
            query.setParameter("maHoaDon", id);
            query.setParameter("trangThai", state);
            int rowsUpdated = query.executeUpdate();
            transaction.commit();
            return rowsUpdated > 0;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBanById(String id, Ban ban) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Query query = em.createNamedQuery("HoaDon.updateBanById");
            query.setParameter("maHoaDon", id);
            query.setParameter("ban", ban);
            int rowsUpdated = query.executeUpdate();
            transaction.commit();
            return rowsUpdated > 0;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
