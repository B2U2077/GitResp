package com.study.website.vos;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.StudentPageDTO;
import lombok.Data;

/**
 * @author FeiJi
 * @date 2021-04-19
 */
@Data
public class StudentPageVO {

    StudentPageDTO dto;

    Page<StudentPageDTO> page;
}
