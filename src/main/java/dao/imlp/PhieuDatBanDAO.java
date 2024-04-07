/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IPhieuDatBanDAO;
import entity.PhieuDatBan;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

/**
 *
 * @author Laptop
 */
public class PhieuDatBanDAO extends AbstractDAO<PhieuDatBan> implements IPhieuDatBanDAO<PhieuDatBan> {

    public boolean updateStateById(String id, int trangThai) {
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

}
