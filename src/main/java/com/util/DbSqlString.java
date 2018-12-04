package com.util;

import java.sql.Types;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;

public class DbSqlString {

	public final static int  TypeSelect=0;
	public final static int  TypeInsert=1;
	public final static int  TypeUpdate=2;
	public final static int  TypeDelete=3;
	
	public final static int COLUMNTYPEINT = 0;	// int类型
	public final static int COLUMNTYPEDOUBLE = 1;	// number类型
	public final static int COLUMNTYPESTRING = 2;	// string类型
	public final static int COLUMNTYPEDATE = 3;     //int(日期)类型
	
	private int type=0;     //sql 0--select  1--insert   2--update  3--delete
	private String tmpSql;
	private String tmpValue=" values(";
	private String tmpWhere ="";
	private String tmpGroup = "";
	private String tmpOrder = "";
	private boolean reqAddComma=false;
	private boolean reqAddWhere=true;
	private boolean reqAddGroup=true;
	private boolean reqAddOrder=true;
	//private int dbType = 0; // 数据库类型 0：Oracle 1:DB2 2:MySql
	private Map<String,Integer> dbItemMap = null;

	public  DbSqlString(String tableName){
		this.type=0;
  	    tmpSql="select * from "+tableName;
	}

	public  DbSqlString(String tableName,String[] selectField){
		this.type=0;
		if(selectField==null||selectField.length==0)
		   tmpSql="select * from "+tableName;
		else{
			tmpSql="select ";
			for(int i=0;i<selectField.length;i++){
			  if(i!=0)
			  	tmpSql+=",";
			  tmpSql+=selectField[i];
			}
			tmpSql+=" from "+tableName;
		}
	}

	/**
	 * @param type   0--select  1--insert   2--update  3--delete
	 */
	public  DbSqlString(String tableName,int type){
		this.type=type;
		if(type==0)
			tmpSql="select * from "+tableName;	
		else if(type==1)
		   tmpSql = "insert into "+tableName+"(";
	    else if(type==2)
	    	tmpSql = "update "+tableName+" set ";
	    else
	    	tmpSql = " delete from "+tableName;

		/*// 针对mysql数据库，Integer类型数据更新为空值时出错
		// 更新操作，取得数据库类型和表字段类型
		if (type == 2) {
			initDBData(tableName);	
		}
		
		// 针对mysql数据库，数值类型空串插入更新为空值时出错 
		if (type == 1) {
			initDBData(tableName);
		}*/
	}

	/**
	 * 初始化数据表类型和表字段类型
	 * @param tableName
	 *//*
	private void initDBData(String tableName) {
		dbType=2;
		
		dbItemMap = TableNameColumnTypeIntegerCache.getInstance().get(tableName);
		
	}*/
	 
	public String getSqlString(){
		if(type==1){
			 tmpSql+=")";
			 tmpValue+=")";
			 return tmpSql+tmpValue ;
			}else if(type == DbSqlString.TypeSelect){
				return tmpSql+tmpWhere+tmpGroup+tmpOrder;
			}else
			 return tmpSql+tmpWhere;
		
	}

	/**
	 * 设定默认参数，规避SQL错误
	 * @param filedName
	 * @param filedValue
	 * @param defaultValue
	 * @param columntype
	 */
	public void set(String filedName, String filedValue, String defaultValue, int columntype) {
		if (Utils.isNullStr(filedValue)) {
			filedValue = defaultValue;
		}
		set(filedName, filedValue, columntype, false, false);
	}

	/**
	 * 设定默认
	 * @param filedName
	 * @param filedValue
	 * @param columntype
	 */
	public void set(String filedName, String filedValue, int columntype) {
		set(filedName, filedValue, columntype, false, false);
	}

	/**
	 * 数据库字段设置
	 * @param filedName 字段名称
	 * @param filedValue 字段值
	 * @param columntype 字段类型
	 * @param retMinus true
	 */
	public void set(String filedName, String filedValue, int columntype, boolean retMinus) {
		set(filedName, filedValue, columntype, retMinus, false);
	}

	/**
	 * 数据库字段设置
	 * @param filedName 字段名称
	 * @param filedValue 字段值
	 * @param columntype 字段类型
	 */
	public void set(String filedName, String filedValue, int columntype, boolean retMinus, boolean isTrimFlag) {

		if (filedValue != null) {
			if (columntype == COLUMNTYPEINT) {
				if (retMinus) {
					if (Utils.convObjToInt(filedValue) != 0) {
						set(filedName, -Utils.convObjToInt(filedValue));
					}
				} else {
					set(filedName, Utils.convObjToInt(filedValue));
				}
			} else if (columntype == COLUMNTYPEDOUBLE) {
				if (retMinus) {
					if (Utils.convObjToDouble(filedValue) != 0) {
						set(filedName, -Utils.convObjToDouble(filedValue));
					}
				} else {
					set(filedName, Utils.convObjToDouble(filedValue));
				}
			} else if (columntype == COLUMNTYPEDATE) {
				setDate(filedName, Utils.convObjToInt(filedValue));
			}else {
				if (isTrimFlag) {
					setWithTrim(filedName, filedValue);
				} else {
					set(filedName, filedValue);
				}
			}
		}
	}
	private void setWithTrim(String filedName, String filedValue) {
		if (filedValue != null) {
			addComma();
			if (type == 1) {
				tmpSql += filedName;
				tmpValue += "'" + filedValue.trim() + "'";
			} else
				tmpSql += filedName + "=" + "'" + filedValue.trim() + "'";
		}
	}
	
	/**
	 * 赋值
	 * @param filedName
	 * @param filedValue
	 */
	public void set(String filedName,String filedValue){
		if(type==0||type==3)
			return;
		
		//mysql数据库
		setForMysql(filedName,filedValue);
	}

	/**
	 * 针对MYSQL数据库，Integer类型数据插入更新为空值时出错
	 * @param filedName
	 * @param filedValue
	 */
	public void setForMysql(String filedName,String filedValue){
		if(filedValue!=null){
			addComma();
			filedValue = StringEscapeUtils.escapeSql(filedValue);//SQL特殊符号保存处理
			if(type==1){
				if ("".equals(filedValue)) {
					Integer itemType = dbItemMap.get(filedName.toUpperCase());
					if (Types.INTEGER == itemType||Types.DECIMAL == itemType||Types.NUMERIC == itemType||Types.DOUBLE == itemType) {
						tmpSql+=filedName;
				    	tmpValue+=null;
					}else{
						tmpSql+=filedName;
				    	tmpValue+="'"+filedValue+"'";
					}
				}else{
		    	tmpSql+=filedName;
		    	tmpValue+="'"+filedValue+"'";
				}
			}else {
				if ("".equals(filedValue)) {
					Integer itemType = dbItemMap.get(filedName.toUpperCase());
					if (Types.INTEGER == itemType||Types.DECIMAL == itemType||Types.NUMERIC == itemType||Types.DOUBLE == itemType) {
						tmpSql+=filedName+"="+ null;
					} else {
						tmpSql+=filedName+"="+"'"+filedValue+"'";
					}
				} else {
					tmpSql+=filedName+"="+"'"+filedValue+"'";
				}
			}
		}
	}
	/**
	 * 赋值
	 * @param filedName
	 * @param filedValue
	 */
	public void set(String filedName,long filedValue){
		if(type==0||type==3)
			return;
		addComma();
			
		if(type==1){
	    	tmpSql+=filedName;
	    	tmpValue+=filedValue;
		}else
			tmpSql+=filedName+"="+filedValue;
	     
	}
	
	/**
	 * 日期型格式
	 * @param filedName
	 * @param filedValue
	 */
	public void setDate(String filedName,long filedValue){
		if(type==0||type==3)
			return;
		addComma();
			
		if(type==1){
	    	tmpSql+=filedName;
	    	if(filedValue != 0)
	    		tmpValue+=filedValue;
	    	else
	    		tmpValue+=null;
		}else{
			if(filedValue != 0)
				tmpSql+=filedName+"="+ filedValue;	
			else
				tmpSql+=filedName+"="+ null;
		}
			
	}
	
	/**
	 * 赋值
	 * @param filedName
	 * @param filedValue
	 */	
	public void set(String filedName,double filedValue){
		if(type==0||type==3)
			return;
		
		addComma();
			
		if(type==1){
	    	tmpSql+=filedName;
	    	tmpValue+=filedValue;
		}else
			tmpSql+=filedName+"="+filedValue;
	     
	}
	

	
	/**
	 * 条件
	 * @param condition
	 */
	public void setWhere(String condition){
		
		if(type==1){
			return;
		}
	  if((condition!=null)&&(!condition.trim().equals(""))){
		  addWhereAnd();
	  
		tmpWhere+=condition;
	  }
	     
	}
	
	public void setWhere(String filedName,String filedValue,boolean isEmptyFlag){
		setWhere(filedName,"=",filedValue, isEmptyFlag);
	}
	
	public void setWhere(String filedName, String opr, String filedValue) {
		setWhere(filedName,opr,filedValue,false);
	}

	public void setWhere(String filedName,String filedValue){
		setWhere(filedName,"=",filedValue);
	}
	
	public void setWhere(String filedName,long filedValue){
		setWhere(filedName,"=",filedValue);
	}
	
	public void setWhere(String filedName,double filedValue){
		setWhere(filedName,"=",filedValue);
	}
	
	/**
	 * 拼接条件
	 * @param filedName	字段名
	 * @param opr 关系符
	 * @param filedValue	字段值
	 * @param isEmptyFlag 是否进行空串判断，如果为空串，忽略
	 */
	public void setWhere(String filedName,String opr,String filedValue, boolean isEmptyFlag){
		
		if(type==1||filedValue==null){
			return;
		}
		if(isEmptyFlag){
			if(Utils.isNullStr(filedValue)){
				return;
			}
		}
		 
		addWhereAnd();
		if(opr.toUpperCase().indexOf("LIKE") != -1 && filedValue.indexOf("%") != -1 && filedValue.indexOf("_") != -1){
			filedValue = "'"+filedValue.replaceAll("\\_", "\\\\_")+"'"+" escape '\\' ";
			tmpWhere+=filedName+" "+opr +" "+filedValue;
		}else{
			tmpWhere+=filedName+" "+opr+" "+"'"+filedValue+"'";
		}
 		
	    
	}
	
	public void setWhere(String filedName,String opr,long filedValue){
		if(type==1){
			return;
		}
		addWhereAnd();
		
		tmpWhere+=filedName+opr+filedValue;
	     
	}
	
	public void setWhere(String filedName,String opr,double filedValue){
		
		if(type==1){
			return;
		}
		addWhereAnd();
		
		tmpWhere+=filedName+opr+filedValue;
	     
	}
	
	private void addComma(){
		
		if(reqAddComma){
			tmpSql+=",";
			tmpValue+=",";
		}else
			reqAddComma=true;
	}
	
	private void addWhereAnd(){
		
		if(reqAddWhere){
			tmpWhere=" where ";
			reqAddWhere=false;
		}else
			tmpWhere+=" and ";
	}
	
	public void setGroup(String fieldName){
		if(type == DbSqlString.TypeSelect){
			addGroup();
			tmpGroup += fieldName;
		}
	}
	
	private void addGroup(){
		
		if(reqAddGroup){
			tmpGroup=" group by ";
			reqAddGroup=false;
		}else
			tmpGroup+=" , ";
	}
	public void setOrder(String fieldName){
		if(type == DbSqlString.TypeSelect){
			addOrder();
			tmpOrder += fieldName;
		}
	}
	
	private void addOrder(){
		
		if(reqAddOrder){
			tmpOrder=" order by ";
			reqAddOrder=false;
		}else
			tmpOrder+=" , ";
	}

	/**
	 * 拼接特殊sql
	 * @param sql
	 */
	public void addUniqueSql(String sql){
		tmpSql = tmpSql + sql;
	}
	
}
