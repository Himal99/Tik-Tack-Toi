package com.custom.orm.database.mapper;

import java.sql.ResultSet;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@FunctionalInterface
public interface SbRowMapper<T> {

    T mapRow(ResultSet resultSet) throws Exception;
}
