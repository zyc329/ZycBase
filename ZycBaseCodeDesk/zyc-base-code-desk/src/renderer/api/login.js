import axios from '@/utils/request' // 引入封装好的 axios 请求

export function login(params) { // 测试
    return axios({
        url: '/demo/text',
        method: 'post',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
        },
        data: params
    })
}

// export function login(params) { // 登录接口
//     return axios({ // 使用封装好的 axios 进行网络请求
//         url: '/login/userLogin',
//         method: 'post',
//         headers: {
//             'Content-Type': 'application/json;charset=UTF-8'
//         },
//         data: params
//     })
// }

