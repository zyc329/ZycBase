// antd ui 组件样式引入
import Vue from 'vue';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import 'ant-design-vue/dist/antd.css';

Vue.use(Antd);
//lodash
import _ from 'lodash'

Vue.prototype._ = _
//jquery
import $ from "jquery"

Vue.prototype.$ = $
// vue-ls
import Storage from 'vue-ls';

options = {
    namespace: 'pro__', // key键前缀
    name: 'ls', // 命名Vue变量.[ls]或this.[$ls],
    storage: 'local', // 存储名称: session, local, memory
};
Vue.use(Storage, options);

//svg
import '@assets/icon/index.js'


