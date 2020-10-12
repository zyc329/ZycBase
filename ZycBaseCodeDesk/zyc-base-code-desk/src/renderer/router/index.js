import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export const constantRouterMap = [
  {
    path: '/',
    name: 'Login',
    component: () => import('@/view/login/login')
  },
  {
    path: '/hello-world',
    name: 'HelloWorld',
    component: () => import('@/view/demo/HelloWorld')
  }
]

export default new Router({
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})

// export default new Router({
//     routes: [
//         {
//             path: '/',
//             name: 'HelloWorld',
//             component: () => import('@/renderer/view/demo/HelloWorld')
//         },
//         {
//             path: '*',
//             redirect: '/'
//         }
//     ]
// })
