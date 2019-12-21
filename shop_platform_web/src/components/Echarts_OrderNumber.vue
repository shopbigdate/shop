<template>
	<div id="myChart" :style="{width: '600px', height: '600px'}"></div>
</template>

<script>
	import echarts from 'echarts';
	import axios from 'axios';
	export default {
		data() {
			return {
				order: [],
				listInfo: [],
				listInfo2: [],
				timelist: []
			}
		},
		mounted() {
			this.searchall();
		},
		methods: {
			searchall: function() {
				var url = 'http://localhost:8888/echarts/echartsOrder';
				axios.post(url).then((response) => {
					this.order = response.data;
					for(var i = 0; i < this.order.length; i++) {
						this.listInfo.push(this.order[i].order_pay_count);
						this.listInfo2.push(this.order[i].order_refund_count);
						this.timelist.push(this.order[i].order_count_date);
					}
					this.drawLine();
				});
			},
			drawLine() {
				var d = this;
				// 基于准备好的dom，初始化echarts实例
				let myChart = this.$echarts.init(document.getElementById('myChart'));
				// 绘制图表
				let option = {
					backgroundColor: '#323a5e',
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid: {
						left: '2%',
						right: '4%',
						bottom: '14%',
						top: '16%',
						containLabel: true
					},
					legend: {
						data: ['交易成功订单数', '交易失败订单数'],
						right: 10,
						top: 12,
						textStyle: {
							color: "#fff"
						},
						itemWidth: 12,
						itemHeight: 10,
						// itemGap: 35
					},
					xAxis: {
						type: 'category',
						data: d.timelist,
						axisLine: {
							lineStyle: {
								color: 'white'

							}
						},
						axisLabel: {
							// interval: 0,
							// rotate: 40,
							textStyle: {
								fontFamily: 'Microsoft YaHei'
							}
						},
					},

					yAxis: {
						type: 'value',
						name: '数量',
						min: 0,
						max: 20,
						axisLine: {
							show: false,
							lineStyle: {
								color: 'white'
							}
						},
						splitLine: {
							show: true,
							lineStyle: {
								color: 'rgba(255,255,255,0.3)'
							}
						},
						axisLabel: {}
					},
					"dataZoom": [{
						"show": true,
						"height": 12,
						"xAxisIndex": [
							0
						],
						bottom: '8%',
						"start": 10,
						"end": 90,
						handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
						handleSize: '110%',
						handleStyle: {
							color: "#d3dee5",

						},
						textStyle: {
							color: "#fff"
						},
						borderColor: "#90979c"
					}, {
						"type": "inside",
						"show": true,
						"height": 15,
						"start": 1,
						"end": 35
					}],
					series: [{
							name: '交易成功订单数',
							type: 'bar',
							barWidth: '15%',
							itemStyle: {
								normal: {
									color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
										offset: 0,
										color: '#fccb05'
									}, {
										offset: 1,
										color: '#f5804d'
									}]),
									barBorderRadius: 12,
								},
							},
							data: d.listInfo
						},
						{
							name: '交易失败订单数',
							type: 'bar',
							barWidth: '15%',
							itemStyle: {
								normal: {
									color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
										offset: 0,
										color: '#8bd46e'
									}, {
										offset: 1,
										color: '#09bcb7'
									}]),
									barBorderRadius: 11,
								}

							},
							data: d.listInfo2
						}
					]
				};
				var app = {
					currentIndex: -1,
				};
				setInterval(function() {
					var dataLen = option.series[0].data.length;

					// 取消之前高亮的图形
					myChart.dispatchAction({
						type: 'downplay',
						seriesIndex: 0,
						dataIndex: app.currentIndex
					});
					app.currentIndex = (app.currentIndex + 1) % dataLen;
					//console.log(app.currentIndex);
					// 高亮当前图形
					myChart.dispatchAction({
						type: 'highlight',
						seriesIndex: 0,
						dataIndex: app.currentIndex,
					});
					// 显示 tooltip
					myChart.dispatchAction({
						type: 'showTip',
						seriesIndex: 0,
						dataIndex: app.currentIndex
					});

				}, 1000);
				
				myChart.setOption(option);
			}
		}
	}
</script>

<style scoped>

</style>