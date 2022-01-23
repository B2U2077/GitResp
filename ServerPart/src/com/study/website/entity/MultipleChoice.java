package com.study.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (MultipleChoice)表实体类
 *
 * @author Feiji
 * @since 2021-03-30 19:15:49
 */
@Data
@TableName(value = "Multiple_Choice")
public class MultipleChoice extends Model<MultipleChoice> {

    @TableId(type = IdType.AUTO)

    private Long mId;

    private String mText;

    private String mOption1;

    private String mOption2;

    private String mOption3;

    private String mOption4;

    private String mAnswer;

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
        return this.mId;
    }
}