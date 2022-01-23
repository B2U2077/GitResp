package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.dtos.MultipleDTO;
import com.study.website.entity.QuestionsList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


/**
 * (QuestionsList)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:15:59
 */
@Mapper
public interface QuestionsListDao extends BaseMapper<QuestionsList> {

    @Select("select ql.q_scores,ql.q_index,m.m_text,m.m_option1,m.m_option2,m.m_option3,m.m_option4,m.m_answer,m.m_id " +
            "from questions_list ql,multiple_choice m " +
            "where ql.q_exam = #{qExam} and ql.q_type = #{qType} and m.m_id = ql.q_multiple ORDER BY ql.q_index asc")
    ArrayList<MultipleDTO> getMultipleList(@Param("qExam") Long qExam, @Param("qType")String qType);
}