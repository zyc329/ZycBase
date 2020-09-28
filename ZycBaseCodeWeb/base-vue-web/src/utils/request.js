import Vue from 'vue'
import axios from 'axios'
import store from '@/store'
import nprogress from './nprogress'
import notification from 'ant-design-vue/es/notification'

notification.config({
    placement: 'bottomRight'
})

// 创建 axios 实例
const service = axios.create({
    baseURL: '/api', // api base_url
    timeout: 30000 // 请求超时时间
})

export default service


