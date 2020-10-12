package com.base.service.impl;

import cn.hutool.core.util.IdUtil;
import com.base.mapper.TextMapper;
import com.base.service.TextService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyc.base.pojo.Text;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author ZengYc
 * @Date 2020/9/23 22:57
 */
@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private TextMapper textMapper;


    @Override
    public PageInfo<Text> findPage(Text text, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索数据
        Example example =createExample(text);
        List<Text> texts = textMapper.selectByExample(example);
        //封装PageInfo
        return new PageInfo<Text>(texts);
    }

    /**
     * 分页查询
     * @param page:当前页
     * @param size:每页显示的条数
     * @return
     */
    @Override
    public PageInfo<Text> findPage(Integer page, Integer size) {
        /**
         * PageHelper.startPage(page,size);后面的查询紧跟集合查询
         * 1：当前页
         * 2：每页显示第几条
         */
        PageHelper.startPage(page,size);
        //集合查询
        List<Text> texts = textMapper.selectAll();

        //封装PageInfo
        return new PageInfo<Text>(texts);
    }

    /**
     * 根据条件查询
     *
     * @param text
     * @return
     */
    @Override
    public List<Text> findList(Text text) {
//        //自定义条件搜索对象Example
//        Example example = new Example(Text.class);
//        Example.Criteria criteria = example.createCriteria();//条件构造器
//        if (text != null) {
//            //text.textSex!=null根据sex模糊查询where textSex like '%sex%'
//            if (!StringUtils.isEmpty(text.getTextSex())) {
//                /**
//                 * 1:text的属性名
//                 * 2:占位符,搜索的条件
//                 */
//                criteria.andLike("textSex", "%" + text.getTextSex() + "%");
//            }
//            //text.textName!=null根据textName搜索and textName=''
//            if (!StringUtils.isEmpty(text.getTextName())){
//                criteria.andEqualTo("textName",text.getTextName());
//            }
//        }
        Example example =createExample(text);
        return textMapper.selectByExample(example);
    }

    public Example createExample(Text text){
        Example example = new Example(Text.class);
        Example.Criteria criteria = example.createCriteria();//条件构造器
        if (text != null) {
            //text.textSex!=null根据sex模糊查询where textSex like '%sex%'
            if (!StringUtils.isEmpty(text.getTextSex())) {
                /**
                 * 1:text的属性名
                 * 2:占位符,搜索的条件
                 */
                criteria.andLike("textSex", "%" + text.getTextSex() + "%");
            }
            //text.textName!=null根据textName搜索and textName=''
            if (!StringUtils.isEmpty(text.getTextName())){
                criteria.andEqualTo("textName",text.getTextName());
            }
        }
        return example;
    }

    /**
     * 根据ID删除
     *
     * @param id
     */
    @Override
    public void delete(String id) {
        textMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id修改
     *
     * @param text
     */
    @Override
    public void update(Text text) {
        textMapper.updateByPrimaryKeySelective(text);
    }

    @Override
    public void add(Text text) {
        /**
         * 使用通用Mapper.insertSelective(T)实现增加
         * 方法中但凡带有Selective，会忽略空值
         *
         * 不忽略空值
         * Mapper。insert
         */
        text.setId(IdUtil.objectId());
        textMapper.insertSelective(text);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public Text findById(Integer id) {
        // 根据ID查询->通用Mapper.selectByPrimaryKey(Object) 根据主键查询
        return textMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Text> findAll() {
        // 查询所有->通用Mapper.selectAll()
        return textMapper.selectAll();
    }


}
