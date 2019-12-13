package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.GoodsInfoMapper;
import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.service.GoodsInfoService;
//声明成一个spring bean
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService{
	
	@Autowired GoodsInfoMapper goodsInfoMapper;
	@Override
	public List<GoodsInfo> vague(String goods_name) {
		//主页搜索vague
		return goodsInfoMapper.vague(goods_name);
	}

}
