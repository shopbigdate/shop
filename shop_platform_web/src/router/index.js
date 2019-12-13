import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import goods_info_index from '@/components/goods_info_index'
import ORDER from '@/components/Order'
import userRegister from '@/components/register'

Vue.use(Router)

export default new Router({
	routes: [{
			path: '/login',
			name: 'Login',
			component: Login
		},
		{
			path: '/',
			name: 'goods_info_index',
			component: goods_info_index
		},
		{
			path: '/Order',
			name: 'Order',
			component: ORDER
		},

		{
			path: '/shopping/register',
			name: 'register',
			component: userRegister
		},
	]
})