package com.study.website.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * @author FeiJi
 * @date 2021-05-10
 */
@Data
public class StuGradesDTO implements Serializable {
    /**
     * 学生姓名
     */
    String stuName;

    /**
     * 课程名称
     */
    String suName;

    /**
     * 教师姓名
     */
    String tName;

    /**
     * 考试名称
     */
    String eName;

    /**
     * 考试分数
     */
    Double sgScores;
}
