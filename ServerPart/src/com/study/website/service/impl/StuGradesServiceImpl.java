package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.StuGradesDao;
import com.study.website.dtos.StuGradesDTO;
import com.study.website.entity.StuGrades;
import com.study.website.service.StuGradesService;
import com.study.website.vos.StuGradesVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (StuGrades)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@Service("stuGradesService")
public class StuGradesServiceImpl extends ServiceImpl<StuGradesDao, StuGrades> implements StuGradesService {

    @Resource
    StuGradesDao stuGradesDao;

    @Override
    public Page<StuGradesDTO> getAllList(StuGradesVO vo) {
        Long suId = vo.getSuId();
        return stuGradesDao.getAllList(vo.getPage(),suId);
    }
}