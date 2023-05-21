package com.custom.orm.database.template;

import com.custom.orm.core.exception.SbDbServiceValidationException;
import com.custom.orm.database.connection.DbConnection;
import com.custom.orm.database.generator.TableGenerator;
import com.custom.orm.database.mapper.SbRowMapper;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
@Component
public class SbOrmTemplate<T> {
    /**
     * this is our custom CRUD operation manager class
     **/

    private String tableName;


    public List<T> findAll(SbRowMapper<T> mapper) throws Exception {
        String sql = "select *from " + tableName + "";
        List<T> list = new ArrayList<>();
        PreparedStatement statement = statement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            list.add(mapper.mapRow(resultSet));
        }

        return list;
    }

    public int save(Object[] objects, String sql) throws Exception {
        PreparedStatement stmt = statement(sql);
        int row = 1;
        for (Object o : objects) {
            stmt.setObject(row, o);
            row++;
        }
        return stmt.executeUpdate();
    }

    public int createTable(TableGenerator tableGenerator) throws Exception {
      try {
          Connection connection = DbConnection.getConnection();
          PreparedStatement statement = connection.prepareStatement(tableGenerator.sql());
          int row = statement.executeUpdate();
          return row;
      }catch (SQLException ex )
      {
          throw new SbDbServiceValidationException("something went wrong.. check if table name already exits");
      }
    }

    public List<T> findById(int id, SbRowMapper<T> mapper) throws Exception {
        String sql = "select *from " + tableName + " where id=?";
        List<T> list = new ArrayList<>();
        PreparedStatement statement = statement(sql);
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            list.add(mapper.mapRow(resultSet));
        }

        return list;
    }

    public void saveAll() throws Exception {
        //TODO:
    }

    public String deleteById(int id) throws Exception {
        String sql = "delete from " + tableName + " where id=?";
        PreparedStatement statement = statement(sql);
        statement.setObject(1, id);
        int row = statement.executeUpdate();
        return "SuccessFully deleted";
    }

    private PreparedStatement statement(String sql) throws Exception {
        Connection connection = DbConnection.getConnection();
        return connection.prepareStatement(sql);
    }

}
