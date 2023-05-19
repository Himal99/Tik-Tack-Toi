package com.custom.orm.database.generator;

import com.custom.orm.core.exception.SbDbServiceValidationException;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
@Component
public class TableGenerator {
    private String idType;
    private String tableName;
    private String pk= "id int primary key";
    private Map<String, Objects> column = new HashMap<>();

    public String sql(){
        StringBuilder table = new StringBuilder("create table");
        table.append(" ").append(tableName);
        table.append("(");
        table.append(pk);
        table.append(",");
        table.append("");
        for (Map.Entry<String,Objects> m: column.entrySet()){
            String columnNAme = m.getKey()+" "+m.getValue();
            table.append(columnNAme).append(",");
        }
        table.append(")");
        return table.toString().replace(",)",")");
    }

    public String generateQueryFromFile(String file)throws Exception{
        File queryFile = new File(file);
        if (!queryFile.exists())throw new SbDbServiceValidationException("No file found");

        BufferedReader reader =
                new BufferedReader(new FileReader(queryFile));
        String query;
        StringBuilder builder = new StringBuilder("create table");
        builder.append(" ").append(tableName);
        String filterQuery[]=null;
        while ((query=reader.readLine()) != null){
            query +=query;
        }
        filterQuery = query.split(",");

        return filterQuery.toString();
    }

    public String showQuery(){
        if (StringUtils.hasText(sql()))
            return sql();
        return "Query is empty";
    }


}
