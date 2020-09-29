// antd ui 组件样式引入
import Vue from 'vue';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import config from '@/config/defaultSettings'

Vue.use(Antd);
//lodash
import _ from 'lodash'

Vue.prototype._ = _
//jquery
import $ from "jquery"

Vue.prototype.$ = $
// vue-ls
import Storage from 'vue-ls';

Vue.use(Storage, config.storageOptions);

//svg
import '@assets/icon/index.js'


