package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.StudentPageDTO;
import com.study.website.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * (Student)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 15:55:38
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {

    @Select("select * from student where vdef1 = #{account} and stu_pwd = #{pwd}")
    Student findStuByAccount(@Param("account") String account,@Param("pwd") String pwd);

    @Select({"<script>" +
            "select s.stu_id,s.stu_name,s.stu_major,s.stu_grade,s.stu_class,sc.sc_name,s.stu_gender " +
            "from student s left join school sc on s.stu_school = sc.sc_id " +
            "where 1=1 " +
            "<if test='stuName != null'> and s.stu_name = #{stuName} </if> " +
            "<if test='scName != null'> and sc.scName = #{scName}</if>" +
            "</script>"})
    Page<StudentPageDTO> selectAll(Page page,@Param("scName") String scName,@Param("stuName") String stuName);
}