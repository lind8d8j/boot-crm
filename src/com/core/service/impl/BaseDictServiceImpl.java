package com.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.dao.BaseDictDao;
import com.core.po.BaseDict;
import com.core.service.BaseDictService;

@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {

	//注入Dao
	@Autowired
	private BaseDictDao baseDictDao;
	@Override
	public List<BaseDict> selectBaseDictTypeCode(String typecode) {
		//根据类别代码查询数据字典
		return baseDictDao.selectBaseDictTypeCode(typecode);
	}

}
