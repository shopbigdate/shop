package com.qrsx.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrsx.springboot.pojo.ActiveCount;
import com.qrsx.springboot.service.Echarts_line_chart_Service;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName: Echarts_line_chart_Controller
 * @Description: TODO(24小时活跃人数折线图)
 * @author zsd
 * @date 2019年12月20日
 *
 */
@Controller
@RequestMapping("ActiveCount")
public class Echarts_line_chart_Controller {

	@Autowired
	private Echarts_line_chart_Service echarts_line_chart_Service;

	//获取数据
	@RequestMapping("selectToday")
	@ResponseBody
	public JSONObject selectToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<ActiveCount> activeCounts = echarts_line_chart_Service.select(sdf.format(new Date()));
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

	////处理页面跳转，即入口
	@RequestMapping("showLineChart")
	public String showLineChart() {
		return "line_chart";
	}
}
