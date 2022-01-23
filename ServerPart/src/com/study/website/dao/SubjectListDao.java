package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.entity.SubjectList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * (SubjectList)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:15:59
 */
@Mapper
public interface SubjectListDao extends BaseMapper<SubjectList> {

    @Select("select su_teacher from subject_list where su_id = #{suId}")
    Long getTidBySuId(@Param("suId") Long suId);
}