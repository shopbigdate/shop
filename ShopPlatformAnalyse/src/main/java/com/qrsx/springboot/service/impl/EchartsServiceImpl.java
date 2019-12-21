package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.EchartsMapper;
import com.qrsx.springboot.pojo.ActiveCount;
import com.qrsx.springboot.pojo.OrderCount;
import com.qrsx.springboot.service.EchartsService;

/**
 * 
 * @ClassName: Echarts_line_chart_ServiceImpl
 * @Description: TODO(24小时活跃人数折线图)
 * @author zsd
 * @date 2019年12月20日
 *
 */
@Service
public class EchartsServiceImpl implements EchartsService {
	@Autowired
	private EchartsMapper echarts_line_chart_Mapper;
	@Autowired
	EchartsMapper echartsMapper;
	
	//订单统计表查询
	@Override
	public List<OrderCount> order() {
		return echartsMapper.order();
	}

	//按天查询活跃人数
	@Override
	public List<ActiveCount> select(String date) {
		return echarts_line_chart_Mapper.select(date);
	}

}
