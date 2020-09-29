import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "./config"
// 初始化从localstorage获取布局主题设置
import bootstrap from '@/config/bootstrap'
import '@assets/styles/index.css'

Vue.config.productionTip = false;

new Vue({
    router,
    store,
    created: bootstrap,
    render: h => h(App)
}).$mount("#app");
