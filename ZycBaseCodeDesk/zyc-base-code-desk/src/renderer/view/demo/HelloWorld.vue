<template>
    <div style="height: 100%;width:100%;text-align: center;background: red;">
        <h1>第一个桌面应用</h1>
        <h2>HelloWorld!</h2>
        <a-button @click="clickBtn">请蹂躏我吧！</a-button>
    </div>
</template>

<script>
    export default {
      data () {
        return {}
      },
      mounted () {

      },
      methods: {
        clickBtn () {
          alert('臭猪猪！')
          this.$router.push({name: 'Login'})
        }
      }
    }
</script>

<style scoped>

</style>
