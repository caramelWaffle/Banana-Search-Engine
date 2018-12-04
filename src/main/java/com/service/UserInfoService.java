package com.service;

import com.entity.UserInfo;

public interface UserInfoService {
	/**
	 * find user
	 * @param info
	 * @return
	 */
	public UserInfo find(UserInfo info) throws Exception ;
	/**
	 * save user info
	 * @param UserInfo
	 */
	public void save(UserInfo userInfo) throws Exception ;
	/**
	 * check user login
	 * @param UserInfo
	 */
	public boolean checkLogin(String c_user_name, String c_user_pwd) throws Exception ;
}
