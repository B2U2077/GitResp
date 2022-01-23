package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.entity.Exam;

/**
 * (Exam)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:26:48
 */
public interface ExamService extends IService<Exam> {

    Long getExamId(Long suId);
}