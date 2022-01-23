package com.study.website.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * 简答题数据传输对象
 * @author FeiJi
 * @date 2021-05-09
 */
@Data
public class MultipleDTO implements Serializable  {

    private Double qScores;

    private int qIndex;

    private String mText;

    private String mOption1;

    private String mOption2;

    private String mOption3;

    private String mOption4;

    private String mAnswer;

    private Long mId;

    private String choice;
}
