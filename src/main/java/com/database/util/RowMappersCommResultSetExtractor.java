package com.database.util;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

public class RowMappersCommResultSetExtractor  extends RowMapperResultSetExtractor{
	  private final RowMapper rowMapper;
	  private final int rowsExpected;

	  public RowMappersCommResultSetExtractor(RowMapper rowMapper)
	  {
	    super(rowMapper, 0);
	    this.rowMapper = rowMapper;
	    this.rowsExpected = 0;
	  }
}
