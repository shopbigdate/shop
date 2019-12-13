import Vue from 'vue'
import Router from 'vue-router'
import ORDER from '@/components/Order'
import goods_info_index from '@/components/goods_info_index.vue'
import GoodsDetails from '@/components/GoodsDetails.vue'
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
    }
  ],
  mode:'history'
})
