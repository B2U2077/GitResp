package com.study.website.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.dtos.StudentPageDTO;
import com.study.website.entity.Student;
import com.study.website.vos.StudentPageVO;

/**
 * (Student)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
public interface StudentService extends IService<Student> {
    /**
     * 通过账号密码查询学生
     * @param account
     * @return
     */
    Student findStuByAccount(String account,String pwd);

    /**
     * 通过试图分页对象 分页查询学生信息
     * @param vo
     * @return
     */
    Page<StudentPageDTO> selectAll(StudentPageVO vo);
}