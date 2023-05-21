package com.custom.orm.database.queryMaker;

import lombok.Data;

/**
 * @author Himal Rai on 5/21/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
public class FieldMaker {

    public FieldMaker() {

    }

    private static String typeConvertor(Object type) {
        return type.getClass().getName();
    }

    public static String fieldCreator( String field, Object type) {
        StringBuilder builder = new StringBuilder();
        String fields = field.concat(" ").concat(typeConvertor(type));
        builder.append(fields);
        return builder.toString();
    }
}
