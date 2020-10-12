package com.base.service;

import com.github.pagehelper.PageInfo;
import com.zyc.base.pojo.Text;

import java.util.List;

/**
 * @Author ZengYc
 * @Date 2020/9/23 22:58
 */
public interface TextService {

    /**
     * 分页+条件搜索
     * @param page:当前页
     * @param size:每页显示的条数
     */
    PageInfo<Text> findPage(Text text,Integer page,Integer size);

    /**
     * 条件搜索
     * @param page:当前页
     * @param size:每页显示的条数
     */
    PageInfo<Text> findPage(Integer page,Integer size);

    /**
     * 条件查询
     */
    List<Text> findList(Text text);

    /**
     * 根据ID删除
     */
    void delete(String id);

    /**
     * 修改数据
     */
    void update(Text text);

    /**
     * 增加品牌
     */
    void add(Text text);

    /**
     * 根据ID查询
     */
    Text findById(Integer id);


    /**
     * 查询所有
     */
    List<Text> findAll();
}
