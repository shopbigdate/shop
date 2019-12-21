<template>
	<div id="myChart" :style="{width: '600px', height: '600px'}">
	</div>
</template>

<script>
	import axios from 'axios';
	export default {
		name: 'echartsOrder',
		data() {
			return {
				order: [],
				listInfo: [],
				listInfo2: [],
				listInfo3: [],
				timelist: []
			}
		},
		mounted: function() {
			this.searchall();
		},
		methods: {
			searchall: function() {
				var url = 'http://localhost:8888/echarts/echartsOrder';
				axios.post(url).then((response) => {
					this.order = response.data;
					for(var i = 0; i < this.order.length; i++) {
						this.listInfo.push(this.order[i].order_sum_count);
						this.listInfo2.push(this.order[i].order_trade_sum);
						this.listInfo3.push(this.order[i].order_refund_sum);
						this.timelist.push(this.order[i].order_count_date);
					}
					this.drawLine();
				});
			},
			drawLine() {
				var d = this
				// 指定图表的配置项和数据
				// 基于准备好的dom，初始化echarts实例
				let myChart = d.$echarts.init(document.getElementById('myChart'));
				// 绘制图表
				myChart.setOption({
					tooltip: {
						trigger: 'axis',
						axisPointer: {
							type: 'cross',
							crossStyle: {
								color: '#999'
							}
						}
					},
					toolbox: {
						feature: {
							dataView: {
								show: true,
								readOnly: false
							},
							magicType: {
								show: true,
								type: ['line', 'bar']
							},
							restore: {
								show: true
							},
							saveAsImage: {
								show: true
							}
						}
					},
					legend: {
						data: ['订单交易总额', '订单退款总额', '订单数']
					},
					xAxis: [{
						type: 'category',
						data: d.timelist,
						axisPointer: {
							type: 'shadow'
						},
						axisLabel: {
							interval: 0,
							rotate: -20
						}
					}],
					yAxis: [{
							type: 'value',
							name: '金额',
							min: 0,
							max: 2000,
							interval: 200,
							axisLabel: {
								formatter: '{value} 元'
							}
						},
						{
							type: 'value',
							name: '订单数量',
							min: 0,
							max: 25,
							interval: 5,
							axisLabel: {
								formatter: '{value} 个'
							}
						}
					],
					series: [{
							name: '订单交易总额',
							type: 'bar',
							data: d.listInfo2
						},
						{
							name: '订单退款总额',
							type: 'bar',
							data: d.listInfo3
						},
						{
							name: '订单数',
							type: 'line',
							yAxisIndex: 1,

							data: d.listInfo
						}
					]
				});
			}
		}
	}
</script>

<style scoped>

</style>