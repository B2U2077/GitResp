package com.study.website.vos;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.TeacherPageDTO;
import lombok.Data;

/**
 * @author FeiJi
 * @date 2021-04-18
 */
@Data
public class TeacherPageVO {
    Page<TeacherPageDTO> page;

    TeacherPageDTO dto;
}
