package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.website.dtos.ClassListDTO;
import com.study.website.entity.UserClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * (UserClass)表数据库访问层
 *
 * @author Feiji
 * @since 2021-04-28 17:05:00
 */
@Mapper
public interface UserClassDao extends BaseMapper<UserClass> {

    @Select({
            "<script>" +
                    "select su.vdef10,su.su_id,su.su_name,sc.sc_name from subject_list su,school sc where su.su_id in (" +
                    "select uc_sub from user_class where uc_type = #{role} " +
                    "<if test='role == &apos;教师&apos;'> and uc_teacher = #{id}</if>" +
                    "<if test='role == &apos;学生&apos;'> and uc_stu = #{id}</if>)" +
                    " and sc.sc_id = su.su_school" +
                    "</script>"
    })
    ArrayList<ClassListDTO> showUserClassList(@Param("role")String role, @Param("id")Long id);

    @Select("select su.vdef10,su.su_id,su.su_name,sc.sc_name from subject_list su,school sc where sc.sc_id = su.su_school")
    ArrayList<ClassListDTO> getAllList();

    @Select("<script>" +
            "select * from user_class where " +
            "uc_sub = #{suId} and " +
            " uc_type = #{role} " +
            "<if test='role == &apos;教师&apos;'> and uc_teacher = #{id}</if>" +
            "<if test='role == &apos;学生&apos;'> and uc_stu = #{id}</if>" +
            "</script>")
    UserClass getOne(@Param("role") String role,@Param("id") Long id,@Param("suId") Long suId);
}