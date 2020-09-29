import _ from 'lodash'

/**
 * 判断是否是图片用
 * @param {String} fileName 文件名称
 */
export function isImg(fileName) {
    let rule = /\.(png|jpg|gif|jpeg|webp|bmp)$/i
    return rule.test(fileName)
}

/**
 * 获取指定字符串第N次出现的位置
 * @param {String} str 字符串
 * @param {String} inquiry 指定字符串
 * @param {Number}  n 第n次
 */
export const findStr = (str, inquiry, n) => {
    let index = str.indexOf(inquiry)
    for (let i = 0; i < n - 1; i++) {
        index = str.indexOf(inquiry, index + 1)
    }
    return index
}

/**
 * 删除对象中的指定key
 * @param {Object} obj 源对象
 * @param {Array | String} key 要被删除的key
 */
export const deleteObjKeyArr = (obj, key) => {
    let sourceObj = obj
    if (key instanceof Array) {
        for (let item of key) {
            delete sourceObj[item]
        }
    } else if (key instanceof String) {
        delete sourceObj[key]
    }
    return sourceObj
}

/**
 * 判断对象中是否存在指定key或某个key
 * @param {Object} obj 源对象
 * @param {Array | String} key 要被查找的key
 *  @param {Number} type 是否需要判断所有key都存在 0：是不需要，1：是需要
 */
export const isHaveKey = (obj, key, type = 0) => {
    let returnFlag = true
    if (key instanceof Array && type === 0) {
        for (let item of key) {
            if (_.has(obj, item)) {
                returnFlag = true
            }
        }
    } else if (key instanceof Array && type === 1) {
        for (let item of key) {
            if (!_.has(obj, item)) {
                returnFlag = false
            }
        }
    } else if (key instanceof String) {
        returnFlag = _.has(obj, key)
    }
    return returnFlag
}

/**
 * 删除Obj或者Array中的空值
 * @param {Object} obj 源Object
 * @param {Array} retain 无论如何都保留的字段
 * 返回处理后的数组
 */
export const deleteObjNull = (obj, retain = []) => {
    let sourceObj = _.clone(obj)
    let deleteFlag = ['', undefined, null, []]
    let retainFlag = retain
    // 删除数组中空值
    if (sourceObj instanceof Array) {
        sourceObj.forEach((item, index) => {
            if (deleteFlag.indexOf(item) > -1 || item.toString().trim() === '') {
                sourceObj.script(index, 1)
            }
        })
    }
    // 删除对象中空值
    for (let key in sourceObj) {
        if (sourceObj.hasOwnProperty(key)) {
            if (retainFlag.indexOf(key) === -1) {
                if (deleteFlag.indexOf(sourceObj[key]) > -1 || sourceObj[key].toString().trim() === '') {
                    delete sourceObj[key]
                }
            }
        }
    }
    return sourceObj
}

/**
 * 判断值是否为空
 * @param  source 数据源
 */
export const isEmpty = (source) => {
    let resultFlag = false
    if (source === undefined || source === null || source.toString() === '' || source.length === 0 || JSON.stringify(source) === '{}') {
        resultFlag = true
    }
    return resultFlag
}

/**
 * 截取字符串长度
 * @param  {String} str 字符串
 * @param  {Number} len 长度 默认10
 * @param  {Boolean} isShow 是否拼接... 默认true
 */
export const strLength = (str, len = 10, isShow = true) => {
    let resultStr = ''
    if (str.length <= len) {
        return str
    }
    if (isShow) {
        resultStr = str.substring(0, len) + '...'
    } else {
        resultStr = str.substring(0, len)
    }
    return resultStr
}
