<template xmlns="http://www.w3.org/1999/html">
    <div class="bg">
        <div class="form-div-style">
            <h1>Zyc基础框架</h1>
            <a-form
                    class="div-center"
                    style="margin-top: 40px;width: 50%;"
                    :form="form"
                    :wrapper-col="{ span: 24 }"
                    @submit="handleSubmit">
                <a-form-item>
                    <a-input
                            v-decorator="['name', { rules: [{ required: true, message: '请输入账号！' }] }]"
                            placeholder="请输入账号"
                    >
                        <a-icon slot="prefix" type="user" style="color:rgba(0,0,0,.25)"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input
                            type="password"
                            v-decorator="['password',{ rules: [
                                { required: true, message: '密码错误！' },
                                { minLength:8,message: '密码不得少于八位数！' }
                                ] }]"
                            placeholder="请输入密码"
                    >
                        <a-icon slot="prefix" type="lock" style="color:rgba(0,0,0,.25)"/>
                    </a-input>
                </a-form-item>
                <a-form-item style="margin: -20px 0;">
                    <a-checkbox @change="()=>{this.isRememberPassword.isFlag = !this.isRememberPassword.isFlag}"
                                :checked="isRememberPassword.isFlag"
                                style="float: left;">
                        记住密码
                    </a-checkbox>
                </a-form-item>
                <a-form-item style="text-align: center">
                    <a-button :loading="loginBtn" style="float: left;">注册</a-button>
                    <a-button :loading="loginBtn" type="primary" html-type="submit" style="float: right;">
                        登录
                    </a-button>
                </a-form-item>
            </a-form>
        </div>
        <login-foote></login-foote>
    </div>
</template>

<script>
    import md5 from 'md5'
    import {timeFix} from '@/utils/util'
    import { mapActions } from 'vuex'
    import LoginFooter from "@views/system/modules/LoginFooter";

    export default {
        components: {LoginFooter},
        data() {
            return {
                form: this.$form.createForm(this),
                isRememberPassword: {
                    isFlag: false,
                    name: '',
                    password: ''
                },
                loginBtn: false
            }
        },
        mounted() {
            if (localStorage.getItem('isRememberPassword') === null || localStorage.getItem('isRememberPassword')  === undefined) {
                localStorage.setItem('isRememberPassword', JSON.stringify(this.isRememberPassword))
10           } else {
                let isRememberPassword = JSON.parse(localStorage.getItem('isRememberPassword'))
                if (isRememberPassword.isFlag) {
                    this.isRememberPassword = isRememberPassword
                    this.form.setFieldsValue({
                        'name': isRememberPassword.name,
                        'password': isRememberPassword.password
                    })
                } else {
                    this.isRememberPassword = {
                        isFlag: false,
                        name: '',
                        password: ''
                    }
                }
            }
        },
        methods: {
            ...mapActions(['Login', 'Logout']),
            //记住密码
            rememberPasswordTreat () {
                if (this.isRememberPassword.isFlag) {
                    this.isRememberPassword.name = this.form.getFieldValue('name')
                    this.isRememberPassword.password = this.form.getFieldValue('password')
                } else {
                    this.isRememberPassword.name = ''
                    this.isRememberPassword.password = ''
                }
                localStorage.setItem('isRememberPassword', JSON.stringify(this.isRememberPassword))
            },
            handleSubmit(e) {
                this.rememberPasswordTreat()
                e.preventDefault()
                const {form: {validateFields},Login} = this
                this.loginBtn = true
                validateFields((err, values) => {
                    if (!err) {
                        const loginParams = {...values}
                        loginParams.name = values.name
                        loginParams.password = md5(values.password)
                       Login(loginParams)
                         .then((res) => this.loginSuccess(res))
                            .catch(err => this.requestFailed(err))
                            .finally(() => {
                                this.loginBtn = false
                            })
                    } else {
                        setTimeout(() => {
                            this.loginBtn = false
                        }, 600)
                    }
                })
            },
            loginSuccess(res) {
                console.log(res)
                if (res.data.role==='admin'){
                    this.$router.push({path: '/'})
                    // 延迟 1 秒显示欢迎信息
                    setTimeout(() => {
                        this.$notification.success({
                            message: '欢迎',
                            description: `${timeFix()}，欢迎回来`
                        })
                    }, 1000)
                }else{

                }
            },
            requestFailed(err) {
                // this.$notification.error({
                //     message: '提示',
                //     description: `请检查您的账号密码是否正确`
                // })
                this.$notification['error']({
                    message: '错误',
                    description: ((err.response || {}).data || {}).message || '请求出现错误，请稍后再试',
                    duration: 4
                })
            }
        }
    }
</script>

<style scoped>
    .bg {
        background: url(~@/assets/img/bg.jpg) no-repeat;
        background-size: 100% 100%;
        width: 100%;
        height: 100%;
    }

    .form-div-style {
        border-radius: 15px;
        text-align: center;
        width: 25%;
        height: 35%;
        background: rgba(255, 255, 255, 0.3);
        padding: 20px;
        position: relative;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }


</style>
