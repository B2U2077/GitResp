package com.study.website.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.dtos.StuGradesDTO;
import com.study.website.entity.StuGrades;
import com.study.website.vos.StuGradesVO;

/**
 * (StuGrades)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
public interface StuGradesService extends IService<StuGrades> {

    Page<StuGradesDTO> getAllList(StuGradesVO vo);
}