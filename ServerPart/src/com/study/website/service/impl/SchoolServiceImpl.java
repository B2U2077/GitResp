package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.SchoolDao;
import com.study.website.entity.School;
import com.study.website.service.SchoolService;
import org.springframework.stereotype.Service;

/**
 * (School)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
@Service("schoolService")
public class SchoolServiceImpl extends ServiceImpl<SchoolDao, School> implements SchoolService {

}