package com.study.website.dtos;

import lombok.Data;

/**
 * @author FeiJi
 * @date 2021-04-28
 */
@Data
public class ClassListDTO {

    /**
     * 图片的绝对路径
     */
    String vdef10;

    /**
     *  课程编号
     */
    Long suId;

    /**
     * 课程名称
     */
    String suName;

    /**
     * 学校名称
     */
    String scName;
}
