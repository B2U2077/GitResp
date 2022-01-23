package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.dtos.MultipleDTO;
import com.study.website.entity.QuestionsList;

import java.util.ArrayList;

/**
 * (QuestionsList)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
public interface QuestionsListService extends IService<QuestionsList> {

    ArrayList<MultipleDTO> getMultipleList(Long qExam,String qType);
}