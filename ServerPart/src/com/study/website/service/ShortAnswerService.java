package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.dtos.ShortDTO;
import com.study.website.entity.ShortAnswer;

import java.util.ArrayList;

/**
 * (ShortAnswer)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
public interface ShortAnswerService extends IService<ShortAnswer> {

    ArrayList<ShortAnswer> getList();

    ArrayList<ShortDTO> getShortList(Long qExam,String qType);
}