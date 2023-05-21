package com.custom.orm.domain.address.service;

import com.custom.orm.database.generator.TableGenerator;
import com.custom.orm.database.mapper.SbRowMapper;
import com.custom.orm.domain.address.entity.Address;
import com.custom.orm.domain.address.repo.AddressRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;

import static com.custom.orm.domain.address.sql.AddressSqlManager.*;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final TableGenerator generator;


   public AddressServiceImpl(AddressRepository orm, TableGenerator generator){
       this.repository = orm;
       this.generator = generator;
       generator.setMappedFinalColumns(Boolean.TRUE);
       this.repository.setTableName("address"); // this is your entity table name

   }
    @Override
    public String save(Address address) throws Exception{
        String sql=INSERT;
        repository.save(address.getObjects(),sql);
        return "success";
    }

    @Override
    public int createTable()throws Exception {
       /** example of table creation in database **/

        generator.setTableName("sbTable");
        Map<String, String> columns =
                new HashMap(){{
                    put("name","varchar(200)");
                    put("email","varchar(200)");
                    put("address","varchar(200)");
                    put("phone","varchar(200)");
                    put("country","varchar(200)");
                    put("state","varchar(200)");
                    put("ward","varchar(200)");
                    put("mun","varchar(200)");

                }};
        generator.setColumn(columns);
        System.out.println(generator.sql());
        return 0;
//        return repository.createTable(generator);
    }

    @Override
    public List<Address> findAll() throws Exception{
        return repository.findAll(Address::map);
    }

    @Override
    public Address findById(int id) throws Exception {
     return   repository.findById(id, Address::map).get(0);
    }

    @Override
    public String deleteById(int id) throws Exception {
        return repository.deleteById(id);
    }
}
