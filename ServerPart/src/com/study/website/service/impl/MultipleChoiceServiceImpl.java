package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.MultipleChoiceDao;
import com.study.website.entity.MultipleChoice;
import com.study.website.service.MultipleChoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (MultipleChoice)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
@Service("multipleChoiceService")
public class MultipleChoiceServiceImpl extends ServiceImpl<MultipleChoiceDao, MultipleChoice> implements MultipleChoiceService {

    @Resource
    MultipleChoiceDao multipleChoiceDao;

    @Override
    public ArrayList<MultipleChoice> getList() {

        return multipleChoiceDao.getList();
    }
}