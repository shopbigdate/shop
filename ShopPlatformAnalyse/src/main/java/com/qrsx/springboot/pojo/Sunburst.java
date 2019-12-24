package com.qrsx.springboot.pojo;

import java.util.List;

/**
 * @ClassName:  Sunburst   
 * @Description:echarts旭日图信息
 * @author: 姜振楠
 * @date:   2019年12月20日 下午7:22:11
 */
public class Sunburst {
	//商品种类
	private String name;
	//此种类的总销量
	private Integer value;
	//此种类的Top3
	private List<SunburstChild> children;

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

	public List<SunburstChild> getChildren() {
		return children;
	}

	public void setChildren(List<SunburstChild> children) {
		this.children = children;
	}

	public Sunburst(String name, Integer value, List<SunburstChild> children) {
		super();
		this.name = name;
		this.value = value;
		this.children = children;
	}

	public Sunburst() {
		super();
	}

}
