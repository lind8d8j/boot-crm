package com.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.core.po.User;

/**
 * 
 * 用户Dao层接口
 *
 */
@Mapper
public interface UserDao {

	/**
	 * 通过账户和密码查询用户
	 */
	public User findUser(@Param("usercode")String usercode,@Param("password")String password);
}
