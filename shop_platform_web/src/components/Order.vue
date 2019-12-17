<template>
	<div>
		<!--收货地址body部分开始-->
		<div class="border_top_cart">
			<div class="container">
				<div class="checkout-box">
					<div class="checkout-box-bd">
						<!-- 地址状态 0：默认选择；1：新增地址；2：修改地址 -->
						<input type="hidden" name="Checkout[addressState]" id="addrState" value="0">
						<!-- 收货地址 -->
						<div class="xm-box">
							<div class="box-hd ">
								<h2 class="title">收货地址</h2>
							</div>
							<div class="box-bd">
								<div class="clearfix xm-address-list" id="checkoutAddrList">
									<dl class="item">
										<dt>
											<strong class="itemConsignee">{{input.consignee_name}}</strong> <span
												class="itemTag tag">家</span>
										</dt>
										<dd>
											<p class="tel itemTel">{{input.user_phone}}</p>
											<p class="itemRegion">{{input.user_address}}</p>
											<span class="edit-btn J_editAddr">编辑</span>
										</dd>
										<dd style="display: none">
											<input type="radio" name="Checkout[address]" class="addressId" value="10140916720030323">
										</dd>
									</dl>
									<div class="item use-new-addr" id="J_useNewAddr" data-state="off">
										<span class="iconfont icon-add"><img
											src="../../static/images/add_cart.png" /></span> 使用新地址
									</div>
								</div>
								<input type="hidden" name="newAddress[type]" id="newType" value="common"> <input type="hidden" name="newAddress[consignee]" id="newConsignee"> <input type="hidden" name="newAddress[province]" id="newProvince">
								<input type="hidden" name="newAddress[city]" id="newCity">
								<input type="hidden" name="newAddress[district]" id="newCounty">
								<input type="hidden" name="newAddress[address]" id="newStreet">
								<input type="hidden" name="newAddress[zipcode]" id="newZipcode">
								<input type="hidden" name="newAddress[tel]" id="newTel">
								<input type="hidden" name="newAddress[tag_name]" id="newTag">
								<!--点击弹出新增/收货地址界面start-->
								<div class="xm-edit-addr-box" id="J_editAddrBox">
									<div class="bd">
										<div class="item">
											<label>收货人姓名<span>*</span></label> <input type="text" name="userAddress[consignee]" id="Consignee" class="input" placeholder="收货人姓名" maxlength="15" autocomplete='off'>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>联系电话<span>*</span></label> <input type="text" name="userAddress[tel]" class="input" id="Telephone" placeholder="11位手机号" autocomplete='off'>
											<p class="tel-modify-tip" id="telModifyTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>地址<span>*</span></label>
											<select name="userAddress[province]" id="Provinces" class="select-1">
												<option>省份/自治区</option>
											</select>
											<select name="userAddress[city]" id="Citys" class="select-2" disabled>
												<option>城市/地区/自治州</option>
											</select>
											<select name="userAddress[county]" id="Countys" class="select-3" disabled>
												<option>区/县</option>
											</select>
											<textarea name="userAddress[street]" class="input-area" id="Street" placeholder="路名或街道地址，门牌号"></textarea>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>邮政编码<span>*</span></label> <input type="text" name="userAddress[zipcode]" id="Zipcode" class="input" placeholder="邮政编码" autocomplete='off'>
											<p class="zipcode-tip" id="zipcodeTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>地址标签<span>*</span></label> <input type="text" name="userAddress[tag]" id="Tag" class="input" placeholder='地址标签：如"家"、"公司"。限5个字内'>
											<p class="tip-msg tipMsg"></p>
										</div>
									</div>
									<div class="ft clearfix">
										<button type="button" class="btn btn-lineDake btn-small " id="J_editAddrCancel">取消</button>
										<button type="button" class="btn btn-primary  btn-small " id="J_editAddrOk">保存</button>
									</div>
								</div>
								<!--点击弹出新增/收货地址界面end-->
								<div class="xm-edit-addr-backdrop" id="J_editAddrBackdrop"></div>
							</div>
						</div>
						<!-- 收货地址 END-->
						<div id="checkoutPayment">
							<!-- 支付方式 -->
							<div class="xm-box">
								<div class="box-hd ">
									<h2 class="title">支付方式</h2>
								</div>
								<div class="box-bd">
									<ul id="checkoutPaymentList" class="checkout-option-list clearfix J_optionList">
										<li class="item selected"><input type="radio" name="Checkout[pay_id]" checked="checked" value="1">
											<p>
												在线支付 <span></span>
											</p>
										</li>
									</ul>
								</div>
							</div>
							<!-- 支付方式 END-->
							<div class="xm-box">
								<div class="box-hd ">
									<h2 class="title">配送方式</h2>
								</div>
								<div class="box-bd">
									<ul id="checkoutShipmentList" class="checkout-option-list clearfix J_optionList">
										<li class="item selected"><input type="radio" data-price="0" name="Checkout[shipment_id]" checked="checked" value="1">
											<p>
												快递配送（免运费） <span></span>
											</p>
										</li>
									</ul>
								</div>
							</div>
							<!-- 配送方式 END-->
							<!-- 配送方式 END-->
						</div>
						<!-- 送货时间 -->
						<div class="xm-box">
							<div class="box-hd">
								<h2 class="title">送货时间</h2>
							</div>
							<div class="box-bd">
								<ul class="checkout-option-list clearfix J_optionList">
									<li class="item selected"><input type="radio" checked="checked" name="Checkout[best_time]" value="1">
										<p>
											不限送货时间<span>周一至周日</span>
										</p>
									</li>
									<li class="item "><input type="radio" name="Checkout[best_time]" value="2">
										<p>
											工作日送货<span>周一至周五</span>
										</p>
									</li>
									<li class="item "><input type="radio" name="Checkout[best_time]" value="3">
										<p>
											双休日、假日送货<span>周六至周日</span>
										</p>
									</li>
								</ul>
							</div>
						</div>
						<!-- 送货时间 END-->
						<!-- 发票信息 -->
						<div id="checkoutInvoice">
							<div class="xm-box">
								<div class="box-hd">
									<h2 class="title">发票信息</h2>
								</div>
								<div class="box-bd">
									<ul class="checkout-option-list checkout-option-invoice clearfix J_optionList J_optionInvoice">
										<li class="hide">电子个人发票4</li>
										<li class="item selected">
											<!--<label><input type="radio"  class="needInvoice" value="0" name="Checkout[invoice]">不开发票</label>-->
											<input type="radio" checked="checked" value="4" name="Checkout[invoice]">
											<p>电子发票（非纸质）</p>
										</li>
										<li class="item "><input type="radio" value="1" name="Checkout[invoice]">
											<p>普通发票（纸质）</p>
										</li>
									</ul>
									<p id="eInvoiceTip" class="e-invoice-tip ">
										电子发票是税务局认可的有效凭证，可作为售后维权凭据，不随商品寄送。开票后不可更换纸质发票，如需报销请选择普通发票。
										<a href="http://bbs.xiaomi.cn/thread-9285999-1-1.html" target="_blank">什么是电子发票？</a>
									</p>
									<div class="invoice-info nvoice-info-1" id="checkoutInvoiceElectronic" style="display: none;">

										<p class="tip">电子发票目前仅对个人用户开具，不可用于单位报销 ，不随商品寄送</p>
										<p>发票内容：购买商品明细</p>
										<p>发票抬头：个人</p>
										<p>
											<span class="hide"><input type="radio" value="4"
												name="Checkout[invoice_type]" checked="checked"
												id="electronicPersonal" class="invoiceType"></span>
											<dl>
												<dt>什么是电子发票?</dt>
												<dd>&#903; 电子发票是纸质发票的映像，是税务局认可的有效凭证，与传统纸质发票具有同等法律效力，可作为售后维权凭据。
												</dd>
												<dd>&#903; 开具电子服务于个人，开票后不可更换纸质发票，不可用于单位报销。</dd>
												<dd>
													&#903; 您在订单详情的"发票信息"栏可查看、下载您的电子发票。
													<a href="http://bbs.xiaomi.cn/thread-9285999-1-1.html" target="_blank">什么是电子发票？</a>
												</dd>
											</dl>
										</p>
									</div>
									<div class="invoice-info invoice-info-2" id="checkoutInvoiceDetail" style="display: none;">
										<p>发票内容：购买商品明细</p>
										<p>发票抬头：请确认单位名称正确,以免因名称错误耽搁您的报销。注：合约机话费仅能开个人发票</p>
										<ul class="type clearfix J_invoiceType">
											<li class="hide"><input type="radio" value="0" name="Checkout[invoice_type]" id="noNeedInvoice"></li>
											<li class=""><input class="invoiceType" type="radio" id="commonPersonal" name="Checkout[invoice_type]" value="1"> 个人
											</li>
											<li class=""><input class="invoiceType" type="radio" name="Checkout[invoice_type]" value="2"> 单位</li>
										</ul>
										<div id='CheckoutInvoiceTitle' class=" hide  invoice-title">
											<label for="Checkout[invoice_title]">单位名称：</label> <input name="Checkout[invoice_title]" type="text" maxlength="49" value="" class="input"> <span class="tip-msg J_tipMsg"></span>
										</div>

									</div>

								</div>
							</div>
						</div>
						<!-- 发票信息 END-->
					</div>
					<div class="checkout-box-ft">
						<!-- 商品清单 -->
						<div id="checkoutGoodsList" class="checkout-goods-box">
							<div class="xm-box">
								<div class="box-hd">
									<h2 class="title">确认订单信息</h2>
								</div>
								<div class="box-bd">
									<dl class="checkout-goods-list">
										<dt class="clearfix">
											<span class="col col-1">商品名称</span> <span class="col col-2">购买价格</span>
											<span class="col col-3">购买数量</span> <span class="col col-4">小计（元）</span>
										</dt>
										<dd class="item clearfix" v-for="order in input.orderDetail">
											<div class="item-row">
												<div class="col col-1">
													<div class="g-pic">
														<img src="http://i1.mifile.cn/a1/T11lLgB5YT1RXrhCrK!40x40.jpg" srcset="http://i1.mifile.cn/a1/T11lLgB5YT1RXrhCrK!80x80.jpg 2x" width="40" height="40" />
													</div>
													<div class="g-info">
														<input type="hidden" v-model="order.goods_id" />
														<a href="#"> {{order.goods_name}} </a>
													</div>
												</div>

												<div class="col col-2">{{order.goods_price}}</div>
												<div class="col col-3">{{order.goods_number}}</div>
												<div class="col col-4">{{order.goods_number*order.goods_price}}元</div>
											</div>
										</dd>
									</dl>
									<div class="checkout-count clearfix">
										<div class="checkout-count-extend xm-add-buy">
											<h3 class="title">会员留言</h3>
											</br> <input type="text" />

										</div>
										<!-- checkout-count-extend -->
										<div class="checkout-price">
											<ul>

												<li>订单总额：<span>{{input.order_sum}}元</span>
												</li>
												<li>活动优惠：<span>-0元</span>
												</li>
												<li>优惠券抵扣：<span id="couponDesc">-0元</span>
												</li>
												<li>运费：<span id="postageDesc">0元</span>
												</li>
											</ul>
											<p class="checkout-total">
												应付总额：<span><strong id="totalPrice">{{input.order_sum}}</strong>元</span>
											</p>
										</div>
										<!--  -->
									</div>
								</div>
							</div>

							<!--S 加价购 产品选择弹框 -->
							<div class="modal hide modal-choose-pro" id="J_choosePro-664">
								<div class="modal-header">
									<span class="close" data-dismiss='modal'><i
										class="iconfont">&#xe617;</i></span>
									<h3>选择产品</h3>
									<div class="more">
										<div class="xm-recommend-page clearfix">
											<a class="page-btn-prev   J_carouselPrev iconfont" href="javascript: void(0);">&#xe604;</a>
											<a class="page-btn-next  J_carouselNext iconfont" href="javascript: void(0);">&#xe605;</a>
										</div>
									</div>
								</div>
								<div class="modal-body J_chooseProCarousel">
									<div class="J_carouselWrap modal-choose-pro-list-wrap">
										<ul class="clearfix J_carouselList"></ul>
									</div>
								</div>
								<div class="modal-footer">
									<a href="#" class="btn btn-disabled J_chooseProBtn">加入购物车</a>
								</div>
							</div>
							<!--E 加价购 产品选择弹框 -->

							<!--S 保障计划 产品选择弹框 -->

						</div>
						<!-- 商品清单 END -->
						<input type="hidden" id="couponType" name="Checkout[couponsType]">
						<input type="hidden" id="couponValue" name="Checkout[couponsValue]">
						<div class="checkout-confirm">
							<router-link to="/shoppingCar">
								<a href="E:\JD103code\eclipse-workspace\webjob01\WebContent\WEB-INF\shoppingcar.html" class="btn btn-lineDakeLight btn-back-cart">返回购物车</a>
							</router-link>
							<router-link to="/shoppingCar">
								<el-button type="text" class="btn btn-primary" id="checkoutToPay" @click="payfor">立即下单</el-button>
							</router-link>
						</div>
					</div>
				</div>
			</div>
			<!-- 禮品卡提示 S-->
			<div class="modal hide lipin-modal" id="lipinTip">
				<div class="modal-header">
					<h2 class="title">温馨提示</h2>
					<p>
						为保障您的利益与安全，下单后礼品卡将会被使用，<br> 且订单信息将不可修改。请确认收货信息：
					</p>
				</div>
				<div class="modal-body">
					<ul>
						<li><strong>收&nbsp;&nbsp;货&nbsp;&nbsp;人：</strong><span id="lipin-uname"></span></li>
						<li><strong>联系电话：</strong><span id="lipin-uphone"></span></li>
						<li><strong>收货地址：</strong><span id="lipin-uaddr"></span></li>
					</ul>
				</div>
				<div class="modal-footer">
					<span class="btn btn-primary" id="useGiftCard">确认下单</span><span class="btn btn-dakeLight" id="closeGiftCard">返回修改</span>
				</div>
			</div>
			<!--  禮品卡提示 E-->
			<!-- 预售提示 S-->

		</div>

		<!--收货地址body部分结束-->
		<!-- 底部 -->
		<div class="promise_box">
			<div class="w">
				<ul>
					<li><img src="../../static/images/promise_img01.jpg"><span>365天不打烊</span></li>
					<li><img src="../../static/images/promise_img02.jpg"><span>无理由退换货</span></li>
					<li><img src="../../static/images/promise_img03.jpg"><span>担保交易</span></li>
					<li><img src="../../static/images/promise_img04.jpg"><span>先行赔付</span></li>
					<li><img src="../../static/images/promise_img05.jpg"><span>支持定制</span></li>
				</ul>
			</div>
		</div>
		<div class="bottom-links">
			<ul class="clearfix cols">
				<li class="col">
					<div class="bottom-links-title">关于我们</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<a href="#">招聘英才</a>
						</li>
						<li>
							<a href="#">公司简介</a>
						</li>
						<li>
							<a href="#">合作洽谈</a>
						</li>
						<li>
							<a href="#">联系我们</a>
						</li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">客服中心</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<a href="#">收货地址</a>
						</li>
						<li>
							<a href="#">个人资料</a>
						</li>
						<li>
							<a href="#">修改密码</a>
						</li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">售后服务</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<a href="#">退换货政策</a>
						</li>
						<li>
							<a href="#">退款说明</a>
						</li>
						<li>
							<a href="#">联系卖家</a>
						</li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">帮助中心</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<a href="#">FAQ</a>
						</li>
						<li>
							<a href="#">积分兑换</a>
						</li>
						<li>
							<a href="#">积分细则</a>
						</li>
						<li>
							<a href="#">已购商品</a>
						</li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">锡好网公众号</div>
					<ul class="clearfix bottom-links-items">
						<li><img src="../../static/images/weixin_big.jpg" /></li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">关注我们</div>
					<ul class="clearfix bottom-links-items">
						<li><img src="../../static/images/icon_sina.png" />
							<a href="#">新浪微博</a>
						</li>
						<li><img src="../../static/images/icon_tencent.png" />
							<a href="#">腾讯微博</a>
						</li>
						<li><img src="../../static/images/icon_dou.png" />
							<a href="#">豆瓣小站</a>
						</li>
						<li><img src="../../static/images/icon_weixin.png" />
							<a href="#">官方微信</a>
						</li>
					</ul>
				</li>

			</ul>
		</div>
		<div class="footer_v2013 bottom-about">
			<div class="w">
				<p class="foot_p1">
					<a href="#">首页</a>|
					<a href="#">招聘英才</a>|
					<a href="#">广告合作</a>|
					<a href="#">联系我们</a>|
					<a href="#">关于我们</a>
				</p>
				<pre>
    经营许可证：苏B2-20130223备案许可证：苏ICP备13041162号-1360网站安全检测平台
    ©2013-2014 无锡太湖云电商网络科技发展有限公司   版权所有  更多模板：<a
					href="http://www.mycodes.net/" target="_blank">源码之家</a>
                </pre>
			</div>
			<p>
				<a href="#"><img src="../../static/images/bottom_img01.png"></a>
				<a href="#"><img src="../../static/images/bottom_img02.png"></a>
				<a href="#"><img src="../../static/images/bottom_img03.png"></a>
				<a href="#"><img src="../../static/images/bottom_img04.png"></a>
				<a href="#"><img src="../../static/images/bottom_img05.png"></a>
				<a href="#"><img src="../../static/images/bottom_img06.png"></a>
				<a href="#"><img src="../../static/images/bottom_img07.png"></a>
				<a href="#"><img src="../../static/images/bottom_img08.png"></a>
				<a href="#"><img src="../../static/images/bottom_img09.png"></a>
			</p>
		</div>
		<!-- 底部 -->
		<div class="fixed-buttons">
			<ul>
				<li>
					<a href="#" class="fixed-weixin"><img src="../../static/images/fixed_weixin.png" />
						<div class="weixin-pic">
							<img src="../../static/images/weixin_big.jpg">
						</div>
					</a>
				</li>
				<li><img id="imgBtn-to-top" src="../../static/images/back_top.png" /></li>
			</ul>
		</div>
	</div>
</template>

<script>
	var checkoutConfig = {
		addressMatch: 'common',
		addressMatchVarName: 'data',
		hasPresales: false,
		hasBigTv: false,
		hasAir: false,
		hasScales: false,
		hasGiftcard: false,
		totalPrice: 244.00,
		postage: 10, //运费
		postFree: true, //活动是否免邮了
		bcPrice: 150, //计算界值
		activityDiscountMoney: 0.00, //活动优惠
		showCouponBox: 0,
		invoice: {
			NA: "0",
			personal: "1",
			company: "2",
			electronic: "4"
		}
	};
	var miniCartDisable = true;

	import axios from 'axios'
	export default {
		name: 'Order',
		data() {
			return {
				input: {
					//					orderDetail: [{
					//							goods_name: "cjl",
					//							goods_price: 25,
					//							goods_id: 654321,
					//							goods_number: 5
					//						},
					//						{
					//							goods_name: "gbb",
					//							goods_price: 25,
					//							goods_id: 438438,
					//							goods_number: 5
					//						}
					//					],
					//					order_sum: 250,
					//					user_id: 123456,
					//					consignee_name: "llx",
					//					user_phone: 130123456789,
					//					user_address: "江苏省连云港市",
					//					order_status: 1
				}
			}
		},
		mounted: function() { //mounted　表示这个 Vue 对象加载成功了
			var self = this;
			axios.post("http://localhost:8888/getOrders").then(function(response) {
				self.input = response.data;
			})
		},
		methods: {
			payfor: function() {
				var self = this;
				let formData = JSON.stringify(self.input)
				var url = "http://localhost:8888/orders";
				var url2 = "http://localhost:8888/updateOrders";
				axios.post(url, formData, {
					headers: {
						'Content-Type': 'application/json;charset=UTF-8'
					}
				}).then(function(response) {
					console.log(response);
				})
				self.$confirm('下单成功！是否支付?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					self.$message({
						type: 'success',
						message: '支付成功!'
					});
					axios.post(url2, formData, {
						headers: {
							'Content-Type': 'application/json;charset=UTF-8'
						}
					}).then(function(response) {
						console.log(response);
					})
				}).catch(() => {
					self.$message({
						type: 'info',
						message: '支付失败!'
					});
				});

			}

		}

	}
</script>
<style scoped>
	@import '../../static/css/public.css';
	@import '../../static/css/base1.css';
	@import '../../static/css/checkOut.css';
</style>