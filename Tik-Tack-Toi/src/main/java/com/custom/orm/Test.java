package com.custom.orm;

import com.custom.orm.database.queryMaker.QueryMaker;
import com.custom.orm.domain.address.entity.Company;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
public class Test {


    public static void main(String[] args) throws Exception {
        QueryMaker<Company> queryMaker = new QueryMaker<>();

        queryMaker.generateFields();
    }

}
