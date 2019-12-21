<template>
	<div>
		<div id="myChart" :style="{width: '600px', height: '600px',float:'left'}">
		</div>
		<div id="myChart2" :style="{width: '600px', height: '600px',float:'right'}">
		</div>
		<!-- <div id="myChart3" :style="{width: '300px', height: '300px'}"></div> -->
	</div>
	
</template>

<script>
	import axios from 'axios';
	import echarts from 'echarts';
	export default {
		name: 'echartsOrder',
		data() {
			return {
				order: [],
				listInfo: [],
				listInfo2: [],
				listInfo3: [],
				timelist: [],
				paycount: [],
				refundcount: []
			}
		},
		mounted: function() {
			this.searchall();
			//this.drawLine3();
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
						this.paycount.push(this.order[i].order_pay_count);
						this.refundcount.push(this.order[i].order_refund_count);
					}
					this.drawLine();
					this.drawLine2();
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
			},
			drawLine2() {
				alert("sdafghjkl");
				var d = this;
				// 基于准备好的dom，初始化echarts实例
				let myChart = this.$echarts.init(document.getElementById('myChart2'));
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
							data: d.paycount
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
							data: d.refundcount
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
			},
			// drawLine3() {
			// 				// 基于准备好的dom，初始化echarts实例	
			// 				alert('dsafg');
			// 				let myChart = this.$echarts.init(document.getElementById('myChart3'));
			// 				var url = 'http://localhost:8888/echarts/Top3';
			// 				axios.post(url).then((response) => {
			// 					var info = response.data;
			// 					alert(info);
			// 					myChart.setOption({
			// 						title: {
			// 							text: '各类别热门商品Top3',
			// 						},
			// 						series: {
			// 							type: 'sunburst',
			// 							data: info,
			// 						},
			// 						tooltip: {
			// 							trigger: 'item',
			// 							formatter: "商品名：{b},销量：{c}"
			
			// 						}
			// 					});
			// 				})
			
			// 			}
		}
	}
</script>

<style scoped>

</style>