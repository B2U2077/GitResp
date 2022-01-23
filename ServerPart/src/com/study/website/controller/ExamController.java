package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.entity.Exam;
import com.study.website.service.ExamService;
import com.study.website.vos.ExamVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Exam)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:26:48
 */
@CrossOrigin
@RestController
@RequestMapping("/exam")
public class ExamController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ExamService examService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @RequestMapping(value = "/showList",method = RequestMethod.POST)
    public R selectAll(@RequestBody ExamVO vo) {
        Page<Exam> page = vo.getPage();
        Exam exam = vo.getExam();
        return success(this.examService.page(page, new QueryWrapper<>(exam)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.examService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param exam 实体对象
     * @return 新增结果
     */
    @ResponseBody
    @PostMapping
    public Map<String,Object> insert(@RequestBody Exam exam) {
        success(this.examService.save(exam));
        Map<String,Object> map = new HashMap<>();
        map.put("eId",exam.getEId());
        return map;
    }

    /**
     * 修改数据
     *
     * @param exam 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Exam exam) {
        return success(this.examService.updateById(exam));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.examService.removeByIds(idList));
    }

    @RequestMapping(value = "/getExamId",method = RequestMethod.POST)
    public Long getExamId(@RequestParam("suId") Long suId) {
        return examService.getExamId(suId);
    }
}