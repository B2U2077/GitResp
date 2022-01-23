package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.entity.StuExamInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * (StuExamInfo)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:15:59
 */
@Mapper
public interface StuExamInfoDao extends BaseMapper<StuExamInfo> {

}