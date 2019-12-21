package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.ActiveCount;
import com.qrsx.springboot.pojo.OrderCount;

/**
 * 
 * @ClassName: Echarts_line_chart_Service
 * @author zsd
 * @date 2019年12月20日
 *
 */
public interface EchartsService {

	//24小时活跃人数折线图，按天查询活跃人数
	List<ActiveCount> select(String date);

	//订单统计表查询
	List<OrderCount> order();

}
