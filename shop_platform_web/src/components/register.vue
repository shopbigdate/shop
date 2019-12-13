<template>
	<div id="re">
		<div id="header">
			<div class="h-top">
				<!-- 图标logo -->
				<img :src="img" alt="" />
			</div>
			<!-- 已有账号 -->
			<p>已有账号？
				<router-link to="/Login">请登录</router-link>
			</p>
		</div>

		<div id="content">
			<div class="input_div">
				<form id="form1">
					<div class="input_control">
						<input type="text" class="form_input" v-model="userInfo.userName" placeholder="请输入你的用户名" @blur="username" />
						<span class="hint" style="color: red;">{{hint.nameHint}}</span>
					</div>
					<div class="input_control">
						<label>
                <input type="password" class="form_input" v-model="userInfo.userPassword" placeholder="请输入你的密码" @blur="password" />
              </label>
						<span class="hint" style="color: red;">{{hint.pwdHint}}</span>
					</div>
					<div class="input_control">
						<input type="password" class="form_input" v-model="userInfo.password2" placeholder="再一次输入你的密码" @blur="passwordAgain" />
						<span class="hint" style="color: red;">{{hint.pwdHint1}}</span>
					</div>
					<div class="input_control">
						<input type="text" class="form_input" v-model="userInfo.userPhone" placeholder="请输入你的11位手机号" @blur="link" />
						<span class="hint" style="color: red;">{{hint.linkHint}}</span>
					</div>
					<div class="input_control">
						<button id="btd" class="ant-btn-red" @click="flag" :disabled="btn">立即注册</button>
					</div>
				</form>
			</div>
		</div>

		<div id="footer">
			<div class="other">
				<a href="https://www.jd.com/" class="about">关于我们</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="http://about.jd.com/contact" class="call">联系我们</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="http://zhaopin.jd.com/home;jsessionid=0D8472A29BF72DC239E3DE9FA99D04A9.s1" class="people">人才招聘</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="https://www.jd.com/" class="peo">商家入驻</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp; &nbsp;&nbsp;&nbsp;
				<a href="https://www.jd.com/" class="tall">广告服务</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp; &nbsp;&nbsp;&nbsp;
				<a href="https://app.jd.com/" class="phone">手机京东</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="https://club.jd.com/links.aspx" class="friend">友情链接</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp; &nbsp;&nbsp;&nbsp;
				<a href="https://media.jd.com/" class="shop">销售联盟</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp; &nbsp;&nbsp;&nbsp;
				<a href="https://sale.jd.com/act/n0hAvqy5CW8.html" class="club">京东社区</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="https://gongyi.jd.com/" class="love">京东公益</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp; &nbsp;&nbsp;&nbsp;
				<a href="https://www.joybuy.com/" class="english">English Site</a>
			</div>
			<div class="versions">
				<span>Copyright © 2004-2018 京东JD.com 版权所有</span>
			</div>
		</div>
	</div>
</template>

<script>
	import Img from '@/img/logo.png'
	export default {
		name: "register",
		data() {
			return {
				img: Img,
				btn: false,
				hint: {
					nameHint: '',
					pwdHint: '',
					pwdHint1: '',
					linkHint: '',
				},
				userInfo: {
					userName: '',
					userPassword: '',
					password2: '',
					userPhone: '',
				},
			}
		},
		methods: {
			//用户名
			username: function() {
				let formData = JSON.stringify(this.userInfo);
				//alert(this.userInfo.userName);
				this.hint.nameHint = '';
				if(this.userInfo.userName.length === 0)
					this.hint.nameHint = '用户名不能为空';
				else if(this.userInfo.userName.length < 3 || this.userInfo.userName.length > 15)
					this.hint.nameHint = '用户名不得小于3个字符或大于15个字符';
				else {
					var self = this;
					this.$axios({
							method: "post",
							url: 'http://localhost:8888/user/select',
							data: formData,
							headers: {
								'Content-Type': 'application/json;charset=UTF-8'
							}
						})
						.then(function(dat) {
							if(dat.data == true) {
								self.hint.nameHint = '恭喜,用户名可用'
							} else if(dat.data == false) {
								self.hint.nameHint = '用户名已存在,请重新创建'
							}
						})
				}
			},
			//密码
			password: function() {
				this.hint.pwdHint = '';
				var p = /^[a-zA-z][a-zA-Z0-9_]{5,15}$/;
				if(this.userInfo.userPassword.length === 0) {
					this.hint.pwdHint = '密码不能为空';
				} else if(!p.test(this.userInfo.userPassword)) {
					this.hint.pwdHint = '由字母+数字组成的6-16位密码，字母开头'
				} else {
					this.hint.pwdHint = '';
				}
			},
			passwordAgain: function() {
				this.hint.pwdHint1 = '';
				if(this.userInfo.password2 === 0) {
					this.hint.pwdHint1 = '重复密码不能为空'
				} else if(this.userInfo.userPassword !== this.userInfo.password2)
					this.hint.pwdHint1 = '前后两次密码不一致';
				else {
					this.hint.pwdHint1 = '';
				}
			},
			link: function() {
				this.hint.linkHint = '';
				var n = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
				if(this.userInfo.userPhone.length === 0) {
					this.hint.linkHint = '手机号不能为空';
				} else if(!n.test(this.userInfo.userPhone)) {
					this.hint.linkHint = '手机号格式不正确';
				} else {
					this.hint.linkHint = '';
				}
			},
			flag: function() {
				this.hint.nameHint = '';
				this.hint.pwdHint = '';
				this.hint.pwdHint1 = '';
				this.hint.linkHint = '';
				let formData = JSON.stringify(this.userInfo);
				if(this.userInfo.userName.length === 0)
					this.hint.nameHint = '用户名不能为空';
				else if(this.userInfo.userName.length < 3 || this.userInfo.userName.length > 15)
					this.hint.nameHint = '用户名不得小于3个字符或大于15个字符';
				else {
					var self = this;
					this.$axios({
							method: "post",
							url: 'http://localhost:8888/user/select',
							data: formData,
							headers: {
								'Content-Type': 'application/json;charset=UTF-8'
							}
						})
						.then(function(dat) {
							if(dat.data == true) {
								self.hint.nameHint = '恭喜,用户名可用'
							} else if(dat.data == false) {
								self.hint.nameHint = '用户名已存在,请重新创建'
							}
						})
				}
				var p = /^[a-zA-z][a-zA-Z0-9_]{5,15}$/;
				if(this.userInfo.userPassword.length === 0) {
					this.hint.pwdHint = '密码不能为空';
				} else if(!p.test(this.userInfo.userPassword)) {
					this.hint.pwdHint = '由字母+数字组成的6-16位密码，字母开头'
				}
				if(this.userInfo.password2 === 0) {
					this.hint.pwdHint1 = '重复密码不能为空！！'
				} else if(this.userInfo.password2 !== this.userInfo.password2) {
					this.hint.pwdHint1 = '前后两次密码不一致!';
				}
				var n = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
				if(this.userInfo.userPhone.length === 0) {
					this.hint.linkHint = '手机号不能为空!';
				} else if(!n.test(this.userInfo.userPhone)) {
					this.hint.linkHint = '手机号格式不正确!';
				} else {
					this.$axios({
							method: "post",
							url: 'http://localhost:8888/user/register',
							data: formData,
							headers: {
								'Content-Type': 'application/json;charset=UTF-8'
							}
						})
						.then((dat) => {
							if(dat.data == 1) {
								alert("注册成功")
								this.$router.push({
								path: '/Login'
							});
							} else {
								alert("注册失败")
							}
						})
				}
			}
		}
	}
</script>

<style scoped>
	.input_control {
		width: 360px;
		margin: 20px auto;
	}
	
	input[type="text"],
	input[type="password"],
	#btd {
		box-sizing: border-box;
		text-align: center;
		font-size: 1.4em;
		height: 2.7em;
		border-radius: 4px;
		border: 1px solid #c8cccf;
		color: #6a6f77;
		-web-kit-appearance: none;
		-moz-appearance: none;
		display: block;
		outline: 0;
		padding: 0 1em;
		text-decoration: none;
		width: 100%;
	}
	
	input[type="password"]:focus {
		border: 1px solid #ff7496;
	}
	
	input[type="text"]:focus {
		border: 1px solid #ff7496;
	}
	
	.ant-btn-red {
		color: #fff;
		background-color: #FF5A44;
		border-color: #FF5A44;
		text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.12);
		-webkit-box-shadow: 0 2px 0 rgba(0, 0, 0, 0.045);
		box-shadow: 0 2px 0 rgba(0, 0, 0, 0.045);
	}
	
	#re {
		text-align: center;
	}
</style>