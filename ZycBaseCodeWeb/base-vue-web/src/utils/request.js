import Vue from 'vue'
import axios from 'axios'
import store from '@/store'
import nprogress from './nprogress'
import notification from 'ant-design-vue/es/notification'
import storage from 'store'

notification.config({
    placement: 'bottomRight'
})

// 请求超时最多重试3次
axios.defaults.retry = 3
axios.defaults.retryDelay = 1000

const service = axios.create({
    // 请求超时时间
    timeout: 20000,
    // 允许携带cookie
    withCredentials: true
})

const err = (error)=>{
    nprogress.done()

    if (!error.response){
        notification.error({
            message:'请检查网络连接'
        })
        return Promise.reject(error)
    }

    const data =error.response.data
    const token = storage.get('ACCESS_TOKEN')
}



export default service


