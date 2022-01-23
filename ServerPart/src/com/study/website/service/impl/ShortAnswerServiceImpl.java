package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.ShortAnswerDao;
import com.study.website.dtos.ShortDTO;
import com.study.website.entity.ShortAnswer;
import com.study.website.service.ShortAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (ShortAnswer)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
@Service("shortAnswerService")
public class ShortAnswerServiceImpl extends ServiceImpl<ShortAnswerDao, ShortAnswer> implements ShortAnswerService {

    @Resource
    ShortAnswerDao shortAnswerDao;

    @Override
    public ArrayList<ShortAnswer> getList() {
        return shortAnswerDao.getList();
    }

    @Override
    public ArrayList<ShortDTO> getShortList(Long qExam, String qType) {

        return shortAnswerDao.getShortList(qType,qExam);
    }
}