package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.EchartsMapper;
import com.qrsx.springboot.pojo.ActiveCount;
import com.qrsx.springboot.service.EchartsService;

/**
 * 
 * @ClassName: EchartsServiceImpl
 * @author zsd
 * @date 2019年12月20日
 *
 */
@Service
public class EchartsServiceImpl implements EchartsService {
	@Autowired
	private EchartsMapper echartsMapper;

	//24小时活跃人数折线图，按天查询活跃人数
	@Override
	public List<ActiveCount> select(String date) {
		return echartsMapper.select(date);
	}

}
