// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
Vue.config.productionTip = false

import Qs from 'qs'
Vue.prototype.qs = Qs;

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

import axios from 'axios'
//允许请求携带Cookie信息
axios.defaults.withCredentials = true
Vue.prototype.$axios = axios;
//$axios：在需要axios的vue文件中引用axios的别名，比如this.$axios.post()...
//如果写成Vue.prototype.$http = axios,那么要改成this.$http.post()...

/* eslint-disable no-new */
new Vue({
	el: '#app',
	router,
	components: {
		App
	},
	template: '<App/>'
})