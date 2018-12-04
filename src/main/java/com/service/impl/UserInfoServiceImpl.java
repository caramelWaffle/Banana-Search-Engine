package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserInfoDao;
import com.entity.UserInfo;
import com.service.UserInfoService;
import com.util.MD5;
import com.util.Utils;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private UserInfoDao userInfoDao;

	@SuppressWarnings("rawtypes")
	public UserInfo find(UserInfo info) throws Exception {
		UserInfo userInfo = null;
		
		List list = new ArrayList();
		list = userInfoDao.find(info);
		if(list !=null && list.size() >0){
			Object obj = Utils.mapToBean(UserInfo.class,(Map)list.get(0));
			userInfo = (UserInfo)obj;
		}
		return userInfo;
	}
	
	public void save(UserInfo info) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setC_USER_NAME(info.getC_USER_NAME());
		userInfo.setC_NAME(info.getC_NAME());
		userInfo.setC_USER_PWD(MD5.md5(info.getC_USER_PWD()));
		userInfo.setC_ADDRESS_LINE1(info.getC_ADDRESS_LINE1());
		userInfo.setC_ADDRESS_LINE2(info.getC_ADDRESS_LINE2());
		userInfo.setC_TOWN(info.getC_TOWN());
		userInfo.setC_COUNTRY(info.getC_COUNTRY());
		userInfo.setC_EMAIL(info.getC_EMAIL());
		userInfo.setC_POST(info.getC_POST());
		userInfoDao.save(userInfo);
	}
	
	@SuppressWarnings("rawtypes")
	public boolean checkLogin(String c_user_name, String c_user_pwd) throws Exception{
		boolean isLogin = true;
		if(c_user_name==null || "".equals(c_user_name.trim()) || c_user_pwd==null || "".equals(c_user_pwd.trim())){
			isLogin = false;
		}
		List list = new ArrayList();
		list = userInfoDao.checkLogin(c_user_name, MD5.md5(c_user_pwd));
		if(list ==null || list.size() ==0){
			isLogin = false;
		}
		return isLogin;
	}
}
