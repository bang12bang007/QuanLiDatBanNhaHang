/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Laptop
 */
public interface IPhieuDatBanDAO<T> extends GenericDAO<T> {

    boolean updateStateById(String id, int trangThai);
}
