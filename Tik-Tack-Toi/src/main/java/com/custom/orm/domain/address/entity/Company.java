package com.custom.orm.domain.address.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Himal Rai on 5/21/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
@Builder
public class Company {
    private int id;
    private String cName,cAddress,cCode;

    public  Object[] getObjects(){
        return new Object[]{this.id,this.cName,this.cAddress,this.cCode};
    }

    public static Company map(ResultSet rs) throws SQLException {
        return Company.builder().cName(rs.getString("cName"))
                .cAddress(rs.getString("cAddress"))
                .cCode(rs.getString("cCode"))
                .build();
    }
}
