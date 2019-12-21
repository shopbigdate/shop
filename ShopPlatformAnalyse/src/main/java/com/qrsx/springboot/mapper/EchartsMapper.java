package com.qrsx.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qrsx.springboot.pojo.ActiveCount;
import com.qrsx.springboot.pojo.OrderCount;
import com.qrsx.springboot.pojo.Sunburst;
import com.qrsx.springboot.pojo.SunburstChild;

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

	//订单统计表查询
	List<OrderCount> order();
	//热门商品Top3
	List<Sunburst> getAllGoodsOrderCount(@Param("time") String time);
	List<SunburstChild> getAllChild(@Param("time") String time,@Param("goods_category") String goods_category);

}
