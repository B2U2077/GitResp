package com.study.website.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.StudentPageDTO;
import com.study.website.entity.Student;
import com.study.website.service.StudentService;
import com.study.website.vos.StudentPageVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Student)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询所有数据
     *
     * @param vo  学生分页视图对象
     * @return 所有数据
     */
    @RequestMapping(value = "/stuvo",method = RequestMethod.POST)
    public Page<StudentPageDTO> selectAll(@RequestBody StudentPageVO vo) {
        Page page = studentService.selectAll(vo);
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
        return success(this.studentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param student 实体对象
     * @return 新增结果
     */
    @PostMapping
    public void insert(@RequestBody Student student) {
        System.out.println(student);
        student.setStuStatus("1");
        success(this.studentService.save(student));
    }

    /**
     * 修改数据
     *
     * @param student 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Student student) {
        return success(this.studentService.updateById(student));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.studentService.removeByIds(idList));
    }
}