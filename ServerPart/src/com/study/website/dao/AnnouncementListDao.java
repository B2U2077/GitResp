package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.dtos.AnnounceListDTO;
import com.study.website.entity.AnnouncementList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * (AnnouncementList)表数据库访问层
 *
 * @author Feiji
 * @since 2021-04-30 09:46:21
 */
@Mapper
public interface AnnouncementListDao extends BaseMapper<AnnouncementList> {

    @Select("select anl.a_announcement,anl.a_date,t.t_name from announcement_list anl,teacher t where a_subject = #{suId} and anl.a_teacher = t.t_id")
    ArrayList<AnnounceListDTO> showList(@Param("suId") Long suId);
}