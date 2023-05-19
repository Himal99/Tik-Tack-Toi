package com.custom.orm.domain.address.service;

import com.custom.orm.domain.address.entity.Address;

import java.util.List;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
public interface AddressService {
    String save(Address address)throws Exception;
    int createTable()throws Exception;
    List<Address> findAll()throws Exception;
    Address findById(int id)throws Exception;
    String deleteById(int id)throws Exception;
}
