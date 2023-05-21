package com.custom.orm.database.queryMaker;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Himal Rai on 5/21/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
@Component
public class QueryMaker<PK> {

    /**TODO: work in progress **/

    private PK obj;

    public void generateFields() {

        System.out.println("sa");
        if (!ObjectUtils.isEmpty(obj)) {
            try {
                Field[] allFields = obj.getClass().getFields();
                List<String> list = Arrays.stream(allFields).
                        map(fi -> fi.getName()).
                        collect(Collectors.toList());

                list.forEach(l -> System.out.println(l));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            obj = null;
            Field[] allFields = obj.getClass().getFields();
            System.out.println(allFields.length);
            List<String> list = Arrays.stream(allFields).
                    map(fi -> fi.getName()).
                    collect(Collectors.toList());

            list.forEach(l -> System.out.println(l));
        }
    }

    protected String generateQuery(Map<Object, String> fields) {
        StringBuilder builder = new
                StringBuilder("create table").append(obj.getClass().getName().toString()).append("(");

        fields.forEach((key, value) -> {
            builder.append(FieldMaker.fieldCreator(key.toString(), value));
        });
        builder.append(")");
        return builder.toString().replace(",)", ")");
    }


}
