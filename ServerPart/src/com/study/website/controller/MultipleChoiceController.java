package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.entity.MultipleChoice;
import com.study.website.service.MultipleChoiceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (MultipleChoice)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
@CrossOrigin
@RestController
@RequestMapping("/multipleChoice")
public class MultipleChoiceController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MultipleChoiceService multipleChoiceService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param multipleChoice 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<MultipleChoice> page, MultipleChoice multipleChoice) {
        return success(this.multipleChoiceService.page(page, new QueryWrapper<>(multipleChoice)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.multipleChoiceService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param multipleChoice 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MultipleChoice multipleChoice) {
        return success(this.multipleChoiceService.save(multipleChoice));
    }

    /**
     * 修改数据
     *
     * @param multipleChoice 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MultipleChoice multipleChoice) {
        return success(this.multipleChoiceService.updateById(multipleChoice));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.multipleChoiceService.removeByIds(idList));
    }

    @RequestMapping(value = "/getList" ,method = RequestMethod.POST)
    public ArrayList<MultipleChoice> getList() {
        ArrayList<MultipleChoice> list = multipleChoiceService.getList();
        return list;
    }
}