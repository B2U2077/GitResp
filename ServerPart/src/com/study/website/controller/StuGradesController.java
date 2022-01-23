package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.StuGradesDTO;
import com.study.website.entity.StuGrades;
import com.study.website.service.StuGradesService;
import com.study.website.vos.StuGradesVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (StuGrades)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@RestController
@RequestMapping("/stuGrades")
public class StuGradesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private StuGradesService stuGradesService;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param stuGrades 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<StuGrades> page, StuGrades stuGrades) {
        return success(this.stuGradesService.page(page, new QueryWrapper<>(stuGrades)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.stuGradesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param stuGrades 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody StuGrades stuGrades) {
        return success(this.stuGradesService.save(stuGrades));
    }

    /**
     * 修改数据
     *
     * @param stuGrades 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody StuGrades stuGrades) {
        return success(this.stuGradesService.updateById(stuGrades));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.stuGradesService.removeByIds(idList));
    }


    /**
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/getAllList" ,method = RequestMethod.POST)
    public Page<StuGradesDTO> getAllList(@RequestBody StuGradesVO vo) {
        Page page = stuGradesService.getAllList(vo);
        return page;
    }
}