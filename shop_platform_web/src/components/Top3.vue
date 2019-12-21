<template>
	<div id="myChart" :style="{width: '300px', height: '300px'}"></div>
</template>

<script>
	export default {

		mounted() {
			this.drawLine();
			

		},

		methods: {
			drawLine() {
				// 基于准备好的dom，初始化echarts实例	
				let myChart = this.$echarts.init(document.getElementById('myChart'));
				var url = 'http://localhost:8888/echarts/Top3';
				this.$axios.get(url).then((response) => {
					var info = response.data;

					myChart.setOption({
						title: {
							text: '各类别热门商品Top3',
						},
						series: {
							type: 'sunburst',
							data: info,
						},
						tooltip: {
							trigger: 'item',
							formatter: "商品名：{b},销量：{c}"

						}
					});
				})

			}

		},


	}
</script>

