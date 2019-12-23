package com.qrsx.springboot.pojo;

public class OrderCount {
	//自增id
	private Integer order_count_id;
	//总订单个数
	private Integer order_sum_count;
	//成功支付的订单个数
	private Integer order_pay_count;
	//退款的订单个数
	private Integer order_refund_count;
	//订单交易总额
	private Double order_trade_sum;
	//订单退款总额
	private Double order_refund_sum;
	//当前日期
	private String order_count_date;

	public Integer getOrder_count_id() {
		return order_count_id;
	}

	public void setOrder_count_id(Integer order_count_id) {
		this.order_count_id = order_count_id;
	}

	public Integer getOrder_sum_count() {
		return order_sum_count;
	}

	public void setOrder_sum_count(Integer order_sum_count) {
		this.order_sum_count = order_sum_count;
	}

	public Integer getOrder_pay_count() {
		return order_pay_count;
	}

	public void setOrder_pay_count(Integer order_pay_count) {
		this.order_pay_count = order_pay_count;
	}

	public Integer getOrder_refund_count() {
		return order_refund_count;
	}

	public void setOrder_refund_count(Integer order_refund_count) {
		this.order_refund_count = order_refund_count;
	}

	public Double getOrder_trade_sum() {
		return order_trade_sum;
	}

	public void setOrder_trade_sum(Double order_trade_sum) {
		this.order_trade_sum = order_trade_sum;
	}

	public Double getOrder_refund_sum() {
		return order_refund_sum;
	}

	public void setOrder_refund_sum(Double order_refund_sum) {
		this.order_refund_sum = order_refund_sum;
	}

	public String getOrder_count_date() {
		return order_count_date;
	}

	public void setOrder_count_date(String order_count_date) {
		this.order_count_date = order_count_date;
	}

}
