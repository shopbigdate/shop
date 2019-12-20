package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.Echarts_line_chart_Mapper;
import com.qrsx.springboot.pojo.ActiveCount;
import com.qrsx.springboot.service.Echarts_line_chart_Service;

/**
 * 
 * @ClassName: Echarts_line_chart_ServiceImpl
 * @Description: TODO(24小时活跃人数折线图)
 * @author zsd
 * @date 2019年12月20日
 *
 */
@Service
public class Echarts_line_chart_ServiceImpl implements Echarts_line_chart_Service {
	@Autowired
	private Echarts_line_chart_Mapper echarts_line_chart_Mapper;

	//按天查询活跃人数
	@Override
	public List<ActiveCount> select(String date) {
		return echarts_line_chart_Mapper.select(date);
	}

}
