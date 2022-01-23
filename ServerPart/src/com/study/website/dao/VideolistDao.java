package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.entity.Videolist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * (Videolist)表数据库访问层
 *
 * @author Feiji
 * @since 2021-04-28 10:05:53
 */
@Mapper
public interface VideolistDao extends BaseMapper<Videolist> {

    @Select("select * from videolist where v_sub = #{suId}")
    ArrayList<Videolist> getVideoList(@Param("suId")Long suId);
}