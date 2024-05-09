/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Ban;
import entity.HoaDon;
import java.util.List;

/**
 * @author Laptop
 */
public interface IBanDAO<T> extends GenericDAO<T> {

    boolean updateStateById(String id, Enum state);

    List<Ban> findByFloor(int floor);

    List<Ban> findTableByStateAndFloor(Enum state, int floor);

    List<Ban> findTableByState(Enum state);

    List<Object[]> groupByMaTang();

    List<HoaDon> findListOrderbyBan(Ban ban);

    public List<Ban> getListBanGopInvoice(String maBan);

    public List<Ban> findByBanGop(Ban ban);
}
