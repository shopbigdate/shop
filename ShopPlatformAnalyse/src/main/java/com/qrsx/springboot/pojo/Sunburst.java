package com.qrsx.springboot.pojo;

import java.util.List;

/**   
 * @ClassName:  Sunburst   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 姜振楠
 * @date:   2019年12月20日 下午7:22:11   
 *     
 * @Copyright: 2019 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于自己传阅，禁止外泄以及用于其他的商业目 
 */
public class Sunburst {
	private String name;
	private Integer value;
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
