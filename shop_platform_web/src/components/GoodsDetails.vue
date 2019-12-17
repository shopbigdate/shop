<template>
	<div>
		<div class="header">
			<!--页面顶部-->
			<div class="page-top">
				<ul class="welcome">
					<li>欢迎进入 京东</li>
					<li>
						&nbsp;&nbsp;&nbsp;{{loginInfo}}
						<a v-on:click="loginAndOut()" style="cursor:pointer">{{loginStatus}}</a>
						<router-link to="/register" class="f10">免费注册</router-link>
					</li>
				</ul>
				<ul class="data">
					<li>
						<router-link to="/order">我的订单</router-link>
					<li>
						<a href="#">我的信息</a>
						<ul class="info">
							<li class="touxiang">
								<img src="../../static/images/touxiang-jzx.png" title="头像" alt="对不起图片加载失败..." width="50" height="50">
								<p>
									<a href="#">{{loginInfo}}</a>
								</p>
							</li>
							<li class="from">
								<a href="#">待处理订单<span id="num1-jzx">(0)</span></a>
							</li>
							<li class="from">
								<a href="#">购买咨询 <span id="num2-jzx"></span></a>
							</li>
							<li class="from">
								<a href="#">退款/售后</a>
							</li>
							<li class="from">
								<a href="#" target="_blank">我的关注</a>
							</li>
							<li class="from">
								<a href="#" target="_blank">优惠券 <span id="num-coupon">(0)</span></a>
							</li>
							<li class="from">
								<a href="#" target="_blank">地址管理</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">手机APP</a>
						<ul>
							<li class="APP"><img src="../../static/images/erweima-jzx.png" title="APP二维码" alt="对不起图片加载失败..."></li>
						</ul>
					</li>
					<li>京东资讯</li>
					<li>合作伙伴</li>
					<li>关于我们</li>
				</ul>
			</div>
			<!--导航-->
			<div class="navigtion">
				<div class="logo">
					<img src="../../static/images/logo-201305-b.png" title="logo" alt="对不起图片加载失败..." width="240px">
				</div>
				<div class="search">
					<input type="text" class="sear" name="keyword" v-model="str">
					<button id="search" class="search-jzx" v-on:click="trans()">搜索</button>
					<div class="sousuo">
						<a href="#">Rival 300</a>
						<a href="#">炼狱蝰蛇</a>
						<a href="#">G502</a>
						<a href="#">MK Pro</a>
						<a href="#">QPAD</a>
					</div>
				</div>
				<div class="sopping-jzx">
					<router-link to="/shoppingCar">我的购物车</router-link>
				</div>
			</div>
			<div class="clear"></div>
			<div class="zxr_nav">
				<div class="nav_ten">
					<div class="quanbu_zxr">
						<div class="quanbu_zxr1"> 全部商品分类</div>
						<ul>
							<li>
								<a href="#">免费维修</a>
							</li>
							<li>
								<a href="#">免费维修</a>
							</li>
							<li>
								<a href="#">免费试用</a>
							</li>
							<li>
								<a href="#">免费兑换</a>
							</li>
							<li>
								<a href="#">私人定制</a>
							</li>
							<li>
								<a href="#">个人寄售</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--商品展示-->
		<div class="fang">
			<div class="SS_fang_zxr">
				<ul>
					<li>
						<a href="#"> 京东 </a> /</li>
					<li>
						<a href="#"> {{goodsInfo.goods_shop}} </a> /</li>
					<li>
						<a href="#"> {{goodsInfo.goods_category}} </a> /</li>
					<li> {{goodsInfo.goods_name}}</li>
				</ul>
			</div>
			<div class="nav_zxr">
				<div class="nav_left_zxr">
					<div class="nav_left_tu_zxr1 " v-for="goodspictures in goodspicture">
						<img v-bind:src="goodspictures.picture_path">
					</div>
					<!--放大镜左侧小图片第三个-->
				</div>
				<div class="wrapp">
					<a href="../../static/images/fang_shubiao1_zxr.jpg" class="img1">
						<img src="../../static/images/fang_shubiao1_zxr.jpg">
						<!--放大镜主图片-->
					</a>
				</div>

				<div class="nav_right_zxr">
					<div class="nav_list_zxr">
						<h3>{{goodsInfo.goods_name}}</h3>
						<!--放大镜右侧商品名-->
					</div>
					<div class="box"></div>
					<div class="nav_moner_zxr">
						<p class="p1"> {{goodsInfo.goods_price}}<span>元</span></p>
						<!--放大镜右侧商品单价-->
						<div class="pRight">
							<p class="p2">累计评价</p><br>
							<span>9</span></div>
					</div>
					<div class="nav_shangpin_zxr">
						<!--放大镜右侧商品是否有货-->
						{{store}}
					</div>

					<div class="nav_shaoyou">
						<p>烧友服务：满99元包邮</p>
					</div>
					<div class="nav_shuliangz_zxr">
						数量：
						<div class="nav_shuliang_zxr">
							<form>
								<div class="jian_zxr" id="jian" v-on:click="minus">-</div><input name=names type="text" class="input_zxr" v-model="clickNumber">
								<div class="jia_zxr" id="jia" v-on:click="count">+</div>
							</form>
						</div>
					</div>

					<button class="sub_zxr" v-on:click="createclickNumber">加入购物车</button>

					<div class="tishi">
						<span>温馨提醒：</span><br> 一般情况下，16:00前付款的订单会在当日发出
						<br> 优惠券信息请以结算页为准

					</div>

				</div>
			</div>
		</div>
		<!--中间导航栏-->
		<div class="list_zxr">
			<div class="list1_zxr">
				<ul>
					<li>
						<a href="#">官方介绍</a>
					</li>
					<li>
						<a href="#">规格参数</a>
					</li>
					<li>
						<a href="#">评论晒单</a>
					</li>
					<li>
						<a href="#">商品提问</a>
					</li>
				</ul>
			</div>

		</div>
		<!--下方滚动浏览-->
		<div class="bigimg_zxr">

			<div class="canshu">
				<div class="canshubiao_zxr">
					规格参数

				</div>
				<div class="shubiaoshow_zxr">
					<img src="../../static/images/fang_shubiao1_zxr.jpg">
					<form action="">
						<table>
							<tr>
								<td>{{goodsInfo.goods_detail}}</td>
							</tr>
						</table>

					</form>
				</div>
			</div>
			<div class="canshu">
				<div class="canshubiao_zxr">
					评价晒单

				</div>
				<div class="shubiaoshow_zxr">
					<div class="pingjia_zxr">
						<p>88.9<span>%</span></p>
						<span>购买后满意</span>
						<span id="toupiao">9名用户投票</span>
					</div>
				</div>
				<div class="shubiaoshow_zxr shu1">
					<img src="../../static/images/noavatar.gif">
					<p>9月份买的，11月底开始发生回滚，外设天下的售后还有这所谓赛睿的售后垃圾得一B，唉</p>
					<div class="shouhou_zxr">
						<img src="../../static/images/avatar.png">
						<p>您好，赛睿提供一年质保，非人为质量问题一年换新，出现问题请联系官方售后。</p>
					</div>
					<div class="user_zxr"><span id="user">gh***d</span><span id="date">2016/12/5 17:06:26</span><span id="sbcolor">黑色</span></div>
				</div>
				<div class="shubiaoshow_zxr shu1">
					<img src="../../static/images/noavatar.gif">
					<p>9月份买的，11月底开始发生回滚，外设天下的售后还有这所谓赛睿的售后垃圾得一B，唉</p>
					<div class="shouhou_zxr">
						<img src="../../static/images/avatar.png">
						<p>您好，赛睿提供一年质保，非人为质量问题一年换新，出现问题请联系官方售后。</p>
					</div>
					<div class="user_zxr"><span id="user">gh***d</span><span id="date">2016/12/5 17:06:26</span><span id="sbcolor">黑色</span></div>
				</div>
				<div class="shubiaoshow_zxr shu1">
					<img src="../../static/images/noavatar.gif">
					<p>9月份买的，11月底开始发生回滚，外设天下的售后还有这所谓赛睿的售后垃圾得一B，唉</p>
					<div class="shouhou_zxr">
						<img src="../../static/images/avatar.png">
						<p>您好，赛睿提供一年质保，非人为质量问题一年换新，出现问题请联系官方售后。</p>
					</div>
					<div class="user_zxr"><span id="user">gh***d</span><span id="date">2016/12/5 17:06:26</span><span id="sbcolor">黑色</span></div>
				</div>
				<div class="shubiaoshow_zxr shu1">
					<img src="../../static/images/noavatar.gif">
					<p>9月份买的，11月底开始发生回滚，外设天下的售后还有这所谓赛睿的售后垃圾得一B，唉</p>
					<div class="shouhou_zxr">
						<img src="../../static/images/avatar.png">
						<p>您好，赛睿提供一年质保，非人为质量问题一年换新，出现问题请联系官方售后。</p>
					</div>
					<div class="user_zxr"><span id="user">gh***d</span><span id="date">2016/12/5 17:06:26</span><span id="sbcolor">黑色</span></div>
				</div>
				<div class="shubiaoshow_zxr shu1">
					<img src="../../static/images/noavatar.gif">
					<p>9月份买的，11月底开始发生回滚，外设天下的售后还有这所谓赛睿的售后垃圾得一B，唉</p>
					<div class="shouhou_zxr">
						<img src="../../static/images/avatar.png">
						<p>您好，赛睿提供一年质保，非人为质量问题一年换新，出现问题请联系官方售后。</p>
					</div>
					<div class="user_zxr"><span id="user">gh***d</span><span id="date">2016/12/5 17:06:26</span><span id="sbcolor">黑色</span></div>
				</div>
				<div class="shubiaoshow_zxr shu1">
					<img src="../../static/images/noavatar.gif">
					<p>9月份买的，11月底开始发生回滚，外设天下的售后还有这所谓赛睿的售后垃圾得一B，唉</p>
					<div class="shouhou_zxr">
						<img src="../../static/images/avatar.png">
						<p>您好，赛睿提供一年质保，非人为质量问题一年换新，出现问题请联系官方售后。</p>
					</div>
					<div class="user_zxr"><span id="user">gh***d</span><span id="date">2016/12/5 17:06:26</span><span id="sbcolor">黑色</span></div>
				</div>
				<div class="shubiaoshow_zxr shu1">
					<img src="../../static/images/noavatar.gif">
					<p>9月份买的，11月底开始发生回滚，外设天下的售后还有这所谓赛睿的售后垃圾得一B，唉</p>
					<div class="shouhou_zxr">
						<img src="../../static/images/avatar.png">
						<p>您好，赛睿提供一年质保，非人为质量问题一年换新，出现问题请联系官方售后。</p>
					</div>
					<div class="user_zxr"><span id="user">gh***d</span><span id="date">2016/12/5 17:06:26</span><span id="sbcolor">黑色</span></div>
				</div>
				<div class="shubiaoshow_zxr shu1">
					<img src="../../static/images/noavatar.gif">
					<p>9月份买的，11月底开始发生回滚，外设天下的售后还有这所谓赛睿的售后垃圾得一B，唉</p>
					<div class="shouhou_zxr">
						<img src="../../static/images/avatar.png">
						<p>您好，赛睿提供一年质保，非人为质量问题一年换新，出现问题请联系官方售后。</p>
					</div>
					<div class="user_zxr"><span id="user">gh***d</span><span id="date">2016/12/5 17:06:26</span><span id="sbcolor">黑色</span></div>
				</div>
				<div class="canshu">
					<div class="canshubiao_zxr">
						商品提问

					</div>
					<div class="shubiaoshow_zxr shu1">
						<div class="tiwen">
							<div class="sousuo_zxr">
								<form>
									<input type="text" class="text_zxr">
									<input type="button" value="搜索" class="but_zxr">
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="canshu">
					<div class="canshubiao1_zxr">
						你可能感兴趣的商品

					</div>
					<div class="shubiaoshow_zxr shu1 shuai">
						<div class="lunbo_zxr">
							<div class="float_lunbo_zxr1">
								<img src="../../static/images/pir_zxr_2.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr">
								<img src="../../static/images/pig9_zxr.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr">
								<img src="../../static/images/pig11_zxr.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr">
								<img src="../../static/images/pig12_zxr.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr">
								<img src="../../static/images/pig13_zxr.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr1">
								<img src="../../static/images/pir_zxr_2.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr">
								<img src="../../static/images/pig9_zxr.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr">
								<img src="../../static/images/pig11_zxr.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr">
								<img src="../../static/images/pig12_zxr.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="float_lunbo_zxr">
								<img src="../../static/images/pig13_zxr.jpg">
								<p>卓威奇亚（Zowie gear）CA..</p>
								<span>149.00</span>
								<p>0人好评</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="dianji">
			<div class="dianji2"></div>
			<div class="dianji1"></div>
		</div>
		<!--尾部-->
		<div class="footer">
			<div class="promise">
				<ul>
					<li><span>100%</span>品牌授权正品</li>
					<li><span>7</span>天无理由退换货</li>
					<li><span>15</span>天质量问题换新</li>
					<li class="number">客服电话：<span>400-616-7778</span></li>
				</ul>
			</div>
			<div class="items">
				<h4 class="txt">帮助中心</h4>
				<ul>
					<li>
						<a href="#">购物指南</a>
					</li>
					<li>
						<a href="#">支付方式</a>
					</li>
					<li>
						<a href="#">配送方式</a>
					</li>
				</ul>
			</div>
			<div class="items">
				<h4 class="txt">售后服务</h4>
				<ul>
					<li>
						<a href="#">售后政策</a>
					</li>
					<li>
						<a href="#">自助服务</a>
					</li>
					<li>
						<a href="#">相关下载</a>
					</li>
				</ul>
			</div>
			<div class="items">
				<h4 class="txt">关于我们</h4>
				<ul>
					<li>
						<a href="#">公司简介</a>
					</li>
					<li>
						<a href="#">加入我们</a>
					</li>
					<li>
						<a href="#">联系我们</a>
					</li>
				</ul>
			</div>
			<div class="items">
				<h4 class="txt">关注我们</h4>
				<ul>
					<li>
						<a href="#">新浪微博</a>
					</li>
					<li>
						<a href="#">外设导航</a>
					</li>
					<li>
						<a href="#">外设社区</a>
					</li>
				</ul>
			</div>
			<div class="item-service">
				<h4 class="txt"><img src="../../static/images/touxiang-jzx.png" width="20px"> 客户服务</h4>
				<ul>
					<li><i class="fa-caret-right"></i> 周一至周日 09:00-24:00</li>
					<li><i class="fa-caret-right fa-qq"></i>: 4006167778</li>
				</ul>
			</div>
			<div class="item-twodcode">
				<h4 class="txt">微信公众号</h4>
				<ul>
					<li><img src="../../static/images/erweima-jzx.png" width="60px"></li>
				</ul>
			</div>
			<div class="container">
				<p><span>PENTA LILL&copy;2007-2016</span><span><a href="#">黑ICP备53</a></span><span>版权所有 &copy; 2016 PENTA LILL</span></p>
			</div>
		</div>
		<div class="fird_zxr">
			<div class="main_zxr">
				<div class="smaillogo">
					<img src="../../static/images/fang_shubiao1_zxr.jpg">
					<p>赛睿（SteelSeries）Kinzu <br>
						<span>119.00</span></p>
				</div>
				<ul>
					<li>官方介绍<span>|</span></li>
					<li>规格参数<span>|</span></li>
					<li>评论晒单<span>|</span></li>
					<li>商品提问<span>|</span></li>
					<li>
						<div class="gouwu_zxr">加入购物车</div>
					</li>
				</ul>

			</div>
		</div>
	</div>
</template>

<script>
	import axios from 'axios';
	export default {
		data() {
			return {
				clickNumber: 1,
				goodsInfo: [],
				goodspicture: [],
				store: "",
				goods_id: 0,
				/*user_id: 1,*/
				result: 0,
				maxstore: 0,
				str: "",
				loginInfo: "",
				loginStatus: "请登录"
			}
		},

		mounted: function() {
			this.getGoodsInfo();
			this.getGoodsPicture();
			this.getSession();
		},

		created: function() {
			this.goods_id = this.$route.query.goods_id;
			var self = this;
			var url = 'http://localhost:8888/goods/getUserName';
			axios.post(url).then(function(response) {
				self.loginInfo = response.data;
			})
		},

		methods: {
			trans() {
				this.$router.push({
					path: '/',
					query: {
						str: this.str
					}
				})
			},

			count() {
				var url = "http://localhost:8888/goods/goodsinfo/";
				this.$axios.post(url, JSON.stringify({
						goods_id: this.goods_id
					}), {
						headers: {
							'Content-Type': 'application/json;charset=UTF-8'
						}
					})
					.then(response => {
						this.maxstore = response.data.goods_store;
						if(this.clickNumber < this.maxstore)
							this.clickNumber++;
						else if(this.clickNumber > this.maxstore) {
							alert("数据已更新，请刷新页面")
						}
					});
			},

			minus() {
				if(this.clickNumber > 1) {
					this.clickNumber--;
				}
			},

			getGoodsInfo() {
				var url = "http://localhost:8888/goods/goodsinfo/";
				this.$axios.post(url, JSON.stringify({
						goods_id: this.goods_id
					}), {
						headers: {
							'Content-Type': 'application/json;charset=UTF-8'
						}
					})
					.then(response => {
						this.goodsInfo = response.data;
						if(this.goodsInfo.goods_store == 0) {
							this.store = "商品暂时无货";
						} else {
							this.store = this.goodsInfo.goods_store + "件";
							this.maxstore = this.goodsInfo.goods_store;
							this.goods_id = this.goodsInfo.goods_id;
						}
					})
			},

			getGoodsPicture() {
				var url = "http://localhost:8888/goods/goodspicture/";
				this.$axios.post(url, JSON.stringify({
						goods_id: 3306
					}), {
						headers: {
							'Content-Type': 'application/json;charset=UTF-8'
						}
					})
					.then(response => {
						this.goodspicture = response.data;
					})
			},

			createclickNumber() {
				var url = "http://localhost:8888/goods/getUserSession/";
				this.$axios.get(url)
					.then(response => {
						var userInfo = response.data;
						if(userInfo == "") {
							alert("请先登录")
						} else {
							var url = "http://localhost:8888/goods/createShoppingCar/";
							this.$axios.post(url, JSON.stringify({
									goods_id: this.goods_id,
									user_id: userInfo.userId,
									goods_number: this.clickNumber,
								}), {
									headers: {
										'Content-Type': 'application/json;charset=UTF-8'
									}
								})
								.then(response => {
									this.result = response.data;
									if(this.result == 0) {
										alert("加入失败")
									} else {
										alert("加入成功")
									}
								})
						}
					})
			},
			
			getSession() {
				var url = "http://localhost:8888/goods/getUserSession/";
				this.$axios.get(url)
					.then(response => {
						var userInfo = response.data;
						if(userInfo != "") {
							this.loginStatus = "退出登录"
						}
					})
			},
			
			loginAndOut() {
				if(this.loginStatus == "你好，请登录") {
					this.$router.push({
						path: '/login'
					});
				} else {
					this.$axios.get("http://localhost:8888/user/loginout/")
						.then(response => {
							this.$router.push({
								path: '/login'
							});
						})
				}
			}
		}
	}
</script>

<style scoped>
	@import url("../../static/css/base.css");
	@import url("../../static/css/SteelSeries_zxr.css");
</style>