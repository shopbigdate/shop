import Vue from 'vue'
import Router from 'vue-router'
import ORDER from '@/components/Order'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Order',
	  name: 'Order',
      component: ORDER
    }
  ],
  mode:'history'
})
