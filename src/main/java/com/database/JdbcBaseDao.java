package com.database;

import java.util.List;

public abstract interface JdbcBaseDao {
	public abstract void save(String paramString)
		    throws Exception;

		  public abstract void save(List paramList)
		    throws Exception;

		  public abstract void exeSql(String paramString)
		    throws Exception;

		  public abstract void exeSql(List paramList)
		    throws Exception;

		  public abstract List find(String paramString)
		    throws Exception;

		  public abstract List find(String paramString, Class paramClass)
		    throws Exception;

		  public abstract List find(String paramString, Class[] paramArrayOfClass)
		    throws Exception;

		  public abstract List find(String paramString, int paramInt1, int paramInt2)
		    throws Exception;

		  public abstract List find(String paramString, Class paramClass, int paramInt1, int paramInt2)
		    throws Exception;

		  public abstract List find(String paramString, Class[] paramArrayOfClass, int paramInt1, int paramInt2)
		    throws Exception;
}
