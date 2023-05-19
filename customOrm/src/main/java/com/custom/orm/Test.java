package com.custom.orm;

import com.custom.orm.domain.address.repo.AddressRepository;
import com.custom.orm.domain.address.service.AddressService;
import com.custom.orm.domain.address.service.AddressServiceImpl;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
public class Test {


    public static void main(String[] args) throws Exception {
        AddressRepository repository = new AddressRepository();
        AddressService addressService = new AddressServiceImpl(repository, generator);

       addressService.createTable();
    }

}
