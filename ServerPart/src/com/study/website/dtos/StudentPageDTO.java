package com.study.website.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author FeiJi
 * @date 2021-04-19
 */
@Data
@NoArgsConstructor
public class StudentPageDTO implements Serializable {

    @ApiModelProperty(value = "学生id")
    private Long stuId;

    @ApiModelProperty(value = "学生姓名")
    private String stuName;

    @ApiModelProperty(value = "学生性别")
    private String stuGender;

    @ApiModelProperty(value = "学校名称")
    private String scName;

    @ApiModelProperty(value = "所属专业")
    private String stuMajor;

    @ApiModelProperty(value = "所在班级")
    private String stuClass;

    @ApiModelProperty(value = "所在年级")
    private String stuGrade;
}
