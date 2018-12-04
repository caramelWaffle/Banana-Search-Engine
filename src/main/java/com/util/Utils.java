package com.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Utils {
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param s
	 *            字符串
	 * @return true为空 false 不为空
	 */
	public static boolean isNullStr(String s) {
		if (s == null || s.trim().length() <= 0)
			return true;
		else
			return false;
	}
	
	public static int convObjToInt(String str) {
		return Utils.isNullStr(str) ? 0 : Integer.valueOf(str.trim()).intValue();
	}
	
	public static double convObjToDouble(String str) {
		return Utils.isNullStr(str) ? 0 : Double.valueOf(str.trim()).doubleValue();
	}
	
	public static String getDateTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
    	String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    	return date;
	}
	
    @SuppressWarnings("rawtypes")
	public static Object mapToBean(Class type, Map map) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        Object obj=type.newInstance();
        PropertyDescriptor[] propertyDescriptors=beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor:propertyDescriptors) {
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)){
                Object value = map.get(propertyName);
                descriptor.getWriteMethod().invoke(obj,value);
            }
        }
        return obj;
    }
    
}
