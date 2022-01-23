package com.study.website.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author FeiJi
 * @date 2021-04-18
 */
@Data
@NoArgsConstructor
public class TeacherPageDTO implements Serializable {

    @ApiModelProperty(value = "教师id")
    private Long tId;

    @ApiModelProperty(value = "教师姓名")
    private String tName;

    @ApiModelProperty(value = "教师性别")
    private String tGender;

    @ApiModelProperty(value = "教师简介")
    private String tInfo;

    @ApiModelProperty(value = "所属学校")
    private String scName;
}
