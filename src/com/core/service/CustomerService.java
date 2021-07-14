package com.core.service;

import com.common.utils.Page;
import com.core.po.Customer;
import org.springframework.stereotype.Service;

public interface CustomerService {

	//查询客户列表
	public Page<Customer> findCustomerList(Integer page,Integer rows,String custName,
			String custSource,String custIndustry,String custLevel);

	//添加客户
	public int createCustomer(Customer customer);
	/**
	 * 根据id查询客户
	 */
	public int updateCustomer(Customer customer);
	/**
	 * 更新客户
	 */
	public Customer getCustomerById(Integer id);
    //删除客户
	public int deleteCustomer(Integer id);
}
