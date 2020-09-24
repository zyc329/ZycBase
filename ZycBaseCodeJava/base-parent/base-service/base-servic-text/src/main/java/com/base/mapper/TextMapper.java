package com.base.mapper;

import com.zyc.base.pojo.Text;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author ZengYc
 * @Date 2020/9/23 22:57
 * 使用通用Mapper，需要继承tk.mybatis.mapper.common.Mapper接口
 *      增加数据，调用Mapper.insert()
 *      增加数据，调用Mapper.insertSelective()
 *
 *      修改数据，调用Mapper.update(T)
 *      修改数据，调用Mapper.updateByPrimaryKey(T)
 *
 *      查询数据，根据ID查询:Mapper.selectByPrimaryKey(ID)
 *      查询数据，根据条件查询:Mapper.select(T)
 */
public interface TextMapper extends Mapper<Text> {

}
