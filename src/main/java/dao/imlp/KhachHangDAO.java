/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imlp;

import dao.IKhachHangDAO;
import dao.INhanVienDAO;
import entity.KhachHang;
import entity.NhanVien;
import jakarta.persistence.TypedQuery;

/**
 * @author Laptop
 */
public class KhachHangDAO extends AbstractDAO<KhachHang> implements IKhachHangDAO<KhachHang> {

    public KhachHang findByPhoneNumber(String phoneNumber) {
        TypedQuery<KhachHang> query = em.createNamedQuery("KhachHang.findByPhoneNumber", KhachHang.class);
        query.setParameter("sdt", phoneNumber);

        return !query.getResultList().isEmpty() ? query.getResultList().get(0) : null;
    }

}
