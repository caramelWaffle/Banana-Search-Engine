package com.database;

public class JdbcDaoImpl extends JdbcDaoSupport implements JdbcBaseDao{
	public String getString()
	{
	  return super.getSql();
	}
}
