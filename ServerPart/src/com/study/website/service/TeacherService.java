package com.study.website.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.dtos.TeacherPageDTO;
import com.study.website.entity.Teacher;
import com.study.website.vos.TeacherPageVO;

/**
 * (Teacher)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
public interface TeacherService extends IService<Teacher> {

    Page<TeacherPageDTO> selectAll(TeacherPageVO vo);

    Teacher findTeacherByAccount(String account,String password);
}