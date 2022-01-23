package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.MultipleDTO;
import com.study.website.entity.QuestionsList;
import com.study.website.service.QuestionsListService;
import com.study.website.vos.MultipleVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (QuestionsList)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
@RestController
@RequestMapping("/questionsList")
public class QuestionsListController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionsListService questionsListService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param questionsList 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<QuestionsList> page, QuestionsList questionsList) {
        return success(this.questionsListService.page(page, new QueryWrapper<>(questionsList)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.questionsListService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param questionsList 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody QuestionsList questionsList) {
        return success(this.questionsListService.save(questionsList));
    }

    /**
     * 修改数据
     *
     * @param questionsList 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody QuestionsList questionsList) {
        return success(this.questionsListService.updateById(questionsList));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.questionsListService.removeByIds(idList));
    }

    @ResponseBody
    @RequestMapping(value = "/getMultipleList" ,method = RequestMethod.POST)
    public ArrayList<MultipleDTO> getMultipleList(@RequestBody MultipleVO vo) {
        Long qExam = vo.getQExam();
        String qType = vo.getQType();
        ArrayList<MultipleDTO> dtoList = questionsListService.getMultipleList(qExam,qType);
        return dtoList;
    }
}