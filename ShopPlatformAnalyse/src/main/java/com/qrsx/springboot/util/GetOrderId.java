package com.qrsx.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:  EchartsServiceImpl   
 * @Description:生成订单编号工具类
 * @author llx  
 * @date 2019年12月11日  
 */
public class GetOrderId {
	public String getId(SimpleDateFormat sdf, Date d, Integer user_id) {
		return sdf.format(d) + "-" + user_id;
	}
}
