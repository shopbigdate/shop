package com.qrsx.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.ActiveCount;
import com.qrsx.springboot.pojo.OrderCount;
import com.qrsx.springboot.service.EchartsService;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName: EchartsController
 * @author zsd
 * @date 2019年12月20日
 *
 */
@RestController
@RequestMapping("echarts")
public class EchartsController {

	@Autowired
	private EchartsService echartsService;

	//24小时活跃人数折线图，获取数据
	@RequestMapping("selectToday")
	public JSONObject selectToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<ActiveCount> activeCounts = echartsService.select(sdf.format(new Date()));
		int total = activeCounts.size();
		//x轴上滑动显示24条数据
		int j = total - 1;
		int i = 0;
		if (total >= 24) {
			i = total - 24;
		}
		int size = j - i + 1;
		//x轴数据
		String[] per_hour = new String[size];
		//y轴数据
		Integer[] active_count = new Integer[size];
		for (int k = 0; i <= j; i++, k++) {
			per_hour[k] = activeCounts.get(i).getPer_hour().toString().substring(8, 16);
			active_count[k] = activeCounts.get(i).getActive_count();
		}

		JSONObject data = new JSONObject();
		data.put("per_hour", per_hour);
		data.put("active_count", active_count);
		//System.out.println(data.toString());
		return data;
	}

	//24小时活跃人数折线图，处理页面跳转，即入口
	@RequestMapping("showLineChart")
	public String showLineChart() {
		return "line_chart";
	}
	
	//订单echarts
		@RequestMapping(value = "/echartsOrder", method = RequestMethod.POST)
		public List<OrderCount> order() {
			return echartsService.order();
		}
}
