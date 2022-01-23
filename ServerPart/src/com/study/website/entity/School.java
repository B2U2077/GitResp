package com.study.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (School)表实体类
 *
 * @author Feiji
 * @since 2021-04-17 15:11:33
 */
@Data
@TableName(value = "School")
public class School extends Model<School> {

    @TableId(type = IdType.AUTO)

    private Long scId;

    private String scName;

    @TableLogic(value="1",delval = "0")
    private String scStatus;

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
     * 学校简介
     */
    private String scInfo;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.scId;
    }
}