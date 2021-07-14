package com.core.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.utils.Page;
import com.core.po.BaseDict;
import com.core.po.Customer;
import com.core.po.User;
import com.core.service.BaseDictService;
import com.core.service.CustomerService;

/**
 * 客户管理控制器类
 * 
 * @author mylegion
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
    @Autowired
	private BaseDictService baseDictService;

	// springmvc 加载并读取属性配置文件
	@Value("${customer.from.type}")
	private String FROM_TYPE;
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;

	/**
	 * 客户列表
	 */
	@RequestMapping(value="/customer/list.action")
	public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows,
			String custName, String custSource, String custIndustry, String custLevel, Model model) {
		// 条件查询所有客户
		Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry,
				custLevel);
		model.addAttribute("page", customers);

		// 客户来源
		List<BaseDict> fromType = baseDictService.selectBaseDictTypeCode(FROM_TYPE);
		// 客户所属行业
		List<BaseDict> industryType = baseDictService.selectBaseDictTypeCode(INDUSTRY_TYPE);
		// 客户级别
		List<BaseDict> levelType = baseDictService.selectBaseDictTypeCode(LEVEL_TYPE);

		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);

		return "customer";

	}
	
	/**
	 * 添加客户
	 */
	@RequestMapping("customer/create.action")
	@ResponseBody
	public String addCustomer(Customer customer, HttpSession session) {
		//获取Session
		User user = (User) session.getAttribute("USER_SESSION");
		//将当前用户id存储到客户对象中
		customer.setCust_create_id(user.getUser_id());
		//创建Date对象
		Date date = new  Date();
		//得到一个timestamp格式时间，存入mysql中的时间格式"yyyy/MM/dd HH:mm:ss"
		Timestamp timestamp = new Timestamp(date.getTime());
		customer.setCust_createtime(timestamp);
		//执行Service层中创建方法，返回受影响的行数
		int rows  = customerService.createCustomer(customer);
		if(rows > 0) {
			return "OK";
		}else {
			return "Fail";
		}
	}
	
	/**
	 * 根据id查询客户
	 */
	@RequestMapping("customer/getCustomerById.action")
	@ResponseBody
	public Customer getCustomerById(Integer id) {
		return customerService.getCustomerById(id);
	}
	
	/**
	 * 更新客户
	 */
	@RequestMapping("customer/update.action")
	@ResponseBody
	public String customerUpdate(Customer customer) {
		int rows = customerService.updateCustomer(customer);
		if(rows > 0) {
			return "OK";
		}else {
			return "Fail";
		}
	}
	
	/**
	 * 删除客户
	 */
	@RequestMapping("customer/delete.action")
	@ResponseBody
	public String customerDelete(Integer id) {
		int rows = customerService.deleteCustomer(id);
		if(rows > 0) {
			return "OK";
		}else {
			return "Fail";
		}
	}
}
