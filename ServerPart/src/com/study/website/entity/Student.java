package com.study.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Student)表实体类
 *
 * @author Feiji
 * @since 2021-03-30 16:46:34
 */
@Data
@TableName(value = "Student")
public class Student extends Model<Student> {
    @TableId(type = IdType.AUTO)

    private Long stuId;

    private String stuGender;

    private String stuPwd;

    private String stuName;

    private Long stuSchool;

    private String stuMajor;

    private String stuGrade;

    private String stuClass;

    @TableLogic(value="1",delval = "0")
    private String stuStatus;

    //表示学生账号
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
        return this.stuId;
    }
}