<template>
	<div>
		<div class="first">
			<a href=""><img alt="" src="../../static/images/logo-201305-b.png"></a>&nbsp&nbsp&nbsp&nbsp&nbsp
			<font size="5">欢迎登录</font>
		</div>
		<div class="second">
			<div class="second_first">
				<div class="second_first_first">
					<div class="second_first_first_first">
						<font size=2>京东不会以任何理由要求您转账汇款，谨防诈骗。</font>
					</div>
					<div class="second_first_first_second">
						<font size=4>
							<a href="">扫码登录</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp丨&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<a href="">账户登录</a>
						</font>
					</div>
					<div class="second_first_first_third">
						<form action="">
							<br>
							<label for="loginname" class="label1"></label>
							<input type="text" class="username" v-model="input.userName" placeholder="用户名" @blur="onUser">
							<br><br>
							<label for="password" class="label2"></label>
							<input type="password" class="password" v-model="input.userPassword" placeholder="密码" @blur="onPass">
							<br>
							<div class="msg" v-model="input.msg">{{input.msg}}</div>
							<a href="" style="height: 20px;">
								<font size="2" style="float:right;height: 20px;">忘记密码</font>
							</a>
							<br><br>
							<button @click="onSubmit" class="submit">登录</button>
						</form>
					</div>
					<div class="second_first_first_forth">
						&nbsp&nbsp
						<label for="QQ" class="label_qq"></label>
						<a href="" name="QQ" class="QQ">&nbsp&nbsp&nbsp&nbsp&nbspQQ</a>
						丨&nbsp
						<label for="weixin" class="label_weixin"></label>
						<a href="" name="weixin" class="weixin">&nbsp&nbsp&nbsp&nbsp&nbsp微信</a>

						<a href="" style="float:right"><label class="zhuce"></label>&nbsp&nbsp&nbsp&nbsp立即注册&nbsp&nbsp&nbsp&nbsp</a>
					</div>
				</div>
			</div>
		</div>
		<!-- second div -->
		<div class="third">
			<ul>
				<li>
					<a href="">关于我们</a>
				</li>
				<li>
					<a href="">联系我们</a>
				</li>
				<li>
					<a href="">人才招聘</a>
				</li>
				<li>
					<a href="">商家入驻</a>
				</li>
				<li>
					<a href="">广告服务</a>
				</li>
				<li>
					<a href="">手机京东</a>
				</li>
				<li>
					<a href="">友情链接</a>
				</li>
				<li>
					<a href="">销售联盟</a>
				</li>
				<li>
					<a href="">京东社区</a>
				</li>
				<li>
					<a href="">京东公益</a>
				</li>
				<li>
					<a href="">English Site</a>
				</li>
			</ul>
		</div>
		<div class="forth">
			Copyright © 2004-2019 京东JD.com 版权所有
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				input: {
					userName: '',
					userPassword: '',
					msg: ''
				}
			}
		},
		methods: {
			onSubmit() {
				let formData = JSON.stringify(this.input);
				//var formData = this.input
				this.$axios({
					method: "post",
					url: "http://localhost:8888/login",
					headers: {
						"Content-Type": "application/json;charset=UTF-8"
					},
					data: formData
				}).then((res) => {
					console.log(res);
					if(res.status == 200) { //请求成功
						if(res.data) { //登录成功
							//成功后跳转
							this.$router.push({
								path: '/'
							});
						} else { //登录失败
							this.input.msg = "用户名或密码输入错误"
						}
					}
				}).catch((error) => {
					console.log(error) //请求失败返回的数据
				})
			},
			onUser() {
				this.input.msg = ""
				if(this.input.userName == "")
					this.input.msg = "用户名不能为空"
			},
			onPass() {
				this.input.msg = ""
				if(this.input.userPassword == "")
					this.input.msg = "密码不能为空"
			}
		}
	}
</script>

<style>
	a {
		text-decoration: none;
	}
	
	li {
		overflow: hidden;
		border-right: 1px solid;
		float: left;
		text-align: center;
		width: 100px;
		font-size: 12px;
	}
	
	.first {
		width: 100%;
		height: 100px;
		padding-left: 200px;
	}
	
	.second {
		width: 100%;
		height: 500px;
		background-color: #6B0A1D;
		padding-left: 300px;
	}
	
	.second_first {
		padding-top: 10px;
		width: 1000px;
		height: 490px;
		background-image: url(../../static/images/db26121dd54f6464.jpg);
	}
	
	.second_first_first {
		margin-left: 600px;
		width: 360px;
		height: 85%;
		background-color: white;
	}
	
	.second_first_first_first {
		width: 100%;
		height: 30px;
		padding-top: 10px;
		background-color: #FFF8F0;
		text-align: center;
	}
	
	.second_first_first_second {
		width: 100%;
		height: 40px;
		padding-top: 20px;
		text-align: center;
		border-bottom: 1px solid #DEDEDE;
	}
	
	.second_first_first_third {
		width: 320px;
		height: 240px;
		padding-left: 20px;
		padding-top: 20px;
		padding-right: 20px;
		border-bottom: 1px solid #DEDEDE;
	}
	
	.label1 {
		position: absolute;
		width: 38px;
		height: 38px;
		background-image: url(../../static/images/pwd-icons-new.png);
		border: 1px solid #DEDEDE;
	}
	
	.username {
		width: 260px;
		height: 36px;
		padding-left: 60px;
		border: 1px solid #DEDEDE;
	}
	
	.label2 {
		position: absolute;
		width: 38px;
		height: 38px;
		background-image: url(../../static/images/pwd-icons-new.png);
		background-position: -48px 0;
		border: 1px solid #DEDEDE;
	}
	
	.password {
		width: 260px;
		height: 36px;
		padding-left: 60px;
		border: 1px solid #DEDEDE;
	}
	
	.msg {
		margin-top: 6px;
		width: 260px;
		height: 36px;
		padding-left: 60px;
		color: red;
	}
	
	.submit {
		width: 320px;
		height: 31px;
		background-color: #E4393C;
		border: 1px solid #e85356;
		font-size: 20px;
		color: #fff;
		cursor: pointer;
	}
	
	.second_first_first_forth {
		padding-top: 19px;
		width: 100%;
		height: 35px;
		background-color: #FCFCFC;
	}
	
	.QQ {}
	
	.label_qq {
		position: absolute;
		width: 19px;
		height: 18px;
		background-image: url(../../static/images/QQ-weixin.png);
	}
	
	.weixin {}
	
	.label_weixin {
		position: absolute;
		background-position: -19px 0;
		width: 19px;
		height: 18px;
		background-image: url(../../static/images/QQ-weixin.png);
	}
	
	.zhuce {
		position: absolute;
		background-image: url(../../static/images/pwd-icons-new.png);
		background-position: -104px -75px;
		width: 16px;
		height: 16px;
		float: right;
	}
	
	.third {
		padding-left: 140px;
		width: 100%;
		padding-top: 5px;
		height: 40px;
	}
	
	.forth {
		width: 100%;
		height: 20px;
		text-align: center;
	}
</style>