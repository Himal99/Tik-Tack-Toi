package com.custom.orm.database.generator;

import com.custom.orm.core.exception.SbDbServiceValidationException;
import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
@Component
@PropertySource("classpath:application.properties")
public class TableGenerator<PK> {


    private final PK id;
    private String idType;
    private String tableName;
    private String pk;
    private Map<String, String> column = new HashMap<>();
    private Boolean mappedFinalColumns = Boolean.FALSE;
    private Boolean enableVersion = Boolean.FALSE;


    public String sql() {
        pk = id instanceof Long ? "id Long primary key" : "id int primary key";

        StringBuilder table = new StringBuilder("create table");
        table.append(" ").append(tableName);
        table.append("(");
        table.append(pk);
        table.append(",");
        table.append("");

        if (mappedFinalColumns) column.putAll(finalTableColumns());

        for (Map.Entry<String, String> m : column.entrySet()) {
            String columnNAme = m.getKey() + " " + m.getValue();
            table.append(columnNAme).append(",");
        }
        table.append(")");
        System.out.println("Generate Sql Query: " + table.toString().replace(",)", ")"));
        return table.toString().replace(",)", ")");
    }

    private Map<String, String> finalTableColumns() {
        if (enableVersion) column.put("version", "int");
        return new HashMap() {{
            put("created_At", "date default current_timestamp");
            put("modified_At", "date default current_timestamp");
        }};
    }


    public String generateQueryFromFile(String file) throws Exception {
        File queryFile = new File(file);
        if (!queryFile.exists()) throw new SbDbServiceValidationException("No file found");

        BufferedReader reader =
                new BufferedReader(new FileReader(queryFile));
        String query;
        StringBuilder builder = new StringBuilder("create table");
        builder.append(" ").append(tableName);
        String filterQuery[] = null;
        while ((query = reader.readLine()) != null) {
            query += query;
        }
        filterQuery = query.split(",");

        return filterQuery.toString();
    }

    public String showQuery() {
        if (StringUtils.hasText(sql()))
            return sql();
        return "Query is empty";
    }


}
