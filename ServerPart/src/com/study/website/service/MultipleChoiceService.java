package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.entity.MultipleChoice;

import java.util.ArrayList;

/**
 * (MultipleChoice)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
public interface MultipleChoiceService extends IService<MultipleChoice> {

    ArrayList<MultipleChoice> getList();
}