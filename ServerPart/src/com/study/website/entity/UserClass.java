package com.study.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (UserClass)表实体类
 *
 * @author Feiji
 * @since 2021-04-28 17:05:00
 */
@Data
@TableName(value = "User_Class")
public class UserClass extends Model<UserClass> {

    @TableId(type = IdType.AUTO)
    /**主键*/
    private Long ucId;
    /**
     * 所选课程id
     */
    private Long ucSub;
    /**
     * 学生id
     */
    private Long ucStu;
    /**
     * 教师id
     */
    private Long ucTeacher;
    /**
     * 用户类别
     */
    private String ucType;

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
        return this.ucId;
    }
}