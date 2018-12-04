package com.database.util;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

public class RowMappersResultSetExtractor extends RowMapperResultSetExtractor
{
	  private int firstRow = 0;
	  private final RowMapper rowMapper;
	  private final int rowsExpected;

	  public RowMappersResultSetExtractor(RowMapper rowMapper)
	  {
	    super(rowMapper, 0);
	    this.rowMapper = rowMapper;
	    this.rowsExpected = 0;
	  }

	  public RowMappersResultSetExtractor(RowMapper rowMapper, int rowsExpected) {
	    super(rowMapper, rowsExpected);
	    this.rowMapper = rowMapper;
	    this.rowsExpected = rowsExpected;
	  }
	  public void setFirstRow(int firstRow) {
	    this.firstRow = firstRow;
	  }
	  public int getFirstRow() {
	    return this.firstRow;
	  }
	  public List extractData(ResultSet rs) throws SQLException {
	    List results = this.rowsExpected > 0 ? new ArrayList(this.rowsExpected) : 
	      new ArrayList();
	    int rowNum = 0;

	    if (rs.hashCode() > 0)
	    {
	      try
	      {
	        rs.absolute(this.firstRow);
	      } catch (Exception e) {
	        System.out.println(e.getMessage());
	        for (int m = 0; m < this.firstRow; m++) {
	          rs.next();
	        }

	      }

	    }

	    while (rs.next()) {
	      results.add(this.rowMapper.mapRow(rs, rowNum++));
	    }

	    return results;
	  }
}