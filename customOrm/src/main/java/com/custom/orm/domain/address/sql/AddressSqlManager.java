package com.custom.orm.domain.address.sql;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
public class AddressSqlManager {
    public static String FIND_DALL= """
            select *from address
            """;
    public static String FIND_BY_ID= """
            select *from address where id=?
            """;
    public static String INSERT= """
            insert into address(id,name)values(?,?)
            """;
    public static String DELETE_BY_ID="""
            delete from address where id=?
            """;

}
