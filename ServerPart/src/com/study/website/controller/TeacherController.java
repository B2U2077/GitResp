package com.study.website.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.TeacherPageDTO;
import com.study.website.entity.Teacher;
import com.study.website.service.TeacherService;
import com.study.website.vos.TeacherPageVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * (Teacher)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    /**
     * 分页查询所有数据
     *
     * @param voPage  分页对象
     * @return 所有数据
     */
    @RequestMapping(value = "/teachervo",method = RequestMethod.POST)
    public Page selectAll(@RequestBody TeacherPageVO voPage) {
        Page<TeacherPageDTO> page = teacherService.selectAll(voPage);
        return page;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.teacherService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param teacher 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Teacher teacher) {
        System.out.println(teacher);
        teacher.setTStatus("1");
        return success(this.teacherService.save(teacher));
    }

    /**
     * 修改数据
     *
     * @param teacher 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Teacher teacher) {
        return success(this.teacherService.updateById(teacher));
    }

    /**
     * 删除数据
     *
     * @param tid 主键
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("tid") Long tid) {
        return success(this.teacherService.removeById((Serializable) tid));
    }
}