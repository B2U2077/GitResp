package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.AnnounceListDTO;
import com.study.website.entity.AnnouncementList;
import com.study.website.service.AnnouncementListService;
import com.study.website.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * (AnnouncementList)表控制层
 *
 * @author Feiji
 * @since 2021-04-30 09:46:21
 */
@CrossOrigin
@RestController
@RequestMapping("/annList")
public class AnnouncementListController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AnnouncementListService announcementListService;

    /**
     * 教师服务
     */
    @Resource
    private TeacherService teacherService;

    /**
     * 分页查询所有数据
     *
     * @param page             分页对象
     * @param announcementList 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<AnnouncementList> page, AnnouncementList announcementList) {
        return success(this.announcementListService.page(page, new QueryWrapper<>(announcementList)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.announcementListService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param announcementList 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody AnnouncementList announcementList) {
        announcementList.setADate(LocalDate.now());

        return success(this.announcementListService.save(announcementList));
    }

    /**
     * 查询所有课程公告
     * @param suId  课程id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showList" , method = RequestMethod.POST)
    public ArrayList<AnnounceListDTO> showList(@RequestParam(value = "suId")Long suId) {
        ArrayList<AnnounceListDTO> dtoList = announcementListService.showList(suId);
        return dtoList;
    }

    /**
     * 修改数据
     *
     * @param announcementList 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody AnnouncementList announcementList) {
        return success(this.announcementListService.updateById(announcementList));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.announcementListService.removeByIds(idList));
    }
}