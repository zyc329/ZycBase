package com.base.controller;

import com.base.service.TextService;
import com.github.pagehelper.PageInfo;
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
     * 条件+分页查询实现
     */
    @PostMapping("/findPage/{page}/{size}")
    public Result<PageInfo<Text>> findPage(@RequestBody Text text,
                                           @PathVariable(value = "page")Integer page,
                                           @PathVariable(value = "size")Integer size){
        PageInfo<Text> pageInfo =textService.findPage(text,page, size);
        return new Result<PageInfo<Text>>(true, StatusCode.OK, "条件+分页查询成功",pageInfo);
    }

    /**
     * 分页查询实现
     */
    @GetMapping("/findPage/{page}/{size}")
    public Result<PageInfo<Text>> findPage(@PathVariable(value = "page")Integer page,
                                   @PathVariable(value = "size")Integer size){
        PageInfo<Text> pageInfo =textService.findPage(page, size);
        return new Result<PageInfo<Text>>(true, StatusCode.OK, "分页查询成功",pageInfo);
    }

    /**
     * 条件查询
     */
    @PostMapping("textFindList")
    public Result<List<Text>> findList(@RequestBody Text text) {
        List<Text> texts = textService.findList(text);
        return new Result<List<Text>>(true, StatusCode.OK, "条件查询成功", texts);
    }

    /**
     * 根绝ID删除实现
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") String id) {
        textService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功！");
    }

    @PostMapping("textDelete")
    public Result delete2(@RequestBody Text text) {
        textService.delete(text.getId());
        return new Result(true, StatusCode.OK, "删除成功！");
    }

    /**
     * 修改text用户
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id") String id, @RequestBody Text text) {
        text.setId(id);
        textService.update(text);
        return new Result(true, StatusCode.OK, "修改成功！");
    }

    /**
     * 修改text用户2
     */
    @PostMapping("textUpdate")
    public Result update2(@RequestBody Text text) {
        textService.update(text);
        return new Result(true, StatusCode.OK, "修改成功！");
    }

    /**
     * 增加text用户
     */
    @PostMapping("textAdd")
    public Result add(@RequestBody Text text) {
        textService.add(text);
        return new Result(true, StatusCode.OK, "新增成功！");
    }

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
