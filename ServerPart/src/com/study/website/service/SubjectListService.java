package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.entity.SubjectList;

/**
 * (SubjectList)表服务接口
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
public interface SubjectListService extends IService<SubjectList> {

    Long getTIdBySuId(Long suId);
}