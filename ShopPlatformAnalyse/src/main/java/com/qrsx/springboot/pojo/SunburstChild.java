package com.qrsx.springboot.pojo;

/**
 * @ClassName:  SunburstChild   
 * @Description:echarts旭日图子图信息
 * @author: 姜振楠
 * @date:   2019年12月20日 下午7:25:20 
 */
public class SunburstChild {
	//商品名
	private String name;
	//商品销量
	private Integer value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public SunburstChild(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
	}

	public SunburstChild() {
		super();
	}

}
