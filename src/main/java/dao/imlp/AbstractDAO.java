/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.GenericDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;

import java.util.List;

/**
 *
 * @author Laptop
 */
public class AbstractDAO<T> implements GenericDAO<T> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("QLNH_mssql");
    protected EntityManager em = emf.createEntityManager();

    public boolean insert(T t) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(t);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    public boolean update(T t) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(t);
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

    public <T> boolean delete(String id, Class<T> claxx) {
        T t = findById(id, claxx);
        if (t != null) {
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
        } else {
            return false;
        }

    }

    public <T> T findById(String id, Class<T> claxx) {
        return em.find(claxx, id);
    }

    public <T> List<T> findAll(Class<T> t) {
        String jpql = "SELECT t from " + t.getName() + " t";
        return em.createQuery(jpql).getResultList();
    }

}
