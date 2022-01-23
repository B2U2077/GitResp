package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.entity.SubjectList;
import com.study.website.entity.Teacher;
import com.study.website.entity.UserClass;
import com.study.website.service.SubjectListService;
import com.study.website.service.TeacherService;
import com.study.website.service.UserClassService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (SubjectList)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@CrossOrigin
@RestController
@RequestMapping("/subjectList")
public class SubjectListController extends ApiController {

    /**
     * 上传图片的绝对路径
     */
    @Value("${file.location}")
    String fileLocationPath;

    /**
     * 虚拟路径
     */
    @Value("${file.path}")
    String vpath;

    /**
     * 服务对象
     */
    @Resource
    private SubjectListService subjectListService;

    /**
     * 教师服务
     */
    @Resource
    private TeacherService teacherService;

    @Resource
    private UserClassService userClassService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param subjectList 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SubjectList> page, SubjectList subjectList) {
        return success(this.subjectListService.page(page, new QueryWrapper<>(subjectList)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.subjectListService.getById(id));
    }

    /**
     * 新增数据
     *
     * @return 新增结果
     */
    @PostMapping
    public Map<String,Object> insert(@RequestParam(value = "suName") String suName, @RequestParam(value = "tAcc") String account, @RequestParam(value = "tPwd") String pwd, @RequestParam(value = "suInfo") String suInfo, @RequestParam(value = "file")MultipartFile file) throws IOException {
        SubjectList subjectList = new SubjectList();
        subjectList.setSuName(suName);
        subjectList.setSuInfo(suInfo);
        subjectList.setSuStatus("1");
        //调用教师服务根据教师姓名查询教师
        Teacher teacher = teacherService.findTeacherByAccount(account,pwd);
        subjectList.setSuTeacher(teacher.getTId());
        subjectList.setSuSchool(teacher.getTSchool());
        //处理图片路径
        if(file != null) {
            System.out.println("上传路径："+fileLocationPath);
            String fileName = UUID.randomUUID().toString().replaceAll("-","") + file.getOriginalFilename();
            //上传文件类型
            System.out.println("文件类型："+file.getContentType());
            //创建一个文件对象，把存放文件的路径和文件名放进去
            File filePath = new File(fileLocationPath,fileName);
            //若路径不存在就创建一个路径
            if(!filePath.exists()) {
                filePath.mkdirs();
            }
            //将上传文件保存在一个目标文件中
            file.transferTo(new File(fileLocationPath + fileName));
            subjectList.setVdef10(vpath+fileName);
        }
        success(this.subjectListService.save(subjectList));
        Map<String,Object> map = new HashMap<>();
        map.put("filePath",subjectList.getVdef10());
        //给用户课程关系表插入数据
        UserClass userClass = new UserClass();
        userClass.setUcTeacher(teacher.getTId());
        userClass.setUcType("教师");
        userClass.setUcSub(subjectList.getSuId());
        this.userClassService.save(userClass);
        return map;
    }

    /**
     * 修改数据
     *
     * @param subjectList 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SubjectList subjectList) {
        return success(this.subjectListService.updateById(subjectList));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.subjectListService.removeByIds(idList));
    }
}