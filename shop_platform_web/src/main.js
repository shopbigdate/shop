// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import Qs from 'qs'

Vue.config.productionTip = false

Vue.prototype.$axios = axios;
//$axios：在需要axios的vue文件中引用axios的别名，比如this.$axios.post()...
//如果写成Vue.prototype.$http = axios,那么要改成this.$http.post()...
Vue.prototype.qs = Qs;

Vue.use(ElementUI);

//允许请求携带Cookie信息
axios.default.withCredentials = true

/* eslint-disable no-new */
new Vue({
	el: '#app',
	router,
	components: {
		App
	},
	template: '<App/>'
})