package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.entity.School;
import org.apache.ibatis.annotations.Mapper;

/**
 * (School)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:07:58
 */
@Mapper
public interface SchoolDao extends BaseMapper<School> {

}