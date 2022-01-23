package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.entity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * (Exam)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:15:58
 */
@Mapper
public interface ExamDao extends BaseMapper<Exam> {

    @Select("select e_id from exam where e_subject = #{suId}")
    Long getExamId(@Param("suId") Long suId);
}