package com.qrsx.springboot.pojo;

import java.sql.Timestamp;

/**
 * @ClassName:  ActiveCount   
 * @Description:活跃人群统计表
 */
public class ActiveCount {
	//活跃人群统计表id
	private Integer active_count_id;
	//时间
	private Timestamp per_hour;
	//每小时活跃人数
	private Integer active_count;

	public Integer getActive_count_id() {
		return active_count_id;
	}

	public void setActive_count_id(Integer active_count_id) {
		this.active_count_id = active_count_id;
	}

	public Timestamp getPer_hour() {
		return per_hour;
	}

	public void setPer_hour(Timestamp per_hour) {
		this.per_hour = per_hour;
	}

	public Integer getActive_count() {
		return active_count;
	}

	public void setActive_count(Integer active_count) {
		this.active_count = active_count;
	}
}
