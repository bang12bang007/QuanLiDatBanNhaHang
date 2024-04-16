/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Mon;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Laptop
 */
public interface IMonDAO<T> extends GenericDAO<T>{
    List<Mon> findService();
    Map<Mon,Long> findPopular();
    List<Mon> findOthers();
}
