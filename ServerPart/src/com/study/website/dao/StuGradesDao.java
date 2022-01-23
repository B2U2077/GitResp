package com.study.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.StuGradesDTO;
import com.study.website.entity.StuGrades;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * (StuGrades)表数据库访问层
 *
 * @author Feiji
 * @since 2021-03-30 19:15:49
 */
@Mapper
public interface StuGradesDao extends BaseMapper<StuGrades> {

    @Select("select stu.stu_name,sl.su_name,t.t_name,e.e_name,sg.sg_scores from student stu,subject_list sl,teacher t,exam e,stu_grades sg\n" +
            "where sg.stu_id = stu.stu_id and sg.su_id = sl.su_id and sg.t_id = t.t_id and e.e_id = sg.e_id and sl.su_id = #{suId}")
    Page<StuGradesDTO> getAllList(Page page, @Param("suId") Long suId);
}