package com.custom.orm.core.service;

import com.custom.orm.domain.address.entity.Address;

import java.util.List;

/**
 * @author Himal Rai on 5/21/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
public interface BaseService<T>{
    String save(T o)throws Exception;
    int createTable()throws Exception;
    List<T> findAll()throws Exception;
    T findById(int id)throws Exception;
    String deleteById(int id)throws Exception;
}
