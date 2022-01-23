package com.study.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (QuestionsList)表实体类
 *
 * @author Feiji
 * @since 2021-03-30 19:15:59
 */
@Data
@TableName(value = "Questions_List")
public class QuestionsList extends Model<QuestionsList> {

    @TableId(type = IdType.AUTO)

    private Long qId;

    private Integer qIndex;

    private Double qScores;

    private String qType;

    private Long qMultiple;

    private Long qShort;

    private Long qExam;

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
        return this.qId;
    }
}