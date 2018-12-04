package com.database.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSetMetaData;

public class DaoRowMapper implements RowMapper{
	private Class pojoClass;
	  private Class[] pojos;

	  public DaoRowMapper(Class pojoClass)
	  {
	    this.pojoClass = pojoClass;
	  }
	  public DaoRowMapper(Class[] pojos) {
	    this.pojos = pojos;
	  }
	  public Object mapRow(ResultSet rs, int index) throws SQLException {
	    Object object = null;
	    Object[] objs = (Object[])null;
	    try {
	      if (this.pojoClass != null) {
	        object = this.pojoClass.newInstance();
	      }
	      if (this.pojos != null) {
	        objs = new Object[this.pojos.length];
	        for (int i = 0; i < this.pojos.length; i++) {
	          Object obj = this.pojos[i].newInstance();
	          objs[i] = obj;
	        }
	      }
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }
	    ResultSetWrappingSqlRowSetMetaData wapping = 
	      new ResultSetWrappingSqlRowSetMetaData(rs.getMetaData());
	    try {
	      for (int i = 1; i <= wapping.getColumnCount(); i++) {
	        String name = wapping.getColumnName(i);
	        name = name.replaceAll("_", "").trim();
	        Object value = rs.getObject(i);
	        String type = wapping.getColumnTypeName(i);
	        if ((type.equalsIgnoreCase("char")) && 
	          (value != null)) {
	          value = value.toString().trim();
	        }

	        if (object != null)
	          ReflectionBeanUtils.setFieldValue(object, name, value);
	        else
	          ReflectionBeanUtils.setFieldValue(objs, name, value);
	      }
	    }
	    catch (Exception e) {
	      throw new RuntimeException(e);
	    }
	    if ((objs != null) && (object == null))
	      object = objs;
	    return object;
	  }
}
