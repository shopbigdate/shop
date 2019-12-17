<template>
	<div id="goods_info_index">
		<!-- header--start -->
		<header>
			<div class="w">
				<a href="#">
				</a>
			</div>
		</header>
		<!-- header--end -->
		<!-- 快速导航栏--start -->
		<div class="shortcut">
			<div class="w">
				<ul class="fl city">
					<li><i class="f10"></i>北京</li>
				</ul>
				<ul class="fr ">
					<li>
						<router-link to="/login">{{loginInfo}}</router-link>
						<router-link to="/register" class="f10">免费注册</router-link>
					</li>
					<li class="space"></li>
					<li>
						<router-link to="/order">我的订单</router-link>
					</li>
					<li class="space"></li>
					<li>
						<a href="#">我的京东</a>
						<i></i>
					</li>
					<li class="space"></li>
					<li>
						<a href="#">京东会员</a>
					</li>
					<li class="space"></li>
					<li>
						<a href="#">企业采购</a>
					</li>
					<li class="space"></li>
					<li>
						<a href="#">客户服务</a>
						<i></i>
					</li>
					<li class="space"></li>
					<li>
						<a href="#">网站导航</a>
						<i></i>
					</li>
					<li class="space"></li>
					<li>
						<a href="#">手机京东
							<div class="qrcode"></div>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 快速导航栏--end -->
		<!-- 导航栏--start -->
		<div class="w middle">

			<!-- 搜索框 -->
			<div class="form">
				<input type="text" name="search" placeholder="手机" v-model="str" style="border:1px solid #c8cccf;">
				<button type="button" v-on:click="search()"><i></i></button>
			</div>
			<!-- 我的购物车 -->
			<div class="shopCar">
				<router-link to="/shoppingCar"><i class="f10"></i>我的购物车<span>0</span></router-link>
			</div>
			<!-- 关键词 -->

			<div class="hotwords">
				<a href="#" class="f10">阿胶滋补节</a>
				<a href="#">玩所未玩</a>
				<a href="#">圣诞礼物</a>
				<a href="#">每100-30</a>
				<a href="#">养殖取暖</a>
				<a href="#">圣诞狂欢</a>
				<a href="#">OPPO</a>
				<a href="#">满千减百</a>
			</div>
			<!-- 小导航栏 -->
			<div class="navitems">
				<ul>
					<li>
						<a href="#">秒杀</a>
					</li>
					<li>
						<a href="#">优惠券</a>
					</li>
					<li>
						<a href="#">PLUS会员</a>
					</li>
					<li>
						<a href="#">闪购</a>
					</li>
					<li class="space1"></li>
					<li>
						<a href="#">拍卖</a>
					</li>
					<li>
						<a href="#">京东时尚</a>
					</li>
					<li>
						<a href="#">京东超市</a>
					</li>
					<li>
						<a href="#">京东生鲜</a>
					</li>
					<li class="space1"></li>
					<li>
						<a href="#">海囤全球</a>
					</li>
					<li>
						<a href="#">京东金融</a>
					</li>
				</ul>
			</div>
			<!-- 小广告--start -->

		</div>
		<!-- 导航栏--end -->
		<div align="center">

		</div>

		<!-- 页面底部--start -->

		<div align="center">
			<el-table style="width: 100%;" :header-cell-style="rowClass" :data="good.slice((currentPage-1)*pagesize,currentPage*pagesize)">
				<el-table-column label="商品编号" prop="goods_id" width="180" align="center">
				</el-table-column>
				<el-table-column label="商品名称" width="180" align="center">
					<template slot-scope="scope">
						<router-link :to="{name:'goods_details',query: {goods_id:scope.row.goods_id}}">{{scope.row.goods_name}}</router-link>
					</template>
				</el-table-column>
				<el-table-column label="商品价格" prop="goods_price" width="180" align="center">
				</el-table-column>
				<el-table-column label="商品库存" prop="goods_store" width="200" align="center">
				</el-table-column>
				<el-table-column label="商品详情" prop="goods_detail" width="180" align="center">
				</el-table-column>
				<el-table-column label="商家名称" prop="goods_shop" width="180" align="center">
				</el-table-column>
				<el-table-column label="商品分类" prop="goods_category" width="180" align="center">
				</el-table-column>
			</el-table>
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[2, 4, 6, 8]" :page-size="pagesize" layout="total, sizes, prev, pager, next, jumper" :total="good.length">
			</el-pagination>
		</div>
		<footer>
			<div class="service">
				<!-- 服务模块 -->
				<div class="w">
					<ul>
						<li>
							<h5></h5>
							<p>品类齐全，轻松购物</p>
						</li>
						<li>
							<h5></h5>
							<p>多仓直发，急速配送</p>
						</li>
						<li>
							<h5></h5>
							<p>正品行货，精致服务</p>
						</li>
						<li>
							<h5></h5>
							<p>天天低价，畅选无忧</p>
						</li>
					</ul>
				</div>
			</div>
			<!-- 帮助模块 -->
			<div class="w help">
				<div class="fl">
					<ul>
						<li>
							<dl>
								<dt><h5>购物指南</h5></dt>
								<dd>
									<a href="#">购物流程</a>
								</dd>
								<dd>
									<a href="#">会员介绍</a>
								</dd>
								<dd>
									<a href="#">生活旅行</a>
								</dd>
								<dd>
									<a href="#">常见问题</a>
								</dd>
								<dd>
									<a href="#">大家电</a>
								</dd>
								<dd>
									<a href="#">联系客服</a>
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt><h5>配送方式</h5></dt>
								<dd>
									<a href="#">上门自提</a>
								</dd>
								<dd>
									<a href="#">211限时达</a>
								</dd>
								<dd>
									<a href="#">配送服务查询</a>
								</dd>
								<dd>
									<a href="#">配送费收取标准</a>
								</dd>
								<dd>
									<a href="#">海外配送</a>
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt><h5>支付方式</h5></dt>
								<dd>
									<a href="#">货到付款</a>
								</dd>
								<dd>
									<a href="#">在线支付</a>
								</dd>
								<dd>
									<a href="#">分期付款</a>
								</dd>
								<dd>
									<a href="#">邮局汇款</a>
								</dd>
								<dd>
									<a href="#">公司转账</a>
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt><h5>售后服务</h5></dt>
								<dd>
									<a href="#">售后政策</a>
								</dd>
								<dd>
									<a href="#">价格保护</a>
								</dd>
								<dd>
									<a href="#">退款说明</a>
								</dd>
								<dd>
									<a href="#">返修/退换货</a>
								</dd>
								<dd>
									<a href="#">取消订单</a>
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt><h5>特色服务</h5></dt>
								<dd>
									<a href="#">夺宝岛</a>
								</dd>
								<dd>
									<a href="#">DIY装机</a>
								</dd>
								<dd>
									<a href="#">延保服务</a>
								</dd>
								<dd>
									<a href="#">京东E卡</a>
								</dd>
								<dd>
									<a href="#">京东通信</a>
								</dd>
								<dd>
									<a href="#">京东JD+</a>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
				<div class="fr">
					<div class="content">
						<h5>京东自营覆盖区县</h5>
						<div class="contentP">
							<p>京东已向全国2661个区县提供自营配送服务，支持货到付款、POS机刷卡和售后上门服务。</p>
							<p>
								<a href="#">查看详情<i></i></a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- 版权板块 -->
			<div class="w copyright">
				<p>
					<a href="#">关于我们</a>
					<span>|</span>
					<a href="#">联系我们</a>
					<span>|</span>
					<a href="#">联系客服</a>
					<span>|</span>
					<a href="#">合作招商</a>
					<span>|</span>
					<a href="#">商家帮助</a>
					<span>|</span>
					<a href="#">营销中心</a>
					<span>|</span>
					<a href="#">手机京东</a>
					<span>|</span>
					<a href="#">友情链接</a>
					<span>|</span>
					<a href="#">销售联盟</a>
					<span>|</span>
					<a href="#">京东社区</a>
					<span>|</span>
					<a href="#">风险监测</a>
					<span>|</span>
					<a href="#">隐私政策</a>
					<span>|</span>
					<a href="#">京东公益</a>
					<span>|</span>
					<a href="#">English Site</a>
					<span>|</span>
					<a href="#">Media & IR</a>
				</p>
				<div class="safe">
					<p>
						<a href="#">京公网安备 11000002000088号</a>
						<span>|</span>
						<a href="#">京ICP证070359号</a>
						<span>|</span>
						<a href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>
						<span>|</span>
						<a href="#">新出发京零 字第大120007号</a>
						<span>|</span>
					</p>
					<p>
						<a href="#">互联网出版许可证编号新出网证(京)字150号</a>
						<span>|</span>
						<a href="#">出版物经营许可证</a>
						<span>|</span>
						<a href="#">网络文化经营许可证京网文[2014]2148-348号</a>
						<span>|</span>
						<a href="#">违法和不良信息举报电话：4006561155</a>
						<span>|</span>
					</p>
					<p>
						<a href="#">Copyright © 2004 - 2018 京东JD.com 版权所有</a>
						<span>|</span>
						<a href="#">消费者维权热线：4006067733经营证照</a>
						<span>|</span>
						<a href="#">(京)网械平台备字(2018)第00003号</a>
						<span>|</span>
						<a href="#">营业执照</a>
						<span>|</span>
					</p>
					<p>
						<a href="#">Global Site</a>
						<span>|</span>
						<a href="#">Сайт России</a>
						<span>|</span>
						<a href="#">Situs Indonesia</a>
						<span>|</span>
						<a href="#">Sitio de España</a>
						<span>|</span>
						<a href="#">เว็บไซต์ประเทศไทย</a>
						<span>|</span>
					</p>
					<p>
						<a href="#">京东旗下网站：京东钱包</a>
						<span>|</span>
						<a href="#">京东云</a>
						<span>|</span>
					</p>
				</div>
				<div class="icomoon">
					<p>
						<a href="#"></a>
						<a href="#"></a>
						<a href="#"></a>
						<a href="#"></a>
						<a href="#"></a>
					</p>
				</div>
			</div>
		</footer>
		<!-- 页面底部--end -->
	</div>
</template>

<script>
	import axios from 'axios';
	export default {
		name: 'goods_info',
		data() {
			return {
				good: [],
				cur: 0,
				currentPage: 1,
				pagesize: 4,
				str: "",
				loginInfo : "您好，请登录"
			}
		},
		mounted: function() {
			this.searchall();
			this.getParams();
			var self = this;
			var url = 'http://localhost:8888/goods/getUserName';
			axios.post(url).then(function(response) {
					self.loginInfo = response.data;
				})
		},
		methods: {
			handleSizeChange: function(size) {
				this.pagesize = size;
				console.log(this.pagesize)
			},
			handleCurrentChange: function(currentPage) {
				this.currentPage = currentPage;
				console.log(this.currentPage)
			},
			search: function() {
				var g = this
				var goods_name = g.str.toUpperCase();
				var url = 'http://localhost:8888/goods/vague?goods_name=' + goods_name;
				axios.get(url).then(function(response) {
					g.good = response.data;
				})
			},
			searchall: function() {
				var g = this
				var url = 'http://localhost:8888/goods/search';
				axios.get(url).then(function(response) {
					g.good = response.data;
				})
			},
			getParams() {
				// 取到路由带过来的参数
				this.str = this.$route.query.str
			},
			headClass() {
				return 'text-align: center;background:#eef1f6;'
			},
			// 表格样式设置
			rowClass() {
				return 'text-align: center;'
			}
		}
	}
</script>

<style scoped>
	@import '../../static/base.css';
</style>