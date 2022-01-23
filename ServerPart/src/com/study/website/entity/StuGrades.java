package com.study.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (StuGrades)表实体类
 *
 * @author Feiji
 * @since 2021-03-30 19:15:49
 */
@Data
@TableName(value = "Stu_Grades")
public class StuGrades extends Model<StuGrades> {

    @TableId(type = IdType.AUTO)

    private Long sgId;

    private Long stuId;

    private Long suId;

    private Long tId;

    private Long eId;

    private Double sgScores;

    private String vdef1;

    private String vdef2;

    private String vdef3;

    private String vdef4;

    private String vdef5;

    private String vdef6;

    private String vdef7;

    private String vdef8;

    private String vdef9;

    private String vdef10;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.sgId;
    }

}