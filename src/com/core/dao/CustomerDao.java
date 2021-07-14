package com.core.dao;

import java.util.List;

import com.core.po.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mylegion
 */
@Mapper
public interface CustomerDao {

    /**
     * 客户列表
     * @param customer
     * @return
     */
	public List<Customer> selectCustomerList(Customer customer);
	
	//客户数
	public Integer selectCustomerListCount(Customer customer);

	//添加客户
	public int createCustomer(Customer customer);
	/**
	 * 更新客户
	 */
	public int updateCustomer(Customer customer);
	/**
	 * 根据id查询客户
	 */
	public Customer getCustomerById(Integer id);

	//删除客户
	public int deleteCustomer(Integer id);
	
}
