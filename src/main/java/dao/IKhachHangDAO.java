/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.KhachHang;
import entity.NhanVien;

/**
 * @author Laptop
 */
public interface IKhachHangDAO<T> extends GenericDAO<T> {
    KhachHang findByPhoneNumber(String phoneNumber);
}
