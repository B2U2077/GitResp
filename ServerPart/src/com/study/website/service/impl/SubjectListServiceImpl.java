package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.SubjectListDao;
import com.study.website.entity.SubjectList;
import com.study.website.service.SubjectListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SubjectList)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@Service("subjectListService")
public class SubjectListServiceImpl extends ServiceImpl<SubjectListDao, SubjectList> implements SubjectListService {

    @Resource
    SubjectListDao subjectListDao;

    @Override
    public Long getTIdBySuId(Long suId) {
        return subjectListDao.getTidBySuId(suId);
    }
}