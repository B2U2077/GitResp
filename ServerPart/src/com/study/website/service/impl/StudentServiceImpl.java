package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.StudentDao;
import com.study.website.dtos.StudentPageDTO;
import com.study.website.entity.Student;
import com.study.website.service.StudentService;
import com.study.website.vos.StudentPageVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Student)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

    @Resource
    StudentDao studentDao;

    @Override
    public Student findStuByAccount(String account, String pwd) {
        Student student = studentDao.findStuByAccount(account,pwd);
        return student;
    }

    @Override
    public Page<StudentPageDTO> selectAll(StudentPageVO vo) {
        String scName = vo.getDto().getScName();
        String stuName= vo.getDto().getStuName();
        return studentDao.selectAll(vo.getPage(),scName,stuName);
    }
}