package com.custom.orm.domain.address.sql;

import lombok.Data;

/**
 * @author Himal Rai on 5/21/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
public class CompanySqlManager {
    public static String INSERT= """
            insert into company(id,cName,cAddress,cCode)values(?,?,?,?)
            """;
}
