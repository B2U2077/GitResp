package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.TeacherPageDTO;
import com.study.website.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * (Teacher)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:15:58
 */
@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {

    @Select({
            "<script>" +
                    "select t.t_id,t.t_name,t.t_gender,s.sc_name,t.t_info " +
                    "from teacher t left join school s on t.t_school = s.sc_id " +
                    "where 1=1 " +
                    "<if test='scName != null'> and s.sc_name = #{scName}</if>" +
                    "<if test='tName != null'> and t.t_name = #{tName}</if>" +
                    "</script>"
    })
    Page<TeacherPageDTO> selectAll(Page page, @Param("scName") String scName,@Param("tName") String tName);

    @Select("select * from teacher t where t.vdef1 = #{account} and t.t_pwd = #{pwd}")
    Teacher findTeacherByAccount(@Param("account") String account,@Param("pwd") String password);
}