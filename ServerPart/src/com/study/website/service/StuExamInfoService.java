package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.entity.StuExamInfo;

import java.util.ArrayList;

/**
 * (StuExamInfo)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
public interface StuExamInfoService extends IService<StuExamInfo> {

    void setStuExam(ArrayList<Object> multipleDTOMap,ArrayList<Object> shortDTOMap,Long examId,Long suId,Long stuId);
}