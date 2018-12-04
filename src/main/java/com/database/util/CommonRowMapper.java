package com.database.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.support.JdbcUtils;

public class CommonRowMapper extends ColumnMapRowMapper
{
  public Map<String, Object> mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    synchronized (rs) {
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount();
      Map mapOfColValues = createColumnMap(columnCount);

      for (int i = 1; i <= columnCount; i++) {
        String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
        String type = rsmd.getColumnTypeName(i);
        Object obj = getColumnValue(rs, i);
        if (obj == null) obj = "";
        if ((type.equalsIgnoreCase("char")) && 
          (obj != null)) {
          obj = obj.toString().trim();
        }
        key = key.toUpperCase();
        mapOfColValues.put(key, obj);
      }

      return mapOfColValues;
    }
  }
}