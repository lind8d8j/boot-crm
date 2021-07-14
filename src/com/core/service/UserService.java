package com.core.service;

import com.core.po.User;
import org.springframework.stereotype.Service;

public interface UserService {

	//通过账户和密码查询用户
	public User findUser(String usercode,String password);
}
