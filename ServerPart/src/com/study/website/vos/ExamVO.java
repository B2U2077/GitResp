package com.study.website.vos;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.entity.Exam;
import lombok.Data;

/**
 * @author FeiJi
 * @date 2021-05-04
 */
@Data
public class ExamVO {

    //分页对象
    Page<Exam> page;

    //考试对象
    Exam exam;
}
