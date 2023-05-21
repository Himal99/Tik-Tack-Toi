package com.custom.orm.domain.address.entity;

import com.custom.orm.database.generator.EntityMapper;
import lombok.Builder;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
@Builder
public class Address{
    private int id;
    private String name;


    public static Address map(ResultSet rs) throws SQLException {
        return Address.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build();
    }

    public  Object[] getObjects(){
        return new Object[]{this.id,this.getName()};
    }
}
