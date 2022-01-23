package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.ShortDTO;
import com.study.website.entity.ShortAnswer;
import com.study.website.service.ShortAnswerService;
import com.study.website.vos.ShortVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (ShortAnswer)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
@CrossOrigin
@RestController
@RequestMapping("/shortAnswer")
public class ShortAnswerController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ShortAnswerService shortAnswerService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param shortAnswer 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ShortAnswer> page, ShortAnswer shortAnswer) {
        return success(this.shortAnswerService.page(page, new QueryWrapper<>(shortAnswer)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.shortAnswerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param shortAnswer 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ShortAnswer shortAnswer) {
        return success(this.shortAnswerService.save(shortAnswer));
    }

    /**
     * 修改数据
     *
     * @param shortAnswer 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ShortAnswer shortAnswer) {
        return success(this.shortAnswerService.updateById(shortAnswer));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.shortAnswerService.removeByIds(idList));
    }

    @RequestMapping(value = "/getList" ,method = RequestMethod.POST)
    public ArrayList<ShortAnswer> getList() {
        ArrayList<ShortAnswer> list = shortAnswerService.getList();
        return list;
    }

    @RequestMapping(value = "/getShortList",method = RequestMethod.POST)
    public ArrayList<ShortDTO> getShortList(@RequestBody ShortVO vo) {
        ArrayList<ShortDTO> list = shortAnswerService.getShortList(vo.getQExam(),vo.getQType());
        return list;
    }
}