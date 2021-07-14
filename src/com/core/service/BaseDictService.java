package com.core.service;

import java.util.List;

import com.core.po.BaseDict;
import org.springframework.stereotype.Service;

public interface BaseDictService {
	//根据类别代码查询数据字典
		public List<BaseDict>  selectBaseDictTypeCode(String typecode);
}
