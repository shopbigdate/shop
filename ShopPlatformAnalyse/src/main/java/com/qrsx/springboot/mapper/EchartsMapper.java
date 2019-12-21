package com.qrsx.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qrsx.springboot.pojo.ActiveCount;

/**
 * 
 * @ClassName: EchartsMapper
 * @author zsd
 * @date 2019年12月20日
 *
 */
@Mapper
public interface EchartsMapper {
	
	//24小时活跃人数折线图，按天查询活跃人数
	List<ActiveCount> select(String date);

}
