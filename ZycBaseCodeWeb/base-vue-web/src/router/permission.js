// import Vue from 'vue'
// import router from '@/router'
// import store from '@/store'
// // import * as utils from '@/utils'
// import NProgress from 'nprogress' // progress bar
// import 'nprogress/nprogress.css' // progress bar style
// import notification from 'ant-design-vue/es/notification'
// import { ACCESS_TOKEN } from '@/store/mutation-types'
//
// NProgress.configure({ showSpinner: false }) // NProgress Configuration
//
// const whiteList = ['login'] // no redirect whitelist
//
// router.beforeEach((to, from, next) => {
//   NProgress.start() // start progress bar
//   // console.log(to, from)
//   // 假如本地token存在，已经登录了
//   // console.log(Vue.ls.get(ACCESS_TOKEN))
//   if (Vue.ls.get(ACCESS_TOKEN)) {
//     /* 输入登录页会跳转到首页 */
//     // console.log('ACCESS_TOKEN', true)
//     if (to.path === '/login') {
//       // console.log('登录后，输入登录地址，直接跳转工作台', to)
//       next({ path: '/dashboard' })
//       NProgress.done()
//     } else {
//       // console.log('登录后，根据角色判断是否是存在用户信息', store.getters.nickname)
//       if (!store.getters.nickname) {
//         // console.log('第一次请求获取用户信息和菜单', store.getters.nickname)
//         store
//           .dispatch('SelAdminUserInfo')
//           .then(res => {
//             // 根据用户角色过滤哪些菜单有权限
//             const roles = res.data.sysRole && res.data.sysRole.code
//             store.dispatch('GenerateRoutes', roles).then(asyncRouterMap => {
//               if (store.getters.access.length === 0) {
//                 // 如果没有添加菜单权限，无法进入
//                 // console.log('如果没有添加菜单权限，无法进入')
//                 store.dispatch('LogoutFed')
//                 notification.error({
//                   message: '提示',
//                   description: '你未获取系统菜单的权限，无法进入！'
//                 })
//               } else {
//                 // 根据roles权限生成可访问的路由表
//                 // 动态添加可访问路由表
//                 // console.log('动态添加可访问路由表')
//                 // console.log(asyncRouterMap)
//                 router.addRoutes(asyncRouterMap)
//                 // 延迟 1 秒显示欢迎信息
//                 // notification.success({
//                 //   message: store.getters.nickname,
//                 //   description: `${utils.timeFix()}，欢迎回来`
//                 // })
//                 next({ ...to, replace: true })
//               }
//             })
//           })
//           .catch(err => {
//             console.log(err)
//             store.dispatch('LogoutFed').then(() => {
//               next({ path: '/login', query: { redirect: to.fullPath }})
//             })
//           })
//       } else {
//         // console.log('登录后，已经获取用户信息，直接进入工作台', store.getters.nickname, to)
//         next()
//       }
//     }
//   } else {
//     // console.log('ACCESS_TOKEN', false)
//     // console.log('to.name', to)
//     // console.log('from.name', from)
//     if (whiteList.includes(to.name)) {
//       // 在免登录白名单，直接进入
//       next()
//     } else {
//       next({ path: '/login', query: { redirect: to.fullPath }})
//       NProgress.done() // if current page is login will not trigger afterEach hook, so manually handle it
//     }
//   }
// })
//
// router.afterEach((to, from) => {
//   NProgress.done() // finish progress bar
// })
