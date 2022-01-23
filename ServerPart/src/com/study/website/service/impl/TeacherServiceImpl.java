package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.TeacherDao;
import com.study.website.dtos.TeacherPageDTO;
import com.study.website.entity.Teacher;
import com.study.website.service.TeacherService;
import com.study.website.vos.TeacherPageVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Teacher)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {

    @Resource
    TeacherDao teacherDao;

    @Override
    public Page<TeacherPageDTO> selectAll(TeacherPageVO vo) {
        String scName = vo.getDto().getScName();
        String tName = vo.getDto().getTName();
        return teacherDao.selectAll(vo.getPage(),scName,tName);
    }

    @Override
    public Teacher findTeacherByAccount(String account, String password) {
        return teacherDao.findTeacherByAccount(account,password);
    }
}