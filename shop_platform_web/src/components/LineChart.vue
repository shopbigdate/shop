<template>
	<div id="myChart" :style="{width: '800px', height: '400px'}"></div>
</template>

<script>
	export default {
		data() {
			return {
				datax: [],
				datas: []
			}
		},
		mounted() {
			//第一次加载
			this.refresh()
			//每隔n秒实时刷新数据
			this.timer = setInterval(() => {
				this.refresh();
			}, 5000)
		},
		beforeDestroy() {
			// 在Vue实例销毁前，清除定时器
			if(this.timer) {
				clearInterval(this.timer);
			}
		},
		methods: {
			refresh() {
				this.$axios.get('http://localhost:8888/echarts/selectToday')
					.then((res) => {
						console.log(res)
						this.datax = res.data.per_hour
						this.datas = res.data.active_count
						this.drawLine();
					});
			},

			drawLine() {
				// 基于准备好的dom，初始化echarts实例
				let myChart = this.$echarts.init(document.getElementById('myChart'))
				// 绘制图表
				myChart.setOption({
					tooltip: {
						// 触发类型，默认（'item'）数据触发，可选为：'item' | 'axis'
						trigger: 'axis'
					},

					xAxis: [{
						type: 'category',
						/*data: ['2019-01', '2019-02', '2019-03', '2019-04', '2019-05',
							'2019-06'
						],*/
						data: this.datax,
						axisLine: {
							lineStyle: {
								color: "#999"
							}
						}
					}],

					yAxis: [{
						type: 'value',
						splitNumber: 4,
						splitLine: {
							lineStyle: {
								type: 'dashed',
								color: '#DDD'
							}
						},
						axisLine: {
							show: false,
							lineStyle: {
								color: "#333"
							},
						},
						nameTextStyle: {
							color: "#999"
						},
						splitArea: {
							show: false
						}
					}],

					series: [{
						name: '活跃人数',
						type: 'line',
						/*data: [23, 60, 20, 36, 23, 85],*/
						data: this.datas,
						lineStyle: {
							normal: {
								width: 8,
								color: {
									type: 'linear',

									colorStops: [{
										offset: 0,
										color: '#A9F387' // 0% 处的颜色
									}, {
										offset: 1,
										color: '#48D8BF' // 100% 处的颜色
									}],
									globalCoord: false
									// 缺省为 false
								},
								shadowColor: 'rgba(72,216,191, 0.3)',
								shadowBlur: 10,
								shadowOffsetY: 20
							}
						},
						itemStyle: {
							normal: {
								color: '#fff',
								borderWidth: 10,
								/*shadowColor: 'rgba(72,216,191, 0.3)',
								shadowBlur: 100,*/
								borderColor: "#A9F387"
							}
						},
						smooth: true
					}]
				});
				//this.refresh();
			}
		}
	}
</script>
<style></style>