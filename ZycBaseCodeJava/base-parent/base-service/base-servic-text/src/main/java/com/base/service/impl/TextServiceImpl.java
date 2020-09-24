package com.base.service.impl;

import com.base.mapper.TextMapper;
import com.base.service.TextService;
import com.zyc.base.pojo.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZengYc
 * @Date 2020/9/23 22:57
 */
@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private TextMapper textMapper;

    /**
     * 根据ID查询
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
