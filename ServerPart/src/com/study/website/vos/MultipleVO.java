package com.study.website.vos;

import lombok.Data;

import java.io.Serializable;

/**
 * 选择题页面VO对象
 * @author FeiJi
 * @date 2021-05-09
 */
@Data
public class MultipleVO implements Serializable {

    String qType;

    Long qExam;
}
