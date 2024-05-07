/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 * @author Laptop
 */
public interface GenericDAO<T> {

    boolean insert(T t);

    boolean update(T t);

    <T> boolean delete(String id, Class<T> claxx);

    <T> T findById(String id, Class<T> t);

    <T> List<T> findAll(Class<T> t);
}
