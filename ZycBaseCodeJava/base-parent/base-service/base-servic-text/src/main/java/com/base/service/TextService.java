package com.base.service;

import com.zyc.base.pojo.Text;

import java.util.List;

/**
 * @Author ZengYc
 * @Date 2020/9/23 22:58
 */
public interface TextService {

    /**
     * 根据ID查询
     */
    Text findById(Integer id);


    /**
     * 查询所有
     */
    List<Text> findAll();
}
