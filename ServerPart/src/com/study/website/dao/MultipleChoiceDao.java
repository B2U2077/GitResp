package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.entity.MultipleChoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * (MultipleChoice)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:15:49
 */
@Mapper
public interface MultipleChoiceDao extends BaseMapper<MultipleChoice> {

    @Select("select * from multiple_choice")
    ArrayList<MultipleChoice> getList();
}