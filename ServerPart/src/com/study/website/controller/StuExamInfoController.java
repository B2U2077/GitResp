package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.entity.StuExamInfo;
import com.study.website.service.StuExamInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (StuExamInfo)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@RestController
@RequestMapping("/stuExamInfo")
public class StuExamInfoController extends ApiController {

    /**
     * 服务对象
     */
    @Resource
    private StuExamInfoService stuExamInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param stuExamInfo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<StuExamInfo> page, StuExamInfo stuExamInfo) {
        return success(this.stuExamInfoService.page(page, new QueryWrapper<>(stuExamInfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.stuExamInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        ArrayList<Object> multipleDTOMap = (ArrayList<Object>)map.get("multipleDTOMap");
        ArrayList<Object> shortDTOMap = (ArrayList<Object>)map.get("shortDTOMap");
        Long examId = Long.valueOf((Integer)map.get("examId"));
        Long suId = Long.valueOf(Integer.valueOf((String)map.get("suId")));
        Long stuId = Long.valueOf(Integer.valueOf((String)map.get("id")));
        stuExamInfoService.setStuExam(multipleDTOMap,shortDTOMap,examId,suId,stuId);
        return null;
    }

    /**
     * 修改数据
     *
     * @param stuExamInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody StuExamInfo stuExamInfo) {
        return success(this.stuExamInfoService.updateById(stuExamInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.stuExamInfoService.removeByIds(idList));
    }
}