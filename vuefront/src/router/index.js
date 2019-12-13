import Vue from 'vue'
import Router from 'vue-router'
import ORDER from '@/components/Order'

Vue.use(Router)

export default new Router({
  routes: [
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
      path:'/shopping/register',
      name:'register',
      component: userRegister
    },
	{
		path: '/login',
		name: 'Login',
		component: Login
	},
  ],
  mode:'history'
})
