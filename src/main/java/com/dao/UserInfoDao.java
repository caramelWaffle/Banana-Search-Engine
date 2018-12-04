package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.database.JdbcDaoImpl;
import com.entity.UserInfo;
import com.util.DbSqlString;

@Repository
public class UserInfoDao extends JdbcDaoImpl{
	public UserInfoDao(DataSource dataSource) {
		super.dataSource = dataSource;
	}
	
	/**
	 * find user by c_user_name
	 * @param info
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List find(UserInfo info) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT C_USER_NAME,C_NAME,C_ADDRESS_LINE1,C_ADDRESS_LINE2,C_TOWN,C_COUNTRY,C_EMAIL,C_POST"
				+ "	FROM T_USER "
				+ "	WHERE 1=1 ");
		
		if(info !=null){
			if(info.getC_USER_NAME() !=null && !"".equals(info.getC_USER_NAME())){
				sb.append(" AND C_USER_NAME ='").append(info.getC_USER_NAME()).append("'");
			}
		}
		sb.append(" ORDER BY C_USER_NAME DESC");
		return find(sb.toString());
	}
	
	/**
	 * find user by c_user_name
	 * @param info
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List checkLogin(String c_user_name, String c_user_pwd) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT C_USER_NAME,C_NAME,C_ADDRESS_LINE1,C_ADDRESS_LINE2,C_TOWN,C_COUNTRY,C_EMAIL,C_POST"
				+ "	FROM T_USER "
				+ "	WHERE 1=1 ");
		
		sb.append(" AND C_USER_NAME ='").append(c_user_name).append("'");
		sb.append(" AND C_USER_PWD ='").append(c_user_pwd).append("'");
		
		return find(sb.toString());
	}
	
	/**
	 * save user info
	 * @param dictInfo
	 * @throws Exception
	 */
	public void save(UserInfo info) throws Exception{
		DbSqlString dss = new DbSqlString("T_USER", DbSqlString.TypeInsert);
		dss.set("C_USER_NAME", info.getC_USER_NAME(), DbSqlString.COLUMNTYPESTRING);
		dss.set("C_NAME", info.getC_NAME(), DbSqlString.COLUMNTYPESTRING);
		dss.set("C_USER_PWD", info.getC_USER_PWD(), DbSqlString.COLUMNTYPESTRING);
		dss.set("C_ADDRESS_LINE1", info.getC_ADDRESS_LINE1(), DbSqlString.COLUMNTYPESTRING);
		dss.set("C_ADDRESS_LINE2", info.getC_ADDRESS_LINE2(), DbSqlString.COLUMNTYPESTRING);
		dss.set("C_TOWN", info.getC_TOWN(), DbSqlString.COLUMNTYPESTRING);
		dss.set("C_COUNTRY", info.getC_COUNTRY(), DbSqlString.COLUMNTYPESTRING);
		dss.set("C_EMAIL", info.getC_EMAIL(), DbSqlString.COLUMNTYPESTRING);
		dss.set("C_POST", info.getC_POST(), DbSqlString.COLUMNTYPESTRING);
		
		exeSql(dss.getSqlString());
	}
	
}
