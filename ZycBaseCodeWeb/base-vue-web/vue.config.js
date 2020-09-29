const path = require('path')
const webpack = require('webpack')

function resolve(dir) {
    return path.join(__dirname, dir)
}

module.exports = {
    lintOnSave: false,
    configureWebpack: {
        externals: {
            'BMap': 'BMap'
        },
        plugins: [
            // Ignore all locale files of moment.js
            new webpack.IgnorePlugin(/^\.\/locale$/, /moment$/)
        ]
    },

    chainWebpack: (config) => {
        config.resolve.alias
            .set('@', resolve('src'))
            .set('@api', resolve('src/api'))
            .set('@assets', resolve('src/assets'))
            .set('@comp', resolve('src/components'))
            .set('@views', resolve('src/views'))
            .set('@layout', resolve('src/layout'))

        config.module
            .rule("svg")
            .exclude.add(resolve("src/assets/icon/svg"))
            .end();
        // 第二步：使用svg-sprite-loader 对 src/assets/imgs/svgs下的svg进行操作
        config.module
            .rule("icons")
            .test(/\.svg$/)
            .include.add(resolve("src/assets/icon/svg"))
            .end()
            .use("svg-sprite-loader")
            .loader("svg-sprite-loader")
            //定义规则 使用时 <svg class="icon"> <use xlink:href="#icon-svg文件名"></use>  </svg>
            .options({
                symbolId: "icon-[name]"
            })
            .end();
    },


    css: {
        loaderOptions: {
            less: {
                modifyVars: {
                    /* less 变量覆盖，用于自定义 ant design 主题 */

                    /*
                    'primary-color': '#F5222D',
                    'link-color': '#F5222D',
                    'border-radius-base': '4px',
                    */
                },
                javascriptEnabled: true
            }
        }
    },

    devServer: {
        // development server port 8000
        port: 5555,
        proxy: {
            '/': {
                target: 'http://127.0.0.1:18081/',
                ws: false,
                changeOrigin: true
            },
        }
    },

    // disable source map in production
    productionSourceMap: true,
    // babel-loader no-ignore node_modules/*
    transpileDependencies: [
        'vue-echarts',
        'resize-detector'
    ]
}
