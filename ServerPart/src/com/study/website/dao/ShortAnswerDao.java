package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.dtos.ShortDTO;
import com.study.website.entity.ShortAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


/**
 * (ShortAnswer)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:15:59
 */
@Mapper
public interface ShortAnswerDao extends BaseMapper<ShortAnswer> {

    @Select("select * from short_answer")
    ArrayList<ShortAnswer> getList();

    @Select("select ql.q_scores,ql.q_index,sh.sh_text,sh.sh_answer,sh.sh_id " +
            "from questions_list ql,short_answer sh " +
            "where ql.q_exam = #{qExam} and ql.q_type = #{qType} and sh.sh_id = ql.q_short ORDER BY ql.q_index asc")
    ArrayList<ShortDTO> getShortList(@Param("qType") String qType,@Param("qExam") Long qExam);
}