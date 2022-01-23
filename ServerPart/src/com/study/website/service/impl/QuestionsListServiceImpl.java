package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.QuestionsListDao;
import com.study.website.dtos.MultipleDTO;
import com.study.website.entity.QuestionsList;
import com.study.website.service.QuestionsListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (QuestionsList)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
@Service("questionsListService")
public class QuestionsListServiceImpl extends ServiceImpl<QuestionsListDao, QuestionsList> implements QuestionsListService {

    @Resource
    QuestionsListDao questionsListDao;

    @Override
    public ArrayList<MultipleDTO> getMultipleList(Long qExam, String qType) {

        return questionsListDao.getMultipleList(qExam,qType);
    }
}