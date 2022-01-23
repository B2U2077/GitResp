// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueCookies from 'vue-cookies'
import axios from 'axios'
import echarts from 'echarts'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.prototype.$axios = axios
Vue.use(VueCookies);
Vue.prototype.$echarts = echarts

router.beforeEach((to,from,next) => {
  let userName = localStorage.getItem("userName");
  if(to.meta.requireAuth) {
    if(userName) {
      next()
    } else {
      next({
        path: '/login'
      })
    }
  } else {
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
