package com.custom.orm;

import com.custom.orm.database.generator.TableGenerator;
import com.custom.orm.domain.address.entity.Company;
import com.custom.orm.domain.address.repo.AddressRepository;
import com.custom.orm.domain.address.repo.CompanyRepository;
import com.custom.orm.domain.address.service.AddressService;
import com.custom.orm.domain.address.service.AddressServiceImpl;
import com.custom.orm.domain.address.service.CompanyService;
import com.custom.orm.domain.address.service.CompanyServiceImpl;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
public class Test {


    public static void main(String[] args) throws Exception {
        CompanyRepository repository = new CompanyRepository();
        TableGenerator generator = new TableGenerator();
        CompanyService addressService = new CompanyServiceImpl(repository, generator);

        System.out.println( addressService.findById(1).getCName());
    }

}
