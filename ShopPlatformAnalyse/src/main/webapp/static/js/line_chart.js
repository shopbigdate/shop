$(function() {
	$.ajax({
		url : '../EmpServlet',
		data : null,
		dataType : 'json',
		error : function() {
			alert("error message");
		},
		success : function(data) {
			myChart.setOption({
				xAxis : {
					data : data.ename
				},

				series : [ {
					data : data.sal
				} ]
			});
		}
	});

	// 基于准备好的dom，初始化echarts图表
	var myChart = echarts.init(document.getElementById('main'));

	var option = {
		tooltip : {
			// 触发类型，默认（'item'）数据触发，可选为：'item' | 'axis'
			trigger : 'axis'
		},
		xAxis : [ {
			type : 'category',
			data : [ '2019-01', '2019-02', '2019-03', '2019-04', '2019-05',
					'2019-06' ],
			axisLine : {
				lineStyle : {
					color : "#999"
				}
			}
		} ],
		yAxis : [ {
			type : 'value',
			splitNumber : 4,
			splitLine : {
				lineStyle : {
					type : 'dashed',
					color : '#DDD'
				}
			},
			axisLine : {
				show : false,
				lineStyle : {
					color : "#333"
				},
			},
			nameTextStyle : {
				color : "#999"
			},
			splitArea : {
				show : false
			}
		} ],
		series : [ {
			name : '课时',
			type : 'line',
			data : [ 23, 60, 20, 36, 23, 85 ],
			lineStyle : {
				normal : {
					width : 8,
					color : {
						type : 'linear',

						colorStops : [ {
							offset : 0,
							color : '#A9F387' // 0% 处的颜色
						}, {
							offset : 1,
							color : '#48D8BF' // 100% 处的颜色
						} ],
						globalCoord : false
					// 缺省为 false
					},
					shadowColor : 'rgba(72,216,191, 0.3)',
					shadowBlur : 10,
					shadowOffsetY : 20
				}
			},
			itemStyle : {
				normal : {
					color : '#fff',
					borderWidth : 10,
					/*shadowColor: 'rgba(72,216,191, 0.3)',
					shadowBlur: 100,*/
					borderColor : "#A9F387"
				}
			},
			smooth : true
		} ]
	};

	// 为echarts对象加载数据
	myChart.setOption(option);
});
