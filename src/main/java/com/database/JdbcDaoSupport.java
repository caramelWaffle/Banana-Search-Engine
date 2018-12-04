package com.database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.database.util.CommonRowMapper;
import com.database.util.DaoRowMapper;
import com.database.util.RowMappersCommResultSetExtractor;
import com.database.util.RowMappersResultSetExtractor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDaoSupport extends JdbcTemplate{
	
	protected DataSource dataSource;
	protected String logId = "000000000ll";
	private JdbcTemplate jt;
	public String sql;

	public String getSql(){
		return this.sql;
	}
	
	public DataSource getDataSource(){
	    return this.dataSource;
	}
	
	public void setLogId(String logId) {
	    this.logId = logId;
	}

	/*private NamedParameterJdbcTemplate getNameJdbcTemplate(){
		return new NamedParameterJdbcTemplate(getDataSource());
	}*/

	public void save(String sql) throws Exception{
	    exeSql(sql);
	}

	public void save(Object object) throws Exception{
		
	}

	public void save(List sql) throws Exception{
	    exeSql(sql);
	}

	public void exeSql(String sql) throws Exception{
	    try {
	      this.jt = new JdbcTemplate(this.dataSource);
	      this.jt.execute(sql);
	      this.sql = sql;
	    } catch (Exception e) {
	      e.printStackTrace();
	      throw new Exception("执行sql删除或更新时出错\n" + e.getMessage(), e);
	    }
	  }

	public void exeSql(List sql)throws Exception{
	    int maxCount = 10000;
	    int totCount = sql == null ? 0 : sql.size();
	    this.jt = new JdbcTemplate(this.dataSource);
	    for (int i = 0; i <= totCount / maxCount; i++) {
	      int thisCount = maxCount;
	      if (i == totCount / maxCount)
	      {
	        thisCount = totCount % maxCount;
	      }
	      try {
	        ////writeLog("批量更新sql=" + sql);
	        String[] sqls = new String[thisCount];
	        for (int j = 0; j < thisCount; j++) {
	          sqls[j] = ((String)sql.get(i * maxCount + j));
	        }
	        this.jt.batchUpdate(sqls);
	      } catch (Exception e) {
	        e.printStackTrace();
	        throw new Exception("执行sql批量删除或更新时出错\n" + e.getMessage(), e);
	      }
	    }
	  }

	  public List find(String sql) throws Exception{
		  List list = null;
		  try {
			  ////writeLog("结果集获取sql=" + sql);
			  RowMappersCommResultSetExtractor rxtractor = new RowMappersCommResultSetExtractor(new CommonRowMapper());

			  this.jt = new JdbcTemplate(this.dataSource);
			  list = (List)this.jt.query(sql, rxtractor);
		  }catch (Exception e) {
			  e.printStackTrace();
			  throw new Exception("执行sql查询出错\n" + e.getMessage(), e);
		  }
	   	  return list;
	  }

	  public List find(String sql, Class pojo) throws Exception{
		  	////writeLog("结果集获取sql=" + sql);
		  	List list = null;
		    try {
		      this.jt = new JdbcTemplate(this.dataSource);
		      list = this.jt.query(sql, new DaoRowMapper(pojo));
		    } catch (Exception e) {
		      e.printStackTrace();
		      throw new Exception("执行sql查询时出错\n" + e.getMessage(), e);
		    }
		    return list;
	  }

	  public List find(String sql, Class[] pojo)
	    throws Exception
	  {
	    //writeLog("结果集获取sql=" + sql);
	    List list = null;
	    try {
	      this.jt = new JdbcTemplate(this.dataSource);
	      list = this.jt.query(sql, new DaoRowMapper(pojo));
	    } catch (Exception e) {
	      e.printStackTrace();
	      throw new Exception("执行sql查询时出错\n" + e.getMessage(), e);
	    }
	    return list;
	  }

	  public List find(String sql, int pageFirst, int pageRow) throws Exception{
		  List list = null;
	  	  try {
		      this.jt = new JdbcTemplate(this.dataSource);
		      int maxCount = pageFirst + pageRow;
		      this.jt.setMaxRows(maxCount);
		      ////writeLog("结果集获取sql=" + sql);
		      RowMappersResultSetExtractor rxtractor = new RowMappersResultSetExtractor(new CommonRowMapper());
	
		      rxtractor.setFirstRow(pageFirst);
	
		      list = (List)this.jt.query(new UpdateablePreparedStatementCreator(sql), rxtractor);
	  	  }
	  	  catch (Exception e)
	  	  {
		      e.printStackTrace();
		      throw new Exception("执行sql分页查询时出错\n" + e.getMessage(), e);
	  	  }
	  	  return list;
	  }

	  public List find(String sql, Class pojo, int pageFirst, int pageRow) throws Exception{
	      List list = null;
		      try {
		      this.jt = new JdbcTemplate(this.dataSource);
		      this.jt.setMaxRows(pageRow);
		      ////writeLog("结果集获取sql=" + sql);
		      RowMappersResultSetExtractor rxtractor = new RowMappersResultSetExtractor(new DaoRowMapper(pojo));
	
		      rxtractor.setFirstRow(pageFirst);
		      list = (List)this.jt.query(sql, rxtractor);
		  } catch (Exception e) {
		      e.printStackTrace();
		      throw new Exception("执行sql分页查询时出错\n" + e.getMessage(), e);
		  }

		  return list;
	  }

	  public List find(String sql, Class[] pojo, int pageFirst, int pageRow) throws Exception {
	      List list = null;
	      try {
		      this.jt = new JdbcTemplate(this.dataSource);
		      this.jt.setMaxRows(pageRow);
		      ////writeLog("结果集获取sql=" + sql);
		      RowMappersResultSetExtractor rxtractor = new RowMappersResultSetExtractor(new DaoRowMapper(pojo));
	
		      rxtractor.setFirstRow(pageFirst);
		      list = (List)this.jt.query(sql, rxtractor);
		  } catch (Exception e) {
		      e.printStackTrace();
		      throw new Exception("执行sql分页查询时出错\n" + e.getMessage(), e);
		  }
	      return list;
	  }

	  public Connection getConnection() throws Exception{
	    Connection conn = null;
	    try {
	      this.jt = new JdbcTemplate(this.dataSource);
	      conn = this.jt.getDataSource().getConnection();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      throw new Exception("获取数据库连接出错\n" + e.getMessage(), e);
	    }
	    return conn;
	  }

	  public void closeConnection(Connection conn) throws Exception {
	    try
	    {
	      DataSourceUtils.releaseConnection(conn, getDataSource());
	    } catch (Exception e) {
	      throw new Exception("jdbc数据库关闭错误\n" + e.getMessage(), e);
	    }
	  }

	  public void closeConnection() throws Exception {
	    Connection con = null;
	    try {
	      con = getDataSource().getConnection();
	      if (con != null)
	        con.close();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      throw new Exception("关闭数据库联接出错\n" + e.getMessage(), e);
	    }
	  }

	  /*protected void writeLog(String logInfo) throws Exception
	  {
	    String isTrue = SCacheManage.getInstance().getValue("jdbcinfo", "showSql");
	    if (isTrue.equals("true"))
	      Log.getInstance().info(this.logId, logInfo);
	  }*/
	  class FindablePreparedStatementCreator
	    implements PreparedStatementCreator, SqlProvider
	  {
	    private String sql;

	    public FindablePreparedStatementCreator(String sql)
	    {
	      this.sql = sql;
	    }

	    public PreparedStatement createPreparedStatement(Connection con) throws SQLException
	    {
	      return con.prepareStatement(this.sql);
	    }

	    public String getSql()
	    {
	      return this.sql;
	    }
	  }

	  class UpdateablePreparedStatementCreator
	    implements PreparedStatementCreator, SqlProvider
	  {
	    private String sql;

	    public UpdateablePreparedStatementCreator(String sql)
	    {
	      this.sql = sql;
	    }

	    public PreparedStatement createPreparedStatement(Connection con) throws SQLException
	    {
	      return con.prepareStatement(this.sql);
	    }

	    public String getSql()
	    {
	      return this.sql;
	    }
	  }
}
