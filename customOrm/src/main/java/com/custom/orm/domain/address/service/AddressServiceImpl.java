package com.custom.orm.domain.address.service;

import com.custom.orm.database.generator.TableGenerator;
import com.custom.orm.domain.address.entity.Address;
import com.custom.orm.domain.address.repo.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.custom.orm.domain.address.sql.AddressSqlManager.*;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository orm;
    private final TableGenerator generator;


   public AddressServiceImpl(AddressRepository orm, TableGenerator generator){
       this.orm = orm;
       this.generator = generator;
       this.orm.setTableName("address"); // this is your entity table name

   }
    @Override
    public String save(Address address) throws Exception{
        String sql=INSERT;
        orm.save(new Object[]{address.getId(),address.getName()},sql);

        return "success";
    }

    @Override
    public int createTable()throws Exception {
       /** example of table creation in database **/

        generator.setTableName("newEmployee");
        Map<String, Objects> columns =
                new HashMap(){{
                    put("name","varchar(200)");
                    put("email","varchar(200)");
                    put("address","varchar(200)");
                    put("phone","varchar(200)");
                    put("gender","varchar(200)");

                }};
        generator.setColumn(columns);
        System.out.println(generator.sql());
        return orm.createTable(generator);
    }

    @Override
    public List<Address> findAll() throws Exception{
        return orm.findAll(v -> {
            Address address =
                    Address.builder().id(v.getInt("id"))
                            .name(v.getString("name")).build();

            return address;
        });
    }

    @Override
    public Address findById(int id) throws Exception {
        Address address = null;
     return    orm.findById(id, resultSet -> {
         System.out.println(resultSet.getString("name"));
         return   Address.builder().id(resultSet.getInt("id"))
                 .name(resultSet.getString("name"))
                 .build();
     }).get(0);

    }

    @Override
    public String deleteById(int id) throws Exception {
        return orm.deleteById(id);
    }
}
