package com.core.dao;

import java.util.List;
import com.core.po.BaseDict;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典
 * @author mylegion
 *
 */
@Mapper
public interface BaseDictDao {

	//根据类别代码查询数据字典
	public List<BaseDict>  selectBaseDictTypeCode(String typecode);
}
