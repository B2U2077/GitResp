package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.ExamDao;
import com.study.website.entity.Exam;
import com.study.website.service.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Exam)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:26:48
 */
@Service("examService")
public class ExamServiceImpl extends ServiceImpl<ExamDao, Exam> implements ExamService {

    @Resource
    ExamDao examDao;

    @Override
    public Long getExamId(Long suId) {
        return examDao.getExamId(suId);
    }
}