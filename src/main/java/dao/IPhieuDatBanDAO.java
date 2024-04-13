/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Ban;
import entity.PhieuDatBan;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Laptop
 */
public interface IPhieuDatBanDAO<T> extends GenericDAO<T> {

    boolean updateStateById(String id, int trangThai);

    boolean updateBanById(String id, Ban ban);

    List<PhieuDatBan> filterByDate(LocalDate date);

}
