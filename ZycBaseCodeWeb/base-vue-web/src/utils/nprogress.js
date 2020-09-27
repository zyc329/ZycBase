import NProgress from 'nprogress'

NProgress.configure({ showSpinner: false })

export default {
  start () {
    NProgress.start()
  },

  done () {
    NProgress.done()
  }
}
