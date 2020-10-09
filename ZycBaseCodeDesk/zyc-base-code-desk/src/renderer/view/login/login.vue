<template>
    <div class="outer-div" style="position: relative;">
        <div class="card">
<!--            <h1>个人入账系统</h1>-->
            <a-form :form="form">
                <a-form-item>
                    <a-input
                            size="large"
                            type="text"
                            placeholder="用户名"
                            v-decorator="['username',{rules: [{ required: true, message: '请输入用户名' }], validateTrigger: 'change'}]">
                        <a-icon slot="prefix" type="user" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input
                            size="large"
                            type="password"
                            autocomplete="false"
                            placeholder="密码"
                            v-decorator="['password',{rules: [{ required: true, message: '请输入密码' }], validateTrigger: 'blur'}]">
                        <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                    </a-input>
                </a-form-item>
            </a-form>
            <a-button @click="clickLogin" :loading="loading">登录</a-button>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                loading: false,
                form: this.$form.createForm(this)
            }
        },
        mounted() {

        },
        methods: {
            clickLogin() {
                const {form: {validateFields}} = this
                this.loading = true
                validateFields((errs, values) => {
                    if (!errs) {
                        this.$store
                            .dispatch('Login', values)
                            .then(response => {
                                let code = response.data.code
                                if (code == 200) {
                                    this.$router.push({
                                        name: 'HelloWorld'
                                    })
                                } else {
                                    this.$message.error('登陆失败！')
                                }
                            })
                            .catch(() => {
                                this.loading = false
                            })
                    } else {
                        // eslint-disable-next-line no-console
                        console.log('参数验证不合法！')
                        this.loading = false
                        return false
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .outer-div {
        width: 100%;
        height: 100%;
        background-image: url(~@/assets/login.jpg);
        background-repeat: no-repeat;
        background-size: 100% 100%;
        -moz-background-size: 100% 100%;
        text-align: center;
    }

    .card {
        position: absolute;
        width: 30%;
        height: 30%;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        text-align: center;
        background: rgba(255, 255, 255, 0.5);
        padding: 20px;
        border-radius: 15px;
    }
</style>
