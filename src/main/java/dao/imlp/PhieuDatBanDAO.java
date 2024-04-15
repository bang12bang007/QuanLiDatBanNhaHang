/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IPhieuDatBanDAO;
import entity.Ban;
import entity.PhieuDatBan;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class PhieuDatBanDAO extends AbstractDAO<PhieuDatBan> implements IPhieuDatBanDAO<PhieuDatBan> {

    public boolean updateStateById(String id, Enum trangThai) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Query query = em.createNamedQuery("PhieuDatBan.updateState");
            query.setParameter("maPhieuDatBan", id);
            query.setParameter("trangThai", trangThai);
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
            Query query = em.createNamedQuery("PhieuDatBan.updateBanById");
            query.setParameter("maPhieuDatBan", id);
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

    @Override
    public List<PhieuDatBan> filterByDate(LocalDate date) {
        TypedQuery<PhieuDatBan> query = em.createNamedQuery("PhieuDatBan.filterByDate", PhieuDatBan.class);
        query.setParameter("date", date);

        return query.getResultList();
    }

}
