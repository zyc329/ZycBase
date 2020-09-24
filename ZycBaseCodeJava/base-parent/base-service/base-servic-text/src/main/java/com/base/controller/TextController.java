package com.base.controller;

import com.base.service.TextService;
import com.zyc.base.pojo.Text;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ZengYc
 * @Date 2020/9/23 22:59
 */
@RestController
@RequestMapping(value = "/text")
/**
 * 跨域
 */
@CrossOrigin
public class TextController {

    @Autowired
    private TextService textService;

    /**
     * 根据主键ID查询
     */
    @GetMapping(value = "/{id}")
    public Result<Text> findById(@PathVariable(value = "id") Integer id) {
        // 调用Service实现查询
        Text text = textService.findById(id);
        return new Result<Text>(true, StatusCode.OK, "查询成功", text);
    }

    /**
     * 查询所有
     */
    @GetMapping
    public Result<List<Text>> findAll() {
        List<Text> texts = textService.findAll();
        return new Result<List<Text>>(true, StatusCode.OK, "查询成功", texts);
    }

    /**
     * 查询所有
     */
    @GetMapping
    @RequestMapping("/text123")
    public Result<List<Text>> findAll1() {
        List<Text> texts = textService.findAll();
        return new Result<List<Text>>(true, StatusCode.OK, "查询成功", texts);
    }

    /**
     * 根据主键ID查询
     */
    @GetMapping(value = "/text234/{id}")
    public Result<Text> findById1(@PathVariable(value = "id") Integer id) {
        // 调用Service实现查询
        Text text = textService.findById(id);
        return new Result<Text>(true, StatusCode.OK, "查询成功", text);
    }
}
