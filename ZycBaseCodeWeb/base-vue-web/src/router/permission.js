import Vue from 'vue'
import router from '@/router'
import store from '@/store'
import storage from 'store'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import notification from 'ant-design-vue/es/notification'
import { ACCESS_TOKEN } from '@/store/mutation-types'

NProgress.configure({ showSpinner: false }) // NProgress Configuration

const whiteList = ['login']

router.beforeEach((to, from, next) => {
  NProgress.start()
  if (storage.get(ACCESS_TOKEN)) {
    if (to.path === '/login') {
      // console.log('登录后，输入登录地址，直接跳转工作台', to)
      next()
      NProgress.done()
    } else {
      if (!store.getters.nickname) {

      } else {
        next()
      }
    }
  } else {
    if (whiteList.includes(to.name)) {
      // 在免登录白名单，直接进入
      next()
    } else {
      next({ path: '/login', query: { redirect: to.fullPath }})
      NProgress.done()
    }
  }
})

router.afterEach((to, from) => {
  NProgress.done()
})
