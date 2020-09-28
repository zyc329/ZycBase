import axios from '@/utils/request' // 引入封装好的 axios 请求
const api = {
    demo: '/demo/text',
}
export default api

export function loginText(params) { // 测试
    return axios({
        url: api.demo,
        method: 'post',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
        },
        data: params
    })
}
